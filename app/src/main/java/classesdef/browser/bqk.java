package classesdef.browser;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: bqk */
public class bqk {

    /* renamed from: a */
    private static Method f16427a;

    /* renamed from: bqk$a */
    public static abstract class C4042a implements Application.ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    /* renamed from: a */
    public static void m18951a(Activity activity, Application application) {
        boolean z;
        if (Build.VERSION.SDK_INT <= 23) {
            InputMethodManager inputMethodManager = (InputMethodManager) application.getSystemService("input_method");
            if (f16427a == null) {
                try {
                    f16427a = InputMethodManager.class.getDeclaredMethod("finishInputLocked", new Class[0]);
                } catch (NoSuchMethodException e) {
                    Log.d("MemoryLeakUtils", "Unable to find method in clearNextServedView", e);
                }
            }
            try {
                Field declaredField = InputMethodManager.class.getDeclaredField("mNextServedView");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(inputMethodManager);
                if ((obj instanceof View) && ((View) obj).getContext() == activity) {
                    z = true;
                    if (f16427a != null && z) {
                        f16427a.setAccessible(true);
                        try {
                            f16427a.invoke(inputMethodManager, new Object[0]);
                            return;
                        } catch (Exception e2) {
                            Log.d("MemoryLeakUtils", "Unable to invoke method in clearNextServedView", e2);
                            return;
                        }
                    }
                }
            } catch (NoSuchFieldException e3) {
                Log.d("MemoryLeakUtils", "Unable to get mNextServedView field", e3);
            } catch (IllegalAccessException e4) {
                Log.d("MemoryLeakUtils", "Unable to access mNextServedView field", e4);
            }
            z = false;
            if (f16427a != null) {
            }
        }
    }
}
