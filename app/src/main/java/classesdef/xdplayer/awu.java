package classesdef.xdplayer;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: awu */
public class awu extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f6152a;

    /* renamed from: b */
    private int f6153b;

    /* renamed from: c */
    private int f6154c = -1;

    public awu(int i, int i2) {
        this.f6152a = i;
        this.f6153b = i2;
    }

    /* renamed from: a */
    public void mo10893a(int i) {
        this.f6153b = i;
    }

    /* renamed from: b */
    public void mo10894b(int i) {
        this.f6154c = i;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int itemCount = state.getItemCount();
        int i = 0;
        if (this.f6153b <= 1) {
            if (childLayoutPosition == itemCount - 1) {
                i = this.f6152a;
            }
            rect.bottom = i;
            return;
        }
        if (this.f6154c >= 0 && childLayoutPosition >= this.f6154c) {
            itemCount--;
            childLayoutPosition--;
        }
        if ((childLayoutPosition + (this.f6153b - 1)) / this.f6153b == ((itemCount + (this.f6153b - 1)) - 1) / this.f6153b) {
            rect.bottom = this.f6152a;
        } else {
            rect.bottom = 0;
        }
    }
}
