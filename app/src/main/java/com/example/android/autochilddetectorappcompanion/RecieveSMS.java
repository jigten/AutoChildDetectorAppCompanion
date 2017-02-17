package com.example.android.autochilddetectorappcompanion;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ujigt on 2/12/2017.
 */

public class RecieveSMS extends BroadcastReceiver {
    final SmsManager sms = SmsManager.getDefault();
    @Override
    public void onReceive(Context context, Intent intent) {
        WakeLocker.acquire(context);
        final Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    if(message.equals("Emergency from Arduino")) {
                        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_RING);
                        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                        audioManager.setStreamVolume(AudioManager.STREAM_RING, maxVolume, AudioManager.FLAG_SHOW_UI + AudioManager.FLAG_PLAY_SOUND);

                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, "Sender: "+ senderNum + ", Message: " + message, duration);
                        toast.show();

                        NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(context)
                                        .setSmallIcon(R.drawable.logosmall)
                                        .setContentTitle("Auto Child Detector")
                                        .setPriority(Notification.PRIORITY_MAX)
                                        .setDefaults(Notification.DEFAULT_ALL)
                                        .setVisibility(1)
                                        .setLights(Color.RED, 1000, 500)
                                        .setContentText("CHILD DETECTED INSIDE HOT VECHIClE");

                        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                        mNotificationManager.notify(1, mBuilder.build());

                        WakeLocker.release();
                    }
                    else if (message.equals("Setup Complete"))  {
                        NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(context)
                                        .setSmallIcon(R.drawable.logosmall)
                                        .setContentTitle("Auto Child Detector")
                                        .setPriority(Notification.PRIORITY_MAX)
                                        .setDefaults(Notification.DEFAULT_ALL)
                                        .setVisibility(1)
                                        .setLights(Color.RED, 1000, 500)
                                        .setContentText("Setup Complete");

                        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                        mNotificationManager.notify(1, mBuilder.build());
                    }

                }

            }
        }catch (Exception e) {
            Log.e("SmsReceive", "Exception" +e);

        }
    }
    }



