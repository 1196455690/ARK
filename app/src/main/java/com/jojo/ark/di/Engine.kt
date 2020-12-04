package com.jojo.ark.di

import javax.inject.Qualifier

/**
 * @author zhoupeng
 * @date 2020/11/25
 */
interface Engine {
    fun start()
    fun shutdown()
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindGasEngine

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindElectricEngine