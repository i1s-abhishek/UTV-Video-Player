package classesdef.xdplayer;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: axr */
public class axr extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private int f6309a;

    /* renamed from: b */
    private int f6310b;

    /* renamed from: c */
    private int f6311c = -1;

    public axr(int i, int i2) {
        this.f6309a = i;
        this.f6310b = i2;
    }

    /* renamed from: a */
    public void mo10998a(int i) {
        this.f6311c = i;
    }

    /* renamed from: a */
    public int mo10997a() {
        return this.f6311c;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == 0) {
            rect.left = 0;
            rect.right = 0;
        } else if (childLayoutPosition == this.f6311c) {
            rect.left = -this.f6309a;
            rect.right = 0;
        } else {
            if (this.f6311c >= 0 && childLayoutPosition > this.f6311c) {
                childLayoutPosition--;
            }
            int i = (childLayoutPosition - 1) % this.f6310b;
            rect.bottom = 0;
            rect.top = 0;
            if (i == 0) {
                rect.left = this.f6309a;
                rect.right = this.f6309a >> 1;
            } else if (i == this.f6310b - 1) {
                rect.left = this.f6309a >> 1;
                rect.right = this.f6309a;
            } else {
                rect.left = this.f6309a >> 1;
                rect.right = this.f6309a >> 1;
            }
        }
    }
}
