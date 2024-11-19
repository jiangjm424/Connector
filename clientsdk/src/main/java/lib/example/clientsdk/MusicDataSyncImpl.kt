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
import jm.droid.lib.connector.Client
import jm.droid.lib.connector.ClientConfiguration
import jm.droid.lib.connector.internal.ConnectionManager
import jm.droid.lib.connector.internal.ProviderConnectionManager
import lib.example.server.IAidlMusic

internal class MusicDataSyncImpl(

    private val context: Context,
    clientConfiguration: ClientConfiguration,
    connectionManager: ConnectionManager = ProviderConnectionManager.create(context),
) :
    Client<IAidlMusic>(
        clientConfiguration,
        connectionManager,
        IAidlMusic.Stub::asInterface,
        null,
    ),
    IMusicDataSync {
    override fun play(path: String): ListenableFuture<Unit> {
        return executeWithVersionCheck(1) { service, future ->
            service.play(path)
//            future.set(Unit)
        }
    }
}
