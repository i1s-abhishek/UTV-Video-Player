package com.abhishek.xplayer.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatImageView;

import com.abhishek.xplayer.application.MyApplication;

import classesdef.ads.DisplayMatrix;


/* renamed from: com.inshot.xplayer.ad.FunnyAdCoverImageView */
public class FunnyAdCoverImageView extends AppCompatImageView {

    /* renamed from: a */
    public static int f7923a;

    public FunnyAdCoverImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FunnyAdCoverImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageBitmap(Bitmap bitmap) {
        int i;
        int i2;
        if (f7923a <= 0) {
            super.setImageBitmap(bitmap);
            return;
        }
        if (bitmap != null) {
            i2 = bitmap.getWidth();
            i = bitmap.getHeight();
        } else {
            i2 = 0;
            i = 0;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams.width <= 0) {
            layoutParams.width = f7923a - DisplayMatrix.getdisplayDensity(MyApplication.getApplicationContext_(), 16.0f);
        }
        if (i2 > 0) {
            layoutParams.height = (int) (Math.min(0.7f, ((float) i) / ((float) i2)) * ((float) layoutParams.width));
        } else {
            layoutParams.height = 0;
        }
        super.setImageBitmap(bitmap);
    }
}
