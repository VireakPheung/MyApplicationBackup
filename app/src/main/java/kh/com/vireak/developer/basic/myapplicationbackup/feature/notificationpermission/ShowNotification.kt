package kh.com.vireak.developer.basic.myapplicationbackup.feature.notificationpermission

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import kh.com.vireak.developer.basic.myapplicationbackup.R


fun ShowNotification(context: Context){
    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val notification = NotificationCompat.Builder(context, "channel_id")
        .setContentText("This is some content text")
        .setContentTitle("this is content title")
        .setSmallIcon(R.drawable.ic_notification)
        .build()

    notificationManager.notify(1, notification)


}

