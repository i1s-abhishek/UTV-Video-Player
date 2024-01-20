package com.abhishek.xplayer.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.mobileads.VastIconXmlManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.inshot.xplayer.content.c */
public class PrivateVideoInfo {

    /* renamed from: a */
    static final Executor f10576a = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private static final String[] f10577c = {"id as _id", "url", "oldURL", "name", VastExtensionXmlManager.TYPE, "add_time", VastIconXmlManager.DURATION, "modify_time"};

    /* renamed from: b */
    private Context f10578b;

    PrivateVideoInfo(Context context) {
        this.f10578b = context.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c8 A[SYNTHETIC, Splitter:B:46:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d8 A[SYNTHETIC, Splitter:B:53:0x00d8] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e5 A[SYNTHETIC, Splitter:B:61:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f5 A[SYNTHETIC, Splitter:B:68:0x00f5] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo17947aa(java.util.List<C2634a> r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L_0x00fe
            boolean r1 = r11.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x00fe
        L_0x000b:
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            r2 = 0
            com.inshot.xplayer.content.c$b r3 = new com.inshot.xplayer.content.c$b     // Catch:{ Exception -> 0x00c1, all -> 0x00bd }
            android.content.Context r4 = r10.f10578b     // Catch:{ Exception -> 0x00c1, all -> 0x00bd }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00c1, all -> 0x00bd }
            android.database.sqlite.SQLiteDatabase r4 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x00bb }
            r4.beginTransaction()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
        L_0x0023:
            boolean r5 = r11.hasNext()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            if (r5 == 0) goto L_0x0097
            java.lang.Object r5 = r11.next()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            com.inshot.xplayer.content.c$a r5 = (com.inshot.xplayer.content.C2632c.C2634a) r5     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.clear()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            int r6 = r5.f10579a     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r7 = -1
            if (r6 != r7) goto L_0x003d
            java.lang.String r6 = "id"
            r1.putNull(r6)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            goto L_0x0048
        L_0x003d:
            java.lang.String r6 = "id"
            int r8 = r5.f10579a     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.put(r6, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
        L_0x0048:
            java.lang.String r6 = "url"
            java.lang.String r8 = r5.f10580b     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.put(r6, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r6 = "oldURL"
            java.lang.String r8 = r5.f10581c     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.put(r6, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r6 = "name"
            java.lang.String r8 = r5.f10582d     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.put(r6, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r6 = "type"
            int r8 = r5.f10583e     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.put(r6, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r6 = "add_time"
            long r8 = r5.f10584f     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.put(r6, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r6 = "duration"
            long r8 = r5.f10585g     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.put(r6, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r6 = "modify_time"
            long r8 = r5.f10586h     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r1.put(r6, r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            java.lang.String r6 = "PrivateVideos"
            long r8 = r4.replace(r6, r2, r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            int r6 = r5.f10579a     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            if (r6 != r7) goto L_0x0023
            int r6 = (int) r8     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r5.f10579a = r6     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            goto L_0x0023
        L_0x0097:
            r4.setTransactionSuccessful()     // Catch:{ Exception -> 0x00b8, all -> 0x00b6 }
            r11 = 1
            if (r4 == 0) goto L_0x00ab
            boolean r0 = r4.inTransaction()     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x00ab
            r4.endTransaction()     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ab:
            if (r3 == 0) goto L_0x00b5
            r3.close()     // Catch:{ Exception -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b5:
            return r11
        L_0x00b6:
            r11 = move-exception
            goto L_0x00e3
        L_0x00b8:
            r11 = move-exception
            r2 = r4
            goto L_0x00c3
        L_0x00bb:
            r11 = move-exception
            goto L_0x00c3
        L_0x00bd:
            r11 = move-exception
            r3 = r2
            r4 = r3
            goto L_0x00e3
        L_0x00c1:
            r11 = move-exception
            r3 = r2
        L_0x00c3:
            r11.printStackTrace()     // Catch:{ all -> 0x00e1 }
            if (r2 == 0) goto L_0x00d6
            boolean r11 = r2.inTransaction()     // Catch:{ Exception -> 0x00d2 }
            if (r11 == 0) goto L_0x00d6
            r2.endTransaction()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00d6
        L_0x00d2:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00d6:
            if (r3 == 0) goto L_0x00e0
            r3.close()     // Catch:{ Exception -> 0x00dc }
            goto L_0x00e0
        L_0x00dc:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00e0:
            return r0
        L_0x00e1:
            r11 = move-exception
            r4 = r2
        L_0x00e3:
            if (r4 == 0) goto L_0x00f3
            boolean r0 = r4.inTransaction()     // Catch:{ Exception -> 0x00ef }
            if (r0 == 0) goto L_0x00f3
            r4.endTransaction()     // Catch:{ Exception -> 0x00ef }
            goto L_0x00f3
        L_0x00ef:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00f3:
            if (r3 == 0) goto L_0x00fd
            r3.close()     // Catch:{ Exception -> 0x00f9 }
            goto L_0x00fd
        L_0x00f9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00fd:
            throw r11
        L_0x00fe:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2632c.mo17947a(java.util.List):boolean");
    }
    public boolean mo17947a(List<C2634a> list) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        C2635b bVar;
        Exception e;
        if (list == null || list.isEmpty()) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            bVar = new C2635b(this.f10578b);
            try {
                sQLiteDatabase = bVar.getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    for (C2634a aVar : list) {
                        contentValues.clear();
                        if (aVar.f10579a == -1) {
                            contentValues.putNull(VastExtensionXmlManager.ID);
                        } else {
                            contentValues.put(VastExtensionXmlManager.ID, Integer.valueOf(aVar.f10579a));
                        }
                        contentValues.put("url", aVar.f10580b);
                        contentValues.put("oldURL", aVar.f10581c);
                        contentValues.put("name", aVar.f10582d);
                        contentValues.put(VastExtensionXmlManager.TYPE, Integer.valueOf(aVar.f10583e));
                        contentValues.put("add_time", Long.valueOf(aVar.f10584f));
                        contentValues.put(VastIconXmlManager.DURATION, Long.valueOf(aVar.f10585g));
                        contentValues.put("modify_time", Long.valueOf(aVar.f10586h));
                        long replace = sQLiteDatabase.replace("PrivateVideos", null, contentValues);
                        if (aVar.f10579a == -1) {
                            aVar.f10579a = (int) replace;
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    sQLiteDatabase2 = sQLiteDatabase;
                    try {
                        e.printStackTrace();
                        if (sQLiteDatabase2 != null) {
                        }
                        if (bVar != null) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = sQLiteDatabase2;
                        if (sQLiteDatabase != null) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (sQLiteDatabase != null) {
                    }
                    if (bVar != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                if (sQLiteDatabase2 != null) {
                    try {
                        if (sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase2.endTransaction();
                        }
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Exception e10) {
            e = e10;
            bVar = null;
            e.printStackTrace();
            if (sQLiteDatabase2 != null) {
            }
            if (bVar != null) {
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
            sQLiteDatabase = null;
            if (sQLiteDatabase != null) {
            }
            if (bVar != null) {
            }
            //throw th;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a3 A[SYNTHETIC, Splitter:B:36:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3 A[SYNTHETIC, Splitter:B:43:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c0 A[SYNTHETIC, Splitter:B:51:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d0 A[SYNTHETIC, Splitter:B:58:0x00d0] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo17946aa(C2634a r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x00d9
            int r1 = r9.f10579a
            r2 = -1
            if (r1 != r2) goto L_0x000a
            goto L_0x00d9
        L_0x000a:
            android.content.ContentValues r1 = new android.content.ContentValues
            r1.<init>()
            r2 = 0
            com.inshot.xplayer.content.c$b r3 = new com.inshot.xplayer.content.c$b     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
            android.content.Context r4 = r8.f10578b     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x009c, all -> 0x0098 }
            android.database.sqlite.SQLiteDatabase r4 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x0096 }
            r4.beginTransaction()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.clear()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r5 = "id"
            int r6 = r9.f10579a     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r5 = "url"
            java.lang.String r6 = r9.f10580b     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r5 = "oldURL"
            java.lang.String r6 = r9.f10581c     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r5 = "name"
            java.lang.String r6 = r9.f10582d     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r5 = "type"
            int r6 = r9.f10583e     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r5 = "add_time"
            long r6 = r9.f10584f     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r5 = "duration"
            long r6 = r9.f10585g     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r5 = "modify_time"
            long r6 = r9.f10586h     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.Long r9 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r1.put(r5, r9)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            java.lang.String r9 = "PrivateVideos"
            r4.replace(r9, r2, r1)     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r4.setTransactionSuccessful()     // Catch:{ Exception -> 0x0093, all -> 0x0091 }
            r9 = 1
            if (r4 == 0) goto L_0x0086
            boolean r0 = r4.inTransaction()     // Catch:{ Exception -> 0x0082 }
            if (r0 == 0) goto L_0x0086
            r4.endTransaction()     // Catch:{ Exception -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0086:
            if (r3 == 0) goto L_0x0090
            r3.close()     // Catch:{ Exception -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0090:
            return r9
        L_0x0091:
            r9 = move-exception
            goto L_0x00be
        L_0x0093:
            r9 = move-exception
            r2 = r4
            goto L_0x009e
        L_0x0096:
            r9 = move-exception
            goto L_0x009e
        L_0x0098:
            r9 = move-exception
            r3 = r2
            r4 = r3
            goto L_0x00be
        L_0x009c:
            r9 = move-exception
            r3 = r2
        L_0x009e:
            r9.printStackTrace()     // Catch:{ all -> 0x00bc }
            if (r2 == 0) goto L_0x00b1
            boolean r9 = r2.inTransaction()     // Catch:{ Exception -> 0x00ad }
            if (r9 == 0) goto L_0x00b1
            r2.endTransaction()     // Catch:{ Exception -> 0x00ad }
            goto L_0x00b1
        L_0x00ad:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00b1:
            if (r3 == 0) goto L_0x00bb
            r3.close()     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00bb:
            return r0
        L_0x00bc:
            r9 = move-exception
            r4 = r2
        L_0x00be:
            if (r4 == 0) goto L_0x00ce
            boolean r0 = r4.inTransaction()     // Catch:{ Exception -> 0x00ca }
            if (r0 == 0) goto L_0x00ce
            r4.endTransaction()     // Catch:{ Exception -> 0x00ca }
            goto L_0x00ce
        L_0x00ca:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00ce:
            if (r3 == 0) goto L_0x00d8
            r3.close()     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d8
        L_0x00d4:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d8:
            throw r9
        L_0x00d9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2632c.mo17946a(com.inshot.xplayer.content.c$a):boolean");
    }
    public boolean mo17946a(C2634a aVar) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        C2635b bVar;
        Exception e;
        if (aVar == null || aVar.f10579a == -1) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            bVar = new C2635b(this.f10578b);
            try {
                sQLiteDatabase = bVar.getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    contentValues.clear();
                    contentValues.put(VastExtensionXmlManager.ID, Integer.valueOf(aVar.f10579a));
                    contentValues.put("url", aVar.f10580b);
                    contentValues.put("oldURL", aVar.f10581c);
                    contentValues.put("name", aVar.f10582d);
                    contentValues.put(VastExtensionXmlManager.TYPE, Integer.valueOf(aVar.f10583e));
                    contentValues.put("add_time", Long.valueOf(aVar.f10584f));
                    contentValues.put(VastIconXmlManager.DURATION, Long.valueOf(aVar.f10585g));
                    contentValues.put("modify_time", Long.valueOf(aVar.f10586h));
                    sQLiteDatabase.replace("PrivateVideos", null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    sQLiteDatabase2 = sQLiteDatabase;
                    try {
                        e.printStackTrace();
                        if (sQLiteDatabase2 != null) {
                        }
                        if (bVar != null) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = sQLiteDatabase2;
                        if (sQLiteDatabase != null) {
                        }
                        if (bVar != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (sQLiteDatabase != null) {
                    }
                    if (bVar != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (sQLiteDatabase2 != null) {
                }
                if (bVar != null) {
                }
                return false;
            }
        } catch (Exception e6) {
            e = e6;
            bVar = null;
            e.printStackTrace();
            if (sQLiteDatabase2 != null) {
                try {
                    if (sQLiteDatabase2.inTransaction()) {
                        sQLiteDatabase2.endTransaction();
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
            sQLiteDatabase = null;
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            //throw th;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0072 A[SYNTHETIC, Splitter:B:41:0x0072] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0082 A[SYNTHETIC, Splitter:B:48:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x008f A[SYNTHETIC, Splitter:B:56:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x009f A[SYNTHETIC, Splitter:B:63:0x009f] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo17948bb(java.util.List<C2634a> r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x00a8
            boolean r1 = r8.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x00a8
        L_0x000b:
            r1 = 0
            com.inshot.xplayer.content.c$b r2 = new com.inshot.xplayer.content.c$b     // Catch:{ Exception -> 0x006b, all -> 0x0067 }
            android.content.Context r3 = r7.f10578b     // Catch:{ Exception -> 0x006b, all -> 0x0067 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x006b, all -> 0x0067 }
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0065 }
            r3.beginTransaction()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
        L_0x001e:
            boolean r1 = r8.hasNext()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r4 = 1
            if (r1 == 0) goto L_0x0042
            java.lang.Object r1 = r8.next()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            com.inshot.xplayer.content.c$a r1 = (com.inshot.xplayer.content.C2632c.C2634a) r1     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            int r5 = r1.f10579a     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r6 = -1
            if (r5 == r6) goto L_0x001e
            java.lang.String r5 = "PrivateVideos"
            java.lang.String r6 = "id=?"
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            int r1 = r1.f10579a     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r4[r0] = r1     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            r3.delete(r5, r6, r4)     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            goto L_0x001e
        L_0x0042:
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x0062, all -> 0x0060 }
            if (r3 == 0) goto L_0x0055
            boolean r8 = r3.inTransaction()     // Catch:{ Exception -> 0x0051 }
            if (r8 == 0) goto L_0x0055
            r3.endTransaction()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0055:
            if (r2 == 0) goto L_0x005f
            r2.close()     // Catch:{ Exception -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r8 = move-exception
            r8.printStackTrace()
        L_0x005f:
            return r4
        L_0x0060:
            r8 = move-exception
            goto L_0x008d
        L_0x0062:
            r8 = move-exception
            r1 = r3
            goto L_0x006d
        L_0x0065:
            r8 = move-exception
            goto L_0x006d
        L_0x0067:
            r8 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x008d
        L_0x006b:
            r8 = move-exception
            r2 = r1
        L_0x006d:
            r8.printStackTrace()     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0080
            boolean r8 = r1.inTransaction()     // Catch:{ Exception -> 0x007c }
            if (r8 == 0) goto L_0x0080
            r1.endTransaction()     // Catch:{ Exception -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0080:
            if (r2 == 0) goto L_0x008a
            r2.close()     // Catch:{ Exception -> 0x0086 }
            goto L_0x008a
        L_0x0086:
            r8 = move-exception
            r8.printStackTrace()
        L_0x008a:
            return r0
        L_0x008b:
            r8 = move-exception
            r3 = r1
        L_0x008d:
            if (r3 == 0) goto L_0x009d
            boolean r0 = r3.inTransaction()     // Catch:{ Exception -> 0x0099 }
            if (r0 == 0) goto L_0x009d
            r3.endTransaction()     // Catch:{ Exception -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r0 = move-exception
            r0.printStackTrace()
        L_0x009d:
            if (r2 == 0) goto L_0x00a7
            r2.close()     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00a7:
            throw r8
        L_0x00a8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2632c.mo17948b(java.util.List):boolean");
    }
    public boolean mo17948b(List<C2634a> list) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        C2635b bVar;
        Exception e;
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            bVar = new C2635b(this.f10578b);
            try {
                sQLiteDatabase = bVar.getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    for (C2634a aVar : list) {
                        if (aVar.f10579a != -1) {
                            sQLiteDatabase.delete("PrivateVideos", "id=?", new String[]{String.valueOf(aVar.f10579a)});
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    sQLiteDatabase2 = sQLiteDatabase;
                    try {
                        e.printStackTrace();
                        if (sQLiteDatabase2 != null) {
                        }
                        if (bVar != null) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = sQLiteDatabase2;
                        if (sQLiteDatabase != null) {
                        }
                        if (bVar != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (sQLiteDatabase != null) {
                    }
                    if (bVar != null) {
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (sQLiteDatabase2 != null) {
                }
                if (bVar != null) {
                }
                return false;
            }
        } catch (Exception e6) {
            e = e6;
            bVar = null;
            e.printStackTrace();
            if (sQLiteDatabase2 != null) {
                try {
                    if (sQLiteDatabase2.inTransaction()) {
                        sQLiteDatabase2.endTransaction();
                    }
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
            sQLiteDatabase = null;
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
            if (bVar != null) {
                try {
                    bVar.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            //throw th;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0069 A[SYNTHETIC, Splitter:B:41:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0079 A[SYNTHETIC, Splitter:B:48:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0086 A[SYNTHETIC, Splitter:B:56:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0096 A[SYNTHETIC, Splitter:B:63:0x0096] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo17949cc(java.util.List<String> r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L_0x009f
            boolean r1 = r8.isEmpty()
            if (r1 == 0) goto L_0x000b
            goto L_0x009f
        L_0x000b:
            r1 = 0
            com.inshot.xplayer.content.c$b r2 = new com.inshot.xplayer.content.c$b     // Catch:{ Exception -> 0x0062, all -> 0x005e }
            android.content.Context r3 = r7.f10578b     // Catch:{ Exception -> 0x0062, all -> 0x005e }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0062, all -> 0x005e }
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x005c }
            r3.beginTransaction()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
        L_0x001e:
            boolean r1 = r8.hasNext()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r4 = 1
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r8.next()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            if (r1 == 0) goto L_0x001e
            java.lang.String r5 = "PrivateVideos"
            java.lang.String r6 = "url=?"
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r4[r0] = r1     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r3.delete(r5, r6, r4)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            goto L_0x001e
        L_0x0039:
            r3.setTransactionSuccessful()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            if (r3 == 0) goto L_0x004c
            boolean r8 = r3.inTransaction()     // Catch:{ Exception -> 0x0048 }
            if (r8 == 0) goto L_0x004c
            r3.endTransaction()     // Catch:{ Exception -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r8 = move-exception
            r8.printStackTrace()
        L_0x004c:
            if (r2 == 0) goto L_0x0056
            r2.close()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0056:
            return r4
        L_0x0057:
            r8 = move-exception
            goto L_0x0084
        L_0x0059:
            r8 = move-exception
            r1 = r3
            goto L_0x0064
        L_0x005c:
            r8 = move-exception
            goto L_0x0064
        L_0x005e:
            r8 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x0084
        L_0x0062:
            r8 = move-exception
            r2 = r1
        L_0x0064:
            r8.printStackTrace()     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0077
            boolean r8 = r1.inTransaction()     // Catch:{ Exception -> 0x0073 }
            if (r8 == 0) goto L_0x0077
            r1.endTransaction()     // Catch:{ Exception -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0077:
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ Exception -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0081:
            return r0
        L_0x0082:
            r8 = move-exception
            r3 = r1
        L_0x0084:
            if (r3 == 0) goto L_0x0094
            boolean r0 = r3.inTransaction()     // Catch:{ Exception -> 0x0090 }
            if (r0 == 0) goto L_0x0094
            r3.endTransaction()     // Catch:{ Exception -> 0x0090 }
            goto L_0x0094
        L_0x0090:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0094:
            if (r2 == 0) goto L_0x009e
            r2.close()     // Catch:{ Exception -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x009e:
            throw r8
        L_0x009f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2632c.mo17949c(java.util.List):boolean");
    }
    public boolean mo17949c(List<String> list) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        C2635b bVar;
        Exception e;
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            bVar = new C2635b(this.f10578b);
            try {
                sQLiteDatabase = bVar.getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    for (String str : list) {
                        if (str != null) {
                            sQLiteDatabase.delete("PrivateVideos", "url=?", new String[]{str});
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return true;
                } catch (Exception e4) {
                    e = e4;
                    sQLiteDatabase2 = sQLiteDatabase;
                    try {
                        e.printStackTrace();
                        if (sQLiteDatabase2 != null) {
                        }
                        if (bVar != null) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = sQLiteDatabase2;
                        if (sQLiteDatabase != null) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (sQLiteDatabase != null) {
                    }
                    if (bVar != null) {
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                if (sQLiteDatabase2 != null) {
                    try {
                        if (sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase2.endTransaction();
                        }
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Exception e10) {
            e = e10;
            bVar = null;
            e.printStackTrace();
            if (sQLiteDatabase2 != null) {
            }
            if (bVar != null) {
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
            sQLiteDatabase = null;
            if (sQLiteDatabase != null) {
            }
            if (bVar != null) {
            }
         //   throw th;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r12 = r0;
        r0 = r14;
        r14 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        r15 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        r0 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0069, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006a, code lost:
        r14.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007a, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x007b, code lost:
        r14.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0084, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0085, code lost:
        r14.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0065 A[SYNTHETIC, Splitter:B:38:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006f A[SYNTHETIC, Splitter:B:43:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0076 A[SYNTHETIC, Splitter:B:48:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0080 A[SYNTHETIC, Splitter:B:53:0x0080] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<C2634a> mo17945aa(String r14, String[] r15) {
        /*
            r13 = this;
            r0 = 0
            com.inshot.xplayer.content.c$b r1 = new com.inshot.xplayer.content.c$b     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            android.content.Context r2 = r13.f10578b     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            r1.<init>(r2)     // Catch:{ Exception -> 0x005d, all -> 0x005a }
            android.database.sqlite.SQLiteDatabase r3 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r4 = "PrivateVideos"
            java.lang.String[] r5 = f10577c     // Catch:{ Exception -> 0x0057 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r6 = r14
            r7 = r15
            android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0057 }
            if (r14 == 0) goto L_0x0041
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            int r2 = r14.getCount()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r15.<init>(r2)     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
        L_0x0025:
            boolean r0 = r14.moveToNext()     // Catch:{ Exception -> 0x0033, all -> 0x0038 }
            if (r0 == 0) goto L_0x0042
            com.inshot.xplayer.content.c$a r0 = r13.m12131a((android.database.Cursor) r14)     // Catch:{ Exception -> 0x0033, all -> 0x0038 }
            r15.add(r0)     // Catch:{ Exception -> 0x0033, all -> 0x0038 }
            goto L_0x0025
        L_0x0033:
            r0 = move-exception
            r12 = r0
            r0 = r14
            r14 = r12
            goto L_0x0060
        L_0x0038:
            r15 = move-exception
            r0 = r14
            goto L_0x0074
        L_0x003b:
            r15 = move-exception
            r12 = r0
            r0 = r14
            r14 = r15
            r15 = r12
            goto L_0x0060
        L_0x0041:
            r15 = r0
        L_0x0042:
            if (r14 == 0) goto L_0x004c
            r14.close()     // Catch:{ Exception -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r14 = move-exception
            r14.printStackTrace()
        L_0x004c:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0072
        L_0x0052:
            r14 = move-exception
            r14.printStackTrace()
            goto L_0x0072
        L_0x0057:
            r14 = move-exception
            r15 = r0
            goto L_0x0060
        L_0x005a:
            r15 = move-exception
            r1 = r0
            goto L_0x0074
        L_0x005d:
            r14 = move-exception
            r15 = r0
            r1 = r15
        L_0x0060:
            r14.printStackTrace()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x006d
            r0.close()     // Catch:{ Exception -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r14 = move-exception
            r14.printStackTrace()
        L_0x006d:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ Exception -> 0x0052 }
        L_0x0072:
            return r15
        L_0x0073:
            r15 = move-exception
        L_0x0074:
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ Exception -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r14 = move-exception
            r14.printStackTrace()
        L_0x007e:
            if (r1 == 0) goto L_0x0088
            r1.close()     // Catch:{ Exception -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0088:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.C2632c.mo17945a(java.lang.String, java.lang.String[]):java.util.List");
    }
    public List<C2634a> mo17945a(String str, String[] strArr) {
        Throwable th;
        C2635b bVar;
        ArrayList arrayList = null;
        Exception e;
        Cursor cursor = null;
        try {
            bVar = new C2635b(this.f10578b);
            try {
                Cursor query = bVar.getReadableDatabase().query("PrivateVideos", f10577c, str, strArr, null, null, null, null);
                if (query != null) {
                    try {
                        arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            arrayList.add(m12131a(query));
                        }
                    } catch (Exception e2) {
                        cursor = query;
                        e = e2;
                        arrayList = null;
                        try {
                            e.printStackTrace();
                            if (cursor != null) {
                            }
                            if (bVar != null) {
                            }
                            return arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                            }
                            if (bVar != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                    }
                } else {
                    arrayList = null;
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (bVar != null) {
                    try {
                        bVar.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                arrayList = null;
                e.printStackTrace();
                if (cursor != null) {
                }
                if (bVar != null) {
                }
                return arrayList;
            }
        } catch (Exception e6) {
            e = e6;
            arrayList = null;
            bVar = null;
            e.printStackTrace();
            if (cursor != null) {
            }
            if (bVar != null) {
            }
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            bVar = null;
            if (cursor != null) {
            }
            if (bVar != null) {
            }
          //  throw th;
        }
        return arrayList;
    }

    /* renamed from: a */
    private C2634a m12131a(Cursor cursor) {
        C2634a aVar = new C2634a();
        aVar.f10579a = cursor.getInt(0);
        aVar.f10580b = cursor.getString(1);
        aVar.f10581c = cursor.getString(2);
        aVar.f10582d = cursor.getString(3);
        aVar.f10583e = cursor.getInt(4);
        aVar.f10584f = cursor.getLong(5);
        aVar.f10585g = cursor.getLong(6);
        aVar.f10586h = cursor.getLong(7);
        return aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C2634a mo17944a() {
        return new C2634a();
    }

    /* renamed from: com.inshot.xplayer.content.c$a */
    public class C2634a {

        /* renamed from: a */
        public int f10579a = -1;

        /* renamed from: b */
        public String f10580b;

        /* renamed from: c */
        public String f10581c;

        /* renamed from: d */
        public String f10582d;

        /* renamed from: e */
        public int f10583e = 0;

        /* renamed from: f */
        public long f10584f;

        /* renamed from: g */
        public long f10585g;

        /* renamed from: h */
        public long f10586h;

        C2634a() {
        }
    }

    /* renamed from: com.inshot.xplayer.content.c$b */
    private static class C2635b extends SQLiteOpenHelper {
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        private C2635b(Context context) {
            super(context, "Private.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS PrivateVideos (id INTEGER PRIMARY KEY AUTOINCREMENT, url VARCHAR, oldURL VARCHAR, name VARCHAR, type INTEGER, add_time INTEGER, duration INTEGER, modify_time INTEGER, json VARCHAR)");
        }
    }
}
