package classesdef.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: bnp */
public class bnp {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3971a f15995a;

    /* renamed from: bnp$a */
    public interface C3971a {
        /* renamed from: a */
        void mo21549a();
    }

    /* renamed from: a */
    public void mo23235a(Context context) {
        final AlertDialog create = new AlertDialog.Builder(context).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.sdcard_warn, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tv_warn_content)).setText(context.getString(R.string.warning_content, new Object[]{context.getString(R.string.downloader_app_name)}));
        inflate.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        inflate.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        inflate.findViewById(R.id.tv_confirm).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
                if (bnp.this.f15995a != null) {
                    bnp.this.f15995a.mo21549a();
                }
            }
        });
        create.setView(inflate);
        create.show();
    }

    /* renamed from: a */
    public void mo23236a(C3971a aVar) {
        this.f15995a = aVar;
    }
}
