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

package jm.droid.lib.connector.internal

import android.content.Context
import android.os.HandlerThread
import android.os.Looper
import android.os.Process
import java.util.concurrent.atomic.AtomicInteger

object ProviderConnectionManager {

    private val index = AtomicInteger(0)

    fun create(context: Context): ConnectionManager {
        return ConnectionManager(
            context.applicationContext,
            startHandlerThread(index.addAndGet(1)),
        )
    }

    private fun startHandlerThread(index: Int): Looper {
        val handlerThread =
            HandlerThread(
                "ProviderConnectionManager$index",
                Process.THREAD_PRIORITY_BACKGROUND + Process.THREAD_PRIORITY_MORE_FAVORABLE,
            )
        handlerThread.start()
        return handlerThread.getLooper()
    }
}
