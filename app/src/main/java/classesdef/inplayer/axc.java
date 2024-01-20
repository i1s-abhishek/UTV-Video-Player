package classesdef.inplayer;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.media.session.PlaybackStateCompat;
import android.webkit.MimeTypeMap;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.LongBuffer;
import java.nio.channels.FileChannel;

import classesdef.xdplayer.axy;

/* renamed from: axc */
public class axc {
    /* renamed from: a */
    public static boolean chekFileExist(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    /* renamed from: a */
    public static void m7299a(Context context, String str, FilenameFilter filenameFilter, boolean z) {
        String[] strArr;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            File file = new File(str);
            if (filenameFilter == null) {
                strArr = file.list();
            } else {
                strArr = file.list(filenameFilter);
            }
            for (String str2 : strArr) {
                File file2 = new File(str + "/" + str2);
                file2.delete();
                if (z) {
                    contentResolver.delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{file2.getAbsolutePath()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = (r0 = r2.lastIndexOf(46)) + 1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m7304bb(String r2) {
        /*
            if (r2 == 0) goto L_0x001d
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            r1 = 47
            int r1 = r2.lastIndexOf(r1)
            if (r0 <= r1) goto L_0x001d
            int r0 = r0 + 1
            int r1 = r2.length()
            if (r0 >= r1) goto L_0x001d
            java.lang.String r2 = r2.substring(r0)
            return r2
        L_0x001d:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axc.m7304b(java.lang.String):java.lang.String");
    }
    public static String m7304b(String str) {
        int lastIndexOf;
        int i;
        return (str == null || (lastIndexOf = str.lastIndexOf(46)) <= str.lastIndexOf(47) || (i = lastIndexOf + 1) >= str.length()) ? "" : str.substring(i);
    }
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0053 A[SYNTHETIC, Splitter:B:25:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068 A[SYNTHETIC, Splitter:B:36:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0058=Splitter:B:28:0x0058, B:22:0x004e=Splitter:B:22:0x004e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m7300aa(String r2, String r3, byte[] r4) {
        /*
            if (r4 == 0) goto L_0x0071
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = r1.toString()
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x004d }
            r3.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x004d }
            boolean r2 = r3.exists()     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x004d }
            if (r2 != 0) goto L_0x0025
            r3.createNewFile()     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x004d }
        L_0x0025:
            if (r4 == 0) goto L_0x0044
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x004d }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x004d }
            r1.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x004d }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x004d }
            r2.write(r4)     // Catch:{ FileNotFoundException -> 0x0040, IOException -> 0x003c, all -> 0x0038 }
            r2.flush()     // Catch:{ FileNotFoundException -> 0x0040, IOException -> 0x003c, all -> 0x0038 }
            goto L_0x0045
        L_0x0038:
            r3 = move-exception
            r0 = r2
            r2 = r3
            goto L_0x0066
        L_0x003c:
            r3 = move-exception
            r0 = r2
            r2 = r3
            goto L_0x004e
        L_0x0040:
            r3 = move-exception
            r0 = r2
            r2 = r3
            goto L_0x0058
        L_0x0044:
            r2 = r0
        L_0x0045:
            if (r2 == 0) goto L_0x0071
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0071
        L_0x004b:
            r2 = move-exception
            goto L_0x0066
        L_0x004d:
            r2 = move-exception
        L_0x004e:
            r2.printStackTrace()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0071
            r0.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0071
        L_0x0057:
            r2 = move-exception
        L_0x0058:
            r2.printStackTrace()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0071
            r0.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0071
        L_0x0061:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x0071
        L_0x0066:
            if (r0 == 0) goto L_0x0070
            r0.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0070:
            throw r2
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axc.m7300a(java.lang.String, java.lang.String, byte[]):void");
    }
    public static void m7300a(String str, String str2, byte[] bArr) {
        Throwable th;
        FileNotFoundException e;
        IOException e2;
        BufferedOutputStream bufferedOutputStream;
        if (bArr != null) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                File file = new File(str + "/" + str2);
                if (!file.exists()) {
                    file.createNewFile();
                }
                if (bArr != null) {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                    } catch (FileNotFoundException e3) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        e = e3;
                    } catch (IOException e4) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        e2 = e4;
                        try {
                            e2.printStackTrace();
                            if (bufferedOutputStream2 == null) {
                                bufferedOutputStream2.close();
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedOutputStream2 != null) {
                                try {
                                    bufferedOutputStream2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                           // throw th;
                        }
                    } catch (Throwable th3) {
                        bufferedOutputStream2 = bufferedOutputStream;
                        th = th3;
                        if (bufferedOutputStream2 != null) {
                        }
                       // throw th;
                    }
                } else {
                    bufferedOutputStream = null;
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                e.printStackTrace();
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            } catch (IOException e8) {
                e2 = e8;
                e2.printStackTrace();
                if (bufferedOutputStream2 == null) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054 A[SYNTHETIC, Splitter:B:24:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005f A[SYNTHETIC, Splitter:B:31:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c A[SYNTHETIC, Splitter:B:38:0x006c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x005a=Splitter:B:28:0x005a, B:21:0x004f=Splitter:B:21:0x004f} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m7302aa(String r3, String r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r3 = "/"
            r0.append(r3)
            r0.append(r4)
            java.lang.String r3 = r0.toString()
            r4 = 0
            if (r3 == 0) goto L_0x0075
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            boolean r3 = r0.exists()     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            if (r3 != 0) goto L_0x0023
            return r4
        L_0x0023:
            long r1 = r0.length()     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            int r3 = (int) r1     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            byte[] r3 = new byte[r3]     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0058, IOException -> 0x004d, all -> 0x004b }
            r0 = 0
            int r2 = r3.length     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x0047 }
            r1.read(r3, r0, r2)     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x0047 }
            r1.close()     // Catch:{ FileNotFoundException -> 0x0049, IOException -> 0x0047 }
            if (r1 == 0) goto L_0x0046
            r1.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0046:
            return r3
        L_0x0047:
            r3 = move-exception
            goto L_0x004f
        L_0x0049:
            r3 = move-exception
            goto L_0x005a
        L_0x004b:
            r3 = move-exception
            goto L_0x006a
        L_0x004d:
            r3 = move-exception
            r1 = r4
        L_0x004f:
            r3.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0075
        L_0x0058:
            r3 = move-exception
            r1 = r4
        L_0x005a:
            r3.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x0075
            r1.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0075
        L_0x0063:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0075
        L_0x0068:
            r3 = move-exception
            r4 = r1
        L_0x006a:
            if (r4 == 0) goto L_0x0074
            r4.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0074
        L_0x0070:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0074:
            throw r3
        L_0x0075:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axc.m7302a(java.lang.String, java.lang.String):byte[]");
    }
    public static byte[] m7302a(String str, String str2) {
        Throwable th;
        FileNotFoundException e;
        BufferedInputStream bufferedInputStream;
        IOException e2;
        String str3 = str + "/" + str2;
        BufferedInputStream bufferedInputStream2 = null;
        if (str3 != null) {
            try {
                File file = new File(str3);
                if (!file.exists()) {
                    return null;
                }
                byte[] bArr = new byte[((int) file.length())];
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    bufferedInputStream.read(bArr, 0, bArr.length);
                    bufferedInputStream.close();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bArr;
                } catch (FileNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return null;
                } catch (IOException e5) {
                    e2 = e5;
                    try {
                        e2.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                        }
                        throw th;
                    }
                }
            } catch (FileNotFoundException e7) {
                e = e7;
                bufferedInputStream = null;
                e.printStackTrace();
                if (bufferedInputStream != null) {
                }
                return null;
            } catch (IOException e8) {
                e2 = e8;
                bufferedInputStream = null;
                e2.printStackTrace();
                if (bufferedInputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                //throw th;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static String appFolder() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/VideoPlayerHD+";
    }

    /* renamed from: b */
    public static String createFolder() {
        return appFolder() + "/.cache";
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x007b=Splitter:B:31:0x007b, B:25:0x006e=Splitter:B:25:0x006e} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m7298aa(File r14) {
        /*
            long r0 = r14.length()
            r2 = 65536(0x10000, double:3.2379E-319)
            long r10 = java.lang.Math.min(r2, r0)
            r12 = 0
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006b, all -> 0x0067 }
            r13.<init>(r14)     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x006b, all -> 0x0067 }
            java.nio.channels.FileChannel r14 = r13.getChannel()     // Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x0061, all -> 0x005e }
            java.nio.channels.FileChannel$MapMode r5 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            r6 = 0
            r4 = r14
            r8 = r10
            java.nio.MappedByteBuffer r4 = r4.map(r5, r6, r8)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            long r4 = m7296a((java.nio.ByteBuffer) r4)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            int r6 = (int) r10     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocateDirect(r6)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            r7 = 0
            long r2 = r0 - r2
            r7 = 0
            long r2 = java.lang.Math.max(r2, r7)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
        L_0x0031:
            int r7 = r14.read(r6, r2)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            if (r7 <= 0) goto L_0x003a
            long r7 = (long) r7     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            long r2 = r2 + r7
            goto L_0x0031
        L_0x003a:
            r6.flip()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            long r2 = m7296a((java.nio.ByteBuffer) r6)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            java.lang.String r6 = "%016x"
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            r8 = 0
            long r0 = r0 + r4
            long r0 = r0 + r2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            r7[r8] = r0     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            java.lang.String r0 = java.lang.String.format(r6, r7)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x005a }
            p000.axy.m7471a((java.io.Closeable) r14)
            p000.axy.m7471a((java.io.Closeable) r13)
            return r0
        L_0x005a:
            r0 = move-exception
            goto L_0x006e
        L_0x005c:
            r0 = move-exception
            goto L_0x007b
        L_0x005e:
            r0 = move-exception
            r14 = r12
            goto L_0x0086
        L_0x0061:
            r0 = move-exception
            r14 = r12
            goto L_0x006e
        L_0x0064:
            r0 = move-exception
            r14 = r12
            goto L_0x007b
        L_0x0067:
            r0 = move-exception
            r14 = r12
            r13 = r14
            goto L_0x0086
        L_0x006b:
            r0 = move-exception
            r14 = r12
            r13 = r14
        L_0x006e:
            r0.printStackTrace()     // Catch:{ all -> 0x0085 }
            p000.axy.m7471a((java.io.Closeable) r14)
            p000.axy.m7471a((java.io.Closeable) r13)
            return r12
        L_0x0078:
            r0 = move-exception
            r14 = r12
            r13 = r14
        L_0x007b:
            r0.printStackTrace()     // Catch:{ all -> 0x0085 }
            p000.axy.m7471a((java.io.Closeable) r14)
            p000.axy.m7471a((java.io.Closeable) r13)
            return r12
        L_0x0085:
            r0 = move-exception
        L_0x0086:
            p000.axy.m7471a((java.io.Closeable) r14)
            p000.axy.m7471a((java.io.Closeable) r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axc.m7298a(java.io.File):java.lang.String");
    }
    public static String m7298a(File file) {
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        Throwable th;
        FileNotFoundException e;
        IOException e2;
        long length = file.length();
        long min = Math.min((long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, length);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    long a = m7296a(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, min));
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect((int) min);
                    long max = Math.max(length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH, 0L);
                    while (true) {
                        int read = fileChannel.read(allocateDirect, max);
                        if (read > 0) {
                            max += (long) read;
                        } else {
                            allocateDirect.flip();
                            String format = String.format("%016x", Long.valueOf(length + a + m7296a(allocateDirect)));
                            axy.m7471a(fileChannel);
                            axy.m7471a(fileInputStream);
                            return format;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    e.printStackTrace();
                    axy.m7471a(fileChannel);
                    axy.m7471a(fileInputStream);
                    return null;
                } catch (IOException e4) {
                    e2 = e4;
                    try {
                        e2.printStackTrace();
                        axy.m7471a(fileChannel);
                        axy.m7471a(fileInputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        axy.m7471a(fileChannel);
                        axy.m7471a(fileInputStream);
                        throw th;
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileChannel = null;
                e.printStackTrace();
                axy.m7471a(fileChannel);
                axy.m7471a(fileInputStream);
                return null;
            } catch (IOException e6) {
                e2 = e6;
                fileChannel = null;
                e2.printStackTrace();
                axy.m7471a(fileChannel);
                axy.m7471a(fileInputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                axy.m7471a(fileChannel);
                axy.m7471a(fileInputStream);
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileChannel = null;
            fileInputStream = null;
            e.printStackTrace();
            axy.m7471a(fileChannel);
            axy.m7471a(fileInputStream);
            return null;
        } catch (IOException e8) {
            e2 = e8;
            fileChannel = null;
            fileInputStream = null;
            e2.printStackTrace();
            axy.m7471a(fileChannel);
            axy.m7471a(fileInputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            fileChannel = null;
            fileInputStream = null;
            axy.m7471a(fileChannel);
            axy.m7471a(fileInputStream);
           // throw th;
        }
        return null;
    }

    /* renamed from: a */
    private static long m7296a(ByteBuffer byteBuffer) {
        LongBuffer asLongBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asLongBuffer();
        long j = 0;
        while (asLongBuffer.hasRemaining()) {
            j += asLongBuffer.get();
        }
        return j;
    }

    /* renamed from: c */
    public static String m7305c(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }
}
