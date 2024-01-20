package classesdef.browser;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: bos */
public class bos {
    /* renamed from: a */
    public static String m18407a(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(), 0, str.getBytes().length);
            return m18408a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m18408a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            m18409a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m18409a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789abcdef".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789abcdef".charAt(b & 15));
    }
}
