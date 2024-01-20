package classesdef.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import classesdef.browser.bbc;
import classesdef.browser.BrowserData;
import classesdef.browser.bph;
import classesdef.eventbus.bnx;

/* renamed from: bnm */
public class bnm {

    /* renamed from: a */
    private static bnm f15978a;

    private bnm() {
    }

    /* renamed from: a */
    public static synchronized bnm m18246a() {
        bnm bnm;
        synchronized (bnm.class) {
            if (f15978a == null) {
                f15978a = new bnm();
            }
            bnm = f15978a;
        }
        return bnm;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo23221aa(android.content.Context r7, long r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            bnl r2 = new bnl     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0047, all -> 0x0043 }
            android.database.sqlite.SQLiteDatabase r7 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x003f, all -> 0x003c }
            java.lang.String r3 = "record_info"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r4.<init>()     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            java.lang.String r5 = "_id= "
            r4.append(r5)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r4.append(r8)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            java.lang.String r8 = ""
            r4.append(r8)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            java.lang.String r8 = r4.toString()     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            int r8 = r7.delete(r3, r8, r1)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            if (r2 == 0) goto L_0x002c
            r2.close()
        L_0x002c:
            if (r7 == 0) goto L_0x0064
            boolean r9 = r7.isOpen()
            if (r9 == 0) goto L_0x0064
            r7.close()
            goto L_0x0064
        L_0x0038:
            r8 = move-exception
            goto L_0x006b
        L_0x003a:
            r8 = move-exception
            goto L_0x0041
        L_0x003c:
            r8 = move-exception
            r7 = r1
            goto L_0x006b
        L_0x003f:
            r8 = move-exception
            r7 = r1
        L_0x0041:
            r1 = r2
            goto L_0x0049
        L_0x0043:
            r8 = move-exception
            r7 = r1
            r2 = r7
            goto L_0x006b
        L_0x0047:
            r8 = move-exception
            r7 = r1
        L_0x0049:
            r8.printStackTrace()     // Catch:{ all -> 0x0069 }
            bor r9 = bor.m18385a()     // Catch:{ all -> 0x0069 }
            r9.mo23297a((java.lang.Throwable) r8)     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0058
            r1.close()
        L_0x0058:
            if (r7 == 0) goto L_0x0063
            boolean r8 = r7.isOpen()
            if (r8 == 0) goto L_0x0063
            r7.close()
        L_0x0063:
            r8 = 0
        L_0x0064:
            if (r8 != 0) goto L_0x0067
            return r0
        L_0x0067:
            r7 = 1
            return r7
        L_0x0069:
            r8 = move-exception
            r2 = r1
        L_0x006b:
            if (r2 == 0) goto L_0x0070
            r2.close()
        L_0x0070:
            if (r7 == 0) goto L_0x007b
            boolean r9 = r7.isOpen()
            if (r9 == 0) goto L_0x007b
            r7.close()
        L_0x007b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23221a(android.content.Context, long):boolean");
    }
    public boolean mo23221a(Context context, long j) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bnl bnl;
        int i = 0;
        Exception e;
        bnl bnl2 = null;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getWritableDatabase();
            }
            catch (Exception e2) {
                e = e2;
                sQLiteDatabase = null;
                bnl2 = bnl;
                try {
                    e.printStackTrace();
                    BrowserData.m18385a().mo23297a(e);
                    if (bnl2 != null) {
                        bnl2.close();
                    }
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    i = 0;
                    if (i != 0) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bnl = bnl2;
                    if (bnl != null) {
                    }
                    sQLiteDatabase.close();
                    throw th;
                }
            }
            catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
                if (bnl != null) {
                    bnl.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
            try {
                i = sQLiteDatabase.delete("record_info", "_id= " + j + "", null);
                if (bnl != null) {
                    bnl.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
            } catch (Exception e3) {
                e = e3;
                bnl2 = bnl;
                e.printStackTrace();
                BrowserData.m18385a().mo23297a(e);
                if (bnl2 != null) {
                }
                sQLiteDatabase.close();
                i = 0;
                if (i != 0) {
                }
            } catch (Throwable th4) {
                th = th4;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            e.printStackTrace();
            BrowserData.m18385a().mo23297a(e);
            if (bnl2 != null) {
            }
            sQLiteDatabase.close();
            i = 0;
            if (i != 0) {
            }
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
            bnl = null;
            if (bnl != null) {
            }
            sQLiteDatabase.close();
           // throw th;
        }
        if (i != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007c, code lost:
        if (r9.isOpen() != false) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x007e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0084, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0086, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ac, code lost:
        if (r9.isOpen() != false) goto L_0x007e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0084 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x000c] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo23217aa(android.content.Context r9, bph r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            bnl r3 = new bnl     // Catch:{ Exception -> 0x0094, all -> 0x0090 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x0094, all -> 0x0090 }
            android.database.sqlite.SQLiteDatabase r9 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x008b, all -> 0x0088 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r4.<init>()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "download_link"
            java.lang.String r6 = r10.mo23339c()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "father_link"
            java.lang.String r6 = r10.mo23354i()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "time"
            long r6 = r10.mo23343d()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "file_name"
            java.lang.String r6 = r10.mo23346e()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "file_type"
            int r6 = r10.mo23352h()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "download_state"
            int r6 = r10.mo23355j()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "other"
            java.lang.String r6 = r10.mo23328a()     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "record_info"
            long r4 = r9.insert(r5, r0, r4)     // Catch:{ Exception -> 0x0086, all -> 0x0084 }
            r10.mo23330a((long) r4)     // Catch:{ Exception -> 0x0082, all -> 0x0084 }
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.C3279c.m14239a()     // Catch:{ Exception -> 0x0082, all -> 0x0084 }
            bnx r1 = new bnx     // Catch:{ Exception -> 0x0082, all -> 0x0084 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x0082, all -> 0x0084 }
            r0.mo20557d(r1)     // Catch:{ Exception -> 0x0082, all -> 0x0084 }
            if (r3 == 0) goto L_0x0076
            r3.close()
        L_0x0076:
            if (r9 == 0) goto L_0x00af
            boolean r10 = r9.isOpen()
            if (r10 == 0) goto L_0x00af
        L_0x007e:
            r9.close()
            goto L_0x00af
        L_0x0082:
            r10 = move-exception
            goto L_0x008e
        L_0x0084:
            r10 = move-exception
            goto L_0x00b2
        L_0x0086:
            r10 = move-exception
            goto L_0x008d
        L_0x0088:
            r10 = move-exception
            r9 = r0
            goto L_0x00b2
        L_0x008b:
            r10 = move-exception
            r9 = r0
        L_0x008d:
            r4 = r1
        L_0x008e:
            r0 = r3
            goto L_0x0097
        L_0x0090:
            r10 = move-exception
            r9 = r0
            r3 = r9
            goto L_0x00b2
        L_0x0094:
            r10 = move-exception
            r9 = r0
            r4 = r1
        L_0x0097:
            r10.printStackTrace()     // Catch:{ all -> 0x00b0 }
            bor r1 = bor.m18385a()     // Catch:{ all -> 0x00b0 }
            r1.mo23297a((java.lang.Throwable) r10)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x00a6
            r0.close()
        L_0x00a6:
            if (r9 == 0) goto L_0x00af
            boolean r10 = r9.isOpen()
            if (r10 == 0) goto L_0x00af
            goto L_0x007e
        L_0x00af:
            return r4
        L_0x00b0:
            r10 = move-exception
            r3 = r0
        L_0x00b2:
            if (r3 == 0) goto L_0x00b7
            r3.close()
        L_0x00b7:
            if (r9 == 0) goto L_0x00c2
            boolean r0 = r9.isOpen()
            if (r0 == 0) goto L_0x00c2
            r9.close()
        L_0x00c2:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23217a(android.content.Context, bph):long");
    }
    public long mo23217a(Context context, bph bph) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bnl bnl;
        long j = 0;
        Exception e;
        bnl bnl2 = null;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("download_link", bph.mo23339c());
                    contentValues.put("father_link", bph.mo23354i());
                    contentValues.put("time", Long.valueOf(bph.mo23343d()));
                    contentValues.put("file_name", bph.mo23346e());
                    contentValues.put("file_type", Integer.valueOf(bph.mo23352h()));
                    contentValues.put("download_state", Integer.valueOf(bph.mo23355j()));
                    contentValues.put("other", bph.mo23328a());
                    j = sQLiteDatabase.insert("record_info", null, contentValues);
                    bph.mo23330a(j);
                    EventBus.getDefault().post(new bnx(bph));
                    if (bnl != null) {
                        bnl.close();
                    }
                    if (sQLiteDatabase != null) {
                    }
                } catch (Exception e2) {
                    e = e2;
                    bnl2 = bnl;
                    try {
                        e.printStackTrace();
                        BrowserData.m18385a().mo23297a(e);
                        if (bnl2 != null) {
                        }
                        if (sQLiteDatabase != null) {
                        }
                        return j;
                    } catch (Throwable th2) {
                        th = th2;
                        bnl = bnl2;
                        if (bnl != null) {
                            bnl.close();
                        }
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                }
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase = null;
                j = 0;
                bnl2 = bnl;
                e.printStackTrace();
                BrowserData.m18385a().mo23297a(e);
                if (bnl2 != null) {
                    bnl2.close();
                }
                if (sQLiteDatabase != null) {
                }
                return j;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabase = null;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            j = 0;
            e.printStackTrace();
            BrowserData.m18385a().mo23297a(e);
            if (bnl2 != null) {
            }
            if (sQLiteDatabase != null) {
            }
            return j;
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
            bnl = null;
            if (bnl != null) {
            }
            sQLiteDatabase.close();
            ///throw th;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0078  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo23223bb(android.content.Context r10, bph r11) {
        /*
            r9 = this;
            r0 = 0
            r2 = 0
            bnl r3 = new bnl     // Catch:{ Exception -> 0x0056, all -> 0x0052 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x0056, all -> 0x0052 }
            android.database.sqlite.SQLiteDatabase r10 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            r4.<init>()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            java.lang.String r5 = "other"
            java.lang.String r6 = r11.mo23328a()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            java.lang.String r5 = "record_info"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            r6.<init>()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            java.lang.String r7 = "_id = "
            r6.append(r7)     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            long r7 = r11.mo23333b()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            r6.append(r7)     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            java.lang.String r11 = r6.toString()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            int r11 = r10.update(r5, r4, r11, r2)     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            long r4 = (long) r11
            if (r3 == 0) goto L_0x003b
            r3.close()
        L_0x003b:
            if (r10 == 0) goto L_0x006c
            boolean r11 = r10.isOpen()
            if (r11 == 0) goto L_0x006c
            r10.close()
            goto L_0x006c
        L_0x0047:
            r11 = move-exception
            goto L_0x0076
        L_0x0049:
            r11 = move-exception
            goto L_0x0050
        L_0x004b:
            r11 = move-exception
            r10 = r2
            goto L_0x0076
        L_0x004e:
            r11 = move-exception
            r10 = r2
        L_0x0050:
            r2 = r3
            goto L_0x0058
        L_0x0052:
            r11 = move-exception
            r10 = r2
            r3 = r10
            goto L_0x0076
        L_0x0056:
            r11 = move-exception
            r10 = r2
        L_0x0058:
            r11.printStackTrace()     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0060
            r2.close()
        L_0x0060:
            if (r10 == 0) goto L_0x006b
            boolean r11 = r10.isOpen()
            if (r11 == 0) goto L_0x006b
            r10.close()
        L_0x006b:
            r4 = r0
        L_0x006c:
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 != 0) goto L_0x0072
            r10 = 0
            return r10
        L_0x0072:
            r10 = 1
            return r10
        L_0x0074:
            r11 = move-exception
            r3 = r2
        L_0x0076:
            if (r3 == 0) goto L_0x007b
            r3.close()
        L_0x007b:
            if (r10 == 0) goto L_0x0086
            boolean r0 = r10.isOpen()
            if (r0 == 0) goto L_0x0086
            r10.close()
        L_0x0086:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23223b(android.content.Context, bph):boolean");
    }
    public boolean mo23223b(Context context, bph bph) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bnl bnl;
        long j = 0;
        Exception e;
        bnl bnl2 = null;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("other", bph.mo23328a());
                    j = (long) sQLiteDatabase.update("record_info", contentValues, "_id = " + bph.mo23333b(), null);
                    if (bnl != null) {
                        bnl.close();
                    }
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    bnl2 = bnl;
                    try {
                        e.printStackTrace();
                        if (bnl2 != null) {
                        }
                        sQLiteDatabase.close();
                        j = 0;
                        if (j == 0) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bnl = bnl2;
                        if (bnl != null) {
                            bnl.close();
                        }
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bnl != null) {
                    }
                    sQLiteDatabase.close();
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase = null;
                bnl2 = bnl;
                e.printStackTrace();
                if (bnl2 != null) {
                    bnl2.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                j = 0;
                if (j == 0) {
                }
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabase = null;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            e.printStackTrace();
            if (bnl2 != null) {
            }
            sQLiteDatabase.close();
            j = 0;
            if (j == 0) {
            }
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
            bnl = null;
            if (bnl != null) {
            }
            sQLiteDatabase.close();
            //throw th;
        }
        return j == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0078  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo23225cc(android.content.Context r10, bph r11) {
        /*
            r9 = this;
            r0 = 0
            r2 = 0
            bnl r3 = new bnl     // Catch:{ Exception -> 0x0056, all -> 0x0052 }
            r3.<init>(r10)     // Catch:{ Exception -> 0x0056, all -> 0x0052 }
            android.database.sqlite.SQLiteDatabase r10 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x004e, all -> 0x004b }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            r4.<init>()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            java.lang.String r5 = "file_name"
            java.lang.String r6 = r11.mo23346e()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            java.lang.String r5 = "record_info"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            r6.<init>()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            java.lang.String r7 = "_id = "
            r6.append(r7)     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            long r7 = r11.mo23333b()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            r6.append(r7)     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            java.lang.String r11 = r6.toString()     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            int r11 = r10.update(r5, r4, r11, r2)     // Catch:{ Exception -> 0x0049, all -> 0x0047 }
            long r4 = (long) r11
            if (r3 == 0) goto L_0x003b
            r3.close()
        L_0x003b:
            if (r10 == 0) goto L_0x006c
            boolean r11 = r10.isOpen()
            if (r11 == 0) goto L_0x006c
            r10.close()
            goto L_0x006c
        L_0x0047:
            r11 = move-exception
            goto L_0x0076
        L_0x0049:
            r11 = move-exception
            goto L_0x0050
        L_0x004b:
            r11 = move-exception
            r10 = r2
            goto L_0x0076
        L_0x004e:
            r11 = move-exception
            r10 = r2
        L_0x0050:
            r2 = r3
            goto L_0x0058
        L_0x0052:
            r11 = move-exception
            r10 = r2
            r3 = r10
            goto L_0x0076
        L_0x0056:
            r11 = move-exception
            r10 = r2
        L_0x0058:
            r11.printStackTrace()     // Catch:{ all -> 0x0074 }
            if (r2 == 0) goto L_0x0060
            r2.close()
        L_0x0060:
            if (r10 == 0) goto L_0x006b
            boolean r11 = r10.isOpen()
            if (r11 == 0) goto L_0x006b
            r10.close()
        L_0x006b:
            r4 = r0
        L_0x006c:
            int r10 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r10 != 0) goto L_0x0072
            r10 = 0
            return r10
        L_0x0072:
            r10 = 1
            return r10
        L_0x0074:
            r11 = move-exception
            r3 = r2
        L_0x0076:
            if (r3 == 0) goto L_0x007b
            r3.close()
        L_0x007b:
            if (r10 == 0) goto L_0x0086
            boolean r0 = r10.isOpen()
            if (r0 == 0) goto L_0x0086
            r10.close()
        L_0x0086:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23225c(android.content.Context, bph):boolean");
    }
    public boolean mo23225c(Context context, bph bph) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bnl bnl;
        long j = 0;
        Exception e;
        bnl bnl2 = null;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("file_name", bph.mo23346e());
                    j = (long) sQLiteDatabase.update("record_info", contentValues, "_id = " + bph.mo23333b(), null);
                    if (bnl != null) {
                        bnl.close();
                    }
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    bnl2 = bnl;
                    try {
                        e.printStackTrace();
                        if (bnl2 != null) {
                        }
                        sQLiteDatabase.close();
                        j = 0;
                        if (j == 0) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bnl = bnl2;
                        if (bnl != null) {
                            bnl.close();
                        }
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bnl != null) {
                    }
                    sQLiteDatabase.close();
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase = null;
                bnl2 = bnl;
                e.printStackTrace();
                if (bnl2 != null) {
                    bnl2.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                j = 0;
                if (j == 0) {
                }
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabase = null;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            e.printStackTrace();
            if (bnl2 != null) {
            }
            sQLiteDatabase.close();
            j = 0;
            if (j == 0) {
            }
        } catch (Throwable th5) {
            th = th5;
            sQLiteDatabase = null;
            bnl = null;
            if (bnl != null) {
            }
            sQLiteDatabase.close();
            //throw th;
        }
        return j == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo23222aa(android.content.Context r9, String r10, int r11) {
        /*
            r8 = this;
            r0 = 0
            r2 = 0
            bnl r3 = new bnl     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            r3.<init>(r9)     // Catch:{ Exception -> 0x0064, all -> 0x0060 }
            android.database.sqlite.SQLiteDatabase r4 = r3.getWritableDatabase()     // Catch:{ Exception -> 0x005c, all -> 0x0059 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r5.<init>()     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String r6 = "download_state"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r5.put(r6, r11)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String r11 = "time"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r5.put(r11, r6)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String r11 = "record_info"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r6.<init>()     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String r7 = "file_name = '"
            r6.append(r7)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            r6.append(r10)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String r10 = "'"
            r6.append(r10)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            java.lang.String r10 = r6.toString()     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            int r10 = r4.update(r11, r5, r10, r2)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            long r9 = (long) r10
            if (r3 == 0) goto L_0x0049
            r3.close()
        L_0x0049:
            if (r4 == 0) goto L_0x0081
            boolean r11 = r4.isOpen()
            if (r11 == 0) goto L_0x0081
            r4.close()
            goto L_0x0081
        L_0x0055:
            r9 = move-exception
            goto L_0x008b
        L_0x0057:
            r10 = move-exception
            goto L_0x005e
        L_0x0059:
            r9 = move-exception
            r4 = r2
            goto L_0x008b
        L_0x005c:
            r10 = move-exception
            r4 = r2
        L_0x005e:
            r2 = r3
            goto L_0x0066
        L_0x0060:
            r9 = move-exception
            r3 = r2
            r4 = r3
            goto L_0x008b
        L_0x0064:
            r10 = move-exception
            r4 = r2
        L_0x0066:
            r10.printStackTrace()     // Catch:{ all -> 0x0089 }
            bbc r11 = bbc.m15886a()     // Catch:{ all -> 0x0089 }
            r11.mo21879a((android.content.Context) r9, (java.lang.Throwable) r10)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x0075
            r2.close()
        L_0x0075:
            if (r4 == 0) goto L_0x0080
            boolean r9 = r4.isOpen()
            if (r9 == 0) goto L_0x0080
            r4.close()
        L_0x0080:
            r9 = r0
        L_0x0081:
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 != 0) goto L_0x0087
            r9 = 0
            return r9
        L_0x0087:
            r9 = 1
            return r9
        L_0x0089:
            r9 = move-exception
            r3 = r2
        L_0x008b:
            if (r3 == 0) goto L_0x0090
            r3.close()
        L_0x0090:
            if (r4 == 0) goto L_0x009b
            boolean r10 = r4.isOpen()
            if (r10 == 0) goto L_0x009b
            r4.close()
        L_0x009b:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23222a(android.content.Context, java.lang.String, int):boolean");
    }
    public boolean mo23222a(Context context, String str, int i) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bnl bnl;
        long j = 0;
        Exception e;
        bnl bnl2 = null;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getWritableDatabase();
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("download_state", Integer.valueOf(i));
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    j = (long) sQLiteDatabase.update("record_info", contentValues, "file_name = '" + str + "'", null);
                    if (bnl != null) {
                        bnl.close();
                    }
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    bnl2 = bnl;
                    try {
                        e.printStackTrace();
                        bbc.m15886a().mo21879a(context, e);
                        if (bnl2 != null) {
                        }
                        sQLiteDatabase.close();
                        j = 0;
                        if (j == 0) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bnl = bnl2;
                        if (bnl != null) {
                        }
                        sQLiteDatabase.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bnl != null) {
                    }
                    sQLiteDatabase.close();
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase = null;
                bnl2 = bnl;
                e.printStackTrace();
                bbc.m15886a().mo21879a(context, e);
                if (bnl2 != null) {
                    bnl2.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                j = 0;
                if (j == 0) {
                }
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabase = null;
                if (bnl != null) {
                    bnl.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            sQLiteDatabase = null;
            e.printStackTrace();
            bbc.m15886a().mo21879a(context, e);
            if (bnl2 != null) {
            }
            sQLiteDatabase.close();
            j = 0;
            if (j == 0) {
            }
        } catch (Throwable th5) {
            th = th5;
            bnl = null;
            sQLiteDatabase = null;
            if (bnl != null) {
            }
            sQLiteDatabase.close();
            //throw th;
        }
        return j == 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: bnl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: bph} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        r10 = th;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        r7 = null;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006b, code lost:
        r10 = m18247a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        bau.m15850a("exist link = " + r11, new java.lang.Object[0]);
        bau.m15850a("exist dblk = " + r6, new java.lang.Object[0]);
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009b, code lost:
        r7 = r10;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        r7 = r10;
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c1, code lost:
        r10 = th;
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c4, code lost:
        r10 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c5, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e4, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x011e, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c1 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v7 ?) = (r3v0 ?), (r3v13 ?), (r3v15 ?), (r3v16 ?) binds: [B:5:0x000f, B:24:0x0051, B:30:0x006f, B:31:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bph mo23218aa(android.content.Context r10, String r11) {
        /*
            r9 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            r3 = 0
            bnl r4 = new bnl     // Catch:{ Exception -> 0x00d4, all -> 0x00d0 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x00d4, all -> 0x00d0 }
            android.database.sqlite.SQLiteDatabase r5 = r4.getReadableDatabase()     // Catch:{ Exception -> 0x00ca, all -> 0x00c7 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c4, all -> 0x00c1 }
            r6.<init>()     // Catch:{ Exception -> 0x00c4, all -> 0x00c1 }
            java.lang.String r7 = "select * from record_info where download_link = '"
            r6.append(r7)     // Catch:{ Exception -> 0x00c4, all -> 0x00c1 }
            r6.append(r11)     // Catch:{ Exception -> 0x00c4, all -> 0x00c1 }
            java.lang.String r7 = "'"
            r6.append(r7)     // Catch:{ Exception -> 0x00c4, all -> 0x00c1 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00c4, all -> 0x00c1 }
            android.database.Cursor r6 = r5.rawQuery(r6, r3)     // Catch:{ Exception -> 0x00c4, all -> 0x00c1 }
            if (r6 == 0) goto L_0x003d
            boolean r7 = r6.moveToNext()     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            if (r7 == 0) goto L_0x003d
            bph r7 = r9.m18247a((android.database.Cursor) r6)     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            goto L_0x003e
        L_0x0036:
            r10 = move-exception
            goto L_0x011b
        L_0x0039:
            r10 = move-exception
            r7 = r3
            goto L_0x00ce
        L_0x003d:
            r7 = r3
        L_0x003e:
            if (r7 != 0) goto L_0x00a4
            if (r6 == 0) goto L_0x0049
            r6.close()     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            goto L_0x0049
        L_0x0046:
            r10 = move-exception
            goto L_0x00ce
        L_0x0049:
            java.lang.String r8 = "select * from record_info"
            android.database.Cursor r3 = r5.rawQuery(r8, r3)     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            if (r3 == 0) goto L_0x00a5
        L_0x0051:
            boolean r6 = r3.moveToNext()     // Catch:{ Exception -> 0x00a1, all -> 0x00c1 }
            if (r6 == 0) goto L_0x00a5
            java.lang.String r6 = "download_link"
            int r6 = r3.getColumnIndexOrThrow(r6)     // Catch:{ Exception -> 0x00a1, all -> 0x00c1 }
            java.lang.String r6 = r3.getString(r6)     // Catch:{ Exception -> 0x00a1, all -> 0x00c1 }
            boh r8 = boh.m18304a()     // Catch:{ Exception -> 0x00a1, all -> 0x00c1 }
            boolean r8 = r8.mo23263a(r10, r11, r6)     // Catch:{ Exception -> 0x00a1, all -> 0x00c1 }
            if (r8 == 0) goto L_0x0051
            bph r10 = r9.m18247a((android.database.Cursor) r3)     // Catch:{ Exception -> 0x00a1, all -> 0x00c1 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            r7.<init>()     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            java.lang.String r8 = "exist link = "
            r7.append(r8)     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            r7.append(r11)     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            java.lang.String r11 = r7.toString()     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            bau.m15850a(r11, r7)     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            r11.<init>()     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            java.lang.String r7 = "exist dblk = "
            r11.append(r7)     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            r11.append(r6)     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            bau.m15850a(r11, r6)     // Catch:{ Exception -> 0x009d, all -> 0x00c1 }
            r7 = r10
            goto L_0x00a5
        L_0x009d:
            r11 = move-exception
            r7 = r10
            r10 = r11
            goto L_0x00a2
        L_0x00a1:
            r10 = move-exception
        L_0x00a2:
            r6 = r3
            goto L_0x00ce
        L_0x00a4:
            r3 = r6
        L_0x00a5:
            if (r4 == 0) goto L_0x00aa
            r4.close()
        L_0x00aa:
            if (r5 == 0) goto L_0x00b5
            boolean r10 = r5.isOpen()
            if (r10 == 0) goto L_0x00b5
            r5.close()
        L_0x00b5:
            if (r3 == 0) goto L_0x00fd
            boolean r10 = r3.isClosed()
            if (r10 != 0) goto L_0x00fd
            r3.close()
            goto L_0x00fd
        L_0x00c1:
            r10 = move-exception
            goto L_0x011c
        L_0x00c4:
            r10 = move-exception
            r6 = r3
            goto L_0x00cd
        L_0x00c7:
            r10 = move-exception
            r5 = r3
            goto L_0x011c
        L_0x00ca:
            r10 = move-exception
            r5 = r3
            r6 = r5
        L_0x00cd:
            r7 = r6
        L_0x00ce:
            r3 = r4
            goto L_0x00d8
        L_0x00d0:
            r10 = move-exception
            r4 = r3
            r5 = r4
            goto L_0x011c
        L_0x00d4:
            r10 = move-exception
            r5 = r3
            r6 = r5
            r7 = r6
        L_0x00d8:
            r10.printStackTrace()     // Catch:{ all -> 0x0119 }
            bor r11 = bor.m18385a()     // Catch:{ all -> 0x0119 }
            r11.mo23297a((java.lang.Throwable) r10)     // Catch:{ all -> 0x0119 }
            if (r3 == 0) goto L_0x00e7
            r3.close()
        L_0x00e7:
            if (r5 == 0) goto L_0x00f2
            boolean r10 = r5.isOpen()
            if (r10 == 0) goto L_0x00f2
            r5.close()
        L_0x00f2:
            if (r6 == 0) goto L_0x00fd
            boolean r10 = r6.isClosed()
            if (r10 != 0) goto L_0x00fd
            r6.close()
        L_0x00fd:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "check exist time = "
            r10.append(r11)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r0
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            java.lang.Object[] r11 = new java.lang.Object[r2]
            bau.m15850a(r10, r11)
            return r7
        L_0x0119:
            r10 = move-exception
            r4 = r3
        L_0x011b:
            r3 = r6
        L_0x011c:
            if (r4 == 0) goto L_0x0121
            r4.close()
        L_0x0121:
            if (r5 == 0) goto L_0x012c
            boolean r11 = r5.isOpen()
            if (r11 == 0) goto L_0x012c
            r5.close()
        L_0x012c:
            if (r3 == 0) goto L_0x0137
            boolean r11 = r3.isClosed()
            if (r11 != 0) goto L_0x0137
            r3.close()
        L_0x0137:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23218a(android.content.Context, java.lang.String):bph");
    }
    public bph mo23218a(Context context, String str) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bnl bnl;
        Cursor cursor;
        bph bph = null;
        Exception e;
        Cursor cursor2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        bnl bnl2 = null;
        //r3 = null;
       // r3 = null;
        Cursor cursor3 = null;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getReadableDatabase();
                try {
                    cursor = sQLiteDatabase.rawQuery("select * from record_info where download_link = '" + str + "'", null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToNext()) {
                                bph = m18247a(cursor);
                                if (bph != null) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    cursor2 = sQLiteDatabase.rawQuery("select * from record_info", null);
                                    if (cursor2 != null) {
                                        while (true) {
                                            if (!cursor2.moveToNext()) {
                                                break;
                                            }
                                            String string = cursor2.getString(cursor2.getColumnIndexOrThrow("download_link"));
                                            if (boh.m18304a().mo23263a(context, str, string)) {
                                                break;
                                            }
                                        }
                                    }
                                } else {
                                    cursor2 = cursor;
                                }
                                if (bnl != null) {
                                    bnl.close();
                                }
                                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                    sQLiteDatabase.close();
                                }
                                if (cursor2 != null && !cursor2.isClosed()) {
                                    cursor2.close();
                                }
                                Logger.e("check exist time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                                return bph;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bnl2 = bnl;
                            try {
                                e.printStackTrace();
                                BrowserData.m18385a().mo23297a(e);
                                if (bnl2 != null) {
                                }
                                sQLiteDatabase.close();
                                cursor.close();
                                Logger.e("check exist time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                                return bph;
                            } catch (Throwable th2) {
                                th = th2;
                                bnl = bnl2;
                                cursor3 = cursor;
                                if (bnl != null) {
                                }
                                sQLiteDatabase.close();
                                cursor3.close();
                                throw th;
                            }
                        } catch (Throwable th3) {
                        }
                    }
                    bph = null;
                    if (bph != null) {
                    }
                    if (bnl != null) {
                    }
                    sQLiteDatabase.close();
//                    cursor2.close();
                } catch (Exception e3) {
                    e = e3;
                    cursor = cursor2;
                    bnl2 = bnl;
                    e.printStackTrace();
                    BrowserData.m18385a().mo23297a(e);
                    if (bnl2 != null) {
                    }
                    sQLiteDatabase.close();
//                    cursor.close();
                    Logger.e("check exist time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                    return bph;
                } catch (Throwable th4) {
                }
            } catch (Exception e4) {
                e = e4;
                sQLiteDatabase = null;
                cursor = null;
               // bph = cursor;
                bnl2 = bnl;
                e.printStackTrace();
                BrowserData.m18385a().mo23297a(e);
                if (bnl2 != null) {
                }
////                sQLiteDatabase.close();
                cursor.close();
                Logger.e("check exist time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                return bph;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                cursor3.close();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase = null;
            cursor = null;
            bph = null;
            e.printStackTrace();
            BrowserData.m18385a().mo23297a(e);
            if (bnl2 != null) {
            }
//            sQLiteDatabase.close();
//            cursor.close();
            Logger.e("check exist time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
            return bph;
        } catch (Throwable th6) {
            th = th6;
            bnl = null;
            sQLiteDatabase = null;
            if (bnl != null) {
            }
            sQLiteDatabase.close();
            cursor3.close();
           /// throw th;
        }
        Logger.e("check exist time = " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        return bph;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: bnl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: bnl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: bnl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: bnl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: bnl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: bnl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: bnl} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: android.database.Cursor} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009c  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo23224bb(android.content.Context r7, String r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
            bnl r2 = new bnl     // Catch:{ Exception -> 0x006c, all -> 0x0067 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x006c, all -> 0x0067 }
            android.database.sqlite.SQLiteDatabase r7 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0062, all -> 0x005e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r3.<init>()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            java.lang.String r4 = "select * from record_info where file_name = '"
            r3.append(r4)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            r3.append(r8)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            java.lang.String r8 = "'"
            r3.append(r8)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            java.lang.String r8 = r3.toString()     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            android.database.Cursor r8 = r7.rawQuery(r8, r0)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            if (r8 == 0) goto L_0x003b
            boolean r0 = r8.moveToNext()     // Catch:{ Exception -> 0x0036, all -> 0x0030 }
            if (r0 == 0) goto L_0x003b
            r0 = 1
            r1 = 1
            goto L_0x003b
        L_0x0030:
            r0 = move-exception
            r5 = r0
            r0 = r8
            r8 = r5
            goto L_0x009a
        L_0x0036:
            r0 = move-exception
            r5 = r2
            r2 = r8
            r8 = r0
            goto L_0x005c
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.close()
        L_0x0040:
            if (r7 == 0) goto L_0x004b
            boolean r0 = r7.isOpen()
            if (r0 == 0) goto L_0x004b
            r7.close()
        L_0x004b:
            if (r8 == 0) goto L_0x0095
            boolean r7 = r8.isClosed()
            if (r7 != 0) goto L_0x0095
            r8.close()
            goto L_0x0095
        L_0x0057:
            r8 = move-exception
            goto L_0x009a
        L_0x0059:
            r8 = move-exception
            r5 = r2
            r2 = r0
        L_0x005c:
            r0 = r5
            goto L_0x0070
        L_0x005e:
            r7 = move-exception
            r8 = r7
            r7 = r0
            goto L_0x009a
        L_0x0062:
            r7 = move-exception
            r8 = r7
            r7 = r0
            r0 = r2
            goto L_0x006f
        L_0x0067:
            r7 = move-exception
            r8 = r7
            r7 = r0
            r2 = r7
            goto L_0x009a
        L_0x006c:
            r7 = move-exception
            r8 = r7
            r7 = r0
        L_0x006f:
            r2 = r7
        L_0x0070:
            r8.printStackTrace()     // Catch:{ all -> 0x0096 }
            bor r3 = bor.m18385a()     // Catch:{ all -> 0x0096 }
            r3.mo23297a((java.lang.Throwable) r8)     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x007f
            r0.close()
        L_0x007f:
            if (r7 == 0) goto L_0x008a
            boolean r8 = r7.isOpen()
            if (r8 == 0) goto L_0x008a
            r7.close()
        L_0x008a:
            if (r2 == 0) goto L_0x0095
            boolean r7 = r2.isClosed()
            if (r7 != 0) goto L_0x0095
            r2.close()
        L_0x0095:
            return r1
        L_0x0096:
            r8 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
        L_0x009a:
            if (r2 == 0) goto L_0x009f
            r2.close()
        L_0x009f:
            if (r7 == 0) goto L_0x00aa
            boolean r1 = r7.isOpen()
            if (r1 == 0) goto L_0x00aa
            r7.close()
        L_0x00aa:
            if (r0 == 0) goto L_0x00b5
            boolean r7 = r0.isClosed()
            if (r7 != 0) goto L_0x00b5
            r0.close()
        L_0x00b5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23224b(android.content.Context, java.lang.String):boolean");
    }
    public boolean mo23224b(Context context, String str) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bnl bnl;
        Exception e;
        Cursor cursor = null;
        bnl bnl2;
        bnl bnl3 = null;
        //r0 = null;
        //r0 = null;
        Cursor cursor2 = null;
        boolean z = false;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getReadableDatabase();
            } catch (Exception e2) {
                e = e2;
                sQLiteDatabase = null;
                bnl3 = bnl;
             //   cursor = sQLiteDatabase;
                try {
                    e.printStackTrace();
                    BrowserData.m18385a().mo23297a(e);
                    if (bnl3 != null) {
                    }
                    sQLiteDatabase.close();
                    cursor.close();
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    bnl = bnl3;
                    cursor2 = cursor;
                    if (bnl != null) {
                    }
                    sQLiteDatabase.close();
                    cursor2.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                cursor2.close();
                throw th;
            }
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select * from record_info where file_name = '" + str + "'", null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToNext()) {
                            z = true;
                        }
                    } catch (Exception e3) {
                        bnl2 = bnl;
                        cursor = rawQuery;
                        e = e3;
                        bnl3 = bnl2;
                        e.printStackTrace();
                        BrowserData.m18385a().mo23297a(e);
                        if (bnl3 != null) {
                        }
                        sQLiteDatabase.close();
                        cursor.close();
                        return z;
                    } catch (Throwable th4) {
                        cursor2 = rawQuery;
                        th = th4;
                        if (bnl != null) {
                        }
                        sQLiteDatabase.close();
                        cursor2.close();
                        throw th;
                    }
                }
                if (bnl != null) {
                    bnl.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                if (rawQuery != null && !rawQuery.isClosed()) {
                    rawQuery.close();
                }
            } catch (Exception e4) {
                e = e4;
                bnl2 = bnl;
                cursor = null;
                bnl3 = bnl2;
                e.printStackTrace();
                BrowserData.m18385a().mo23297a(e);
                if (bnl3 != null) {
                }
                sQLiteDatabase.close();
                cursor.close();
                return z;
            } catch (Throwable th5) {
                th = th5;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                cursor2.close();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase = null;
          //  cursor = sQLiteDatabase;
            e.printStackTrace();
            BrowserData.m18385a().mo23297a(e);
            if (bnl3 != null) {
                bnl3.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return z;
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
            bnl = null;
            if (bnl != null) {
                bnl.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            if (cursor2 != null && !cursor2.isClosed()) {
                cursor2.close();
            }
           // throw th;
        }
        return z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: bnl} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        if (r7.isClosed() == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0093, code lost:
        if (r7.isClosed() == false) goto L_0x005b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<bph> mo23220aa(android.content.Context r6, int r7, int r8) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            bnl r2 = new bnl     // Catch:{ Exception -> 0x0070, all -> 0x006c }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0070, all -> 0x006c }
            android.database.sqlite.SQLiteDatabase r6 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0067, all -> 0x0064 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            r3.<init>()     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            java.lang.String r4 = "select * from record_info where download_state = 2 order by time desc  limit "
            r3.append(r4)     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            r3.append(r7)     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            java.lang.String r4 = " offset "
            r3.append(r4)     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            int r8 = r8 * r7
            r3.append(r8)     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            java.lang.String r7 = r3.toString()     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            android.database.Cursor r7 = r6.rawQuery(r7, r1)     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            if (r7 == 0) goto L_0x0043
        L_0x0030:
            boolean r8 = r7.moveToNext()     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            if (r8 == 0) goto L_0x0043
            bph r8 = r5.m18247a((android.database.Cursor) r7)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            r0.add(r8)     // Catch:{ Exception -> 0x0041, all -> 0x003e }
            goto L_0x0030
        L_0x003e:
            r8 = move-exception
            goto L_0x0099
        L_0x0041:
            r8 = move-exception
            goto L_0x006a
        L_0x0043:
            if (r2 == 0) goto L_0x0048
            r2.close()
        L_0x0048:
            if (r6 == 0) goto L_0x0053
            boolean r8 = r6.isOpen()
            if (r8 == 0) goto L_0x0053
            r6.close()
        L_0x0053:
            if (r7 == 0) goto L_0x0096
            boolean r6 = r7.isClosed()
            if (r6 != 0) goto L_0x0096
        L_0x005b:
            r7.close()
            goto L_0x0096
        L_0x005f:
            r8 = move-exception
            goto L_0x009a
        L_0x0061:
            r8 = move-exception
            r7 = r1
            goto L_0x006a
        L_0x0064:
            r8 = move-exception
            r6 = r1
            goto L_0x009a
        L_0x0067:
            r8 = move-exception
            r6 = r1
            r7 = r6
        L_0x006a:
            r1 = r2
            goto L_0x0073
        L_0x006c:
            r8 = move-exception
            r6 = r1
            r2 = r6
            goto L_0x009a
        L_0x0070:
            r8 = move-exception
            r6 = r1
            r7 = r6
        L_0x0073:
            r8.printStackTrace()     // Catch:{ all -> 0x0097 }
            bor r2 = bor.m18385a()     // Catch:{ all -> 0x0097 }
            r2.mo23297a((java.lang.Throwable) r8)     // Catch:{ all -> 0x0097 }
            if (r1 == 0) goto L_0x0082
            r1.close()
        L_0x0082:
            if (r6 == 0) goto L_0x008d
            boolean r8 = r6.isOpen()
            if (r8 == 0) goto L_0x008d
            r6.close()
        L_0x008d:
            if (r7 == 0) goto L_0x0096
            boolean r6 = r7.isClosed()
            if (r6 != 0) goto L_0x0096
            goto L_0x005b
        L_0x0096:
            return r0
        L_0x0097:
            r8 = move-exception
            r2 = r1
        L_0x0099:
            r1 = r7
        L_0x009a:
            if (r2 == 0) goto L_0x009f
            r2.close()
        L_0x009f:
            if (r6 == 0) goto L_0x00aa
            boolean r7 = r6.isOpen()
            if (r7 == 0) goto L_0x00aa
            r6.close()
        L_0x00aa:
            if (r1 == 0) goto L_0x00b5
            boolean r6 = r1.isClosed()
            if (r6 != 0) goto L_0x00b5
            r1.close()
        L_0x00b5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23220a(android.content.Context, int, int):java.util.ArrayList");
    }
    public ArrayList<bph> mo23220a(Context context, int i, int i2) {
        Throwable th;
        SQLiteDatabase sQLiteDatabase;
        bnl bnl;
        Cursor cursor;
        Exception e;
        ArrayList<bph> arrayList = new ArrayList<>();
        bnl bnl2 = null;
        //r1 = null;
       // r1 = null;
        Cursor cursor2 = null;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getReadableDatabase();
                try {
                    cursor = sQLiteDatabase.rawQuery("select * from record_info where download_state = 2 order by time desc  limit " + i + " offset " + (i2 * i), null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                arrayList.add(m18247a(cursor));
                            } catch (Exception e2) {
                                e = e2;
                                bnl2 = bnl;
                                try {
                                    e.printStackTrace();
                                    BrowserData.m18385a().mo23297a(e);
                                    if (bnl2 != null) {
                                    }
                                    sQLiteDatabase.close();
                                    if (cursor != null) {
                                    }
                                    return arrayList;
                                } catch (Throwable th2) {
                                    th = th2;
                                    bnl = bnl2;
                                    cursor2 = cursor;
                                    if (bnl != null) {
                                        bnl.close();
                                    }
                                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                        sQLiteDatabase.close();
                                    }
                                    if (cursor2 != null && !cursor2.isClosed()) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                cursor2 = cursor;
                                if (bnl != null) {
                                }
                                sQLiteDatabase.close();
                                cursor2.close();
                                throw th;
                            }
                        }
                    }
                    if (bnl != null) {
                        bnl.close();
                    }
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    if (cursor != null) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                    bnl2 = bnl;
                    e.printStackTrace();
                    BrowserData.m18385a().mo23297a(e);
                    if (bnl2 != null) {
                    }
                    sQLiteDatabase.close();
                    if (cursor != null) {
                    }
                    return arrayList;
                } catch (Throwable th4) {
                    th = th4;
                    if (bnl != null) {
                    }
                    sQLiteDatabase.close();
                    cursor2.close();
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                sQLiteDatabase = null;
                cursor = null;
                bnl2 = bnl;
                e.printStackTrace();
                BrowserData.m18385a().mo23297a(e);
                if (bnl2 != null) {
                    bnl2.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                if (cursor != null) {
                }
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase = null;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                cursor2.close();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase = null;
            cursor = null;
            e.printStackTrace();
            BrowserData.m18385a().mo23297a(e);
            if (bnl2 != null) {
            }
            sQLiteDatabase.close();
            if (cursor != null) {
            }
            return arrayList;
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
            bnl = null;
            if (bnl != null) {
            }
            sQLiteDatabase.close();
            cursor2.close();
           // throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r3.isClosed() == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0045, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0084, code lost:
        if (r3.isClosed() == false) goto L_0x0045;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x008d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<bph> mo23219aa(android.content.Context r7) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            bnl r2 = new bnl     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            android.database.sqlite.SQLiteDatabase r7 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0057, all -> 0x0053 }
            java.lang.String r3 = "select * from record_info where download_state = 1 order by time desc "
            android.database.Cursor r3 = r7.rawQuery(r3, r1)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            if (r3 == 0) goto L_0x002d
        L_0x0017:
            boolean r1 = r3.moveToNext()     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            if (r1 == 0) goto L_0x002d
            bph r1 = r6.m18247a((android.database.Cursor) r3)     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            r0.add(r1)     // Catch:{ Exception -> 0x0028, all -> 0x0025 }
            goto L_0x0017
        L_0x0025:
            r0 = move-exception
            goto L_0x008b
        L_0x0028:
            r1 = move-exception
            r5 = r2
            r2 = r7
            r7 = r1
            goto L_0x0051
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            r2.close()
        L_0x0032:
            if (r7 == 0) goto L_0x003d
            boolean r1 = r7.isOpen()
            if (r1 == 0) goto L_0x003d
            r7.close()
        L_0x003d:
            if (r3 == 0) goto L_0x0087
            boolean r7 = r3.isClosed()
            if (r7 != 0) goto L_0x0087
        L_0x0045:
            r3.close()
            goto L_0x0087
        L_0x0049:
            r0 = move-exception
            r3 = r1
            goto L_0x008b
        L_0x004c:
            r3 = move-exception
            r5 = r2
            r2 = r7
            r7 = r3
            r3 = r1
        L_0x0051:
            r1 = r5
            goto L_0x0064
        L_0x0053:
            r0 = move-exception
            r7 = r1
            r3 = r7
            goto L_0x008b
        L_0x0057:
            r7 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
            goto L_0x0064
        L_0x005c:
            r0 = move-exception
            r7 = r1
            r2 = r7
            r3 = r2
            goto L_0x008b
        L_0x0061:
            r7 = move-exception
            r2 = r1
            r3 = r2
        L_0x0064:
            r7.printStackTrace()     // Catch:{ all -> 0x0088 }
            bor r4 = bor.m18385a()     // Catch:{ all -> 0x0088 }
            r4.mo23297a((java.lang.Throwable) r7)     // Catch:{ all -> 0x0088 }
            if (r1 == 0) goto L_0x0073
            r1.close()
        L_0x0073:
            if (r2 == 0) goto L_0x007e
            boolean r7 = r2.isOpen()
            if (r7 == 0) goto L_0x007e
            r2.close()
        L_0x007e:
            if (r3 == 0) goto L_0x0087
            boolean r7 = r3.isClosed()
            if (r7 != 0) goto L_0x0087
            goto L_0x0045
        L_0x0087:
            return r0
        L_0x0088:
            r0 = move-exception
            r7 = r2
            r2 = r1
        L_0x008b:
            if (r2 == 0) goto L_0x0090
            r2.close()
        L_0x0090:
            if (r7 == 0) goto L_0x009b
            boolean r1 = r7.isOpen()
            if (r1 == 0) goto L_0x009b
            r7.close()
        L_0x009b:
            if (r3 == 0) goto L_0x00a6
            boolean r7 = r3.isClosed()
            if (r7 != 0) goto L_0x00a6
            r3.close()
        L_0x00a6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bnm.mo23219a(android.content.Context):java.util.ArrayList");
    }
    public ArrayList<bph> mo23219a(Context context) {
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        bnl bnl;
        Throwable th;
        Exception e;
        SQLiteDatabase sQLiteDatabase2;
        bnl bnl2;
        ArrayList<bph> arrayList = new ArrayList<>();
        bnl bnl3 = null;
        try {
            bnl = new bnl(context);
            try {
                sQLiteDatabase = bnl.getReadableDatabase();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
                bnl3 = bnl;
                sQLiteDatabase2 = null;
                try {
                    e.printStackTrace();
                    BrowserData.m18385a().mo23297a(e);
                    if (bnl3 != null) {
                    }
                    sQLiteDatabase2.close();
                    if (cursor != null) {
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase = sQLiteDatabase2;
                    bnl = bnl3;
                    if (bnl != null) {
                    }
                    sQLiteDatabase.close();
                    cursor.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteDatabase = null;
                cursor = null;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                cursor.close();
                throw th;
            }
            try {
                cursor = sQLiteDatabase.rawQuery("select * from record_info where download_state = 1 order by time desc ", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            arrayList.add(m18247a(cursor));
                        } catch (Exception e3) {
                            bnl2 = bnl;
                            sQLiteDatabase2 = sQLiteDatabase;
                            e = e3;
                            bnl3 = bnl2;
                            e.printStackTrace();
                            BrowserData.m18385a().mo23297a(e);
                            if (bnl3 != null) {
                            }
                            sQLiteDatabase2.close();
                            if (cursor != null) {
                            }
                            return arrayList;
                        } catch (Throwable th4) {
                            th = th4;
                            if (bnl != null) {
                            }
                            sQLiteDatabase.close();
                            cursor.close();
                            throw th;
                        }
                    }
                }
                if (bnl != null) {
                    bnl.close();
                }
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    sQLiteDatabase.close();
                }
                if (cursor != null) {
                }
            } catch (Exception e4) {
                bnl2 = bnl;
                sQLiteDatabase2 = sQLiteDatabase;
                e = e4;
                cursor = null;
                bnl3 = bnl2;
                e.printStackTrace();
                BrowserData.m18385a().mo23297a(e);
                if (bnl3 != null) {
                }
                sQLiteDatabase2.close();
                if (cursor != null) {
                }
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                cursor = null;
                if (bnl != null) {
                }
                sQLiteDatabase.close();
                cursor.close();
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            sQLiteDatabase2 = null;
            cursor = null;
            e.printStackTrace();
            BrowserData.m18385a().mo23297a(e);
            if (bnl3 != null) {
                bnl3.close();
            }
            if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                sQLiteDatabase2.close();
            }
            if (cursor != null) {
            }
            return arrayList;
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabase = null;
            bnl = null;
            cursor = null;
            if (bnl != null) {
                bnl.close();
            }
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
           // throw th;
        }
        return arrayList;
    }

    /* renamed from: a */
    private bph m18247a(Cursor cursor) {
        bph bph = new bph();
        bph.mo23330a(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
        bph.mo23337b(cursor.getString(cursor.getColumnIndexOrThrow("download_link")));
        bph.mo23347e(cursor.getString(cursor.getColumnIndexOrThrow("father_link")));
        bph.mo23336b(cursor.getLong(cursor.getColumnIndexOrThrow("time")));
        bph.mo23342c(cursor.getString(cursor.getColumnIndexOrThrow("file_name")));
        bph.mo23329a(cursor.getInt(cursor.getColumnIndexOrThrow("file_type")));
        bph.mo23335b(cursor.getInt(cursor.getColumnIndexOrThrow("download_state")));
        bph.mo23331a(cursor.getString(cursor.getColumnIndexOrThrow("other")));
        return bph;
    }
}
