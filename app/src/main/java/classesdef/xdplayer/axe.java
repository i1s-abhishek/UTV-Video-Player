package classesdef.xdplayer;

import android.os.StatFs;
import android.util.Base64;
import android.util.Log;

import androidx.recyclerview.widget.ItemTouchHelper;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: axe */
public class axe {
    /* renamed from: a */
    public static String m7313a(String str) {
        String replaceAll = str.replaceAll(":", "_").replaceAll("//", "_").replaceAll("/", "_").replaceAll("=", "_").replaceAll(",", "_").replaceAll("&", "_").replaceAll("\\?", "_");
        return replaceAll.length() > 200 ? replaceAll.substring(replaceAll.length() - ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION) : replaceAll;
    }

    /* renamed from: a */
    public static boolean m7319a(String str, boolean z) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || z != file.isDirectory()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static String m7320b(String str) {
        if (str == null) {
            return null;
        }
        return new File(str).getParent();
    }

    /* renamed from: a */
    public static String m7314a(String str, int i) {
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return m7315a(instance.digest()).substring(i, i + 16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return m7313a(str);
        }
    }

    /* renamed from: c */
    public static String m7322c(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    /* renamed from: d */
    public static String m7323d(String str) {
        try {
            return new String(Base64.decode(str.getBytes(), 0));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m7315a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:3|4|5|(3:6|7|(1:9)(6:19|20|(2:22|23)|24|25|52))|49|11|(2:13|14)|15|16|17) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:41|(2:43|44)|45|46|47) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|(2:22|23)|24|25|52) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:26|31|32|(2:34|35)|36|37|38|50) */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0045 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0065 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062 A[SYNTHETIC, Splitter:B:34:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x006d A[SYNTHETIC, Splitter:B:43:0x006d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m7311aa(File r6, String r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r1]
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>(r1)
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            r1.<init>(r6)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        L_0x0012:
            int r4 = r1.read(r2)     // Catch:{ IOException -> 0x0056 }
            r5 = -1
            if (r4 == r5) goto L_0x0049
            r5 = 0
            r3.write(r2, r5, r4)     // Catch:{ IOException -> 0x0056 }
            int r4 = r3.size()     // Catch:{ IOException -> 0x0056 }
            r5 = 1024000(0xfa000, float:1.43493E-39)
            if (r4 <= r5) goto L_0x0012
            java.lang.String r7 = "IoUtils"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0056 }
            r2.<init>()     // Catch:{ IOException -> 0x0056 }
            java.lang.String r4 = "File too large, maybe not a string. "
            r2.append(r4)     // Catch:{ IOException -> 0x0056 }
            java.lang.String r6 = r6.getAbsolutePath()     // Catch:{ IOException -> 0x0056 }
            r2.append(r6)     // Catch:{ IOException -> 0x0056 }
            java.lang.String r6 = r2.toString()     // Catch:{ IOException -> 0x0056 }
            android.util.Log.e(r7, r6)     // Catch:{ IOException -> 0x0056 }
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            r3.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            return r0
        L_0x0049:
            java.lang.String r6 = r3.toString(r7)     // Catch:{ IOException -> 0x0056 }
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            r3.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x0069
        L_0x0056:
            r6 = move-exception
            goto L_0x005d
        L_0x0058:
            r6 = move-exception
            r1 = r0
            goto L_0x006b
        L_0x005b:
            r6 = move-exception
            r1 = r0
        L_0x005d:
            r6.printStackTrace()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0065:
            r3.close()     // Catch:{ IOException -> 0x0068 }
        L_0x0068:
            r6 = r0
        L_0x0069:
            return r6
        L_0x006a:
            r6 = move-exception
        L_0x006b:
            if (r1 == 0) goto L_0x0070
            r1.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            r3.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0073:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axe.m7311a(java.io.File, java.lang.String):java.lang.String");
    }
    public static String m7311a(File file, String str) {
        Throwable th;
        FileInputStream fileInputStream;
        IOException e;
        if (file == null) {
            return null;
        }
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            fileInputStream = new FileInputStream(file);
            do {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream2;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                }
            } while (byteArrayOutputStream.size() <= 1024000);
            Log.e("IoUtils", "File too large, maybe not a string. " + file.getAbsolutePath());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            byteArrayOutputStream.close();
            return null;
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
         //   throw th;
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0028 A[SYNTHETIC, Splitter:B:23:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x002e A[SYNTHETIC, Splitter:B:28:0x002e] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m7318aa(String r3, File r4, String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0032
            if (r3 != 0) goto L_0x0006
            goto L_0x0032
        L_0x0006:
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0022 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0022 }
            byte[] r3 = r3.getBytes(r5)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
            r2.write(r3)     // Catch:{ IOException -> 0x001d, all -> 0x001a }
            r3 = 1
            if (r2 == 0) goto L_0x0019
            r2.close()     // Catch:{ IOException -> 0x0019 }
        L_0x0019:
            return r3
        L_0x001a:
            r3 = move-exception
            r1 = r2
            goto L_0x002c
        L_0x001d:
            r3 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r3 = move-exception
            goto L_0x002c
        L_0x0022:
            r3 = move-exception
        L_0x0023:
            r3.printStackTrace()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ IOException -> 0x002b }
        L_0x002b:
            return r0
        L_0x002c:
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x0031 }
        L_0x0031:
            throw r3
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axe.m7318a(java.lang.String, java.io.File, java.lang.String):boolean");
    }
    public static boolean m7318a(String str, File file, String str2) {
        Throwable th;
        IOException e;
        if (file == null || str == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str.getBytes(str2));
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                return true;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                  //  throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                }
             //   throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: a */
    public static String m7312a(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            do {
                int read = 0;
                try {
                    read = inputStream.read(bArr);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str2 = new String(byteArrayOutputStream.toByteArray(), str);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return str2;
                }
            } while (byteArrayOutputStream.size() <= 1024000);
            Log.e("IoUtils", "Data too large, maybe not a string. ");
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
            }
        }
        return str;
    }

    /* renamed from: a */
    public static long m7310a(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public static void m7316a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x003f A[SYNTHETIC, Splitter:B:35:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0044 A[SYNTHETIC, Splitter:B:39:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x004b A[SYNTHETIC, Splitter:B:45:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0050 A[SYNTHETIC, Splitter:B:49:0x0050] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean m7317aa(File r4, File r5) {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = r4.exists()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            if (r2 == 0) goto L_0x0047
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0033 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0033 }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0030, all -> 0x002d }
        L_0x0016:
            int r1 = r2.read(r5)     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            r3 = -1
            if (r1 == r3) goto L_0x0021
            r4.write(r5, r0, r1)     // Catch:{ Exception -> 0x0030, all -> 0x002d }
            goto L_0x0016
        L_0x0021:
            r5 = 1
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            if (r2 == 0) goto L_0x002c
            r2.close()     // Catch:{ IOException -> 0x002c }
        L_0x002c:
            return r5
        L_0x002d:
            r5 = move-exception
            r1 = r4
            goto L_0x0049
        L_0x0030:
            r5 = move-exception
            r1 = r4
            goto L_0x003a
        L_0x0033:
            r5 = move-exception
            goto L_0x003a
        L_0x0035:
            r5 = move-exception
            r2 = r1
            goto L_0x0049
        L_0x0038:
            r5 = move-exception
            r2 = r1
        L_0x003a:
            r5.printStackTrace()     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ IOException -> 0x0042 }
        L_0x0042:
            if (r2 == 0) goto L_0x0047
            r2.close()     // Catch:{ IOException -> 0x0047 }
        L_0x0047:
            return r0
        L_0x0048:
            r5 = move-exception
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r1.close()     // Catch:{ IOException -> 0x004e }
        L_0x004e:
            if (r2 == 0) goto L_0x0053
            r2.close()     // Catch:{ IOException -> 0x0053 }
        L_0x0053:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axe.m7317a(java.io.File, java.io.File):boolean");
    }
    public static boolean m7317a(File file, File file2) {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream2 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream2 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                }
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    if (fileOutputStream2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                }
            }
            return false;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused6) {
                }
            }
            //throw th;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m7321b(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        if (file.length() > m7310a(file2.getParentFile())) {
            return false;
        }
        return m7317a(file, file2);
    }

    /* renamed from: e */
    public static String m7324e(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(46)) > 0) {
            return str.substring(lastIndexOf + 1);
        }
        return null;
    }

    /* renamed from: f */
    public static boolean m7325f(String str) {
        return str != null && new File(str).isHidden();
    }
}
