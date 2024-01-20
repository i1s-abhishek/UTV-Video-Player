package classesdef.xdplayer;

import android.content.ContentUris;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriPermission;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;

import androidx.documentfile.provider.DocumentFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: awx */
public class awx {
    /* renamed from: a */
    private static void m7219a(Context context, String[] strArr) {
        MediaScannerConnection.scanFile(context, strArr, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r5 = r5.createFile(r8, r6.getName());
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0079 A[SYNTHETIC, Splitter:B:40:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007e A[SYNTHETIC, Splitter:B:44:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0085 A[SYNTHETIC, Splitter:B:52:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x008a A[SYNTHETIC, Splitter:B:56:0x008a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m7221aa(Context r4, File r5, File r6, int r7, String r8) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0082, all -> 0x0075 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0082, all -> 0x0075 }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            r3 = 21
            if (r5 < r3) goto L_0x003a
            java.io.File r5 = r6.getParentFile()     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            android.support.v4.provider.DocumentFile r5 = m7214a((android.content.Context) r4, (java.io.File) r5, (boolean) r1, (boolean) r1)     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            if (r5 == 0) goto L_0x0038
            java.lang.String r3 = r6.getName()     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            android.support.v4.provider.DocumentFile r3 = m7215a((android.support.p001v4.provider.DocumentFile) r5, (java.lang.String) r3)     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            if (r3 != 0) goto L_0x0038
            java.lang.String r3 = r6.getName()     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            android.support.v4.provider.DocumentFile r5 = r5.createFile(r8, r3)     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            if (r5 == 0) goto L_0x0038
            android.content.ContentResolver r8 = r4.getContentResolver()     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            android.net.Uri r5 = r5.getUri()     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            java.io.OutputStream r5 = r8.openOutputStream(r5)     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            goto L_0x003f
        L_0x0038:
            r5 = r0
            goto L_0x003f
        L_0x003a:
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
        L_0x003f:
            r0 = r5
            r5 = 1
            if (r0 == 0) goto L_0x005a
            if (r7 <= 0) goto L_0x0049
            long r7 = (long) r7     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            r2.skip(r7)     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
        L_0x0049:
            r7 = 8192(0x2000, float:1.14794E-41)
            byte[] r7 = new byte[r7]     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
        L_0x004d:
            int r8 = r2.read(r7)     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            r3 = -1
            if (r8 == r3) goto L_0x0058
            r0.write(r7, r1, r8)     // Catch:{ Exception -> 0x0083, all -> 0x0073 }
            goto L_0x004d
        L_0x0058:
            r7 = 1
            goto L_0x005b
        L_0x005a:
            r7 = 0
        L_0x005b:
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x0060 }
        L_0x0060:
            if (r0 == 0) goto L_0x0065
            r0.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0065:
            if (r7 == 0) goto L_0x0072
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.String r6 = r6.getPath()
            r5[r1] = r6
            m7219a((android.content.Context) r4, (java.lang.String[]) r5)
        L_0x0072:
            return r7
        L_0x0073:
            r4 = move-exception
            goto L_0x0077
        L_0x0075:
            r4 = move-exception
            r2 = r0
        L_0x0077:
            if (r2 == 0) goto L_0x007c
            r2.close()     // Catch:{ IOException -> 0x007c }
        L_0x007c:
            if (r0 == 0) goto L_0x0081
            r0.close()     // Catch:{ IOException -> 0x0081 }
        L_0x0081:
            throw r4
        L_0x0082:
            r2 = r0
        L_0x0083:
            if (r2 == 0) goto L_0x0088
            r2.close()     // Catch:{ IOException -> 0x0088 }
        L_0x0088:
            if (r0 == 0) goto L_0x008d
            r0.close()     // Catch:{ IOException -> 0x008d }
        L_0x008d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.awx.m7221a(android.content.Context, java.io.File, java.io.File, int, java.lang.String):boolean");
    }
    public static boolean m7221a(Context context, File file, File file2, int i, String str) {
        FileInputStream fileInputStream;
        Throwable th;
        OutputStream outputStream;
        boolean z = false;
        DocumentFile createFile;
        OutputStream outputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    DocumentFile a = m7214a(context, file2.getParentFile(), false, false);
                    outputStream = (a == null || m7215a(a, file2.getName()) != null || (createFile = a.createFile(str, file2.getName())) == null) ? null : context.getContentResolver().openOutputStream(createFile.getUri());
                } else {
                    outputStream = new FileOutputStream(file2);
                }
                if (outputStream != null) {
                    if (i > 0) {
                        fileInputStream.skip((long) i);
                    }
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        outputStream.write(bArr, 0, read);
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                if (z) {
                    m7219a(context, new String[]{file2.getPath()});
                }
                return z;
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                if (0 != 0) {
                    try {
                        outputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (0 != 0) {
                    try {
                        outputStream2.close();
                    } catch (IOException unused7) {
                    }
                }
                throw th;
            }
        } catch (Exception unused8) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            if (0 != 0) {
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            if (0 != 0) {
            }
            //throw th;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m7220a(Context context, File file) {
        boolean delete = file.delete();
        if (!delete) {
            delete = !file.exists();
        }
        if (delete || Build.VERSION.SDK_INT < 21) {
            return delete;
        }
        DocumentFile a = m7214a(context, file, false, false);
        if (a != null) {
            try {
                if (a.delete()) {
                    return true;
                }
            } catch (SecurityException unused) {
                return delete;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7222a(Context context, File file, String str) {
        DocumentFile a;
        if (Build.VERSION.SDK_INT < 21 || (a = m7214a(context, file, false, false)) == null) {
            return false;
        }
        try {
            if (a.renameTo(str)) {
                return true;
            }
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static HashSet<File> m7217a(Context context) {
        HashSet<File> hashSet = new HashSet<>();
        for (File file : context.getExternalFilesDirs("external")) {
            if (file != null) {
                int lastIndexOf = file.getAbsolutePath().lastIndexOf("/Android/data");
                if (lastIndexOf < 0) {
                    Log.w("asd", "Unexpected external file dir: " + file.getAbsolutePath());
                } else {
                    hashSet.add(new File(file.getAbsolutePath().substring(0, lastIndexOf)));
                }
            }
        }
        return hashSet;
    }

    /* renamed from: b */
    public static String m7224b(Context context) {
        for (File file : context.getExternalFilesDirs("external")) {
            if (file != null && !file.equals(context.getExternalFilesDir("external"))) {
                int lastIndexOf = file.getAbsolutePath().lastIndexOf("/Android/data");
                if (lastIndexOf >= 0) {
                    return new File(file.getAbsolutePath().substring(0, lastIndexOf)).getPath();
                }
                Log.w("asd", "Unexpected external file dir: " + file.getAbsolutePath());
            }
        }
        return null;
    }

    /* renamed from: a */
    private static DocumentFile m7214a(Context context, File file, boolean z, boolean z2) {
        String str;
        Uri c = m7227c(context);
        if (c == null) {
            return null;
        }
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(context, c);
        String d = m7229d(context);
        if (d != null) {
            str = file.getPath().indexOf(d) != -1 ? file.getAbsolutePath().substring(d.length()) : null;
        } else {
            Iterator<File> it = m7217a(context).iterator();
            String str2 = null;
            while (it.hasNext()) {
                File next = it.next();
                if (!(next == null || file.getPath().indexOf(next.getPath()) == -1)) {
                    str2 = file.getAbsolutePath().substring(file.getPath().length());
                }
            }
            str = str2;
        }
        if (str == null) {
            Log.d("ContentHelper", "unable to find the document file, filePath:" + file.getPath() + " root: " + d);
            return null;
        }
        if (str.startsWith(File.separator)) {
            str = str.substring(1);
        }
        String[] split = str.split("/");
        for (int i = 0; i < split.length; i++) {
            DocumentFile a = m7215a(fromTreeUri, split[i]);
            if (a != null) {
                fromTreeUri = a;
            } else if (i < split.length - 1) {
                if (!z2) {
                    return null;
                }
                fromTreeUri = fromTreeUri.createDirectory(split[i]);
            } else if (z) {
                fromTreeUri = fromTreeUri.createDirectory(split[i]);
            } else if (!z2) {
                return null;
            } else {
                try {
                    return fromTreeUri.createFile("image", split[i]);
                } catch (Exception unused) {
                }
            }
        }
        return fromTreeUri;
    }

    /* renamed from: a */
    private static DocumentFile m7215a(DocumentFile documentFile, String str) {
        if (str == null || documentFile == null) {
            return null;
        }
        DocumentFile findFile = documentFile.findFile(str);
        if (findFile != null) {
            return findFile;
        }
        DocumentFile[] listFiles = documentFile.listFiles();
        if (listFiles != null) {
            for (DocumentFile documentFile2 : listFiles) {
                if (documentFile2 != null && str.equalsIgnoreCase(documentFile2.getName())) {
                    return documentFile2;
                }
            }
        }
        return null;
    }

    /* renamed from: c */
    private static Uri m7227c(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("sdTreeUri", (String) null);
        if (string != null) {
            return Uri.parse(string);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
            if (!persistedUriPermissions.isEmpty()) {
                return persistedUriPermissions.get(0).getUri();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m7218a(Context context, Uri uri) {
        String str;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        edit.putString("sdTreeUri", str);
        edit.putString("sdCardPath", m7224b(context));
        edit.apply();
    }

    /* renamed from: d */
    private static String m7229d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("sdCardPath", (String) null);
    }

    /* renamed from: b */
    public static String m7225b(Context context, Uri uri) {
        int i = 0;
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (m7223a(uri)) {
                String[] split = DocumentsContract.getDocumentId(uri).split(":");
                if ("primary".equalsIgnoreCase(split[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (m7226b(uri)) {
                return m7216a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
            } else if (m7228c(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return m7216a(context, uri2, "_id=?", new String[]{split2[1]});
            }
        } else if ("downloads".equals(uri.getAuthority())) {
            String[] split3 = uri.toString().split("/");
            return m7216a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(split3[split3.length - 1]).longValue()), (String) null, (String[]) null);
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            try {
                String a = m7216a(context, uri, (String) null, (String[]) null);
                if (a != null) {
                    return a;
                }
            } catch (Exception unused) {
            }
            String[] split4 = uri.getPath().split("/");
            int length = split4.length;
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (split4[i].equals("external_files")) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                StringBuilder sb = new StringBuilder();
                for (int i2 = i + 1; i2 < length; i2++) {
                    sb.append(split4[i2]);
                    sb.append('/');
                }
                String sb2 = sb.toString();
                Iterator<File> it = m7217a(context).iterator();
                while (it.hasNext()) {
                    File file = new File(it.next(), sb2);
                    if (file.exists()) {
                        return file.getPath();
                    }
                }
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String m7216aa(Context r7, Uri r8, String r9, String[] r10) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r0 = 0
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ all -> 0x0033 }
            r6 = 0
            r2 = r8
            r4 = r9
            r5 = r10
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0033 }
            if (r7 == 0) goto L_0x002d
            boolean r8 = r7.moveToFirst()     // Catch:{ all -> 0x002b }
            if (r8 == 0) goto L_0x002d
            java.lang.String r8 = "_data"
            int r8 = r7.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x002b }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ all -> 0x002b }
            if (r7 == 0) goto L_0x002a
            r7.close()
        L_0x002a:
            return r8
        L_0x002b:
            r8 = move-exception
            goto L_0x0035
        L_0x002d:
            if (r7 == 0) goto L_0x0032
            r7.close()
        L_0x0032:
            return r0
        L_0x0033:
            r8 = move-exception
            r7 = r0
        L_0x0035:
            if (r7 == 0) goto L_0x003a
            r7.close()
        L_0x003a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.awx.m7216a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }
    private static String m7216a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
        //    throw th;
        }
        return str;
    }

    /* renamed from: a */
    private static boolean m7223a(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /* renamed from: b */
    private static boolean m7226b(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /* renamed from: c */
    private static boolean m7228c(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
}
