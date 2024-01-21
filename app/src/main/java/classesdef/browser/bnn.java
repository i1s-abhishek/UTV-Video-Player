package classesdef.browser;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bnn */
public class bnn {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f15979b = false;

    /* renamed from: a */
    private int f15980a;

    public bnn(int i) {
        this.f15980a = i;
    }

    /* renamed from: a */
    public void mo23226a(Context context) {
        if (!f15979b) {
            try {
                final AlertDialog create = new AlertDialog.Builder(context).create();
                View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_youtube_tip, (ViewGroup) null);
                create.setView(inflate);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_logo);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_cannot_download);
                if (this.f15980a == 0) {
                    Glide.with(context).load(Integer.valueOf(R.mipmap.youtube_tip)).dontAnimate().into(imageView);
                    textView.setText(context.getString(R.string.cannot_download_tip));
                } else if (this.f15980a == 1) {
                    Glide.with(context).load(Integer.valueOf(R.mipmap.soundcloud_tip)).dontAnimate().into(imageView);
                    textView.setText(context.getString(R.string.cannot_download_tip).replace("YouTube", "SoundCloud"));
                }
                ((ImageView) inflate.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        create.cancel();
                        boolean unused = bnn.f15979b = false;
                    }
                });
                ((Button) inflate.findViewById(R.id.got_it)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        create.cancel();
                        boolean unused = bnn.f15979b = false;
                    }
                });
                create.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        boolean unused = bnn.f15979b = false;
                    }
                });
                create.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        boolean unused = bnn.f15979b = false;
                    }
                });
                create.show();
                f15979b = true;
            } catch (Exception e) {
                e.printStackTrace();
                bbc.m15886a().mo21879a(context, (Throwable) e);
                f15979b = false;
            }
        }
    }
}
