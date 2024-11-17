package lib.example.clientsdk

import android.content.Context
import com.google.common.util.concurrent.ListenableFuture
import jm.droid.lib.connector.ClientConfiguration

//与服务端连接的一个类，可以调用服务端提供的aidl方法
internal interface IMusicDataSync {
    fun play(path: String): ListenableFuture<Unit>

    companion object {
        fun get(context: Context): IMusicDataSync {
            val connection = ClientConfiguration(
                context.packageName,
                "com.example.connector.server",
                "jm.droid.service.action.music"

            )
            return MusicDataSyncImpl(context, connection)
        }
    }
}