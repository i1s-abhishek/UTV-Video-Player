package com.abhishek.inplayer.misc;

public interface IAndroidIO {
    int close();

    int open(String str);

    int read(byte[] bArr, int i);

    long seek(long j, int i);
}
