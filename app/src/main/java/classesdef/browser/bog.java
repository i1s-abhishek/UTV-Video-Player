package classesdef.browser;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* renamed from: bog */
public class bog {

    /* renamed from: d */
    private static C3979a f16051d;

    /* renamed from: a */
    private View f16052a;

    /* renamed from: b */
    private int f16053b;

    /* renamed from: c */
    private FrameLayout.LayoutParams f16054c = ((FrameLayout.LayoutParams) this.f16052a.getLayoutParams());

    /* renamed from: bog$a */
    public interface C3979a {
        /* renamed from: a */
        void mo21383a(boolean z);
    }

    /* renamed from: a */
    public static void m18300a(Activity activity, C3979a aVar) {
        try {
            new bog(activity);
            f16051d = aVar;
        } catch (Exception e) {
            e.printStackTrace();
            bbc.m15886a().mo21879a((Context) activity, (Throwable) e);
        } catch (Error e2) {
            e2.printStackTrace();
            bbc.m15886a().mo21879a((Context) activity, (Throwable) e2);
        }
    }

    private bog(Activity activity) {
        this.f16052a = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.f16052a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                bog.this.m18299a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18299a() {
        int b = m18302b();
        if (b != this.f16053b) {
            int height = this.f16052a.getRootView().getHeight();
            int i = height - b;
            if (i > height / 4) {
                ((FrameLayout.LayoutParams) this.f16052a.getLayoutParams()).height = height - i;
                if (f16051d != null) {
                    f16051d.mo21383a(true);
                }
            } else {
                ((FrameLayout.LayoutParams) this.f16052a.getLayoutParams()).height = b;
                if (f16051d != null) {
                    f16051d.mo21383a(false);
                }
            }
            this.f16052a.requestLayout();
            this.f16053b = b;
        }
    }

    /* renamed from: b */
    private int m18302b() {
        Rect rect = new Rect();
        this.f16052a.getWindowVisibleDisplayFrame(rect);
        if (Build.VERSION.SDK_INT <= 19) {
            return rect.bottom - rect.top;
        }
        return rect.bottom;
    }
}
