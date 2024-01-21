package classesdef.browser.download;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.provider.FontsContractCompat;

import com.liulishuo.filedownloader.BaseDownloadTask;

import java.util.HashMap;

import classesdef.browser.bbc;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.five.activity.FilesActivity;

/* renamed from: bow */
public class bow {

    /* renamed from: a */
    private static bow f16101a;

    /* renamed from: b */
    private NotificationManager f16102b;

    /* renamed from: c */
    private HashMap<Integer, NotificationCompat.Builder> f16103c;

    /* renamed from: d */
    private boolean f16104d;

    private bow() {
    }

    /* renamed from: a */
    public static bow m18450a() {
        if (f16101a == null) {
            f16101a = new bow();
        }
        return f16101a;
    }

    /* renamed from: a */
    private NotificationManager m18448a(Context context) {
        if (this.f16102b == null) {
            this.f16102b = (NotificationManager) context.getSystemService("notification");
        }
        return this.f16102b;
    }

    /* renamed from: b */
    private void m18451b() {
        if (this.f16103c == null) {
            this.f16103c = new HashMap<>(3);
        }
    }

    /* renamed from: a */
    public void mo23302a(Context context, BaseDownloadTask aye) {
        String str;
        if (aye != null && context != null && aye.getId() != 0) {
            m18451b();
            NotificationCompat.Builder builder = this.f16103c.get(Integer.valueOf(aye.getId()));
            if (builder == null) {
                this.f16103c.put(Integer.valueOf(aye.getId()), m18449a(context, aye.getId(), aye.getFilename()));
                return;
            }
            boolean z = false;
            switch (aye.getStatus()) {
                case -4:
                case -1:
                    builder.setContentText(context.getString(R.string.error));
                    break;
                case FontsContractCompat.FontRequestCallback.FAIL_REASON_FONT_LOAD_ERROR:
                    builder.setContentText(context.getString(R.string.finished));
                    break;
                case -2:
                case 0:
                    builder.setContentText(context.getString(R.string.paused));
                    break;
                case 1:
                case 10:
                case 11:
                    builder.setContentText(context.getString(R.string.waiting));
                    break;
                case 2:
                case 6:
                    builder.setContentText(context.getString(R.string.connecting));
                    break;
                case 3:
                case 4:
                    long b = bpa.m18486b(aye.getPath(), aye.getLargeFileSoFarBytes());
                    if (b == 0) {
                        b = (long) (aye.getSpeed() * 1024);
                    }
                    if (b == 0) {
                        str = context.getString(R.string.unknown).toLowerCase();
                    } else {
                        str = bpd.m18502a((long) (((((float) (aye.getLargeFileTotalBytes() - aye.getLargeFileSoFarBytes())) * 1.0f) / ((float) b)) * 1000.0f));
                    }
                    builder.setContentText(context.getString(R.string.left, new Object[]{str}));
                    break;
                case 5:
                    builder.setContentText(context.getString(R.string.retrying));
                    break;
            }
            z = true;
            if (aye.getLargeFileTotalBytes() == 0) {
                z = true;
            }
            builder.setProgress((int) aye.getLargeFileTotalBytes(), (int) aye.getLargeFileSoFarBytes(), z);
            try {
                m18448a(context).notify(aye.getId(), builder.build());
            } catch (Exception e) {
                e.printStackTrace();
                bbc.m15886a().mo21879a(context, (Throwable) e);
            }
        }
    }

    /* renamed from: a */
    public void mo23301a(Context context, int i) {
        if (this.f16103c != null && i != 0 && context != null) {
            this.f16103c.remove(Integer.valueOf(i));
            m18448a(context).cancel(i);
        }
    }

    /* renamed from: b */
    private void m18452b(Context context) {
        if (Build.VERSION.SDK_INT >= 26 && !this.f16104d) {
            this.f16104d = true;
            NotificationManager a = m18448a(context);
            NotificationChannel notificationChannel = new NotificationChannel("download", "Downloading", 2);
            notificationChannel.setDescription("Notify downloading progress.");
            notificationChannel.enableVibration(false);
            notificationChannel.enableLights(false);
            a.createNotificationChannel(notificationChannel);
        }
    }

    /* renamed from: a */
    private NotificationCompat.Builder m18449a(Context context, int i, String str) {
        m18452b(context);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "download");
        builder.setAutoCancel(false);
        builder.setOnlyAlertOnce(false);
        builder.setDefaults(32);
        builder.setTicker(context.getString(R.string.downloading));
        if (str.length() > 24) {
            str = str.substring(0, 24) + "...";
        }
        builder.setContentTitle(str);
        builder.setPriority(1);
        builder.setProgress(0, 0, true);
        Intent intent = new Intent(context, FilesActivity.class);
        intent.setFlags(131072);
        intent.putExtra("position", 1);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 167772160));
        builder.setSmallIcon(R.mipmap.ic_file_download_white_24dp_noti);
        m18448a(context).notify(i, builder.build());
        return builder;
    }
}
