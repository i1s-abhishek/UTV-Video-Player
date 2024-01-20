package video.downloader.videodownloader.five.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.abhishek.xplayer.application.BaseActivity;
import com.liulishuo.filedownloader.FileDownloader;

import org.greenrobot.eventbus.EventBus;

import classesdef.browser.bbc;
import classesdef.browser.bov;
import classesdef.browser.box;
import classesdef.eventbus.bnz;
import classesdef.xdplayer.bpj;
import hdplayer.vlcplayer.videoplayer.R;


public abstract class BasePermissionActivity extends BaseActivity {

    NetworkStateReceiver networkStateReceiver;

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 12) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else if (iArr.length <= 0 || iArr[0] != 0) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                mo21307a();
            } else {
                box.m18456a(this);
            }
        } else if (box.m18455a() != null) {
            box.m18455a().mo21376a();
        }
    }

    private void mo21307a() {
        final AlertDialog create = new AlertDialog.Builder(this).create();
        View inflate = LayoutInflater.from(this).inflate(R.layout.open_permission_setting, (ViewGroup) null);
        inflate.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        inflate.findViewById(R.id.tv_update_settings).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
                try {
                    BasePermissionActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + BasePermissionActivity.this.getPackageName())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        create.setView(inflate);
        create.show();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        try {
            mo21524F();
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        try {
            unregisterReceiver(this.networkStateReceiver);
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) this, (Throwable) e);
        }
    }

    /* renamed from: F */
    public void mo21524F() {
        if (this.networkStateReceiver == null) {
            this.networkStateReceiver = new NetworkStateReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(this.networkStateReceiver, intentFilter);
    }

    public class NetworkStateReceiver extends BroadcastReceiver {
        public NetworkStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            EventBus.getDefault().post(new bnz());
            if (!bpj.m18578a(context).mo23412s() && !bov.m18446a(context)) {
                FileDownloader.getImpl().pauseAll();
            }
        }
    }
}
