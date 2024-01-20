package com.abhishek.xplayer.subtitle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class SubtitleTextView extends TextView {

    /* renamed from: a */
    private boolean f11141a;

    /* renamed from: b */
    private boolean f11142b;

    /* renamed from: c */
    private CharSequence f11143c;

    public SubtitleTextView(Context context) {
        super(context);
    }

    public SubtitleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SubtitleTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTextCustom(CharSequence charSequence) {
        if (this.f11141a) {
            this.f11143c = charSequence;
            this.f11142b = true;
            return;
        }
        super.setText(charSequence);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f11141a) {
            canvas.drawColor(1308622847);
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void setTouching(boolean z) {
        this.f11141a = z;
        if (!z) {
            if (this.f11142b) {
                setText(this.f11143c);
            }
            this.f11142b = false;
        }
        invalidate();
    }
}
