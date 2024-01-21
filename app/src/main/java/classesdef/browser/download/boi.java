package classesdef.browser.download;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import classesdef.browser.bon;
import classesdef.browser.box;
import classesdef.browser.bpc;
import classesdef.browser.bph;
import classesdef.database.bnm;
import classesdef.database.boh;
import classesdef.eventbus.bob;
import classesdef.inplayer.awt;
import es.dmoral.toasty.Toasty;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.five.service.ManualParseService;

/* renamed from: boi */
public class boi {

    /* renamed from: a */
    private static boi f16058a;

    /* renamed from: b */
    private HashMap<String, ArrayList<bph>> f16059b = new HashMap<>();
    private HashMap<String, ArrayList<bph>> f16332c = new HashMap<>();

    private void m21016b(bph bfz) {
        if (this.f16332c == null) {
            this.f16332c = new HashMap<>();
        }
        if (this.f16332c.containsKey(bfz.mo23354i())) {
            this.f16332c.get(bfz.mo23354i()).add(bfz);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bfz);
        this.f16332c.put(bfz.mo23354i(), arrayList);
    }
    private void m21017h(String str) {
        HashMap<String, ArrayList<bph>> hashMap;
        if (!TextUtils.isEmpty(str) && (hashMap = this.f16332c) != null) {
            hashMap.remove(str);
        }
    }
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    private ArrayList<bph> m21018i(String str) {
        HashMap<String, ArrayList<bph>> hashMap;
        ArrayList<bph> arrayList = new ArrayList<>();
        return (TextUtils.isEmpty(str) || (hashMap = this.f16332c) == null) ? arrayList : hashMap.get(str);
    }

    private synchronized void m21015b(Context context, bph bfz) {
        if (!ManualParseService.m15237a(context, bfz.mo23354i())) {
            mo23268a(context, bfz);
        } else if (!ManualParseService.m14400a(bfz.mo23354i())) {
            m21016b(bfz);
        } else if (!mo24563g(bfz.mo23354i())) {
            mo23268a(context, bfz);
        }
    }
    public synchronized void mo23268aa(Context r7, bph r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.HashMap<java.lang.String, java.util.ArrayList<bph>> r0 = r6.f16059b     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x000c
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x00cc }
            r0.<init>()     // Catch:{ all -> 0x00cc }
            r6.f16059b = r0     // Catch:{ all -> 0x00cc }
        L_0x000c:
            r0 = 0
            java.util.HashMap<java.lang.String, java.util.ArrayList<bph>> r1 = r6.f16059b     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = r8.mo23354i()     // Catch:{ all -> 0x00cc }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x00cc }
            r2 = 1
            if (r1 == 0) goto L_0x005c
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00cc }
            java.util.HashMap<java.lang.String, java.util.ArrayList<bph>> r3 = r6.f16059b     // Catch:{ all -> 0x00cc }
            java.lang.String r4 = r8.mo23354i()     // Catch:{ all -> 0x00cc }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00cc }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x00cc }
            r1.<init>(r3)     // Catch:{ all -> 0x00cc }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00cc }
        L_0x002f:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00cc }
            if (r3 == 0) goto L_0x005c
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00cc }
            bph r3 = (bph) r3     // Catch:{ all -> 0x00cc }
            java.lang.String r4 = r3.mo23339c()     // Catch:{ all -> 0x00cc }
            java.lang.String r5 = r8.mo23339c()     // Catch:{ all -> 0x00cc }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00cc }
            if (r4 != 0) goto L_0x005b
            boh r4 = boh.m18304a()     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = r3.mo23339c()     // Catch:{ all -> 0x00cc }
            java.lang.String r5 = r8.mo23339c()     // Catch:{ all -> 0x00cc }
            boolean r3 = r4.mo23263a(r7, r3, r5)     // Catch:{ all -> 0x00cc }
            if (r3 == 0) goto L_0x002f
        L_0x005b:
            r0 = 1
        L_0x005c:
            if (r0 != 0) goto L_0x00ca
            java.util.HashMap<java.lang.String, java.util.ArrayList<bph>> r7 = r6.f16059b     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r8.mo23354i()     // Catch:{ all -> 0x00cc }
            boolean r7 = r7.containsKey(r0)     // Catch:{ all -> 0x00cc }
            if (r7 == 0) goto L_0x0097
            java.util.HashMap<java.lang.String, java.util.ArrayList<bph>> r7 = r6.f16059b     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r8.mo23354i()     // Catch:{ all -> 0x00cc }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ all -> 0x00cc }
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r8.mo23354i()     // Catch:{ all -> 0x00cc }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00cc }
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = r8.mo23354i()     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = "facebook.com"
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x00cc }
            if (r0 == 0) goto L_0x0093
            r7.clear()     // Catch:{ all -> 0x00cc }
        L_0x0093:
            r7.add(r8)     // Catch:{ all -> 0x00cc }
            goto L_0x00a8
        L_0x0097:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x00cc }
            r7.<init>()     // Catch:{ all -> 0x00cc }
            r7.add(r8)     // Catch:{ all -> 0x00cc }
            java.util.HashMap<java.lang.String, java.util.ArrayList<bph>> r0 = r6.f16059b     // Catch:{ all -> 0x00cc }
            java.lang.String r1 = r8.mo23354i()     // Catch:{ all -> 0x00cc }
            r0.put(r1, r7)     // Catch:{ all -> 0x00cc }
        L_0x00a8:
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.EventBus.getDefault()     // Catch:{ all -> 0x00cc }
            bob r1 = new bob     // Catch:{ all -> 0x00cc }
            int r7 = r7.size()     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = r8.mo23354i()     // Catch:{ all -> 0x00cc }
            r1.<init>(r7, r3, r2)     // Catch:{ all -> 0x00cc }
            r0.post(r1)     // Catch:{ all -> 0x00cc }
            boolean r7 = r8.mo23358m()     // Catch:{ all -> 0x00cc }
            if (r7 != 0) goto L_0x00ca
            boz r7 = new boz     // Catch:{ all -> 0x00cc }
            r7.<init>()     // Catch:{ all -> 0x00cc }
            r7.mo23305a(r8)     // Catch:{ all -> 0x00cc }
        L_0x00ca:
            monitor-exit(r6)
            return
        L_0x00cc:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: boi.mo23268a(android.content.Context, bph):void");
    }
    public synchronized void mo24556a(Context context, String str, List<bph> list) {
        if (list != null) {
            if (list.size() != 0) {
                mo23274c(str);
                for (bph a : list) {
                    mo23268a(context, a);
                }
                m21017h(str);
            }
        }
        ArrayList<bph> i = m21018i(str);
        if (i != null && i.size() > 0) {
            Iterator<bph> it = i.iterator();
            while (it.hasNext()) {
                mo23268a(context, it.next());
            }
        }
        m21017h(str);
    }

    public synchronized void mo23268a_(Context context, bph bph) {
        ArrayList<bph> arrayList;
        if (this.f16059b == null) {
            this.f16059b = new HashMap<>();
        }
        boolean z = false;
        if (this.f16059b.containsKey(bph.mo23354i())) {
            Iterator it = new ArrayList(this.f16059b.get(bph.mo23354i())).iterator();
            while (true) {
                if (!it.hasNext()) {
                    bph bph2 = (bph) it.next();
                    if (bph2.mo23339c().equals(bph.mo23339c()) || boh.m18304a().mo23263a(context, bph2.mo23339c(), bph.mo23339c())) {
                        z = true;
                    }
                    if (!it.hasNext()) {
                        break;
                    }
                }
            }
            z = true;
        }
        if (!z) {
            if (this.f16059b.containsKey(bph.mo23354i())) {
                arrayList = this.f16059b.get(bph.mo23354i());
                if (!TextUtils.isEmpty(bph.mo23354i()) && bph.mo23354i().toLowerCase().contains("facebook.com")) {
                    arrayList.clear();
                }
                arrayList.add(bph);
            } else {
                arrayList = new ArrayList<>();
                arrayList.add(bph);
                this.f16059b.put(bph.mo23354i(), arrayList);
            }
            EventBus.getDefault().post(new bob(arrayList.size(), bph.mo23354i(), 1));
            Log.e("getVideoSize444callnew2","///"+String.valueOf(bph.mo23339c()));
            if (!bph.mo23358m()) {
                new GetVideoSizeFromUrl().mo23305a(bph);
            }
        }
    }
    public synchronized void mo23268a(Context context, bph bph) {
        ArrayList<bph> arrayList;
        if (this.f16059b == null) {
            this.f16059b = new HashMap<>();
        }
        Object obj = null;
        if (this.f16059b.containsKey(bph.mo23354i())) {
            Iterator it = new ArrayList(this.f16059b.get(bph.mo23354i())).iterator();
            while (it.hasNext()) {
                    bph bph2 = (bph) it.next();
                if (!bph2.mo23339c().equals(bph.mo23339c())) {
                    if (  boh.m18304a().mo23263a(context, bph2.mo23339c(), bph.mo23339c())) {
                         break;
                    }
                } else {
                    obj = 1;
                        break;
                    }
                obj = null;
            }

        }
        if (obj == null) {
            if (this.f16059b.containsKey(bph.mo23354i())) {
                arrayList = this.f16059b.get(bph.mo23354i());
                if (!TextUtils.isEmpty(bph.mo23354i()) && bph.mo23354i().toLowerCase().contains("facebook.com")) {
                    arrayList.clear();
                }
                arrayList.add(bph);
            } else {
                arrayList = new ArrayList<>();
                arrayList.add(bph);
                this.f16059b.put(bph.mo23354i(), arrayList);
            }
            EventBus.getDefault().post(new bob(arrayList.size(), bph.mo23354i(), 1));
            if (!bph.mo23358m()) {
                new GetVideoSizeFromUrl().mo23305a(bph);
            }
        }
    }

    public void mo23272a(bph bph) {
        ArrayList arrayList;
        if (this.f16059b != null && (arrayList = this.f16059b.get(bph.mo23354i())) != null) {
            arrayList.remove(bph);
            if (arrayList.size() == 0) {
                this.f16059b.remove(bph.mo23354i());
            }
            EventBus.getDefault().post(new bob(arrayList.size(), bph.mo23354i()));
        }
    }

    /* renamed from: a */
    public void mo23265a() {
        if (this.f16059b != null) {
            this.f16059b.clear();
            EventBus.getDefault().post(new bob(0, ""));
        }
    }

    /* renamed from: a */
    public int mo23264a(String str) {
        return mo23276e(str).size();
    }

    /* renamed from: b */
    public boolean mo23273b(String str) {
        return this.f16059b != null && this.f16059b.containsKey(str);
    }

    /* renamed from: c */
    public void mo23274c(String str) {
        if (mo23273b(str)) {
            this.f16059b.remove(str);
        }
    }

    /* renamed from: d */
    public boolean mo23275d(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || this.f16059b == null) {
            return false;
        }
        Iterator<String> it = this.f16059b.keySet().iterator();
        while (it.hasNext() && !z) {
            ArrayList arrayList = this.f16059b.get(it.next());
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((bph) it2.next()).mo23346e().equals(str)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: e */
    public ArrayList<bph> mo23276e(String str) {
        if (this.f16059b == null) {
            this.f16059b = new HashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return new ArrayList<>();
        }
        ArrayList<bph> arrayList = this.f16059b.get(str);
        if (arrayList == null) {
            return new ArrayList<>();
        }
        if (arrayList.size() > 1) {
            try {
                Collections.sort(arrayList, new Comparator<bph>() {
                    /* renamed from: a */
                    public int compare(bph bph, bph bph2) {
                        if (bph2.mo23359n() <= 0 || bph.mo23359n() <= 0) {
                            return awt.m7204b(bph2.getVideoSize(), bph.getVideoSize());
                        }
                        return awt.m7204b((long) bph2.mo23359n(), (long) bph.mo23359n());
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
    public ArrayList<bph> mo24562f(String str) {
        if (this.f16059b == null) {
            this.f16059b = new HashMap<>();
        }
        if (TextUtils.isEmpty(str)) {
            return new ArrayList<>();
        }
        ArrayList<bph> arrayList = this.f16059b.get(str);
        return arrayList == null ? new ArrayList<>() : arrayList;
    }
    public boolean mo24563g(String str) {
        ArrayList<bph> f = mo24562f(str);
        int size = f.size();
        for (int i = 0; i < size; i++) {
            if (f.get(i).mo23359n() != 0) {
                return true;
            }
        }
        return false;
    }
    private boi() {
    }

    /* renamed from: b */
    public static boi m18319b() {
        if (f16058a == null) {
            f16058a = new boi();
        }
        return f16058a;
    }

    /* renamed from: a */
    public void mo23269a(Context context, String str, String str2, String str3) {
        m18318a(context, str, str2, str3, true, 0, 0, "");
    }

    /* renamed from: a */
    public void mo23271a(Context context, String str, String str2, String str3, boolean z) {
        m18318a(context, str, str2, str3, z, 0, 0, "");
    }

    /* renamed from: a */
 /*   public void mo23270a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        m18318a(context, str, str2, str3, true, i, i2, str4);
    }
*/
    /* renamed from: a */
   private void m18318a___(Context context, String str, String str2, String str3, boolean z, int i, int i2, String str4) {
        Context context2 = context;
        String str5 = str;
        if (TextUtils.isEmpty(str5) || bol.m18346a().mo23283b(str5)) {
            return;
        }
        if (str5.contains("fapteentube.com") && str5.contains("?")) {
            str5 = str5.substring(0, str5.lastIndexOf("?") - 1);
        }
        String str6 = str5;
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str6);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        if (TextUtils.isEmpty(fileExtensionFromUrl) || fileExtensionFromUrl.length() < 3) {
            return;
        }
        if (bon.m18359a().mo23288c(fileExtensionFromUrl) || bon.m18359a().mo23287b(fileExtensionFromUrl) || ((bon.m18359a().mo23289d(fileExtensionFromUrl) && z) || bon.m18359a().mo23290e(fileExtensionFromUrl) || bon.m18359a().mo23292g(fileExtensionFromUrl) || bon.m18359a().mo23291f(fileExtensionFromUrl))) {
            bph a = bnm.m18246a().mo23218a(context2, str6);
            if (a != null) {
                a.mo23338b(true);
                a.mo23340c(i);
                a.mo23337b(str6);
                mo23268a(context2, a);
                return;
            } else if (bon.m18359a().mo23288c(fileExtensionFromUrl)) {
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    mimeTypeFromExtension = "audio/" + fileExtensionFromUrl;
                }
                m18316a(context2, str6, str2, 4, mimeTypeFromExtension, str3);
                return;
            } else if (bon.m18359a().mo23287b(fileExtensionFromUrl)) {
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    mimeTypeFromExtension = "video/" + fileExtensionFromUrl;
                }
                m18317a(context2, str6, str2, 2, mimeTypeFromExtension, str3, i, i2, str4);
                return;
            } else if (bon.m18359a().mo23289d(fileExtensionFromUrl) && z) {
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    mimeTypeFromExtension = "image/" + fileExtensionFromUrl;
                }
                m18316a(context2, str6, str2, 3, mimeTypeFromExtension, str3);
                return;
            } else if (bon.m18359a().mo23290e(fileExtensionFromUrl)) {
                m18316a(context2, str6, str2, 5, "application/vnd.android.package-archive", str3);
                return;
            } else if (bon.m18359a().mo23292g(fileExtensionFromUrl)) {
                m18316a(context2, str6, str2, 6, "application/zip", str3);
                return;
            } else if (bon.m18359a().mo23291f(fileExtensionFromUrl)) {
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    mimeTypeFromExtension = "text/" + fileExtensionFromUrl;
                }
                m18316a(context2, str6, str2, 7, mimeTypeFromExtension, str3);
                return;
            }
        }
    }


    private void m18318a(Context context, String str, String str2, String str3, boolean z, int i, int i2, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        Context context2 = context;
        String str9 = str;
        if (TextUtils.isEmpty(str) || bol.m18346a().mo23283b(str)) {
            return;
        }
        String substring = (!str.contains("fapteentube.com") || !str.contains("?")) ? str9 : str.substring(0, str.lastIndexOf("?") - 1);
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(substring);
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        if (TextUtils.isEmpty(fileExtensionFromUrl) || fileExtensionFromUrl.length() < 3) {
        } else if (bon.m18359a().mo23288c(fileExtensionFromUrl) || bon.m18359a().mo23287b(fileExtensionFromUrl) || ((bon.m18359a().mo23289d(fileExtensionFromUrl) && z) || bon.m18359a().mo23290e(fileExtensionFromUrl) || bon.m18359a().mo23292g(fileExtensionFromUrl) || bon.m18359a().mo23291f(fileExtensionFromUrl))) {
            bph a = bnm.m18246a().mo23218a(context, substring);
            if (a != null) {
                a.mo23338b(true);
                a.mo23340c(i);
                a.mo23337b(substring);
                mo23268a(context, a);
            } else if (bon.m18359a().mo23288c(fileExtensionFromUrl)) {
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    str8 = "audio/" + fileExtensionFromUrl;
                } else {
                    str8 = mimeTypeFromExtension;
                }
                m18316a(context, substring, str2, 4, str8, str3);
            } else if (bon.m18359a().mo23287b(fileExtensionFromUrl)) {
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    str7 = "video/" + fileExtensionFromUrl;
                } else {
                    str7 = mimeTypeFromExtension;
                }
                m18317a(context, substring, str2, 2, str7, str3, i, i2, str4);
            } else if (bon.m18359a().mo23289d(fileExtensionFromUrl) && z) {
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    str6 = "image/" + fileExtensionFromUrl;
                } else {
                    str6 = mimeTypeFromExtension;
                }
                m18316a(context, substring, str2, 3, str6, str3);
            } else if (bon.m18359a().mo23290e(fileExtensionFromUrl)) {
                m18316a(context, substring, str2, 5, "application/vnd.android.package-archive", str3);
            } else if (bon.m18359a().mo23292g(fileExtensionFromUrl)) {
                m18316a(context, substring, str2, 6, "application/zip", str3);
            } else if (bon.m18359a().mo23291f(fileExtensionFromUrl)) {
                if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                    str5 = "text/" + fileExtensionFromUrl;
                } else {
                    str5 = mimeTypeFromExtension;
                }
                m18316a(context, substring, str2, 7, str5, str3);
            }
        }
    }

    /* renamed from: a */
    private void m18316a(Context context, String str, String str2, int i, String str3, String str4) {
        mo23268a(context, bpd.m18501a(context, str, str2, i, bpc.m18491a(context, str, i, str3, (String) null, str4)));
    }

    /* renamed from: a */
    private void m18317a(Context context, String str, String str2, int i, String str3, String str4, int i2, int i3, String str5) {
        Context context2 = context;
        String str6 = str;
        bph a = bpd.m18501a(context2, str6, str2, i, bpc.m18492a(context2, str6, i, str3, (String) null, str4, !TextUtils.isEmpty(str5)));
        a.mo23340c(i2);
        a.mo23344d((long) i3);
        a.mo23349f(str5);
        mo23268a(context2, a);
    }
    public void mo24553a(Context context, String str, String str2) {
        ArrayList<bph> f = mo24562f(str2);
        if (f == null || f.size() <= 0 || !f.get(0).mo23339c().equals(str)) {
            bph a = bpd.m18501a(context, str, str2, 2, "tiktok_" + System.currentTimeMillis());
            mo23274c(str2);
            m21015b(context, a);
        }
    }
    /* renamed from: a */
    public void mo23267a(final Activity activity, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (bnm.m18246a().mo23218a((Context) activity, str) != null) {
                Toast.makeText(activity, activity.getString(R.string.lib_have_download), 1).show();
                return;
            }
            final bph a = bpd.m18501a(activity, str, str2, 3, bpc.m18491a(activity, str, 3, "image/png", (String) null, str3));
            if (box.m18457a(activity, new box.C3987a() {
                /* renamed from: a */
                public void mo21376a() {
                    boi.this.mo23266a(activity, a);
                }
            })) {
                mo23266a(activity, a);
            }
        }
    }

    /* renamed from: a */
    public void mo23266a(Activity activity, bph bph) {
        bpd.m18506a((Context) activity, bph);
        Toasty.custom(activity, activity.getString(R.string.start_downloading), (Drawable) null, activity.getResources().getColor(R.color.toast_start), 1, false, true).show();
    }
}
