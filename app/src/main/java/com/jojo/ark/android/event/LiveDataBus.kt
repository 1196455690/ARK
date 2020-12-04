package com.jojo.ark.android.event

/**
 * @author JOJO
 * @date 2020/5/12
 */
class LiveDataBus(builder: LiveDataBusBuilder? = DEFAULT_BUILDER) {

    companion object {
        private val DEFAULT_BUILDER = LiveDataBusBuilder()

        private val defaultInstance: LiveDataBus by lazy {
            LiveDataBus()
        }

        fun getDefault(): LiveDataBus {
            return defaultInstance
        }
    }

}