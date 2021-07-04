package com.example.service;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class  MyApplication  extends Application {
    public static final String CHANNEL_ID = "channel_vervice";
    @Override
    public void onCreate() {
        super.onCreate();

        createChannelNotifications();
    }

    private void createChannelNotifications() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "channel_service", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null){
                manager.createNotificationChannel(channel);
            }
        }
    }

}
