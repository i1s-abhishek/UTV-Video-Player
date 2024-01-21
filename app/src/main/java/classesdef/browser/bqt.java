package classesdef.browser;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bqt ContextCompat*/
public class bqt {

    /* renamed from: a */
    private static final TypedValue f16453a = new TypedValue();

    /* renamed from: a */
    public static int m18989a(boolean z) {
        return (z ? -1 : -16777216) & -2130706433;
    }

    /* renamed from: a */
    public static int m18986a(Context context) {
        return m18987a(context, (int) R.attr.colorPrimary);
    }

    /* renamed from: b */
    public static int m18991b(Context context) {
        return m18987a(context, (int) R.attr.colorPrimaryDark);
    }

    /* renamed from: c */
    public static int m18994c(Context context) {
        return m18987a(context, (int) R.attr.colorAccent);
    }

    @TargetApi(21)
    /* renamed from: d */
    public static int m18996d(Context context) {
        return m18987a(context, 16843857);
    }

    /* renamed from: a */
    public static int m18987a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f16453a.data, new int[]{i});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    /* renamed from: e */
    public static int m18997e(Context context) {
        return ContextCompat.getColor(context, R.color.icon_light_theme);
    }

    /* renamed from: f */
    public static int m18998f(Context context) {
        return ContextCompat.getColor(context, R.color.icon_dark_theme);
    }

    /* renamed from: a */
    public static int m18988a(Context context, boolean z) {
        return z ? m18998f(context) : m18997e(context);
    }

    /* renamed from: b */
    private static Drawable m18992b(Context context, int i) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        bql.m18952a(drawable);
        return Build.VERSION.SDK_INT < 21 ? DrawableCompat.wrap(drawable).mutate() : drawable;
    }

    /* renamed from: c */
    private static Bitmap m18995c(Context context, int i) {
        Drawable b = m18992b(context, i);
        Bitmap createBitmap = Bitmap.createBitmap(b.getIntrinsicWidth(), b.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        b.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        b.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m18990a(Context context, int i, boolean z) {
        int f = z ? m18998f(context) : m18997e(context);
        Bitmap c = m18995c(context, i);
        Bitmap createBitmap = Bitmap.createBitmap(c.getWidth(), c.getHeight(), Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setColorFilter(new PorterDuffColorFilter(f, PorterDuff.Mode.SRC_IN));
        new Canvas(createBitmap).drawBitmap(c, 0.0f, 0.0f, paint);
        c.recycle();
        return createBitmap;
    }

    /* renamed from: b */
    public static Drawable m18993b(Context context, int i, boolean z) {
        int f = z ? m18998f(context) : m18997e(context);
        Drawable b = m18992b(context, i);
        b.mutate();
        b.setColorFilter(f, PorterDuff.Mode.SRC_IN);
        return b;
    }
}
