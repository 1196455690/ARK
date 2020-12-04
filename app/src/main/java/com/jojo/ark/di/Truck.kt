package com.jojo.ark.di

import com.jojo.uikit.log.LogCat
import javax.inject.Inject

/**
 * @author zhoupeng
 * @date 2020/11/25
 */
class Truck @Inject constructor() {
    @BindGasEngine
    @Inject
    lateinit var gasEngine: Engine

    @BindElectricEngine
    @Inject
    lateinit var electricEngine: Engine

    fun deliver() {
        gasEngine.start()
        electricEngine.start()
        LogCat.d("deliver")
        gasEngine.shutdown()
        electricEngine.shutdown()
    }
}