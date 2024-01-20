package classesdef.xdplayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.abhishek.xplayer.application.MyApplication;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: axq */
public class axq {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C1362a f6302a;

    /* renamed from: b */
    private String f6303b = "";

    /* renamed from: axq$a */
    public interface C1362a {
        /* renamed from: c */
        void mo10931c();

        /* renamed from: d */
        void mo10932d();

        /* renamed from: e */
        void mo10933e();
    }

    public axq(C1362a aVar, String str) {
        this.f6302a = aVar;
        this.f6303b = m7409a(str);
    }

    /* renamed from: a */
    public void mo10993a(final Fragment fragment, final int i) {
        AlertDialog show = new AlertDialog.Builder(fragment.getContext()).setView((int) R.layout.layout_sd_tips).setPositiveButton((int) R.string.start, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        fragment.startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), i);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                axq.this.f6302a.mo10932d();
            }
        }).setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                axq.this.f6302a.mo10933e();
            }
        }).show();
        ((TextView) show.findViewById(R.id.sd_tips)).setText(Html.fromHtml(show.getContext().getString(R.string.sd_tips, new Object[]{this.f6303b})));
    }

    /* renamed from: a */
    public void mo10992a(int i, Intent intent) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (i == -1) {
            Uri data = intent.getData();
            awx.m7218a(MyApplication.getApplicationContext_(), data);
            MyApplication.getApplicationContext_().getContentResolver().takePersistableUriPermission(data, 2);
            this.f6302a.mo10931c();
            return;
        }
        this.f6302a.mo10932d();
    }

    /* renamed from: a */
    private static String m7409a(String str) {
        if (str == null) {
            return "/mnt/extSdCard";
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length && (charArray[i] != '/' || (i2 = i2 + 1) != 3)) {
            i3++;
            i++;
        }
        return i2 == 3 ? str.substring(0, i3) : "/mnt/extSdCard";
    }
}
