package classesdef.browser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public final class bqw {

    public static int m19008a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return (((int) ((((float) (i & 255)) * f) + (((float) (i2 & 255)) * f2))) & 255) | ((((int) ((((float) ((i >> 16) & 255)) * f) + (((float) ((i2 >> 16) & 255)) * f2))) & 255) << 16) | -16777216 | ((((int) ((((float) ((i >> 8) & 255)) * f) + (((float) ((i2 >> 8) & 255)) * f2))) & 255) << 8);
    }


    public static boolean m19018a(int i) {
        int i2 = ((((int) (((float) ((i >> 16) & 255)) * 0.3f)) & 255) + (((int) (((double) ((float) ((i >> 8) & 255))) * 0.59d)) & 255) + (((int) (((double) ((float) (i & 255))) * 0.11d)) & 255)) & 255;
        return ((i2 << 8) + i2) + (i2 << 16) < 7500402;
    }
    public static boolean m19017a() {
        return Build.VERSION.SDK_INT >= 19;
    }


    public static Intent m19009a(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.TEXT", str3);
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.CC", str4);
        intent.setType("message/rfc822");
        return intent;
    }


    public static void m19012a(Activity activity, int i) {
        try {
            View findViewById = activity.findViewById(16908290);
            if (findViewById == null) {
                Log.e("Utils", "showSnackbar", new NullPointerException("Unable to find android.R.id.content"));
            } else {
                Snackbar.make(findViewById, i, -1).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) activity, (Throwable) e);
            m19014a((Context) activity, i);
        }
    }


    public static void m19014a(Context context, int i) {
        Toast.makeText(context, i, 0).show();
    }
    public static int m19007a(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }


    public static String m19011a(String str) {
        String str2;
        if (str == null || str.isEmpty()) {
            return "";
        }
        boolean startsWith = str.startsWith("https://");
        int indexOf = str.indexOf(47, 8);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        try {
            str2 = new URI(str).getHost();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            str2 = null;
        }
        if (str2 == null || str2.isEmpty()) {
            return str;
        }
        if (!startsWith) {
            return str2.startsWith("www.") ? str2.substring(4) : str2;
        }
        return "https://" + str2;
    }
    public static void m19013a(Context context) {
        try {
            File cacheDir = context.getCacheDir();
            if (cacheDir != null && cacheDir.isDirectory()) {
                m19019a(cacheDir);
            }
        } catch (Exception unused) {
        }
    }


    private static boolean m19019a(File file) {
        if (file != null && file.isDirectory()) {
            for (String file2 : file.list()) {
                if (!m19019a(new File(file, file2))) {
                    return false;
                }
            }
        }
        if (file == null || !file.delete()) {
            return false;
        }
        return true;
    }


    public static Bitmap m19010a(Bitmap bitmap) {
        int a = m19007a(4.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + a, bitmap.getHeight() + a, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        float f = (float) (a / 2);
        canvas.drawBitmap(bitmap, f, f, new Paint(2));
        return createBitmap;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static File m19020b() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        try {
            return File.createTempFile("JPEG_" + format + '_', ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void m19016a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void m19015a(Canvas canvas, int i, boolean z) {
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        if (z) {
            paint.setShader(new LinearGradient(0.0f, ((float) canvas.getHeight()) * 0.9f, 0.0f, (float) canvas.getHeight(), i, m19008a(-16777216, i, 0.5f), Shader.TileMode.CLAMP));
        } else {
            paint.setShader((Shader) null);
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int tan = (int) (((double) height) / Math.tan(1.0471975511965976d));
        Path path = new Path();
        path.reset();
        float f = (float) height;
        path.moveTo(0.0f, f);
        path.lineTo((float) width, f);
        path.lineTo((float) (width - tan), 0.0f);
        path.lineTo((float) tan, 0.0f);
        path.close();
        canvas.drawPath(path, paint);
    }


    public static String m19022b(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length / 2;
        char[] cArr = {'P', 'e', 'r', 'i', 'o', 'd'};
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            charArray[i2] = (char) (charArray[i2] ^ cArr[i % 6]);
        }
        return new String(charArray);
    }


    public static String getFileType(String str) {
        int lastIndexOf = str.lastIndexOf(46) + 1;
        if (lastIndexOf <= 0 || str.length() <= lastIndexOf) {
            return null;
        }
        return str.substring(lastIndexOf, str.length());
    }


    public static String m19021b(Context context) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            return (clipboardManager == null || clipboardManager.getText() == null) ? "" : clipboardManager.getText().toString();
        } catch (Exception unused) {
            return "";
        }
    }


    public static boolean m19025d(String str) {
        try {
            if (!Patterns.WEB_URL.matcher(str).matches()) {
                return false;
            }
            new URL(str).toURI();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }


    public static boolean m19024c() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        if (Build.BRAND != null && Build.BRAND.toLowerCase(Locale.ENGLISH).contains("lava")) {
            return true;
        }
        if (Build.MODEL == null || !Build.MODEL.toLowerCase(Locale.ENGLISH).contains("lava")) {
            return false;
        }
        return true;
    }
}
