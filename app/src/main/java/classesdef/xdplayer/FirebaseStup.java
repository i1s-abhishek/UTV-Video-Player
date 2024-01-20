package classesdef.xdplayer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.abhishek.xplayer.application.MyApplication;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;


import org.json.JSONException;
import org.json.JSONObject;

import classesdef.ads.RemoteCloudConfig;


public class FirebaseStup {

    
    private static final String className = "FirebaseStup";

    
    private static boolean enableFirebseAnalytic = true;

    
    private static boolean enableFirebseRemoteConfig;

    
    private static JSONObject jsonObject;

    
    public static void firebaseAppInitilize(Context context) {
        if (context != null) {
            try {
                FirebaseApp.initializeApp(context);
                enableFirebseAnalytic = false;
            } catch (Exception e) {
                e.printStackTrace();
                enableFirebseAnalytic = true;
            }
        }
    }

    
    public static void normal_type_logevent(String str) {
        if (enableFirebseAnalytic) {
            Log.e(className, "event: " + str);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("item_id", str);
        FirebaseAnalytics.getInstance(MyApplication.getApplicationContext_()).logEvent("Page", bundle);
    }

    
    public static void content_type_logEvent(String str, String str2) {
        if (enableFirebseAnalytic) {
            Log.e(className, "event: " + str + ", " + str2);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("content_type", str);
        bundle.putString("item_id", str2);
        FirebaseAnalytics.getInstance(MyApplication.getApplicationContext_()).logEvent("select_content", bundle);
    }

    
    public static void downloader_content_type_logEvent(String str, String str2) {
        if (enableFirebseAnalytic) {
            Log.e(className, "event: " + str + ", " + str2);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("content_type", str);
        bundle.putString("item_id", str2);
        FirebaseAnalytics.getInstance(MyApplication.getApplicationContext_()).logEvent("Downloader", bundle);
    }

    
    public static boolean splashUseMoPub(String str) {
        feach();
        if (enableFirebseAnalytic || !enableFirebseRemoteConfig) {
            return false;
        }
        return FirebaseRemoteConfig.getInstance().getBoolean(str);
    }
    public static void feach() {
        if (!enableFirebseRemoteConfig) {
            enableFirebseRemoteConfig = true;
            try {
                FirebaseRemoteConfig.getInstance().setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(3600).build());
                FirebaseRemoteConfig.getInstance().fetchAndActivate().addOnCompleteListener(/*$$Lambda$att$qGYekXZOfCXIjTwaIkm7dpHNir8.INSTANCE*/new OnCompleteListener<Boolean>() {
                    @Override
                    public void onComplete(@NonNull Task<Boolean> task) {
                        m18504a( task);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                enableFirebseRemoteConfig = false;
            }
        }
    }

   
    public static  void m18504a(Task zwVar) {
        if (zwVar.isSuccessful()) {
            getJason();
            m18509d();
        }
    }

    
    public static JSONObject CloudConfigJason() {
        feach();
        if (jsonObject == null) {
            getJason();
        }
        return jsonObject;
    }

    
    private static void getJason() {
        if (enableFirebseAnalytic || !enableFirebseRemoteConfig) {
            jsonObject = new JSONObject();
            return;
        }
        String a = FirebaseRemoteConfig.getInstance().getString("CloudConfig");
        if (!TextUtils.isEmpty(a)) {
            try {
                jsonObject = new JSONObject(a);
                RemoteCloudConfig.m18217b();
                return;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jsonObject = new JSONObject();
    }

    
    private static void m18509d() {
        if (!enableFirebseAnalytic && enableFirebseRemoteConfig) {
        }
    }
}
