package com.abhishek.xplayer.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.mopub.common.AdType;
import com.mopub.mobileads.VastExtensionXmlManager;
import com.mopub.mobileads.VastIconXmlManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RecentMediaStorage {

    /* renamed from: a */
    public static final String[] f10507a = {"id as _id", "url", "name", VastExtensionXmlManager.TYPE, "last_time", "seen_length", VastIconXmlManager.DURATION, AdType.STATIC_NATIVE};

    /* renamed from: b */
    private static final Executor f10508b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private static final String f10509c = String.format(Locale.ENGLISH, "%s=?", new Object[]{"url"});

    /* renamed from: d */
    private static final String f10510d = String.format(Locale.ENGLISH, "%s=? and %s<>-1", new Object[]{"url", VastIconXmlManager.DURATION});

    /* renamed from: e */
    private static final String f10511e = String.format(Locale.ENGLISH, "%s=? and %s<>-1", new Object[]{VastExtensionXmlManager.TYPE, VastIconXmlManager.DURATION});

    /* renamed from: f */
    private static final String f10512f = String.format(Locale.ENGLISH, "%s=?", new Object[]{VastExtensionXmlManager.ID});

    /* renamed from: g */
    private Context f10513g;

    /* renamed from: a */
    public static Executor m12069a() {
        return f10508b;
    }

    public RecentMediaStorage(Context context) {
        this.f10513g = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo17903a(int i, String str, long j, long j2, int i2, ExInfo exInfo) {
        if (str != null) {
            final int i3 = i;
            final String str2 = str;
            final long j3 = j;
            final long j4 = j2;
            final int i4 = i2;
            final ExInfo exInfo2 = exInfo;
            f10508b.execute(new Runnable() {
                public void run() {
                    RecentMediaStorage.this.m12076b(i3, str2, j3, j4, i4, exInfo2);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo17902a(int i, String str, long j) {
        if (str != null) {
            final int i2 = i;
            final String str2 = str;
            final long j2 = j;
            f10508b.execute(new Runnable() {
                public void run() {
                    RecentMediaStorage.this.m12075b(i2, str2, j2);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo17904a(final String str, final int i) {
        if (str != null) {
            f10508b.execute(new Runnable() {
                public void run() {
                    RecentMediaStorage.this.m12077b(str, i);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A[SYNTHETIC, Splitter:B:28:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006a A[SYNTHETIC, Splitter:B:35:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077 A[SYNTHETIC, Splitter:B:42:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0087 A[SYNTHETIC, Splitter:B:49:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo17905aa(String r6, String r7, boolean r8) {
        /*
            r5 = this;
            r0 = 0
            com.inshot.xplayer.content.RecentMediaStorage$a r1 = new com.inshot.xplayer.content.RecentMediaStorage$a     // Catch:{ Exception -> 0x0053, all -> 0x004f }
            android.content.Context r2 = r5.f10513g     // Catch:{ Exception -> 0x0053, all -> 0x004f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0053, all -> 0x004f }
            android.database.sqlite.SQLiteDatabase r2 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x004d }
            r2.beginTransaction()     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            r0.<init>()     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            java.lang.String r3 = "url"
            r0.put(r3, r7)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            java.lang.String r7 = "type"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            r0.put(r7, r8)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            java.lang.String r7 = "RecentMedia"
            java.lang.String r8 = f10509c     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            r4 = 0
            r3[r4] = r6     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            r2.update(r7, r0, r8, r3)     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            r2.setTransactionSuccessful()     // Catch:{ Exception -> 0x004a, all -> 0x0048 }
            if (r2 == 0) goto L_0x0042
            boolean r6 = r2.inTransaction()     // Catch:{ Exception -> 0x003e }
            if (r6 == 0) goto L_0x0042
            r2.endTransaction()     // Catch:{ Exception -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0042:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ Exception -> 0x006e }
            goto L_0x0072
        L_0x0048:
            r6 = move-exception
            goto L_0x0075
        L_0x004a:
            r6 = move-exception
            r0 = r2
            goto L_0x0055
        L_0x004d:
            r6 = move-exception
            goto L_0x0055
        L_0x004f:
            r6 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x0075
        L_0x0053:
            r6 = move-exception
            r1 = r0
        L_0x0055:
            r6.printStackTrace()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0068
            boolean r6 = r0.inTransaction()     // Catch:{ Exception -> 0x0064 }
            if (r6 == 0) goto L_0x0068
            r0.endTransaction()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0068
        L_0x0064:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0068:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ Exception -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0072:
            return
        L_0x0073:
            r6 = move-exception
            r2 = r0
        L_0x0075:
            if (r2 == 0) goto L_0x0085
            boolean r7 = r2.inTransaction()     // Catch:{ Exception -> 0x0081 }
            if (r7 == 0) goto L_0x0085
            r2.endTransaction()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0085:
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ Exception -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x008f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.RecentMediaStorage.mo17905a(java.lang.String, java.lang.String, boolean):void");
    }
    public void mo17905a(String str, String str2, boolean z) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        C2623a aVar;
        Exception e2;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            aVar = new C2623a(this.f10513g);
            try {
                sQLiteDatabase = aVar.getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("url", str2);
                    contentValues.put(VastExtensionXmlManager.TYPE, Integer.valueOf(z ? 1 : 0));
                    sQLiteDatabase.update("RecentMedia", contentValues, f10509c, new String[]{str});
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (aVar != null) {
                        try {
                            aVar.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    sQLiteDatabase2 = sQLiteDatabase;
                    try {
                        e2.printStackTrace();
                        if (sQLiteDatabase2 != null) {
                        }
                        if (aVar != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sQLiteDatabase = sQLiteDatabase2;
                        if (sQLiteDatabase != null) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (aVar != null) {
                            try {
                                aVar.close();
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (sQLiteDatabase != null) {
                    }
                    if (aVar != null) {
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e2 = e8;
                e2.printStackTrace();
                if (sQLiteDatabase2 != null) {
                    try {
                        if (sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase2.endTransaction();
                        }
                    } catch (Exception e9) {
                        e9.printStackTrace();
                    }
                }
                if (aVar != null) {
                    aVar.close();
                }
            }
        } catch (Exception e10) {
            e2 = e10;
            aVar = null;
            e2.printStackTrace();
            if (sQLiteDatabase2 != null) {
            }
            if (aVar != null) {
            }
        } catch (Throwable th4) {
            th = th4;
            aVar = null;
            sQLiteDatabase = null;
            if (sQLiteDatabase != null) {
            }
            if (aVar != null) {
            }
            //throw th;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12076b(int i, String str, long j, long j2, int i2, ExInfo exInfo) {
        DBBean a = i != -1 ? m12065a(i) : null;
        if (a == null) {
            a = m12067a(str, true);
        }
        if (a == null) {
            a = new DBBean();
        }
        a.f10529b = str;
        a.f10533f = j;
        a.f10534g = j2;
        a.f10531d = i2;
        a.f10535h = exInfo;
        m12070a(a);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12075b(int i, String str, long j) {
        DBBean a = i != -1 ? m12065a(i) : null;
        if (a == null) {
            a = m12067a(str, true);
        }
        if (a == null) {
            a = new DBBean();
        }
        a.f10529b = str;
        a.f10532e = j;
        m12070a(a);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12077b(String str, int i) {
        DBBean a = m12067a(str, true);
        if (a != null) {
            if (a.f10535h == null) {
                a.f10535h = new ExInfo();
            }
            a.f10535h.f10543h = i;
            m12070a(a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a3 A[SYNTHETIC, Splitter:B:35:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b3 A[SYNTHETIC, Splitter:B:42:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bf A[SYNTHETIC, Splitter:B:48:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cf A[SYNTHETIC, Splitter:B:55:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m12070aa(DBBean r5) {
        /*
            r4 = this;
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            int r1 = r5.f10528a
            r2 = -1
            if (r1 != r2) goto L_0x0010
            java.lang.String r1 = "id"
            r0.putNull(r1)
            goto L_0x001b
        L_0x0010:
            java.lang.String r1 = "id"
            int r2 = r5.f10528a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
        L_0x001b:
            java.lang.String r1 = "url"
            java.lang.String r2 = r5.f10529b
            r0.put(r1, r2)
            java.lang.String r1 = "name"
            java.lang.String r2 = r5.f10530c
            r0.put(r1, r2)
            java.lang.String r1 = "type"
            int r2 = r5.f10531d
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            java.lang.String r1 = "seen_length"
            long r2 = r5.f10533f
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.put(r1, r2)
            java.lang.String r1 = "duration"
            long r2 = r5.f10534g
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.put(r1, r2)
            java.lang.String r1 = "last_time"
            long r2 = r5.f10532e
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.put(r1, r2)
            java.lang.String r1 = "json"
            com.inshot.xplayer.content.RecentMediaStorage$ExInfo r5 = r5.f10535h
            java.lang.String r5 = m12068a((com.inshot.xplayer.content.RecentMediaStorage.ExInfo) r5)
            r0.put(r1, r5)
            r5 = 0
            com.inshot.xplayer.content.RecentMediaStorage$a r1 = new com.inshot.xplayer.content.RecentMediaStorage$a     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            android.content.Context r2 = r4.f10513g     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x009a, all -> 0x0095 }
            android.database.sqlite.SQLiteDatabase r2 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0092, all -> 0x008f }
            r2.beginTransaction()     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = "RecentMedia"
            r2.replace(r3, r5, r0)     // Catch:{ Exception -> 0x008d }
            r2.setTransactionSuccessful()     // Catch:{ Exception -> 0x008d }
            if (r2 == 0) goto L_0x0087
            boolean r5 = r2.inTransaction()     // Catch:{ Exception -> 0x0083 }
            if (r5 == 0) goto L_0x0087
            r2.endTransaction()     // Catch:{ Exception -> 0x0083 }
            goto L_0x0087
        L_0x0083:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0087:
            if (r1 == 0) goto L_0x00bb
            r1.close()     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00bb
        L_0x008d:
            r5 = move-exception
            goto L_0x009e
        L_0x008f:
            r0 = move-exception
            r2 = r5
            goto L_0x0098
        L_0x0092:
            r0 = move-exception
            r2 = r5
            goto L_0x009d
        L_0x0095:
            r0 = move-exception
            r1 = r5
            r2 = r1
        L_0x0098:
            r5 = r0
            goto L_0x00bd
        L_0x009a:
            r0 = move-exception
            r1 = r5
            r2 = r1
        L_0x009d:
            r5 = r0
        L_0x009e:
            r5.printStackTrace()     // Catch:{ all -> 0x00bc }
            if (r2 == 0) goto L_0x00b1
            boolean r5 = r2.inTransaction()     // Catch:{ Exception -> 0x00ad }
            if (r5 == 0) goto L_0x00b1
            r2.endTransaction()     // Catch:{ Exception -> 0x00ad }
            goto L_0x00b1
        L_0x00ad:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00b1:
            if (r1 == 0) goto L_0x00bb
            r1.close()     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00bb
        L_0x00b7:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00bb:
            return
        L_0x00bc:
            r5 = move-exception
        L_0x00bd:
            if (r2 == 0) goto L_0x00cd
            boolean r0 = r2.inTransaction()     // Catch:{ Exception -> 0x00c9 }
            if (r0 == 0) goto L_0x00cd
            r2.endTransaction()     // Catch:{ Exception -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00cd:
            if (r1 == 0) goto L_0x00d7
            r1.close()     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00d7
        L_0x00d3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d7:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.RecentMediaStorage.m12070a(com.inshot.xplayer.content.RecentMediaStorage$DBBean):void");
    }
    private void m12070a(DBBean dBBean) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        C2623a aVar;
        Exception e2;
        Exception e3;
        Throwable th2;
        ContentValues contentValues = new ContentValues();
        if (dBBean.f10528a == -1) {
            contentValues.putNull(VastExtensionXmlManager.ID);
        } else {
            contentValues.put(VastExtensionXmlManager.ID, Integer.valueOf(dBBean.f10528a));
        }
        contentValues.put("url", dBBean.f10529b);
        contentValues.put("name", dBBean.f10530c);
        contentValues.put(VastExtensionXmlManager.TYPE, Integer.valueOf(dBBean.f10531d));
        contentValues.put("seen_length", Long.valueOf(dBBean.f10533f));
        contentValues.put(VastIconXmlManager.DURATION, Long.valueOf(dBBean.f10534g));
        contentValues.put("last_time", Long.valueOf(dBBean.f10532e));
        contentValues.put(AdType.STATIC_NATIVE, m12068a(dBBean.f10535h));
        try {
            aVar = new C2623a(this.f10513g);
            try {
                sQLiteDatabase = aVar.getWritableDatabase();
                try {
                    sQLiteDatabase.beginTransaction();
                    sQLiteDatabase.replace("RecentMedia", null, contentValues);
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (aVar != null) {
                        try {
                            aVar.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    try {
                        e2.printStackTrace();
                        if (sQLiteDatabase != null) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Exception e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (aVar != null) {
                            aVar.close();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (sQLiteDatabase != null) {
                        }
                        if (aVar != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e8) {
                e3 = e8;
                sQLiteDatabase = null;
                e2 = e3;
                e2.printStackTrace();
                if (sQLiteDatabase != null) {
                }
                if (aVar != null) {
                }
            } catch (Throwable th4) {
                th2 = th4;
                sQLiteDatabase = null;
                th = th2;
                if (sQLiteDatabase != null) {
                }
                if (aVar != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e3 = e9;
            aVar = null;
            sQLiteDatabase = null;
            e2 = e3;
            e2.printStackTrace();
            if (sQLiteDatabase != null) {
            }
            if (aVar != null) {
            }
        } catch (Throwable th5) {
            th2 = th5;
            aVar = null;
            sQLiteDatabase = null;
            th = th2;
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
            //throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.inshot.xplayer.content.RecentMediaStorage$DBBean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0059 A[SYNTHETIC, Splitter:B:32:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0063 A[SYNTHETIC, Splitter:B:37:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006d A[SYNTHETIC, Splitter:B:43:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0077 A[SYNTHETIC, Splitter:B:48:0x0077] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DBBean m12065a_(int r14) {
        /*
            r13 = this;
            r0 = 0
            com.inshot.xplayer.content.RecentMediaStorage$a r1 = new com.inshot.xplayer.content.RecentMediaStorage$a     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            android.content.Context r2 = r13.f10513g     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            android.database.sqlite.SQLiteDatabase r3 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r4 = "RecentMedia"
            java.lang.String[] r5 = f10507a     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r6 = f10512f     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r2 = 0
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r7[r2] = r14     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            if (r14 == 0) goto L_0x0034
            boolean r2 = r14.moveToFirst()     // Catch:{ Exception -> 0x0032 }
            if (r2 == 0) goto L_0x0034
            com.inshot.xplayer.content.RecentMediaStorage$DBBean r2 = r13.m12066a((android.database.Cursor) r14)     // Catch:{ Exception -> 0x0032 }
            r0 = r2
            goto L_0x0034
        L_0x0032:
            r2 = move-exception
            goto L_0x0054
        L_0x0034:
            if (r14 == 0) goto L_0x003e
            r14.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r14 = move-exception
            r14.printStackTrace()
        L_0x003e:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ Exception -> 0x0044 }
            goto L_0x0066
        L_0x0044:
            r14 = move-exception
            r14.printStackTrace()
            goto L_0x0066
        L_0x0049:
            r14 = move-exception
            goto L_0x006b
        L_0x004b:
            r2 = move-exception
            r14 = r0
            goto L_0x0054
        L_0x004e:
            r14 = move-exception
            r1 = r0
            goto L_0x006b
        L_0x0051:
            r2 = move-exception
            r14 = r0
            r1 = r14
        L_0x0054:
            r2.printStackTrace()     // Catch:{ all -> 0x0067 }
            if (r14 == 0) goto L_0x0061
            r14.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0061:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ Exception -> 0x0044 }
        L_0x0066:
            return r0
        L_0x0067:
            r0 = move-exception
            r12 = r0
            r0 = r14
            r14 = r12
        L_0x006b:
            if (r0 == 0) goto L_0x0075
            r0.close()     // Catch:{ Exception -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0075:
            if (r1 == 0) goto L_0x007f
            r1.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007f:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.RecentMediaStorage.m12065a(int):com.inshot.xplayer.content.RecentMediaStorage$DBBean");
    }
    private DBBean m12065a(int i) {
        Throwable th;
        C2623a aVar;
        Cursor cursor;
        Exception e2;
        DBBean dBBean = null;
        dBBean = null;
        dBBean = null;
      //  r0 = null;
        Cursor cursor2 = null;
        dBBean = null;
        try {
            aVar = new C2623a(this.f10513g);
            try {
                cursor = aVar.getReadableDatabase().query("RecentMedia", f10507a, f10512f, new String[]{String.valueOf(i)}, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            dBBean = m12066a(cursor);
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            e2.printStackTrace();
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (aVar != null) {
                                aVar.close();
                            }
                            return dBBean;
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (aVar != null) {
                                try {
                                    aVar.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
                if (aVar != null) {
                    try {
                        aVar.close();
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
            } catch (Exception e9) {
                e2 = e9;
                cursor = null;
                e2.printStackTrace();
                if (cursor != null) {
                }
                if (aVar != null) {
                }
                return dBBean;
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                }
                if (aVar != null) {
                }
                throw th;
            }
        } catch (Exception e10) {
            e2 = e10;
            cursor = null;
            aVar = null;
            e2.printStackTrace();
            if (cursor != null) {
            }
            if (aVar != null) {
            }
            return dBBean;
        } catch (Throwable th4) {
            th = th4;
            aVar = null;
            if (cursor2 != null) {
            }
            if (aVar != null) {
            }
         ///   throw th;
        }
        return dBBean;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.inshot.xplayer.content.RecentMediaStorage$DBBean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0062 A[SYNTHETIC, Splitter:B:39:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006c A[SYNTHETIC, Splitter:B:44:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0074 A[SYNTHETIC, Splitter:B:50:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x007e A[SYNTHETIC, Splitter:B:55:0x007e] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DBBean m12067a_(String r14, boolean r15) {
        /*
            r13 = this;
            r0 = 0
            com.inshot.xplayer.content.RecentMediaStorage$a r1 = new com.inshot.xplayer.content.RecentMediaStorage$a     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            android.content.Context r2 = r13.f10513g     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x005a, all -> 0x0057 }
            android.database.sqlite.SQLiteDatabase r3 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            java.lang.String r4 = "RecentMedia"
            java.lang.String[] r5 = f10507a     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            if (r15 == 0) goto L_0x0015
            java.lang.String r15 = f10509c     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            goto L_0x0017
        L_0x0015:
            java.lang.String r15 = f10510d     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
        L_0x0017:
            r6 = r15
            r15 = 1
            java.lang.String[] r7 = new java.lang.String[r15]     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            r15 = 0
            r7[r15] = r14     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0054, all -> 0x0052 }
            if (r14 == 0) goto L_0x003d
            boolean r15 = r14.moveToFirst()     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            if (r15 == 0) goto L_0x003d
            com.inshot.xplayer.content.RecentMediaStorage$DBBean r15 = r13.m12066a((android.database.Cursor) r14)     // Catch:{ Exception -> 0x0038, all -> 0x0034 }
            r0 = r15
            goto L_0x003d
        L_0x0034:
            r15 = move-exception
            r0 = r14
            r14 = r15
            goto L_0x0072
        L_0x0038:
            r15 = move-exception
            r12 = r15
            r15 = r14
            r14 = r12
            goto L_0x005d
        L_0x003d:
            if (r14 == 0) goto L_0x0047
            r14.close()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r14 = move-exception
            r14.printStackTrace()
        L_0x0047:
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ Exception -> 0x004d }
            goto L_0x006f
        L_0x004d:
            r14 = move-exception
            r14.printStackTrace()
            goto L_0x006f
        L_0x0052:
            r14 = move-exception
            goto L_0x0072
        L_0x0054:
            r14 = move-exception
            r15 = r0
            goto L_0x005d
        L_0x0057:
            r14 = move-exception
            r1 = r0
            goto L_0x0072
        L_0x005a:
            r14 = move-exception
            r15 = r0
            r1 = r15
        L_0x005d:
            r14.printStackTrace()     // Catch:{ all -> 0x0070 }
            if (r15 == 0) goto L_0x006a
            r15.close()     // Catch:{ Exception -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r14 = move-exception
            r14.printStackTrace()
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.close()     // Catch:{ Exception -> 0x004d }
        L_0x006f:
            return r0
        L_0x0070:
            r14 = move-exception
            r0 = r15
        L_0x0072:
            if (r0 == 0) goto L_0x007c
            r0.close()     // Catch:{ Exception -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r15 = move-exception
            r15.printStackTrace()
        L_0x007c:
            if (r1 == 0) goto L_0x0086
            r1.close()     // Catch:{ Exception -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r15 = move-exception
            r15.printStackTrace()
        L_0x0086:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.RecentMediaStorage.m12067a(java.lang.String, boolean):com.inshot.xplayer.content.RecentMediaStorage$DBBean");
    }
    private DBBean m12067a(String str, boolean z) {
        Throwable th;
        C2623a aVar;
        Cursor cursor;
        Exception e2;
        DBBean dBBean = null;
        dBBean = null;
        dBBean = null;
      //  r0 = null;
        Cursor cursor2 = null;
        dBBean = null;
        try {
            aVar = new C2623a(this.f10513g);
            try {
                Cursor query = aVar.getReadableDatabase().query("RecentMedia", f10507a, z ? f10509c : f10510d, new String[]{str}, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            dBBean = m12066a(query);
                        }
                    } catch (Exception e3) {
                        cursor = query;
                        e2 = e3;
                        try {
                            e2.printStackTrace();
                            if (cursor != null) {
                            }
                            if (aVar != null) {
                            }
                            return dBBean;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (aVar != null) {
                                try {
                                    aVar.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor2 = query;
                        th = th3;
                        if (cursor2 != null) {
                        }
                        if (aVar != null) {
                        }
                        throw th;
                    }
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (aVar != null) {
                    try {
                        aVar.close();
                    } catch (Exception e7) {
                        e7.printStackTrace();
                    }
                }
            } catch (Exception e8) {
                e2 = e8;
                cursor = null;
                e2.printStackTrace();
                if (cursor != null) {
                }
                if (aVar != null) {
                }
                return dBBean;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                }
                if (aVar != null) {
                }
                throw th;
            }
        } catch (Exception e9) {
            e2 = e9;
            cursor = null;
            aVar = null;
            e2.printStackTrace();
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            if (aVar != null) {
                aVar.close();
            }
            return dBBean;
        } catch (Throwable th5) {
            th = th5;
            aVar = null;
            if (cursor2 != null) {
            }
            if (aVar != null) {
            }
           // throw th;
        }
        return dBBean;
    }

    /* renamed from: a */
    public DBBean mo17901a(String str) {
        return m12067a(str, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.inshot.xplayer.content.RecentMediaStorage$DBBean} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c A[SYNTHETIC, Splitter:B:32:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0066 A[SYNTHETIC, Splitter:B:37:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0070 A[SYNTHETIC, Splitter:B:43:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007a A[SYNTHETIC, Splitter:B:48:0x007a] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DBBean mo17906b_() {
        /*
            r13 = this;
            r0 = 0
            com.inshot.xplayer.content.RecentMediaStorage$a r1 = new com.inshot.xplayer.content.RecentMediaStorage$a     // Catch:{ Exception -> 0x0054, all -> 0x0050 }
            android.content.Context r2 = r13.f10513g     // Catch:{ Exception -> 0x0054, all -> 0x0050 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0054, all -> 0x0050 }
            android.database.sqlite.SQLiteDatabase r3 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x004d, all -> 0x004b }
            java.lang.String r4 = "RecentMedia"
            java.lang.String[] r5 = f10507a     // Catch:{ Exception -> 0x004d, all -> 0x004b }
            java.lang.String r6 = f10511e     // Catch:{ Exception -> 0x004d, all -> 0x004b }
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x004d, all -> 0x004b }
            r2 = 0
            java.lang.String r8 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x004d, all -> 0x004b }
            r7[r2] = r8     // Catch:{ Exception -> 0x004d, all -> 0x004b }
            r8 = 0
            r9 = 0
            java.lang.String r10 = "last_time DESC"
            java.lang.String r11 = "1"
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x004d, all -> 0x004b }
            if (r2 == 0) goto L_0x0036
            boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x0034 }
            if (r3 == 0) goto L_0x0036
            com.inshot.xplayer.content.RecentMediaStorage$DBBean r3 = r13.m12066a((android.database.Cursor) r2)     // Catch:{ Exception -> 0x0034 }
            r0 = r3
            goto L_0x0036
        L_0x0034:
            r3 = move-exception
            goto L_0x0057
        L_0x0036:
            if (r2 == 0) goto L_0x0040
            r2.close()     // Catch:{ Exception -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0040:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ Exception -> 0x0046 }
            goto L_0x0069
        L_0x0046:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0069
        L_0x004b:
            r2 = move-exception
            goto L_0x006e
        L_0x004d:
            r3 = move-exception
            r2 = r0
            goto L_0x0057
        L_0x0050:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x006e
        L_0x0054:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L_0x0057:
            r3.printStackTrace()     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0064
            r2.close()     // Catch:{ Exception -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0064:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ Exception -> 0x0046 }
        L_0x0069:
            return r0
        L_0x006a:
            r0 = move-exception
            r12 = r2
            r2 = r0
            r0 = r12
        L_0x006e:
            if (r0 == 0) goto L_0x0078
            r0.close()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0078:
            if (r1 == 0) goto L_0x0082
            r1.close()     // Catch:{ Exception -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0082:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.content.RecentMediaStorage.mo17906b():com.inshot.xplayer.content.RecentMediaStorage$DBBean");
    }
    public DBBean mo17906b() {
        Throwable th;
        C2623a aVar;
        Exception e2;
        Cursor cursor;
        DBBean dBBean = null;
        dBBean = null;
        dBBean = null;
       // r0 = null;
        Cursor cursor2 = null;
        dBBean = null;
        try {
            aVar = new C2623a(this.f10513g);
            try {
                cursor = aVar.getReadableDatabase().query("RecentMedia", f10507a, f10511e, new String[]{String.valueOf(0)}, null, null, "last_time DESC", "1");
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            dBBean = m12066a(cursor);
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            e2.printStackTrace();
                            if (cursor != null) {
                            }
                            if (aVar != null) {
                            }
                            return dBBean;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            if (aVar != null) {
                            }
                            throw th;
                        }
                    }
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (aVar != null) {
                    try {
                        aVar.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Exception e6) {
                e2 = e6;
                cursor = null;
                e2.printStackTrace();
                if (cursor != null) {
                }
                if (aVar != null) {
                }
                return dBBean;
            } catch (Throwable th3) {
                th = th3;
                if (cursor2 != null) {
                }
                if (aVar != null) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e2 = e7;
            aVar = null;
            cursor = null;
            e2.printStackTrace();
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            }
            if (aVar != null) {
                aVar.close();
            }
            return dBBean;
        } catch (Throwable th4) {
            th = th4;
            aVar = null;
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
           // throw th;
        }
        return dBBean;
    }

    /* renamed from: a */
    private DBBean m12066a(Cursor cursor) {
        DBBean dBBean = new DBBean();
        dBBean.f10528a = cursor.getInt(0);
        dBBean.f10529b = cursor.getString(1);
        dBBean.f10530c = cursor.getString(2);
        dBBean.f10531d = cursor.getInt(3);
        dBBean.f10532e = cursor.getLong(4);
        dBBean.f10533f = cursor.getLong(5);
        dBBean.f10534g = cursor.getLong(6);
        dBBean.f10535h = m12074b(cursor.getString(7));
        return dBBean;
    }

    public static class DBBean implements Parcelable {
        public static final Creator<DBBean> CREATOR = new Creator<DBBean>() {
            /* renamed from: a */
            public DBBean createFromParcel(Parcel parcel) {
                return new DBBean(parcel);
            }

            /* renamed from: a */
            public DBBean[] newArray(int i) {
                return new DBBean[i];
            }
        };

        /* renamed from: a */
        public int f10528a;

        /* renamed from: b */
        public String f10529b;

        /* renamed from: c */
        public String f10530c;

        /* renamed from: d */
        public int f10531d;

        /* renamed from: e */
        public long f10532e;

        /* renamed from: f */
        public long f10533f;

        /* renamed from: g */
        public long f10534g;

        /* renamed from: h */
        public ExInfo f10535h;

        public int describeContents() {
            return 0;
        }

        private DBBean() {
            this.f10528a = -1;
            this.f10534g = -1;
        }

        private DBBean(Parcel parcel) {
            this.f10528a = parcel.readInt();
            this.f10529b = parcel.readString();
            this.f10530c = parcel.readString();
            this.f10531d = parcel.readInt();
            this.f10532e = parcel.readLong();
            this.f10533f = parcel.readLong();
            this.f10534g = parcel.readLong();
            this.f10535h = (ExInfo) parcel.readParcelable(ExInfo.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f10528a);
            parcel.writeString(this.f10529b);
            parcel.writeString(this.f10530c);
            parcel.writeInt(this.f10531d);
            parcel.writeLong(this.f10532e);
            parcel.writeLong(this.f10533f);
            parcel.writeLong(this.f10534g);
            parcel.writeParcelable(this.f10535h, i);
        }
    }

    public static class ExInfo implements Parcelable {
        public static final Creator<ExInfo> CREATOR = new Creator<ExInfo>() {
            /* renamed from: a */
            public ExInfo createFromParcel(Parcel parcel) {
                return new ExInfo(parcel);
            }

            /* renamed from: a */
            public ExInfo[] newArray(int i) {
                return new ExInfo[i];
            }
        };

        /* renamed from: a */
        public String f10536a;

        /* renamed from: b */
        public int f10537b;

        /* renamed from: c */
        public boolean f10538c;

        /* renamed from: d */
        public int f10539d;

        /* renamed from: e */
        public int f10540e;

        /* renamed from: f */
        public float f10541f;

        /* renamed from: g */
        public int f10542g;

        /* renamed from: h */
        public int f10543h;

        /* renamed from: i */
        public float f10544i;

        public int describeContents() {
            return 0;
        }

        public ExInfo() {
            this.f10539d = -1;
            this.f10540e = -1;
            this.f10541f = -1.0f;
            this.f10542g = -1;
            this.f10543h = -1;
            this.f10544i = 0.0f;
        }

        private ExInfo(Parcel parcel) {
            this.f10539d = -1;
            this.f10540e = -1;
            this.f10541f = -1.0f;
            this.f10542g = -1;
            this.f10543h = -1;
            this.f10544i = 0.0f;
            this.f10536a = parcel.readString();
            this.f10537b = parcel.readInt();
            this.f10538c = parcel.readByte() != 0;
            this.f10539d = parcel.readInt();
            this.f10540e = parcel.readInt();
            this.f10541f = parcel.readFloat();
            this.f10542g = parcel.readInt();
            this.f10543h = parcel.readByte();
            this.f10544i = parcel.readFloat();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f10536a);
            parcel.writeInt(this.f10537b);
            parcel.writeByte(this.f10538c ? (byte) 1 : 0);
            parcel.writeInt(this.f10539d);
            parcel.writeInt(this.f10540e);
            parcel.writeFloat(this.f10541f);
            parcel.writeInt(this.f10542g);
            parcel.writeByte((byte) this.f10543h);
            parcel.writeFloat(this.f10544i);
        }
    }

    /* renamed from: b */
    private static ExInfo m12074b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                ExInfo exInfo = new ExInfo();
                exInfo.f10536a = jSONObject.optString("a", (String) null);
                boolean z = false;
                exInfo.f10537b = jSONObject.optInt("b", 0);
                if (1 == jSONObject.optInt("c", 0)) {
                    z = true;
                }
                exInfo.f10538c = z;
                exInfo.f10539d = jSONObject.optInt("d", -1);
                exInfo.f10541f = (float) jSONObject.optDouble("f", -1.0d);
                exInfo.f10540e = jSONObject.optInt("g", -1);
                exInfo.f10542g = jSONObject.optInt("e", -1);
                exInfo.f10543h = jSONObject.optInt("h", -1);
                exInfo.f10544i = (float) jSONObject.optDouble("i", 0.0d);
                return exInfo;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: a */
    private static String m12068a(ExInfo exInfo) {
        if (exInfo == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", exInfo.f10536a);
            jSONObject.put("b", exInfo.f10537b);
            jSONObject.put("c", exInfo.f10538c ? 1 : 0);
            jSONObject.put("d", exInfo.f10539d);
            jSONObject.put("f", (double) exInfo.f10541f);
            jSONObject.put("g", exInfo.f10540e);
            jSONObject.put("e", exInfo.f10542g);
            jSONObject.put("h", exInfo.f10543h);
            jSONObject.put("i", (double) exInfo.f10544i);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: com.inshot.xplayer.content.RecentMediaStorage$a */
    public static class C2623a extends SQLiteOpenHelper {
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public C2623a(Context context) {
            super(context, "RecentMedia.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(" CREATE TABLE IF NOT EXISTS RecentMedia (id INTEGER PRIMARY KEY AUTOINCREMENT, url VARCHAR UNIQUE, name VARCHAR, type INTEGER, last_time INTEGER, seen_length INTEGER, duration INTEGER, json VARCHAR)");
        }
    }
}
