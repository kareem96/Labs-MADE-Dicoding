package com.kareemdev.tmdbapp.core.di

import androidx.room.Room
import com.kareemdev.tmdbapp.core.data.MovieRepository
import com.kareemdev.tmdbapp.core.data.source.local.LocalDataSource
import com.kareemdev.tmdbapp.core.data.source.local.room.MovieDatabase
import com.kareemdev.tmdbapp.core.data.source.remote.RemoteDataSource
import com.kareemdev.tmdbapp.core.data.source.remote.network.ApiService
import com.kareemdev.tmdbapp.core.domain.repository.IMovieRepository
import com.kareemdev.tmdbapp.core.utils.AppExecutors
import com.kareemdev.tmdbapp.core.utils.Constant.API_KEY
import com.kareemdev.tmdbapp.core.utils.Constant.BASE_URL
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
   /* single {
        val hostname = "api.themoviedb.org"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/+vqZVAzTqUP8BGkfl88yU7SQ3C8J2uNEa55B7RZjEg0=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }*/

    /*single {
        val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor{
                val original = it.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Authorization", API_KEY)
                val request = requestBuilder.build()
                it.proceed(request)
            }
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }*/

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/discover/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
         retrofit.create(ApiService::class.java)
    }
}

val databaseModule = module {
    factory { get<MovieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            MovieDatabase::class.java, "Movie.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    single<IMovieRepository>{MovieRepository(get(), get(), get())}
    factory { AppExecutors() }
}