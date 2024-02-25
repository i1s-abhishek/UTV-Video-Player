package com.abhishek.xplayer.content;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import androidx.core.util.Pair;

import com.abhishek.xplayer.application.MyApplication;
import com.abhishek.xplayer.fragments.HideListFragment;
import com.mopub.mobileads.VastIconXmlManager;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import classesdef.eventbus.awj;
import classesdef.inplayer.axc;
import classesdef.inplayer.axi;
import classesdef.inplayer.SharedPrefrence;
import classesdef.player.awr;
import classesdef.xdplayer.axe;
import classesdef.xdplayer.axy;
import classesdef.xdplayer.LogEvents;
import classesdef.xdplayer.bpj;
import hdplayer.xdplayer.videoplayer.R;


public class VideoManager {


    private static final Executor EXECUTOR = Executors.newSingleThreadExecutor();


    private static Handler handler;


    private static Set<String> f10620c;


    private static int m12162a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }


    public static void setHandler(Handler handler) {
        VideoManager.handler = handler;
    }

    public static void clearHandler(Handler handler) {
        if (VideoManager.handler == handler) {
            VideoManager.handler = null;
        }
    }
    private static void m12175a(int i, Object obj) {
        Log.e("swipeRefresh", "one1");
        m12195b(i, obj, 0, 0);
    }


    public static void m12195b(final int i, final Object obj, final int i2, final int i3) {
        Log.e("swipeRefresh", "one2");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Log.e("swipeRefresh", "one4");
            MyApplication.myApplication().runnable((Runnable) new Runnable() {
                public void run() {
                    VideoManager.m12195b(i, obj, i2, i3);
                }
            });
        } else if (handler != null) {
            Log.e("swipeRefresh_", "one3" + String.valueOf(i));
            handler.obtainMessage(i, i2, i3, obj).sendToTarget();
            Log.e("swipeRefresh__", "one3" + String.valueOf(i));
        }
    }


    public static void m12187a(final boolean includeRecent, final boolean z2, final AtomicBoolean atomicBoolean) {
        EXECUTOR.execute(new Runnable() {
            public void run() {
                VideoManager.getAllVideoFolder(includeRecent, z2, atomicBoolean);
            }
        });
    }


    public static void m12174a() {
        EXECUTOR.execute(new Runnable() {
            public void run() {
                VideoManager.m12201d();
            }
        });
    }


    public static void m12201d() {
        ArrayList arrayList;
        List<MediaFolder> a = m12173a(SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("lH9wboin", false), Environment.getExternalStorageDirectory().getAbsolutePath(), new ArrayList(), C2636d.m12150b(), HideListFragment.m12284a(), new RecentMediaStorage(MyApplication.getApplicationContext_()), new HashSet(), (List<MediaFolder>) null);
        if (a == null || a.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(a.size() + 1);
            arrayList.add(0, recentAddedVideos((Collection<MediaFolder>) a));
            arrayList.addAll(a);
        }
        m12175a(294, (Object) arrayList);
    }


    private static List<MediaFolder> m12173a(boolean z, String str, List<String> list, Set<String> set, Set<String> set2, RecentMediaStorage recentMediaStorage, Set<String> set3, List<MediaFolder> list2) {
        String str2 = str;
        Set<String> set4 = set2;
        Set<String> set5 = set3;
        List<C2668a> e = loadAndParseVideoData();
        if (e == null) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(e.size());
        for (C2668a next : e) {
            if (!(next == null || next.path == null)) {
                File file = new File(next.path);
                if (z || !file.isHidden()) {
                    if (file.exists()) {
                        if ((f10620c == null || !f10620c.contains(next.path)) && file.lastModified() == next.lastFetchedTime) {
                            MediaFolder a = m12167a(next, str2.equals(next.path) ? MyApplication.myApplication().getString(R.string.internal_sd) : file.getName());
                            if (a == null || a.f10545a == null) {
                                List<String> list3 = list;
                                RecentMediaStorage recentMediaStorage2 = recentMediaStorage;
                            } else {
                                String lowerCase = a.f10545a.toLowerCase(Locale.ENGLISH);
                                if (set4 == null || !set4.contains(lowerCase)) {
                                    if (!set5.contains(lowerCase)) {
                                        list.add(a.f10545a);
                                        set5.add(lowerCase);
                                    } else {
                                        List<String> list4 = list;
                                    }
                                    a.mo17925a(!a.f10545a.startsWith(str2));
                                    arrayList.add(a);
                                } else {
                                    List<String> list5 = list;
                                }
                                updateRecentMediaStorage(recentMediaStorage, a);
                            }
                        } else {
                            MediaFolder a2 = m12168a(next.path, str2, list, set, set4, recentMediaStorage, set5, next, z);
                            if (!(a2 == null || a2.f10545a == null)) {
                                a2.mo17925a(!a2.f10545a.startsWith(str2));
                                arrayList.add(a2);
                            }
                        }
                    }
                }
            }
            List<String> list6 = list;
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0576  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x058f  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x05ac  */
    /* JADX WARNING: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getAllVideoFolder_(boolean r44, boolean r45, AtomicBoolean r46) {
        /*
            android.content.Context r2 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            android.content.SharedPreferences r2 = p000.axn.getSharedPrefrence(r2)
            java.lang.String r3 = "lH9wboin"
            r4 = 0
            boolean r2 = r2.getBoolean(r3, r4)
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r3 = r3.getAbsolutePath()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Set r15 = com.inshot.xplayer.content.C2636d.m12150b()
            java.util.Set r13 = com.inshot.xplayer.fragments.C2690f.m12284a()
            com.inshot.xplayer.content.RecentMediaStorage r12 = new com.inshot.xplayer.content.RecentMediaStorage
            android.content.Context r5 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            r12.<init>(r5)
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            r10 = 291(0x123, float:4.08E-43)
            r9 = 1
            r16 = 0
            if (r45 == 0) goto L_0x0074
            r5 = r2
            r6 = r3
            r7 = r14
            r8 = r15
            r4 = 1
            r9 = r13
            r10 = r12
            r18 = r11
            r19 = r12
            r12 = r16
            java.util.List r5 = m12173a(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r5 == 0) goto L_0x006f
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L_0x006f
            if (r44 == 0) goto L_0x006f
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = r5.size()
            int r7 = r7 + r4
            r6.<init>(r7)
            com.inshot.xplayer.content.a r7 = m12169a((java.util.Collection<com.inshot.xplayer.content.MediaFolder>) r5)
            r8 = 0
            r6.add(r8, r7)
            r6.addAll(r5)
            r12 = 291(0x123, float:4.08E-43)
            m12175a((int) r12, (java.lang.Object) r6)
            goto L_0x0071
        L_0x006f:
            r12 = 291(0x123, float:4.08E-43)
        L_0x0071:
            r16 = r5
            goto L_0x007b
        L_0x0074:
            r18 = r11
            r19 = r12
            r4 = 1
            r12 = 291(0x123, float:4.08E-43)
        L_0x007b:
            android.content.Context r5 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            r11 = r18
            java.util.List r5 = extractMediaFoldersFromMediaFiles((android.content.Context) r5, (java.util.Set<java.lang.String>) r15, (java.util.Set<java.lang.String>) r13, (java.util.Set<java.lang.String>) r11)
            if (r16 != 0) goto L_0x0096
            java.util.ArrayList r6 = new java.util.ArrayList
            if (r5 != 0) goto L_0x008d
            r7 = 0
            goto L_0x0091
        L_0x008d:
            int r7 = r5.size()
        L_0x0091:
            r6.<init>(r7)
            r10 = r6
            goto L_0x0098
        L_0x0096:
            r10 = r16
        L_0x0098:
            r7 = 2131624167(0x7f0e00e7, float:1.8875506E38)
            if (r5 == 0) goto L_0x0254
            int r6 = r10.size()
            java.util.Iterator r5 = r5.iterator()
        L_0x00a5:
            boolean r16 = r5.hasNext()
            if (r16 == 0) goto L_0x00fb
            java.lang.Object r16 = r5.next()
            r12 = r16
            com.inshot.xplayer.content.a r12 = (com.inshot.xplayer.content.MediaFolder) r12
            java.lang.String r8 = r12.f10545a
            if (r8 == 0) goto L_0x00ba
            r14.add(r8)
        L_0x00ba:
            if (r13 == 0) goto L_0x00cd
            if (r8 == 0) goto L_0x00cd
            java.util.Locale r9 = java.util.Locale.ENGLISH
            java.lang.String r9 = r8.toLowerCase(r9)
            boolean r9 = r13.contains(r9)
            if (r9 == 0) goto L_0x00cd
        L_0x00ca:
            r12 = 291(0x123, float:4.08E-43)
            goto L_0x00a5
        L_0x00cd:
            boolean r9 = r3.equals(r8)
            if (r9 == 0) goto L_0x00de
            com.inshot.xplayer.application.MyApplication r9 = com.inshot.xplayer.application.MyApplication.myApplication()
            java.lang.String r9 = r9.getString(r7)
        L_0x00db:
            r23 = r9
            goto L_0x00e3
        L_0x00de:
            java.lang.String r9 = p000.axy.m7460a((java.lang.String) r8)
            goto L_0x00db
        L_0x00e3:
            com.inshot.xplayer.content.a r9 = new com.inshot.xplayer.content.a
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r7 = r12.f10547c
            long r25 = r12.mo17930f()
            r21 = r9
            r22 = r8
            r24 = r7
            r21.<init>(r22, r23, r24, r25)
            r10.add(r9)
            r7 = 2131624167(0x7f0e00e7, float:1.8875506E38)
            goto L_0x00ca
        L_0x00fb:
            java.util.Iterator r5 = r10.iterator()
            r7 = 0
            r8 = 0
        L_0x0101:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x024b
            java.lang.Object r9 = r5.next()
            com.inshot.xplayer.content.a r9 = (com.inshot.xplayer.content.MediaFolder) r9
            if (r7 >= r6) goto L_0x0111
            r12 = 1
            goto L_0x0112
        L_0x0111:
            r12 = 0
        L_0x0112:
            int r7 = r7 + 1
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r4 = r9.f10547c
            if (r4 == 0) goto L_0x0230
            java.lang.String r4 = r9.f10545a
            if (r4 == 0) goto L_0x0230
            java.io.File r4 = new java.io.File
            r27 = r6
            java.lang.String r6 = r9.f10545a
            r4.<init>(r6)
            com.inshot.xplayer.content.f$10 r6 = new com.inshot.xplayer.content.f$10
            r6.<init>()
            java.io.File[] r4 = r4.listFiles(r6)
            if (r4 == 0) goto L_0x0213
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            r28 = r7
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r7 = r9.f10547c
            java.util.Iterator r7 = r7.iterator()
        L_0x013d:
            boolean r16 = r7.hasNext()
            if (r16 == 0) goto L_0x016a
            java.lang.Object r16 = r7.next()
            r29 = r7
            r7 = r16
            com.inshot.xplayer.content.MediaFileInfo r7 = (com.inshot.xplayer.content.MediaFileInfo) r7
            java.lang.String r16 = r7.mo17892e()
            if (r16 == 0) goto L_0x0163
            java.lang.String r7 = r7.mo17892e()
            r30 = r8
            java.util.Locale r8 = java.util.Locale.ENGLISH
            java.lang.String r7 = r7.toLowerCase(r8)
            r6.add(r7)
            goto L_0x0165
        L_0x0163:
            r30 = r8
        L_0x0165:
            r7 = r29
            r8 = r30
            goto L_0x013d
        L_0x016a:
            r30 = r8
            int r7 = r4.length
            r8 = 0
        L_0x016e:
            if (r8 >= r7) goto L_0x020a
            r31 = r7
            r7 = r4[r8]
            boolean r16 = r7.isFile()
            if (r16 == 0) goto L_0x01f4
            r32 = r4
            java.lang.String r4 = r7.getName()
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r0 = r4.toLowerCase(r0)
            boolean r0 = r6.contains(r0)
            if (r0 != 0) goto L_0x01ef
            com.inshot.xplayer.content.MediaFileInfo r0 = new com.inshot.xplayer.content.MediaFileInfo
            r0.<init>()
            java.lang.String r4 = r7.getName()
            r0.mo17888b((java.lang.String) r4)
            java.lang.String r4 = r7.getAbsolutePath()
            r0.mo17884a((java.lang.String) r4)
            r4 = 1
            r0.mo17881a((int) r4)
            r33 = r2
            r34 = r3
            r2 = 0
            r0.mo17882a((long) r2)
            long r2 = r7.length()
            r0.f10496a = r2
            java.lang.String r2 = r7.getAbsolutePath()
            r0.f10497b = r2
            long r2 = r7.lastModified()
            r0.mo17887b((long) r2)
            java.lang.String r2 = r0.mo17890d()
            boolean r2 = r15.contains(r2)
            if (r2 != 0) goto L_0x01fa
            if (r12 == 0) goto L_0x01e7
            r2 = r19
            boolean r3 = m12189a((com.inshot.xplayer.content.RecentMediaStorage) r2, (com.inshot.xplayer.content.MediaFileInfo) r0)
            if (r3 == 0) goto L_0x01fc
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r3 = r9.f10550f
            if (r3 != 0) goto L_0x01df
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 1
            r3.<init>(r4)
            r9.f10550f = r3
        L_0x01df:
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r3 = r9.f10550f
            r3.add(r0)
            r30 = 1
            goto L_0x01fc
        L_0x01e7:
            r2 = r19
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r3 = r9.f10547c
            r3.add(r0)
            goto L_0x01fc
        L_0x01ef:
            r33 = r2
            r34 = r3
            goto L_0x01fa
        L_0x01f4:
            r33 = r2
            r34 = r3
            r32 = r4
        L_0x01fa:
            r2 = r19
        L_0x01fc:
            int r8 = r8 + 1
            r19 = r2
            r7 = r31
            r4 = r32
            r2 = r33
            r3 = r34
            goto L_0x016e
        L_0x020a:
            r33 = r2
            r34 = r3
            r2 = r19
            r8 = r30
            goto L_0x021d
        L_0x0213:
            r33 = r2
            r34 = r3
            r28 = r7
            r30 = r8
            r2 = r19
        L_0x021d:
            if (r12 != 0) goto L_0x0222
            updateRecentMediaStorage((com.inshot.xplayer.content.RecentMediaStorage) r2, (com.inshot.xplayer.content.MediaFolder) r9)
        L_0x0222:
            int r0 = r9.mo17924a()
            if (r0 != 0) goto L_0x022c
            r5.remove()
            goto L_0x023e
        L_0x022c:
            r9.mo17928d()
            goto L_0x023e
        L_0x0230:
            r33 = r2
            r34 = r3
            r27 = r6
            r28 = r7
            r30 = r8
            r2 = r19
            r8 = r30
        L_0x023e:
            r19 = r2
            r6 = r27
            r7 = r28
            r2 = r33
            r3 = r34
            r4 = 1
            goto L_0x0101
        L_0x024b:
            r33 = r2
            r34 = r3
            r30 = r8
            r2 = r19
            goto L_0x025c
        L_0x0254:
            r33 = r2
            r34 = r3
            r2 = r19
            r30 = 0
        L_0x025c:
            java.util.Iterator r0 = r14.iterator()
        L_0x0260:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0278
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0260
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.String r3 = r3.toLowerCase(r4)
            r11.add(r3)
            goto L_0x0260
        L_0x0278:
            if (r45 != 0) goto L_0x02b4
            java.util.List r0 = m12192b()
            if (r0 == 0) goto L_0x02b4
            java.util.Iterator r0 = r0.iterator()
        L_0x0284:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02b4
            java.lang.Object r1 = r0.next()
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            r6 = r34
            r1 = 2131624167(0x7f0e00e7, float:1.8875506E38)
            r7 = r14
            r3 = 0
            r8 = r15
            r9 = r10
            r12 = r10
            r10 = r13
            r35 = r11
            r11 = r2
            r36 = r12
            r1 = 291(0x123, float:4.08E-43)
            r12 = r35
            r37 = r13
            r13 = r33
            m12180a((java.lang.String) r5, (java.lang.String) r6, (java.util.List<java.lang.String>) r7, (java.util.Set<java.lang.String>) r8, (java.util.List<com.inshot.xplayer.content.MediaFolder>) r9, (java.util.Set<java.lang.String>) r10, (com.inshot.xplayer.content.RecentMediaStorage) r11, (java.util.Set<java.lang.String>) r12, (boolean) r13)
            r11 = r35
            r10 = r36
            r13 = r37
            goto L_0x0284
        L_0x02b4:
            r36 = r10
            r35 = r11
            r37 = r13
            r1 = 291(0x123, float:4.08E-43)
            r3 = 0
            r5 = r34
            r6 = r34
            r7 = r14
            r8 = r15
            r9 = r36
            r10 = r37
            r11 = r2
            r12 = r35
            r13 = r33
            m12180a((java.lang.String) r5, (java.lang.String) r6, (java.util.List<java.lang.String>) r7, (java.util.Set<java.lang.String>) r8, (java.util.List<com.inshot.xplayer.content.MediaFolder>) r9, (java.util.Set<java.lang.String>) r10, (com.inshot.xplayer.content.RecentMediaStorage) r11, (java.util.Set<java.lang.String>) r12, (boolean) r13)
            java.util.ArrayList r0 = p000.awr.m7190d()
            java.util.Iterator r13 = r0.iterator()
        L_0x02d8:
            boolean r5 = r13.hasNext()
            if (r5 == 0) goto L_0x0309
            java.lang.Object r5 = r13.next()
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0304
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            boolean r6 = r6.exists()
            if (r6 == 0) goto L_0x0304
            r6 = r34
            r7 = r14
            r8 = r15
            r9 = r36
            r10 = r37
            r11 = r2
            r12 = r35
            r16 = r13
            r13 = r33
            m12180a((java.lang.String) r5, (java.lang.String) r6, (java.util.List<java.lang.String>) r7, (java.util.Set<java.lang.String>) r8, (java.util.List<com.inshot.xplayer.content.MediaFolder>) r9, (java.util.Set<java.lang.String>) r10, (com.inshot.xplayer.content.RecentMediaStorage) r11, (java.util.Set<java.lang.String>) r12, (boolean) r13)
            goto L_0x0306
        L_0x0304:
            r16 = r13
        L_0x0306:
            r13 = r16
            goto L_0x02d8
        L_0x0309:
            android.content.Context r5 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            java.lang.String r6 = "FolderData"
            r7 = 0
            android.content.SharedPreferences r13 = r5.getSharedPreferences(r6, r7)
            java.lang.String r5 = "additionDir"
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>(r7)
            java.util.Set r5 = r13.getStringSet(r5, r6)
            java.util.Iterator r12 = r5.iterator()
        L_0x0323:
            boolean r5 = r12.hasNext()
            if (r5 == 0) goto L_0x0348
            java.lang.Object r5 = r12.next()
            java.lang.String r5 = (java.lang.String) r5
            r6 = r34
            r7 = r14
            r8 = r15
            r9 = r36
            r10 = r37
            r11 = r2
            r16 = r12
            r12 = r35
            r38 = r13
            r13 = r33
            m12180a((java.lang.String) r5, (java.lang.String) r6, (java.util.List<java.lang.String>) r7, (java.util.Set<java.lang.String>) r8, (java.util.List<com.inshot.xplayer.content.MediaFolder>) r9, (java.util.Set<java.lang.String>) r10, (com.inshot.xplayer.content.RecentMediaStorage) r11, (java.util.Set<java.lang.String>) r12, (boolean) r13)
            r12 = r16
            r13 = r38
            goto L_0x0323
        L_0x0348:
            r38 = r13
            android.content.Context r5 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            bpj r5 = p000.bpj.m18578a((android.content.Context) r5)
            java.lang.String r5 = r5.mo23414u()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x036c
            r6 = r34
            r7 = r14
            r8 = r15
            r9 = r36
            r10 = r37
            r11 = r2
            r12 = r35
            r13 = r33
            m12180a((java.lang.String) r5, (java.lang.String) r6, (java.util.List<java.lang.String>) r7, (java.util.Set<java.lang.String>) r8, (java.util.List<com.inshot.xplayer.content.MediaFolder>) r9, (java.util.Set<java.lang.String>) r10, (com.inshot.xplayer.content.RecentMediaStorage) r11, (java.util.Set<java.lang.String>) r12, (boolean) r13)
        L_0x036c:
            android.content.Context r5 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            android.content.SharedPreferences r5 = android.preference.PreferenceManager.getDefaultSharedPreferences(r5)
            java.lang.String r6 = "firstScan"
            r7 = 1
            boolean r5 = r5.getBoolean(r6, r7)
            if (r5 == 0) goto L_0x039c
            r6 = r36
            int r7 = r6.size()
            r8 = 0
            int r7 = r7 + r8
            java.util.Iterator r8 = r6.iterator()
            r9 = 0
        L_0x038a:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x03a0
            java.lang.Object r10 = r8.next()
            com.inshot.xplayer.content.a r10 = (com.inshot.xplayer.content.MediaFolder) r10
            int r10 = r10.mo17924a()
            int r9 = r9 + r10
            goto L_0x038a
        L_0x039c:
            r6 = r36
            r7 = 0
            r9 = 0
        L_0x03a0:
            java.util.Iterator r8 = r6.iterator()
        L_0x03a4:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x03c9
            java.lang.Object r10 = r8.next()
            com.inshot.xplayer.content.a r10 = (com.inshot.xplayer.content.MediaFolder) r10
            if (r10 == 0) goto L_0x03c4
            java.lang.String r11 = r10.f10545a
            if (r11 == 0) goto L_0x03c4
            java.lang.String r11 = r10.f10545a
            r12 = r34
            boolean r11 = r11.startsWith(r12)
            r13 = 1
            r11 = r11 ^ r13
            r10.mo17925a(r11)
            goto L_0x03c6
        L_0x03c4:
            r12 = r34
        L_0x03c6:
            r34 = r12
            goto L_0x03a4
        L_0x03c9:
            r12 = r34
            com.inshot.xplayer.content.f$11 r8 = new com.inshot.xplayer.content.f$11
            r8.<init>()
            java.util.Collections.sort(r6, r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>(r6)
            if (r44 == 0) goto L_0x03ec
            com.inshot.xplayer.content.a r11 = m12169a((java.util.Collection<com.inshot.xplayer.content.MediaFolder>) r6)
            r13 = 0
            r6.add(r13, r11)
            if (r30 == 0) goto L_0x03e9
            r11 = 1
            m12195b((int) r1, (java.lang.Object) r6, (int) r11, (int) r13)
            goto L_0x03ec
        L_0x03e9:
            m12175a((int) r1, (java.lang.Object) r6)
        L_0x03ec:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            r6.add(r12)
            r6.addAll(r0)
            r0 = r33
            r13 = r35
            r11 = r37
            java.util.List r0 = m12172a((java.util.List<java.lang.String>) r14, (java.util.Set<java.lang.String>) r13, (java.util.Set<java.lang.String>) r11, (java.util.Set<java.lang.String>) r6, (boolean) r0)
            if (r0 == 0) goto L_0x0570
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x0570
            java.util.ArrayList r6 = new java.util.ArrayList
            int r11 = r0.size()
            r6.<init>(r11)
            java.util.Iterator r0 = r0.iterator()
        L_0x0416:
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x0511
            java.lang.Object r11 = r0.next()
            android.support.v4.util.Pair r11 = (android.support.p001v4.util.Pair) r11
            F r13 = r11.first
            com.inshot.xplayer.content.f$d r13 = (com.inshot.xplayer.content.C2651f.C2671d) r13
            if (r13 == 0) goto L_0x0416
            java.lang.String r14 = r13.f10648a
            if (r14 != 0) goto L_0x042f
            goto L_0x0416
        L_0x042f:
            java.io.File r14 = new java.io.File
            java.lang.String r1 = r13.f10648a
            r14.<init>(r1)
            boolean r1 = r14.isDirectory()
            if (r1 != 0) goto L_0x0441
            r1 = 291(0x123, float:4.08E-43)
            goto L_0x0416
        L_0x0441:
            S r1 = r11.second
            java.lang.String[] r1 = (java.lang.String[]) r1
            if (r1 == 0) goto L_0x0500
            int r11 = r1.length
            if (r11 <= 0) goto L_0x0500
            java.util.ArrayList r11 = new java.util.ArrayList
            int r3 = r1.length
            r11.<init>(r3)
            int r3 = r1.length
            r4 = 0
        L_0x0452:
            if (r4 >= r3) goto L_0x04b5
            r39 = r0
            r0 = r1[r4]
            r40 = r1
            java.io.File r1 = new java.io.File
            r1.<init>(r14, r0)
            boolean r0 = r1.isFile()
            if (r0 != 0) goto L_0x046a
            r41 = r3
            r42 = r9
            goto L_0x04aa
        L_0x046a:
            com.inshot.xplayer.content.MediaFileInfo r0 = new com.inshot.xplayer.content.MediaFileInfo
            r0.<init>()
            r41 = r3
            java.lang.String r3 = r1.getName()
            r0.mo17888b((java.lang.String) r3)
            java.lang.String r3 = r1.getAbsolutePath()
            r0.mo17884a((java.lang.String) r3)
            r3 = 1
            r0.mo17881a((int) r3)
            r42 = r9
            r9 = 0
            r0.mo17882a((long) r9)
            long r9 = r1.length()
            r0.f10496a = r9
            java.lang.String r3 = r1.getAbsolutePath()
            r0.f10497b = r3
            long r9 = r1.lastModified()
            r0.mo17887b((long) r9)
            java.lang.String r1 = r0.mo17890d()
            boolean r1 = r15.contains(r1)
            if (r1 != 0) goto L_0x04aa
            r11.add(r0)
        L_0x04aa:
            int r4 = r4 + 1
            r0 = r39
            r1 = r40
            r3 = r41
            r9 = r42
            goto L_0x0452
        L_0x04b5:
            r39 = r0
            r42 = r9
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x0504
            com.inshot.xplayer.content.a r0 = new com.inshot.xplayer.content.a
            java.lang.String r18 = r14.getAbsolutePath()
            java.lang.String r1 = r14.getAbsolutePath()
            boolean r1 = r12.equals(r1)
            if (r1 == 0) goto L_0x04dd
            com.inshot.xplayer.application.MyApplication r1 = com.inshot.xplayer.application.MyApplication.myApplication()
            r3 = 2131624167(0x7f0e00e7, float:1.8875506E38)
            java.lang.String r1 = r1.getString(r3)
        L_0x04da:
            r19 = r1
            goto L_0x04e5
        L_0x04dd:
            r3 = 2131624167(0x7f0e00e7, float:1.8875506E38)
            java.lang.String r1 = r14.getName()
            goto L_0x04da
        L_0x04e5:
            long r21 = r13.f10649b
            r17 = r0
            r20 = r11
            r17.<init>(r18, r19, r20, r21)
            updateRecentMediaStorage((com.inshot.xplayer.content.RecentMediaStorage) r2, (com.inshot.xplayer.content.MediaFolder) r0)
            int r1 = r0.mo17924a()
            if (r1 <= 0) goto L_0x0507
            r6.add(r0)
            r0.mo17928d()
            goto L_0x0507
        L_0x0500:
            r39 = r0
            r42 = r9
        L_0x0504:
            r3 = 2131624167(0x7f0e00e7, float:1.8875506E38)
        L_0x0507:
            r0 = r39
            r9 = r42
            r1 = 291(0x123, float:4.08E-43)
            r3 = 0
            goto L_0x0416
        L_0x0511:
            r42 = r9
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0572
            if (r5 == 0) goto L_0x0537
            int r0 = r6.size()
            int r7 = r7 + r0
            java.util.Iterator r0 = r6.iterator()
        L_0x0524:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0537
            java.lang.Object r1 = r0.next()
            com.inshot.xplayer.content.a r1 = (com.inshot.xplayer.content.MediaFolder) r1
            int r1 = r1.mo17924a()
            int r42 = r42 + r1
            goto L_0x0524
        L_0x0537:
            r9 = r42
            java.util.Iterator r0 = r6.iterator()
        L_0x053d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0559
            java.lang.Object r1 = r0.next()
            com.inshot.xplayer.content.a r1 = (com.inshot.xplayer.content.MediaFolder) r1
            if (r1 == 0) goto L_0x0557
            java.lang.String r2 = r1.f10545a
            boolean r2 = r2.startsWith(r12)
            r3 = 1
            r2 = r2 ^ r3
            r1.mo17925a(r2)
            goto L_0x053d
        L_0x0557:
            r3 = 1
            goto L_0x053d
        L_0x0559:
            r8.addAll(r6)
            if (r44 == 0) goto L_0x0574
            m12196b((java.util.List<com.inshot.xplayer.content.MediaFolder>) r8)
            r1 = 292(0x124, float:4.09E-43)
            android.support.v4.util.Pair r2 = new android.support.v4.util.Pair
            com.inshot.xplayer.content.a r3 = m12169a((java.util.Collection<com.inshot.xplayer.content.MediaFolder>) r8)
            r2.<init>(r6, r3)
            m12175a((int) r1, (java.lang.Object) r2)
            goto L_0x0574
        L_0x0570:
            r42 = r9
        L_0x0572:
            r9 = r42
        L_0x0574:
            if (r44 != 0) goto L_0x058f
            m12196b((java.util.List<com.inshot.xplayer.content.MediaFolder>) r8)
            com.inshot.xplayer.content.f$12 r0 = new com.inshot.xplayer.content.f$12
            r0.<init>()
            java.util.Collections.sort(r8, r0)
            com.inshot.xplayer.content.a r0 = m12169a((java.util.Collection<com.inshot.xplayer.content.MediaFolder>) r8)
            r1 = 0
            r8.add(r1, r0)
            r0 = 291(0x123, float:4.08E-43)
            m12175a((int) r0, (java.lang.Object) r8)
            goto L_0x0590
        L_0x058f:
            r1 = 0
        L_0x0590:
            r0 = r46
            r0.set(r1)
            r0 = 293(0x125, float:4.1E-43)
            r1 = 0
            m12175a((int) r0, (java.lang.Object) r1)
            r0 = r38
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = "additionDir"
            android.content.SharedPreferences$Editor r0 = r0.remove(r1)
            r0.commit()
            if (r5 == 0) goto L_0x05de
            java.util.TreeMap r0 = new java.util.TreeMap
            r0.<init>()
            java.lang.String r1 = "dirCount"
            java.lang.String r2 = java.lang.String.valueOf(r7)
            r0.put(r1, r2)
            java.lang.String r1 = "fileCount"
            java.lang.String r2 = java.lang.String.valueOf(r9)
            r0.put(r1, r2)
            java.lang.String r1 = "FirstScan"
            p000.ayb.m7491a((java.lang.String) r1, (java.util.Map<java.lang.String, java.lang.String>) r0)
            android.content.Context r0 = com.inshot.xplayer.application.MyApplication.getApplicationContext_()
            android.content.SharedPreferences r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            java.lang.String r1 = "firstScan"
            r2 = 0
            android.content.SharedPreferences$Editor r0 = r0.putBoolean(r1, r2)
            r0.apply()
        L_0x05de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2651f.getAllVideoFolder(boolean, boolean, java.util.concurrent.atomic.AtomicBoolean):void");
    }

    public static void getAllVideoFolder(boolean z, boolean z2, AtomicBoolean atomicBoolean) {
        RecentMediaStorage recentMediaStorage;
        HashSet hashSet;
        String str;
        boolean z3;
        boolean z4;
        RecentMediaStorage recentMediaStorage2;
        int i;
        int i2;
        ArrayList<MediaFolder> arrayList;
        int i3;
        boolean z5 = false;
        int i4;
        int i5;
        Iterator<Pair<C2671d, String[]>> it;
        int i6;
        int i7;
        String str2;
        Iterator<String> it2;
        List<String> b2;
        String str3;
        boolean z6;
        int i8;
        int i9;
        RecentMediaStorage recentMediaStorage3;
        String str4;
        boolean z7;
        File[] fileArr;
        RecentMediaStorage recentMediaStorage4;
        boolean z8;
        boolean z9 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("lH9wboin", false);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        ArrayList<String> arrayList2 = new ArrayList();
        Set<String> b3 = C2636d.m12150b();
        Set<String> a2 = HideListFragment.m12284a();
        RecentMediaStorage recentMediaStorage5 = new RecentMediaStorage(MyApplication.getApplicationContext_());
        HashSet hashSet2 = new HashSet();
        List<MediaFolder> list = null;
        if (z2) {
            hashSet = hashSet2;
            recentMediaStorage = recentMediaStorage5;
            List<MediaFolder> a3 = m12173a(z9, absolutePath, arrayList2, b3, a2, recentMediaStorage5, hashSet2, null);
            if (a3 != null && !a3.isEmpty() && z) {
                ArrayList arrayList3 = new ArrayList(a3.size() + 1);
                arrayList3.add(0, recentAddedVideos((Collection<MediaFolder>) a3));
                arrayList3.addAll(a3);
                m12175a(291, arrayList3);
            }
            list = a3;
        } else {
            hashSet = hashSet2;
            recentMediaStorage = recentMediaStorage5;
        }
        HashSet hashSet3 = hashSet;
        List<MediaFolder> a4 = extractMediaFoldersFromMediaFiles(MyApplication.getApplicationContext_(), b3, a2, hashSet3);
        ArrayList arrayList4 = list == null ? new ArrayList(a4 == null ? 0 : a4.size()) : (ArrayList) list;
        int i10 = R.string.internal_sd;
        if (a4 != null) {
            int size = arrayList4.size();
            for (MediaFolder aVar : a4) {
                String str5 = aVar.f10545a;
                if (str5 != null) {
                    arrayList2.add(str5);
                }
                if (a2 == null || str5 == null || !a2.contains(str5.toLowerCase(Locale.ENGLISH))) {
                    arrayList4.add(new MediaFolder(str5, absolutePath.equals(str5) ? MyApplication.myApplication().getString(i10) : axy.m7460a(str5), aVar.f10547c, aVar.mo17930f()));
                    i10 = R.string.internal_sd;
                }
            }
            Iterator it3 = arrayList4.iterator();
            int i11 = 0;
            boolean z10 = false;
            while (it3.hasNext()) {
                MediaFolder aVar2 = (MediaFolder) it3.next();
                boolean z11 = i11 < size;
                int i12 = i11 + 1;
                if (aVar2.f10547c == null || aVar2.f10545a == null) {
                    z6 = z9;
                    str3 = absolutePath;
                    i9 = size;
                    i8 = i12;
                    recentMediaStorage3 = recentMediaStorage;
                    z10 = z10;
                } else {
                    i9 = size;
                    File[] listFiles = new File(aVar2.f10545a).listFiles(new FilenameFilter() {
                        /* class com.inshot.xplayer.content.f.AnonymousClass10 */

                        public boolean accept(File file, String str) {
                            return axi.m7358a(str);
                        }
                    });
                    if (listFiles != null) {
                        HashSet hashSet4 = new HashSet();
                        i8 = i12;
                        Iterator<MediaFileInfo> it4 = aVar2.f10547c.iterator();
                        while (it4.hasNext()) {
                            MediaFileInfo next = it4.next();
                            if (next.mo17892e() != null) {
                                z8 = z10;
                                hashSet4.add(next.mo17892e().toLowerCase(Locale.ENGLISH));
                            } else {
                                z8 = z10;
                            }
                            it4 = it4;
                            z10 = z8;
                        }
                        boolean z12 = z10;
                        int length = listFiles.length;
                        int i13 = 0;
                        while (i13 < length) {
                            File file = listFiles[i13];
                            if (file.isFile()) {
                                fileArr = listFiles;
                                if (!hashSet4.contains(file.getName().toLowerCase(Locale.ENGLISH))) {
                                    MediaFileInfo mediaFileInfo = new MediaFileInfo();
                                    mediaFileInfo.mo17888b(file.getName());
                                    mediaFileInfo.mo17884a(file.getAbsolutePath());
                                    mediaFileInfo.mo17881a(1);
                                    z7 = z9;
                                    str4 = absolutePath;
                                    mediaFileInfo.mo17882a(0L);
                                    mediaFileInfo.f10496a = file.length();
                                    mediaFileInfo.f10497b = file.getAbsolutePath();
                                    mediaFileInfo.mo17887b(file.lastModified());
                                    if (!b3.contains(mediaFileInfo.mo17890d())) {
                                        if (z11) {
                                            recentMediaStorage4 = recentMediaStorage;
                                            if (m12189a(recentMediaStorage4, mediaFileInfo)) {
                                                if (aVar2.f10550f == null) {
                                                    aVar2.f10550f = new ArrayList(1);
                                                }
                                                aVar2.f10550f.add(mediaFileInfo);
                                                z12 = true;
                                            }
                                        } else {
                                            recentMediaStorage4 = recentMediaStorage;
                                            aVar2.f10547c.add(mediaFileInfo);
                                        }
                                        i13++;
                                        recentMediaStorage = recentMediaStorage4;
                                        length = length;
                                        listFiles = fileArr;
                                        z9 = z7;
                                        absolutePath = str4;
                                    }
                                } else {
                                    z7 = z9;
                                    str4 = absolutePath;
                                }
                            } else {
                                z7 = z9;
                                str4 = absolutePath;
                                fileArr = listFiles;
                            }
                            recentMediaStorage4 = recentMediaStorage;
                            i13++;
                            recentMediaStorage = recentMediaStorage4;
                            length = length;
                            listFiles = fileArr;
                            z9 = z7;
                            absolutePath = str4;
                        }
                        z6 = z9;
                        str3 = absolutePath;
                        recentMediaStorage3 = recentMediaStorage;
                        z10 = z12;
                    } else {
                        z6 = z9;
                        str3 = absolutePath;
                        i8 = i12;
                        recentMediaStorage3 = recentMediaStorage;
                    }
                    if (!z11) {
                        updateRecentMediaStorage(recentMediaStorage3, aVar2);
                    }
                    if (aVar2.mo17924a() == 0) {
                        it3.remove();
                    } else {
                        aVar2.mo17928d();
                    }
                }
                recentMediaStorage = recentMediaStorage3;
                size = i9;
                i11 = i8;
                z9 = z6;
                absolutePath = str3;
            }
            z3 = z9;
            str = absolutePath;
            z4 = z10;
            recentMediaStorage2 = recentMediaStorage;
        } else {
            z3 = z9;
            str = absolutePath;
            recentMediaStorage2 = recentMediaStorage;
            z4 = false;
        }
        for (String str6 : arrayList2) {
            if (str6 != null) {
                hashSet3.add(str6.toLowerCase(Locale.ENGLISH));
            }
        }
        if (!z2 && (b2 = m12192b()) != null) {
            for (String str7 : b2) {
                m12180a(str7, str, arrayList2, b3, arrayList4, a2, recentMediaStorage2, hashSet3, z3);
                hashSet3 = hashSet3;
                arrayList4 = arrayList4;
                a2 = a2;
            }
        }
        m12180a(str, str, arrayList2, b3, arrayList4, a2, recentMediaStorage2, hashSet3, z3);
        ArrayList<String> d2 = awr.m7190d();
        Iterator<String> it5 = d2.iterator();
        while (it5.hasNext()) {
            String next2 = it5.next();
            if (next2 == null || !new File(next2).exists()) {
                it2 = it5;
            } else {
                it2 = it5;
                m12180a(next2, str, arrayList2, b3, arrayList4, a2, recentMediaStorage2, hashSet3, z3);
            }
            it5 = it2;
        }
        SharedPreferences sharedPreferences = MyApplication.getApplicationContext_().getSharedPreferences("FolderData", 0);
        Iterator<String> it6 = sharedPreferences.getStringSet("additionDir", new HashSet(0)).iterator();
        while (it6.hasNext()) {
            m12180a(it6.next(), str, arrayList2, b3, arrayList4, a2, recentMediaStorage2, hashSet3, z3);
            it6 = it6;
            sharedPreferences = sharedPreferences;
        }
        String u = bpj.m18578a(MyApplication.getApplicationContext_()).mo23414u();
        if (!TextUtils.isEmpty(u)) {
            m12180a(u, str, arrayList2, b3, arrayList4, a2, recentMediaStorage2, hashSet3, z3);
        }
        boolean z13 = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("firstScan", true);
        if (z13) {
            arrayList = arrayList4;
            i2 = arrayList.size() + 0;
            i = 0;
            for (MediaFolder aVar3 : arrayList) {
                i += aVar3.mo17924a();
            }
        } else {
            arrayList = arrayList4;
            i2 = 0;
            i = 0;
        }
        for (MediaFolder aVar4 : arrayList) {
            if (aVar4 == null || aVar4.f10545a == null) {
                str2 = str;
            } else {
                str2 = str;
                aVar4.mo17925a(!aVar4.f10545a.startsWith(str2));
            }
            str = str2;
        }
        Collections.sort(arrayList, new Comparator<MediaFolder>() {
            /* class com.inshot.xplayer.content.f.AnonymousClass11 */

            /* renamed from: a */
            public int compare(MediaFolder aVar, MediaFolder aVar2) {
                return VideoManager.m12164a(aVar.f10545a, aVar2.f10545a);
            }
        });
        ArrayList arrayList5 = new ArrayList(arrayList);
        if (z) {
            arrayList.add(0, recentAddedVideos((Collection<MediaFolder>) arrayList));
            if (z4) {
                m12195b(291, arrayList, 1, 0);
            } else {
                m12175a(291, arrayList);
            }
        }
        HashSet hashSet5 = new HashSet();
        hashSet5.add(str);
        hashSet5.addAll(d2);
        List<Pair<C2671d, String[]>> a5 = m12172a(arrayList2, hashSet3, a2, hashSet5, z3);
        if (a5 == null || a5.isEmpty()) {
            i4 = i;
        } else {
            ArrayList<MediaFolder> arrayList6 = new ArrayList(a5.size());
            Iterator<Pair<C2671d, String[]>> it7 = a5.iterator();
            while (it7.hasNext()) {
                Pair<C2671d, String[]> next3 = it7.next();
                C2671d f = next3.first;
                if (!(f == null || ((C2671d) f).f10648a == null)) {
                    File file2 = new File(((C2671d) f).f10648a);
                    if (file2.isDirectory()) {
                        String[] strArr = (String[]) next3.second;
                        if (strArr == null || strArr.length <= 0) {
                            it = it7;
                            i5 = i;
                        } else {
                            ArrayList arrayList7 = new ArrayList(strArr.length);
                            int length2 = strArr.length;
                            int i14 = 0;
                            while (i14 < length2) {
                                File file3 = new File(file2, strArr[i14]);
                                if (!file3.isFile()) {
                                    i7 = length2;
                                    i6 = i;
                                } else {
                                    MediaFileInfo mediaFileInfo2 = new MediaFileInfo();
                                    i7 = length2;
                                    mediaFileInfo2.mo17888b(file3.getName());
                                    mediaFileInfo2.mo17884a(file3.getAbsolutePath());
                                    mediaFileInfo2.mo17881a(1);
                                    i6 = i;
                                    mediaFileInfo2.mo17882a(0L);
                                    mediaFileInfo2.f10496a = file3.length();
                                    mediaFileInfo2.f10497b = file3.getAbsolutePath();
                                    mediaFileInfo2.mo17887b(file3.lastModified());
                                    if (!b3.contains(mediaFileInfo2.mo17890d())) {
                                        arrayList7.add(mediaFileInfo2);
                                    }
                                }
                                i14++;
                                it7 = it7;
                                strArr = strArr;
                                length2 = i7;
                                i = i6;
                            }
                            it = it7;
                            i5 = i;
                            if (!arrayList7.isEmpty()) {
                                MediaFolder aVar5 = new MediaFolder(file2.getAbsolutePath(), str.equals(file2.getAbsolutePath()) ? MyApplication.myApplication().getString(R.string.internal_sd) : file2.getName(), arrayList7, ((C2671d) f).f10649b);
                                updateRecentMediaStorage(recentMediaStorage2, aVar5);
                                if (aVar5.mo17924a() > 0) {
                                    arrayList6.add(aVar5);
                                    aVar5.mo17928d();
                                }
                                it7 = it;
                                i = i5;
                            }
                        }
                        it7 = it;
                        i = i5;
                    }
                }
            }
            i4 = i;
            if (!arrayList6.isEmpty()) {
                if (z13) {
                    i2 += arrayList6.size();
                    for (MediaFolder aVar6 : arrayList6) {
                        i4 += aVar6.mo17924a();
                    }
                }
                i3 = i4;
                for (MediaFolder aVar7 : arrayList6) {
                    if (aVar7 != null) {
                        aVar7.mo17925a(!aVar7.f10545a.startsWith(str));
                    }
                }
                arrayList5.addAll(arrayList6);
                if (z) {
                    m12196b(arrayList5);
                    m12175a(292, new Pair(arrayList6, recentAddedVideos((Collection<MediaFolder>) arrayList5)));
                }
                if (z) {
                    m12196b(arrayList5);
                    Collections.sort(arrayList5, new Comparator<MediaFolder>() {
                        /* class com.inshot.xplayer.content.f.AnonymousClass12 */

                        /* renamed from: a */
                        public int compare(MediaFolder aVar, MediaFolder aVar2) {
                            return VideoManager.m12164a(aVar.f10545a, aVar2.f10545a);
                        }
                    });
                    z5 = false;
                    arrayList5.add(0, recentAddedVideos((Collection<MediaFolder>) arrayList5));
                    m12175a(291, arrayList5);
                } else {
                    z5 = false;
                }
                atomicBoolean.set(z5);
                m12175a(293, (Object) null);
                sharedPreferences.edit().remove("additionDir").commit();
                if (!z13) {
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("dirCount", String.valueOf(i2));
                    treeMap.put("fileCount", String.valueOf(i3));
                    LogEvents.m18489a("FirstScan", treeMap);
                    PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean("firstScan", false).apply();
                    return;
                }
                return;
            }
        }
        i3 = i4;
        if (z) {
        }
        atomicBoolean.set(z5);
        m12175a(293, (Object) null);
        sharedPreferences.edit().remove("additionDir").commit();
        if (!z13) {
        }
    }

    private static void getAllVideoFoldernj(final boolean b, final boolean b2, final AtomicBoolean atomicBoolean) {
        final boolean boolean1 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("lH9wboin", false);
        final String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final ArrayList<String> list = new ArrayList<String>();
        final Set b3 = C2636d.m12150b();
        final Set a = HideListFragment.m12284a();
        RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
        final HashSet<String> set = new HashSet<String>();
        Object a2 = null;
        if (!b2) {
            a2 = m12173a(boolean1, absolutePath, list, b3, a, recentMediaStorage, set, null);
            if (a2 != null && !((List) a2).isEmpty() && b) {
                final ArrayList list2 = new ArrayList<MediaFolder>(((List) a2).size() + 1);
                list2.add(0, recentAddedVideos((Collection<MediaFolder>) a2));
                list2.addAll((Collection<?>) a2);
                m12175a(291, list2);
            }
        }
        final List<MediaFolder> a3 = extractMediaFoldersFromMediaFiles(MyApplication.getApplicationContext_(), b3, a, set);
        List<MediaFolder> list3;
        if (a2 == null) {
            int size;
            if (a3 == null) {
                size = 0;
            } else {
                size = a3.size();
            }
            list3 = new ArrayList<MediaFolder>(size);
        } else {
            list3 = (List<MediaFolder>) a2;
        }
        int n = R.string.internal_sd;
        String s2;
        RecentMediaStorage recentMediaStorage6;
        boolean b6;
        if (a3 != null) {
            final int size2 = list3.size();
            for (final MediaFolder a4 : a3) {
                final String a5 = a4.f10545a;
                if (a5 != null) {
                    list.add(a5);
                }
                if (a != null && a5 != null && a.contains(a5.toLowerCase(Locale.ENGLISH))) {
                    continue;
                }
                String s;
                if (absolutePath.equals(a5)) {
                    s = MyApplication.myApplication().getString(n);
                } else {
                    s = axy.m7460a(a5);
                }
                list3.add(new MediaFolder(a5, s, a4.f10547c, a4.mo17930f()));
                n = R.string.internal_sd;
            }
            final Iterator<MediaFolder> iterator2 = list3.iterator();
            int n2 = 0;
            boolean b4 = false;
            s2 = absolutePath;
            while (iterator2.hasNext()) {
                final MediaFolder a6 = (MediaFolder) iterator2.next();
                final boolean b5 = n2 < size2;
                final int n3 = n2 + 1;
                RecentMediaStorage recentMediaStorage2;
                String s4;
                if (a6.f10547c != null && a6.f10545a != null) {
                    final File[] listFiles = new File(a6.f10545a).listFiles((FilenameFilter) new FilenameFilter() {
                        /* class com.inshot.xplayer.content.f.AnonymousClass10 */

                        public boolean accept(File file, String str) {
                            return axi.m7358a(str);
                        }
                    });
                    if (listFiles != null) {
                        final HashSet<String> set2 = new HashSet<String>();
                        for (final MediaFileInfo mediaFileInfo : a6.f10547c) {
                            if (mediaFileInfo.mo17892e() != null) {
                                set2.add(mediaFileInfo.mo17892e().toLowerCase(Locale.ENGLISH));
                            }
                        }
                        final int length = listFiles.length;
                        int i = 0;
                        final File[] array = listFiles;
                        while (i < length) {
                            final File file = array[i];
                            if (file.isFile()) {
                                if (!set2.contains(file.getName().toLowerCase(Locale.ENGLISH))) {
                                    final MediaFileInfo mediaFileInfo2 = new MediaFileInfo();
                                    mediaFileInfo2.mo17888b(file.getName());
                                    mediaFileInfo2.mo17884a(file.getAbsolutePath());
                                    mediaFileInfo2.mo17881a(1);
                                    mediaFileInfo2.mo17882a(0L);
                                    mediaFileInfo2.f10496a = file.length();
                                    mediaFileInfo2.f10497b = file.getAbsolutePath();
                                    mediaFileInfo2.mo17887b(file.lastModified());
                                    if (!b3.contains(mediaFileInfo2.mo17890d())) {
                                        if (b5) {
                                            if (m12189a(recentMediaStorage, mediaFileInfo2)) {
                                                if (a6.f10550f == null) {
                                                    a6.f10550f = new ArrayList(1);
                                                }
                                                a6.f10550f.add(mediaFileInfo2);
                                                b4 = true;
                                            }
                                        } else {
                                            a6.f10547c.add(mediaFileInfo2);
                                        }
                                    }
                                }
                            }
                            ++i;
                        }
                        final String s3 = s2;
                        recentMediaStorage2 = recentMediaStorage;
                        s4 = s3;
                    } else {
                        final RecentMediaStorage recentMediaStorage3 = recentMediaStorage;
                        s4 = s2;
                        recentMediaStorage2 = recentMediaStorage3;
                    }
                    if (!b5) {
                        updateRecentMediaStorage(recentMediaStorage2, a6);
                    }
                    if (a6.mo17924a() == 0) {
                        iterator2.remove();
                    } else {
                        a6.mo17928d();
                    }
                } else {
                    final RecentMediaStorage recentMediaStorage4 = recentMediaStorage;
                    s4 = s2;
                    recentMediaStorage2 = recentMediaStorage4;
                }
                final RecentMediaStorage recentMediaStorage5 = recentMediaStorage2;
                n2 = n3;
                s2 = s4;
                recentMediaStorage = recentMediaStorage5;
            }
            recentMediaStorage6 = recentMediaStorage;
            b6 = b4;
        } else {
            s2 = absolutePath;
            b6 = false;
            recentMediaStorage6 = recentMediaStorage;
        }
        for (final String s5 : list) {
            if (s5 != null) {
                set.add(s5.toLowerCase(Locale.ENGLISH));
            }
        }
        List<MediaFolder> list4 = list3;
        HashSet<String> set3 = set;
        Set<String> set4 = (Set<String>) a;
        if (!b2) {
            final List<String> b7 = m12192b();
            list4 = list3;
            set3 = set;
            set4 = (Set<String>) a;
            if (b7 != null) {
                final Iterator<String> iterator5 = b7.iterator();
                while (true) {
                    list4 = list3;
                    set3 = set;
                    set4 = (Set<String>) a;
                    if (!iterator5.hasNext()) {
                        break;
                    }
                    m12180a(iterator5.next(), s2, list, b3, list3, a, recentMediaStorage6, set, boolean1);
                }
            }
        }
        m12180a(s2, s2, list, b3, list4, set4, recentMediaStorage6, set3, boolean1);
        final ArrayList<String> d = awr.m7190d();
        for (String pathname : d) {
            if (pathname != null && new File(pathname).exists()) {
                m12180a(pathname, s2, list, b3, list4, set4, recentMediaStorage6, set3, boolean1);
            }
        }
        final SharedPreferences sharedPreferences = MyApplication.getApplicationContext_().getSharedPreferences("FolderData", 0);
        final Iterator<String> iterator7 = sharedPreferences.getStringSet("additionDir", (Set) new HashSet(0)).iterator();
        while (iterator7.hasNext()) {
            m12180a(iterator7.next(), s2, list, b3, list4, set4, recentMediaStorage6, set3, boolean1);
        }
        final String u = bpj.m18578a(MyApplication.getApplicationContext_()).mo23414u();
        if (!TextUtils.isEmpty((CharSequence) u)) {
            m12180a(u, s2, list, b3, list4, set4, recentMediaStorage6, set3, boolean1);
        }
        final boolean boolean2 = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("firstScan", true);
        int j;
        int n6;
        if (boolean2) {
            final List<MediaFolder> list5 = list4;
            final int n4 = list5.size() + 0;
            final Iterator<MediaFolder> iterator8 = list5.iterator();
            int n5 = 0;
            while (true) {
                j = n4;
                n6 = n5;
                if (!iterator8.hasNext()) {
                    break;
                }
                n5 += ((MediaFolder) iterator8.next()).mo17924a();
            }
        } else {
            j = 0;
            n6 = 0;
        }
        final Iterator<MediaFolder> iterator9 = list4.iterator();
        final String prefix = s2;
        while (iterator9.hasNext()) {
            final MediaFolder a7 = (MediaFolder) iterator9.next();
            if (a7 != null && a7.f10545a != null) {
                a7.mo17925a(a7.f10545a.startsWith(prefix) ^ true);
            }
        }
        Collections.sort(list4, new Comparator<MediaFolder>() {
            public int compare(MediaFolder aVar, MediaFolder aVar2) {
                return VideoManager.m12164a(aVar.f10545a, aVar2.f10545a);
            }
        });
        final ArrayList list6 = new ArrayList<MediaFolder>(list4);
        if (b) {
            list4.add(0, recentAddedVideos((Collection<MediaFolder>) list4));
            if (b6) {
                m12195b(291, list4, 1, 0);
            } else {
                m12175a(291, list4);
            }
        }
        final HashSet set5 = new HashSet();
        set5.add(prefix);
        set5.addAll(d);
        final List<Pair<C2671d, String[]>> a8 = m12172a(list, set3, set4, set5, boolean1);
        int l = 0;
        Label_2214:
        {
            int n8;
            if (a8 != null && !a8.isEmpty()) {
                final ArrayList<MediaFolder> list7 = new ArrayList<MediaFolder>(a8.size());
                Object iterator10 = a8.iterator();
                while (((Iterator) iterator10).hasNext()) {
                    final Pair pair = (Pair) ((Iterator<Pair>) iterator10).next();
                    final C2671d d2 = (C2671d) pair.first;
                    if (d2 != null) {
                        if (((C2671d) d2).f10648a == null) {
                            continue;
                        }
                        final File parent = new File(((C2671d) d2).f10648a);
                        if (!parent.isDirectory()) {
                            continue;
                        }
                        final String[] array2 = (String[]) pair.second;
                        Iterator<Pair> iterator11;
                        int n7;
                        if (array2 != null && array2.length > 0) {
                            final ArrayList list8 = new ArrayList<MediaFileInfo>(array2.length);
                            for (int length2 = array2.length, k = 0; k < length2; ++k) {
                                final File file2 = new File(parent, array2[k]);
                                if (file2.isFile()) {
                                    final MediaFileInfo mediaFileInfo3 = new MediaFileInfo();
                                    mediaFileInfo3.mo17888b(file2.getName());
                                    mediaFileInfo3.mo17884a(file2.getAbsolutePath());
                                    mediaFileInfo3.mo17881a(1);
                                    mediaFileInfo3.mo17882a(0L);
                                    mediaFileInfo3.f10496a = file2.length();
                                    mediaFileInfo3.f10497b = file2.getAbsolutePath();
                                    mediaFileInfo3.mo17887b(file2.lastModified());
                                    if (!b3.contains(mediaFileInfo3.mo17890d())) {
                                        list8.add(mediaFileInfo3);
                                    }
                                }
                            }
                            iterator11 = (Iterator<Pair>) iterator10;
                            n7 = n6;
                            if (!list8.isEmpty()) {
                                final String absolutePath2 = parent.getAbsolutePath();
                                String s6;
                                if (prefix.equals(parent.getAbsolutePath())) {
                                    s6 = MyApplication.myApplication().getString(R.string.internal_sd);
                                } else {
                                    s6 = parent.getName();
                                }
                                final MediaFolder a9 = new MediaFolder(absolutePath2, s6, (List) list8, ((C2671d) d2).f10649b);
                                updateRecentMediaStorage(recentMediaStorage6, a9);
                                iterator11 = (Iterator<Pair>) iterator10;
                                n7 = n6;
                                if (a9.mo17924a() > 0) {
                                    list7.add(a9);
                                    a9.mo17928d();
                                    iterator11 = (Iterator<Pair>) iterator10;
                                    n7 = n6;
                                }
                            }
                        } else {
                            n7 = n6;
                            iterator11 = (Iterator<Pair>) iterator10;
                        }
                        iterator10 = iterator11;
                        n6 = n7;
                    }
                }
                n8 = n6;
                if (!list7.isEmpty()) {
                    int n9 = j;
                    int n10 = n6;
                    if (boolean2) {
                        final int n11 = j + list7.size();
                        final Iterator<MediaFolder> iterator12 = list7.iterator();
                        while (true) {
                            n9 = n11;
                            n10 = n6;
                            if (!iterator12.hasNext()) {
                                break;
                            }
                            n6 += ((MediaFolder) iterator12.next()).mo17924a();
                        }
                    }
                    for (MediaFolder a10 : list7) {
                        if (a10 != null) {
                            a10.mo17925a(a10.f10545a.startsWith(prefix) ^ true);
                        }
                    }
                    list6.addAll((Collection<?>) list7);
                    j = n9;
                    l = n10;
                    if (b) {
                        m12196b((List) list6);
                        m12175a(292, new Pair((Object) list7, (Object) recentAddedVideos((Collection<MediaFolder>) list6)));
                        j = n9;
                        l = n10;
                    }
                    break Label_2214;
                }
            } else {
                n8 = n6;
            }
            l = n8;
        }
        if (!b) {
            m12196b((List<MediaFolder>) list6);
            Collections.sort((List) list6, new Comparator<MediaFolder>() {
                public int compare(MediaFolder aVar, MediaFolder aVar2) {
                    return VideoManager.m12164a(aVar.f10545a, aVar2.f10545a);
                }
            });
            list6.add(0, recentAddedVideos((Collection<MediaFolder>) list6));
            m12175a(291, list6);
        }
        atomicBoolean.set(false);
        m12175a(293, null);
        sharedPreferences.edit().remove("additionDir").commit();
        if (boolean2) {
            final TreeMap<String, String> treeMap = new TreeMap<String, String>();
            treeMap.put("dirCount", String.valueOf(j));
            treeMap.put("fileCount", String.valueOf(l));
            LogEvents.m18489a("FirstScan", (Map) treeMap);
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean("firstScan", false).apply();
        }
    }
    public static void getAllVideoFolderv(boolean includeRecent, boolean scanInternal, AtomicBoolean isScanning) {
        Context context = MyApplication.getApplicationContext_();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean isFirstScan = sharedPreferences.getBoolean("firstScan", true);
        boolean isHidden = SharedPrefrence.getSharedPrefrence(context).getBoolean("lH9wboin", false);
        String externalStoragePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        List<String> scannedDirectories = new ArrayList<>();
        scannedDirectories.add(externalStoragePath);
        Set<String> additionalDirectories = C2636d.m12150b();
        Set<String> hiddenList = HideListFragment.m12284a();
        RecentMediaStorage recentMediaStorage = new RecentMediaStorage(context);
        List<MediaFolder> videoFolders = new ArrayList<>();

        if (scanInternal) {
            List<MediaFolder> internalFolders = m12173a(isHidden, externalStoragePath, scannedDirectories, additionalDirectories, hiddenList, recentMediaStorage, new HashSet<>(), null);
            if (internalFolders != null && !internalFolders.isEmpty() && includeRecent) {
                ArrayList<MediaFolder> tempFolders = new ArrayList<>(internalFolders.size() + 1);
                tempFolders.add(0, recentAddedVideos(internalFolders));
                tempFolders.addAll(internalFolders);
                m12175a(291, tempFolders);
            }
            videoFolders.addAll(internalFolders != null ? internalFolders : Collections.emptyList());
        }

        List<MediaFolder> additionalFolders = extractMediaFoldersFromMediaFiles(context, additionalDirectories, hiddenList, new HashSet<>());
        ArrayList<MediaFolder> finalVideoFolders = new ArrayList<>(videoFolders.isEmpty() ? 0 : additionalFolders.size());
        if (additionalFolders != null) {
            int internalSdStringResId = R.string.internal_sd;
            for (MediaFolder folder : additionalFolders) {
                String folderPath = folder.f10545a;
                if (folderPath != null) {
                    scannedDirectories.add(folderPath);
                }
                if (hiddenList == null || folderPath == null || !hiddenList.contains(folderPath.toLowerCase(Locale.ENGLISH))) {
                    finalVideoFolders.add(new MediaFolder(folderPath, externalStoragePath.equals(folderPath) ? MyApplication.myApplication().getString(internalSdStringResId) : axy.m7460a(folderPath), folder.f10547c, folder.mo17930f()));
                }
            }
            for (MediaFolder folder : finalVideoFolders) {
                if (folder != null && folder.f10547c != null && folder.f10545a != null) {
                    File[] files = new File(folder.f10545a).listFiles(new FilenameFilter() {
                        public boolean accept(File file, String name) {
                            return axi.m7358a(name);
                        }
                    });
                    if (files != null) {
                        HashSet<String> existingFiles = new HashSet<>();
                        for (MediaFileInfo fileInfo : folder.f10547c) {
                            if (fileInfo.mo17892e() != null) {
                                existingFiles.add(fileInfo.mo17892e().toLowerCase(Locale.ENGLISH));
                            }
                        }
                        boolean isRecentAdded = false;
                        for (File file : files) {
                            if (file.isFile() && !existingFiles.contains(file.getName().toLowerCase(Locale.ENGLISH))) {
                                MediaFileInfo mediaFileInfo = new MediaFileInfo();
                                mediaFileInfo.mo17888b(file.getName());
                                mediaFileInfo.mo17884a(file.getAbsolutePath());
                                mediaFileInfo.mo17881a(1);
                                mediaFileInfo.mo17882a(0L);
                                mediaFileInfo.f10496a = file.length();
                                mediaFileInfo.f10497b = file.getAbsolutePath();
                                mediaFileInfo.mo17887b(file.lastModified());
                                if (!additionalDirectories.contains(mediaFileInfo.mo17890d())) {
                                    if (includeRecent && m12189a(recentMediaStorage, mediaFileInfo)) {
                                        if (folder.f10550f == null) {
                                            folder.f10550f = new ArrayList<>(1);
                                        }
                                        folder.f10550f.add(mediaFileInfo);
                                        isRecentAdded = true;
                                    } else {
                                        folder.f10547c.add(mediaFileInfo);
                                    }
                                }
                            }
                        }
                        if (!isRecentAdded) {
                            updateRecentMediaStorage(recentMediaStorage, folder);
                        }
                        if (folder.mo17924a() == 0) {
                            finalVideoFolders.remove(folder);
                        } else {
                            folder.mo17928d();
                        }
                    }
                }
            }
        }

        if (includeRecent) {
            ArrayList<String> additionalDirectoriesList = new ArrayList<>(additionalDirectories);
            m12180a(externalStoragePath, externalStoragePath, scannedDirectories, additionalDirectories, finalVideoFolders, hiddenList, recentMediaStorage, new HashSet<>(), isHidden);
            for (String additionalDir : additionalDirectoriesList) {
                m12180a(additionalDir, externalStoragePath, scannedDirectories, additionalDirectories, finalVideoFolders, hiddenList, recentMediaStorage, new HashSet<>(), isHidden);
            }
            for (String dir : awr.m7190d()) {
                if (dir != null && new File(dir).exists()) {
                    m12180a(dir, externalStoragePath, scannedDirectories, additionalDirectories, finalVideoFolders, hiddenList, recentMediaStorage, new HashSet<>(), isHidden);
                }
            }
            SharedPreferences folderDataPreferences = context.getSharedPreferences("FolderData", 0);
            for (String additionDir : folderDataPreferences.getStringSet("additionDir", new HashSet<>())) {
                m12180a(additionDir, externalStoragePath, scannedDirectories, additionalDirectories, finalVideoFolders, hiddenList, recentMediaStorage, new HashSet<>(), isHidden);
            }
            String u = bpj.m18578a(context).mo23414u();
            if (!TextUtils.isEmpty(u)) {
                m12180a(u, externalStoragePath, scannedDirectories, additionalDirectories, finalVideoFolders, hiddenList, recentMediaStorage, new HashSet<>(), isHidden);
            }
        }

        boolean firstScan = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("firstScan", true);
        if (firstScan) {
            int totalFolders = finalVideoFolders.size();
            int totalFiles = 0;
            for (MediaFolder folder : finalVideoFolders) {
                totalFiles += folder.mo17924a();
            }
            TreeMap<String, String> scanStats = new TreeMap<>();
            scanStats.put("dirCount", String.valueOf(totalFolders));
            scanStats.put("fileCount", String.valueOf(totalFiles));
            LogEvents.m18489a("FirstScan", scanStats);
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            editor.putBoolean("firstScan", false).apply();
        }
        isScanning.set(false);
        m12175a(293, (Object) null);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("additionDir").commit();
    }
    private static void getAllVideoFoldermm(final boolean b, final boolean b2, final AtomicBoolean atomicBoolean) {
        final boolean boolean1 = SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("lH9wboin", false);
        final String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final ArrayList<String> list = new ArrayList<>();
        final Set b3 = C2636d.m12150b();
        final Set a = HideListFragment.m12284a();
        RecentMediaStorage recentMediaStorage = new RecentMediaStorage(MyApplication.getApplicationContext_());
        final HashSet<String> set = new HashSet<>();
        Object a2 = null;
        if (!b2) {
            a2 = m12173a(boolean1, absolutePath, list, b3, a, recentMediaStorage, set, null);
            if (a2 != null && !((List) a2).isEmpty() && b) {
                final ArrayList list2 = new ArrayList<MediaFolder>(((List) a2).size() + 1);
                list2.add(0, recentAddedVideos((Collection<MediaFolder>) a2));
                list2.addAll((Collection<?>) a2);
                m12175a(291, list2);
            }
        }
        final List<MediaFolder> a3 = extractMediaFoldersFromMediaFiles(MyApplication.getApplicationContext_(), b3, a, set);
        List<MediaFolder> list3;
        if (a2 == null) {
            int size;
            if (a3 == null) {
                size = 0;
            } else {
                size = a3.size();
            }
            list3 = new ArrayList<MediaFolder>(size);
        } else {
            list3 = (List<MediaFolder>) a2;
        }
        int n = R.string.internal_sd;
        String s2;
        RecentMediaStorage recentMediaStorage6;
        boolean b6;
        if (a3 != null) {
            final int size2 = list3.size();
            for (final MediaFolder a4 : a3) {
                final String a5 = a4.f10545a;
                if (a5 != null) {
                    list.add(a5);
                }
                if (a != null && a5 != null && a.contains(a5.toLowerCase(Locale.ENGLISH))) {
                    continue;
                }
                String s;
                if (absolutePath.equals(a5)) {
                    s = MyApplication.myApplication().getString(n);
                } else {
                    s = axy.m7460a(a5);
                }
                list3.add(new MediaFolder(a5, s, a4.f10547c, a4.mo17930f()));
                n = R.string.internal_sd;
            }
            final Iterator<MediaFolder> iterator2 = list3.iterator();
            int n2 = 0;
            boolean b4 = false;
            s2 = absolutePath;
            while (iterator2.hasNext()) {
                final MediaFolder a6 = (MediaFolder) iterator2.next();
                final boolean b5 = n2 < size2;
                final int n3 = n2 + 1;
                RecentMediaStorage recentMediaStorage2;
                String s4;
                if (a6.f10547c != null && a6.f10545a != null) {
                    final File[] listFiles = new File(a6.f10545a).listFiles((FilenameFilter) new FilenameFilter() {
                        public boolean accept(File file, String str) {
                            return axi.m7358a(str);
                        }
                    });
                    if (listFiles != null) {
                        final HashSet<String> set2 = new HashSet<String>();
                        for (final MediaFileInfo mediaFileInfo : a6.f10547c) {
                            if (mediaFileInfo.mo17892e() != null) {
                                set2.add(mediaFileInfo.mo17892e().toLowerCase(Locale.ENGLISH));
                            }
                        }
                        final int length = listFiles.length;
                        int i = 0;
                        final File[] array = listFiles;
                        while (i < length) {
                            final File file = array[i];
                            if (file.isFile()) {
                                if (!set2.contains(file.getName().toLowerCase(Locale.ENGLISH))) {
                                    final MediaFileInfo mediaFileInfo2 = new MediaFileInfo();
                                    mediaFileInfo2.mo17888b(file.getName());
                                    mediaFileInfo2.mo17884a(file.getAbsolutePath());
                                    mediaFileInfo2.mo17881a(1);
                                    mediaFileInfo2.mo17882a(0L);
                                    mediaFileInfo2.f10496a = file.length();
                                    mediaFileInfo2.f10497b = file.getAbsolutePath();
                                    mediaFileInfo2.mo17887b(file.lastModified());
                                    if (!b3.contains(mediaFileInfo2.mo17890d())) {
                                        if (b5) {
                                            if (m12189a(recentMediaStorage, mediaFileInfo2)) {
                                                if (a6.f10550f == null) {
                                                    a6.f10550f = new ArrayList(1);
                                                }
                                                a6.f10550f.add(mediaFileInfo2);
                                                b4 = true;
                                            }
                                        } else {
                                            a6.f10547c.add(mediaFileInfo2);
                                        }
                                    }
                                }
                            }
                            ++i;
                        }
                        final String s3 = s2;
                        recentMediaStorage2 = recentMediaStorage;
                        s4 = s3;
                    } else {
                        final RecentMediaStorage recentMediaStorage3 = recentMediaStorage;
                        s4 = s2;
                        recentMediaStorage2 = recentMediaStorage3;
                    }
                    if (!b5) {
                        updateRecentMediaStorage(recentMediaStorage2, a6);
                    }
                    if (a6.mo17924a() == 0) {
                        iterator2.remove();
                    } else {
                        a6.mo17928d();
                    }
                } else {
                    final RecentMediaStorage recentMediaStorage4 = recentMediaStorage;
                    s4 = s2;
                    recentMediaStorage2 = recentMediaStorage4;
                }
                final RecentMediaStorage recentMediaStorage5 = recentMediaStorage2;
                n2 = n3;
                s2 = s4;
                recentMediaStorage = recentMediaStorage5;
            }
            recentMediaStorage6 = recentMediaStorage;
            b6 = b4;
        } else {
            s2 = absolutePath;
            b6 = false;
            recentMediaStorage6 = recentMediaStorage;
        }
        for (final String s5 : list) {
            if (s5 != null) {
                set.add(s5.toLowerCase(Locale.ENGLISH));
            }
        }
        List<MediaFolder> list4 = list3;
        HashSet<String> set3 = set;
        Set<String> set4 = (Set<String>) a;
        if (!b2) {
            final List<String> b7 = m12192b();
            list4 = list3;
            set3 = set;
            set4 = (Set<String>) a;
            if (b7 != null) {
                final Iterator<String> iterator5 = b7.iterator();
                while (true) {
                    list4 = list3;
                    set3 = set;
                    set4 = (Set<String>) a;
                    if (!iterator5.hasNext()) {
                        break;
                    }
                    m12180a(iterator5.next(), s2, list, b3, list3, a, recentMediaStorage6, set, boolean1);
                }
            }
        }
        m12180a(s2, s2, list, b3, list4, set4, recentMediaStorage6, set3, boolean1);
        final ArrayList<String> d = awr.m7190d();
        for (String pathname : d) {
            if (pathname != null && new File(pathname).exists()) {
                m12180a(pathname, s2, list, b3, list4, set4, recentMediaStorage6, set3, boolean1);
            }
        }
        final SharedPreferences sharedPreferences = MyApplication.getApplicationContext_().getSharedPreferences("FolderData", 0);
        final Iterator<String> iterator7 = sharedPreferences.getStringSet("additionDir", (Set) new HashSet(0)).iterator();
        while (iterator7.hasNext()) {
            m12180a(iterator7.next(), s2, list, b3, list4, set4, recentMediaStorage6, set3, boolean1);
        }
        final String u = bpj.m18578a(MyApplication.getApplicationContext_()).mo23414u();
        if (!TextUtils.isEmpty((CharSequence) u)) {
            m12180a(u, s2, list, b3, list4, set4, recentMediaStorage6, set3, boolean1);
        }
        final boolean boolean2 = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getBoolean("firstScan", true);
        int j;
        int n6;
        if (boolean2) {
            final List<MediaFolder> list5 = list4;
            final int n4 = list5.size() + 0;
            final Iterator<MediaFolder> iterator8 = list5.iterator();
            int n5 = 0;
            while (true) {
                j = n4;
                n6 = n5;
                if (!iterator8.hasNext()) {
                    break;
                }
                n5 += ((MediaFolder) iterator8.next()).mo17924a();
            }
        } else {
            j = 0;
            n6 = 0;
        }
        final Iterator<MediaFolder> iterator9 = list4.iterator();
        final String prefix = s2;
        while (iterator9.hasNext()) {
            final MediaFolder a7 = (MediaFolder) iterator9.next();
            if (a7 != null && a7.f10545a != null) {
                a7.mo17925a(a7.f10545a.startsWith(prefix) ^ true);
            }
        }
        Collections.sort(list4, new Comparator<MediaFolder>() {
            public int compare(MediaFolder aVar, MediaFolder aVar2) {
                return VideoManager.m12164a(aVar.f10545a, aVar2.f10545a);
            }
        });
        final ArrayList list6 = new ArrayList<MediaFolder>(list4);
        if (b) {
            list4.add(0, recentAddedVideos((Collection<MediaFolder>) list4));
            if (b6) {
                m12195b(291, list4, 1, 0);
            } else {
                m12175a(291, list4);
            }
        }
        final HashSet set5 = new HashSet();
        set5.add(prefix);
        set5.addAll(d);
        final List<Pair<C2671d, String[]>> a8 = m12172a(list, set3, set4, set5, boolean1);
        int l = 0;
        Label_2214:
        {
            int n8;
            if (a8 != null && !a8.isEmpty()) {
                final ArrayList<MediaFolder> list7 = new ArrayList<MediaFolder>(a8.size());
                Object iterator10 = a8.iterator();
                while (((Iterator) iterator10).hasNext()) {
                    final Pair pair = (Pair) ((Iterator<Pair>) iterator10).next();
                    final C2671d d2 = (C2671d) pair.first;
                    if (d2 != null) {
                        if (((C2671d) d2).f10648a == null) {
                            continue;
                        }
                        final File parent = new File(((C2671d) d2).f10648a);
                        if (!parent.isDirectory()) {
                            continue;
                        }
                        final String[] array2 = (String[]) pair.second;
                        Iterator<Pair> iterator11;
                        int n7;
                        if (array2 != null && array2.length > 0) {
                            final ArrayList list8 = new ArrayList<MediaFileInfo>(array2.length);
                            for (int length2 = array2.length, k = 0; k < length2; ++k) {
                                final File file2 = new File(parent, array2[k]);
                                if (file2.isFile()) {
                                    final MediaFileInfo mediaFileInfo3 = new MediaFileInfo();
                                    mediaFileInfo3.mo17888b(file2.getName());
                                    mediaFileInfo3.mo17884a(file2.getAbsolutePath());
                                    mediaFileInfo3.mo17881a(1);
                                    mediaFileInfo3.mo17882a(0L);
                                    mediaFileInfo3.f10496a = file2.length();
                                    mediaFileInfo3.f10497b = file2.getAbsolutePath();
                                    mediaFileInfo3.mo17887b(file2.lastModified());
                                    if (!b3.contains(mediaFileInfo3.mo17890d())) {
                                        list8.add(mediaFileInfo3);
                                    }
                                }
                            }
                            iterator11 = (Iterator<Pair>) iterator10;
                            n7 = n6;
                            if (!list8.isEmpty()) {
                                final String absolutePath2 = parent.getAbsolutePath();
                                String s6;
                                if (prefix.equals(parent.getAbsolutePath())) {
                                    s6 = MyApplication.myApplication().getString(R.string.internal_sd);
                                } else {
                                    s6 = parent.getName();
                                }
                                final MediaFolder a9 = new MediaFolder(absolutePath2, s6, (List) list8, ((C2671d) d2).f10649b);
                                updateRecentMediaStorage(recentMediaStorage6, a9);
                                iterator11 = (Iterator<Pair>) iterator10;
                                n7 = n6;
                                if (a9.mo17924a() > 0) {
                                    list7.add(a9);
                                    a9.mo17928d();
                                    iterator11 = (Iterator<Pair>) iterator10;
                                    n7 = n6;
                                }
                            }
                        } else {
                            n7 = n6;
                            iterator11 = (Iterator<Pair>) iterator10;
                        }
                        iterator10 = iterator11;
                        n6 = n7;
                    }
                }
                n8 = n6;
                if (!list7.isEmpty()) {
                    int n9 = j;
                    int n10 = n6;
                    if (boolean2) {
                        final int n11 = j + list7.size();
                        final Iterator<MediaFolder> iterator12 = list7.iterator();
                        while (true) {
                            n9 = n11;
                            n10 = n6;
                            if (!iterator12.hasNext()) {
                                break;
                            }
                            n6 += ((MediaFolder) iterator12.next()).mo17924a();
                        }
                    }
                    for (MediaFolder a10 : list7) {
                        if (a10 != null) {
                            a10.mo17925a(a10.f10545a.startsWith(prefix) ^ true);
                        }
                    }
                    list6.addAll((Collection<?>) list7);
                    j = n9;
                    l = n10;
                    if (b) {
                        m12196b((List) list6);
                        m12175a(292, new Pair((Object) list7, (Object) recentAddedVideos((Collection<MediaFolder>) list6)));
                        j = n9;
                        l = n10;
                    }
                    break Label_2214;
                }
            } else {
                n8 = n6;
            }
            l = n8;
        }
        if (!b) {
            m12196b((List<MediaFolder>) list6);
            Collections.sort((List) list6, new Comparator<MediaFolder>() {
                public int compare(MediaFolder aVar, MediaFolder aVar2) {
                    return VideoManager.m12164a(aVar.f10545a, aVar2.f10545a);
                }
            });
            list6.add(0, recentAddedVideos((Collection<MediaFolder>) list6));
            m12175a(291, list6);
        }
        atomicBoolean.set(false);
        m12175a(293, null);
        sharedPreferences.edit().remove("additionDir").commit();
        if (boolean2) {
            final TreeMap<String, String> treeMap = new TreeMap<String, String>();
            treeMap.put("dirCount", String.valueOf(j));
            treeMap.put("fileCount", String.valueOf(l));
            LogEvents.m18489a("FirstScan", (Map) treeMap);
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putBoolean("firstScan", false).apply();
        }
    }

    /* renamed from: a */
    private static MediaFolder recentAddedVideos(Collection<MediaFolder> collection) {
        MediaFolder aVar = new MediaFolder((String) null, MyApplication.getApplicationContext_().getString(R.string.recent_added), new ArrayList());
        aVar.f10548d = true;
        for (MediaFolder aVar2 : collection) {
            aVar.f10547c.addAll(aVar2.f10547c);
        }
        aVar.f10549e = 0;
        long j = PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).getLong("clickRecentTime", -1);
        if (j == -1) {
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putLong("clickRecentTime", System.currentTimeMillis()).apply();
        } else {
            for (MediaFileInfo h : aVar.f10547c) {
                if (h.mo17895h() > j) {
                    aVar.f10549e++;
                }
            }
        }
        return aVar;
    }

    /* renamed from: a */
    private static void m12180a(String str, String str2, List<String> list, Set<String> set, List<MediaFolder> list2, Set<String> set2, RecentMediaStorage recentMediaStorage, Set<String> set3, boolean z) {
        if (z || !axe.m7325f(str)) {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (!set3.contains(lowerCase)) {
                list.add(str);
                set3.add(lowerCase);
                if (set2 == null || !set2.contains(lowerCase)) {
                    File file = new File(str);
                    long lastModified = file.lastModified();
                    File[] listFiles = file.listFiles(new FilenameFilter() {
                        public boolean accept(File file, String str) {
                            return axi.m7358a(str);
                        }
                    });
                    if (listFiles != null) {
                        ArrayList arrayList = new ArrayList(listFiles.length);
                        for (File file2 : listFiles) {
                            if (file2.isFile()) {
                                MediaFileInfo mediaFileInfo = new MediaFileInfo();
                                mediaFileInfo.mo17888b(file2.getName());
                                mediaFileInfo.mo17884a(file2.getAbsolutePath());
                                mediaFileInfo.mo17881a(1);
                                mediaFileInfo.mo17882a(0);
                                mediaFileInfo.f10496a = file2.length();
                                mediaFileInfo.f10497b = file2.getAbsolutePath();
                                mediaFileInfo.mo17887b(file2.lastModified());
                                if (!set.contains(mediaFileInfo.mo17890d())) {
                                    arrayList.add(mediaFileInfo);
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            MediaFolder aVar = new MediaFolder(file.getAbsolutePath(), str2.equals(file.getAbsolutePath()) ? MyApplication.myApplication().getString(R.string.internal_sd) : file.getName(), arrayList, lastModified);
                            updateRecentMediaStorage(recentMediaStorage, aVar);
                            if (aVar.mo17924a() > 0) {
                                list2.add(aVar);
                                aVar.mo17928d();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x012c A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static MediaFolder m12168a_(String r16, String r17, List<String> r18, Set<String> r19, Set<String> r20, RecentMediaStorage r21, Set<String> r22, C2668a r23, boolean r24) {
        /*
            r0 = r16
            r1 = r20
            r2 = r22
            r3 = 0
            if (r24 != 0) goto L_0x0010
            boolean r4 = p000.axe.m7325f(r16)
            if (r4 == 0) goto L_0x0010
            return r3
        L_0x0010:
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.String r4 = r0.toLowerCase(r4)
            boolean r5 = r2.contains(r4)
            if (r5 != 0) goto L_0x016d
            r5 = r18
            r5.add(r0)
            r2.add(r4)
            if (r1 == 0) goto L_0x002e
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L_0x002e
            goto L_0x016d
        L_0x002e:
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            long r8 = r1.lastModified()
            com.inshot.xplayer.content.f$14 r0 = new com.inshot.xplayer.content.f$14
            r0.<init>()
            java.io.File[] r0 = r1.listFiles(r0)
            if (r0 == 0) goto L_0x016d
            java.util.ArrayList r7 = new java.util.ArrayList
            int r2 = r0.length
            r7.<init>(r2)
            java.util.List r2 = r23.f10638c
            if (r2 == 0) goto L_0x009e
            java.util.HashMap r2 = new java.util.HashMap
            java.util.List r4 = r23.f10638c
            int r4 = r4.size()
            r2.<init>(r4)
            java.util.List r4 = r23.f10638c
            java.util.Iterator r4 = r4.iterator()
        L_0x0063:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0077
            java.lang.Object r5 = r4.next()
            com.inshot.xplayer.content.f$b r5 = (com.inshot.xplayer.content.C2651f.VideoFile) r5
            java.lang.String r6 = r5.f10639a
            r2.put(r6, r5)
            goto L_0x0063
        L_0x0077:
            java.lang.String r4 = r23.f10636a
            java.lang.String r5 = "/"
            boolean r4 = r4.endsWith(r5)
            if (r4 == 0) goto L_0x0088
            java.lang.String r4 = r23.f10636a
            goto L_0x00a0
        L_0x0088:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r23.f10636a
            r4.append(r5)
            r5 = 47
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            goto L_0x00a0
        L_0x009e:
            r2 = r3
            r4 = r2
        L_0x00a0:
            int r5 = r0.length
            r6 = 0
        L_0x00a2:
            if (r6 >= r5) goto L_0x0130
            r10 = r0[r6]
            boolean r11 = r10.isFile()
            if (r11 == 0) goto L_0x012a
            if (r2 == 0) goto L_0x00e8
            java.lang.String r11 = r10.getName()
            java.lang.Object r11 = r2.get(r11)
            com.inshot.xplayer.content.f$b r11 = (com.inshot.xplayer.content.C2651f.VideoFile) r11
            if (r11 == 0) goto L_0x00e8
            long r12 = r11.f10642d
            r14 = -1
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x00cb
            long r12 = r10.length()
            long unused = r11.f10642d = r12
        L_0x00cb:
            long r12 = r11.f10640b
            long r14 = r10.lastModified()
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x00e8
            long r12 = r11.f10642d
            long r14 = r10.length()
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 != 0) goto L_0x00e8
            com.inshot.xplayer.content.MediaFileInfo r11 = createMediaFileInfo((java.lang.String) r4, (com.inshot.xplayer.content.C2651f.VideoFile) r11)
            goto L_0x00e9
        L_0x00e8:
            r11 = r3
        L_0x00e9:
            if (r11 != 0) goto L_0x011a
            com.inshot.xplayer.content.MediaFileInfo r11 = new com.inshot.xplayer.content.MediaFileInfo
            r11.<init>()
            java.lang.String r12 = r10.getName()
            r11.mo17888b((java.lang.String) r12)
            java.lang.String r12 = r10.getAbsolutePath()
            r11.mo17884a((java.lang.String) r12)
            r12 = 1
            r11.mo17881a((int) r12)
            r12 = 0
            r11.mo17882a((long) r12)
            long r12 = r10.length()
            r11.f10496a = r12
            java.lang.String r12 = r10.getAbsolutePath()
            r11.f10497b = r12
            long r12 = r10.lastModified()
            r11.mo17887b((long) r12)
        L_0x011a:
            java.lang.String r10 = r11.mo17890d()
            r12 = r19
            boolean r10 = r12.contains(r10)
            if (r10 != 0) goto L_0x012c
            r7.add(r11)
            goto L_0x012c
        L_0x012a:
            r12 = r19
        L_0x012c:
            int r6 = r6 + 1
            goto L_0x00a2
        L_0x0130:
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x016d
            com.inshot.xplayer.content.a r0 = new com.inshot.xplayer.content.a
            java.lang.String r5 = r1.getAbsolutePath()
            java.lang.String r2 = r1.getAbsolutePath()
            r4 = r17
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0155
            com.inshot.xplayer.application.MyApplication r1 = com.inshot.xplayer.application.MyApplication.myApplication()
            r2 = 2131624167(0x7f0e00e7, float:1.8875506E38)
            java.lang.String r1 = r1.getString(r2)
        L_0x0153:
            r6 = r1
            goto L_0x015a
        L_0x0155:
            java.lang.String r1 = r1.getName()
            goto L_0x0153
        L_0x015a:
            r4 = r0
            r4.<init>(r5, r6, r7, r8)
            r1 = r21
            updateRecentMediaStorage((com.inshot.xplayer.content.RecentMediaStorage) r1, (com.inshot.xplayer.content.MediaFolder) r0)
            int r1 = r0.mo17924a()
            if (r1 <= 0) goto L_0x016d
            r0.mo17928d()
            return r0
        L_0x016d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2651f.m12168a(java.lang.String, java.lang.String, java.util.List, java.util.Set, java.util.Set, com.inshot.xplayer.content.RecentMediaStorage, java.util.Set, com.inshot.xplayer.content.f$a, boolean):com.inshot.xplayer.content.a");
    }

    private static MediaFolder m12168aa(String str, String str2, List<String> list, Set<String> set, Set<String> set2, RecentMediaStorage recentMediaStorage, Set<String> set3, C2668a aVar, boolean z) {
        String str3;
        HashMap hashMap;
        MediaFileInfo mediaFileInfo;
        VideoFile bVar;
        if (!z && axe.m7325f(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (!set3.contains(lowerCase)) {
            list.add(str);
            set3.add(lowerCase);
            if (set2 == null || !set2.contains(lowerCase)) {
                File file = new File(str);
                long lastModified = file.lastModified();
                File[] listFiles = file.listFiles(new FilenameFilter() {
                    /* class com.inshot.xplayer.content.f.AnonymousClass14 */

                    public boolean accept(File file, String str) {
                        return axi.m7358a(str);
                    }
                });
                if (listFiles != null) {
                    ArrayList arrayList = new ArrayList(listFiles.length);
                    if (aVar.videoFiles != null) {
                        hashMap = new HashMap(aVar.videoFiles.size());
                        for (VideoFile bVar2 : aVar.videoFiles) {
                            hashMap.put(bVar2.name, bVar2);
                        }
                        str3 = aVar.path.endsWith("/") ? aVar.path : aVar.path + '/';
                    } else {
                        hashMap = null;
                        str3 = null;
                    }
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (!(hashMap == null || (bVar = (VideoFile) hashMap.get(file2.getName())) == null)) {
                                if (bVar.size == -1) {
                                    bVar.size = file2.length();
                                }
                                if (bVar.type == file2.lastModified() && bVar.size == file2.length()) {
                                    mediaFileInfo = createMediaFileInfo(str3, bVar);
                                    if (mediaFileInfo == null) {
                                        mediaFileInfo = new MediaFileInfo();
                                        mediaFileInfo.mo17888b(file2.getName());
                                        mediaFileInfo.mo17884a(file2.getAbsolutePath());
                                        mediaFileInfo.mo17881a(1);
                                        mediaFileInfo.mo17882a(0L);
                                        mediaFileInfo.f10496a = file2.length();
                                        mediaFileInfo.f10497b = file2.getAbsolutePath();
                                        mediaFileInfo.mo17887b(file2.lastModified());
                                    }
                                    if (set.contains(mediaFileInfo.mo17890d())) {
                                        arrayList.add(mediaFileInfo);
                                    }
                                }
                            }
                          /*  mediaFileInfo = null;
                            if (mediaFileInfo == null) {
                            }
                            /*if (set.contains(mediaFileInfo.mo17890d())) {
                            }*/
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        MediaFolder aVar2 = new MediaFolder(file.getAbsolutePath(), str2.equals(file.getAbsolutePath()) ? MyApplication.myApplication().getString(R.string.internal_sd) : file.getName(), arrayList, lastModified);
                        updateRecentMediaStorage(recentMediaStorage, aVar2);
                        if (aVar2.mo17924a() > 0) {
                            aVar2.mo17928d();
                            return aVar2;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static MediaFolder m12168a(String str, String str2, List<String> list, Set<String> set, Set<String> set2, RecentMediaStorage recentMediaStorage, Set<String> set3, C2668a aVar, boolean z) {
        String str3;
        HashMap<String, VideoFile> hashMap;
        MediaFileInfo mediaFileInfo;
        VideoFile bVar;
        if (!z && axe.m7325f(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (!set3.contains(lowerCase)) {
            list.add(str);
            set3.add(lowerCase);
            if (set2 == null || !set2.contains(lowerCase)) {
                File file = new File(str);
                long lastModified = file.lastModified();
                File[] listFiles = file.listFiles(new FilenameFilter() {
                    public boolean accept(File file, String str) {
                        return axi.m7358a(str);
                    }
                });
                if (listFiles != null) {
                    ArrayList<MediaFileInfo> arrayList = new ArrayList<>(listFiles.length);
                    if (aVar.videoFiles != null) {
                        hashMap = new HashMap<>(aVar.videoFiles.size());
                        for (VideoFile bVar2 : aVar.videoFiles) {
                            hashMap.put(bVar2.name, bVar2);
                        }
                        str3 = aVar.path.endsWith("/") ? aVar.path : aVar.path + '/';
                    } else {
                        hashMap = null;
                        str3 = null;
                    }
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (!(hashMap == null || (bVar = hashMap.get(file2.getName())) == null)) {
                                if (bVar.size == -1) {
                                    bVar.size = file2.length();
                                }
                                if (bVar.type == file2.lastModified() && bVar.size == file2.length()) {
                                    mediaFileInfo = createMediaFileInfo(str3, bVar);
                                    if (mediaFileInfo == null) {
                                        mediaFileInfo = new MediaFileInfo();
                                        mediaFileInfo.mo17888b(file2.getName());
                                        mediaFileInfo.mo17884a(file2.getAbsolutePath());
                                        mediaFileInfo.mo17881a(1);
                                        mediaFileInfo.mo17882a(0L);
                                        mediaFileInfo.f10496a = file2.length();
                                        mediaFileInfo.f10497b = file2.getAbsolutePath();
                                        mediaFileInfo.mo17887b(file2.lastModified());
                                    }
                                    if (set.contains(mediaFileInfo.mo17890d())) {
                                        arrayList.add(mediaFileInfo);
                                    }
                                }
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        MediaFolder aVar2 = new MediaFolder(file.getAbsolutePath(), str2.equals(file.getAbsolutePath()) ? MyApplication.myApplication().getString(R.string.internal_sd) : file.getName(), arrayList, lastModified);
                        updateRecentMediaStorage(recentMediaStorage, aVar2);
                        if (aVar2.mo17924a() > 0) {
                            aVar2.mo17928d();
                            return aVar2;
                        }
                    }
                }
            }
        }
        return null;
    }


    /* renamed from: b */
    public static List<String> m12192b() {
        String str;
        try {
            File file = new File(axc.createFolder(), ".data");
            str = axe.m7312a(/*(InputStream)*/ file.exists() ? new FileInputStream(file) : MyApplication.getApplicationContext_().openFileInput("VideoData"), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            str = null;
        }
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList(jSONArray.length());
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.optJSONObject(i).optString("p"));
                }
                return arrayList;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: e */
    private static List<C2668a> loadAndParseVideoData() {
        String str;
        //  C26521 r1 = null;
        try {
            File file = new File(axc.createFolder(), ".data");
            str = axe.m7312a(/*(InputStream)*/ file.exists() ? new FileInputStream(file) : MyApplication.getApplicationContext_().openFileInput("VideoData"), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList(jSONArray.length());
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    C2668a aVar = new C2668a();
                    String unused = aVar.path = optJSONObject.optString("p");
                    if (aVar.path != null) {
                        long unused2 = aVar.lastFetchedTime = optJSONObject.optLong("ft", -1);
                        arrayList.add(aVar);
                        JSONArray optJSONArray = optJSONObject.optJSONArray("m");
                        if (optJSONArray != null) {
                            int length2 = optJSONArray.length();
                            List unused3 = aVar.videoFiles = new ArrayList(length2);
                            int i2 = 0;
                            while (i2 < length2) {
                                JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                                VideoFile bVar = new VideoFile();
                                ArrayList arrayList2 = arrayList;
                                int i3 = i;
                                long unused4 = bVar.duration = jSONObject.optLong("d", 0);
                                long unused5 = bVar.type = jSONObject.optLong("t", 0);
                                String unused6 = bVar.name = jSONObject.optString("n");
                                long unused7 = bVar.size = jSONObject.optLong("l", -1);
                                aVar.videoFiles.add(bVar);
                                i2++;
                                arrayList = arrayList2;
                                i = i3;
                                // r1 = null;
                            }
                        }
                    }
                }
                i++;
                arrayList = arrayList;
                //r1 = null;
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }


    private static List<C2668a> loadAndParseVideoDataa() {
        String jsonData = null;
        try {
            File dataFile = new File(axc.createFolder(), ".data");
            InputStream inputStream = dataFile.exists() ? new FileInputStream(dataFile) : MyApplication.getApplicationContext_().openFileInput("VideoData");
            jsonData = axe.m7312a(inputStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (jsonData == null) {
            return null;
        }

        try {
            JSONArray jsonArray = new JSONArray(jsonData);
            List<C2668a> videoData = new ArrayList<>(); // Use the correct type

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject folderObject = jsonArray.optJSONObject(i);
                if (folderObject != null) {
                    C2668a folderData = new C2668a();
                    folderData.path = folderObject.optString("p"); // Assuming 'path' is a field in C2668a
                    folderData.lastFetchedTime = folderObject.optLong("ft", -1);

                    JSONArray videoFilesArray = folderObject.optJSONArray("m");
                    if (videoFilesArray != null) {
                        folderData.videoFiles = parseVideoFiles(videoFilesArray); // Assuming 'videoFiles' is a field
                    }

                    videoData.add(folderData);
                }
            }
            return videoData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<VideoFile> parseVideoFiles(JSONArray videoFilesArray) {
        List<VideoFile> videoFiles = new ArrayList<>();
        for (int i = 0; i < videoFilesArray.length(); i++) {
            JSONObject videoFileObject = videoFilesArray.optJSONObject(i);
            if (videoFileObject != null) {
                VideoFile videoFile = new VideoFile();
                videoFile.duration = videoFileObject.optLong("d", 0);
                videoFile.type = videoFileObject.optLong("t", 0);
                videoFile.name = videoFileObject.optString("n");
                videoFile.size = videoFileObject.optLong("l", -1);
                videoFiles.add(videoFile);
            }
        }
        return videoFiles;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c6 A[SYNTHETIC, Splitter:B:34:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cc A[SYNTHETIC, Splitter:B:38:0x00cc] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m12196b_(List<MediaFolder> r13) {
        /*
            java.lang.String r0 = ""
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.util.Iterator r13 = r13.iterator()     // Catch:{ JSONException -> 0x0085 }
            r2 = 0
            r3 = 0
        L_0x000d:
            boolean r4 = r13.hasNext()     // Catch:{ JSONException -> 0x0085 }
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r13.next()     // Catch:{ JSONException -> 0x0085 }
            com.inshot.xplayer.content.a r4 = (com.inshot.xplayer.content.MediaFolder) r4     // Catch:{ JSONException -> 0x0085 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0085 }
            r5.<init>()     // Catch:{ JSONException -> 0x0085 }
            java.util.List<com.inshot.xplayer.content.MediaFileInfo> r6 = r4.f10547c     // Catch:{ JSONException -> 0x0085 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ JSONException -> 0x0085 }
            r7 = 0
        L_0x0025:
            boolean r8 = r6.hasNext()     // Catch:{ JSONException -> 0x0085 }
            if (r8 == 0) goto L_0x005f
            java.lang.Object r8 = r6.next()     // Catch:{ JSONException -> 0x0085 }
            com.inshot.xplayer.content.MediaFileInfo r8 = (com.inshot.xplayer.content.MediaFileInfo) r8     // Catch:{ JSONException -> 0x0085 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0085 }
            r9.<init>()     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r10 = "n"
            java.lang.String r11 = r8.mo17892e()     // Catch:{ JSONException -> 0x0085 }
            r9.put(r10, r11)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r10 = "t"
            long r11 = r8.mo17895h()     // Catch:{ JSONException -> 0x0085 }
            r9.put(r10, r11)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r10 = "d"
            long r11 = r8.mo17893f()     // Catch:{ JSONException -> 0x0085 }
            r9.put(r10, r11)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r10 = "l"
            long r11 = r8.f10496a     // Catch:{ JSONException -> 0x0085 }
            r9.put(r10, r11)     // Catch:{ JSONException -> 0x0085 }
            int r8 = r7 + 1
            r5.put(r7, r9)     // Catch:{ JSONException -> 0x0085 }
            r7 = r8
            goto L_0x0025
        L_0x005f:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0085 }
            r6.<init>()     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r7 = "p"
            java.lang.String r8 = r4.f10545a     // Catch:{ JSONException -> 0x0085 }
            r6.put(r7, r8)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r7 = "m"
            r6.put(r7, r5)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r5 = "ft"
            long r7 = r4.mo17930f()     // Catch:{ JSONException -> 0x0085 }
            r6.put(r5, r7)     // Catch:{ JSONException -> 0x0085 }
            int r4 = r3 + 1
            r1.put(r3, r6)     // Catch:{ JSONException -> 0x0085 }
            r3 = r4
            goto L_0x000d
        L_0x0080:
            java.lang.String r13 = r1.toString()     // Catch:{ JSONException -> 0x0085 }
            goto L_0x008a
        L_0x0085:
            r13 = move-exception
            r13.printStackTrace()
            r13 = r0
        L_0x008a:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x00c0 }
            java.lang.String r2 = p000.axc.m7303b()     // Catch:{ IOException -> 0x00c0 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x00c0 }
            boolean r2 = r1.exists()     // Catch:{ IOException -> 0x00c0 }
            if (r2 != 0) goto L_0x009d
            r1.mkdirs()     // Catch:{ IOException -> 0x00c0 }
        L_0x009d:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c0 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00c0 }
            java.lang.String r4 = ".data"
            r3.<init>(r1, r4)     // Catch:{ IOException -> 0x00c0 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00c0 }
            java.lang.String r0 = "utf-8"
            byte[] r13 = r13.getBytes(r0)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
            r2.write(r13)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
            if (r2 == 0) goto L_0x00c9
            r2.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00c9
        L_0x00b8:
            r13 = move-exception
            r0 = r2
            goto L_0x00ca
        L_0x00bb:
            r13 = move-exception
            r0 = r2
            goto L_0x00c1
        L_0x00be:
            r13 = move-exception
            goto L_0x00ca
        L_0x00c0:
            r13 = move-exception
        L_0x00c1:
            r13.printStackTrace()     // Catch:{ all -> 0x00be }
            if (r0 == 0) goto L_0x00c9
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x00c9:
            return
        L_0x00ca:
            if (r0 == 0) goto L_0x00cf
            r0.close()     // Catch:{ IOException -> 0x00cf }
        L_0x00cf:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2651f.m12196b(java.util.List):void");
    }

    private static void m12196b(List<MediaFolder> list) {
        String str;
        Throwable th;
        IOException e;
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 0;
            for (MediaFolder aVar : list) {
                JSONArray jSONArray2 = new JSONArray();
                int i2 = 0;
                for (MediaFileInfo mediaFileInfo : aVar.f10547c) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", mediaFileInfo.mo17892e());
                    jSONObject.put("t", mediaFileInfo.mo17895h());
                    jSONObject.put("d", mediaFileInfo.mo17893f());
                    jSONObject.put("l", mediaFileInfo.f10496a);
                    jSONArray2.put(i2, jSONObject);
                    i2++;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("p", aVar.f10545a);
                jSONObject2.put("m", jSONArray2);
                jSONObject2.put("ft", aVar.mo17930f());
                jSONArray.put(i, jSONObject2);
                i++;
            }
            str = jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            str = "";
        }
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(axc.createFolder());
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, ".data"));
            try {
                fileOutputStream2.write(str.getBytes("utf-8"));
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    //   throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                }
                //throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            if (fileOutputStream == null) {
                try {
                    fileOutputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.inshot.xplayer.content.f$a */
    private static class C2668a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String path;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long lastFetchedTime;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public List<VideoFile> videoFiles;

        private C2668a() {
        }
    }

    /* renamed from: com.inshot.xplayer.content.f$b */
    private static class VideoFile {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String name;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long type;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public long duration;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public long size;

        private VideoFile() {
            this.size = -1;
        }
    }

    /* renamed from: a */
    private static MediaFolder m12167a(C2668a aVar, String str) {
        String str2;
        if (aVar.videoFiles == null || aVar.videoFiles.isEmpty()) {
            return null;
        }
        if (aVar.path.endsWith("/")) {
            str2 = aVar.path;
        } else {
            str2 = aVar.path + '/';
        }
        ArrayList arrayList = new ArrayList(aVar.videoFiles.size());
        for (VideoFile a : aVar.videoFiles) {
            arrayList.add(createMediaFileInfo(str2, a));
        }
        return new MediaFolder(aVar.path, str, arrayList, aVar.lastFetchedTime);
    }

    /* renamed from: a */
    private static MediaFileInfo createMediaFileInfo(String str, VideoFile bVar) {
        MediaFileInfo mediaFileInfo = new MediaFileInfo();
        mediaFileInfo.mo17887b(bVar.type);
        mediaFileInfo.mo17884a(str + bVar.name);
        mediaFileInfo.mo17881a(1);
        mediaFileInfo.mo17882a(bVar.duration);
        mediaFileInfo.f10496a = bVar.size;
        mediaFileInfo.mo17887b(bVar.type);
        return mediaFileInfo;
    }

    /* renamed from: a */
    public static void m12184a(List<MediaFileInfo> list, boolean z) {
        if (list != null) {
            ArrayList<C2670c> arrayList = new ArrayList<>(list.size());
            for (MediaFileInfo a : list) {
                arrayList.add(m12170a(a, z));
            }
            Collections.sort(arrayList);
            int i = 0;
            for (C2670c b : arrayList) {
                list.set(i, b.f10643a);
                i++;
            }
        }
    }

    /* renamed from: a */
    private static C2670c m12170a(MediaFileInfo mediaFileInfo, boolean z) {
        C2670c cVar = new C2670c(mediaFileInfo, z);
        String unused = cVar.f10645c = mediaFileInfo.mo17892e();
        if (cVar.f10645c != null) {
            String c = cVar.f10645c;
            int lastIndexOf = c.lastIndexOf(46);
            if (lastIndexOf >= 0) {
                String unused2 = cVar.f10646d = c.substring(lastIndexOf + 1);
                c = c.substring(0, lastIndexOf);
            }
            List unused3 = cVar.f10644b = m12194b(c);
        }
        return cVar;
    }

    /* renamed from: b */
    private static List<Object> m12194b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(str.length() >> 1);
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (m12188a(codePointAt)) {
                if (sb.length() > 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                sb2.append(Character.toChars(codePointAt));
                if (sb2.length() >= 9) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(sb2.toString())));
                    sb2.setLength(0);
                }
            } else {
                if (sb2.length() > 0) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(sb2.toString())));
                    sb2.setLength(0);
                }
                sb.append(Character.toChars(codePointAt));
            }
            i += Character.charCount(codePointAt);
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        if (sb2.length() > 0) {
            arrayList.add(Integer.valueOf(Integer.parseInt(sb2.toString())));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m12188a(int i) {
        char[] chars = Character.toChars(i);
        if (chars == null) {
            return false;
        }
        for (char c : chars) {
            if (c > '9' || c < '0') {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static int m12165a(List<Object> list, List<Object> list2) {
        if (list == list2) {
            return 0;
        }
        if (list == null) {
            return -1;
        }
        if (list2 == null) {
            return 1;
        }
        int min = Math.min(list.size(), list2.size());
        for (int i = 0; i < min; i++) {
            Object obj = list.get(i);
            Object obj2 = list2.get(i);
            if (obj != obj2) {
                if (obj == null) {
                    return -1;
                }
                if (obj2 == null) {
                    return 1;
                }
                if (obj.equals(obj2)) {
                    continue;
                } else {
                    boolean z = obj2 instanceof Integer;
                    if (obj instanceof Integer) {
                        if (!z) {
                            return -1;
                        }
                        int a = m12162a(((Integer) obj).intValue(), ((Integer) obj2).intValue());
                        if (a != 0) {
                            return a;
                        }
                    } else if (z) {
                        return 1;
                    } else {
                        int compareToIgnoreCase = ((String) obj).compareToIgnoreCase((String) obj2);
                        if (compareToIgnoreCase != 0) {
                            return compareToIgnoreCase;
                        }
                    }
                }
            }
        }
        return m12162a(list.size(), list2.size());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = m12191b(com.inshot.xplayer.content.C2651f.C2670c.m12228e(r2), com.inshot.xplayer.content.C2651f.C2670c.m12228e(r3));
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m12190b_(C2670c r2, C2670c r3) {
        /*
            java.util.List r0 = r2.f10644b
            java.util.List r1 = r3.f10644b
            int r0 = m12165a((java.util.List<java.lang.Object>) r0, (java.util.List<java.lang.Object>) r1)
            if (r0 != 0) goto L_0x0029
            java.lang.String r0 = r2.f10646d
            java.lang.String r1 = r3.f10646d
            int r0 = m12191b((java.lang.String) r0, (java.lang.String) r1)
            if (r0 != 0) goto L_0x0029
            java.lang.String r2 = r2.f10645c
            java.lang.String r3 = r3.f10645c
            int r2 = m12191b((java.lang.String) r2, (java.lang.String) r3)
            return r2
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2651f.m12190b(com.inshot.xplayer.content.f$c, com.inshot.xplayer.content.f$c):int");
    }

    public static int m12190b(C2670c cVar, C2670c cVar2) {
        int a2 = m12165a(cVar.f10644b, cVar2.f10644b);
        return (a2 == 0 && (a2 = m12191b(cVar.f10646d, cVar2.f10646d)) == 0) ? m12191b(cVar.f10645c, cVar2.f10645c) : a2;
    }

    /* renamed from: b */
    private static int m12191b(String str, String str2) {
        if (str == null) {
            return str2 == null ? 0 : -1;
        }
        if (str2 == null) {
            return 1;
        }
        int compareToIgnoreCase = str.compareToIgnoreCase(str2);
        if (compareToIgnoreCase != 0) {
            return compareToIgnoreCase;
        }
        return str.compareTo(str2);
    }

    /* renamed from: com.inshot.xplayer.content.f$c */
    private static class C2670c implements Comparable<C2670c> {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public MediaFileInfo f10643a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public List<Object> f10644b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f10645c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f10646d;

        /* renamed from: e */
        private boolean f10647e;

        private C2670c(MediaFileInfo mediaFileInfo, boolean z) {
            this.f10647e = false;
            this.f10643a = mediaFileInfo;
            this.f10647e = z;
        }

        /* renamed from: a */
        public int compareTo(C2670c cVar) {
            return this.f10647e ? VideoManager.m12190b(cVar, this) : VideoManager.m12190b(this, cVar);
        }
    }

    /* renamed from: a */
    public static int m12164a(String str, String str2) {
        int i;
        String str3;
        int lastIndexOf = str == null ? -1 : str.lastIndexOf("/");
        if (str2 == null) {
            i = -1;
        } else {
            i = str2.lastIndexOf("/");
        }
        String substring = lastIndexOf != -1 ? str.substring(lastIndexOf) : str;
        if (i != -1) {
            str3 = str2.substring(i);
        } else {
            str3 = str2;
        }
        if (substring == null && str3 == null) {
            return 0;
        }
        if (substring == null) {
            return -1;
        }
        if (str3 == null) {
            return 1;
        }
        if (!substring.toLowerCase().equals(str3.toLowerCase())) {
            return substring.compareToIgnoreCase(str3);
        }
        int compareTo = substring.compareTo(str3);
        if (compareTo > 0) {
            return -1;
        }
        if (compareTo != 0) {
            return 1;
        }
        if (lastIndexOf != -1) {
            str = str.substring(0, lastIndexOf);
        }
        if (i != -1) {
            str2 = str2.substring(0, i);
        }
        return str.compareTo(str2);
    }

    /* renamed from: a */
    private static void updateRecentMediaStorage(RecentMediaStorage recentMediaStorage, MediaFolder aVar) {
        Iterator<MediaFileInfo> it = aVar.f10547c.iterator();
        while (it.hasNext()) {
            if (!m12189a(recentMediaStorage, it.next())) {
                it.remove();
            }
        }
    }

    /* renamed from: a */
    private static boolean m12189a(RecentMediaStorage recentMediaStorage, MediaFileInfo mediaFileInfo) {
        mediaFileInfo.mo17883a(recentMediaStorage.mo17901a(mediaFileInfo.mo17890d()));
        if (mediaFileInfo.mo17893f() > 0 && mediaFileInfo.mo17893f() <= 36000000) {
            return true;
        }
        long c = m12198c(mediaFileInfo.mo17890d());
        if (c <= 0) {
            return false;
        }
        mediaFileInfo.mo17882a(c);
        return true;
    }

    /* renamed from: a */
    public static void m12183a(List<MediaFileInfo> list, int i, final boolean z) {
        switch (i) {
            case 0:
                m12184a(list, z);
                return;
            case 1:
                Collections.sort(list, new Comparator<MediaFileInfo>() {
                    /* renamed from: a */
                    public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
                        long h = mediaFileInfo.mo17895h() - mediaFileInfo2.mo17895h();
                        if (z) {
                            h = -h;
                        }
                        int i = (h > 0 ? 1 : (h == 0 ? 0 : -1));
                        if (i == 0) {
                            return 0;
                        }
                        return i < 0 ? 1 : -1;
                    }
                });
                return;
            case 2:
                Collections.sort(list, new Comparator<MediaFileInfo>() {
                    /* renamed from: a */
                    public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
                        long j = mediaFileInfo.f10496a - mediaFileInfo2.f10496a;
                        if (z) {
                            j = -j;
                        }
                        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                        if (i == 0) {
                            return 0;
                        }
                        return i < 0 ? 1 : -1;
                    }
                });
                return;
            case 3:
                Collections.sort(list, new Comparator<MediaFileInfo>() {
                    /* renamed from: a */
                    public int compare(MediaFileInfo mediaFileInfo, MediaFileInfo mediaFileInfo2) {
                        long f = mediaFileInfo.mo17893f() - mediaFileInfo2.mo17893f();
                        if (z) {
                            f = -f;
                        }
                        int i = (f > 0 ? 1 : (f == 0 ? 0 : -1));
                        if (i == 0) {
                            return 0;
                        }
                        return i < 0 ? 1 : -1;
                    }
                });
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private static long m12198c(String str) {
        return axi.m7359b(str);
    }

    /* renamed from: com.inshot.xplayer.content.f$d */
    private static class C2671d {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f10648a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public long f10649b;

        private C2671d(String str, long j) {
            this.f10648a = str;
            this.f10649b = j;
        }
    }

    /* renamed from: a */
    private static List<Pair<C2671d, String[]>> m12172a(List<String> list, Set<String> set, Set<String> set2, Set<String> set3, final boolean z) {
        if (list == null || set == null) {
            return null;
        }
        HashSet hashSet = new HashSet(set.size() + (set2 == null ? 0 : set2.size()));
        hashSet.addAll(set);
        if (set2 != null) {
            hashSet.addAll(set2);
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            File file = new File(next);
            if (file.exists()) {
                if (!set3.contains(next)) {
                    File parentFile = file.getParentFile();
                    m12185a((Set<String>) hashSet, (List<Pair<C2671d, String[]>>) arrayList, parentFile);
                    File[] listFiles = parentFile.listFiles(new FileFilter() {
                        public boolean accept(File file) {
                            return file.isDirectory() && (z || !file.getName().startsWith("."));
                        }
                    });
                    if (listFiles != null) {
                        for (File a : listFiles) {
                            m12185a((Set<String>) hashSet, (List<Pair<C2671d, String[]>>) arrayList, a);
                        }
                    }
                }
                m12186a((Set<String>) hashSet, (List<Pair<C2671d, String[]>>) arrayList, file, z, z ? 2 : 0);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m12186a(Set<String> set, List<Pair<C2671d, String[]>> list, File file, final boolean z, int i) {
        File[] listFiles = file.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory() && (z || !file.getName().startsWith("."));
            }
        });
        if (listFiles != null) {
            for (File file2 : listFiles) {
                m12185a(set, list, file2);
                if (i > 0) {
                    m12186a(set, list, file2, z, i - 1);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m12185a(Set<String> set, List<Pair<C2671d, String[]>> list, File file) {
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            String lowerCase = absolutePath.toLowerCase(Locale.ENGLISH);
            if (!set.contains(lowerCase)) {
                set.add(lowerCase);
                if (file.isDirectory()) {
                    long lastModified = file.lastModified();
                    String[] list2 = file.list(new FilenameFilter() {
                        public boolean accept(File file, String str) {
                            return axi.m7358a(str);
                        }
                    });
                    if (list2 != null && list2.length > 0) {
                        list.add(new Pair(new C2671d(absolutePath, lastModified), list2));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static List<MediaFolder> extractMediaFoldersFromMediaFiles(Context context, Set<String> set, Set<String> set2, Set<String> set3) {
        List<MediaFileInfo> b = getMediaFileInfos(context, set, set2, set3);
        if (b == null || b.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (MediaFileInfo next : b) {
            String parent = new File(next.mo17890d()).getParent();
            if (parent != null) {
                MediaFolder aVar = (MediaFolder) hashMap.get(parent.toLowerCase(Locale.ENGLISH));
                if (aVar == null) {
                    aVar = new MediaFolder(parent, (String) null, new ArrayList(), new File(parent).lastModified());
                    hashMap.put(parent.toLowerCase(Locale.ENGLISH), aVar);
                    arrayList.add(aVar);
                }
                aVar.f10547c.add(next);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static List<MediaFileInfo> getMediaFileInfos(Context context, Set<String> set, Set<String> set2, Set<String> set3) {
        Cursor cursor;
        Exception e;
        ArrayList arrayList = new ArrayList();
        try {
            cursor = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "date_modified", VastIconXmlManager.DURATION, VastIconXmlManager.WIDTH, VastIconXmlManager.HEIGHT}, (String) null, (String[]) null, "date_modified DESC");
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        if (Thread.currentThread().isInterrupted()) {
                            axy.m7468a(cursor);
                            return arrayList;
                        }
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        long lastModified = new File(string).lastModified();
                        long j = cursor.getLong(cursor.getColumnIndex(VastIconXmlManager.DURATION));
                        cursor.getLong(cursor.getColumnIndex(VastIconXmlManager.WIDTH));
                        cursor.getLong(cursor.getColumnIndex(VastIconXmlManager.HEIGHT));
                        if (!TextUtils.isEmpty(string)) {
                            File file = new File(string);
                            if (file.exists()) {
                                if (set == null || !set.contains(string)) {
                                    String parent = file.getParent();
                                    if (parent != null) {
                                        if (!set3.contains(parent.toLowerCase(Locale.ENGLISH))) {
                                            if (set2 != null && set2.contains(parent.toLowerCase(Locale.ENGLISH))) {
                                            }
                                        }
                                    }
                                    MediaFileInfo mediaFileInfo = new MediaFileInfo();
                                    mediaFileInfo.mo17887b(lastModified);
                                    mediaFileInfo.mo17884a(string);
                                    mediaFileInfo.mo17881a(1);
                                    mediaFileInfo.mo17882a(j);
                                    mediaFileInfo.f10496a = file.length();
                                    arrayList.add(mediaFileInfo);
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            axy.m7468a(cursor);
                            return arrayList;
                        } catch (Throwable th) {
                            th = th;
                            axy.m7468a(cursor);
                            throw th;
                        }
                    }
                }
            }
        } catch (Exception e3) {
            cursor = null;
            e = e3;
            e.printStackTrace();
            axy.m7468a(cursor);
            return arrayList;
        } catch (Throwable th) {
            cursor = null;
            th = th;
            axy.m7468a(cursor);
            // throw th;
        }
        axy.m7468a(cursor);
        return arrayList;
    }

    /* renamed from: a */
    public static void m12181a(final String str, final boolean z) {
        EXECUTOR.execute(new Runnable() {
            public void run() {
                File file = new File(str);
                String parent = file.isDirectory() ? str : file.getParent();
                SharedPreferences sharedPreferences = MyApplication.getApplicationContext_().getSharedPreferences("FolderData", 0);
                Set<String> stringSet = sharedPreferences.getStringSet("additionDir", new HashSet(1));
                if (!stringSet.contains(parent)) {
                    stringSet.add(parent);
                    sharedPreferences.edit().putStringSet("additionDir", stringSet).commit();
                    if (z) {
                        MyApplication.myApplication().runnable((Runnable) new Runnable() {
                            public void run() {
                                EventBus.getDefault().post(new awj());
                            }
                        });
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public static void m12182a(List<MediaFolder> list) {
        for (MediaFolder next : list) {
            if (!(next == null || next.f10550f == null || next.f10547c == null)) {
                next.f10547c.addAll(next.f10550f);
                next.f10550f = null;
            }
        }
    }

    /* renamed from: a */
    public static void m12179a(String str) {
        if (f10620c == null) {
            f10620c = new CopyOnWriteArraySet();
        }
        f10620c.add(str);
    }
}
