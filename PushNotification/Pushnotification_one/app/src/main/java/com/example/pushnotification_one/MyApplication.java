package com.example.pushnotification_one;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.NoCopySpan;

public class MyApplication extends Application {
    public static final String CHANNEL_ID = "Channel_1";
    public static final String CHANNEL_ID_2 = "Channel_2";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Uri sound = Uri.parse("android.resource://" +  getPackageName() + "/" + R.raw.ringtone);
            Uri sound1 = Uri.parse("android.resource://" +  getPackageName() + "/" + R.raw.shoppee);
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();


            // config channel_1
            CharSequence name = getString(R.string.channel_name_1);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_MIN;
            NotificationChannel channel_1 = new NotificationChannel(CHANNEL_ID, name, importance);
            channel_1.setDescription(description);
            channel_1.setSound(sound, audioAttributes);

            //config channel_2
            CharSequence name_2 = getString(R.string.channel_name_2);
            String description_2 = getString(R.string.channel_description_2);
            int importance_2 = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel_2 = new NotificationChannel(CHANNEL_ID_2, name_2, importance_2);
            channel_2.setDescription(description_2);
            channel_2.setSound(sound1, audioAttributes);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null){
                notificationManager.createNotificationChannel(channel_1);
                notificationManager.createNotificationChannel(channel_2);
            }
        }
    }
}
