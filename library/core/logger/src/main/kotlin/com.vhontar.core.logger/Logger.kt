package com.vhontar.core.logger

import android.util.Log
import com.vhontar.domain.logger.LogMessage

interface Logger {
    fun log(log: LogMessage)

    companion object {
        // instead of DI Singleton
        private var INSTANCE: Logger? = null
        fun create(): Logger {
            if (INSTANCE == null) {
                INSTANCE = DefaultLogger()
            }

            return INSTANCE!!
        }
    }
}

internal class DefaultLogger: Logger {
    override fun log(log: LogMessage) {
        Log.d(log.tag, log.message)
    }
}