package classesdef.player;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.abhishek.inplayer.widget.XVideoView;
import com.abhishek.xplayer.content.RecentMediaStorage;
import com.abhishek.xplayer.subtitle.C2822c;

import java.util.Locale;

import classesdef.xdplayer.axy;
import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: awo */
public class awo implements TextWatcher, View.OnTouchListener {

    /* renamed from: a */
    private View f6093a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f6094b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f6095c;

    /* renamed from: d */
    private Handler f6096d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Activity f6097e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f6098f;

    /* renamed from: g */
    private int f6099g;

    /* renamed from: h */
    private C2822c f6100h;

    /* renamed from: i */
    private XVideoView f6101i;

    /* renamed from: j */
    private RecentMediaStorage.ExInfo f6102j;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public awo(Activity activity) {
        this.f6097e = activity;
        this.f6096d = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                String str;
                if (!awo.this.f6095c && awo.this.f6097e != null && !awo.this.f6097e.isFinishing()) {
                    switch (message.what) {
                        case 6:
                        case 12:
                            awo.this.mo10862a();
                            return;
                        case 7:
                        case 13:
                            if (awo.this.f6094b != null) {
                                float round = ((float) (Math.round(axy.m7458a((CharSequence) awo.this.f6094b.getText(), 0.0f) * 1000.0f) + message.arg1)) / 1000.0f;
                                EditText c = awo.this.f6094b;
                                if (awo.this.f6098f) {
                                    str = String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(round)});
                                } else {
                                    str = String.valueOf(round);
                                }
                                c.setText(str);
                                sendMessageDelayed(obtainMessage(message.what, message.arg1, message.arg2), 100);
                                awo.this.m7163c();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    /* renamed from: a */
    public void mo10863a(C2822c cVar) {
        this.f6098f = false;
        this.f6100h = cVar;
        if (cVar != null) {
            this.f6099g = 100;
            m7159a(((float) cVar.mo18213a()) / 1000.0f);
        }
    }

    /* renamed from: a */
    public void mo10862a() {
        this.f6096d.removeMessages(6);
        this.f6096d.removeMessages(12);
        if (this.f6093a != null && this.f6093a.getVisibility() != 8) {
            this.f6093a.setVisibility(8);
            if (this.f6094b != null) {
                ((InputMethodManager) this.f6094b.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f6094b.getWindowToken(), 2);
            }
        }
    }

    /* renamed from: b */
    public void mo10865b() {
        this.f6100h = null;
        this.f6095c = true;
        this.f6096d.removeCallbacksAndMessages((Object) null);
        this.f6096d = null;
        this.f6097e = null;
        this.f6101i = null;
    }

    /* renamed from: a */
    private void m7159a(float f) {
        mo10862a();
        if (this.f6093a == null) {
            this.f6093a = ((ViewStub) this.f6097e.findViewById(R.id.layout_subtitle_sync_stub)).inflate().findViewById(R.id.adjust_subtitle_layout);
            this.f6094b = (EditText) this.f6093a.findViewById(R.id.adjust_text);
            this.f6093a.findViewById(R.id.adjust_close).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    awo.this.mo10862a();
                }
            });
            View findViewById = this.f6093a.findViewById(R.id.adjust_add);
            View findViewById2 = this.f6093a.findViewById(R.id.adjust_reduce);
            findViewById.setOnTouchListener(this);
            findViewById2.setOnTouchListener(this);
            findViewById.setLongClickable(true);
            findViewById2.setLongClickable(true);
            findViewById.setClickable(true);
            findViewById2.setClickable(true);
            this.f6094b.addTextChangedListener(this);
        }
        this.f6094b.setText(String.valueOf(f));
        this.f6093a.setVisibility(0);
        m7163c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7163c() {
        int i = 6;
        this.f6096d.removeMessages(this.f6098f ? 12 : 6);
        if (this.f6093a != null && this.f6093a.getVisibility() == 0) {
            Handler handler = this.f6096d;
            if (this.f6098f) {
                i = 12;
            }
            handler.sendEmptyMessageDelayed(i, 12000);
        }
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f6095c) {
            float a = axy.m7458a((CharSequence) this.f6094b.getText(), Float.NaN);
            if (this.f6098f) {
                if (this.f6101i != null) {
                    if (Float.isNaN(a)) {
                        a = 0.0f;
                    }
                    if (a != this.f6101i.getAudioDelay()) {
                        this.f6101i.setAudioDelay(a);
                        if (this.f6102j != null) {
                            this.f6102j.f10544i = a;
                        }
                    }
                }
            } else if (this.f6100h != null && !Float.isNaN(a)) {
                this.f6100h.mo18215a(Math.round(a * 1000.0f));
            }
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f6095c) {
            return true;
        }
        int i = 7;
        switch (motionEvent.getAction()) {
            case 0:
                Handler handler = this.f6096d;
                if (this.f6098f) {
                    i = 13;
                }
                handler.obtainMessage(i, view.getId() == R.id.adjust_add ? this.f6099g : -this.f6099g, 0).sendToTarget();
                view.setPressed(true);
                break;
            case 1:
            case 3:
            case 4:
                Handler handler2 = this.f6096d;
                if (this.f6098f) {
                    i = 13;
                }
                handler2.removeMessages(i);
                view.setPressed(false);
                break;
        }
        return true;
    }
}
