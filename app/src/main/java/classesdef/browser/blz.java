package classesdef.browser;

import android.app.Application;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import classesdef.browser.download.bmn;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4892v;
import classesdef.browser.tab.C4927w;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

/* renamed from: blz */
public final class blz {
    @Inject
    public

    /* renamed from: a */
            Application f15609a;
    @Inject
    public

    /* renamed from: b */
    bpn f15610b;
    @Inject
    public

    /* renamed from: c */
            bmn f15611c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public File f15612d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f15613e = this.f15609a.getString(R.string.downloads);

    public blz() {
        BrowserApp.m15129g().mo21490a(this);
    }

    /* renamed from: a */
    public C4805t<String> mo23027a() {
        return C4805t.m21581a(new C4858u<String>() {
            /* renamed from: a */
            public void mo21407a(C4927w<String> wVar) {
                File unused = blz.this.f15612d = blz.this.f15609a.getFilesDir();
                blz.this.m17896b();
                File file = new File(blz.this.f15612d, "downloads.html");
                wVar.mo25115a("file://" + file);
                wVar.mo23729a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17896b() {
        this.f15611c.mo23097b().mo23840a(new C4892v<List<bml>>() {
            /* renamed from: a */
            public void mo21366a(List<bml> list) {
                bql.m18952a(list);
                String n = blz.this.f15610b.mo23475n();
                StringBuilder sb = new StringBuilder("<!DOCTYPE html><html xmlns=http://www.w3.org/1999/xhtml>\n<head>\n<meta content=en-us http-equiv=Content-Language />\n<meta content='text/html; charset=utf-8' http-equiv=Content-Type />\n<meta name=viewport content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no'>\n<title>" + blz.this.f15613e + "</title></head><style>body{background:#f5f5f5;}.box{vertical-align:middle;position:relative; display: block; margin: 10px;padding:10px; background-color:#fff;box-shadow: 0px 2px 4px rgba( 0, 0, 0, 0.25 );font-family: Arial;color: #444;font-size: 12px;-moz-border-radius: 2px;-webkit-border-radius: 2px;border-radius: 2px;}.box a { width: 100%; height: 100%; position: absolute; left: 0; top: 0;}.black {color: black;font-size: 15px;font-family: Arial; white-space: nowrap; overflow: hidden;margin:auto; text-overflow: ellipsis; -o-text-overflow: ellipsis; -ms-text-overflow: ellipsis;}.font {color: gray;font-size: 10px;font-family: Arial; white-space: nowrap; overflow: hidden;margin:auto; text-overflow: ellipsis; -o-text-overflow: ellipsis; -ms-text-overflow: ellipsis;}</style><body><div id='content'>");
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bml bml = list.get(i);
                    sb.append("<div class=box><a href='");
                    sb.append("file://");
                    sb.append(n);
                    sb.append("/");
                    sb.append(bml.mo23088b());
                    sb.append("'></a><p class='black'>");
                    sb.append(bml.mo23088b());
                    if (!bml.mo23090c().isEmpty()) {
                        sb.append(" [");
                        sb.append(bml.mo23090c());
                        sb.append("]");
                    }
                    sb.append("</p><p class='font'>");
                    sb.append(bml.mo23086a());
                    sb.append("</p></div>");
                }
                sb.append("</div></body></html>");
                FileWriter fileWriter = null;
                try {
                    FileWriter fileWriter2 = new FileWriter(new File(blz.this.f15612d, "downloads.html"), false);
                    try {
                        fileWriter2.write(sb.toString());
                        bqw.m19016a((Closeable) fileWriter2);
                    } catch (IOException e) {
                        FileWriter fileWriter3 = fileWriter2;
                        e = e;
                        fileWriter = fileWriter3;
                        try {
                            e.printStackTrace();
                            bqw.m19016a((Closeable) fileWriter);
                        } catch (Throwable th) {
                            th = th;
                            bqw.m19016a((Closeable) fileWriter);
                            //throw th;
                        }
                    } catch (Throwable th) {
                        FileWriter fileWriter4 = fileWriter2;
                        th = th;
                        fileWriter = fileWriter4;
                        bqw.m19016a((Closeable) fileWriter);
                     //   throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    bqw.m19016a((Closeable) fileWriter);
                }
            }
        });
    }
}
