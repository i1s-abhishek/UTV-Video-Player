package classesdef.browser;

import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4892v;
import classesdef.browser.tab.C4927w;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

/* renamed from: blx */
public final class blx {
    @Inject
    public

    /* renamed from: a */
            Application f15597a;
    @Inject
    public

    /* renamed from: b */
    bmj f15598b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public File f15599c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public File f15600d;

    /* renamed from: e */
    private final Bitmap f15601e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final String f15602f = this.f15597a.getString(R.string.action_bookmarks);

    public blx(Activity activity) {
        BrowserApp.m15129g().mo21489a(this);
        this.f15601e = bqt.m18990a(activity, R.drawable.ic_downloader_folder, false);
    }

    /* renamed from: a */
    public C4805t<String> mo23023a() {
        return C4805t.m21581a(new C4858u<String>() {
            /* renamed from: a */
            public void mo21407a(C4927w<String> wVar) {
                File unused = blx.this.f15600d = blx.this.f15597a.getCacheDir();
                File unused2 = blx.this.f15599c = blx.this.f15597a.getFilesDir();
                blx.this.m17882b();
                blx.this.m17879a((String) null);
                File file = new File(blx.this.f15599c, "bookmarks.html");
                wVar.mo25115a("file://" + file);
                wVar.mo23729a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17882b() {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(this.f15600d, "folder.png"));
            try {
                this.f15601e.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                this.f15601e.recycle();
                bqw.m19016a((Closeable) fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                bqw.m19016a((Closeable) fileOutputStream2);
               // throw th;
            }
        } catch (FileNotFoundException e) {
            e = e;
            e.printStackTrace();
            bqw.m19016a((Closeable) fileOutputStream);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17879a(final String str) {
        this.f15598b.mo23070d(str).mo23840a(new C4892v<List<bmg>>() {
            /* renamed from: a */
            public void mo21366a(List<bmg> list) {
                File file;
                FileWriter fileWriter;
                IOException e;
                bql.m18952a(list);
                if (str == null || str.isEmpty()) {
                    file = new File(blx.this.f15599c, "bookmarks.html");
                } else {
                    file = new File(blx.this.f15599c, str + '-' + "bookmarks.html");
                }
                StringBuilder sb = new StringBuilder("<!DOCTYPE html><html xmlns=http://www.w3.org/1999/xhtml>\n<head>\n<meta content=en-us http-equiv=Content-Language />\n<meta content='text/html; charset=utf-8' http-equiv=Content-Type />\n<meta name=viewport content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no'>\n<title>" + blx.this.f15602f + "</title>\n</head>\n<style>body{background: #E5E5E5; padding-top: 5px;max-width:100%;min-height:100%}#content{width:100%;max-width:800px;margin:0 auto;text-align:center}.box{vertical-align:middle;text-align:center;position:relative;display:inline-block;height:45px;width:150px;margin:6px;padding:4px;background-color:#fff;border: 1px solid #d2d2d2;border-top-width: 0;border-bottom-width: 2px;font-family:Arial;color:#444;font-size:12px;-moz-border-radius:2px;-webkit-border-radius:2px;border-radius:2px}.box-content{height:25px;width:100%;vertical-align:middle;text-align:center;display:table-cell}p.ellipses{width:130px;font-size: small;font-family: Arial, Helvetica, 'sans-serif';white-space:nowrap;overflow:hidden;text-align:left;vertical-align:middle;margin:auto;text-overflow:ellipsis;-o-text-overflow:ellipsis;-ms-text-overflow:ellipsis}.box a{width:100%;height:100%;position:absolute;left:0;top:0}img{vertical-align:middle;margin-right:10px;width:20px;height:20px;}.margin{margin:10px}</style>\n<body><div id=content>");
                String str = "file://" + blx.this.f15600d + '/' + "folder.png";
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bmg bmg = list.get(i);
                    sb.append("<div class=box><a href='");
                    if (bmg.mo23055g()) {
                        File file2 = new File(blx.this.f15599c, bmg.mo23054f() + '-' + "bookmarks.html");
                        sb.append("file://");
                        sb.append(file2);
                        sb.append("'></a>\n<div class=margin>\n<div class=box-content>\n<p class=ellipses>\n<img src='");
                        sb.append(str);
                        blx.this.m17879a(bmg.mo23054f());
                    } else {
                        sb.append(bmg.mo23052e());
                        sb.append("'></a>\n<div class=margin>\n<div class=box-content>\n<p class=ellipses>\n<img src='");
                        sb.append("https://www.google.com/s2/favicons?domain=");
                        sb.append(bmg.mo23052e());
                    }
                    sb.append("' />");
                    sb.append(bmg.mo23054f());
                    sb.append("</p></div></div></div>");
                }
                sb.append("</div></body></html>");
                try {
                    fileWriter = new FileWriter(file, false);
                    try {
                        fileWriter.write(sb.toString());
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (IOException e3) {
                    fileWriter = null;
                    e = e3;
                    try {
                        e.printStackTrace();
                        bqw.m19016a((Closeable) fileWriter);
                    } catch (Throwable th) {
                        th = th;
                        bqw.m19016a((Closeable) fileWriter);
                      //  throw th;
                    }
                } catch (Throwable th) {
                    fileWriter = null;
                    th = th;
                    bqw.m19016a((Closeable) fileWriter);
                    //throw th;
                }
                bqw.m19016a((Closeable) fileWriter);
            }
        });
    }
}
