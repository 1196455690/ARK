package com.jojo.ark.di

import com.jojo.uikit.log.LogCat
import javax.inject.Inject

/**
 * @author zhoupeng
 * @date 2020/11/25
 */
class ElectricEngine @Inject constructor() : Engine {
    override fun start() {
        LogCat.d("Electric engine start.")
    }

    override fun shutdown() {
        LogCat.d("Electric engine shutdown.")
    }
}