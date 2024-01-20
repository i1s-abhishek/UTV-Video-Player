package classesdef.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: bnl  reason: default package */
public class bnl extends SQLiteOpenHelper {
    private String a = "CREATE TABLE record_info (_id INTEGER PRIMARY KEY AUTOINCREMENT,download_link TEXT,father_link TEXT,time INTEGER,file_name TEXT,file_type INTEGER,download_state INTEGER,other TEXT,temp1 TEXT,temp2 TEXT,temp3 TEXT,int1 INTEGER,int2 INTEGER,int3 INTEGER)";

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public bnl(Context context) {
        super(context, "video_downloader_db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.a);
    }
}
