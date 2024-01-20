package classesdef.browser.download;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;

import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.xplayer.ShareProvider;
import com.abhishek.xplayer.activities.PlayerActivity;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadUtils;


import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

import classesdef.browser.bbc;
import classesdef.browser.bok;
import classesdef.browser.bon;
import classesdef.browser.boo;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.box;
import classesdef.browser.bpc;
import classesdef.browser.bph;
import classesdef.browser.bqw;
import classesdef.database.bnm;
import classesdef.eventbus.bnt;
import classesdef.eventbus.boa;
import classesdef.xdplayer.bpe;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.activity.MainActivity;
import video.downloader.videodownloader.five.activity.ImagePreActivity;

/* renamed from: bpd */
public class bpd {

    /* renamed from: a */
    private static SharedPreferences f16131a;

    /* renamed from: a */
    public static SharedPreferences m18499a(Context context) {
        if (f16131a == null) {
            f16131a = context.getSharedPreferences("video_downloader", 0);
        }
        return f16131a;
    }

    /* renamed from: a */
    public static bph m18501a(Context context, String str, String str2, int i, String str3) {
        bph bph = new bph();
        bph.mo23337b(str);
        bph.mo23347e(str2);
        bph.mo23342c(str3);
        bph.mo23345d(boo.m18379c(context));
        bph.mo23329a(i);
        bph.mo23336b(System.currentTimeMillis());
        if (bph.mo23327a(context).exists()) {
            bph.mo23335b(2);
        } else {
            bph.mo23335b(1);
        }
        return bph;
    }
    public static bph m21193a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        bph bfz = new bph();
        String a = bpc.m18492a(context, str, 2, "video/mp4", (String) null, str3, true);
        bfz.mo23337b(str);
        bfz.mo23347e(str2);
        bfz.mo23342c(a);
        bfz.mo23345d(boo.m18379c(context));
        bfz.mo23329a(2);
        Log.e("video_length_origi","__"+String.valueOf(i));
        bfz.mo23344d((long) i);
        bfz.mo23340c(i2);
        bfz.mo23349f(str4);
        bfz.mo23336b(System.currentTimeMillis());
        if (bfz.mo23327a(context).exists()) {
            bfz.mo23335b(2);
        } else {
            bfz.mo23335b(1);
        }
        return bfz;
    }

    /* renamed from: a */
    public static String m21196a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        boolean startsWith = str.startsWith("https://");
        int indexOf = str.indexOf(47, 8);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        try {
            str2 = new URI(str).getHost();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            str2 = null;
        }
        if (str2 == null || str2.isEmpty()) {
            return str;
        }
        if (startsWith) {
            return "https://" + str2;
        }
        return "http://" + str2;
    }

    /* renamed from: a */
    public static void m18506a(Context context, bph bph) {
        bph.mo23330a(bnm.m18246a().mo23217a(context, bph));
        bou.m18412a().mo23299a(context, bph, true);
        BrowserLogEvent.downloaderLogEvent(context, "goto into download queue", bqw.m19011a(bph.mo23354i()));
    }

    /* renamed from: a */
    public static void m18508a(Context context, String str) {
        if (bon.m18359a().mo23295j(str) || bon.m18359a().mo23293h(str) || bon.m18359a().mo23294i(str)) {
            try {
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public static void m18511b(Context context, String str) {
        if (!bon.m18359a().mo23295j(str) && !bon.m18359a().mo23293h(str) && !bon.m18359a().mo23294i(str)) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 19) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                contentResolver.delete(uri, "_data='" + str + "'", (String[]) null);
            } catch (Exception e) {
                e.printStackTrace();
            //    bor.m18385a().mo23297a((Throwable) e);
            }
        } else {
            m18508a(context, str);
        }
    }

    /* renamed from: c */
    public static void m18513c(Context context, String str) {
        BrowserLogEvent.downloaderLogEvent(context, "download event", "download success");
        BrowserLogEvent.m18381a(context, "download event", "download success", "");
    }

    /* renamed from: d */
    public static void m18514d(Context context, String str) {
        BrowserLogEvent.downloaderLogEvent(context, "download event", "download fail");
        BrowserLogEvent.m18381a(context, "download event", "download failed", "");
    }

    /* renamed from: a */
    public static void m18504a(Activity activity, bph bph) {
        m18505a(activity, bph, (List<bph>) null);
    }

    /* renamed from: a */
    public static void m18505a(final Activity activity, final bph bph, final List<bph> list) {
        if (box.m18457a(activity, new box.C3987a() {
            /* renamed from: a */
            public void mo21376a() {
                bpd.m18507a((Context) activity, bph, (List<bph>) list);
            }
        })) {
            m18507a((Context) activity, bph, list);
        }
    }

    /* renamed from: a */
    public static void m18507a(Context context, bph bph, List<bph> list) {
        int h = bph.mo23352h();
        if (h != 100) {
            switch (h) {
                case 2:
                    ArrayList arrayList = new ArrayList();
                    if (list == null || list.size() == 0) {
                        VideoPlayListBean videoPlayListBean = new VideoPlayListBean();
                        videoPlayListBean.f9815c = bph.mo23346e();
                        videoPlayListBean.f9813a = bph.mo23334b(context);
                        videoPlayListBean.f9814b = bph.mo23360o();
                        arrayList.add(videoPlayListBean);
                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            bph bph2 = list.get(i);
                            int h2 = bph2.mo23352h();
                            if (h2 == 2 || h2 == 1) {
                                VideoPlayListBean videoPlayListBean2 = new VideoPlayListBean();
                                videoPlayListBean2.f9815c = bph2.mo23346e();
                                videoPlayListBean2.f9813a = bph2.mo23334b(context);
                                videoPlayListBean2.f9814b = bph2.mo23360o();
                                int i2 = (bph2.mo23333b() > bph.mo23333b() ? 1 : (bph2.mo23333b() == bph.mo23333b() ? 0 : -1));
                                arrayList.add(videoPlayListBean2);
                            }
                        }
                    }
                    String string = context.getString(R.string.downloads);
                    Intent intent = new Intent(context, PlayerActivity.class);
                    intent.putExtra("path", bph.mo23334b(context));
                    intent.putExtra("name", bph.mo23346e());
                    intent.putExtra("playList", arrayList);
                    intent.putExtra("listName", string);
                    context.startActivity(intent);
                    return;
                case 3:
                    Intent intent2 = new Intent(context, ImagePreActivity.class);
                    intent2.putExtra("record", bph);
                    context.startActivity(intent2);
                    return;
                case 4:
                    m18510b(context, bph);
                    return;
                case 5:
                    m18518h(context, bph.mo23334b(context));
                    return;
                case 6:
                case 7:
                    break;
                default:
                    return;
            }
        }
        try {
            Intent intent3 = new Intent();
            intent3.setAction("android.intent.action.VIEW");
            intent3.setFlags(1);
            intent3.setDataAndType(m18500a(context, bph.mo23327a(context)), "text/plain");
            context.startActivity(Intent.createChooser(intent3, context.getString(R.string.open_with)));
        } catch (Exception e) {
            bbc.m15886a().mo21879a(context, (Throwable) e);
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m18510b(Context context, bph bph) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(1);
            intent.setDataAndType(m18500a(context, bph.mo23327a(context)), "audio/*");
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.open_with)));
        } catch (Exception e) {
            bbc.m15886a().mo21879a(context, (Throwable) e);
            e.printStackTrace();
        }
    }

    /* renamed from: h */
    private static void m18518h(Context context, String str) {
        try {
            Uri a = m18500a(context, new File(str));
            if (Build.VERSION.SDK_INT >= 24) {
                Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
                intent.setData(a);
                intent.setFlags(1);
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setDataAndType(a, "application/vnd.android.package-archive");
            intent2.setFlags(1);
            context.startActivity(intent2);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m18512c(Context context, bph bph) {
        m18509a(context, bph.mo23339c(), bph.mo23334b(context));
        EventBus.getDefault().post(new bnt(bph.mo23333b(), bph.mo23352h()));
        bnm.m18246a().mo23221a(context, bph.mo23333b());
        bpe.m18520a().mo23317b();
    }

    /* renamed from: a */
    private static void m18509a(Context context, String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
            m18511b(context, file.getAbsolutePath());
        } else {
            FileDownloader.getImpl().pause(FileDownloadUtils.generateId(str, str2));
            File file2 = new File(FileDownloadUtils.getTempPath(str2));
            if (file2.exists()) {
                file2.delete();
            }
        }
        FileDownloader.getImpl().clear(FileDownloadUtils.generateId(str, str2), str2);
        bpe.m18520a().mo23315a(file.getAbsolutePath());
        bow.m18450a().mo23301a(context, FileDownloadUtils.generateId(str, str2));
        bok.m18344c(context, str2);
        bpa.m18484a(str2);
    }

    /* renamed from: a */
    public static synchronized long m18498a(String str) {
        synchronized (bpd.class) {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (!TextUtils.isEmpty(extractMetadata)) {
                    long parseLong = Long.parseLong(extractMetadata);
                    return parseLong;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    /* renamed from: a */
    public static String m18502a(long j) {
        if (j <= 0 || j >= 86400000) {
            return "00:00";
        }
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 / 60) % 60;
        long j5 = j2 / 3600;
        Formatter formatter = new Formatter(new StringBuilder(), Locale.getDefault());
        if (j5 > 0) {
            return formatter.format("%02d:%02d:%02d", new Object[]{Long.valueOf(j5), Long.valueOf(j4), Long.valueOf(j3)}).toString();
        }
        return formatter.format("%02d:%02d", new Object[]{Long.valueOf(j4), Long.valueOf(j3)}).toString();
    }

    /* renamed from: e */
    public static void m18515e(Context context, String str) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(131072);
        context.startActivity(intent);
        EventBus. getDefault().post(new boa(str));
    }

    /* renamed from: f */
    public static void m18516f(Context context, String str) {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            BrowserLogEvent.downloaderLogEvent(context, "web_collect_time = " + instance.get(11) + "", bqw.m19011a(str));
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
        }
    }

    /* renamed from: g */
    public static boolean m18517g(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static Uri m18500a(Context context, File file) {
        return ShareProvider.m11567a(file);
    }

    /* renamed from: a */
    public static String m18503a(Context context, long j) {
        if (j < 104857600) {
            StringBuilder sb = new StringBuilder();
            long j2 = (j / 20971520) * 20;
            sb.append(j2);
            sb.append("MB to ");
            sb.append(j2 + 20);
            sb.append("MB");
            return sb.toString();
        }
        long j3 = j / 104857600;
        return android.text.format.Formatter.formatFileSize(context, j3 * 100 * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) + " to " + android.text.format.Formatter.formatFileSize(context, (j3 + 1) * 100 * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
    }
}
