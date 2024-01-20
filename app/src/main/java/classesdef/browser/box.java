package classesdef.browser;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: box */
public class box {

    /* renamed from: a */
    private static C3987a f16105a;

    /* renamed from: box$a */
    public interface C3987a {
        /* renamed from: a */
        void mo21376a();
    }

    /* renamed from: a */
    public static boolean m18457a(Activity activity, C3987a aVar) {
        try {
            if (ContextCompat.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                return true;
            }
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                m18456a(activity);
            } else {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 12);
            }
            f16105a = aVar;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) activity, (Throwable) e);
            return false;
        }
    }

    /* renamed from: a */
    public static void m18456a(final Activity activity) {
        final AlertDialog create = new AlertDialog.Builder(activity).create();
        View inflate = LayoutInflater.from(activity).inflate(R.layout.need_permission, (ViewGroup) null);
        inflate.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        inflate.findViewById(R.id.tv_allow).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 12);
                create.dismiss();
            }
        });
        create.setView(inflate);
        create.show();
    }

    /* renamed from: a */
    public static C3987a m18455a() {
        return f16105a;
    }
}
