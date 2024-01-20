package com.cc.promote.effects;

import java.util.Random;

/* renamed from: com.cc.promote.effects.c */
public class C1453c {

    /* renamed from: a */
    private static final Random f6536a = new Random();

    /* renamed from: a */
    public float mo11395a(float f) {
        return f6536a.nextFloat() * f;
    }

    /* renamed from: a */
    public float mo11396a(float f, float f2) {
        float min = Math.min(f, f2);
        return min + mo11395a(Math.max(f, f2) - min);
    }

    /* renamed from: a */
    public int mo11397a(int i) {
        return f6536a.nextInt(i);
    }
}
