package com.abhishek.xplayer.ad;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* renamed from: com.inshot.xplayer.ad.AdCoverLayout */
public class AdCoverLayout extends FrameLayout {
    public AdCoverLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdCoverLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (measuredWidth > 0 && getMeasuredHeight() > (i3 = (int) (((float) measuredWidth) * 0.75f))) {
            setMeasuredDimension(measuredWidth, i3);
        }
    }
}
