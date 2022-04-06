package com.kareemdev.tourismapss.core.di

//import com.kareemdev.tourismapss.core.data.source.remote.network.ApiConfig

/*
object Injection {
    fun provideRepository(context: Context): ITourismRepository {
        val database = TourismDatabase.getInstance(context)

//        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.tourismDao())
        val appExecutors = AppExecutors()

        return TourismRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

    fun provideTourismUseCase(context: Context): TourismUseCase{
        val repository = provideRepository(context)
        return TourismInteractor(repository)
    }
}*/
