package classesdef.database;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import classesdef.browser.bmg;
import hdplayer.vlcplayer.videoplayer.R;


@Singleton
/* renamed from: bmo */
public class bmo extends SQLiteOpenHelper {

    /* renamed from: a */
    private SQLiteDatabase f15677a = getWritableDatabase();

    @Inject
    public bmo(Application application) {
        super(application, "historyManager", (SQLiteDatabase.CursorFactory) null, 2);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE history(id INTEGER PRIMARY KEY,url TEXT,title TEXT,time INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS history");
        onCreate(sQLiteDatabase);
    }

    /* renamed from: a */
    private static bmg m18059a(Cursor cursor) {
        bmg bmg = new bmg();
        bmg.mo23047b(cursor.getString(1));
        bmg.mo23049c(cursor.getString(2));
        bmg.mo23041a((int) R.drawable.ic_downloader_history);
        return bmg;
    }

    /* renamed from: c */
    private SQLiteDatabase m18061c() {
        if (this.f15677a == null || !this.f15677a.isOpen()) {
            this.f15677a = getWritableDatabase();
        }
        return this.f15677a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo23102a() {
        m18061c().delete("history", (String) null, (String[]) null);
        m18061c().close();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo23103a(String str) {
        m18061c().delete("history", "url = ?", new String[]{str});
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo23104a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str2 == null ? "" : str2);
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        Cursor query = m18061c().query(false, "history", new String[]{"url"}, "url = ?", new String[]{str}, (String) null, (String) null, (String) null, "1");
        if (query.getCount() > 0) {
            m18061c().update("history", contentValues, "url = ?", new String[]{str});
        } else {
            if (str2 == null) {
                str2 = "";
            }
            m18060a(new bmg(str, str2));
        }
        query.close();
    }

    /* renamed from: a */
    private synchronized void m18060a(bmg bmg) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", bmg.mo23052e());
        contentValues.put("title", bmg.mo23054f());
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        m18061c().insert("history", (String) null, contentValues);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0066 A[SYNTHETIC, Splitter:B:29:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073 A[SYNTHETIC, Splitter:B:36:0x0073] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<bmg> mo23106bb(String r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x007d }
            r1 = 5
            r0.<init>(r1)     // Catch:{ all -> 0x007d }
            if (r13 != 0) goto L_0x000b
            monitor-exit(r12)
            return r0
        L_0x000b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r1.<init>()     // Catch:{ all -> 0x007d }
            r2 = 37
            r1.append(r2)     // Catch:{ all -> 0x007d }
            r1.append(r13)     // Catch:{ all -> 0x007d }
            r1.append(r2)     // Catch:{ all -> 0x007d }
            java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x007d }
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r12.m18061c()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = "history"
            r4 = 0
            java.lang.String r5 = "title LIKE ? OR url LIKE ?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Exception -> 0x0060 }
            r7 = 0
            r6[r7] = r13     // Catch:{ Exception -> 0x0060 }
            r7 = 1
            r6[r7] = r13     // Catch:{ Exception -> 0x0060 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "time DESC"
            java.lang.String r10 = "5"
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0060 }
        L_0x003c:
            boolean r1 = r13.moveToNext()     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            if (r1 == 0) goto L_0x004a
            bmg r1 = m18059a((android.database.Cursor) r13)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            r0.add(r1)     // Catch:{ Exception -> 0x0059, all -> 0x0056 }
            goto L_0x003c
        L_0x004a:
            if (r13 == 0) goto L_0x006f
            boolean r1 = r13.isClosed()     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x006f
            r13.close()     // Catch:{ all -> 0x007d }
            goto L_0x006f
        L_0x0056:
            r0 = move-exception
            r1 = r13
            goto L_0x0071
        L_0x0059:
            r1 = move-exception
            r11 = r1
            r1 = r13
            r13 = r11
            goto L_0x0061
        L_0x005e:
            r0 = move-exception
            goto L_0x0071
        L_0x0060:
            r13 = move-exception
        L_0x0061:
            r13.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r1 == 0) goto L_0x006f
            boolean r13 = r1.isClosed()     // Catch:{ all -> 0x007d }
            if (r13 != 0) goto L_0x006f
            r1.close()     // Catch:{ all -> 0x007d }
        L_0x006f:
            monitor-exit(r12)
            return r0
        L_0x0071:
            if (r1 == 0) goto L_0x007c
            boolean r13 = r1.isClosed()     // Catch:{ all -> 0x007d }
            if (r13 != 0) goto L_0x007c
            r1.close()     // Catch:{ all -> 0x007d }
        L_0x007c:
            throw r0     // Catch:{ all -> 0x007d }
        L_0x007d:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.bmo.mo23106b(java.lang.String):java.util.List");
    }
    public synchronized List<bmg> mo23106b(String str) {
        Throwable th;
        Exception e;
        ArrayList arrayList = new ArrayList(5);
        if (str == null) {
            return arrayList;
        }
        String str2 = '%' + str + '%';
        Cursor cursor = null;
        try {
            Cursor query = m18061c().query("history", null, "title LIKE ? OR url LIKE ?", new String[]{str2, str2}, null, null, "time DESC", "5");
            while (query.moveToNext()) {
                try {
                    arrayList.add(m18059a(query));
                } catch (Exception e2) {
                    cursor = query;
                    e = e2;
                    try {
                        e.printStackTrace();
                        cursor.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor.close();
                      //  throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                 //  throw th;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[SYNTHETIC, Splitter:B:24:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0053 A[SYNTHETIC, Splitter:B:31:0x0053] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<bmg> mo23105bb() {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x005d }
            r1 = 100
            r0.<init>(r1)     // Catch:{ all -> 0x005d }
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r12.m18061c()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r3 = "history"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "time DESC"
            java.lang.String r10 = "100"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0040 }
        L_0x001c:
            boolean r1 = r2.moveToNext()     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            if (r1 == 0) goto L_0x002a
            bmg r1 = m18059a((android.database.Cursor) r2)     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            r0.add(r1)     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            goto L_0x001c
        L_0x002a:
            if (r2 == 0) goto L_0x004f
            boolean r1 = r2.isClosed()     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x004f
            r2.close()     // Catch:{ all -> 0x005d }
            goto L_0x004f
        L_0x0036:
            r0 = move-exception
            r1 = r2
            goto L_0x0051
        L_0x0039:
            r1 = move-exception
            r11 = r2
            r2 = r1
            r1 = r11
            goto L_0x0041
        L_0x003e:
            r0 = move-exception
            goto L_0x0051
        L_0x0040:
            r2 = move-exception
        L_0x0041:
            r2.printStackTrace()     // Catch:{ all -> 0x003e }
            if (r1 == 0) goto L_0x004f
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x004f
            r1.close()     // Catch:{ all -> 0x005d }
        L_0x004f:
            monitor-exit(r12)
            return r0
        L_0x0051:
            if (r1 == 0) goto L_0x005c
            boolean r2 = r1.isClosed()     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x005c
            r1.close()     // Catch:{ all -> 0x005d }
        L_0x005c:
            throw r0     // Catch:{ all -> 0x005d }
        L_0x005d:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.bmo.mo23105b():java.util.List");
    }
    public synchronized List<bmg> mo23105b() {
        ArrayList arrayList;
        Throwable th;
        Exception e;
        arrayList = new ArrayList(100);
        Cursor cursor = null;
        try {
            Cursor query = m18061c().query("history", null, null, null, null, null, "time DESC", "100");
            while (query.moveToNext()) {
                try {
                    arrayList.add(m18059a(query));
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        cursor.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor.close();
                       // throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = query;
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                   // throw th;
                }
            }
            if (query != null && !query.isClosed()) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
        return arrayList;
    }

}
