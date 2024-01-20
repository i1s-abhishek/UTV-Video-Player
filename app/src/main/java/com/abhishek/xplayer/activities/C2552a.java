package com.abhishek.xplayer.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.HashMap;

import classesdef.xdplayer.axx;
import classesdef.xdplayer.AllPermission;
import classesdef.xdplayer.LogEvents;

public class C2552a {

    public static boolean m11684a(Activity activity, int i) {
        if (!AllPermission.m7381a(activity.getApplicationContext(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
            activity.startActivityForResult(new Intent(activity, SimpleFragmentActivity.class).putExtra("_mode", 2), i);
            return false;
        } else {
            return true;
        }
    }


    /* renamed from: a */
    public static Bundle m11683a(Context context, Intent intent) {
        Uri uri;
        HashMap hashMap;
        if (intent != null) {
            String action = intent.getAction();
            Bundle bundle = new Bundle();
            if ("android.intent.action.SEND".equals(action)) {
                Bundle extras = intent.getExtras();
                uri = (extras == null || !extras.containsKey("android.intent.extra.STREAM")) ? null : (Uri) extras.getParcelable("android.intent.extra.STREAM");
                LogEvents.m18491b("Entry/Send");
            } else if ("android.intent.action.VIEW".equals(action) || "android.intent.action.EDIT".equals(action)) {
                Uri data = intent.getData();
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    Object obj = extras2.get("title");
                    if (obj instanceof CharSequence) {
                        bundle.putString("i3xBVEHM", obj.toString());
                    } else {
                        Object obj2 = extras2.get("filename");
                        if (obj2 instanceof CharSequence) {
                            bundle.putString("i3xBVEHM", obj2.toString());
                        }
                    }
                    Object obj3 = extras2.get("android.media.intent.extra.HTTP_HEADERS");
                    if (obj3 instanceof Bundle) {
                        hashMap = new HashMap();
                        Bundle bundle2 = (Bundle) obj3;
                        for (String str : bundle2.keySet()) {
                            Object obj4 = bundle2.get(str);
                            if (obj4 instanceof CharSequence) {
                                hashMap.put(str, obj4.toString());
                            }
                        }
                    } else {
                        hashMap = null;
                    }
                    Object obj5 = extras2.get("headers");
                    if (obj5 instanceof String[]) {
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        String[] strArr = (String[]) obj5;
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            if (i2 >= strArr.length) {
                                break;
                            }
                            hashMap.put(strArr[i], strArr[i2]);
                            i += 2;
                        }
                    }
                    bundle.putSerializable("cafPyw9N", hashMap);
                }
                LogEvents.m18491b("Entry/View");
                uri = data;
            } else {
                uri = null;
            }
            if (uri != null) {
                bundle.putParcelable("6bjQrUMY", uri);
                bundle.putString("a6IfgqKJ", axx.m7454a(context, uri));
                return bundle;
            }
        }
        return null;
    }
}
