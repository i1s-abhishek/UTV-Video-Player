package com.abhishek.xplayer.subtitle;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.abhishek.inplayer.misc.C2444c;
import com.abhishek.inplayer.widget.C2481e;
import com.abhishek.inplayer.widget.XVideoView;
import com.abhishek.xplayer.application.MyApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import classesdef.inplayer.axi;
import classesdef.xdplayer.axw;
import classesdef.xdplayer.axy;
import hdplayer.xdplayer.videoplayer.R;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;


/* renamed from: com.inshot.xplayer.subtitle.g */
public class C2840g {

    /* renamed from: a */
    private boolean f11285a;

    /* renamed from: b */
    private boolean f11286b;

    /* renamed from: c */
    private XVideoView f11287c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Boolean f11288d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f11289e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<C2843a> f11290f;

    /* renamed from: com.inshot.xplayer.subtitle.g$b */
    public interface C2844b {
        /* renamed from: a */
        void mo17598a(boolean z, int i);
    }

    public C2840g(XVideoView xVideoView) {
        this.f11287c = xVideoView;
    }

    /* renamed from: a */
    public void mo18254a() {
        this.f11288d = false;
    }

    /* renamed from: a */
    public void mo18256a(boolean z) {
        if (z) {
            this.f11288d = true;
            m12851h();
            if (this.f11290f != null && this.f11290f.size() == 1) {
                this.f11289e = this.f11290f.get(0).f11302b;
                return;
            }
            return;
        }
        this.f11289e = MyApplication.getApplicationContext_().getString(R.string.none);
    }

    /* renamed from: b */
    public void mo18257b() {
        if (!this.f11285a) {
            this.f11285a = true;
            if (this.f11288d == null) {
                this.f11288d = Boolean.valueOf(m12850g());
            }
        }
    }

    /* renamed from: c */
    public boolean mo18258c() {
        return Boolean.TRUE.equals(this.f11288d);
    }

    /* renamed from: d */
    public int mo18259d() {
        return this.f11287c.mo17483d(3);
    }

    /* renamed from: e */
    public int mo18260e() {
        m12851h();
        if (this.f11290f == null || this.f11290f.isEmpty()) {
            return -1;
        }
        return this.f11290f.get(0).f11303c;
    }

    /* renamed from: f */
    public boolean mo18261f() {
        m12851h();
        return this.f11290f != null && !this.f11290f.isEmpty();
    }

    /* renamed from: a */
    public PopupWindow mo18253a(View view, String str, boolean z, View.OnClickListener onClickListener) {
        String str2 = str;
        View.OnClickListener onClickListener2 = onClickListener;
        m12851h();
        String str3 = null;
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_subtitle_menu, (ViewGroup) null, false);
        PopupWindow popupWindow = new PopupWindow(inflate, axw.m7444a(view.getContext(), 300.0f), -2, true);
        TextView textView = (TextView) inflate.findViewById(R.id.subtitle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.subtitle_open_from);
        TextView textView3 = (TextView) inflate.findViewById(R.id.subtitle_download);
        TextView textView4 = (TextView) inflate.findViewById(R.id.subtitle_adjust);
        TextView textView5 = (TextView) inflate.findViewById(R.id.subtitle_personality);
        TextView textView6 = (TextView) inflate.findViewById(R.id.subtitle_select);
        textView6.setOnClickListener(onClickListener2);
        textView2.setOnClickListener(onClickListener2);
        textView3.setOnClickListener(onClickListener2);
        textView4.setOnClickListener(onClickListener2);
        textView5.setOnClickListener(onClickListener2);
        int size = this.f11290f != null ? this.f11290f.size() + 0 : 0;
        if (str2 != null) {
            size++;
        }
        if (size > 0) {
            if (mo18258c()) {
                str3 = this.f11289e;
            } else if (z) {
                str3 = axy.m7461a(str2, (String) null);
            }
            if (str3 == null) {
                str3 = view.getResources().getString(R.string.none);
            }
            textView.setText(str3);
            if (size == 1) {
                if (str2 == null) {
                    textView6.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView5.setVisibility(View.VISIBLE);
                    if (this.f11290f.get(0).f11303c == mo18259d()) {
                        textView6.setText(R.string.subtitle_turn_off);
                        textView6.setId(R.id.subtitle_turn_off);
                    } else {
                        textView6.setText(R.string.subtitle_turn_on);
                        textView6.setId(R.id.subtitle_turn_on);
                    }
                } else if (z) {
                    textView6.setText(R.string.subtitle_turn_off);
                    textView6.setId(R.id.subtitle_turn_off);
                    textView6.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView4.setVisibility(View.VISIBLE);
                    textView5.setVisibility(View.VISIBLE);
                } else {
                    textView6.setText(R.string.subtitle_turn_on);
                    textView6.setId(R.id.subtitle_turn_on);
                    textView6.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.VISIBLE);
                    textView5.setVisibility(View.VISIBLE);
                }
            } else if (mo18258c()) {
                textView6.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
            } else {
                textView6.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView3.setVisibility(View.VISIBLE);
                textView4.setVisibility(View.VISIBLE);
                textView5.setVisibility(View.VISIBLE);
            }
        } else {
            textView.setText(R.string.none);
            textView2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
        }
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        return popupWindow;
    }

    /* renamed from: a */
    public void mo18255a(Context context, String str, boolean z, C2844b bVar, C2481e eVar) {
        int i;
        Context context2 = context;
        final String str2 = str;
        final ArrayList arrayList = new ArrayList(this.f11290f.size() + 2);
        arrayList.add(context2.getString(R.string.none));
        int d = mo18259d();
        int i2 = 1;
        int i3 = 0;
        for (C2843a next : this.f11290f) {
            if (d == next.f11303c) {
                i3 = i2;
            }
            arrayList.add(next.f11302b);
            i2++;
        }
        if (str2 != null) {
            arrayList.add(str2);
            if (z && !mo18258c()) {
                i = i2;
                final boolean a = eVar.mo17544a();
                final int i4 = i;
                final C2844b bVar2 = bVar;
                final boolean z2 = a;
                final C2481e eVar2 = eVar;
                final C2481e eVar3 = eVar;
                new AlertDialog.Builder(context2).setTitle((int) R.string.select_subtitle).setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[arrayList.size()]), i, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i4 != i) {
                            if (bVar2 != null) {
                                if (i == 0) {
                                    bVar2.mo17598a(true, -1);
                                    String unused = C2840g.this.f11289e = MyApplication.getApplicationContext_().getString(R.string.none);
                                    Boolean unused2 = C2840g.this.f11288d = true;
                                } else if (str2 == null || i != arrayList.size() - 1) {
                                    int i2 = i - 1;
                                    if (i2 < C2840g.this.f11290f.size()) {
                                        C2843a aVar = (C2843a) C2840g.this.f11290f.get(i2);
                                        bVar2.mo17598a(true, aVar.f11303c);
                                        String unused3 = C2840g.this.f11289e = aVar.f11302b;
                                        Boolean unused4 = C2840g.this.f11288d = true;
                                    }
                                } else {
                                    bVar2.mo17598a(false, -1);
                                    Boolean unused5 = C2840g.this.f11288d = false;
                                }
                            }
                            if (z2) {
                                eVar2.mo17543a(2);
                            }
                            dialogInterface.dismiss();
                            return;
                        }
                        dialogInterface.cancel();
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        if (a) {
                            eVar3.mo17543a(0);
                        }
                    }
                }).show();
            }
        }
        i = i3;
        final boolean a2 = eVar.mo17544a();
        final int i42 = i;
        final C2844b bVar22 = bVar;
        final boolean z22 = a2;
        final C2481e eVar22 = eVar;
        final C2481e eVar32 = eVar;
        new AlertDialog.Builder(context2).setTitle((int) R.string.select_subtitle).setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[arrayList.size()]), i, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i42 != i) {
                    if (bVar22 != null) {
                        if (i == 0) {
                            bVar22.mo17598a(true, -1);
                            String unused = C2840g.this.f11289e = MyApplication.getApplicationContext_().getString(R.string.none);
                            Boolean unused2 = C2840g.this.f11288d = true;
                        } else if (str2 == null || i != arrayList.size() - 1) {
                            int i2 = i - 1;
                            if (i2 < C2840g.this.f11290f.size()) {
                                C2843a aVar = (C2843a) C2840g.this.f11290f.get(i2);
                                bVar22.mo17598a(true, aVar.f11303c);
                                String unused3 = C2840g.this.f11289e = aVar.f11302b;
                                Boolean unused4 = C2840g.this.f11288d = true;
                            }
                        } else {
                            bVar22.mo17598a(false, -1);
                            Boolean unused5 = C2840g.this.f11288d = false;
                        }
                    }
                    if (z22) {
                        eVar22.mo17543a(2);
                    }
                    dialogInterface.dismiss();
                    return;
                }
                dialogInterface.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (a2) {
                    eVar32.mo17543a(0);
                }
            }
        }).show();
    }

    /* renamed from: g */
    private boolean m12850g() {
        if (mo18259d() != -1) {
            return true;
        }
        m12851h();
        if (this.f11290f == null || this.f11290f.isEmpty()) {
            return false;
        }
        return true;
    }

    /* renamed from: h */
    private void m12851h() {
        if (!this.f11286b) {
            Log.e("abhi_render","abhi_ 1 eroor vala 1 ");
            ITrackInfo[] trackInfo = this.f11287c.getTrackInfo();
            if (trackInfo != null) {
                int d = mo18259d();
                this.f11290f = new ArrayList(2);
                String string = MyApplication.getApplicationContext_().getString(R.string.subtitle);
                int i = 1;
                int i2 = 0;
                for (ITrackInfo bVar : trackInfo) {
                    if (bVar.getTrackType() == 3) {
                        Log.e("abhi_render","abhi_ 1 eroor vala 2 ");
                        if (C2845h.m12867a(((C2444c) bVar.getFormat()).f9822a.mCodecName)) {
                            Log.e("abhi_render","abhi_ 1 eroor vala 3 ");
                            C2843a aVar = new C2843a();
                            int i3 = i + 1;
                            String unused = aVar.f11302b = String.format(Locale.ENGLISH, "%s #%d - %s", new Object[]{string, Integer.valueOf(i), axi.m7361d(bVar.getLanguage())});
                            int unused2 = aVar.f11303c = i2;
                            this.f11290f.add(aVar);
                            if (d == i2) {
                                this.f11289e = aVar.f11302b;
                            }
                            i = i3;
                        } else if (d == i2) {
                            this.f11287c.mo17479c(d);
                        }
                    }
                    i2++;
                }
            }
            this.f11286b = true;
        }
    }

    /* renamed from: com.inshot.xplayer.subtitle.g$a */
    private class C2843a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f11302b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f11303c;

        private C2843a() {
        }
    }
}
