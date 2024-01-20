package classesdef.browser;

import android.app.Application;
import android.util.Log;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4892v;
import classesdef.browser.tab.C4927w;
import video.downloader.videodownloader.app.BrowserApp;

/* renamed from: bmb */
public class bmb {
    @Inject
    public

    /* renamed from: a */
            Application f15623a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final String f15624b ="History";// this.f15623a.getString(R.string.af);

    public bmb() {
        BrowserApp.m15129g().mo21491a(this);
    }

    /* renamed from: a */
    public C4805t<String> mo23031a() {
        return C4805t.m21581a(new C4858u<String>() {
            /* renamed from: a */
            public void mo21407a(final C4927w<String> wVar) {
                final StringBuilder sb = new StringBuilder("<!DOCTYPE html><html xmlns=http://www.w3.org/1999/xhtml>\n<head>\n<meta content=en-us http-equiv=Content-Language />\n<meta content='text/html; charset=utf-8' http-equiv=Content-Type />\n<meta name=viewport content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no'>\n<title>" + bmb.this.f15624b + "</title></head><style>body,html {margin: 0px; padding: 0px;}.box { vertical-align:middle;position:relative; display: block; margin: 0px;padding-left:14px;padding-right:14px;padding-top:9px;padding-bottom:9px; background-color:#fff;border-bottom: 1px solid #d2d2d2;font-family: Arial;color: #444;font-size: 12px;}.box a { width: 100%; height: 100%; position: absolute; left: 0; top: 0;}.black {color: black;font-size: 15px;font-family: Arial; white-space: nowrap; overflow: hidden;margin:auto; text-overflow: ellipsis; -o-text-overflow: ellipsis; -ms-text-overflow: ellipsis;}.font {color: gray;font-size: 10px;font-family: Arial; white-space: nowrap; overflow: hidden;margin:auto; text-overflow: ellipsis; -o-text-overflow: ellipsis; -ms-text-overflow: ellipsis;}</style><body><div id=\"content\">");
                bmq.m18073b().mo23840a(new C4892v<List<bmg>>() {
                    /* renamed from: a */
                    public void mo21366a(List<bmg> list) {
                        FileWriter fileWriter;
                        IOException e;
                        bql.m18952a(list);
                        for (bmg next : list) {
                            sb.append("<div class=box><a href='");
                            sb.append(next.mo23052e());
                            sb.append("'></a><p class='black'>");
                            sb.append(next.mo23054f());
                            sb.append("</p><p class='font'>");
                            sb.append(next.mo23052e());
                            sb.append("</p></div>");
                        }
                        sb.append("</div></body></html>");
                        File file = new File(bmb.this.f15623a.getFilesDir(), "history.html");
                        try {
                            fileWriter = new FileWriter(file, false);
                            try {
                                fileWriter.write(sb.toString());
                            } catch (IOException e2) {
                                e = e2;
                            }
                        } catch (IOException e3) {
                            IOException iOException = e3;
                            fileWriter = null;
                            e = iOException;
                            try {
                                Log.e("HistoryPage", "Unable to write history page to disk", e);
                                bqw.m19016a((Closeable) fileWriter);
                                wVar.mo25115a("file://" + file);
                                wVar.mo23729a();
                            } catch (Throwable th) {
                                th = th;
                                bqw.m19016a((Closeable) fileWriter);
                               // throw th;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileWriter = null;
                            bqw.m19016a((Closeable) fileWriter);
                          //  throw th;
                        }
                        bqw.m19016a((Closeable) fileWriter);
                        wVar.mo25115a("file://" + file);
                        wVar.mo23729a();
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public static C3659b m17912a(final Application application) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                File file = new File(application.getFilesDir(), "history.html");
                if (file.exists()) {
                    file.delete();
                }
                eVar.mo23729a();
            }
        });
    }
}
