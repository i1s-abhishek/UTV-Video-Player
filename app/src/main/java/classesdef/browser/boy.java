package classesdef.browser;

import android.app.ProgressDialog;
import android.content.Context;

/* renamed from: boy */
public class boy {

    /* renamed from: a */
    private static ProgressDialog f16109a;

    /* renamed from: b */
    private static void m18462b(Context context, String str, boolean z) {
        try {
            if (f16109a == null) {
                f16109a = new ProgressDialog(context);
            }
            f16109a.setCancelable(z);
            ProgressDialog progressDialog = f16109a;
            progressDialog.setMessage(str + "");
            f16109a.show();
        } catch (Exception e) {
            m18461b(context);
            e.printStackTrace();
        } catch (Error e2) {
            m18461b(context);
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m18460a(Context context, String str, boolean z) {
        try {
            if (f16109a != null) {
                if (f16109a.isShowing()) {
                    ProgressDialog progressDialog = f16109a;
                    progressDialog.setMessage(str + "");
                    return;
                }
            }
            m18462b(context, str, z);
        } catch (Exception e) {
            m18461b(context);
            e.printStackTrace();
        } catch (Error e2) {
            m18461b(context);
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m18459a(Context context) {
        try {
            if (f16109a != null && f16109a.isShowing()) {
                f16109a.dismiss();
            }
            f16109a = null;
        } catch (Exception e) {
            m18461b(context);
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m18461b(Context context) {
        try {
            if (f16109a != null && f16109a.isShowing()) {
                f16109a.dismiss();
            }
            f16109a = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
