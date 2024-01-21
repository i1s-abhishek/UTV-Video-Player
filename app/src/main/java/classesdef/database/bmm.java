package classesdef.database;

import android.app.Application;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mopub.mobileads.VastExtensionXmlManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import classesdef.browser.bml;
import classesdef.browser.download.bmn;
import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4927w;
import hdplayer.xdplayer.videoplayer.R;


@Singleton
/* renamed from: bmm */
public class bmm extends SQLiteOpenHelper implements bmn {

    /* renamed from: a */
    private final String f15673a;

    /* renamed from: b */
    private SQLiteDatabase f15674b;

    @Inject
    public bmm(Application application) {
        super(application, "downloadManager", (SQLiteDatabase.CursorFactory) null, 1);
        this.f15673a = application.getString(R.string.untitled);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public SQLiteDatabase m18049c() {
        if (this.f15674b == null || !this.f15674b.isOpen()) {
            this.f15674b = getWritableDatabase();
        }
        return this.f15674b;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + DatabaseUtils.sqlEscapeString("download") + '(' + DatabaseUtils.sqlEscapeString(VastExtensionXmlManager.ID) + " INTEGER PRIMARY KEY," + DatabaseUtils.sqlEscapeString("url") + " TEXT," + DatabaseUtils.sqlEscapeString("title") + " TEXT," + DatabaseUtils.sqlEscapeString("size") + " TEXT" + ')');
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseUtils.sqlEscapeString("download"));
        onCreate(sQLiteDatabase);
    }

    /* renamed from: b */
    private static bml m18048b(Cursor cursor) {
        bml bml = new bml();
        bml.mo23087a(cursor.getString(cursor.getColumnIndex("url")));
        bml.mo23089b(cursor.getString(cursor.getColumnIndex("title")));
        bml.mo23091c(cursor.getString(cursor.getColumnIndex("size")));
        return bml;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static List<bml> m18050c(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(m18048b(cursor));
        }
        cursor.close();
        return arrayList;
    }

    /* renamed from: a */
    public C3659b mo23096a() {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                bmm.this.m18049c().delete("download", (String) null, (String[]) null);
                eVar.mo23729a();
            }
        });
    }

    /* renamed from: b */
    public C4805t<List<bml>> mo23097b() {
        return C4805t.m21581a(new C4858u<List<bml>>() {
            /* renamed from: a */
            public void mo21407a(C4927w<List<bml>> wVar) {
                wVar.mo25115a(bmm.m18050c(bmm.this.m18049c().query("download", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null)));
                wVar.mo23729a();
            }
        });
    }
}
