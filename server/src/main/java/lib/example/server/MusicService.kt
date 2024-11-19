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

package lib.example.server

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MusicService : Service() {
    private val mBinder = MusicServer()
    override fun onBind(intent: Intent?): IBinder {
        return mBinder
    }

    private class MusicServer : IAidlMusic.Stub() {
        override fun apiVersion(): Int {
            Log.i("jiang", "server api version:3")
            return 3
        }

        override fun play(path: String?) {
            Log.i("jiang", "server play：$path")
        }
    }
}
