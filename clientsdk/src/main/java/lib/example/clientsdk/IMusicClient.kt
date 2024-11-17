package lib.example.clientsdk

import android.content.Context

//提供给外部使用的api
//服务端提供的方法并非所有的方法都需要提供到业务使用
interface IMusicClient {
    suspend fun play(path: String)

    companion object {
        fun getOrCreate(context: Context): IMusicClient {
            return MusicClientImpl(context)
        }
    }
}