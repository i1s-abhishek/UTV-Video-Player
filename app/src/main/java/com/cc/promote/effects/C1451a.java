package com.cc.promote.effects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.cc.promote.effects.a */
public class C1451a {

    /* renamed from: a */
    private ArrayList<Bitmap> f6532a = new ArrayList<>();

    public C1451a(Context context, int[] iArr) {
        m8041a(context, iArr);
    }

    /* renamed from: a */
    public int mo11390a() {
        return this.f6532a.size();
    }

    /* renamed from: a */
    public Bitmap mo11391a(int i) {
        return this.f6532a.get(i);
    }

    /* renamed from: a */
    private void m8041a(Context context, int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalStateException("You must declare the resources");
        }
        mo11392b();
        for (int decodeResource : iArr) {
            try {
                this.f6532a.add(BitmapFactory.decodeResource(context.getResources(), decodeResource));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void mo11392b() {
        Iterator<Bitmap> it = this.f6532a.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.f6532a.clear();
    }
}
