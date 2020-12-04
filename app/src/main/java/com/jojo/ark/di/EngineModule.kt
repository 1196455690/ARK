package com.jojo.ark.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * @author zhoupeng
 * @date 2020/11/25
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class EngineModule {
    @BindGasEngine
    @Binds
    abstract fun bindEngine(gasEngine: GasEngine): Engine

    @BindElectricEngine
    @Binds
    abstract fun bindElectricEngine(electricEngine: ElectricEngine): Engine
}