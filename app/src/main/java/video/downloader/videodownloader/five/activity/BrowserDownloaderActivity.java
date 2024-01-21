package video.downloader.videodownloader.five.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.provider.FontsContractCompat;

import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadUtils;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import classesdef.browser.bon;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.box;
import classesdef.browser.bpc;
import classesdef.browser.bph;
import classesdef.browser.download.bnu;
import classesdef.browser.download.bou;
import classesdef.browser.download.bpa;
import classesdef.browser.download.bpd;
import classesdef.database.bnm;
import es.dmoral.toasty.Toasty;
import hdplayer.xdplayer.videoplayer.R;


public class BrowserDownloaderActivity extends BasePermissionActivity {

    private bph f13660a;

    
    private TextView fileSize;

    private TextView f13662c;

    private ProgressBar progressBar;

    public AlertDialog alertDialog;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_browser_downloader);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            dataString = intent.getStringExtra("url");
            BrowserLogEvent.downloaderLogEvent(this, "intent page url", dataString);
        }
        if (TextUtils.isEmpty(dataString)) {
            finish();
            return;
        }
        Logger.e("url = " + dataString, new Object[0]);
        String b = bpc.m18497b(dataString);
        Logger.e("extension = " + b, new Object[0]);
        if (TextUtils.isEmpty(b)) {
            BrowserLogEvent.downloaderLogEvent(this, "intent page", "no extension");
            finish();
            return;
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().post((Object) this);
        }
        final bph a = bnm.m18246a().mo23218a((Context) this, dataString);
        if (a != null) {
            BrowserLogEvent.downloaderLogEvent(this, "intent page", "already download");
            if (a.mo23327a((Context) this).exists()) {
                mo21529a((Context) this, a);
                return;
            }
            mo21533b(this, a);
            byte a2 = FileDownloader.getImpl().getStatus(a.mo23339c(), a.mo23334b((Context) this));
            if ((a2 == -2 || a2 == -1 || a2 == 0 || a2 == 11 || a2 == 10) && box.m18457a(this, new box.C3987a() {
                public void mo21376a() {
                    bou.m18412a().mo23299a((Context) BrowserDownloaderActivity.this, a, true);
                }
            })) {
                bou.m18412a().mo23299a((Context) this, a, true);
                return;
            }
            return;
        }
        mo21530a(this, dataString, b);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /* renamed from: a */
    public void mo21529a(Context context, final bph bph) {
        AlertDialog create = new AlertDialog.Builder(context).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.already_in_list, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_file_name)).setText(bph.mo23346e());
        mo21528a(bph.mo23352h(), (ImageView) inflate.findViewById(R.id.label));
        if (bph.getVideoSize() <= 0 && bph.mo23327a(context).exists()) {
            bph.setVideoSize(bph.mo23327a(context).length());
            Log.e("getVideoSize2222","///"+String.valueOf(bph.mo23327a(context).length()));
        }
        ((TextView) inflate.findViewById(R.id.tv_file_size)).setText(bph.getVideoSize() <= 0 ? "" : Formatter.formatFileSize(context, bph.getVideoSize()));
        create.setTitle(context.getString(R.string.already_in_list));
        create.setButton(-1, (CharSequence) context.getString(R.string.action_open).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                bpd.m18504a((Activity) BrowserDownloaderActivity.this, bph);
            }
        });
        create.setButton(-2, (CharSequence) context.getString(R.string.re_download).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, int i) {
                if (box.m18457a(BrowserDownloaderActivity.this, new box.C3987a() {
                    /* renamed from: a */
                    public void mo21376a() {
                        BrowserDownloaderActivity.this.mo21531a(dialogInterface, bph);
                    }
                })) {
                    BrowserDownloaderActivity.this.mo21531a(dialogInterface, bph);
                }
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                BrowserDownloaderActivity.this.finish();
            }
        });
        create.setView(inflate);
        create.show();
    }

    /* renamed from: a */
    public void mo21531a(DialogInterface dialogInterface, bph bph) {
        bpd.m18512c((Context) this, bph);
        bph.mo23335b(1);
        bpd.m18506a((Context) this, bph);
        dialogInterface.dismiss();
        Toasty.custom(this, getString(R.string.start_downloading), (Drawable) null, getResources().getColor(R.color.toast_start), 1, false, true).show();
    }

    /* renamed from: b */
    public void mo21533b(final Context context, final bph bph) {
        String str;
        this.f13660a = bph;
        this.alertDialog = new AlertDialog.Builder(context).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.already_in_list, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_file_name)).setText(bph.mo23346e());
        mo21528a(bph.mo23352h(), (ImageView) inflate.findViewById(R.id.label));
        this.fileSize = (TextView) inflate.findViewById(R.id.tv_file_size);
        this.progressBar = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        int i = 0;
        this.progressBar.setVisibility(0);
        this.f13662c = (TextView) inflate.findViewById(R.id.tv_speed);
        this.f13662c.setVisibility(0);
        int b = FileDownloadUtils.generateId(bph.mo23339c(), bph.mo23334b((Context) this));
        long d = FileDownloader.getImpl().getTotal(b);
        long c = FileDownloader.getImpl().getSoFar(b);
        long b2 = bpa.m18486b(bph.mo23334b((Context) this), c);
        if (b2 <= 0) {
            b2 = 0;
        }
        TextView textView = this.f13662c;
        if (b2 == 0) {
            str = "";
        } else {
            str = Formatter.formatFileSize(this, b2) + "/S";
        }
        textView.setText(str);
        if (d > 0 && c > 0) {
            i = (int) ((((double) c) * 100.0d) / ((double) d));
        }
        this.progressBar.setProgress(i);
        this.fileSize.setText(Formatter.formatFileSize(this, c) + "/" + Formatter.formatFileSize(this, d));
        this.alertDialog.setTitle(context.getString(R.string.already_in_list));
        this.alertDialog.setButton(-1, (CharSequence) context.getString(R.string.view).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                BrowserLogEvent.downloaderLogEvent(context, "Downloading dialog", "touch view");
                Intent intent = new Intent(context, FilesActivity.class);
                intent.setFlags(131072);
                intent.putExtra("position", 1);
                intent.putExtra("curRecordId", bph.mo23333b());
                context.startActivity(intent);
                BrowserDownloaderActivity.this.alertDialog.dismiss();
            }
        });
        this.alertDialog.setButton(-2, (CharSequence) context.getString(R.string.hide).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                BrowserDownloaderActivity.this.alertDialog.dismiss();
            }
        });
        this.alertDialog.setButton(-3, (CharSequence) context.getString(R.string.action_cancel).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                BrowserDownloaderActivity.this.alertDialog.dismiss();
                FileDownloader.getImpl().pause(FileDownloadUtils.generateId(bph.mo23339c(), bph.mo23334b(context)));
            }
        });
        this.alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                BrowserDownloaderActivity.this.finish();
            }
        });
        this.alertDialog.setView(inflate);
        this.alertDialog.show();
    }

    /* renamed from: a */
    public void mo21530a(final Context context, final String str, String str2) {
        final AlertDialog create = new AlertDialog.Builder(context).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.already_in_list, (ViewGroup) null);
        int a = bon.m18359a().mo23285a(str2);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2);
        final String a2 = bpc.m18491a(context, str, a, mimeTypeFromExtension, (String) null, "");
        ((TextView) inflate.findViewById(R.id.tv_file_name)).setText(a2);
        mo21528a(a, (ImageView) inflate.findViewById(R.id.label));
        final TextView textView = (TextView) inflate.findViewById(R.id.tv_file_size);
        textView.setText(context.getString(R.string.loading));
        new Thread(new Runnable() {
            public void run() {
                final long a = BrowserDownloaderActivity.this.m15209a(str);
                BrowserDownloaderActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        if (a > 0) {
                            textView.setText(Formatter.formatFileSize(context, a));
                        }
                    }
                });
            }
        }).start();
        create.setTitle(context.getString(R.string.create_a_download));
        create.setButton(-1, (CharSequence) context.getString(R.string.action_download).toUpperCase(), (DialogInterface.OnClickListener) null);
        create.setButton(-2, (CharSequence) context.getString(R.string.action_cancel).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                create.dismiss();
            }
        });
        create.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                BrowserDownloaderActivity.this.finish();
            }
        });
        create.setView(inflate);
        create.show();
        Button button = create.getButton(-1);
        if (button != null) {
            final String str3 = str;
            final String str4 = str2;
            final String str5 = mimeTypeFromExtension;
            final int i = a;
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (box.m18457a(BrowserDownloaderActivity.this, new box.C3987a() {
                        /* renamed from: a */
                        public void mo21376a() {
                            BrowserDownloaderActivity.this.mo21532a(create, str3, str4, str5, i, a2);
                        }
                    })) {
                        BrowserDownloaderActivity.this.mo21532a(create, str3, str4, str5, i, a2);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo21532a(DialogInterface dialogInterface, String str, String str2, String str3, int i, String str4) {
        BrowserLogEvent.downloaderLogEvent(this, "intent page", "download url = " + str);
        Logger.e("extension = " + str2 + " , mimeType = " + str3, new Object[0]);
        FileDownloader.init(getApplicationContext());
        bpd.m18506a((Context) this, bpd.m18501a(this, str, "", i, str4));
        dialogInterface.dismiss();
        Toasty.custom(this, getString(R.string.start_downloading), (Drawable) null, getResources().getColor(R.color.toast_start), 1, false, true).show();
    }

    @Subscribe(threadMode= ThreadMode.MAIN)
    public void onEventMainThread(bnu bnu) {
        String str;
        String str2 = bnu.f16007c;
        if (!TextUtils.isEmpty(str2) && this.progressBar != null && str2.equals(this.f13660a.mo23334b((Context) this))) {
            this.progressBar.setProgress((bnu.f16010f <= 0 || bnu.f16009e <= 0) ? 0 : (int) ((((double) bnu.f16009e) * 100.0d) / ((double) bnu.f16010f)));
            this.fileSize.setText(Formatter.formatFileSize(this, bnu.f16009e) + "/" + Formatter.formatFileSize(this, bnu.f16010f));
            TextView textView = this.f13662c;
            if (bnu.f16011g == 0) {
                str = "";
            } else {
                str = Formatter.formatFileSize(this, bnu.f16011g) + "/S";
            }
            textView.setText(str);
            switch (bnu.f16008d) {
                case FontsContractCompat.FontRequestCallback.FAIL_REASON_FONT_LOAD_ERROR:
                    this.alertDialog.dismiss();
                    Toasty.custom(this, getString(R.string.downloaded, new Object[]{this.f13660a.mo23346e()}), (Drawable) null, getResources().getColor(R.color.toast_finish), 1, false, true).show();
                    return;
                case -1:
                    this.alertDialog.dismiss();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void mo21528a(int i, ImageView imageView) {
        if (i != 100) {
            switch (i) {
                case 2:
                    imageView.setImageResource(R.drawable.ic_movie_black_24dp);
                    return;
                case 3:
                    imageView.setImageResource(R.drawable.ic_image_black_24dp);
                    return;
                case 4:
                    imageView.setImageResource(R.drawable.ic_audiotrack_black_24dp);
                    return;
                case 5:
                    imageView.setImageResource(R.drawable.ic_android_black_24dp);
                    return;
                case 6:
                    imageView.setImageResource(R.drawable.ic_archive_black_24dp);
                    return;
                case 7:
                    imageView.setImageResource(R.drawable.ic_description_black_24dp);
                    return;
                default:
                    imageView.setImageResource(R.drawable.ic_help_black_24dp);
                    return;
            }
        } else {
            imageView.setImageResource(R.drawable.ic_help_black_24dp);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (r7 != null) goto L_0x0046;
     */
    public long m15209aa(String r7) {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x001d }
            r2.<init>(r7)     // Catch:{ Exception -> 0x001d }
            java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x001d }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x001d }
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "identity"
            r2.setRequestProperty(r3, r4)     // Catch:{ Exception -> 0x001d }
            int r3 = r2.getContentLength()     // Catch:{ Exception -> 0x001d }
            long r3 = (long) r3
            r2.disconnect()     // Catch:{ Exception -> 0x001e }
            goto L_0x001e
        L_0x001d:
            r3 = r0
        L_0x001e:
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0023
            return r3
        L_0x0023:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0056, all -> 0x004f }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0056, all -> 0x004f }
            java.io.InputStream r7 = r1.openStream()     // Catch:{ Exception -> 0x0056, all -> 0x004f }
            int r0 = r7.available()     // Catch:{ Exception -> 0x0057, all -> 0x004a }
            if (r0 <= 0) goto L_0x0036
            long r0 = (long) r0     // Catch:{ Exception -> 0x0057, all -> 0x004a }
            long r3 = r3 + r0
            goto L_0x0044
        L_0x0036:
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0057, all -> 0x004a }
        L_0x003a:
            int r1 = r7.read(r0)     // Catch:{ Exception -> 0x0057, all -> 0x004a }
            r2 = -1
            if (r1 == r2) goto L_0x0044
            long r1 = (long) r1
            long r3 = r3 + r1
            goto L_0x003a
        L_0x0044:
            if (r7 == 0) goto L_0x005a
        L_0x0046:
            r7.close()     // Catch:{ Exception -> 0x005a }
            goto L_0x005a
        L_0x004a:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x0050
        L_0x004f:
            r7 = move-exception
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            throw r7
        L_0x0056:
            r7 = r0
        L_0x0057:
            if (r7 == 0) goto L_0x005a
            goto L_0x0046
        L_0x005a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: video.downloader.video.downloader.videodownloader.five.activity.BrowserDownloaderActivity.m15209a(java.lang.String):long");
    }
    private long m15209a(String str) {
        long j;
        InputStream inputStream;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            j = (long) httpURLConnection.getContentLength();
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            j = 0;
        }
        if (j > 0) {
            return j;
        }
        InputStream inputStream2 = null;
        try {
            inputStream = new URL(str).openStream();
            try {
                int available = inputStream.available();
                if (available <= 0) {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        j += (long) read;
                    }
                } else {
                    j += (long) available;
                }
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                inputStream2 = inputStream;
                th = th2;
                if (inputStream2 != null) {
                }
                throw th;
            }
        } catch (Exception unused4) {
            inputStream = null;
        }
        catch (Throwable th3) {
            th = th3;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused5) {
                }
            }
            //throw th;
        }
        return j;
    }


}
