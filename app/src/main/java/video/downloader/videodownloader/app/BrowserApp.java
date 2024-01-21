package video.downloader.videodownloader.app;

import android.app.Activity;
import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;

import android.util.Log;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDexApplication;

import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadHelper;
import com.mopub.common.MoPubBrowser;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import classesdef.browser.C0000a;
import classesdef.browser.C4740s;
import classesdef.browser.bmg;
import classesdef.browser.bmi;
import classesdef.browser.bmj;
import classesdef.browser.bmk;
import classesdef.browser.bnc;
import classesdef.browser.bpn;
import classesdef.browser.bqk;
import classesdef.browser.bql;
import okhttp3.OkHttpClient;


public abstract class BrowserApp extends MultiDexApplication {
//2021-05-07 00:43:42.723 14535-14668/hdplayer.xdplayer.videoplayer E/jSONObject_1: __{"method_0":"User-Agent","method_1":"Mozilla\/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit\/537.36 (KHTML, like Gecko) Chrome\/62.0.3202.89 Safari\/537.36","method_2":"xvideos.com\/video","method_3":"xnxx.com\/video","method_4":"pornhub.com\/view_video","method_5":"redtube.com\/","method_6":"youporn.com\/watch\/","method_7":"xhamster.com\/videos","method_8":"pornhubpremium.com\/view_video","method_9":"liveleak.com","method_10":"youjizz.com\/videos\/","method_11":"tube8.com"}
//2021-05-07 00:51:11.725 16524-16792/hdplayer.xdplayer.videoplayer E/jSONObject_1: __{"method_0":"User-Agent","method_1":"Mozilla\/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit\/537.36 (KHTML, like Gecko) Chrome\/62.0.3202.89 Safari\/537.36","method_2":"xvideos.com\/video","method_3":"xnxx.com\/video","method_4":"pornhub.com\/view_video","method_5":"redtube.com\/","method_6":"youporn.com\/watch\/","method_7":"https?:\/\/\\w{0,5}.?(xhamster|openxh|unlockxh|xhtotal|xhfull|xhofficial|xhlocal|xhaccess|xhcontent)\\d{0,3}.?\\w{0,5}\/videos.*","method_8":"pornhubpremium.com\/view_video","method_9":"liveleak.com","method_10":"youjizz.com\/videos\/","method_11":"tube8.com","method_12":"spankbang.com","method_13":"https?:\/\/\\w{0,5}.?tiktok.com\/.*","method_14":"javascript:if(document.querySelector('main')||document.querySelector('.swiper-slide-active')||document.querySelector('.videoBox2')){if(document.querySelector('.swiper-slide-active')){var url = document.querySelector('.swiper-slide-active video').src;}else{var url = document.querySelector('video').src;}GetPear.getTikTokUrl(url);}","method_15":"https?:\/\/\\w{0,5}.?onlyfans.com\/.*","method_16":"javascript:function setStyle(obj,css){for(var attr in css){obj.style[attr]=css[attr];}};function styledata(topnum){return{'display':'block','background':\"url('data:image\/png;base64,iVBORw0KGgoAAAANSUhEUgAAAHYAAAB2CAMAAAAqeZcjAAAArlBMVEUAAAD\/OTn\/ODj\/ODj\/VVX\/ODj\/ODj\/ODj\/OTn\/OTn\/ODj\/ODj\/PDz\/Rkb\/Ozv\/Pj7\/ODj\/OTn\/ODj\/ODj\/OTn\/OTn\/OTn\/OTn\/OTn\/OTn\/OTn\/OTn\/ODj\/ODj\/Ojr\/PT3\/PT3\/Q0P\/VVX\/ODj\/ODj\/\/\/\/\/0ND\/WFj\/iIj\/8fH\/+\/v\/c3P\/QED\/3Nz\/9vb\/Ozv\/t7f\/SEj\/ycn\/fn7\/ZGT\/1tb\/wcH\/bGz\/jo7\/m5vNeQRzAAAAJHRSTlMA\/MeeBPPf0biloogoCx4h+e3s49ypinhvY1lRTUQ5LhkTBtUAYTEFAAADEUlEQVRo3t3bWVfaUBSG4Z3EDEAS5llE8dNSp6rV1v7\/P9a1vHCTFQpn3Cv0ufXiXUBikpN9SNcmX06jLEyTQa83SNIwi6bLfEM+deetUYA9glFr3iUfikWU4KAkWhSOo6t2DAVxe+WuWXaGUDbslE6ieRRASxDl1tH1OIC2YLy2il62YKh1aRw9m8UwFs\/OzKoXKaykFyYfdQJrE+0PXIZwINQ8mc77cKJ\/rlPtwJmO+s\/ahkNtxR+4yOBUpnSBuArhWHilUL2Gc9dHu0UID8LiyNGUwYvs8HHVhidtrfNV5Pw9h0f\/\/H9V9uFRv9xfPQvhVbj\/sJrAs8neqzq8u6hXz1J4l9a\/5hkEzGr3iDEExJdU1YKIVrW6hobX25p7KFpXsmNo+H5Ts4Wi8W41D6SyQU4sglQWEVfLAJDKBmXleieSrV4Bh2Des8OvFQIw\/1msqncyIlm+vyliMIFsXHxmF2ASWSyqJ61Elk\/dBEwkm3yu6IHJZNElojmYUHZevdL6z\/JVdwQmlB0RbQIwoWywoRxMKoucllDx8m3HUz37Z\/fvDzhmSVOoeOPUUc84akoRdLv2VUSUwW33+QeOyyiEot9PzqoIKYXL7i+lKlJKoNu1ryKhATS6d26qGFAPGu7vnFTR46x191W5ih5\/ybbd1wcoG\/Ahpdy1ryKhFJp+3llXkVIIZt691aoipAxMuWtZRaZ1u8pduyqi2oXPoPuuW8WUljCxtapiSTmMbG2qyDVv4erd9xdoCzZEI5j5+Kw+GlQxslkI+zCtomXyMMJd\/So\/jHRhbGtWRZcfNAUl\/FgtKeJFBEkLXjIRFBe8QCSozcthklbqi3\/PtxrecMhQY6nz8UbDPQ7p7CzsymWDkr5EctmosmgvlQ1y2jGWyo5p11rqSF434fWT2Mu2ZrxaFHqR2pTXxhIvyZs0EuB9AKJZ4x5+h1uaN8rjcXCpiWNavobSmjqC52PgsMnjlY6HSZs\/OutuUPg0xqKdDIGf0si75YD\/6W1nENy8UdfV3Kpy2htzdLch\/QebrtxuMfsLfN0B74AQVOUAAAAASUVORK5CYII=')\",'z-index':'4','width':'40px','height':'40px','position':'absolute','background-size':'100%','bottom':topnum+'px','right':'35px'}}var post=document.querySelectorAll('.b-post');for(var i=0;i<post.length;i++){(function(i){var btnprev=post[i].querySelector('.swiper-button-prev'),btnnext=post[i].querySelector('.swiper-button-next');if(btnprev){btnprev.style.cssText='width: 36px;';};if(btnnext){btnnext.style.cssText='width: 36px;';};var posttitletag=post[i].querySelector('.b-post__text p');if(posttitletag){var posttitle=posttitletag.innerText;}else{var posttitle='post';};var videodiv=post[i].querySelectorAll('.b-post__media__item-inner');for(var j=0;j<videodiv.length;j++){(function(j){if(videodiv[j]&&videodiv[j].querySelector('i.downbtn')==null){var btntag=document.createElement('i');btntag.className='downbtn';setStyle(btntag,styledata(35));videodiv[j].appendChild(btntag);btntag.onclick=function(e){var weburl=window.location.href;var postvideo=videodiv[j].querySelector('.video-wrapper');if(postvideo){window.GetPear.torch();if(videodiv[j].querySelector('video')==null){videodiv[j].querySelector('.video-js-placeholder-wrapper').click();}setTimeout(function(){var videodata={'fatherUrl':weburl,'title':posttitle,'imageUrl':videodiv[j].querySelector('video').ge

    private static C3546a f13596c;
    @Inject
     bpn f13597a;
    @Inject
     bmj f13598b;

    public static boolean m15130h() {
        return true;
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(Build.VERSION.SDK_INT < 21);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate() {
        super.onCreate();
        try {
            Logger.init().logLevel(LogLevel.NONE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            OkHttpClient.Builder aVar = new  OkHttpClient.Builder();
            aVar.connectTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.readTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.writeTimeout(30000, TimeUnit.MILLISECONDS);
            aVar.retryOnConnectionFailure(true);
            FileDownloader.setupOnApplicationOnCreate((Application) this)
                    .connectionCreator((FileDownloadHelper.ConnectionCreator) new C0000a.C0001a(aVar))
                    .connectionCountAdapter((FileDownloadHelper.ConnectionCountAdapter) new bnc(this));
        } catch (Exception e2) {
            FileDownloader.init(getApplicationContext());
            e2.printStackTrace();
        }
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                FileDownloader.getImpl().pauseAll();
                if (defaultUncaughtExceptionHandler != null) {
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                } else {
                    System.exit(2);
                }
            }
        });
        f13596c = C3554i.m15179b().mo21523a(new C3547b(this)).mo21522a();
        f13596c.mo21503a(this);
        C4740s.m21405c().mo322a(new Runnable() {
            public void run() {
                List<bmg> a = bmk.m18038a(BrowserApp.this);
                if (!a.isEmpty()) {
                    BrowserApp.this.f13598b.mo23060a(a).mo21839a(C4740s.m21407e()).mo23839a();
                } else if (BrowserApp.this.f13598b.mo23069d() == 0) {
                    BrowserApp.this.f13598b.mo23060a(bmi.m18024a(BrowserApp.this)).mo21839a(C4740s.m21407e()).mo23839a();
                }
            }
        });
        if (!m15130h() && Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        registerActivityLifecycleCallbacks(new bqk.C4042a() {
            public void onActivityDestroyed(Activity activity) {
                Log.d("BrowserApp", "Cleaning up after the Android framework");
                bqk.m18951a(activity, BrowserApp.this);
            }
        });
    }

    /* renamed from: g */
    public static C3546a m15129g() {
        bql.m18952a(f13596c);
        return f13596c;
    }

    /* renamed from: a */
    public static void m15128a(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(MoPubBrowser.DESTINATION_URL_KEY, str));
    }
}
