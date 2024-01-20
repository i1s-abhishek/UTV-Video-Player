package classesdef.xdplayer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.abhishek.xplayer.ad.MopubIntertitialAd;
import com.abhishek.xplayer.application.MyApplication;
import com.us.rateus.AppRate;
import com.us.rateus.general.RatingInterface;

import classesdef.ads.RemoteCloudConfig;
import classesdef.ads.atd;
import classesdef.inplayer.SharedPrefrence;
import classesdef.inplayer.awz;

/* renamed from: atg */
public class atg {
    /* renamed from: a */
    public static void m18405a(final Activity activity) {
        int i;

        if (!PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("hasRated", false)
                && (i = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getInt("showRateCount", 0)) < 3) {
            final int a = RemoteCloudConfig.m18214a();
            if (a == 1 || a == 2) {
                if (System.currentTimeMillis() >= Math.max(MopubIntertitialAd.createInstance1().mo16970h(), MopubIntertitialAd.createInstance2().mo16970h()) + 60000) {
                    if (((long) atd.m18390b("wcHRI563", 0)) >= (i == 0 ? 1 : i == 1 ? 2 : 6)) {
                        final int i2 = i + 1;
                        MyApplication.myApplication().runnableDelay((Runnable) new Runnable() {
                            public void run() {
                                if (!activity.isFinishing()) {
                                    if (a != 1) {
                                       atg.m18407b(activity, SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false));
                                    }
                                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit();
                                    edit.putInt("showRateCount", i2);
                                    edit.remove("wcHRI563");
                                    edit.apply();
                                }
                            }
                        }, 500);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m18407b(final Activity activity, boolean z) {
        AppRate dVar = new AppRate(activity, true, z);
        dVar.mo20102a(false);
        dVar.mo20101a(activity, new RatingInterface() {
            /* renamed from: a */
            public void mo23216a(Throwable th) {
            }

            /* renamed from: b */
            public void mo23218b(int i) {
            }

            /* renamed from: a */
            public void mo23213a() {
                SharedPrefrence.m7392a((Context) activity, true);
                LogEvents.m18486a("Rate", "rateUs", "");
                PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean("hasRated", true).apply();
            }

            /* renamed from: b */
            public void mo23217b() {
                SharedPrefrence.m7392a((Context) activity, true);
                LogEvents.m18486a("Rate", "haveSendFeedback", "");
                awz.m7244c(activity);
            }

            /* renamed from: c */
            public void mo23219c() {
                SharedPrefrence.m7392a((Context) activity, true);
                LogEvents.m18486a("Rate", "manualFeedback", "");
                awz.m7244c(activity);
            }

            /* renamed from: a */
            public void mo23214a(int i) {
                LogEvents.m18486a("Rate", "cancelDialog", "");
            }

            /* renamed from: a */
            public void mo23215a(String str, String str2, String str3) {
                LogEvents.m18492b(str, str2 + "/" + str3);
            }
        }, true);
    }
}
