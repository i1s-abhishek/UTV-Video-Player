package com.abhishek.inplayer.widget;

import android.view.View;

import java.lang.ref.WeakReference;

/* renamed from: com.inshot.inplayer.widget.d */
public final class C2480d {

    /* renamed from: a */
    private WeakReference<View> f9948a;

    /* renamed from: b */
    private int mVideoWidth;

    /* renamed from: c */
    private int mVideoHeight;

    /* renamed from: d */
    private int f9951d;

    /* renamed from: e */
    private int f9952e;

    /* renamed from: f */
    private int mVideoRotationDegree;

    /* renamed from: g */
    private int mMeasuredWidth;

    /* renamed from: h */
    private int mMeasuredHeight;

    /* renamed from: i */
    private int f9956i = 0;

    public C2480d(View view) {
        this.f9948a = new WeakReference<>(view);
    }

    /* renamed from: a */
    public void mo17538a(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
    }

    /* renamed from: b */
    public void mo17541b(int i, int i2) {
        this.f9951d = i;
        this.f9952e = i2;
    }

    /* renamed from: a */
    public void mo17537a(int i) {
        this.mVideoRotationDegree = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x010e, code lost:
        if (r1 > r9) goto L_0x0132;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doMeasurec(int r9, int r10) {
        /*
            r8 = this;
            int r0 = r8.mVideoRotationDegree
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 90
            if (r0 == r2) goto L_0x000c
            int r0 = r8.mVideoRotationDegree
            if (r0 != r1) goto L_0x000f
        L_0x000c:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x000f:
            int r0 = r8.mVideoWidth
            int r0 = android.view.View.getDefaultSize(r0, r9)
            int r3 = r8.mVideoHeight
            int r3 = android.view.View.getDefaultSize(r3, r10)
            int r4 = r8.f9956i
            r5 = 3
            if (r4 != r5) goto L_0x0022
            goto L_0x0132
        L_0x0022:
            int r4 = r8.mVideoWidth
            if (r4 <= 0) goto L_0x0130
            int r4 = r8.mVideoHeight
            if (r4 <= 0) goto L_0x0130
            int r0 = android.view.View.MeasureSpec.getMode(r9)
            int r9 = android.view.View.MeasureSpec.getSize(r9)
            int r3 = android.view.View.MeasureSpec.getMode(r10)
            int r10 = android.view.View.MeasureSpec.getSize(r10)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r4) goto L_0x00c9
            if (r3 != r4) goto L_0x00c9
            float r0 = (float) r9
            float r3 = (float) r10
            float r4 = r0 / r3
            int r5 = r8.f9956i
            switch(r5) {
                case 4: goto L_0x007e;
                case 5: goto L_0x0070;
                case 6: goto L_0x0063;
                default: goto L_0x0049;
            }
        L_0x0049:
            int r1 = r8.mVideoWidth
            float r1 = (float) r1
            int r2 = r8.mVideoHeight
            float r2 = (float) r2
            float r5 = r1 / r2
            int r1 = r8.f9951d
            if (r1 <= 0) goto L_0x008b
            int r1 = r8.f9952e
            if (r1 <= 0) goto L_0x008b
            int r1 = r8.f9951d
            float r1 = (float) r1
            float r5 = r5 * r1
            int r1 = r8.f9952e
            float r1 = (float) r1
            float r5 = r5 / r1
            goto L_0x008b
        L_0x0063:
            r5 = 1073741824(0x40000000, float:2.0)
            int r6 = r8.mVideoRotationDegree
            if (r6 == r2) goto L_0x006d
            int r2 = r8.mVideoRotationDegree
            if (r2 != r1) goto L_0x008b
        L_0x006d:
            r5 = 1056964608(0x3f000000, float:0.5)
            goto L_0x008b
        L_0x0070:
            r5 = 1068149419(0x3faaaaab, float:1.3333334)
            int r6 = r8.mVideoRotationDegree
            if (r6 == r2) goto L_0x007b
            int r2 = r8.mVideoRotationDegree
            if (r2 != r1) goto L_0x008b
        L_0x007b:
            r5 = 1061158912(0x3f400000, float:0.75)
            goto L_0x008b
        L_0x007e:
            r5 = 1071877689(0x3fe38e39, float:1.7777778)
            int r6 = r8.mVideoRotationDegree
            if (r6 == r2) goto L_0x0089
            int r2 = r8.mVideoRotationDegree
            if (r2 != r1) goto L_0x008b
        L_0x0089:
            r5 = 1058013184(0x3f100000, float:0.5625)
        L_0x008b:
            int r1 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x0091
            r1 = 1
            goto L_0x0092
        L_0x0091:
            r1 = 0
        L_0x0092:
            int r2 = r8.f9956i
            switch(r2) {
                case 0: goto L_0x00af;
                case 1: goto L_0x00a4;
                case 2: goto L_0x0097;
                case 3: goto L_0x0097;
                case 4: goto L_0x00af;
                case 5: goto L_0x00af;
                case 6: goto L_0x00af;
                default: goto L_0x0097;
            }
        L_0x0097:
            if (r1 == 0) goto L_0x00ba
            int r10 = r8.mVideoWidth
            int r9 = java.lang.Math.min(r10, r9)
            float r10 = (float) r9
            float r10 = r10 / r5
            int r10 = (int) r10
            goto L_0x0132
        L_0x00a4:
            if (r1 == 0) goto L_0x00ab
            float r3 = r3 * r5
            int r9 = (int) r3
            goto L_0x0132
        L_0x00ab:
            float r0 = r0 / r5
            int r10 = (int) r0
            goto L_0x0132
        L_0x00af:
            if (r1 == 0) goto L_0x00b5
            float r0 = r0 / r5
            int r10 = (int) r0
            goto L_0x0132
        L_0x00b5:
            float r3 = r3 * r5
            int r9 = (int) r3
            goto L_0x0132
        L_0x00ba:
            int r9 = r8.mVideoHeight
            int r9 = java.lang.Math.min(r9, r10)
            float r10 = (float) r9
            float r10 = r10 * r5
            int r10 = (int) r10
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x0132
        L_0x00c9:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 != r1) goto L_0x00f3
            if (r3 != r1) goto L_0x00f3
            int r0 = r8.mVideoWidth
            int r0 = r0 * r10
            int r1 = r8.mVideoHeight
            int r1 = r1 * r9
            if (r0 >= r1) goto L_0x00e1
            int r9 = r8.mVideoWidth
            int r9 = r9 * r10
            int r0 = r8.mVideoHeight
            int r9 = r9 / r0
            goto L_0x0132
        L_0x00e1:
            int r0 = r8.mVideoWidth
            int r0 = r0 * r10
            int r1 = r8.mVideoHeight
            int r1 = r1 * r9
            if (r0 <= r1) goto L_0x0132
            int r10 = r8.mVideoHeight
            int r10 = r10 * r9
            int r0 = r8.mVideoWidth
            int r10 = r10 / r0
            goto L_0x0132
        L_0x00f3:
            if (r0 != r1) goto L_0x0103
            int r0 = r8.mVideoHeight
            int r0 = r0 * r9
            int r1 = r8.mVideoWidth
            int r0 = r0 / r1
            if (r3 != r4) goto L_0x0101
            if (r0 <= r10) goto L_0x0101
            goto L_0x0132
        L_0x0101:
            r10 = r0
            goto L_0x0132
        L_0x0103:
            if (r3 != r1) goto L_0x0113
            int r1 = r8.mVideoWidth
            int r1 = r1 * r10
            int r2 = r8.mVideoHeight
            int r1 = r1 / r2
            if (r0 != r4) goto L_0x0111
            if (r1 <= r9) goto L_0x0111
            goto L_0x0132
        L_0x0111:
            r9 = r1
            goto L_0x0132
        L_0x0113:
            int r1 = r8.mVideoWidth
            int r2 = r8.mVideoHeight
            if (r3 != r4) goto L_0x0123
            if (r2 <= r10) goto L_0x0123
            int r1 = r8.mVideoWidth
            int r1 = r1 * r10
            int r2 = r8.mVideoHeight
            int r1 = r1 / r2
            goto L_0x0124
        L_0x0123:
            r10 = r2
        L_0x0124:
            if (r0 != r4) goto L_0x0111
            if (r1 <= r9) goto L_0x0111
            int r10 = r8.mVideoHeight
            int r10 = r10 * r9
            int r0 = r8.mVideoWidth
            int r10 = r10 / r0
            goto L_0x0132
        L_0x0130:
            r9 = r0
            r10 = r3
        L_0x0132:
            r8.mMeasuredWidth = r9
            r8.mMeasuredHeight = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inshot.inplayer.widget.C2480d.doMeasure(int, int):void");
    }
    public void doMeasurecc(int i2, int i3) {
        int i4;
        float f2;
        if (this.mVideoRotationDegree == 90 || this.mVideoRotationDegree == 270) {
            i3 = i2;
            i2 = i3;
        }
        int defaultSize = View.getDefaultSize(this.mVideoWidth, i2);
        int defaultSize2 = View.getDefaultSize(this.mVideoHeight, i3);
        if (this.f9956i != 3) {
            if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                i2 = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                i3 = View.MeasureSpec.getSize(i3);
                if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                    float f3 = (float) i2;
                    float f4 = (float) i3;
                    float f5 = f3 / f4;
                    switch (this.f9956i) {
                        case 4:
                            f2 = 1.7777778f;
                            if (this.mVideoRotationDegree == 90 || this.mVideoRotationDegree == 270) {
                                f2 = 0.5625f;
                                break;
                            }
                        case 5:
                            f2 = 1.3333334f;
                            if (this.mVideoRotationDegree == 90 || this.mVideoRotationDegree == 270) {
                                f2 = 0.75f;
                                break;
                            }
                        case 6:
                            f2 = 2.0f;
                            if (this.mVideoRotationDegree == 90 || this.mVideoRotationDegree == 270) {
                                f2 = 0.5f;
                                break;
                            }
                        default:
                            f2 = ((float) this.mVideoWidth) / ((float) this.mVideoHeight);
                            if (this.f9951d > 0 && this.f9952e > 0) {
                                f2 = (f2 * ((float) this.f9951d)) / ((float) this.f9952e);
                                break;
                            }
                    }
                    boolean z = f2 > f5;
                    switch (this.f9956i) {
                        case 0:
                        case 4:
                        case 5:
                        case 6:
                            if (!z) {
                                i2 = (int) (f4 * f2);
                                break;
                            } else {
                                i3 = (int) (f3 / f2);
                                break;
                            }
                        case 1:
                            if (!z) {
                                i3 = (int) (f3 / f2);
                                break;
                            } else {
                                i2 = (int) (f4 * f2);
                                break;
                            }
                        case 2:
                        case 3:
                        default:
                            if (!z) {
                                int min = Math.min(this.mVideoHeight, i3);
                                i3 = min;
                                i2 = (int) (((float) min) * f2);
                                break;
                            } else {
                                i2 = Math.min(this.mVideoWidth, i2);
                                i3 = (int) (((float) i2) / f2);
                                break;
                            }
                    }
                } else if (mode == 1073741824 && mode2 == 1073741824) {
                    if (this.mVideoWidth * i3 < this.mVideoHeight * i2) {
                        i2 = (this.mVideoWidth * i3) / this.mVideoHeight;
                    } else if (this.mVideoWidth * i3 > this.mVideoHeight * i2) {
                        i3 = (this.mVideoHeight * i2) / this.mVideoWidth;
                    }
                } else if (mode == 1073741824) {
                    int i5 = (this.mVideoHeight * i2) / this.mVideoWidth;
                    if (mode2 != Integer.MIN_VALUE || i5 <= i3) {
                        i3 = i5;
                    }
                } else {
                    if (mode2 == 1073741824) {
                        i4 = (this.mVideoWidth * i3) / this.mVideoHeight;
                        if (mode == Integer.MIN_VALUE) {
                        }
                    } else {
                        i4 = this.mVideoWidth;
                        int i6 = this.mVideoHeight;
                        if (mode2 != Integer.MIN_VALUE || i6 <= i3) {
                            i3 = i6;
                        } else {
                            i4 = (this.mVideoWidth * i3) / this.mVideoHeight;
                        }
                        if (mode == Integer.MIN_VALUE && i4 > i2) {
                            i3 = (this.mVideoHeight * i2) / this.mVideoWidth;
                        }
                    }
                    i2 = i4;
                }
            } else {
                i2 = defaultSize;
                i3 = defaultSize2;
            }
        }
        this.mMeasuredWidth = i2;
        this.mMeasuredHeight = i3;
    }
    public void doMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //Log.i("@@@@", "onMeasure(" + MeasureSpec.toString(widthMeasureSpec) + ", "
        //        + MeasureSpec.toString(heightMeasureSpec) + ")");
        if (mVideoRotationDegree == 90 || mVideoRotationDegree == 270) {
            int tempSpec = widthMeasureSpec;
            widthMeasureSpec  = heightMeasureSpec;
            heightMeasureSpec = tempSpec;
        }

        int width = View.getDefaultSize(mVideoWidth, widthMeasureSpec);
        int height = View.getDefaultSize(mVideoHeight, heightMeasureSpec);
        if (this.f9956i == 3) {
            width = widthMeasureSpec;
            height = heightMeasureSpec;
        } else if (mVideoWidth > 0 && mVideoHeight > 0) {
            int widthSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
            int widthSpecSize = View.MeasureSpec.getSize(widthMeasureSpec);
            int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);
            int heightSpecSize = View.MeasureSpec.getSize(heightMeasureSpec);

            if (widthSpecMode == View.MeasureSpec.AT_MOST && heightSpecMode == View.MeasureSpec.AT_MOST) {
                float specAspectRatio = (float) widthSpecSize / (float) heightSpecSize;
                float displayAspectRatio;
                switch (this.f9956i) {
                    case 4:
                        displayAspectRatio = 16.0f / 9.0f;
                        if (mVideoRotationDegree == 90 || mVideoRotationDegree == 270)
                            displayAspectRatio = 1.0f / displayAspectRatio;
                        break;
                    case 5:
                        displayAspectRatio = 4.0f / 3.0f;
                        if (mVideoRotationDegree == 90 || mVideoRotationDegree == 270)
                            displayAspectRatio = 1.0f / displayAspectRatio;
                        break;
                    case 0:
                    case 1:
                    case 2:
                    default:
                        displayAspectRatio = (float) mVideoWidth / (float) mVideoHeight;
                        if (f9951d > 0 && f9952e > 0)
                            displayAspectRatio = displayAspectRatio * f9951d / f9952e;
                        break;
                }
                boolean shouldBeWider = displayAspectRatio > specAspectRatio;

                switch (this.f9956i) {
                    case 0:
                    case 4:
                    case 5:
                        if (shouldBeWider) {
                            // too wide, fix width
                            width = widthSpecSize;
                            height = (int) (width / displayAspectRatio);
                        } else {
                            // too high, fix height
                            height = heightSpecSize;
                            width = (int) (height * displayAspectRatio);
                        }
                        break;
                    case 1:
                        if (shouldBeWider) {
                            // not high enough, fix height
                            height = heightSpecSize;
                            width = (int) (height * displayAspectRatio);
                        } else {
                            // not wide enough, fix width
                            width = widthSpecSize;
                            height = (int) (width / displayAspectRatio);
                        }
                        break;
                    case 2:
                    default:
                        if (shouldBeWider) {
                            // too wide, fix width
                            width = Math.min(mVideoWidth, widthSpecSize);
                            height = (int) (width / displayAspectRatio);
                        } else {
                            // too high, fix height
                            height = Math.min(mVideoHeight, heightSpecSize);
                            width = (int) (height * displayAspectRatio);
                        }
                        break;
                }
            } else if (widthSpecMode == View.MeasureSpec.EXACTLY && heightSpecMode == View.MeasureSpec.EXACTLY) {
                // the size is fixed
                width = widthSpecSize;
                height = heightSpecSize;

                // for compatibility, we adjust size based on aspect ratio
                if (mVideoWidth * height < width * mVideoHeight) {
                    //Log.i("@@@", "image too wide, correcting");
                    width = height * mVideoWidth / mVideoHeight;
                } else if (mVideoWidth * height > width * mVideoHeight) {
                    //Log.i("@@@", "image too tall, correcting");
                    height = width * mVideoHeight / mVideoWidth;
                }
            } else if (widthSpecMode == View.MeasureSpec.EXACTLY) {
                // only the width is fixed, adjust the height to match aspect ratio if possible
                width = widthSpecSize;
                height = width * mVideoHeight / mVideoWidth;
                if (heightSpecMode == View.MeasureSpec.AT_MOST && height > heightSpecSize) {
                    // couldn't match aspect ratio within the constraints
                    height = heightSpecSize;
                }
            } else if (heightSpecMode == View.MeasureSpec.EXACTLY) {
                // only the height is fixed, adjust the width to match aspect ratio if possible
                height = heightSpecSize;
                width = height * mVideoWidth / mVideoHeight;
                if (widthSpecMode == View.MeasureSpec.AT_MOST && width > widthSpecSize) {
                    // couldn't match aspect ratio within the constraints
                    width = widthSpecSize;
                }
            } else {
                // neither the width nor the height are fixed, try to use actual video size
                width = mVideoWidth;
                height = mVideoHeight;
                if (heightSpecMode == View.MeasureSpec.AT_MOST && height > heightSpecSize) {
                    // too tall, decrease both width and height
                    height = heightSpecSize;
                    width = height * mVideoWidth / mVideoHeight;
                }
                if (widthSpecMode == View.MeasureSpec.AT_MOST && width > widthSpecSize) {
                    // too wide, decrease both width and height
                    width = widthSpecSize;
                    height = width * mVideoHeight / mVideoWidth;
                }
            }
        } else {
            // no size yet, just adopt the given spec sizes
        }

        mMeasuredWidth = width;
        mMeasuredHeight = height;
    }

    /* renamed from: a */
    public int mo17536a() {
        return this.mMeasuredWidth;
    }

    /* renamed from: b */
    public int mo17539b() {
        return this.mMeasuredHeight;
    }

    /* renamed from: b */
    public void mo17540b(int i) {
        this.f9956i = i;
    }
}
