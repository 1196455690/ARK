package com.jojo.ark.di

import com.jojo.uikit.log.LogCat
import javax.inject.Inject

/**
 * @author zhoupeng
 * @date 2020/11/25
 */
class GasEngine @Inject constructor() : Engine {
    override fun start() {
        LogCat.d("Gas engine start.")
    }

    override fun shutdown() {
        LogCat.d("Gas engine shutdown.")
    }
}