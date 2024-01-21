package classesdef.browser;

import android.app.Application;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.inject.Inject;

import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4927w;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

/* renamed from: bmd */
public class bmd {
    @Inject
    public

    /* renamed from: a */
            Application f15632a;
    @Inject
    public

    /* renamed from: b */
    bpn f15633b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f15634c = this.f15632a.getString(R.string.home);

    public bmd() {
        BrowserApp.m15129g().mo21492a(this);
    }

    /* renamed from: a */
    public C4805t<String> mo23036a() {
        return C4805t.m21581a(new C4858u<String>() {
            /* renamed from: a */
            public void mo21407a(C4927w<String> wVar) {
                String str;
                String str2;
                StringBuilder sb = new StringBuilder("<!DOCTYPE html><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta content=\"en-us\" http-equiv=\"Content-Language\" /><meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\" /><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"><title>" + bmd.this.f15634c + "</title></head><style>body{background:#f5f5f5;text-align:center;margin:0px;}#search_input{height:35px; width:100%;outline:none;border:none;font-size: 16px;background-color:transparent;}span { display: block; overflow: hidden; padding-left:5px;vertical-align:middle;}.search_bar{display:table;vertical-align:middle;width:90%;height:35px;max-width:500px;margin:0 auto;background-color:#fff;box-shadow: 0px 2px 3px rgba( 0, 0, 0, 0.25 );font-family: Arial;color: #444;-moz-border-radius: 2px;-webkit-border-radius: 2px;border-radius: 2px;}#search_submit{outline:none;height:37px;float:right;color:#404040;font-size:16px;font-weight:bold;border:none;background-color:transparent;}.outer { display: table; position: absolute; height: 100%; width: 100%;}.middle { display: table-cell; vertical-align: middle;}.inner { margin-left: auto; margin-right: auto; margin-bottom:10%; width: 100%;}img.smaller{width:50%;max-width:300px;}.box { vertical-align:middle;position:relative; display: block; margin: 10px;padding-left:10px;padding-right:10px;padding-top:5px;padding-bottom:5px; background-color:#fff;box-shadow: 0px 3px rgba( 0, 0, 0, 0.1 );font-family: Arial;color: #444;font-size: 12px;-moz-border-radius: 2px;-webkit-border-radius: 2px;border-radius: 2px;}</style><body> <div class=\"outer\"><div class=\"middle\"><div class=\"inner\"><img class=\"smaller\" src=\"");
                switch (bmd.this.f15633b.mo23433F()) {
                    case 0:
                        str2 = "file:///android_asset/google.png";
                        str = "https://www.google.com/search?client=lightning&ie=UTF-8&oe=UTF-8&q=";
                        break;
                    case 1:
                        str2 = "file:///android_asset/google.png";
                        str = "https://www.google.com/search?client=lightning&ie=UTF-8&oe=UTF-8&q=";
                        break;
                    case 2:
                        str2 = "file:///android_asset/ask.png";
                        str = "http://www.ask.com/web?qsrc=0&o=0&l=dir&qo=LightningBrowser&q=";
                        break;
                    case 3:
                        str2 = "file:///android_asset/bing.png";
                        str = "https://www.bing.com/search?q=";
                        break;
                    case 4:
                        str2 = "file:///android_asset/yahoo.png";
                        str = "https://search.yahoo.com/search?p=";
                        break;
                    case 5:
                        str2 = "file:///android_asset/startpage.png";
                        str = "https://startpage.com/do/search?language=english&query=";
                        break;
                    case 6:
                        str2 = "file:///android_asset/startpage.png";
                        str = "https://startpage.com/do/m/mobilesearch?language=english&query=";
                        break;
                    case 7:
                        str2 = "file:///android_asset/duckduckgo.png";
                        str = "https://duckduckgo.com/?t=lightning&q=";
                        break;
                    case 8:
                        str2 = "file:///android_asset/duckduckgo.png";
                        str = "https://duckduckgo.com/lite/?t=lightning&q=";
                        break;
                    case 9:
                        str2 = "file:///android_asset/baidu.png";
                        str = "https://www.baidu.com/s?wd=";
                        break;
                    case 10:
                        str2 = "file:///android_asset/yandex.png";
                        str = "https://yandex.ru/yandsearch?lr=21411&text=";
                        break;
                    default:
                        str2 = "file:///android_asset/google.png";
                        str = "https://www.google.com/search?client=lightning&ie=UTF-8&oe=UTF-8&q=";
                        break;
                }
                sb.append(str2);
                sb.append("\" ></br></br><form onsubmit=\"return search()\" class=\"search_bar\" autocomplete=\"off\"><input type=\"submit\" id=\"search_submit\" value=\"Search\" ><span><input class=\"search\" type=\"text\" value=\"\" id=\"search_input\" ></span></form></br></br></div></div></div><script type=\"text/javascript\">function search(){if(document.getElementById(\"search_input\").value != \"\"){window.location.href = \"");
                sb.append(str);
                sb.append("\" + document.getElementById(\"search_input\").value;document.getElementById(\"search_input\").value = \"\";}return false;}</script></body></html>");
                File file = new File(bmd.this.f15632a.getFilesDir(), "homepage.html");
                FileWriter fileWriter = null;
                try {
                    FileWriter fileWriter2 = new FileWriter(file, false);
                    try {
                        fileWriter2.write(sb.toString());
                        bqw.m19016a((Closeable) fileWriter2);
                    } catch (IOException e) {
                        e = e;
                        fileWriter = fileWriter2;
                        try {
                            e.printStackTrace();
                            bqw.m19016a((Closeable) fileWriter);
                            wVar.mo25115a("file://" + file);
                        } catch (Throwable th) {
                            th = th;
                            bqw.m19016a((Closeable) fileWriter);
                            //throw th;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileWriter = fileWriter2;
                        bqw.m19016a((Closeable) fileWriter);
                      //  throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    bqw.m19016a((Closeable) fileWriter);
                    wVar.mo25115a("file://" + file);
                }
                wVar.mo25115a("file://" + file);
            }
        });
    }
}
