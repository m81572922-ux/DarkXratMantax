package com.darkxrat.mantax.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.darkxrat.mantax.R;

public class SenderService extends Service {

    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    private static final int NOTIF_ID = 1001;
    private static final String CHANNEL_ID = "sender_channel";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(NOTIF_ID, buildNotification());

        // Loop heartbeat sender (cek status online)
        runnable = new Runnable() {
            @Override
            public void run() {
                // Cek sender status ke server/WA
                // (nanti di-implement)
                handler.postDelayed(this, 5000);
            }
        };
        handler.post(runnable);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                "Sender Service",
                NotificationManager.IMPORTANCE_LOW
            );
            channel.setDescription("Service untuk sender");
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) manager.createNotificationChannel(channel);
        }
    }

    private Notification buildNotification() {
        return new NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("DARK XRAT MANTAX")
            .setContentText("Sender Service aktif")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .build();
    }
}