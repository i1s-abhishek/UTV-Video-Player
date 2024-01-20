package classesdef.player;

import android.os.Build;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: aww */
public class aww {

    /* renamed from: a */
    public static final String[] f6155a = {"English", "Deutsch", "Español", "Français", "Indonesia", "Português", "Русский", "العربية", "Čeština", "Italiano", "日本語", "한국어", "Polski", "简体中文", "繁體中文", "Έλληνικά", "فارسی", "हिन्दी", "Magyar", "Nederlands", "ไทย", "Türkçe", "Українська", "Svenska", "Bahasa Melayu", "Tiếng Việt", "Dansk", "Română", "Slovenčina", "Suomi", "Filipino"};

    /* renamed from: b */
    public static final int[] f6156b = {R.id.sort_by_name, R.id.sort_by_date, R.id.sort_by_size, R.id.sort_by_length};

    /* renamed from: c */
    public static final int[][] f6157c = {new int[]{R.string.sort_by_name_toast, R.string.sort_by_name_toast_desc}, new int[]{R.string.sort_by_date_toast, R.string.sort_by_date_toast_desc}, new int[]{R.string.sort_by_size_toast, R.string.sort_by_size_toast_desc}, new int[]{R.string.sort_by_length_toast, R.string.sort_by_length_toast_desc}};

    /* renamed from: d */
    public static final int[] f6158d = {0, 1, 2, 3};

    /* renamed from: e */
    public static final int[] f6159e = {10, 6, 7};

    /* renamed from: f */
    public static final int[] f6160f = {R.drawable.ic_rotation, R.drawable.ic_rotation_landscape, R.drawable.ic_rotation_portrait};

    /* renamed from: g */
    public static final int[] f6161g = {R.string.auto_rotate, R.string.landscape, R.string.portrait};

    /* renamed from: h */
    public static final int[] f6162h = {R.string.auto_rotate, R.string.landscape_locked, R.string.portrait_locked};

    /* renamed from: i */
    public static final int[] f6163i = {R.drawable.ic_ratio_fill, R.drawable.ic_ratio_fit, R.drawable.ic_ratio_original, R.drawable.ic_ratio_stretch, R.drawable.ic_ratio_16_9, R.drawable.ic_ratio_4_3, R.drawable.ic_ratio_18_9};

    /* renamed from: j */
    public static final boolean f6164j;

    static {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21) {
            z = true;
        }
        f6164j = z;
    }
}
