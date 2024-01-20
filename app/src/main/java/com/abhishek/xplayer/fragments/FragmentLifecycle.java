package com.abhishek.xplayer.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

/* renamed from: com.inshot.xplayer.fragments.a */
public abstract class FragmentLifecycle extends Fragment {

    /* renamed from: a */
    private boolean f10657a;

    /* renamed from: b */
    private boolean f10658b = false;

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f10657a = false;
    }

    public void onDetach() {
        this.f10657a = true;
        super.onDetach();
    }

    /* renamed from: b */
    public boolean mo17989b() {
        return !this.f10657a && getActivity() != null && !getActivity().isFinishing();
    }

    public void onStart() {
        super.onStart();
        this.f10658b = false;
    }

    public void onStop() {
        this.f10658b = true;
        super.onStop();
    }

    public void onResume() {
        this.f10658b = false;
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.f10658b = true;
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo17990c() {
        return this.f10658b;
    }
}
