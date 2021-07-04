package com.example.clicknotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button button_click;
    Button button_sendNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        // btn sendnotification
        button_sendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotificationCustom();
            }
        });

        //btn goto lisproduct
        button_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListProductActivity2.class);
                startActivity(intent);
            }
        });


    }
    //creat Notification
    private void sendNotificationCustom() {
        //intent
        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(this, DetailActivity2.class);
// Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
// Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(getNotificationId(), PendingIntent.FLAG_UPDATE_CURRENT);

        // collapsed
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.custom_notification);
        notificationLayout.setTextViewText(R.id.content_title, "Title custom notification");
        notificationLayout.setTextViewText(R.id.content_message, "Messager custom notification");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String strDate = simpleDateFormat.format(new Date());
        notificationLayout.setTextViewText(R.id.time_custom, strDate);

        //expanded
        RemoteViews notificationExpanded = new RemoteViews(getPackageName(), R.layout.custom_notification_expanded);
        notificationExpanded.setTextViewText(R.id.content_title_expanded, "Title custom notification");
        notificationExpanded.setTextViewText(R.id.content_message_expanded, "Messager custom notification");
        notificationExpanded.setImageViewResource(R.id.image1, R.drawable.thong);

        Uri sound = Uri.parse("android.resource://" +  getPackageName() + "/" + R.raw.shoppee);
        Notification notification = new NotificationCompat.Builder(this, Myapplication.CHANNEL_ID)
                .setSmallIcon(R.drawable.messager)
                .setSound(sound)
                .setCustomContentView(notificationLayout)
                .setCustomBigContentView(notificationExpanded)
                .setContentIntent(resultPendingIntent)
                .setAutoCancel(true)
                .build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(getNotificationId(), notification);


    }

    //notificationId
    private int getNotificationId(){
        return (int) new Date().getTime();
    }

    //anhxa
    private void Anhxa() {
        button_click = findViewById(R.id.btn_click);
        button_sendNotification= findViewById(R.id.btn_sendNotification);
    }
}