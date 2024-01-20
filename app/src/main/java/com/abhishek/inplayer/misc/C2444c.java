package com.abhishek.inplayer.misc;

import java.util.HashMap;
import java.util.Map;

import tv.danmaku.ijk.media.player.IjkMediaMeta;


/* renamed from: com.inshot.inplayer.misc.c */
public class C2444c {

    /* renamed from: b */
    private static final Map<String, C2454a> f9821b = new HashMap();

    /* renamed from: a */
    public final IjkMediaMeta.IjkStreamMeta f9822a;

    public C2444c(IjkMediaMeta.IjkStreamMeta aVar) {
        f9821b.put("inx_name_x264", new C2454a() {
        });
        f9821b.put("inx_name_mpg", new C2454a() {
        });
        f9821b.put("inx_5name_x26", new C2454a() {
        });
        f9821b.put("inx_name_mp3", new C2454a() {
        });
        f9821b.put("inx_name_avi", new C2454a() {
        });
        f9821b.put("inx_name_mp4", new C2454a() {
        });
        f9821b.put("inx_name_rm", new C2454a() {
        });
        f9821b.put("inx_name_mkv", new C2454a() {
        });
        f9821b.put("inx_name_flv", new C2454a() {
        });
        this.f9822a = aVar;
    }

    /* renamed from: com.inshot.inplayer.misc.c$a */
    private static abstract class C2454a {
        private C2454a() {
        }
    }
}
