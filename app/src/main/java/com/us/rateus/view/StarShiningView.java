package com.us.rateus.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import hdplayer.vlcplayer.videoplayer.R;


public class StarShiningView extends View {

    /* renamed from: a */
    private Bitmap f10526a;

    /* renamed from: b */
    private Bitmap f10527b;

    /* renamed from: c */
    private Paint f10528c;

    /* renamed from: d */
    private boolean f10529d;

    public StarShiningView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13033a();
    }

    public StarShiningView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13033a();
    }

    /* renamed from: a */
    private void m13033a() {
        this.f10526a = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.lib_rate_star);
        this.f10527b = BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.lib_rate_shining_right);
        this.f10528c = new Paint();
    }

    public void setRtl(boolean z) {
        this.f10529d = z;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getWidth() > 0 && getHeight() > 0) {
            float width = (((float) getWidth()) / 2.0f) + (((float) this.f10526a.getWidth()) / 2.0f);
            float height = (((float) getHeight()) / 2.0f) - (((float) this.f10526a.getHeight()) / 2.0f);
            if (((float) this.f10527b.getWidth()) + width > ((float) getWidth())) {
                width = (float) (getWidth() - this.f10527b.getWidth());
            }
            if (height - ((float) this.f10527b.getHeight()) < 0.0f) {
                height = (float) this.f10527b.getHeight();
            }
            if (width - (((float) getWidth()) / 2.0f) > (((float) getHeight()) / 2.0f) - height) {
                width = ((((float) getWidth()) / 2.0f) + (((float) getHeight()) / 2.0f)) - height;
            } else {
                height = (((float) getHeight()) / 2.0f) - (width - (((float) getWidth()) / 2.0f));
            }
            Bitmap bitmap = this.f10527b;
            canvas.drawBitmap(bitmap, width, height - ((float) bitmap.getHeight()), this.f10528c);
        }
    }
}
