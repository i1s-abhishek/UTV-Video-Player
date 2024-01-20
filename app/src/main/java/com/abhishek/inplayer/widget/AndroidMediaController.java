package com.abhishek.inplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;

import androidx.appcompat.app.ActionBar;

import java.util.ArrayList;
import java.util.Iterator;

public class AndroidMediaController extends MediaController implements C2476b {

    /* renamed from: a */
    private ActionBar f9834a;

    /* renamed from: b */
    private ArrayList<View> f9835b = new ArrayList<>();

    /* renamed from: a */
    private void m11157a(Context context) {
    }

    public AndroidMediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11157a(context);
    }

    public void setSupportActionBar(ActionBar actionBar) {
        this.f9834a = actionBar;
        if (isShowing()) {
            actionBar.show();
        } else {
            actionBar.hide();
        }
    }

    public void show() {
        super.show();
        if (this.f9834a != null) {
            this.f9834a.show();
        }
    }

    public void hide() {
        super.hide();
        if (this.f9834a != null) {
            this.f9834a.hide();
        }
        Iterator<View> it = this.f9835b.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        this.f9835b.clear();
    }
}
