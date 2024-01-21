package com.abhishek.xplayer.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import hdplayer.xdplayer.videoplayer.R;


public class SpanClickableTextView extends TextView {

    /* renamed from: a */
    private OnClickListener f11375a;

    /* renamed from: b */
    private String f11376b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f11377c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f11378d;

    public SpanClickableTextView(Context context) {
        super(context);
    }

    public SpanClickableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpanClickableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int[] SpanClickableTextView = {R.attr.sctv_span_color, R.attr.sctv_span_text, R.attr.sctv_span_underline};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SpanClickableTextView, i, 0);
        this.f11376b = obtainStyledAttributes.getString(1);
        this.f11377c = obtainStyledAttributes.getColor(0, getCurrentTextColor());
        this.f11378d = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
        m12922b();
    }

    public void setSpanText(String str) {
        this.f11376b = str;
        m12922b();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f11375a = onClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12920a() {
        if (this.f11375a != null) {
            this.f11375a.onClick(this);
        }
    }

    /* renamed from: b */
    private void m12922b() {
        if (getText() != null && this.f11376b != null) {
            String[] split = getText().toString().split("%s", 2);
            if (split.length >= 2) {
                setText(split[0]);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f11376b);
                spannableStringBuilder.setSpan(new ClickableSpan() {
                    public void onClick(View view) {
                        SpanClickableTextView.this.m12920a();
                    }

                    public void updateDrawState(TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setUnderlineText(SpanClickableTextView.this.f11378d);
                        textPaint.setColor(SpanClickableTextView.this.f11377c);
                    }
                }, 0, spannableStringBuilder.length(), 33);
                append(spannableStringBuilder);
                append(split[1]);
                setMovementMethod(LinkMovementMethod.getInstance());
                setHighlightColor(0);
                setOnLongClickListener(new OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        return true;
                    }
                });
            }
        }
    }
}
