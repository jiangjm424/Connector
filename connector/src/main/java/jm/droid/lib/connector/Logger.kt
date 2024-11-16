package jm.droid.lib.connector

import android.util.Log

internal object Logger {
    @JvmStatic
    fun debug(tag: String, message: String) {
        if (Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, message)
        }
    }

    @JvmStatic
    fun warning(tag: String, message: String) {
        if (Log.isLoggable(tag, Log.WARN)) {
            Log.w(tag, message)
        }
    }

    @JvmStatic
    fun warning(tag: String, message: String, throwable: Throwable) {
        if (Log.isLoggable(tag, Log.WARN)) {
            Log.w(tag, message, throwable)
        }
    }

    @JvmStatic
    fun error(tag: String, message: String) {
        if (Log.isLoggable(tag, Log.ERROR)) {
            Log.e(tag, message)
        }
    }

    @JvmStatic
    fun error(tag: String, message: String, throwable: Throwable) {
        if (Log.isLoggable(tag, Log.ERROR)) {
            Log.e(tag, message, throwable)
        }
    }
}
