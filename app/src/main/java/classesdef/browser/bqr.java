package classesdef.browser;

/* renamed from: bqr */
public class bqr {
    /* renamed from: a */
    public static void m18980a(StringBuilder sb, String str, String str2) {
        int indexOf = sb.indexOf(str);
        if (indexOf >= 0) {
            sb.replace(indexOf, str.length() + indexOf, str2);
        }
    }

    /* renamed from: a */
    public static void m18979a(StringBuilder sb) {
        while (sb.indexOf(" ") == 0) {
            sb.replace(0, 1, "");
        }
        while (sb.lastIndexOf(" ") == sb.length() - 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
    }

    /* renamed from: b */
    public static boolean m18982b(StringBuilder sb) {
        return sb.length() == 0;
    }

    /* renamed from: a */
    public static boolean m18981a(StringBuilder sb, String str) {
        return sb.indexOf(str) == 0;
    }

    /* renamed from: b */
    public static boolean m18983b(StringBuilder sb, String str) {
        return sb.indexOf(str) >= 0;
    }

    /* renamed from: c */
    public static boolean m18984c(StringBuilder sb, String str) {
        int length = sb.length();
        if (length != str.length()) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static StringBuilder m18978a(StringBuilder sb, int i, int i2) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.replace(i2, sb.length(), "");
        sb2.replace(0, i, "");
        return sb2;
    }
}
