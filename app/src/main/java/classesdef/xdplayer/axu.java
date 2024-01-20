package classesdef.xdplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;

import com.abhishek.xplayer.application.MyApplication;

import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: axu */
public class axu {

    /* renamed from: a */
    private static axu f6315a = new axu();

    /* renamed from: b */
    private static Context f6316b;

    private axu() {
    }

    /* renamed from: a */
    public static axu m7428a() {
        f6316b = MyApplication.getApplicationContext_();
        return f6315a;
    }

    /* renamed from: a */
    public void mo11009a(View view, int i, String str) {
        Object tag;
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.add(view);
        while (true) {
            View view2 = (View) linkedBlockingDeque.poll();
            if (view2 == null) {
                return;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    linkedBlockingDeque.add(viewGroup.getChildAt(i2));
                }
            } else if ((view2 instanceof TextView) && (tag = view2.getTag()) != null && tag.toString().equals(str)) {
                ((TextView) view2).setTextColor(f6316b.getResources().getColor(i));
            }
        }
    }

    /* renamed from: b */
    public void mo11010b(View view, int i, String str) {
        if (str == null) {
            view.setAlpha(Float.parseFloat(f6316b.getResources().getString(i)));
            return;
        }
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.add(view);
        while (true) {
            View view2 = (View) linkedBlockingDeque.poll();
            if (view2 != null) {
                if (view2 instanceof ViewGroup) {
                    int i2 = 0;
                    while (true) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        if (i2 >= viewGroup.getChildCount()) {
                            break;
                        }
                        linkedBlockingDeque.add(viewGroup.getChildAt(i2));
                        i2++;
                    }
                }
                Object tag = view2.getTag();
                if (tag != null && tag.toString().equals(str)) {
                    view2.setAlpha(Float.parseFloat(f6316b.getResources().getString(i)));
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo11008a(View view, int i, int i2) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.add(view);
        while (true) {
            View view2 = (View) linkedBlockingDeque.poll();
            if (view2 == null) {
                return;
            }
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    linkedBlockingDeque.add(viewGroup.getChildAt(i3));
                }
            } else if ((view2 instanceof AppCompatImageView) && view2.getId() == i2) {
                ((ImageView) view2).setImageResource(i);
            }
        }
    }

    /* renamed from: c */
    public void mo11011c(View view, int i, String str) {
        if (str == null) {
            mo11007a(view, i);
            return;
        }
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.add(view);
        while (true) {
            View view2 = (View) linkedBlockingDeque.poll();
            if (view2 != null) {
                if (view2 instanceof ViewGroup) {
                    int i2 = 0;
                    while (true) {
                        ViewGroup viewGroup = (ViewGroup) view2;
                        if (i2 >= viewGroup.getChildCount()) {
                            break;
                        }
                        linkedBlockingDeque.add(viewGroup.getChildAt(i2));
                        i2++;
                    }
                }
                Object tag = view2.getTag();
                if (tag != null && tag.toString().equals(str)) {
                    mo11007a(view2, i);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo11007a(View view, int i) {
        view.setBackgroundResource(i);
    }
}
