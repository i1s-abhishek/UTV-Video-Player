package com.abhishek.xplayer.utils.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatEditText;

public class ClearEditText extends AppCompatEditText {

    /* renamed from: a */
    private Drawable f11336a;

    public ClearEditText(Context context) {
        super(context);
        m12884a();
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12884a();
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12884a();
    }

    /* renamed from: a */
    private void m12884a() {
        this.f11336a = getCompoundDrawables()[2];
        m12885a(getText());
    }

    /* renamed from: a */
    private void m12885a(CharSequence charSequence) {
        if (this.f11336a != null) {
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], charSequence != null && charSequence.length() > 0 ? this.f11336a : null, getCompoundDrawables()[3]);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m12885a(charSequence);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() == 1) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            if (x >= ((float) width) || x <= ((float) (width - this.f11336a.getIntrinsicWidth())) || y >= ((float) height) || y <= ((float) (height - this.f11336a.getIntrinsicHeight()))) {
                z = false;
            }
            if (z) {
                setText("");
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
