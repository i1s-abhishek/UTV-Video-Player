package com.abhishek.xplayer.ad;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.abhishek.xplayer.application.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import classesdef.ads.C4314ie;
import classesdef.ads.AppDataAdded;
import classesdef.xdplayer.ServerConfigSharedPrefrence;
import hdplayer.xdplayer.videoplayer.R;


public class SelfCustumFunnyServerAds {

    
    private static ArrayList<AppDataAdded> arrayList = new ArrayList<>();
    public Bitmap bitmap1 = null;
    public Bitmap bitmap2 = null;
    public Handler handler = new Handler(MyApplication.getApplicationContext_().getMainLooper());
    public View view;
    public ImageView coverImageView;
    public ImageView iconImageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private TextView buttonTextView;
    public interface nativeAdInterface {
        
        void exception();

        
        void showView(View view);

        
        void nativeAdLogEvent();
    }

    SelfCustumFunnyServerAds() {
    }

    
    public AppDataAdded addData(Context context, String str) {
        if (arrayList.size() == 0) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("package", "");
                    if (!C4314ie.m19804a().mo23980a(context, optString)) {
                        if (!ServerConfigSharedPrefrence.m19714b(context, optString, 1)) {
                            AppDataAdded ndVar = new AppDataAdded();
                            ndVar.appPackage = optString;
                            ndVar.market_url = jSONObject.optString("market_url", "");
                            ndVar.appName = jSONObject.optString("app_name", "");
                            ndVar.app_des = jSONObject.optString("app_des", "");
                            ndVar.app_icon = jSONObject.optString("app_icon", "");
                            ndVar.actionOnApp = jSONObject.optString("action", "");
                            ndVar.appCover = jSONObject.optString("app_cover", "");
                            if (!ndVar.appCover.equals("")) {
                                arrayList.add(ndVar);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        AppDataAdded ndVar2 = arrayList.get(new Random().nextInt(arrayList.size()));
        arrayList.remove(ndVar2);
        return ndVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r5 = addData(r4, r5);
     */
    /* renamed from: a */
    public void showDataa(final Context r4, String r5, int r6, final SelfCustumFunnyServerAds.nativeAdInterface r7) {
        /*
            r3 = this;
            android.view.View r0 = r3.view
            if (r0 == 0) goto L_0x0007
            r3.mo17020a()
        L_0x0007:
            if (r7 == 0) goto L_0x00cb
            java.lang.String r0 = ""
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00cb
            nd r5 = r3.addData((android.content.Context) r4, (java.lang.String) r5)
            if (r5 != 0) goto L_0x0018
            return
        L_0x0018:
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r4)
            r1 = 0
            r2 = 0
            android.view.View r6 = r0.inflate(r6, r1, r2)
            r3.view = r6
            android.view.View r6 = r3.view
            if (r6 != 0) goto L_0x002c
            r7.exception()
            return
        L_0x002c:
            r0 = 2131296323(0x7f090043, float:1.821056E38)
            android.view.View r6 = r6.findViewById(r0)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r3.coverImageView = r6
            android.view.View r6 = r3.view
            r0 = 2131296325(0x7f090045, float:1.8210563E38)
            android.view.View r6 = r6.findViewById(r0)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r3.iconImageView = r6
            android.view.View r6 = r3.view
            r0 = 2131296327(0x7f090047, float:1.8210568E38)
            android.view.View r6 = r6.findViewById(r0)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r3.titleTextView = r6
            android.view.View r6 = r3.view
            r0 = 2131296324(0x7f090044, float:1.8210561E38)
            android.view.View r6 = r6.findViewById(r0)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r3.descriptionTextView = r6
            android.view.View r6 = r3.view
            r0 = 2131296322(0x7f090042, float:1.8210557E38)
            android.view.View r6 = r6.findViewById(r0)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r3.buttonTextView = r6
            android.widget.TextView r6 = r3.titleTextView
            r0 = 8
            if (r6 == 0) goto L_0x008c
            java.lang.String r6 = r5.appName
            java.lang.String r1 = ""
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0081
            android.widget.TextView r6 = r3.titleTextView
            r6.setVisibility(r0)
            goto L_0x008c
        L_0x0081:
            android.widget.TextView r6 = r3.titleTextView
            java.lang.String r1 = r5.appName
            android.text.Spanned r1 = android.text.Html.fromHtml(r1)
            r6.setText(r1)
        L_0x008c:
            android.widget.TextView r6 = r3.descriptionTextView
            if (r6 == 0) goto L_0x00ab
            java.lang.String r6 = r5.app_des
            java.lang.String r1 = ""
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x00a0
            android.widget.TextView r6 = r3.descriptionTextView
            r6.setVisibility(r0)
            goto L_0x00ab
        L_0x00a0:
            android.widget.TextView r6 = r3.descriptionTextView
            java.lang.String r0 = r5.app_des
            android.text.Spanned r0 = android.text.Html.fromHtml(r0)
            r6.setText(r0)
        L_0x00ab:
            android.widget.TextView r6 = r3.buttonTextView
            if (r6 == 0) goto L_0x00b4
            java.lang.String r0 = r5.actionOnApp
            r6.setText(r0)
        L_0x00b4:
            android.view.View r6 = r3.view
            com.inshot.xplayer.ad.x$1 r0 = new com.inshot.xplayer.ad.x$1
            r0.<init>(r5, r4, r7)
            r6.setOnClickListener(r0)
            java.lang.Thread r6 = new java.lang.Thread
            com.inshot.xplayer.ad.x$2 r0 = new com.inshot.xplayer.ad.x$2
            r0.<init>(r5, r4, r7)
            r6.<init>(r0)
            r6.start()
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.p005ad.C2270x.showData(android.content.Context, java.lang.String, int, com.inshot.xplayer.ad.x$a):void");
    }
    public void showData(final Context context, String str, int i2, final SelfCustumFunnyServerAds.nativeAdInterface aVar) {
        if (this.view != null) {
            mo17020a();
        }
        if (aVar != null && !str.equals("")) {
            final AppDataAdded a2 = this.addData(context, str);
            if (a2 == null) {
                return;
            }

            this.view = LayoutInflater.from(context).inflate(i2, (ViewGroup) null, false);
            View view = this.view;
            if (view == null) {
                aVar.exception();
                return;
            }
            this.coverImageView = (ImageView) view.findViewById(R.id.admob_native_cover);
            this.iconImageView = (ImageView) this.view.findViewById(R.id.admob_native_icon);
            this.titleTextView = (TextView) this.view.findViewById(R.id.admob_native_title);
            this.descriptionTextView = (TextView) this.view.findViewById(R.id.admob_native_desc);
            this.buttonTextView = (TextView) this.view.findViewById(R.id.admob_native_btn);
            if (this.titleTextView != null) {
                if (a2.appName.equals("")) {
                    this.titleTextView.setVisibility(8);
                } else {
                    this.titleTextView.setText(Html.fromHtml(a2.appName));
                }
            }
            if (this.descriptionTextView != null) {
                if (a2.app_des.equals("")) {
                    this.descriptionTextView.setVisibility(8);
                } else {
                    this.descriptionTextView.setText(Html.fromHtml(a2.app_des));
                }
            }
            TextView textView = this.buttonTextView;
            if (textView != null) {
                textView.setText(a2.actionOnApp);
            }
            this.view.setOnClickListener(new View.OnClickListener() {
                /* class com.inshot.xplayer.ad.x.AnonymousClass1 */

                public void onClick(View view) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(a2.market_url));
                        intent.setFlags(268435456);
                        intent.setPackage("com.android.vending");
                        context.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(a2.market_url));
                        intent2.setFlags(268435456);
                        context.startActivity(intent2);
                    }
                    ServerConfigSharedPrefrence.m19710a(context, a2.appPackage, 1);
                    aVar.nativeAdLogEvent();
                }
            });
            new Thread(new Runnable() {


                public void run() {
                    try {
                        File file = new File(a2.app_icon);
                        File file2 = new File(a2.appCover);
                        if (file.exists() && file2.exists()) {
                            SelfCustumFunnyServerAds.this.bitmap1 = BitmapFactory.decodeFile(a2.app_icon);
                            SelfCustumFunnyServerAds.this.bitmap2 = BitmapFactory.decodeFile(a2.appCover);
                            if (SelfCustumFunnyServerAds.this.bitmap1 != null && !SelfCustumFunnyServerAds.this.bitmap1.isRecycled() && SelfCustumFunnyServerAds.this.bitmap2 != null && !SelfCustumFunnyServerAds.this.bitmap2.isRecycled()) {
                                float width = ((float) context.getResources().getDisplayMetrics().widthPixels) / ((float) SelfCustumFunnyServerAds.this.bitmap2.getWidth());
                                SelfCustumFunnyServerAds.this.bitmap2 = C4816np.m23807a(SelfCustumFunnyServerAds.this.bitmap2, width, width);
                                if (SelfCustumFunnyServerAds.this.bitmap2 != null && !SelfCustumFunnyServerAds.this.bitmap2.isRecycled()) {
                                    SelfCustumFunnyServerAds.this.handler.post(new Runnable() {
                                        /* class com.inshot.xplayer.ad.x.AnonymousClass2.AnonymousClass1 */

                                        public void run() {
                                            try {
                                                if (!(SelfCustumFunnyServerAds.this.iconImageView == null || SelfCustumFunnyServerAds.this.bitmap1 == null || SelfCustumFunnyServerAds.this.bitmap1.isRecycled())) {
                                                    SelfCustumFunnyServerAds.this.iconImageView.setImageBitmap(SelfCustumFunnyServerAds.this.bitmap1);
                                                }
                                                if (!(SelfCustumFunnyServerAds.this.coverImageView == null || SelfCustumFunnyServerAds.this.bitmap2 == null || SelfCustumFunnyServerAds.this.bitmap2.isRecycled())) {
                                                    SelfCustumFunnyServerAds.this.coverImageView.setImageBitmap(SelfCustumFunnyServerAds.this.bitmap2);
                                                }
                                                aVar.showView(SelfCustumFunnyServerAds.this.view);
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                                aVar.exception();
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        SelfCustumFunnyServerAds.this.handler.post(new Runnable() {
                            /* class com.inshot.xplayer.ad.x.AnonymousClass2.AnonymousClass2 */

                            public void run() {
                                SelfCustumFunnyServerAds.this.mo17020a();
                                aVar.exception();
                            }
                        });
                    }
                }
            }).start();
        }
    }

    /* renamed from: a */
    public void mo17020a() {
        ImageView imageView = this.coverImageView;
        if (imageView != null) {
            imageView.setImageBitmap((Bitmap) null);
        }
        ImageView imageView2 = this.iconImageView;
        if (imageView2 != null) {
            imageView2.setImageBitmap((Bitmap) null);
        }
        this.view = null;
        this.coverImageView = null;
        this.iconImageView = null;
        this.titleTextView = null;
        this.descriptionTextView = null;
        this.buttonTextView = null;
        Bitmap bitmap = this.bitmap1;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.bitmap1.recycle();
            }
            this.bitmap1 = null;
        }
        Bitmap bitmap2 = this.bitmap2;
        if (bitmap2 != null) {
            if (!bitmap2.isRecycled()) {
                this.bitmap2.recycle();
            }
            this.bitmap2 = null;
        }
    }
}
