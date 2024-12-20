/*
 * Copyright 2024 The Jmdroid Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
