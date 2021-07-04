package com.example.pushnotification_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static final int NOTIFICATION_ID = 1;
    public static final String NOTIFICATION_TITLE = "Create a channel and set the importance";
    public static final String NOTIFICATION_MESSAGER = "Before you can deliver the notification on Android 8.0 and higher, you must register your app's notification channel with the system by passing an instance of NotificationChannel to createNotificationChannel(). So the following code is blocked by a condition on the SDK_INT version:";
    Button btn_click;
    Button btn_click_2;
    Button btn_custom_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        // btn notification 1
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
        // btn notification 2
        btn_click_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification_2();
            }
        });
        // btn_custom_notification
        btn_custom_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotificationCustom();
            }
        });

    }

    // sendNotification 1
    private void sendNotification() {
        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Notification notification = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID)
                .setContentTitle(NOTIFICATION_TITLE)
                .setContentText(NOTIFICATION_MESSAGER)
                .setSmallIcon(R.drawable.notification)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(NOTIFICATION_MESSAGER))
                .setLargeIcon(bitmap)
                .setSound(uri)
                .setPriority(NotificationManagerCompat.IMPORTANCE_MIN)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))
                .setColor(getResources().getColor(R.color.teal_200))
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null){
            notificationManager.notify(getNotificationId(), notification);
        }
    }
    // sendNotification 2
    private void sendNotification_2() {
        Uri sound = Uri.parse("android.resource://" +  getPackageName() + "/" + R.raw.ringtone);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.thong);
        Notification notification = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_2)
                .setContentTitle("Notification demo")
                .setContentText("Messager push notifiation")
                .setSmallIcon(R.drawable.notification)
                .setLargeIcon(bitmap)
                .setSound(sound)
                .setPriority(NotificationManagerCompat.IMPORTANCE_MAX)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))
                .setColor(getResources().getColor(R.color.teal_200))
                .build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(getNotificationId(), notification);
    }
    // sendNotification_custom
    private void sendNotificationCustom() {
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.custom_notification);
        notificationLayout.setTextViewText(R.id.content_title, "Title custom notification");
        notificationLayout.setTextViewText(R.id.content_message, "Messager custom notification");
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String strDate = simpleDateFormat.format(new Date());
        notificationLayout.setTextViewText(R.id.time_custom, strDate);

        Uri sound = Uri.parse("android.resource://" +  getPackageName() + "/" + R.raw.shoppee);
        Notification notification = new NotificationCompat.Builder(this, MyApplication.CHANNEL_ID_2)
                .setSmallIcon(R.drawable.notification)
                .setSound(sound)
                .setCustomContentView(notificationLayout)
                .build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(getNotificationId(), notification);


    }
   //getNotificationId
    private int getNotificationId(){
        return (int) new Date().getTime();
    }

    //Anh xa
    private void Anhxa() {
        btn_click = findViewById(R.id.btn_click);
        btn_click_2 = findViewById(R.id.btn_click_2);
        btn_custom_notification = findViewById(R.id.btn_custom_notification);
    }
}