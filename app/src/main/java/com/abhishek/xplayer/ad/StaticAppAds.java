package com.abhishek.xplayer.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mopub.common.util.Views;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

import classesdef.inplayer.awt;
import classesdef.xdplayer.ServerConfigSharedPrefrence;
import classesdef.xdplayer.axy;
import hdplayer.vlcplayer.videoplayer.R;



public class StaticAppAds {

    
    private static LinkedList<nodeApp> linkedList1 = new LinkedList<>();

    
    private static LinkedList<nodeApp> linkedList2 = new LinkedList<>();

    
    public static View create(Context context, int layout) {
        LinkedList<nodeApp> linkedList = m10449a(context);
        Log.e("linkedlistis0","empty"+String.valueOf( linkedList.size()));
        Log.e("linkedlistis1","empty"+String.valueOf( linkedList1.size()));
        Log.e("linkedlistis2","empty"+String.valueOf( linkedList2.size()));
        if (linkedList.isEmpty()) {
            return null;
        }
        return setAdView(linkedList.remove(new Random().nextInt(linkedList.size())), context, layout);
    }
    public static void removeSelfListedAD(View view) {
        if (view != null && Boolean.TRUE.equals(view.getTag(R.id.tagID_self_list_ad_flag))) {
            Views.removeFromParent(view);
        }
    }

    private static View setAdView(final nodeApp aVar, final Context context, int layout) {
        View inflate = LayoutInflater.from(context).inflate(layout, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.admob_native_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.admob_native_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.admob_native_desc);
        TextView textView3 = (TextView) inflate.findViewById(R.id.admob_native_btn);
        if (aVar.app_icon != null) {
            Glide.with(context).load(aVar.app_icon).into(imageView);
        } else if (aVar.iconArreyi != 0) {
            imageView.setImageResource(aVar.iconArreyi);
        } else {
            imageView.setVisibility(8);
        }
        textView.setText(aVar.app_name);
        textView2.setText(aVar.app_des);
        textView3.setText(aVar.install ? R.string.allow : R.string.free_download);
        View.OnClickListener  r4 = new View.OnClickListener() {
            public void onClick(View view) {
                axy.m7467a(context, aVar.packageName, "&referrer=utm_source%3DHDXPlayer%26utm_medium%3DListAd");
            }
        };
        textView.setOnClickListener(r4);
        textView2.setOnClickListener(r4);
        imageView.setOnClickListener(r4);
        textView3.setOnClickListener(r4);
        inflate.setTag(R.id.tagID_self_list_ad_flag, true);
        return inflate;
    }

    
    private static LinkedList<nodeApp> m10449a(Context context) {
        if (!linkedList1.isEmpty()) {
            return linkedList1;
        }
        m10453b(context);
        if (!linkedList1.isEmpty()) {
            return linkedList1;
        }
        return linkedList2;
    }

    
    private static void m10453b(Context context) {
        boolean z = !linkedList2.isEmpty();
        addSelfListedApp(context, z, m10450a(context, z));
    }

    
    private static Set<String> m10450a(Context context, boolean z) {
        String j = ServerConfigSharedPrefrence.GetSelfAds(context);
        Log.e("GetSelfAds_empty","__"+String.valueOf(j));
        HashSet hashSet = new HashSet();
        if (TextUtils.isEmpty(j)) {
            return hashSet;
        }
        try {
            JSONArray jSONArray = new JSONArray(j);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                nodeApp aVar = new nodeApp();
                String unused = aVar.packageName = jSONObject.optString("package", "");
                boolean unused2 = aVar.install = awt.m7202a(context, aVar.packageName);
                hashSet.add(aVar.packageName);
                if (!z || !aVar.install) {
                    String unused3 = aVar.app_name = jSONObject.optString("app_name", "");
                    String unused4 = aVar.app_des = jSONObject.optString("app_des", "");
                    String unused5 = aVar.app_icon = jSONObject.optString("app_icon", "");
                    if (aVar.install) {
                        linkedList2.add(aVar);
                    } else {
                        linkedList1.add(aVar);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashSet;
    }

    
    private static void addSelfListedApp(Context context, boolean z, Set<String> set) {
        String[] packageNameArrey = {"com.downloaders.videodownloader", "qrscanner.scanner.barcodereader.barcodescanner", "hidepictures.videolocker.filehider", "com.security.protector.applocker"};
        int[] titleArrey = {R.string.downloader_app_name, R.string.ad_scanner_title, R.string.video_hider_pro, R.string.ad_applocker_title};
        int[] descriptionArrey = {R.string.videodownloader_detail, R.string.scanner_detail, R.string.video_hider_ad, R.string.applocker_detail};
        int[] iconArrey = {R.mipmap.ad_videodownloader, R.mipmap.ad_qrscanner, R.mipmap.ad_filehider, R.mipmap.ad_applocker};
        for (int i = 0; i < packageNameArrey.length; i++) {
            nodeApp nodeApp = new nodeApp();
            String unused = nodeApp.packageName = packageNameArrey[i];
            if (!set.contains(nodeApp.packageName)) {
                boolean unused2 = nodeApp.install = awt.m7202a(context, nodeApp.packageName);
                Log.e("awt_m7202a",String.valueOf( awt.m7202a(context, nodeApp.packageName)));
                if (!z || !nodeApp.install) {
                    String unused3 = nodeApp.app_name = context.getResources().getString(titleArrey[i]);
                    String unused4 = nodeApp.app_des = context.getResources().getString(descriptionArrey[i]);
                    int unused5 = nodeApp.iconArreyi = iconArrey[i];
                    if (nodeApp.install) {
                        linkedList2.add(nodeApp);
                    } else {
                        linkedList1.add(nodeApp);
                    }
                }
            }
        }
    }

    private static class nodeApp {
        public String app_icon;
        public int iconArreyi;
        public String app_name;
        public String app_des;
        public String packageName;
        public boolean install;
        private nodeApp() {
        }
    }
}
