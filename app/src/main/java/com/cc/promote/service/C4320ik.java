package com.cc.promote.service;

import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;

/* renamed from: ik */
public class C4320ik {
    /* renamed from: a */
    public float mo23985a(String str) {
        try {
            StatFs statFs = new StatFs(str);
            float freeBlocks = ((float) ((((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)) / 1024.0f;
            if (freeBlocks > 0.0f) {
                return freeBlocks;
            }
            return 100.0f;
        } catch (Exception e) {
            e.printStackTrace();
            return 100.0f;
        } catch (Error e2) {
            e2.printStackTrace();
            return 100.0f;
        }
    }
}
