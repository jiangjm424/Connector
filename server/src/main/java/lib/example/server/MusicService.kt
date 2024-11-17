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
            Log.i("jiang","server api version:3")
            return 3
        }

        override fun play(path: String?) {
            Log.i("jiang","server play：$path")
        }
    }
}