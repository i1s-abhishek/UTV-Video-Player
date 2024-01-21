package classesdef.browser;

import android.app.Activity;
import android.content.Intent;

import java.util.regex.Pattern;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bqj */
public class bqj {

    /* renamed from: b */
    private static final Pattern f16425b = Pattern.compile("(?i)((?:http|https|file)://|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");

    /* renamed from: a */
    private final Activity f16426a;

    public bqj(Activity activity) {
        this.f16426a = activity;
    }

    /* renamed from: a */
    public void mo23567a(String str, String str2) {
        if (str != null && !bqv.m19001a(str)) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            if (str2 != null) {
                intent.putExtra("android.intent.extra.SUBJECT", str2);
            }
            intent.putExtra("android.intent.extra.TEXT", str);
            this.f16426a.startActivity(Intent.createChooser(intent, this.f16426a.getString(R.string.dialog_title_share)));
        }
    }
}
