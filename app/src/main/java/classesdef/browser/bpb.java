package classesdef.browser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;

import java.io.File;
import java.util.ArrayList;

/* renamed from: bpb */
public class bpb {
    /* renamed from: a */
    public static ArrayList<String> m18488a(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? m18489b(context) : new ArrayList<>();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static ArrayList<String> m18489b(Context context) {
        File[] externalFilesDirs = context.getExternalFilesDirs((String) null);
        ArrayList<String> arrayList = new ArrayList<>(externalFilesDirs.length + 1);
        for (File file : externalFilesDirs) {
            if (file != null && file.exists()) {
                arrayList.add(file.getPath());
            }
        }
        return arrayList;
    }
}
