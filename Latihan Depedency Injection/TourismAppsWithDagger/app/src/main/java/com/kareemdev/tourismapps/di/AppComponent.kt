package com.kareemdev.tourismapps.di

import com.kareemdev.tourismapps.core.di.CoreComponent
import com.kareemdev.tourismapps.detail.DetailTourismActivity
import com.kareemdev.tourismapps.favorite.FavoriteFragment
import com.kareemdev.tourismapps.home.HomeFragment
import dagger.Component


@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}