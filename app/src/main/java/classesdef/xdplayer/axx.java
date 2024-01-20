package classesdef.xdplayer;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import classesdef.inplayer.axi;

public class axx {

    public static String m7454a(Context context, Uri uri) {
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                String b = awx.m7225b(context, uri);
                if (b != null) {
                    return b;
                }
            } catch (Exception unused) {
            }
        }
        String[] a = m7457a(context, uri, false);
        if (a == null || !"1".equals(a[0])) {
            return null;
        }
        return a[1];
    }

    /* renamed from: a */
    private static String[] m7457a(Context context, Uri uri, boolean z) {
        String a;
        String str = null;
        try {
            if (uri.getAuthority() != null) {
                if ("com.google.android.apps.docs.storage".equals(uri.getAuthority())) {
                    return new String[]{"-1", null};
                }
                if ("com.google.android.apps.docs.files".equals(uri.getAuthority())) {
                    return new String[]{"-1", null};
                }
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    return new String[]{"-1", null};
                }
                if ("com.google.android.apps.docs.storage.legacy".equals(uri.getAuthority())) {
                    return new String[]{"-1", null};
                }
            }
            if (uri.toString().startsWith("file:///")) {
                a = Uri.decode(uri.getEncodedPath());
            } else if (Build.VERSION.SDK_INT < 19 || !axz.m7474a(context, uri)) {
                if ("com.google.android.apps.photos.contentprovider".equals(uri.getAuthority())) {
                    try {
                        String decode = Uri.decode(uri.toString());
                        int indexOf = decode.indexOf("content://media/");
                        if (indexOf < 0) {
                            return new String[]{"-2", null};
                        }
                        Matcher matcher = Pattern.compile("media/\\d+").matcher(decode);
                        int end = matcher.find() ? matcher.end() : 0;
                        if (end == 0) {
                            return new String[]{"-2", null};
                        }
                        a = m7455a(context, Uri.parse(decode.substring(indexOf, end)), (String) null, (String[]) null, z);
                    } catch (Exception unused) {
                        return new String[]{"-2", null};
                    }
                } else {
                    a = m7455a(context, uri, (String) null, (String[]) null, z);
                }
            } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String str2 = axz.m7473a(uri).split(":")[1];
                a = z ? m7455a(context, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{str2}, z) : m7455a(context, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_id=?", new String[]{str2}, z);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                a = m7455a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(axz.m7473a(uri)).longValue()), (String) null, (String[]) null, z);
            } else if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] split = axz.m7473a(uri).split(":");
                String str3 = split[0];
                String str4 = split[1];
                if (!"primary".equalsIgnoreCase(str3)) {
                    File[] listFiles = new File("/storage").listFiles();
                    if (listFiles != null) {
                        int i = 0;
                        while (true) {
                            if (i >= listFiles.length) {
                                a = null;
                                break;
                            } else if (new File(listFiles[i].getAbsolutePath(), str4).exists()) {
                                a = listFiles[i].getAbsolutePath() + "/" + str4;
                                break;
                            } else {
                                i++;
                            }
                        }
                    } else {
                        return new String[]{"-2", null};
                    }
                } else {
                    a = Environment.getExternalStorageDirectory() + "/" + str4;
                }
            } else {
                try {
                    a = axz.m7473a(uri);
                } catch (Exception unused2) {
                    return new String[]{"-1", null};
                }
            }
            str = a;
            if (str != null) {
                if (new File(str).exists()) {
                    if (z) {
                        if (str.substring(str.lastIndexOf("/") + 1) != null) {
                            String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase(Locale.ENGLISH);
                            if (!lowerCase.equals("mp3") && !lowerCase.equals("m4a") && !lowerCase.equals("amr") && !lowerCase.equals("aac") && !lowerCase.equals("ogg") && !lowerCase.equals("flac") && !lowerCase.equals("3gpp") && !lowerCase.equals("3ga")) {
                                if (!lowerCase.equals("wav")) {
                                    return new String[]{"-3", str};
                                }
                            }
                        } else {
                            return new String[]{"-3", str};
                        }
                    } else if (!m7456a(str.toLowerCase(Locale.ENGLISH))) {
                        return new String[]{"-3", str};
                    }
                    return new String[]{"1", str};
                }
            }
            return new String[]{"-2", str};
        } catch (Exception unused3) {
            return new String[]{"-1", str};
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a3 A[SYNTHETIC, Splitter:B:20:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d8 A[SYNTHETIC, Splitter:B:36:0x00d8] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String m7455a_(Context r7, Uri r8, String r9, String[] r10, boolean r11) {
        /*
            r0 = 0
            if (r11 == 0) goto L_0x00ac
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ Exception -> 0x009c }
            java.lang.String r7 = "_data"
            java.lang.String r11 = "title"
            java.lang.String r2 = "artist"
            java.lang.String[] r3 = new java.lang.String[]{r7, r11, r2}     // Catch:{ Exception -> 0x009c }
            r6 = 0
            r2 = r8
            r4 = r9
            r5 = r10
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x009c }
            if (r7 == 0) goto L_0x00a1
            r7.moveToFirst()     // Catch:{ Exception -> 0x009a }
            java.lang.String r8 = "_data"
            int r8 = r7.getColumnIndex(r8)     // Catch:{ Exception -> 0x009a }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x009a }
            java.lang.String r9 = "title"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ Exception -> 0x009a }
            java.lang.String r9 = r7.getString(r9)     // Catch:{ Exception -> 0x009a }
            java.lang.String r10 = "artist"
            int r10 = r7.getColumnIndex(r10)     // Catch:{ Exception -> 0x009a }
            java.lang.String r10 = r7.getString(r10)     // Catch:{ Exception -> 0x009a }
            if (r9 == 0) goto L_0x0071
            if (r10 == 0) goto L_0x0071
            java.lang.String r11 = "Music: "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a }
            r1.<init>()     // Catch:{ Exception -> 0x009a }
            r1.append(r11)     // Catch:{ Exception -> 0x009a }
            r1.append(r9)     // Catch:{ Exception -> 0x009a }
            java.lang.String r9 = r1.toString()     // Catch:{ Exception -> 0x009a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a }
            r11.<init>()     // Catch:{ Exception -> 0x009a }
            r11.append(r9)     // Catch:{ Exception -> 0x009a }
            java.lang.String r9 = " - "
            r11.append(r9)     // Catch:{ Exception -> 0x009a }
            java.lang.String r9 = r11.toString()     // Catch:{ Exception -> 0x009a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a }
            r11.<init>()     // Catch:{ Exception -> 0x009a }
            r11.append(r9)     // Catch:{ Exception -> 0x009a }
            r11.append(r10)     // Catch:{ Exception -> 0x009a }
            r11.toString()     // Catch:{ Exception -> 0x009a }
            goto L_0x0098
        L_0x0071:
            java.lang.String r9 = "/"
            int r9 = r8.lastIndexOf(r9)     // Catch:{ Exception -> 0x009a }
            java.lang.String r10 = "."
            int r10 = r8.lastIndexOf(r10)     // Catch:{ Exception -> 0x009a }
            r11 = -1
            if (r9 == r11) goto L_0x0098
            if (r10 == r11) goto L_0x0098
            java.lang.String r11 = "Music: "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009a }
            r1.<init>()     // Catch:{ Exception -> 0x009a }
            r1.append(r11)     // Catch:{ Exception -> 0x009a }
            int r9 = r9 + 1
            java.lang.String r9 = r8.substring(r9, r10)     // Catch:{ Exception -> 0x009a }
            r1.append(r9)     // Catch:{ Exception -> 0x009a }
            r1.toString()     // Catch:{ Exception -> 0x009a }
        L_0x0098:
            r0 = r8
            goto L_0x00a1
        L_0x009a:
            r8 = move-exception
            goto L_0x009e
        L_0x009c:
            r8 = move-exception
            r7 = r0
        L_0x009e:
            r8.printStackTrace()
        L_0x00a1:
            if (r7 == 0) goto L_0x00ab
            r7.close()     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00ab
        L_0x00a7:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00ab:
            return r0
        L_0x00ac:
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ Exception -> 0x00d1 }
            java.lang.String r7 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r7}     // Catch:{ Exception -> 0x00d1 }
            r6 = 0
            r2 = r8
            r4 = r9
            r5 = r10
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00d1 }
            if (r7 == 0) goto L_0x00d6
            r7.moveToFirst()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r8 = "_data"
            int r8 = r7.getColumnIndex(r8)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x00cf }
            r0 = r8
            goto L_0x00d6
        L_0x00cf:
            r8 = move-exception
            goto L_0x00d3
        L_0x00d1:
            r8 = move-exception
            r7 = r0
        L_0x00d3:
            r8.printStackTrace()
        L_0x00d6:
            if (r7 == 0) goto L_0x00e0
            r7.close()     // Catch:{ Exception -> 0x00dc }
            goto L_0x00e0
        L_0x00dc:
            r7 = move-exception
            r7.printStackTrace()
        L_0x00e0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axx.m7455a(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[], boolean):java.lang.String");
    }
    private static String m7455a(Context context, Uri uri, String str, String[] strArr, boolean z) {
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        Exception e2;
        String str2 = null;
        if (z) {
            try {
                cursor2 = context.getContentResolver().query(uri, new String[]{"_data", "title", "artist"}, str, strArr, null);
                if (cursor2 != null) {
                    try {
                        cursor2.moveToFirst();
                        String string = cursor2.getString(cursor2.getColumnIndex("_data"));
                        String string2 = cursor2.getString(cursor2.getColumnIndex("title"));
                        String string3 = cursor2.getString(cursor2.getColumnIndex("artist"));
                        if (string2 == null || string3 == null) {
                            int lastIndexOf = string.lastIndexOf("/");
                            int lastIndexOf2 = string.lastIndexOf(".");
                            if (!(lastIndexOf == -1 || lastIndexOf2 == -1)) {
                                String str3 = "Music: " + string.substring(lastIndexOf + 1, lastIndexOf2);
                            }
                        } else {
                            String str4 = (("Music: " + string2) + " - ") + string3;
                        }
                        str2 = string;
                    } catch (Exception e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        if (cursor2 != null) {
                        }
                        return str2;
                    }
                }
            } catch (Exception e4) {
                e2 = e4;
                cursor2 = null;
                e2.printStackTrace();
                if (cursor2 != null) {
                }
                return str2;
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            return str2;
        }
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    cursor.moveToFirst();
                    str2 = cursor.getString(cursor.getColumnIndex("_data"));
                } catch (Exception e6) {
                    e = e6;
                    e.printStackTrace();
                    if (cursor != null) {
                    }
                    return str2;
                }
            }
        } catch (Exception e7) {
            e = e7;
            cursor = null;
            e.printStackTrace();
            if (cursor != null) {
            }
            return str2;
        }
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }
        return str2;
    }

    /* renamed from: a */
    private static boolean m7456a(String str) {
        return axi.m7358a(str);
    }
}
