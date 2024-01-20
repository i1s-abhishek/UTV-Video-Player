package classesdef.ads;


import com.abhishek.xplayer.ad.C2231b;

import classesdef.xdplayer.FirebaseStup;



public class RemoteCloudConfig {

    public static String m18216a(String str, String str2) {
       return FirebaseStup.CloudConfigJason().optString(str, str2);

    }


    public static int m18215a(String str, int i) {
        return FirebaseStup.CloudConfigJason().optInt(str, i);
    }


    public static int m18214a() {
        return m18215a("rateType", 2);
    }


    public static void m18217b() {
        C2231b.m10188a().mo16919b();
    }
}
