package classesdef.xdplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;

/* renamed from: axz */
class axz {
    /* renamed from: a */
    static boolean m7474a(Context context, Uri uri) {
        return Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri);
    }

    /* renamed from: a */
    static String m7473a(Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContract.getDocumentId(uri);
        }
        return null;
    }
}
