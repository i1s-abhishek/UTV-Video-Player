package com.abhishek.xplayer.content;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import com.abhishek.xplayer.application.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import classesdef.inplayer.axc;
import classesdef.inplayer.axi;
import classesdef.xdplayer.awx;
import classesdef.xdplayer.axe;
import classesdef.xdplayer.axy;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.content.d */
public class C2636d {
    /* access modifiers changed from: private */
    /* renamed from: d */
    public static String m12156d() {
        File file = new File(axc.appFolder());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    /* renamed from: b */
    private static String m12149b(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        File e = m12158e();
        String e2 = axe.m7324e(str);
        if (e2 == null) {
            str2 = "";
        } else {
            str2 = axe.m7322c(e2);
        }
        if (str2 != null) {
            str2 = str2.trim();
        }
        return new File(e, str2 + "_" + axe.m7314a(str, 0)).getAbsolutePath();
    }

    /* renamed from: e */
    private static File m12158e() {
        File file = new File(axc.appFolder(), ".private");
        if (!file.exists()) {
            file.mkdirs();
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m12148b(MediaFileInfo mediaFileInfo) {
        return axi.m7353a(mediaFileInfo.mo17890d(), mediaFileInfo.f10497b, mediaFileInfo.mo17892e(), "video/mp4");
    }

    /* renamed from: a */
    public static MediaFolder m12138a() {
        ArrayList arrayList;
        File[] listFiles;
        List<PrivateVideoInfo.C2634a> a = new PrivateVideoInfo(MyApplication.getApplicationContext_()).mo17945a((String) null, (String[]) null);
        int i = 0;
        if (a != null) {
            arrayList = new ArrayList(a.size());
            final HashSet hashSet = new HashSet();
            for (PrivateVideoInfo.C2634a next : a) {
                if (next.f10580b != null) {
                    MediaFileInfo mediaFileInfo = new MediaFileInfo();
                    mediaFileInfo.mo17888b(next.f10582d);
                    mediaFileInfo.mo17884a(next.f10580b);
                    mediaFileInfo.mo17881a(1);
                    mediaFileInfo.mo17882a(next.f10585g);
                    mediaFileInfo.f10496a = new File(mediaFileInfo.mo17890d()).length();
                    mediaFileInfo.mo17885a(true);
                    mediaFileInfo.f10497b = next.f10581c;
                    mediaFileInfo.mo17887b(next.f10586h);
                    if (axe.m7319a(mediaFileInfo.mo17890d(), false)) {
                        arrayList.add(mediaFileInfo);
                        hashSet.add(axy.m7460a(mediaFileInfo.mo17890d()).toLowerCase(Locale.ENGLISH));
                    }
                }
            }
            File[] listFiles2 = m12158e().listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return !str.startsWith(".") && !hashSet.contains(str.toLowerCase(Locale.ENGLISH));
                }
            });
            long j = 0;
            if (listFiles2 != null) {
                int length = listFiles2.length;
                int i2 = 0;
                int i3 = 1;
                while (i2 < length) {
                    File file = listFiles2[i2];
                    String name = file.getName();
                    int indexOf = name.indexOf(95);
                    if (indexOf >= 0) {
                        String d = axe.m7323d(name.substring(i, indexOf));
                        if (d == null) {
                            d = "mp4";
                        }
                        String str = "." + d;
                        if (axi.m7358a(str)) {
                            String str2 = "XPlayer_" + System.currentTimeMillis() + str;
                            long b = axi.m7359b(file.getAbsolutePath());
                            if (b > j) {
                                MediaFileInfo mediaFileInfo2 = new MediaFileInfo();
                                mediaFileInfo2.mo17888b("Private Video " + i3);
                                mediaFileInfo2.mo17884a(file.getAbsolutePath());
                                mediaFileInfo2.mo17881a(1);
                                mediaFileInfo2.mo17882a(b);
                                mediaFileInfo2.f10496a = new File(mediaFileInfo2.mo17890d()).length();
                                mediaFileInfo2.mo17885a(true);
                                mediaFileInfo2.f10497b = new File(m12156d(), str2).getAbsolutePath();
                                mediaFileInfo2.mo17887b(file.lastModified());
                                arrayList.add(mediaFileInfo2);
                                i3++;
                            }
                        }
                    }
                    i2++;
                    i = 0;
                    j = 0;
                }
            }
            File file2 = new File(m12158e(), ".sd");
            if (file2.isDirectory() && (listFiles = file2.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return !str.startsWith(".") && !hashSet.contains(str.toLowerCase(Locale.ENGLISH));
                }
            })) != null) {
                for (File file3 : listFiles) {
                    if (file3.length() <= 10240) {
                        try {
                            JSONObject jSONObject = new JSONObject(axe.m7311a(file3, "utf-8"));
                            String string = jSONObject.getString("A");
                            String string2 = jSONObject.getString("B");
                            if (!(string == null || string2 == null)) {
                                File file4 = new File(string);
                                if (file4.exists()) {
                                    long b2 = axi.m7359b(file4.getAbsolutePath());
                                    if (b2 > 0) {
                                        MediaFileInfo mediaFileInfo3 = new MediaFileInfo();
                                        mediaFileInfo3.mo17888b(axy.m7460a(string2));
                                        mediaFileInfo3.mo17884a(file4.getAbsolutePath());
                                        mediaFileInfo3.mo17881a(1);
                                        mediaFileInfo3.mo17882a(b2);
                                        mediaFileInfo3.f10496a = file4.length();
                                        mediaFileInfo3.mo17885a(true);
                                        mediaFileInfo3.f10497b = string2;
                                        mediaFileInfo3.mo17887b(file4.lastModified());
                                        arrayList.add(mediaFileInfo3);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            VideoManager.m12184a((List<MediaFileInfo>) arrayList, false);
        } else {
            arrayList = new ArrayList(0);
        }
        return new MediaFolder((String) null, (String) null, arrayList);
    }

    /* renamed from: a */
    public static void m12145a(final List<String> list, final Runnable runnable) {
        if (list != null && !list.isEmpty()) {
            PrivateVideoInfo.f10576a.execute(new Runnable() {
                public void run() {
                    new PrivateVideoInfo(MyApplication.getApplicationContext_()).mo17949c(list);
                    if (runnable != null) {
                        MyApplication.myApplication().runnable(runnable);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    static void m12140a(int i, List<MediaFileInfo> list, Set<String> set, boolean z, C2625b.C2627a aVar) {
        if (list != null && !list.isEmpty()) {
            final List<MediaFileInfo> list2 = list;
            final Set<String> set2 = set;
            final int i2 = i;
            final boolean z2 = z;
            final C2625b.C2627a aVar2 = aVar;
            PrivateVideoInfo.f10576a.execute(new Runnable() {
                public void run() {
                    C2636d.m12151b(new PrivateVideoInfo(MyApplication.getApplicationContext_()), list2, set2, i2, z2, aVar2);
                }
            });
        } else if (aVar != null) {
            aVar.mo17939a(Collections.emptySet(), 0, 0, (String) null, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m12151b(PrivateVideoInfo cVar, List<MediaFileInfo> list, Set<String> set, int i, boolean z, C2625b.C2627a aVar) {
        int i2;
        boolean z2;
        PrivateVideoInfo cVar2 = cVar;
        Set<String> set2 = set;
        final C2625b.C2627a aVar2 = aVar;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList(list.size());
        Set<String> hashSet = set2 == null ? new HashSet<>() : set2;
        for (MediaFileInfo next : list) {
            if (set2 == null || !set2.contains(next.mo17890d())) {
                PrivateVideoInfo.C2634a a = cVar.mo17944a();
                a.f10584f = currentTimeMillis;
                a.f10581c = next.mo17890d();
                a.f10580b = m12149b(a.f10581c);
                a.f10582d = next.mo17892e();
                a.f10585g = next.mo17893f();
                a.f10586h = next.mo17895h();
                if (axe.m7319a(a.f10581c, false)) {
                    arrayList.add(a);
                }
            }
        }
        if (cVar2.mo17947a((List<PrivateVideoInfo.C2634a>) arrayList)) {
            if (set2 == null) {
                i2 = 0;
            } else {
                i2 = set.size();
            }
            RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
            ArrayList arrayList2 = new ArrayList(0);
            ArrayList arrayList3 = new ArrayList(0);
            Iterator it = arrayList.iterator();
            int i3 = i2;
            boolean z3 = false;
            String str = null;
            boolean z4 = false;
            while (it.hasNext()) {
                PrivateVideoInfo.C2634a aVar3 = (PrivateVideoInfo.C2634a) it.next();
                File file = new File(aVar3.f10581c);
                File file2 = new File(aVar3.f10580b);
                Iterator it2 = it;
                if (file.renameTo(file2)) {
                    z2 = z4;
                    i3++;
                    hashSet.add(file.getAbsolutePath());
                    recentMediaStorage.mo17905a(aVar3.f10581c, aVar3.f10580b, true);
                } else if (file.exists()) {
                    z2 = z4;
                    if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26 && !m12155c(aVar3.f10581c)) {
                        aVar3.f10580b = new File(file.getParent(), file2.getName()).getAbsolutePath();
                        if (!awx.m7222a(MyApplication.getApplicationContext_(), file, file2.getName()) || !cVar2.mo17946a(aVar3)) {
                            arrayList2.add(aVar3);
                            str = aVar3.f10581c;
                            z4 = z2;
                            z3 = true;
                            it = it2;
                        } else {
                            i3++;
                            hashSet.add(file.getAbsolutePath());
                            recentMediaStorage.mo17905a(aVar3.f10581c, aVar3.f10580b, true);
                            m12152b(aVar3.f10580b, aVar3.f10581c);
                            VideoManager.m12179a(file.getParent());
                        }
                    } else if (axe.m7321b(file, file2)) {
                        if (!file.delete() && file.exists()) {
                            if (Build.VERSION.SDK_INT < 26 || m12155c(aVar3.f10581c)) {
                                z4 = true;
                                hashSet.add(file.getAbsolutePath());
                                aVar3.f10583e = 1;
                                cVar2.mo17946a(aVar3);
                                i3++;
                                recentMediaStorage.mo17905a(aVar3.f10581c, aVar3.f10580b, true);
                                it = it2;
                            } else if (!awx.m7220a(MyApplication.getApplicationContext_(), file)) {
                                arrayList3.add(aVar3.f10581c);
                            }
                        }
                        z4 = z2;
                        hashSet.add(file.getAbsolutePath());
                        aVar3.f10583e = 1;
                        cVar2.mo17946a(aVar3);
                        i3++;
                        recentMediaStorage.mo17905a(aVar3.f10581c, aVar3.f10580b, true);
                        it = it2;
                    } else {
                        arrayList2.add(aVar3);
                    }
                } else {
                    z2 = z4;
                    arrayList2.add(aVar3);
                }
                z4 = z2;
                it = it2;
            }
            boolean z5 = z4;
            if (!arrayList2.isEmpty()) {
                cVar2.mo17948b(arrayList2);
            }
            if (z3 && z) {
                aVar2.mo17943c(str);
            }
            int size = arrayList2.size();
            int size2 = arrayList.size();
            int i4 = R.string.lock_sd_cant_write;
            if (size < size2) {
                if (aVar2 != null) {
                    if (!arrayList3.isEmpty()) {
                        aVar2.mo17935a((List<String>) arrayList3);
                    }
                    StringBuilder sb = new StringBuilder();
                    if (z3) {
                        sb.append(MyApplication.getApplicationContext_().getString(R.string.lock_sd_cant_write));
                    }
                    if (z5) {
                        if (sb.length() > 0) {
                            sb.append("\n\n");
                        }
                        sb.append(MyApplication.getApplicationContext_().getString(R.string.delete_failed_cant_write));
                    }
                    final int size3 = arrayList2.size();
                    final String sb2 = sb.length() > 0 ? sb.toString() : null;
                    final C2625b.C2627a aVar4 = aVar2;
                    final Set<String> set3 = hashSet;
                    final int i5 = i3;
                    final boolean z6 = z5;
                    MyApplication.myApplication().runnable((Runnable) new Runnable() {
                        public void run() {
                            aVar4.mo17939a(set3, i5, size3, sb2, z6);
                        }
                    });
                }
            } else if (aVar2 != null) {
                Context a2 = MyApplication.getApplicationContext_();
                if (!z3) {
                    i4 = R.string.lock_storage_full;
                }
                final String string = a2.getString(i4);
                MyApplication.myApplication().runnable((Runnable) new Runnable() {
                    public void run() {
                        aVar2.mo17938a(string);
                    }
                });
            }
        } else if (aVar2 != null) {
            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                public void run() {
                    aVar2.mo17938a(MyApplication.getApplicationContext_().getString(R.string.lock_storage_full));
                }
            });
        }
    }
    private static void m12151bvv(final PrivateVideoInfo c, final List<MediaFileInfo> list, final Set<String> set, int size, final boolean b, final C2625b.C2627a b$a) {
        final long currentTimeMillis = System.currentTimeMillis();
        final ArrayList<PrivateVideoInfo.C2634a> list2 = new ArrayList<PrivateVideoInfo.C2634a>(list.size());
        HashSet<String> set2;
        if (set == null) {
            set2 = new HashSet<String>();
        }
        else {
            set2 = (HashSet<String>)set;
        }
        final Iterator<MediaFileInfo> iterator = list.iterator();
        boolean b2;
        while (true) {
            final boolean hasNext = iterator.hasNext();
            b2 = false;
            if (!hasNext) {
                break;
            }
            final MediaFileInfo mediaFileInfo = iterator.next();
            if (set != null && set.contains(mediaFileInfo.mo17890d())) {
                continue;
            }
            final PrivateVideoInfo.C2634a a = c.mo17944a();
            a.f10584f = currentTimeMillis;
            a.f10581c = mediaFileInfo.mo17890d();
            a.f10580b = m12149b(a.f10581c);
            a.f10582d = mediaFileInfo.mo17892e();
            a.f10585g = mediaFileInfo.mo17893f();
            a.f10586h = mediaFileInfo.mo17895h();
            if (axe.m7319a(a.f10581c, false)) {
                list2.add(a);
            }

        }
        if (c.mo17947a((List)list2)) {
            if (set == null) {
                size = 0;
            }
            else {
                size = set.size();
            }
            final RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
            final ArrayList<PrivateVideoInfo.C2634a> list3 = new ArrayList<PrivateVideoInfo.C2634a>(0);
            final ArrayList<String> list4 = new ArrayList<String>(0);
            final Iterator<PrivateVideoInfo.C2634a> iterator2 = list2.iterator();
            String c2 = null;
            int n = 0;
            while (iterator2.hasNext()) {
                final PrivateVideoInfo.C2634a c$a = iterator2.next();
                final File file = new File(c$a.f10581c);
                final File dest = new File(c$a.f10580b);
                if (!file.renameTo(dest)) {
                    if (file.exists()) {
                        final int sdk_INT = Build.VERSION.SDK_INT;
                        final int n2 = n;
                        if (sdk_INT >= 21 && Build.VERSION.SDK_INT < 26 && !m12155c(c$a.f10581c)) {
                            c$a.f10580b = new File(file.getParent(), dest.getName()).getAbsolutePath();
                            if (awx.m7222a(MyApplication.getApplicationContext_(), file, dest.getName()) && c.mo17946a(c$a)) {
                                ++size;
                                set2.add(file.getAbsolutePath());
                                recentMediaStorage.mo17905a(c$a.f10581c, c$a.f10580b, true);
                                m12152b(c$a.f10580b, c$a.f10581c);
                                VideoManager.m12179a(file.getParent());
                                n = n2;
                            }
                            else {
                                list3.add(c$a);
                                c2 = c$a.f10581c;
                                n = n2;
                                b2 = true;
                            }
                        }
                        else if (axe.m7321b(file, dest)) {
                            Label_0567: {
                                if (!file.delete() && file.exists()) {
                                    if (Build.VERSION.SDK_INT < 26 || m12155c(c$a.f10581c)) {
                                        n = 1;
                                        break Label_0567;
                                    }
                                    if (!awx.m7220a(MyApplication.getApplicationContext_(), file)) {
                                        list4.add(c$a.f10581c);
                                    }
                                }
                                n = n2;
                            }
                            set2.add(file.getAbsolutePath());
                            c$a.f10583e = 1;
                            c.mo17946a(c$a);
                            ++size;
                            recentMediaStorage.mo17905a(c$a.f10581c, c$a.f10580b, true);
                        }
                        else {
                            list3.add(c$a);
                        }
                    }
                    else {
                        list3.add(c$a);
                    }
                }
                else {
                    ++size;
                    set2.add(file.getAbsolutePath());
                    recentMediaStorage.mo17905a(c$a.f10581c, c$a.f10580b, true);
                }
            }
            if (!list3.isEmpty()) {
                c.mo17948b((List)list3);
            }
            if (b2 && b) {
                b$a.mo17943c(c2);
            }
            final int size2 = list3.size();
            final int size3 = list2.size();
            final int n3 = R.string.lock_sd_cant_write;
            if (size2 < size3) {
                if (b$a != null) {
                    if (!list4.isEmpty()) {
                        b$a.mo17935a((List)list4);
                    }
                    final StringBuilder sb = new StringBuilder();
                    if (b2) {
                        sb.append(MyApplication.getApplicationContext_().getString(R.string.lock_sd_cant_write));
                    }
                    if (n != 0) {
                        if (sb.length() > 0) {
                            sb.append("\n\n");
                        }
                        sb.append(MyApplication.getApplicationContext_().getString(R.string.delete_failed_cant_write));
                    }
                    final int size4 = list3.size();
                    String string;
                    if (sb.length() > 0) {
                        string = sb.toString();
                    }
                    else {
                        string = null;
                    }
                    int finalN = n;
                    int finalSize1 = size;
                    MyApplication.myApplication().runnable((Runnable) new Runnable() {
                        public void run() {
                            b$a.mo17939a(set2, finalSize1, size4, string, (boolean)(finalN != 0));
                        }
                    });}
            }
            else if (b$a != null) {
                final Context a2 = MyApplication.getApplicationContext_();
                if (b2) {
                    size = n3;
                }
                else {
                    size = R.string.lock_storage_full;
                }
                int finalSize = size;
                MyApplication.myApplication().runnable((Runnable) new Runnable() {
                    public void run() {
                        b$a.mo17938a(a2.getString(finalSize));
                    }
                });  }
        }
        else if (b$a != null) {
            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                public void run() {
                    b$a.mo17938a(MyApplication.getApplicationContext_().getString(R.string.lock_storage_full));
                }
            });        }
    }

    /* access modifiers changed from: private|static */
    public static void m12151bbv(PrivateVideoInfo cVar, List<MediaFileInfo> list, Set<String> set, int i, boolean z, C2625b.C2627a aVar) {
        boolean z2;
        boolean z3;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<PrivateVideoInfo.C2634a> arrayList = new ArrayList<PrivateVideoInfo.C2634a>(list.size());
        Set<String> set2 = set == null ? new HashSet<>() : set;
        Iterator it = list.iterator();
        while (true) {
            z2 = false;
            if (!it.hasNext()) {
                break;
            }
            MediaFileInfo mediaFileInfo = (MediaFileInfo) it.next();
            if (set != null) {
                if (set.contains(mediaFileInfo.mo17890d())) {
                }
            }
            PrivateVideoInfo.C2634a  a= cVar.mo17944a();
            a.f10584f = currentTimeMillis;
            a.f10581c = mediaFileInfo.mo17890d();
            a.f10580b = m12149b(a.f10581c);
            a.f10582d = mediaFileInfo.mo17892e();
            a.f10585g = mediaFileInfo.mo17893f();
            a.f10586h = mediaFileInfo.mo17895h();
            if (axe.m7319a(a.f10581c, false)) {
                arrayList.add(a);
            }
        }
        if (cVar.mo17947a(arrayList)) {
            int size = set == null ? 0 : set.size();
            RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
            ArrayList arrayList2 = new ArrayList(0);
            ArrayList arrayList3 = new ArrayList(0);
            String str = null;
            boolean z4 = false;
            int i2 = size;
            for (PrivateVideoInfo.C2634a aVar2 : arrayList) {
                File file = new File(aVar2.f10581c);
                File file2 = new File(aVar2.f10580b);
                if (!file.renameTo(file2)) {
                    if (!file.exists()) {
                        arrayList2.add(aVar2);
                    } else if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26 && !m12155c(aVar2.f10581c)) {
                        aVar2.f10580b = new File(file.getParent(), file2.getName()).getAbsolutePath();
                        if (!awx.m7222a(MyApplication.getApplicationContext_(), file, file2.getName()) || !cVar.mo17946a(aVar2)) {
                            arrayList2.add(aVar2);
                            String str2 = aVar2.f10581c;
                            z3 = true;
                            str = str2;
                        } else {
                            i2++;
                            set2.add(file.getAbsolutePath());
                            recentMediaStorage.mo17905a(aVar2.f10581c, aVar2.f10580b, true);
                            m12152b(aVar2.f10580b, aVar2.f10581c);
                            VideoManager.m12179a(file.getParent());
                            z3 = z2;
                        }
                    } else if (axe.m7321b(file, file2)) {
                        if (!file.delete() && file.exists()) {
                            if (Build.VERSION.SDK_INT < 26 || m12155c(aVar2.f10581c)) {
                                z4 = true;
                            } else if (!awx.m7220a(MyApplication.getApplicationContext_(), file)) {
                                arrayList3.add(aVar2.f10581c);
                            }
                        }
                        set2.add(file.getAbsolutePath());
                        aVar2.f10583e = 1;
                        cVar.mo17946a(aVar2);
                        i2++;
                        recentMediaStorage.mo17905a(aVar2.f10581c, aVar2.f10580b, true);
                        z3 = z2;
                    } else {
                        arrayList2.add(aVar2);
                    }
                    z3 = z2;
                } else {
                    i2++;
                    set2.add(file.getAbsolutePath());
                    recentMediaStorage.mo17905a(aVar2.f10581c, aVar2.f10580b, true);
                    z3 = z2;
                }
                z2 = z3;
            }
            if (!arrayList2.isEmpty()) {
                cVar.mo17948b(arrayList2);
            }
            if (z2 && z) {
                aVar.mo17943c(str);
            }
            int i3 =  R.string.lock_sd_cant_write;
            if (arrayList2.size() < arrayList.size()) {
                if (aVar != null) {
                    if (!arrayList3.isEmpty()) {
                        aVar.mo17935a(arrayList3);
                    }
                    StringBuilder sb = new StringBuilder();
                    if (z2) {
                        sb.append(MyApplication.getApplicationContext_().getString(R.string.lock_sd_cant_write));
                    }
                    if (z4) {
                        if (sb.length() > 0) {
                            sb.append("\n\n");
                        }
                        sb.append(MyApplication.getApplicationContext_().getString(R.string.delete_failed_cant_write));
                    }
                    int finalI = i2;
                    boolean finalZ = z4;
                    MyApplication.myApplication().runnable((Runnable) new Runnable() {
                        public void run() {
                            aVar.mo17939a(set2, finalI, arrayList2.size(), sb.length() > 0 ? sb.toString() : null, finalZ);
                        }
                    });

                }
            } else if (aVar != null) {
                Context a2 = MyApplication.getApplicationContext_();
                if (!z2) {
                    i3 =  R.string.lock_storage_full;
                }
                final String string = a2.getString(i3);
                MyApplication.myApplication().runnable((Runnable) new Runnable() {
                    public void run() {
                        aVar.mo17938a(string);
                    }
                });
            }
        } else if (aVar != null) {
            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                public void run() {
                    aVar.mo17938a(MyApplication.getApplicationContext_().getString(R.string.lock_storage_full));
                }
            });

        }
    }



    /* renamed from: a */
    static void m12144a(final List<String> list, final C2625b.C2627a aVar) {
        PrivateVideoInfo.f10576a.execute(new Runnable() {
            public void run() {
                Iterator it = list.iterator();
                while (true) {
                    boolean z = true;
                    while (true) {
                        if (it.hasNext()) {
                            if (!awx.m7220a(MyApplication.getApplicationContext_(), new File((String) it.next())) || !z) {
                                z = false;
                            }
                        } else {
                            boolean finalZ = z;
                            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                                public void run() {
                                    aVar.mo17936a(finalZ);
                                }
                            });
                            return;
                        }
                    }
                }
            }
        });
    }

    /* renamed from: c */
    private static boolean m12155c(String str) {
        return str.toLowerCase(Locale.ENGLISH).startsWith("/data/");
    }

    /* renamed from: a */
    static void m12146a(final List<MediaFileInfo> list, final List<MediaFileInfo> list2, final boolean z, final C2625b.C2629c cVar) {
        if (list != null && !list.isEmpty()) {
            PrivateVideoInfo.f10576a.execute(new Runnable() {
                public void run() {
                    final ArrayList<MediaFileInfo> arrayList = new ArrayList<>(list);
                    RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
                    ArrayList arrayList2 = new ArrayList(0);
                    String str = null;
                    boolean z = false;
                    for (MediaFileInfo mediaFileInfo : arrayList) {
                        if (list2 == null || !list2.contains(mediaFileInfo)) {
                            if (!(mediaFileInfo.f10497b == null || mediaFileInfo.mo17890d() == null)) {
                                File file = new File(mediaFileInfo.mo17890d());
                                File file2 = new File(mediaFileInfo.f10497b);
                                File parentFile = file2.getParentFile();
                                if (parentFile != null && (parentFile.exists() || parentFile.mkdirs())) {
                                    file2 = new File(mediaFileInfo.f10497b);
                                    if (C2636d.m12153b(file, file2, mediaFileInfo)) {
                                        axi.m7356a(MyApplication.getApplicationContext_(), file.getAbsolutePath());
                                        axi.m7356a(MyApplication.getApplicationContext_(), file2.getAbsolutePath());
                                        recentMediaStorage.mo17905a(mediaFileInfo.mo17890d(), mediaFileInfo.f10497b, false);
                                    }
                                }
                                if (Build.VERSION.SDK_INT >= 21) {
                                    if (TextUtils.equals(file.getParent(), file2.getParent())) {
                                        if (awx.m7222a(MyApplication.getApplicationContext_(), file, file2.getName())) {
                                            axi.m7356a(MyApplication.getApplicationContext_(), file.getAbsolutePath());
                                            axi.m7356a(MyApplication.getApplicationContext_(), file2.getAbsolutePath());
                                            recentMediaStorage.mo17905a(mediaFileInfo.mo17890d(), mediaFileInfo.f10497b, false);
                                            C2636d.m12157d(mediaFileInfo.mo17890d());
                                        } else {
                                            str = mediaFileInfo.f10497b;
                                            z = true;
                                        }
                                    } else if (Build.VERSION.SDK_INT >= 26 && awx.m7221a(MyApplication.getApplicationContext_(), file, file2, 0, C2636d.m12148b(mediaFileInfo))) {
                                        file.delete();
                                        axi.m7356a(MyApplication.getApplicationContext_(), file.getAbsolutePath());
                                        axi.m7356a(MyApplication.getApplicationContext_(), file2.getAbsolutePath());
                                        recentMediaStorage.mo17905a(mediaFileInfo.mo17890d(), mediaFileInfo.f10497b, false);
                                    }
                                }
                                if (mediaFileInfo.mo17892e() != null) {
                                    File file3 = new File(C2636d.m12156d(), mediaFileInfo.mo17892e());
                                    if (C2636d.m12153b(file, file3, mediaFileInfo)) {
                                        axi.m7356a(MyApplication.getApplicationContext_(), file.getAbsolutePath());
                                        axi.m7356a(MyApplication.getApplicationContext_(), file3.getAbsolutePath());
                                        recentMediaStorage.mo17905a(mediaFileInfo.mo17890d(), mediaFileInfo.f10497b, false);
                                    }
                                }
                            }
                        //    arrayList2.add(mediaFileInfo);
                        }
                    }
                    if (arrayList2.size() > 0 && z && z) {
                        cVar.mo17943c(str);
                    }
                    if (arrayList2.size() < arrayList.size()) {
                        arrayList.removeAll(arrayList2);
                        ArrayList arrayList3 = new ArrayList(arrayList.size());
                        for (MediaFileInfo d : arrayList) {
                            arrayList3.add(d.mo17890d());
                        }
                        new PrivateVideoInfo(MyApplication.getApplicationContext_()).mo17949c(arrayList3);
                        if (cVar != null) {
                            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                                public void run() {
                                    cVar.mo17942b((List<MediaFileInfo>) arrayList);
                                }
                            });
                        }
                    } else if (cVar != null) {
                        MyApplication.myApplication().runnable((Runnable) new Runnable() {
                            public void run() {
                                cVar.mo17941b((String) null);
                            }
                        });
                    }
                }
            });
        }
        else if (cVar != null) {
            cVar.mo17942b(/*(List<MediaFileInfo>) */Collections.emptyList());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m12153b(File file, File file2, MediaFileInfo mediaFileInfo) {
        return file.renameTo(file2);
    }

    /* renamed from: b */
    static Set<String> m12150b() {
        return Collections.emptySet();
    }

    /* renamed from: b */
    private static void m12152b(String str, String str2) {
        File file = new File(m12158e(), ".sd");
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("A", str);
            jSONObject.put("B", str2);
            axe.m7318a(jSONObject.toString(), new File(file, new File(str).getName()), "utf-8");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static void m12157d(String str) {
        File file = new File(new File(m12158e(), ".sd"), new File(str).getName());
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: a */
    public static void m12143a(String str, String str2) {
        File[] listFiles;
        String str3;
        if (str != null && str2 != null) {
            File file = new File(m12158e(), ".sd");
            if (file.isDirectory() && (listFiles = file.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return !str.startsWith(".");
                }
            })) != null) {
                if (str.endsWith("/")) {
                    str3 = str;
                } else {
                    str3 = str + "/";
                }
                String lowerCase = str3.toLowerCase(Locale.ENGLISH);
                for (File file2 : listFiles) {
                    if (file2.length() <= 10240) {
                        try {
                            JSONObject jSONObject = new JSONObject(axe.m7311a(file2, "utf-8"));
                            String string = jSONObject.getString("B");
                            String string2 = jSONObject.getString("A");
                            if (string != null && string.toLowerCase(Locale.ENGLISH).startsWith(lowerCase)) {
                                String str4 = str2 + string2.substring(str.length());
                                jSONObject.put("B", str2 + string.substring(str.length()));
                                jSONObject.put("A", str4);
                                awx.m7220a(MyApplication.getApplicationContext_(), file2);
                                axe.m7318a(jSONObject.toString(), new File(file, new File(str4).getName()), "utf-8");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
