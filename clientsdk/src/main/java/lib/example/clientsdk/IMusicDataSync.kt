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

package lib.example.clientsdk

import android.content.Context
import com.google.common.util.concurrent.ListenableFuture
import jm.droid.lib.connector.ClientConfiguration

// 与服务端连接的一个类，可以调用服务端提供的aidl方法
internal interface IMusicDataSync {
    fun play(path: String): ListenableFuture<Unit>

    companion object {
        fun get(context: Context): IMusicDataSync {
            val connection = ClientConfiguration(
                context.packageName,
                "com.example.connector.server",
                "jm.droid.service.action.music",

            )
            return MusicDataSyncImpl(context, connection)
        }
    }
}
