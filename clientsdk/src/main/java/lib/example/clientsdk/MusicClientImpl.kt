package lib.example.clientsdk

import android.content.Context
import kotlinx.coroutines.guava.await

internal class MusicClientImpl
    internal constructor(
    private val delegate: IMusicDataSync
) : IMusicClient {
    internal constructor(context: Context):this(
        delegate = IMusicDataSync.get(context)
    )
    override suspend fun play(path: String) {
        delegate.play(path).await()
    }
}