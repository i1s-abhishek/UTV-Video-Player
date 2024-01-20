package classesdef.database;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import com.mopub.mobileads.VastExtensionXmlManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import classesdef.browser.bmg;
import classesdef.browser.bmj;
import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4927w;
import hdplayer.vlcplayer.videoplayer.R;


@Singleton
/* renamed from: bmh */
public class bmh extends SQLiteOpenHelper implements bmj {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f15646a;

    @Inject
    public bmh(Application application) {
        super(application, "bookmarkManager", (SQLiteDatabase.CursorFactory) null, 1);
        this.f15646a = application.getString(R.string.untitled);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + DatabaseUtils.sqlEscapeString("bookmark") + '(' + DatabaseUtils.sqlEscapeString(VastExtensionXmlManager.ID) + " INTEGER PRIMARY KEY," + DatabaseUtils.sqlEscapeString("url") + " TEXT," + DatabaseUtils.sqlEscapeString("title") + " TEXT," + DatabaseUtils.sqlEscapeString("folder") + " TEXT," + DatabaseUtils.sqlEscapeString("position") + " INTEGER" + ')');
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseUtils.sqlEscapeString("bookmark"));
        onCreate(sQLiteDatabase);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static ContentValues m17985d(bmg bmg) {
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("title", bmg.mo23054f());
        contentValues.put("url", bmg.mo23052e());
        contentValues.put("folder", bmg.mo23048c());
        contentValues.put("position", Integer.valueOf(bmg.mo23045b()));
        return contentValues;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static bmg m17984c(Cursor cursor) {
        bmg bmg = new bmg();
        bmg.mo23041a((int) R.drawable.ic_bookmark);
        bmg.mo23047b(cursor.getString(cursor.getColumnIndex("url")));
        bmg.mo23049c(cursor.getString(cursor.getColumnIndex("title")));
        bmg.mo23043a(cursor.getString(cursor.getColumnIndex("folder")));
        bmg.mo23046b(cursor.getInt(cursor.getColumnIndex("position")));
        return bmg;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static List<bmg> m17986d(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(m17984c(cursor));
        }
        cursor.close();
        return arrayList;
    }

    /* renamed from: a */
    public C4805t<bmg> mo23063a(final String str) {
        return C4805t.m21581a(new C4858u<bmg>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.database.sqlite.SQLiteDatabase} */
            /* JADX WARNING: type inference failed for: r0v0 */
            /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r0v3 */
            /* JADX WARNING: type inference failed for: r0v5 */
            /* JADX WARNING: type inference failed for: r0v9 */
            /* JADX WARNING: type inference failed for: r0v10 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4927w<bmg> r13) {
                /*
                    r12 = this;
                    r0 = 0
                    bmh r1 = bmh.this     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x005b, all -> 0x0058 }
                    java.lang.String r3 = "bookmark"
                    r4 = 0
                    java.lang.String r5 = "url=?"
                    r2 = 1
                    java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
                    r2 = 0
                    java.lang.String r7 = r2     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
                    r6[r2] = r7     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    java.lang.String r10 = "1"
                    r2 = r1
                    android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0053, all -> 0x0051 }
                    if (r2 == 0) goto L_0x0037
                    boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x0031, all -> 0x002e }
                    if (r3 == 0) goto L_0x0037
                    bmg r0 = bmh.m17984c((android.database.Cursor) r2)     // Catch:{ Exception -> 0x0031, all -> 0x002e }
                    r13.mo25115a(r0)     // Catch:{ Exception -> 0x0031, all -> 0x002e }
                    goto L_0x003a
                L_0x002e:
                    r13 = move-exception
                    r0 = r2
                    goto L_0x007f
                L_0x0031:
                    r0 = move-exception
                    r11 = r2
                    r2 = r0
                    r0 = r1
                    r1 = r11
                    goto L_0x005e
                L_0x0037:
                    r13.mo25115a(r0)     // Catch:{ Exception -> 0x0031, all -> 0x002e }
                L_0x003a:
                    if (r1 == 0) goto L_0x0045
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0045
                    r1.close()
                L_0x0045:
                    if (r2 == 0) goto L_0x0077
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x0077
                    r2.close()
                    goto L_0x0077
                L_0x0051:
                    r13 = move-exception
                    goto L_0x007f
                L_0x0053:
                    r2 = move-exception
                    r11 = r1
                    r1 = r0
                    r0 = r11
                    goto L_0x005e
                L_0x0058:
                    r13 = move-exception
                    r1 = r0
                    goto L_0x007f
                L_0x005b:
                    r1 = move-exception
                    r2 = r1
                    r1 = r0
                L_0x005e:
                    r2.printStackTrace()     // Catch:{ all -> 0x007b }
                    if (r0 == 0) goto L_0x006c
                    boolean r2 = r0.isOpen()
                    if (r2 == 0) goto L_0x006c
                    r0.close()
                L_0x006c:
                    if (r1 == 0) goto L_0x0077
                    boolean r0 = r1.isClosed()
                    if (r0 != 0) goto L_0x0077
                    r1.close()
                L_0x0077:
                    r13.mo23729a()
                    return
                L_0x007b:
                    r13 = move-exception
                    r11 = r1
                    r1 = r0
                    r0 = r11
                L_0x007f:
                    if (r1 == 0) goto L_0x008a
                    boolean r2 = r1.isOpen()
                    if (r2 == 0) goto L_0x008a
                    r1.close()
                L_0x008a:
                    if (r0 == 0) goto L_0x0095
                    boolean r1 = r0.isClosed()
                    if (r1 != 0) goto L_0x0095
                    r0.close()
                L_0x0095:
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C38561.mo21407a(w):void");
            }


            public void mo21407a(C4927w<bmg> wVar) {
                Throwable th;
                SQLiteDatabase sQLiteDatabase;
                Exception e;
                Cursor cursor;
                SQLiteDatabase sQLiteDatabase2 = null;
              //  r0 = null;
                Cursor cursor2 = null;
                try {
                    sQLiteDatabase = bmh.this.getReadableDatabase();
                    try {
                        Cursor query = sQLiteDatabase.query("bookmark", null, "url=?", new String[]{str}, null, null, null, "1");
                        if (query != null) {
                            try {
                                if (query.moveToFirst()) {
                                    wVar.mo25115a(bmh.m17984c(query));
                                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                        sQLiteDatabase.close();
                                    }
                                    if (query != null && !query.isClosed()) {
                                        query.close();
                                    }
                                    wVar.mo23729a();
                                }
                            } catch (Exception e2) {
                                e = e2;
                                sQLiteDatabase2 = sQLiteDatabase;
                                cursor = query;
                                try {
                                    e.printStackTrace();
                                    sQLiteDatabase2.close();
                                    cursor.close();
                                    wVar.mo23729a();
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor2 = cursor;
                                    sQLiteDatabase.close();
                                    cursor2.close();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                cursor2 = query;
                                sQLiteDatabase.close();
                                cursor2.close();
                                throw th;
                            }
                        }
                        wVar.mo25115a((bmg) null);
                        sQLiteDatabase.close();
                        query.close();
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                        sQLiteDatabase2 = sQLiteDatabase;
                        e.printStackTrace();
                        sQLiteDatabase2.close();
                        cursor.close();
                        wVar.mo23729a();
                    } catch (Throwable th4) {
                        th = th4;
                        sQLiteDatabase.close();
                        cursor2.close();
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                    e.printStackTrace();
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    wVar.mo23729a();
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = null;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                  //  throw th;
                }
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: b */
    public C4805t<Boolean> mo23066b(final String str) {
        return C4805t.m21581a(new C4858u<Boolean>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.database.sqlite.SQLiteDatabase} */
            /* JADX WARNING: type inference failed for: r0v0 */
            /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r0v3 */
            /* JADX WARNING: type inference failed for: r0v5 */
            /* JADX WARNING: type inference failed for: r0v7 */
            /* JADX WARNING: type inference failed for: r0v8 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4927w<Boolean> r13) {
                /*
                    r12 = this;
                    r0 = 0
                    bmh r1 = bmh.this     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
                    java.lang.String r3 = "bookmark"
                    r4 = 0
                    java.lang.String r5 = "url=?"
                    r2 = 1
                    java.lang.String[] r6 = new java.lang.String[r2]     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
                    r2 = 0
                    java.lang.String r7 = r2     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
                    r6[r2] = r7     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    java.lang.String r10 = "1"
                    r2 = r1
                    android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
                    boolean r0 = r2.moveToFirst()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                    r13.mo25115a(r0)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                    if (r1 == 0) goto L_0x0034
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0034
                    r1.close()
                L_0x0034:
                    if (r2 == 0) goto L_0x006f
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x006f
                    r2.close()
                    goto L_0x006f
                L_0x0040:
                    r13 = move-exception
                    r0 = r2
                    goto L_0x0077
                L_0x0043:
                    r0 = move-exception
                    r11 = r2
                    r2 = r0
                    r0 = r1
                    r1 = r11
                    goto L_0x0056
                L_0x0049:
                    r13 = move-exception
                    goto L_0x0077
                L_0x004b:
                    r2 = move-exception
                    r11 = r1
                    r1 = r0
                    r0 = r11
                    goto L_0x0056
                L_0x0050:
                    r13 = move-exception
                    r1 = r0
                    goto L_0x0077
                L_0x0053:
                    r1 = move-exception
                    r2 = r1
                    r1 = r0
                L_0x0056:
                    r2.printStackTrace()     // Catch:{ all -> 0x0073 }
                    if (r0 == 0) goto L_0x0064
                    boolean r2 = r0.isOpen()
                    if (r2 == 0) goto L_0x0064
                    r0.close()
                L_0x0064:
                    if (r1 == 0) goto L_0x006f
                    boolean r0 = r1.isClosed()
                    if (r0 != 0) goto L_0x006f
                    r1.close()
                L_0x006f:
                    r13.mo23729a()
                    return
                L_0x0073:
                    r13 = move-exception
                    r11 = r1
                    r1 = r0
                    r0 = r11
                L_0x0077:
                    if (r1 == 0) goto L_0x0082
                    boolean r2 = r1.isOpen()
                    if (r2 == 0) goto L_0x0082
                    r1.close()
                L_0x0082:
                    if (r0 == 0) goto L_0x008d
                    boolean r1 = r0.isClosed()
                    if (r1 != 0) goto L_0x008d
                    r0.close()
                L_0x008d:
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C38646.mo21407a(w):void");
            }
            public void mo21407a(C4927w<Boolean> wVar) {
                Throwable th;
                SQLiteDatabase sQLiteDatabase;
                Exception e;
                Cursor cursor;
                SQLiteDatabase sQLiteDatabase2 = null;
               // r0 = null;
                Cursor cursor2 = null;
                try {
                    sQLiteDatabase = bmh.this.getReadableDatabase();
                    try {
                        Cursor query = sQLiteDatabase.query("bookmark", null, "url=?", new String[]{str}, null, null, null, "1");
                        try {
                            wVar.mo25115a(Boolean.valueOf(query.moveToFirst()));
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            if (query != null && !query.isClosed()) {
                                query.close();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            sQLiteDatabase2 = sQLiteDatabase;
                            cursor = query;
                            try {
                                e.printStackTrace();
                                sQLiteDatabase2.close();
                                cursor.close();
                                wVar.mo23729a();
                            } catch (Throwable th2) {
                                th = th2;
                                sQLiteDatabase = sQLiteDatabase2;
                                cursor2 = cursor;
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
                            cursor2 = query;
                            sQLiteDatabase.close();
                            cursor2.close();
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                        sQLiteDatabase2 = sQLiteDatabase;
                        e.printStackTrace();
                        sQLiteDatabase2.close();
                        cursor.close();
                        wVar. mo23729a();
                    } catch (Throwable th4) {
                        th = th4;
                        sQLiteDatabase.close();
                        cursor2.close();
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                    e.printStackTrace();
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    wVar.mo23729a();
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = null;
                    sQLiteDatabase.close();
                    cursor2.close();
                  //  throw th;
                }
                wVar.mo23729a();
            }

        });
    }

    /* renamed from: a */
    public C4805t<Boolean> mo23062a(final bmg bmg) {
        return C4805t.m21581a(new C4858u<Boolean>() {
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
                if (r2.isClosed() == false) goto L_0x00a1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x009f, code lost:
                if (r2.isClosed() == false) goto L_0x00a1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a1, code lost:
                r2.close();
             */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x009b  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4927w<Boolean> r15) {
                /*
                    r14 = this;
                    r0 = 0
                    bmh r1 = bmh.this     // Catch:{ Exception -> 0x0087, all -> 0x0083 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0087, all -> 0x0083 }
                    java.lang.String r3 = "bookmark"
                    r4 = 0
                    java.lang.String r5 = "url=?"
                    r11 = 1
                    java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ Exception -> 0x007e, all -> 0x007b }
                    bmg r2 = r2     // Catch:{ Exception -> 0x007e, all -> 0x007b }
                    java.lang.String r2 = r2.mo23052e()     // Catch:{ Exception -> 0x007e, all -> 0x007b }
                    r12 = 0
                    r6[r12] = r2     // Catch:{ Exception -> 0x007e, all -> 0x007b }
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    java.lang.String r10 = "1"
                    r2 = r1
                    android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x007e, all -> 0x007b }
                    if (r2 == 0) goto L_0x004d
                    boolean r3 = r2.moveToFirst()     // Catch:{ Exception -> 0x004b }
                    if (r3 == 0) goto L_0x004d
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r12)     // Catch:{ Exception -> 0x004b }
                    r15.mo25115a(r0)     // Catch:{ Exception -> 0x004b }
                    r15.mo23729a()     // Catch:{ Exception -> 0x004b }
                    if (r1 == 0) goto L_0x003f
                    boolean r15 = r1.isOpen()
                    if (r15 == 0) goto L_0x003f
                    r1.close()
                L_0x003f:
                    if (r2 == 0) goto L_0x004a
                    boolean r15 = r2.isClosed()
                    if (r15 != 0) goto L_0x004a
                    r2.close()
                L_0x004a:
                    return
                L_0x004b:
                    r0 = move-exception
                    goto L_0x008b
                L_0x004d:
                    java.lang.String r3 = "bookmark"
                    bmg r4 = r2     // Catch:{ Exception -> 0x004b }
                    android.content.ContentValues r4 = bmh.m17985d((bmg) r4)     // Catch:{ Exception -> 0x004b }
                    long r3 = r1.insert(r3, r0, r4)     // Catch:{ Exception -> 0x004b }
                    r5 = -1
                    int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r0 == 0) goto L_0x0060
                    r12 = 1
                L_0x0060:
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r12)     // Catch:{ Exception -> 0x004b }
                    r15.mo25115a(r0)     // Catch:{ Exception -> 0x004b }
                    if (r1 == 0) goto L_0x0072
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0072
                    r1.close()
                L_0x0072:
                    if (r2 == 0) goto L_0x00a4
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x00a4
                    goto L_0x00a1
                L_0x007b:
                    r15 = move-exception
                    r2 = r0
                    goto L_0x00a9
                L_0x007e:
                    r2 = move-exception
                    r13 = r2
                    r2 = r0
                    r0 = r13
                    goto L_0x008b
                L_0x0083:
                    r15 = move-exception
                    r1 = r0
                    r2 = r1
                    goto L_0x00a9
                L_0x0087:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    r1 = r2
                L_0x008b:
                    r0.printStackTrace()     // Catch:{ all -> 0x00a8 }
                    if (r1 == 0) goto L_0x0099
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0099
                    r1.close()
                L_0x0099:
                    if (r2 == 0) goto L_0x00a4
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x00a4
                L_0x00a1:
                    r2.close()
                L_0x00a4:
                    r15.mo23729a()
                    return
                L_0x00a8:
                    r15 = move-exception
                L_0x00a9:
                    if (r1 == 0) goto L_0x00b4
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x00b4
                    r1.close()
                L_0x00b4:
                    if (r2 == 0) goto L_0x00bf
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x00bf
                    r2.close()
                L_0x00bf:
                    throw r15
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C38657.mo21407a(w):void");
            }
            public void mo21407a(C4927w<Boolean> wVar) {
                Throwable th;
                Cursor cursor;
                SQLiteDatabase sQLiteDatabase;
                Exception e;
                try {
                    sQLiteDatabase = bmh.this.getWritableDatabase();
                    try {
                        boolean z = false;
                        cursor = sQLiteDatabase.query("bookmark", null, "url=?", new String[]{bmg.mo23052e()}, null, null, null, "1");
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    wVar.mo25115a((Boolean) false);
                                    wVar.mo23729a();
                                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                        sQLiteDatabase.close();
                                    }
                                    if (cursor != null && !cursor.isClosed()) {
                                        cursor.close();
                                        return;
                                    }
                                    return;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    e.printStackTrace();
                                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                        sQLiteDatabase.close();
                                    }
                                    if (cursor != null) {
                                    }
                                    wVar.mo23729a();
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabase.close();
                                    cursor.close();
                                    throw th;
                                }
                            }
                        }
                        if (sQLiteDatabase.insert("bookmark", null, bmh.m17985d(bmg)) != -1) {
                            z = true;
                        }
                        wVar.mo25115a(Boolean.valueOf(z));
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (cursor != null) {
                        }
                    } catch (Exception e3) {
                        cursor = null;
                        e = e3;
                        e.printStackTrace();
                        sQLiteDatabase.close();
                        if (cursor != null) {
                        }
                        wVar.mo23729a();
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    cursor = null;
                    e = e4;
                    sQLiteDatabase = null;
                    e.printStackTrace();
                    sQLiteDatabase.close();
                    if (cursor != null) {
                    }
                    wVar.mo23729a();
                } catch (Throwable th4) {
                    th = th4;
                    sQLiteDatabase = null;
                    cursor = null;
                    sQLiteDatabase.close();
                    cursor.close();
                  //  throw th;
                }
                wVar.mo23729a();
            }

        });
    }

    /* renamed from: a */
    public C3659b mo23060a(final List<bmg> list) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                for (bmg a : list) {
                    bmh.this.mo23062a(a).mo23839a();
                }
                eVar.mo23729a();
            }
        });
    }

    /* renamed from: b */
    public C4805t<Boolean> mo23065b(final bmg bmg) {
        return C4805t.m21581a(new C4858u<Boolean>() {
            /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
                if (r1.isOpen() != false) goto L_0x0043;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0041, code lost:
                if (r1.isOpen() != false) goto L_0x0043;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
                r1.close();
             */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4927w<Boolean> r9) {
                /*
                    r8 = this;
                    r0 = 0
                    bmh r1 = bmh.this     // Catch:{ Exception -> 0x0034, all -> 0x0031 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0034, all -> 0x0031 }
                    java.lang.String r0 = "bookmark"
                    java.lang.String r2 = "url=?"
                    r3 = 1
                    java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ Exception -> 0x002f }
                    bmg r5 = r2     // Catch:{ Exception -> 0x002f }
                    java.lang.String r5 = r5.mo23052e()     // Catch:{ Exception -> 0x002f }
                    r6 = 0
                    r4[r6] = r5     // Catch:{ Exception -> 0x002f }
                    int r0 = r1.delete(r0, r2, r4)     // Catch:{ Exception -> 0x002f }
                    if (r0 <= 0) goto L_0x001e
                    goto L_0x001f
                L_0x001e:
                    r3 = 0
                L_0x001f:
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x002f }
                    r9.mo25115a(r0)     // Catch:{ Exception -> 0x002f }
                    if (r1 == 0) goto L_0x0046
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0046
                    goto L_0x0043
                L_0x002f:
                    r0 = move-exception
                    goto L_0x0038
                L_0x0031:
                    r9 = move-exception
                    r1 = r0
                    goto L_0x004b
                L_0x0034:
                    r1 = move-exception
                    r7 = r1
                    r1 = r0
                    r0 = r7
                L_0x0038:
                    r0.printStackTrace()     // Catch:{ all -> 0x004a }
                    if (r1 == 0) goto L_0x0046
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0046
                L_0x0043:
                    r1.close()
                L_0x0046:
                    r9.mo23729a()
                    return
                L_0x004a:
                    r9 = move-exception
                L_0x004b:
                    if (r1 == 0) goto L_0x0056
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0056
                    r1.close()
                L_0x0056:
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C38679.mo21407a(w):void");
            }
            public void mo21407a(C4927w<Boolean> wVar) {
                Throwable th;
                SQLiteDatabase sQLiteDatabase;
                Exception e;
                try {
                    sQLiteDatabase = bmh.this.getWritableDatabase();
                    boolean z = true;
                    try {
                        if (sQLiteDatabase.delete("bookmark", "url=?", new String[]{bmg.mo23052e()}) <= 0) {
                            z = false;
                        }
                        wVar.mo25115a(Boolean.valueOf(z));
                        if (sQLiteDatabase != null) {
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (sQLiteDatabase != null) {
                            }
                            wVar.mo23729a();
                        } catch (Throwable th2) {
                            th = th2;
                            sQLiteDatabase.close();
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    sQLiteDatabase = null;
                    e = e3;
                    e.printStackTrace();
                    if (sQLiteDatabase != null) {
                    }
                    wVar.mo23729a();
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = null;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    //throw th;
                }
                wVar.mo23729a();
            }

        });
    }

    /* renamed from: a */
    public C3659b mo23059a(final String str, final String str2) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
                if (r1.isOpen() != false) goto L_0x003f;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
                r1.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
                if (r1.isOpen() != false) goto L_0x003f;
             */
            /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4165e r9) {
                /*
                    r8 = this;
                    r0 = 0
                    bmh r1 = bmh.this     // Catch:{ Exception -> 0x0030, all -> 0x002d }
                    android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch:{ Exception -> 0x0030, all -> 0x002d }
                    android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ Exception -> 0x002b }
                    r2 = 1
                    r0.<init>(r2)     // Catch:{ Exception -> 0x002b }
                    java.lang.String r3 = "folder"
                    java.lang.String r4 = r3     // Catch:{ Exception -> 0x002b }
                    r0.put(r3, r4)     // Catch:{ Exception -> 0x002b }
                    java.lang.String r3 = "bookmark"
                    java.lang.String r4 = "folder=?"
                    java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x002b }
                    r5 = 0
                    java.lang.String r6 = r2     // Catch:{ Exception -> 0x002b }
                    r2[r5] = r6     // Catch:{ Exception -> 0x002b }
                    r1.update(r3, r0, r4, r2)     // Catch:{ Exception -> 0x002b }
                    if (r1 == 0) goto L_0x0042
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0042
                    goto L_0x003f
                L_0x002b:
                    r0 = move-exception
                    goto L_0x0034
                L_0x002d:
                    r9 = move-exception
                    r1 = r0
                    goto L_0x0047
                L_0x0030:
                    r1 = move-exception
                    r7 = r1
                    r1 = r0
                    r0 = r7
                L_0x0034:
                    r0.printStackTrace()     // Catch:{ all -> 0x0046 }
                    if (r1 == 0) goto L_0x0042
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0042
                L_0x003f:
                    r1.close()
                L_0x0042:
                    r9.mo23729a()
                    return
                L_0x0046:
                    r9 = move-exception
                L_0x0047:
                    if (r1 == 0) goto L_0x0052
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0052
                    r1.close()
                L_0x0052:
                    throw r9
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C385710.mo21407a(e):void");
            }
            public void mo21407a(C4165e eVar) {
                Throwable th;
                SQLiteDatabase sQLiteDatabase;
                Exception e;
                try {
                    sQLiteDatabase = bmh.this.getWritableDatabase();
                    try {
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("folder", str2);
                        sQLiteDatabase.update("bookmark", contentValues, "folder=?", new String[]{str});
                        if (sQLiteDatabase != null) {
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (sQLiteDatabase != null) {
                            }
                            eVar.mo23729a();
                        } catch (Throwable th2) {
                            th = th2;
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    sQLiteDatabase = null;
                    e = e3;
                    e.printStackTrace();
                    if (sQLiteDatabase != null) {
                    }
                    eVar.mo23729a();
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabase = null;
                    sQLiteDatabase.close();
                 //   throw th;
                }
                eVar.mo23729a();
            }
        });
    }

    /* renamed from: c */
    public C3659b mo23067c(final String str) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                bmh.this.mo23059a(str, "").mo23839a();
                eVar.mo23729a();
            }
        });
    }

    /* renamed from: a */
    public C3659b mo23058a(final bmg bmg, final bmg bmg2) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                if (bmg2.mo23054f().isEmpty()) {
                    bmg2.mo23049c(bmh.this.f15646a);
                }
                ContentValues c = bmh.m17985d(bmg2);
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase sQLiteDatabase2 = bmh.this.getWritableDatabase();
                    try {
                        sQLiteDatabase2.update("bookmark", c, "url=?", new String[]{bmg.mo23052e()});
                        if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                            sQLiteDatabase2.close();
                        }
                    } catch (Exception e) {
                        e = e;
                        sQLiteDatabase = sQLiteDatabase2;
                        try {
                            e.printStackTrace();
                            sQLiteDatabase.close();
                            eVar.mo23729a();
                        } catch (Throwable th) {
                            th = th;
                            sQLiteDatabase2 = sQLiteDatabase;
                            if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                                sQLiteDatabase2.close();
                            }
                           // throw th;
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase2.close();
                       // throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    eVar.mo23729a();
                }
                eVar.mo23729a();
            }
        });
    }

    /* renamed from: a */
    public C4805t<List<bmg>> mo23061a() {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
                if (r2.isClosed() == false) goto L_0x0055;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
                if (r2.isClosed() == false) goto L_0x0055;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x0055, code lost:
                r2.close();
             */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x004f  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4927w<List<bmg>> r12) {
                /*
                    r11 = this;
                    r0 = 0
                    bmh r1 = bmh.this     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
                    java.lang.String r3 = "bookmark"
                    r4 = 0
                    r5 = 0
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r2 = r1
                    android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
                    java.util.List r0 = bmh.m17986d((android.database.Cursor) r2)     // Catch:{ Exception -> 0x002f }
                    r12.mo25115a(r0)     // Catch:{ Exception -> 0x002f }
                    if (r1 == 0) goto L_0x0026
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0026
                    r1.close()
                L_0x0026:
                    if (r2 == 0) goto L_0x0058
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x0058
                    goto L_0x0055
                L_0x002f:
                    r0 = move-exception
                    goto L_0x003f
                L_0x0031:
                    r12 = move-exception
                    goto L_0x005e
                L_0x0033:
                    r2 = move-exception
                    r10 = r2
                    r2 = r0
                    r0 = r10
                    goto L_0x003f
                L_0x0038:
                    r12 = move-exception
                    r1 = r0
                    goto L_0x005e
                L_0x003b:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    r1 = r2
                L_0x003f:
                    r0.printStackTrace()     // Catch:{ all -> 0x005c }
                    if (r1 == 0) goto L_0x004d
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x004d
                    r1.close()
                L_0x004d:
                    if (r2 == 0) goto L_0x0058
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x0058
                L_0x0055:
                    r2.close()
                L_0x0058:
                    r12.mo23729a()
                    return
                L_0x005c:
                    r12 = move-exception
                    r0 = r2
                L_0x005e:
                    if (r1 == 0) goto L_0x0069
                    boolean r2 = r1.isOpen()
                    if (r2 == 0) goto L_0x0069
                    r1.close()
                L_0x0069:
                    if (r0 == 0) goto L_0x0074
                    boolean r1 = r0.isClosed()
                    if (r1 != 0) goto L_0x0074
                    r0.close()
                L_0x0074:
                    throw r12
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C38602.mo21407a(w):void");
            }
            public void mo21407a(C4927w<List<bmg>> wVar) {
                Throwable th;
                SQLiteDatabase sQLiteDatabase;
                Cursor cursor;
                Exception e;
                Cursor cursor2 = null;
                try {
                    sQLiteDatabase = bmh.this.getReadableDatabase();
                    try {
                        cursor = sQLiteDatabase.query("bookmark", null, null, null, null, null, null);
                        try {
                            wVar.mo25115a(bmh.m17986d(cursor));
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            if (cursor != null) {
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                    sQLiteDatabase.close();
                                }
                                if (cursor != null) {
                                }
                                wVar.mo23729a();
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = cursor;
                                sQLiteDatabase.close();
                                cursor2.close();
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        cursor = null;
                        e = e3;
                        e.printStackTrace();
                        sQLiteDatabase.close();
                        if (cursor != null) {
                        }
                        wVar.mo23729a();
                    } catch (Throwable th3) {
                        th = th3;
                        sQLiteDatabase.close();
                        cursor2.close();
                        throw th;
                    }
                } catch (Exception e4) {
                    cursor = null;
                    e = e4;
                    sQLiteDatabase = null;
                    e.printStackTrace();
                    sQLiteDatabase.close();
                    if (cursor != null) {
                    }
                    wVar.mo23729a();
                } catch (Throwable th4) {
                    th = th4;
                    sQLiteDatabase = null;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                  //  throw th;
                }
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: d */
    public C4805t<List<bmg>> mo23070d(final String str2) {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: android.database.sqlite.SQLiteDatabase} */
            /* JADX WARNING: type inference failed for: r1v0 */
            /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
            /* JADX WARNING: type inference failed for: r1v3 */
            /* JADX WARNING: type inference failed for: r1v4 */
            /* JADX WARNING: type inference failed for: r1v6 */
            /* JADX WARNING: Multi-variable type inference failed */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4927w<List<bmg>> r13) {
                /*
                    r12 = this;
                    java.lang.String r0 = r2
                    if (r0 == 0) goto L_0x0007
                    java.lang.String r0 = r2
                    goto L_0x0009
                L_0x0007:
                    java.lang.String r0 = ""
                L_0x0009:
                    r1 = 0
                    bmh r2 = bmh.this     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
                    android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
                    java.lang.String r4 = "bookmark"
                    r5 = 0
                    java.lang.String r6 = "folder=?"
                    r3 = 1
                    java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ Exception -> 0x004e, all -> 0x004c }
                    r3 = 0
                    r7[r3] = r0     // Catch:{ Exception -> 0x004e, all -> 0x004c }
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r3 = r2
                    android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004e, all -> 0x004c }
                    java.util.List r1 = bmh.m17986d((android.database.Cursor) r0)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
                    java.util.Collections.sort(r1)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
                    r13.mo25115a(r1)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
                    if (r2 == 0) goto L_0x0038
                    boolean r1 = r2.isOpen()
                    if (r1 == 0) goto L_0x0038
                    r2.close()
                L_0x0038:
                    if (r0 == 0) goto L_0x0071
                    boolean r1 = r0.isClosed()
                    if (r1 != 0) goto L_0x0071
                    r0.close()
                    goto L_0x0071
                L_0x0044:
                    r13 = move-exception
                    r1 = r0
                    goto L_0x0079
                L_0x0047:
                    r1 = move-exception
                    r11 = r2
                    r2 = r0
                    r0 = r1
                    goto L_0x0051
                L_0x004c:
                    r13 = move-exception
                    goto L_0x0079
                L_0x004e:
                    r0 = move-exception
                    r11 = r2
                    r2 = r1
                L_0x0051:
                    r1 = r11
                    goto L_0x0058
                L_0x0053:
                    r13 = move-exception
                    r2 = r1
                    goto L_0x0079
                L_0x0056:
                    r0 = move-exception
                    r2 = r1
                L_0x0058:
                    r0.printStackTrace()     // Catch:{ all -> 0x0075 }
                    if (r1 == 0) goto L_0x0066
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0066
                    r1.close()
                L_0x0066:
                    if (r2 == 0) goto L_0x0071
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x0071
                    r2.close()
                L_0x0071:
                    r13.mo23729a()
                    return
                L_0x0075:
                    r13 = move-exception
                    r11 = r2
                    r2 = r1
                    r1 = r11
                L_0x0079:
                    if (r2 == 0) goto L_0x0084
                    boolean r0 = r2.isOpen()
                    if (r0 == 0) goto L_0x0084
                    r2.close()
                L_0x0084:
                    if (r1 == 0) goto L_0x008f
                    boolean r0 = r1.isClosed()
                    if (r0 != 0) goto L_0x008f
                    r1.close()
                L_0x008f:
                    throw r13
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C38613.mo21407a(w):void");
            }
            public void mo21407a(C4927w<List<bmg>> wVar) {
                Throwable th;
                SQLiteDatabase sQLiteDatabase;
                Cursor cursor;
                Exception e;
                SQLiteDatabase sQLiteDatabase2;
                Cursor query = null;
              //  String str = str != null ? str : "";
                String str =str2;
                if (str == null) {
                    str = "";
                }

                SQLiteDatabase sQLiteDatabase3 = null;
                //r1 = null;
                Cursor cursor2 = null;
                try {
                    sQLiteDatabase = bmh.this.getReadableDatabase();
                    try {
                        query = sQLiteDatabase.query("bookmark", null, "folder=?", new String[]{str}, null, null, null);
                    } catch (Exception e2) {
                        e = e2;
                        sQLiteDatabase2 = sQLiteDatabase;
                        cursor = null;
                        sQLiteDatabase3 = sQLiteDatabase2;
                        try {
                            e.printStackTrace();
                            sQLiteDatabase3.close();
                            cursor.close();
                            wVar.mo23729a();
                        } catch (Throwable th2) {
                            th = th2;
                            sQLiteDatabase = sQLiteDatabase3;
                            cursor2 = cursor;
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
                        sQLiteDatabase.close();
                        cursor2.close();
                        throw th;
                    }
                    try {
                        List<bmg> d = bmh.m17986d(query);
                        Collections.sort(d);
                        wVar.mo25115a(d);
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                    } catch (Exception e3) {
                        sQLiteDatabase2 = sQLiteDatabase;
                        cursor = query;
                        e = e3;
                        sQLiteDatabase3 = sQLiteDatabase2;
                        e.printStackTrace();
                        sQLiteDatabase3.close();
                        cursor.close();
                        wVar.mo23729a();
                    } catch (Throwable th4) {
                        th = th4;
                        cursor2 = query;
                        sQLiteDatabase.close();
                        cursor2.close();
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                    e.printStackTrace();
                    if (sQLiteDatabase3 != null && sQLiteDatabase3.isOpen()) {
                        sQLiteDatabase3.close();
                    }
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    wVar.mo23729a();
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = null;
                    sQLiteDatabase.close();
                    cursor2.close();
                    //throw th;
                }
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: b */
    public C4805t<List<bmg>> mo23064b() {
        return C4805t.m21581a(new C4858u<List<bmg>>() {
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0078, code lost:
                if (r2.isClosed() == false) goto L_0x00a3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a1, code lost:
                if (r2.isClosed() == false) goto L_0x00a3;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a3, code lost:
                r2.close();
             */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x009d  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4927w<List<bmg>> r14) {
                /*
                    r13 = this;
                    r0 = 0
                    bmh r1 = bmh.this     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x0089, all -> 0x0085 }
                    r3 = 1
                    java.lang.String r4 = "bookmark"
                    java.lang.String r2 = "folder"
                    java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0080, all -> 0x007d }
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    r2 = r1
                    android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0080, all -> 0x007d }
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x007b }
                    r0.<init>()     // Catch:{ Exception -> 0x007b }
                L_0x0020:
                    boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x007b }
                    if (r3 == 0) goto L_0x0061
                    java.lang.String r3 = "folder"
                    int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x007b }
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x007b }
                    boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x007b }
                    if (r4 == 0) goto L_0x0037
                    goto L_0x0020
                L_0x0037:
                    bmg r4 = new bmg     // Catch:{ Exception -> 0x007b }
                    r4.<init>()     // Catch:{ Exception -> 0x007b }
                    r5 = 1
                    r4.mo23044a((boolean) r5)     // Catch:{ Exception -> 0x007b }
                    r4.mo23049c(r3)     // Catch:{ Exception -> 0x007b }
                    r5 = 2131230957(0x7f0800ed, float:1.8077981E38)
                    r4.mo23041a((int) r5)     // Catch:{ Exception -> 0x007b }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007b }
                    r5.<init>()     // Catch:{ Exception -> 0x007b }
                    java.lang.String r6 = "folder://"
                    r5.append(r6)     // Catch:{ Exception -> 0x007b }
                    r5.append(r3)     // Catch:{ Exception -> 0x007b }
                    java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x007b }
                    r4.mo23047b((java.lang.String) r3)     // Catch:{ Exception -> 0x007b }
                    r0.add(r4)     // Catch:{ Exception -> 0x007b }
                    goto L_0x0020
                L_0x0061:
                    java.util.Collections.sort(r0)     // Catch:{ Exception -> 0x007b }
                    r14.mo25115a(r0)     // Catch:{ Exception -> 0x007b }
                    if (r1 == 0) goto L_0x0072
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0072
                    r1.close()
                L_0x0072:
                    if (r2 == 0) goto L_0x00a6
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x00a6
                    goto L_0x00a3
                L_0x007b:
                    r0 = move-exception
                    goto L_0x008d
                L_0x007d:
                    r14 = move-exception
                    r2 = r0
                    goto L_0x00ab
                L_0x0080:
                    r2 = move-exception
                    r12 = r2
                    r2 = r0
                    r0 = r12
                    goto L_0x008d
                L_0x0085:
                    r14 = move-exception
                    r1 = r0
                    r2 = r1
                    goto L_0x00ab
                L_0x0089:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    r1 = r2
                L_0x008d:
                    r0.printStackTrace()     // Catch:{ all -> 0x00aa }
                    if (r1 == 0) goto L_0x009b
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x009b
                    r1.close()
                L_0x009b:
                    if (r2 == 0) goto L_0x00a6
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x00a6
                L_0x00a3:
                    r2.close()
                L_0x00a6:
                    r14.mo23729a()
                    return
                L_0x00aa:
                    r14 = move-exception
                L_0x00ab:
                    if (r1 == 0) goto L_0x00b6
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x00b6
                    r1.close()
                L_0x00b6:
                    if (r2 == 0) goto L_0x00c1
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x00c1
                    r2.close()
                L_0x00c1:
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C38624.mo21407a(w):void");
            }
            public void mo21407a(C4927w<List<bmg>> wVar) {
                Throwable th;
                Cursor cursor;
                SQLiteDatabase sQLiteDatabase;
                Exception e;
                try {
                    sQLiteDatabase = bmh.this.getReadableDatabase();
                    try {
                        cursor = sQLiteDatabase.query(true, "bookmark", new String[]{"folder"}, null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                        e = e2;
                        try {
                            e.printStackTrace();
                            sQLiteDatabase.close();
                            if (cursor != null) {
                            }
                            wVar.mo23729a();
                        } catch (Throwable th2) {
                            th = th2;
                            sQLiteDatabase.close();
                            cursor.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        throw th;
                    }
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("folder"));
                            if (!TextUtils.isEmpty(string)) {
                                bmg bmg = new bmg();
                                bmg.mo23044a(true);
                                bmg.mo23049c(string);
                                bmg.mo23041a(R.drawable.ic_downloader_folder);
                                bmg.mo23047b("folder://" + string);
                                arrayList.add(bmg);
                            }
                        }
                        Collections.sort(arrayList);
                        wVar.mo25115a(arrayList);
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (cursor != null) {
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (cursor != null) {
                        }
                        wVar.mo23729a();
                    }
                } catch (Exception e4) {
                    cursor = null;
                    e = e4;
                    sQLiteDatabase = null;
                    e.printStackTrace();
                    sQLiteDatabase.close();
                    if (cursor != null) {
                    }
                    wVar.mo23729a();
                } catch (Throwable th4) {
                    th = th4;
                    sQLiteDatabase = null;
                    cursor = null;
                    sQLiteDatabase.close();
                    cursor.close();
                  //  throw th;
                }
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: c */
    public C4805t<List<String>> mo23068c() {
        return C4805t.m21581a(new C4858u<List<String>>() {
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
                if (r2.isClosed() == false) goto L_0x007a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
                if (r2.isClosed() == false) goto L_0x007a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x007a, code lost:
                r2.close();
             */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0074  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void mo21407aa(C4927w<List<String>> r14) {
                /*
                    r13 = this;
                    r0 = 0
                    bmh r1 = bmh.this     // Catch:{ Exception -> 0x0060, all -> 0x005c }
                    android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch:{ Exception -> 0x0060, all -> 0x005c }
                    r3 = 1
                    java.lang.String r4 = "bookmark"
                    java.lang.String r2 = "folder"
                    java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
                    r6 = 0
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    r2 = r1
                    android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
                    java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0052 }
                    r0.<init>()     // Catch:{ Exception -> 0x0052 }
                L_0x0020:
                    boolean r3 = r2.moveToNext()     // Catch:{ Exception -> 0x0052 }
                    if (r3 == 0) goto L_0x003b
                    java.lang.String r3 = "folder"
                    int r3 = r2.getColumnIndex(r3)     // Catch:{ Exception -> 0x0052 }
                    java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0052 }
                    boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0052 }
                    if (r4 == 0) goto L_0x0037
                    goto L_0x0020
                L_0x0037:
                    r0.add(r3)     // Catch:{ Exception -> 0x0052 }
                    goto L_0x0020
                L_0x003b:
                    r14.mo25115a(r0)     // Catch:{ Exception -> 0x0052 }
                    if (r1 == 0) goto L_0x0049
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0049
                    r1.close()
                L_0x0049:
                    if (r2 == 0) goto L_0x007d
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x007d
                    goto L_0x007a
                L_0x0052:
                    r0 = move-exception
                    goto L_0x0064
                L_0x0054:
                    r14 = move-exception
                    r2 = r0
                    goto L_0x0082
                L_0x0057:
                    r2 = move-exception
                    r12 = r2
                    r2 = r0
                    r0 = r12
                    goto L_0x0064
                L_0x005c:
                    r14 = move-exception
                    r1 = r0
                    r2 = r1
                    goto L_0x0082
                L_0x0060:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    r1 = r2
                L_0x0064:
                    r0.printStackTrace()     // Catch:{ all -> 0x0081 }
                    if (r1 == 0) goto L_0x0072
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x0072
                    r1.close()
                L_0x0072:
                    if (r2 == 0) goto L_0x007d
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x007d
                L_0x007a:
                    r2.close()
                L_0x007d:
                    r14.mo23729a()
                    return
                L_0x0081:
                    r14 = move-exception
                L_0x0082:
                    if (r1 == 0) goto L_0x008d
                    boolean r0 = r1.isOpen()
                    if (r0 == 0) goto L_0x008d
                    r1.close()
                L_0x008d:
                    if (r2 == 0) goto L_0x0098
                    boolean r0 = r2.isClosed()
                    if (r0 != 0) goto L_0x0098
                    r2.close()
                L_0x0098:
                    throw r14
                */
                throw new UnsupportedOperationException("Method not decompiled: bmh.C38635.mo21407a(w):void");
            }
            public void mo21407a(C4927w<List<String>> wVar) {
                Throwable th;
                Cursor cursor;
                SQLiteDatabase sQLiteDatabase;
                Exception e;
                try {
                    sQLiteDatabase = bmh.this.getReadableDatabase();
                    try {
                        cursor = sQLiteDatabase.query(true, "bookmark", new String[]{"folder"}, null, null, null, null, null, null);
                    } catch (Exception e2) {
                        cursor = null;
                        e = e2;
                        try {
                            e.printStackTrace();
                            sQLiteDatabase.close();
                            if (cursor != null) {
                            }
                            wVar.mo23729a();
                        } catch (Throwable th2) {
                            th = th2;
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        sQLiteDatabase.close();
                        cursor.close();
                        throw th;
                    }
                    try {
                        ArrayList arrayList = new ArrayList();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("folder"));
                            if (!TextUtils.isEmpty(string)) {
                                arrayList.add(string);
                            }
                        }
                        wVar.mo25115a(arrayList);
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (cursor != null) {
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                            sQLiteDatabase.close();
                        }
                        if (cursor != null) {
                        }
                        wVar.mo23729a();
                    }
                } catch (Exception e4) {
                    cursor = null;
                    e = e4;
                    sQLiteDatabase = null;
                    e.printStackTrace();
                    sQLiteDatabase.close();
                    if (cursor != null) {
                    }
                    wVar.mo23729a();
                } catch (Throwable th4) {
                    th = th4;
                    sQLiteDatabase = null;
                    cursor = null;
                    sQLiteDatabase.close();
                    cursor.close();
                  //  throw th;
                }
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: d */
    public long mo23069d() {
        SQLiteDatabase sQLiteDatabase;
        Exception e;
        try {
            sQLiteDatabase = getReadableDatabase();
            try {
                long queryNumEntries = DatabaseUtils.queryNumEntries(sQLiteDatabase, "bookmark");
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    return queryNumEntries;
                }
                sQLiteDatabase.close();
                return queryNumEntries;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    sQLiteDatabase.close();
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabase.close();
                    throw th;
                }
            }
        } catch (Exception e3) {
            Exception exc = e3;
            sQLiteDatabase = null;
            e = exc;
            e.printStackTrace();
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
            return 0;
        } catch (Throwable th) {
            Throwable th3 = th;
            sQLiteDatabase = null;
            th = th;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                sQLiteDatabase.close();
            }
           // throw th;
        }
        return 0;
    }
}
