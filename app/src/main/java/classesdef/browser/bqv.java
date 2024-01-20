package classesdef.browser;

import android.util.Patterns;
import android.webkit.URLUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: bqv */
public class bqv {

    /* renamed from: a */
    private static final Pattern f16454a = Pattern.compile("(?i)((?:http|https|file)://|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");

    /* renamed from: a */
    public static String m19000a(String str, boolean z, String str2) {
        String trim = str.trim();
        boolean z2 = trim.indexOf(32) != -1;
        Matcher matcher = f16454a.matcher(trim);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String lowerCase = group.toLowerCase();
            if (!lowerCase.equals(group)) {
                trim = lowerCase + matcher.group(2);
            }
            return (!z2 || !Patterns.WEB_URL.matcher(trim).matches()) ? trim : trim.replace(" ", "%20");
        } else if (z2 || !Patterns.WEB_URL.matcher(trim).matches()) {
            return z ? URLUtil.composeSearchUrl(trim, str2, "%s") : "";
        } else {
            return URLUtil.guessUrl(trim);
        }
    }

    /* renamed from: a */
    public static boolean m19001a(String str) {
        return str != null && str.startsWith("file://") && (str.endsWith("bookmarks.html") || str.endsWith("downloads.html") || str.endsWith("history.html") || str.endsWith("homepage.html") || str.contains("android_asset/web/index.html"));
    }

    /* renamed from: b */
    public static boolean m19002b(String str) {
        return str != null && str.startsWith("file://") && str.endsWith("bookmarks.html");
    }

    /* renamed from: c */
    public static boolean m19003c(String str) {
        return str != null && str.startsWith("file://") && str.endsWith("downloads.html");
    }

    /* renamed from: d */
    public static boolean m19004d(String str) {
        return str != null && str.startsWith("file://") && str.endsWith("history.html");
    }

    /* renamed from: e */
    public static boolean m19005e(String str) {
        return str != null && str.startsWith("file://") && str.endsWith("homepage.html");
    }

    /* renamed from: f */
    public static boolean m19006f(String str) {
        return str != null && str.contains("android_asset/web/index.html");
    }
}
