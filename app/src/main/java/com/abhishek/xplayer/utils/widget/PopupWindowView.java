package com.abhishek.xplayer.utils.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import classesdef.xdplayer.axw;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.utils.widget.a */
public class PopupWindowView implements AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    private C2853a f11381a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public PopupWindow f11382b;

    /* renamed from: c */
    private C2855c f11383c;

    /* renamed from: d */
    private C2854b f11384d;

    /* renamed from: e */
    private PopupWindow.OnDismissListener f11385e;

    /* renamed from: f */
    private Context f11386f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String[] f11387g;

    /* renamed from: h */
    private int[] f11388h;

    /* renamed from: i */
    private int f11389i;

    /* renamed from: j */
    private int f11390j;

    /* renamed from: k */
    private int f11391k;

    /* renamed from: l */
    private int f11392l;

    /* renamed from: m */
    private int f11393m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f11394n;

    /* renamed from: o */
    private View f11395o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f11396p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f11397q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f11398r;

    /* renamed from: com.inshot.xplayer.utils.widget.a$b */
    public interface C2854b {
        /* renamed from: a */
        boolean mo18336a(int i, int i2);
    }

    /* renamed from: com.inshot.xplayer.utils.widget.a$c */
    public interface C2855c {
        /* renamed from: a */
        void mo17620a(int i, int i2, int i3);
    }

    public PopupWindowView(Context context, String[] strArr, int i) {
        this(context, strArr, (int[]) null, i, 0);
    }

    public PopupWindowView(Context context, String[] strArr, int[] iArr, int i, int i2) {
        this.f11389i = -1;
        this.f11394n = 0;
        this.f11396p = -1;
        this.f11397q = -1;
        this.f11398r = -1;
        this.f11386f = context;
        if (strArr == null || strArr.length <= 0) {
            throw new IllegalArgumentException("MenuArray must more than 0");
        }
        this.f11387g = strArr;
        this.f11388h = iArr;
        this.f11390j = i;
        this.f11393m = i2;
    }

    /* renamed from: a */
    public void mo18325a(C2855c cVar) {
        this.f11383c = cVar;
    }

    /* renamed from: a */
    private PopupWindow m12927a(int i) {
        this.f11391k = i;
        ListView listView = new ListView(this.f11386f);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        listView.setVerticalScrollBarEnabled(false);
        listView.setFastScrollEnabled(false);
        listView.setCacheColorHint(0);
        listView.setHeaderDividersEnabled(false);
        if (this.f11395o != null) {
            listView.addHeaderView(this.f11395o, (Object) null, false);
        }
        this.f11382b = new PopupWindow(listView, this.f11391k, -2, true);
        this.f11382b.setOutsideTouchable(true);
        this.f11382b.setTouchable(true);
        this.f11382b.setFocusable(true);
        this.f11382b.setClippingEnabled(false);
        if (this.f11385e != null) {
            this.f11382b.setOnDismissListener(this.f11385e);
        }
        if (this.f11390j == 0) {
            this.f11382b.setBackgroundDrawable(this.f11386f.getResources().getDrawable(R.drawable.bg_popmenu_white));
            listView.setDivider(this.f11386f.getResources().getDrawable(R.color.divider_glay));
        } else {
            this.f11382b.setBackgroundDrawable(this.f11386f.getResources().getDrawable(R.drawable.bg_popmenu_black));
            listView.setDivider(this.f11386f.getResources().getDrawable(R.color.listview_divider_color));
        }
        if (this.f11381a == null) {
            this.f11381a = new C2853a(this.f11386f, this.f11390j);
        }
        listView.setDividerHeight(1);
        listView.setAdapter(this.f11381a);
        listView.setOnItemClickListener(this);
        listView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f11392l = this.f11381a.getCount() * (listView.getDividerHeight() + axw.m7444a(this.f11386f, 45.0f));
        if (this.f11395o != null) {
            this.f11392l += this.f11395o.getMeasuredHeight();
        }
        return this.f11382b;
    }

    /* renamed from: a */
    public void mo18322a(View view, int i) {
        mo18323a(view, i, 0, 0);
    }

    /* renamed from: a */
    public void mo18323a(View view, int i, int i2, int i3) {
        mo18324a(view, i, i2, i3, this.f11386f.getResources().getDimensionPixelSize(R.dimen.popupmenu_width));
    }

    /* renamed from: a */
    public void mo18324a(View view, int i, int i2, int i3, int i4) {
        if (this.f11382b == null) {
            this.f11382b = m12927a(i4);
        }
        if (view != null) {
            int width = view.getWidth();
            final int height = view.getHeight();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            view.getGlobalVisibleRect(rect);
            view.getWindowVisibleDisplayFrame(rect2);
            int a = axw.m7445a(this.f11386f.getResources());
            int i5 = rect.bottom;
            int i6 = rect.left;
            int i7 = rect.bottom - rect.top;
            if (rect.top < this.f11392l * 2) {
                this.f11393m = 0;
            }
            if (this.f11393m == 0 && i7 < height) {
                i5 += height - i7;
            }
            while (i6 + i2 + this.f11391k > rect2.right) {
                i2 -= width / 4;
            }
            if (this.f11393m == 1) {
                final View contentView = this.f11382b.getContentView();
                if (contentView != null) {
                    final View view2 = view;
                    final int i8 = i2;
                    contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            PopupWindowView.this.f11382b.update(view2, i8, -(height + ((int) (((float) contentView.getHeight()) * 1.25f))), PopupWindowView.this.f11382b.getWidth(), PopupWindowView.this.f11382b.getHeight());
                            contentView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        }
                    });
                }
            } else {
                while (i5 + i3 + this.f11392l > rect2.bottom - a) {
                    i3 -= height / 4;
                }
            }
            this.f11382b.showAsDropDown(view, i2, i3);
        }
        this.f11389i = i;
    }

    /* renamed from: a */
    public void mo18321a() {
        if (mo18326b()) {
            this.f11382b.dismiss();
        }
    }

    /* renamed from: b */
    public boolean mo18326b() {
        return this.f11382b != null && this.f11382b.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != this.f11398r || !(view.getTag() instanceof CheckBox)) {
            if (this.f11383c != null) {
                if (adapterView instanceof ListView) {
                    i -= ((ListView) adapterView).getHeaderViewsCount();
                }
                this.f11383c.mo17620a(i, this.f11388h == null ? i : this.f11388h[i], this.f11389i);
            }
            mo18321a();
            return;
        }
        ((CheckBox) view.getTag()).toggle();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f11384d != null) {
            if (compoundButton.getTag() instanceof CheckedTextView) {
                ((CheckedTextView) compoundButton.getTag()).setChecked(z);
            }
            int intValue = ((Integer) compoundButton.getTag(R.id.tagID_int)).intValue();
            if (this.f11384d.mo18336a(intValue, this.f11388h == null ? intValue : this.f11388h[intValue])) {
                return;
            }
        }
        mo18321a();
    }

    /* renamed from: com.inshot.xplayer.utils.widget.a$a */
    private class C2853a extends BaseAdapter {

        /* renamed from: b */
        private Context f11405b;

        /* renamed from: c */
        private int f11406c;

        public long getItemId(int i) {
            return (long) i;
        }

        private C2853a(Context context, int i) {
            this.f11405b = context;
            this.f11406c = i;
        }

        public int getCount() {
            if (PopupWindowView.this.f11387g != null) {
                return PopupWindowView.this.f11387g.length;
            }
            return 0;
        }

        public Object getItem(int i) {
            if (PopupWindowView.this.f11387g != null) {
                return PopupWindowView.this.f11387g[i];
            }
            return null;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = false;
            if (view == null) {
                if (PopupWindowView.this.f11397q == -1) {
                    switch (this.f11406c) {
                        case 0:
                            int unused = PopupWindowView.this.f11397q = R.layout.popup_black_items;
                            break;
                        case 1:
                            int unused2 = PopupWindowView.this.f11397q = R.layout.popup_white_items;
                            break;
                    }
                }
                view = LayoutInflater.from(this.f11405b).inflate(PopupWindowView.this.f11398r == i ? R.layout.popup_white_checkbox_items : PopupWindowView.this.f11397q, viewGroup, false);
            }
            String str = PopupWindowView.this.f11387g[i];
            if (!(view == null || str == null)) {
                TextView textView = (TextView) view.findViewById(R.id.popup_item);
                if (PopupWindowView.this.f11394n != 0) {
                    textView.setTextColor(PopupWindowView.this.f11394n);
                }
                textView.setText(str);
                if (PopupWindowView.this.f11398r == i) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkbox);
                    view.setTag(checkBox);
                    checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                    checkBox.setChecked(PopupWindowView.this.f11396p == i);
                    CheckedTextView checkedTextView = (CheckedTextView) textView;
                    if (PopupWindowView.this.f11396p == i) {
                        z = true;
                    }
                    checkedTextView.setChecked(z);
                    checkBox.setTag(R.id.tagID_int, Integer.valueOf(i));
                    checkBox.setOnCheckedChangeListener(PopupWindowView.this);
                    checkBox.setTag(textView);
                    return view;
                }
                if (PopupWindowView.this.f11396p != -1 && (textView instanceof Checkable)) {
                    if (textView instanceof CompoundButton) {
                        ((CompoundButton) textView).setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                    }
                    Checkable checkable = (Checkable) textView;
                    if (i == PopupWindowView.this.f11396p) {
                        z = true;
                    }
                    checkable.setChecked(z);
                }
                textView.setTag(R.id.tagID_int, Integer.valueOf(i));
                if (textView instanceof CompoundButton) {
                    ((CompoundButton) textView).setOnCheckedChangeListener(PopupWindowView.this);
                }
            }
            return view;
        }

        public int getViewTypeCount() {
            return PopupWindowView.this.f11398r != -1 ? 2 : 1;
        }

        public int getItemViewType(int i) {
            return PopupWindowView.this.f11398r != i ? 1 : 0;
        }
    }
}
