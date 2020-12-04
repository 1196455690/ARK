//package com.jojo.ark.di
//
//import android.app.Application
//import android.content.Context
//import com.jojo.ark.MainApp
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
//
///**
// * @author JOJO
// * @date 2020/8/19
// */
//@Module
//@InstallIn(ApplicationComponent::class)
//object AppModule {
//    @Provides
//    fun provideAppContext(application: Application): Context {
//        return application
//    }
//    @Provides
//    fun provideMainApp(application: Application): MainApp {
//        return application as MainApp
//    }
//}