package bluenet.com.lab10

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {
    override fun onCreate() {
        super.onCreate()
        Thread(Runnable {
            try {
                //延遲5秒
                Thread.sleep(5000)
                //宣告Intent啟動Main2Activity
                val intent = Intent(this@MyService, Main2Activity::class.java)
                //Service要啟動Activity要加入Flag定義要去產生一個新的Activity
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                this@MyService.startActivity(intent)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }).start()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
        super.onStartCommand(intent, flags, startid)
        //結束後不再重啟
        return Service.START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}
