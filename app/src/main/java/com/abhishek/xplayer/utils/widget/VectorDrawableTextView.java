package com.abhishek.xplayer.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;

import hdplayer.vlcplayer.videoplayer.R;


public class VectorDrawableTextView extends AppCompatTextView {
    public VectorDrawableTextView(Context context) {
        super(context);
    }

    public VectorDrawableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo18320a(context, attributeSet);
    }

    public VectorDrawableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo18320a(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo18320a(Context context, AttributeSet attributeSet) {
        int[] VectorDrawableTextView = {R.attr.drawableBottomCompat, R.attr.drawableLeftCompat, R.attr.drawableRightCompat, R.attr.drawableTopCompat};
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet,VectorDrawableTextView);
            Drawable drawable4 = null;
            if (Build.VERSION.SDK_INT >= 21) {
                Drawable drawable5 = obtainStyledAttributes.getDrawable(1);
                Drawable drawable6 = obtainStyledAttributes.getDrawable(2);
                Drawable drawable7 = obtainStyledAttributes.getDrawable(0);
                drawable4 = obtainStyledAttributes.getDrawable(3);
                drawable = drawable6;
                drawable2 = drawable7;
                drawable3 = drawable5;
            } else {
                int resourceId = obtainStyledAttributes.getResourceId(1, -1);
                int resourceId2 = obtainStyledAttributes.getResourceId(2, -1);
                int resourceId3 = obtainStyledAttributes.getResourceId(0, -1);
                int resourceId4 = obtainStyledAttributes.getResourceId(3, -1);
                drawable3 = resourceId != -1 ? AppCompatDrawableManager.get().getDrawable(context, resourceId) : null;
                drawable = resourceId2 != -1 ? AppCompatDrawableManager.get().getDrawable(context, resourceId2) : null;
                drawable2 = resourceId3 != -1 ? AppCompatDrawableManager.get().getDrawable(context, resourceId3) : null;
                if (resourceId4 != -1) {
                    drawable4 = AppCompatDrawableManager.get().getDrawable(context, resourceId4);
                }
            }
            setCompoundDrawablesWithIntrinsicBounds(drawable3, drawable4, drawable, drawable2);
            obtainStyledAttributes.recycle();
        }
    }
}
