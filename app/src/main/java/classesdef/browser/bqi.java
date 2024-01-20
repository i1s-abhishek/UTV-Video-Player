package classesdef.browser;

import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/* renamed from: bqi */
public class bqi {
    /* renamed from: a */
    public static long m18945a(long j) {
        return j * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    /* renamed from: a */
    public static void m18947a(final Application application, final Bundle bundle, final String str) {
        C4740s.m21407e().mo322a(new Runnable() {
            public void run() {
                FileOutputStream fileOutputStream = null;
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(application.getFilesDir(), str));
                    try {
                        Parcel obtain = Parcel.obtain();
                        obtain.writeBundle(bundle);
                        fileOutputStream2.write(obtain.marshall());
                        fileOutputStream2.flush();
                        obtain.recycle();
                        bqw.m19016a((Closeable) fileOutputStream2);
                    } catch (IOException unused) {
                        fileOutputStream = fileOutputStream2;
                        try {
                            Log.e("FileUtils", "Unable to write bundle to storage");
                            bqw.m19016a((Closeable) fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            bqw.m19016a((Closeable) fileOutputStream2);
                        //    throw th;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bqw.m19016a((Closeable) fileOutputStream2);
                       // throw th;
                    }
                } catch (IOException unused2) {
                    Log.e("FileUtils", "Unable to write bundle to storage");
                    bqw.m19016a((Closeable) fileOutputStream);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m18948a(Application application, String str) {
        File file = new File(application.getFilesDir(), str);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: b */
    public static Bundle m18949b(Application application, String str) {
        FileInputStream fileInputStream;
        File file = new File(application.getFilesDir(), str);
        try {
            fileInputStream = new FileInputStream(file);
            try {
                Parcel obtain = Parcel.obtain();
                byte[] bArr = new byte[((int) fileInputStream.getChannel().size())];
                fileInputStream.read(bArr, 0, bArr.length);
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                Bundle readBundle = obtain.readBundle(ClassLoader.getSystemClassLoader());
                readBundle.putAll(readBundle);
                obtain.recycle();
                file.delete();
                bqw.m19016a((Closeable) fileInputStream);
                return readBundle;
            } catch (FileNotFoundException unused) {
                Log.e("FileUtils", "Unable to read bundle from storage");
                file.delete();
                bqw.m19016a((Closeable) fileInputStream);
                return null;
            } catch (Exception e) {
                e = e;
                try {
                    e.printStackTrace();
                    file.delete();
                    bqw.m19016a((Closeable) fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (FileNotFoundException unused2) {
            fileInputStream = null;
            Log.e("FileUtils", "Unable to read bundle from storage");
            file.delete();
            bqw.m19016a((Closeable) fileInputStream);
            return null;
        } catch (Exception e) {
            e = e;
            fileInputStream = null;
            e.printStackTrace();
            file.delete();
            bqw.m19016a((Closeable) fileInputStream);
            return null;
        } catch (Throwable th) {
            Throwable th3 = th;
            fileInputStream = null;
            th = th;
            file.delete();
            bqw.m19016a((Closeable) fileInputStream);
           // throw th;
        }
        return null;
    }

    /* renamed from: a */
    public static String m18946a(InputStream inputStream, String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return sb.toString();
            }
            sb.append(readLine);
        }
    }
}
