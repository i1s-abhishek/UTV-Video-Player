package classesdef.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bno */
public class bno {
    /* renamed from: a */
    public void mo23231a(final Context context, final String str) {
        final AlertDialog create = new AlertDialog.Builder(context).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_no_res, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.no_res_tip)).setText(context.getString(R.string.no_video_resource, new Object[]{context.getString(R.string.downloader_app_name)}));
        inflate.findViewById(R.id.got_it).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.report_to_us);
        textView.getPaint().setFlags(8);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
                bno.this.m18260b(context, str);
            }
        });
        create.setView(inflate);
        try {
            create.show();
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m18260b(Context context, String str) {
        BrowserLogEvent.downloaderLogEvent(context, "no_support_website", bqw.m19011a(str));
        final AlertDialog create = new AlertDialog.Builder(context).create();
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_report_to_us, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.url);
        textView.setText(bqw.m19011a(str));
        textView.getPaint().setFlags(8);
        inflate.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        create.setView(inflate);
        create.show();
    }
}
