package classesdef.browser;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;

import classesdef.browser.download.bpd;
import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: bom */
public class bom {
    /* renamed from: a */
    public static void m18358a(Context context) {
        ArrayList arrayList = new ArrayList();
        String a = boo.m18377a(context);
        File file = new File(a + "/crash.log");
        if (file != null && file.exists()) {
            arrayList.add(bpd.m18500a(context, file));
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n\n");
        stringBuffer.append(context.getString(R.string.feedback_mail_text));
        stringBuffer.append("( " + bpc.m18490a(context));
        stringBuffer.append(", " + Build.MODEL);
        stringBuffer.append(", " + Build.VERSION.RELEASE);
        stringBuffer.append(", ");
        stringBuffer.append(context.getResources().getDisplayMetrics().widthPixels + "x" + context.getResources().getDisplayMetrics().heightPixels);
        stringBuffer.append(", ");
        Locale locale = context.getResources().getConfiguration().locale;
        stringBuffer.append(locale.getLanguage() + " _ " + locale.getCountry());
        stringBuffer.append(", ");
        stringBuffer.append(TimeZone.getDefault().getDisplayName(false, 0));
        stringBuffer.append(")");
        try {
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            intent.setType("application/octet-stream");
            intent.putExtra("android.intent.extra.EMAIL", new String[]{"androdeveloper.feedback@gmail.com"});
            intent.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.feedback));
            intent.putExtra("android.intent.extra.TEXT", stringBuffer.toString());
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            if (boj.m18335a().mo23279a(context)) {
                intent.setPackage("com.google.android.gm");
            } else if (boj.m18335a().mo23280b(context)) {
                intent.setPackage("com.android.email");
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            try {
                e.printStackTrace();
                Intent intent2 = new Intent("android.intent.action.SEND_MULTIPLE");
                intent2.setType("application/octet-stream");
                intent2.putExtra("android.intent.extra.EMAIL", new String[]{"androdeveloper.feedback@gmail.com"});
                intent2.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.feedback));
                intent2.putExtra("android.intent.extra.TEXT", stringBuffer.toString());
                intent2.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                context.startActivity(intent2);
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }
}
