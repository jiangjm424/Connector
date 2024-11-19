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

// 提供给外部使用的api
// 服务端提供的方法并非所有的方法都需要提供到业务使用
interface IMusicClient {
    suspend fun play(path: String)

    companion object {
        fun getOrCreate(context: Context): IMusicClient {
            return MusicClientImpl(context)
        }
    }
}
