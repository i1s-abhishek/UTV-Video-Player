package classesdef.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: ij */
public class C4319ij {
    /* renamed from: a */
    public String mo23983a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(), 0, str.getBytes().length);
            return mo23984a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public String mo23984a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte a : bArr) {
            m19816a(stringBuffer, a);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private void m19816a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789abcdef".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789abcdef".charAt(b & 15));
    }
}
