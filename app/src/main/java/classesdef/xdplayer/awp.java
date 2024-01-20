package classesdef.xdplayer;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mopub.mobileads.VastExtensionXmlManager;

import org.json.JSONException;
import org.json.JSONObject;

import classesdef.ads.RemoteCloudConfig;
import classesdef.inplayer.awt;
import classesdef.inplayer.awz;
import classesdef.inplayer.SharedPrefrence;
import hdplayer.vlcplayer.videoplayer.R;

/* renamed from: awp */
public class awp {
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        r1 = r3.getInt("update_ver");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo10871aa(Context r6) {
        /*
            r5 = this;
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r6)
            java.lang.String r1 = "ULC"
            r2 = 0
            int r1 = r0.getInt(r1, r2)
            if (r1 == 0) goto L_0x0011
            r3 = 6
            if (r1 == r3) goto L_0x0011
            return
        L_0x0011:
            java.lang.String r1 = "update"
            java.lang.String r3 = ""
            java.lang.String r1 = p000.awv.m7213a(r6, r1, r3)
            if (r1 == 0) goto L_0x0079
            java.lang.String r3 = ""
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0079
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            java.lang.String r1 = "app_ver"
            int r1 = r3.getInt(r1)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            java.lang.String r4 = "package"
            java.lang.String r4 = r3.getString(r4)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            boolean r4 = p000.awt.m7202a((android.content.Context) r6, (java.lang.String) r4)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            if (r4 == 0) goto L_0x0041
            int r4 = p000.awt.m7194a((android.content.Context) r6)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            if (r4 < r1) goto L_0x0041
            return
        L_0x0041:
            java.lang.String r1 = "type"
            int r1 = r3.getInt(r1)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            r4 = 1
            if (r1 == r4) goto L_0x004e
            r4 = 3
            if (r1 == r4) goto L_0x004e
            return
        L_0x004e:
            java.lang.String r1 = "update_ver"
            int r1 = r3.getInt(r1)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            java.lang.String r4 = "VCOL"
            int r0 = r0.getInt(r4, r2)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            if (r0 != r1) goto L_0x005d
            return
        L_0x005d:
            if (r1 <= r0) goto L_0x006e
            java.lang.String r0 = "url_market"
            java.lang.String r0 = r3.getString(r0)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            awq r2 = new awq     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            r2.<init>(r6, r3)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            r5.m7169a(r6, r2, r0, r1)     // Catch:{ JSONException -> 0x0074, Exception -> 0x006f }
            goto L_0x0079
        L_0x006e:
            return
        L_0x006f:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0079
        L_0x0074:
            r6 = move-exception
            r6.printStackTrace()
            return
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.awp.mo10871a(android.content.Context):void");
    }
    public void mo10871a(Context context) {
        String a;
        int i;
        int i2;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i3 = defaultSharedPreferences.getInt("ULC", 0);
        if ((i3 == 0 || i3 == 6) && (a = RemoteCloudConfig.m18216a( "update", "")) != null && !a.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(a);
                int i4 = jSONObject.getInt("app_ver");
                if (!awt.m7202a(context, jSONObject.getString("package")) || awt.m7194a(context) < i4) {
                    int i5 = jSONObject.getInt(VastExtensionXmlManager.TYPE);
                    if ((i5 == 1 || i5 == 3) && (i2 = defaultSharedPreferences.getInt("VCOL", 0)) != (i = jSONObject.getInt("update_ver")) && i > i2) {
                        m7169a(context, new awq(context, jSONObject), jSONObject.getString("url_market"), i);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r3 = p000.awz.m7240a(r11, r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7169aa(Context r11,awq r12, String r13, int r14) {
        /*
            r10 = this;
            int r0 = r12.mo10889i()
            if (r0 >= 0) goto L_0x0007
            return
        L_0x0007:
            android.view.View r3 = p000.awz.m7240a((android.content.Context) r11, (int) r0)
            if (r3 != 0) goto L_0x000e
            return
        L_0x000e:
            android.content.SharedPreferences r5 = android.preference.PreferenceManager.getDefaultSharedPreferences(r11)
            android.app.Dialog r4 = new android.app.Dialog
            r4.<init>(r11)
            r0 = 1
            r4.requestWindowFeature(r0)
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r1 = 1133576192(0x43910000, float:290.0)
            int r2 = p000.axw.m7444a((android.content.Context) r11, (float) r1)
            r6 = -2
            r0.<init>(r2, r6)
            r4.setContentView(r3, r0)
            android.view.Window r0 = r4.getWindow()
            android.graphics.drawable.ColorDrawable r2 = new android.graphics.drawable.ColorDrawable
            r6 = 0
            r2.<init>(r6)
            r0.setBackgroundDrawable(r2)
            r4.show()
            int r0 = p000.awt.m7194a((android.content.Context) r11)
            p000.axn.m7394b(r11, r0)
            r0 = 2131296453(0x7f0900c5, float:1.8210823E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = r12.mo10880b()
            r0.setText(r2)
            r0 = 2131296915(0x7f090293, float:1.821176E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2 = 2131296650(0x7f09018a, float:1.8211223E38)
            android.view.View r2 = r4.findViewById(r2)
            android.widget.Button r2 = (android.widget.Button) r2
            r6 = 2131297012(0x7f0902f4, float:1.8211957E38)
            android.view.View r6 = r4.findViewById(r6)
            r9 = r6
            android.widget.Button r9 = (android.widget.Button) r9
            java.lang.String r6 = r12.mo10876a()
            android.text.Spanned r6 = android.text.Html.fromHtml(r6)
            r0.setText(r6)
            java.lang.String r0 = r12.mo10884d()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r2.setText(r0)
            java.lang.String r0 = r12.mo10883c()
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r9.setText(r0)
            r0 = 2131296437(0x7f0900b5, float:1.821079E38)
            android.view.View r6 = r4.findViewById(r0)
            if (r6 == 0) goto L_0x00d2
            android.view.View r0 = r4.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            android.view.ViewGroup$LayoutParams r6 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r6 = (android.widget.FrameLayout.LayoutParams) r6
            if (r6 == 0) goto L_0x00cf
            int r1 = p000.axw.m7444a((android.content.Context) r11, (float) r1)
            r6.width = r1
            android.graphics.Bitmap r1 = r12.mo10888h()
            boolean r1 = p000.axw.m7448a((android.graphics.Bitmap) r1)
            if (r1 == 0) goto L_0x00cf
            android.graphics.Bitmap r1 = r12.mo10888h()
            int r1 = r1.getHeight()
            android.graphics.Bitmap r7 = r12.mo10888h()
            int r7 = r7.getWidth()
            int r8 = r6.width
            int r8 = r8 * r1
            int r8 = r8 / r7
            r6.height = r8
            r0.setLayoutParams(r6)
        L_0x00cf:
            r12.mo10881b((android.widget.ImageView) r0)
        L_0x00d2:
            r0 = 2131296553(0x7f090129, float:1.8211026E38)
            android.view.View r1 = r4.findViewById(r0)
            if (r1 == 0) goto L_0x00e4
            android.view.View r0 = r4.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r12.mo10877a((android.widget.ImageView) r0)
        L_0x00e4:
            awp$1 r12 = new awp$1
            r12.<init>(r3, r5)
            r4.setOnDismissListener(r12)
            awp$2 r12 = new awp$2
            r12.<init>(r3, r4, r5)
            r2.setOnClickListener(r12)
            awp$3 r12 = new awp$3
            r1 = r12
            r2 = r10
            r6 = r14
            r7 = r11
            r8 = r13
            r1.<init>(r3, r4, r5, r6, r7, r8)
            r9.setOnClickListener(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.awp.m7169a(android.content.Context, awq, java.lang.String, int):void");
    }
    private void m7169a(final Context context, awq awq, final String str, final int i) {

        int i2 = awq.mo10889i();
        final View a = awz.m18242a(context, i2);
        if (i2 >= 0 && a != null) {
            final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            final Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.setContentView(a, new ViewGroup.LayoutParams(axw.m7444a(context, 290.0f), -2));
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.show();
            SharedPrefrence.m7394b(context, awt.m7194a(context));
            ((TextView) dialog.findViewById(R.id.desc_tv)).setText(awq.mo10880b());
            Button button = (Button) dialog.findViewById(R.id.no_btn);
            Button button2 = (Button) dialog.findViewById(R.id.yes_btn);
            ((TextView) dialog.findViewById(R.id.title_tv)).setText(Html.fromHtml(awq.mo10876a()));
            button.setText(Html.fromHtml(awq.mo10884d()));
            button2.setText(Html.fromHtml(awq.mo10883c()));
            if (dialog.findViewById(R.id.cover_imageview) != null) {
                ImageView imageView = (ImageView) dialog.findViewById(R.id.cover_imageview);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = axw.m7444a(context, 290.0f);
                    if (axw.m7448a(awq.mo10888h())) {
                        layoutParams.height = (layoutParams.width * awq.mo10888h().getHeight()) / awq.mo10888h().getWidth();
                        imageView.setLayoutParams(layoutParams);
                    }
                }
                awq.mo10881b(imageView);
            }
            if (dialog.findViewById(R.id.icon_imageview) != null) {
                awq.mo10877a((ImageView) dialog.findViewById(R.id.icon_imageview));
            }
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class defpackage.awp.AnonymousClass1 */

                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.getTag() == null) {
                        SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                        edit.putInt("ULC", 1);
                        edit.apply();
                    }
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                /* class defpackage.awp.AnonymousClass2 */

                public void onClick(View view) {
                    a.setTag(0);
                    dialog.dismiss();
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putInt("ULC", 1);
                    edit.apply();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                /* class defpackage.awp.AnonymousClass3 */

                public void onClick(View view) {
                    a.setTag(1);
                    dialog.dismiss();
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putInt("VCOL", i);
                    edit.putInt("ULC", 0);
                    edit.apply();
                    axy.m7467a(context, str, "&referrer=utm_source%3DInShot%26utm_medium%3Dupdate_dialog");
                }
            });
        }
    }

    /* renamed from: b */
    public void mo10872b(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        int i = defaultSharedPreferences.getInt("ULC", 0);
        if (i > 0 && i < 6) {
            defaultSharedPreferences.edit().putInt("ULC", i + 1).apply();
        }
    }
}
