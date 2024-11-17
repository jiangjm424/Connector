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
            startHandlerThread(index.addAndGet(1))
        )

    }

    private fun startHandlerThread(index: Int): Looper {
        val handlerThread =
            HandlerThread(
                "ProviderConnectionManager$index",
                Process.THREAD_PRIORITY_BACKGROUND + Process.THREAD_PRIORITY_MORE_FAVORABLE
            )
        handlerThread.start()
        return handlerThread.getLooper()
    }
}
