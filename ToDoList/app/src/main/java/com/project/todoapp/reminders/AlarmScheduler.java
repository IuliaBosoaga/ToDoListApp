package com.project.todoapp.reminders;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;


public class AlarmScheduler {

    /**
     *
     * @param context Aplicație locală sau context de activitate
     * @param alarmTime Ora de pornire a alarmei
     * @param reminderTask Uri care face referire la task in content provider
     *
     */
    public void scheduleAlarm(Context context, long alarmTime, Uri reminderTask) {
        // Programează alarma. Va actualiza un element existent pentru acelasi task,
        AlarmManager manager = AlarmManagerProvider.getAlarmManager(context);

        PendingIntent operation =
                ReminderAlarmService.getReminderPendingIntent(context, reminderTask);

        manager.setExact(AlarmManager.RTC, alarmTime, operation);
    }
}
