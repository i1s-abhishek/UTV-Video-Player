package com.abhishek.inplayer.widget;

import android.content.ContentResolver;
import android.net.Uri;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* renamed from: com.inshot.inplayer.widget.a */
public class C2475a implements IMediaDataSource {

    /* renamed from: a */
    private ContentResolver f9943a;

    /* renamed from: b */
    private Uri f9944b;

    /* renamed from: c */
    private InputStream f9945c;

    /* renamed from: d */
    private int f9946d;

    /* renamed from: e */
    private long f9947e;

    public C2475a(ContentResolver contentResolver, Uri uri) {
        this.f9944b = uri;
        this.f9943a = contentResolver;
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        m11263a();
        if (this.f9945c == null) {
            return 0;
        }
        if (j < this.f9947e) {
            this.f9947e = 0;
            try {
                this.f9945c.close();
            } catch (IOException unused) {
            }
            this.f9945c = null;
            m11263a();
        }
        if (j > this.f9947e) {
            try {
                this.f9945c.skip(j - this.f9947e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int read = 0;
        try {
            read = this.f9945c.read(bArr, i, i2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f9947e = ((long) read) + j;
        return read;
    }

    public long getSize() {
        m11263a();
        return (long) this.f9946d;
    }

    public void close() {
        if (this.f9945c != null) {
            try {
                this.f9945c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f9945c = null;
        this.f9943a = null;
        this.f9944b = null;
    }

    /* renamed from: a */
    private void m11263a() {
        if (this.f9945c == null) {
            try {
                this.f9945c = this.f9943a.openInputStream(this.f9944b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (this.f9945c != null) {
                try {
                    this.f9946d = this.f9945c.available();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
