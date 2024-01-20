package com.abhishek.xplayer;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Base64;

import com.abhishek.xplayer.application.MyApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ShareProvider extends ContentProvider {

    /* renamed from: a */
    private static final String[] f10205a = {"_display_name", "_size"};

    /* renamed from: b */
    private static Map<String, String> f10206b = new HashMap();

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i = 0;
        File a = m11568a(uri);
        if (strArr == null) {
            strArr = f10205a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(a.length());
            } else if ("_data".equalsIgnoreCase(str3)) {
                strArr3[i2] = "_data";
                i = i2 + 1;
                objArr[i2] = a.getAbsolutePath();
            }
            i2 = i;
        }
        String[] a2 = m11570a(strArr3, i2);
        Object[] a3 = m11569a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(a2, 1);
        matrixCursor.addRow(a3);
        return matrixCursor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r3 = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(r3.getName().substring(r0 + 1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String getType(Uri r3) {
        /*
            r2 = this;
            java.io.File r3 = m11568a((android.net.Uri) r3)
            java.lang.String r0 = r3.getName()
            r1 = 46
            int r0 = r0.lastIndexOf(r1)
            if (r0 < 0) goto L_0x0025
            java.lang.String r3 = r3.getName()
            int r0 = r0 + 1
            java.lang.String r3 = r3.substring(r0)
            android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r3 = r0.getMimeTypeFromExtension(r3)
            if (r3 == 0) goto L_0x0025
            return r3
        L_0x0025:
            java.lang.String r3 = "application/octet-stream"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.xplayer.ShareProvider.getType(android.net.Uri):java.lang.String");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return m11568a(uri).delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str)throws FileNotFoundException {
        return ParcelFileDescriptor.open(m11568a(uri), m11566a(str));
    }

    /* renamed from: a */
    private static int m11566a(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* renamed from: a */
    private static String[] m11570a(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: a */
    private static Object[] m11569a(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    /* renamed from: b */
    private static Uri m11571b(File file) {
        if (file == null) {
            return null;
        }
        String str = new String(Base64.encode(file.getAbsolutePath().getBytes(), 11));
        Uri.Builder scheme = new Uri.Builder().scheme("content");
        return scheme.authority(MyApplication.getApplicationContext_().getPackageName() + ".share").encodedPath(str).build();
    }

    /* renamed from: a */
    private static File m11568a(Uri uri) {
        String path;
        if (uri == null || (path = uri.getPath()) == null) {
            return null;
        }
        String str = f10206b.get(path);
        if (str == null) {
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            str = new String(Base64.decode(path, 11));
        }
        return new File(str);
    }

    /* renamed from: c */
    private static Uri m11572c(File file) {
        Uri b = m11571b(file);
        if (b != null) {
            f10206b.put(b.getPath(), file.getAbsolutePath());
        }
        return b;
    }

    /* renamed from: a */
    public static Uri m11567a(File file) {
        if (Build.VERSION.SDK_INT >= 23) {
            return m11572c(file);
        }
        return Uri.fromFile(file);
    }
}
