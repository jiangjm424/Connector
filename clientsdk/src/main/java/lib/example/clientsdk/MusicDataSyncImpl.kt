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
    connectionManager: ConnectionManager = ProviderConnectionManager.create(context)
) :
    Client<IAidlMusic>(
        clientConfiguration,
        connectionManager,
        IAidlMusic.Stub::asInterface,
        null
    ),
    IMusicDataSync {
    override fun play(path: String): ListenableFuture<Unit> {
        return executeWithVersionCheck(1) { service, future ->
            service.play(path)
//            future.set(Unit)
        }
    }
}