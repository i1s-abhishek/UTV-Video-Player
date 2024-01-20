package com.abhishek.xplayer.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.abhishek.xplayer.activities.SplashActivity;
import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.receiver.SelfReceiver;

import java.io.File;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.axh;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;

public class NotifyService extends Service implements axh.C1349a {

    /* renamed from: a */
    private axh f11024a;

    /* renamed from: b */
    private long f11025b = 0;

    /* renamed from: c */
    private String f11026c;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public void onCreate() {
        super.onCreate();
        this.f11024a = new axh(this, this, 1500);
        this.f11024a.mo10973a();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f11024a.mo10974b();
        this.f11024a = null;
    }

    /* renamed from: a */
    public void mo10977a(Set<Uri> set) {
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("notifyNew", true)) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long max = Math.max(this.f11025b - 30, currentTimeMillis - 180);
            Iterator<Uri> it = set.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (mo18108a(it.next(), max)) {
                        m12580a();
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f11025b = currentTimeMillis;
            return;
        }
        stopSelf();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo18108aa(Uri r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x004f, all -> 0x0048 }
            java.lang.String r4 = "date_modified>? or date_added>?"
            r2 = 2
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch:{ Exception -> 0x004f, all -> 0x0048 }
            java.lang.String r2 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x004f, all -> 0x0048 }
            r5[r0] = r2     // Catch:{ Exception -> 0x004f, all -> 0x0048 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ Exception -> 0x004f, all -> 0x0048 }
            r11 = 1
            r5[r11] = r10     // Catch:{ Exception -> 0x004f, all -> 0x0048 }
            java.lang.String r6 = "_id DESC"
            r2 = r9
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x004f, all -> 0x0048 }
            if (r9 == 0) goto L_0x0042
        L_0x0027:
            boolean r10 = r9.moveToNext()     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            if (r10 == 0) goto L_0x0042
            java.lang.String r10 = r9.getString(r0)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            boolean r10 = m12582a((java.lang.String) r10)     // Catch:{ Exception -> 0x0040, all -> 0x003d }
            if (r10 == 0) goto L_0x0027
            if (r9 == 0) goto L_0x003c
            p000.axy.m7468a((android.database.Cursor) r9)
        L_0x003c:
            return r11
        L_0x003d:
            r10 = move-exception
            r7 = r9
            goto L_0x0049
        L_0x0040:
            r7 = r9
            goto L_0x004f
        L_0x0042:
            if (r9 == 0) goto L_0x0054
            p000.axy.m7468a((android.database.Cursor) r9)
            goto L_0x0054
        L_0x0048:
            r10 = move-exception
        L_0x0049:
            if (r7 == 0) goto L_0x004e
            p000.axy.m7468a((android.database.Cursor) r7)
        L_0x004e:
            throw r10
        L_0x004f:
            if (r7 == 0) goto L_0x0054
            p000.axy.m7468a((android.database.Cursor) r7)
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.service.NotifyService.mo18108a(android.net.Uri, long):boolean");
    }
    public boolean mo18108a(Uri uri, long j) {
        Throwable th;
        String[] strArr = {"_data"};
        Cursor cursor = null;
        try {
            Cursor query = getContentResolver().query(uri, strArr, "date_modified>? or date_added>?", new String[]{String.valueOf(j), String.valueOf(j)}, "_id DESC");
            if (query != null) {
                do {
                    try {
                        if (query.moveToNext()) {
                        }
                    } catch (Exception unused) {
                        cursor = query;
                        if (cursor != null) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                } while (!m12582a(query.getString(0)));
                if (query != null) {
                    axy.m7468a(query);
                }
                return true;
            }
            if (query != null) {
                axy.m7468a(query);
            }
        } catch (Exception unused2) {
            if (cursor != null) {
                axy.m7468a(cursor);
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                axy.m7468a(cursor);
            }
          //  throw th;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m12582a(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && file.length() > 52428800 && !m12581a(file)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m12581a(File file) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        if (externalStoragePublicDirectory == null || !externalStoragePublicDirectory.exists()) {
            return file.getAbsolutePath().toLowerCase(Locale.ENGLISH).contains("dcim/camera");
        }
        return file.getAbsolutePath().toLowerCase(Locale.ENGLISH).startsWith(externalStoragePublicDirectory.getAbsolutePath().toLowerCase(Locale.ENGLISH));
    }

    /* renamed from: a */
    private void m12580a() {
        Notification notification;
        PendingIntent activity = PendingIntent.getActivity(this, (int) (Math.random() * 9999.0d), new Intent(this, SplashActivity.class).putExtra("fromNotification", true).addFlags(32768), 134217728);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, (int) (Math.random() * 9999.0d), new Intent(this, SelfReceiver.class).setAction("dgoasdf"), 134217728);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(this, (int) (Math.random() * 9999.0d), new Intent(this, SelfReceiver.class).setAction("sfdavxvv"), 134217728);
        int i = Build.VERSION.SDK_INT;
        int i2 = R.mipmap.ic_notification;
        if (i >= 26) {
            Notification.Builder addAction = new Notification.Builder(this, m12583b()).setSmallIcon(R.mipmap.ic_notification).setContentTitle(getString(R.string.notification_new_title)).setAutoCancel(true).setStyle(new Notification.BigTextStyle().bigText(getString(R.string.notification_new_desc))).setContentText(getString(R.string.notification_new_desc)).addAction(0, getString(R.string.dismiss), broadcast).addAction(0, getString(R.string.never_remind), broadcast2);
            addAction.setColor(getResources().getColor(R.color.colorAccent));
            addAction.setContentIntent(activity);
            notification = addAction.build();
        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            if (Build.VERSION.SDK_INT < 21) {
                i2 = R.mipmap.ic_launcher;
            }
            NotificationCompat.Builder addAction2 = builder.setSmallIcon(i2).setContentTitle(getString(R.string.notification_new_title)).setAutoCancel(true).setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.notification_new_desc))).setContentText(getString(R.string.notification_new_desc)).addAction(0, getString(R.string.dismiss), broadcast).addAction(0, getString(R.string.never_remind), broadcast2);
            if (Build.VERSION.SDK_INT >= 21) {
                addAction2.setColor(getResources().getColor(R.color.colorAccent));
            }
            addAction2.setContentIntent(activity);
            notification = addAction2.build();
        }
        ((NotificationManager) getSystemService("notification")).notify(328, notification);
        LogEvents.m18492b("Notification", "show");
    }

    /* renamed from: b */
    private String m12583b() {
        if (this.f11026c != null) {
            return this.f11026c;
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager == null) {
            return "";
        }
        this.f11026c = "notify";
        NotificationChannel notificationChannel = new NotificationChannel("notify", "Notify", 3);
        notificationChannel.setDescription("Notify new video.");
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        notificationManager.createNotificationChannel(notificationChannel);
        return this.f11026c;
    }
}
