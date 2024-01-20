package classesdef.browser;

import android.net.Uri;
import android.text.TextUtils;

/* renamed from: bna */
class bna {
    /* renamed from: a */
    static Uri m18170a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getScheme()) || TextUtils.isEmpty(parse.getHost())) {
            return null;
        }
        return parse;
    }

    /* renamed from: a */
    static void m18171a(Uri uri) {
        if (uri == null || TextUtils.isEmpty(uri.getScheme()) || TextUtils.isEmpty(uri.getHost())) {
            throw new RuntimeException("Unsafe uri provided");
        }
    }
}
