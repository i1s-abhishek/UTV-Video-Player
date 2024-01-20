package com.abhishek.xplayer.utils.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import classesdef.xdplayer.LogEvents;

public class BitmapImageView extends AppCompatImageView {

    /* renamed from: a */
    private BitmapDrawable f11335a;

    public BitmapImageView(Context context) {
        super(context);
    }

    public BitmapImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BitmapImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            this.f11335a = (BitmapDrawable) drawable;
            if (m12883a(this.f11335a)) {
                this.f11335a = null;
                drawable = null;
            }
        } else {
            this.f11335a = null;
        }
        super.setImageDrawable(drawable);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f11335a == null || !m12883a(this.f11335a)) {
            super.onDraw(canvas);
            return;
        }
        LogEvents.m18488a("Bitmap", "Recycled on draw", false);
        setImageDrawable((Drawable) null);
    }

    /* renamed from: a */
    private static boolean m12883a(BitmapDrawable bitmapDrawable) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        return bitmap == null || bitmap.isRecycled();
    }
}
