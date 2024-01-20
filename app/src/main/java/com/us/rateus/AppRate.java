package com.us.rateus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.us.rateus.general.RateConstant;
import com.us.rateus.general.RatingInterface;

import hdplayer.vlcplayer.videoplayer.R;

/* renamed from: com.zjsoft.rate.d */
public class AppRate {

    /* renamed from: a */
    public static String f10503a = "com.android.vending";

    /* renamed from: b */
    public static String f10504b = "com.huawei.appmarket";

    /* renamed from: c */
    public static String f10505c = "com.amazon.venezia";

    /* renamed from: d */
    public static String f10506d = "com.oppo.market";

    /* renamed from: e */
    public static String f10507e = "com.bbk.appstore";

    /* renamed from: f */
    public static String f10508f = "com.sec.android.app.samsungapps";

    /* renamed from: g */
    public static String f10509g = "com.xiaomi.market";

    /* renamed from: h */
    public static String f10510h = "";

    /* renamed from: i */
    RateConstant f10511i;

    public AppRate(Context context, boolean z, boolean z2) {
        this.f10511i = null;
        this.f10511i = new RateConstant();
        this.f10511i.f14666a = m13021b(context);
        this.f10511i.f14667b = m13020a(context);
        RateConstant avo = this.f10511i;
        avo.f14673h = z;
        avo.f14668c = z2;
        avo.f14674i = "https://play.google.com/store/apps/details?id=" + context.getPackageName();
        RateConstant avo2 = this.f10511i;
        avo2.f14675j = f10503a;
        avo2.f14669d = context.getResources().getString(R.string.lib_rate_dialog_tip);
    }

    /* renamed from: a */
    public void mo20102a(boolean z) {
        this.f10511i.f14676k = z;
    }

    /* renamed from: a */
    public void mo20101a(Context context, RatingInterface avq, boolean z) {
        new RatingDialog().mo20093a(context, this.f10511i, avq, z);
    }

    /* renamed from: a */
    private boolean m13020a(Context context) {
        return (context.getApplicationInfo().flags & 4194304) == 4194304;
    }

    /* renamed from: b */
    private boolean m13021b(Context context) {
        try {
            String lowerCase = context.getResources().getConfiguration().locale.getLanguage().toLowerCase();
            if (lowerCase.equals("ar") || lowerCase.equals("iw") || lowerCase.equals("fa") || lowerCase.equals("ur")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public static void m13019a(Context context, RateConstant avo) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(avo.f14674i));
            if (!TextUtils.isEmpty(avo.f14675j)) {
                intent.setPackage(avo.f14675j);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(avo.f14674i));
                intent2.setFlags(268435456);
                context.startActivity(intent2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
