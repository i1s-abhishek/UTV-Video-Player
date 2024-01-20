package com.abhishek.xplayer.ad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;

/* renamed from: np */
public class C4816np {
    /* renamed from: a */
    public static Bitmap m23807a(Bitmap bitmap, float f, float f2) {
        boolean z;
        Bitmap bitmap2;
        int width = (int) (((float) bitmap.getWidth()) * f);
        int height = (int) (((float) bitmap.getHeight()) * f2);
        try {
            bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            z = false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            bitmap2 = null;
            z = true;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            bitmap2 = null;
            z = true;
        }
        if (bitmap2 == null || z) {
            System.gc();
            System.gc();
            try {
                bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } catch (NullPointerException e3) {
                e3.printStackTrace();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            }
        }
        if (bitmap2 == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmap2);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, matrix, paint);
        bitmap.recycle();
        return bitmap2;
    }

    /* renamed from: a */
    public static Bitmap m23806a(int i, int i2, String str, Bitmap.Config config) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            if (i4 >= 0) {
                if (i3 >= 0) {
                    int round = Math.round((float) Math.max(i, i2));
                    options.inSampleSize = m23805a(round, round, i4, i3);
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = config;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    if (decodeFile == null) {
                        return null;
                    }
                    return decodeFile;
                }
            }
            return null;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static int m23805a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i <= 0 || i2 <= 0) {
            return 1;
        }
        if (i4 > i2 || i3 > i) {
            int i6 = i4 / 2;
            int i7 = i3 / 2;
            while (true) {
                if (i6 / i5 <= i2 && i7 / i5 <= i) {
                    break;
                }
                i5 *= 2;
            }
        }
        return i5;
    }
}
