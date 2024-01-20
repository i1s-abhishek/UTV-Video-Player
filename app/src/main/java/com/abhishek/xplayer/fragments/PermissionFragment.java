package com.abhishek.xplayer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.activities.SimpleFragmentActivity;
import com.abhishek.xplayer.application.MyApplication;

import classesdef.xdplayer.AllPermission;
import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: com.inshot.xplayer.fragments.e */
public class PermissionFragment extends FragmentLifecycle implements View.OnClickListener {

    /* renamed from: a */
    private boolean f10717a;

    /* renamed from: b */
    private TextView f10718b;

    /* renamed from: c */
    private TextView f10719c;

    /* renamed from: d */
    private ImageView f10720d;

    /* renamed from: e */
    private boolean f10721e;

    /* renamed from: f */
    private boolean f10722f;

    /* renamed from: g */
    private boolean f10723g;

    /* renamed from: h */
    private View f10724h;

    /* renamed from: a */
    public static PermissionFragment m12280a() {
        return new PermissionFragment();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10723g = true;
        this.f10722f = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_permission, viewGroup, false);
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(false);
        supportActionBar.setDisplayShowHomeEnabled(false);
        supportActionBar.setSubtitle((CharSequence) null);
        supportActionBar.setTitle((int) R.string.app_name);
        setHasOptionsMenu(true);
        this.f10718b = (TextView) inflate.findViewById(R.id.permission_desc);
        this.f10719c = (TextView) inflate.findViewById(R.id.permission_button);
        this.f10720d = (ImageView) inflate.findViewById(R.id.permission_icon);
        this.f10719c.setOnClickListener(this);
        if (this.f10722f) {
            inflate.setVisibility(8);
        }
        this.f10724h = inflate;
        return inflate;
    }

    public void onResume() {
        FileExplorerActivity.fragmentName = "Permission";
        super.onResume();
        if (!this.f10721e) {
            if (AllPermission.m7381a(MyApplication.getApplicationContext_(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                m12282e();
            } else {
                m12281d();
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.f10721e) {
            this.f10723g = false;
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i != 2) {
                return;
            }
            if (AllPermission.permissionChek(iArr)) {
                m12282e();
            } else {
                m12281d();
            }
        }
    }

    /* renamed from: d */
    private void m12281d() {
        this.f10717a = !this.f10722f && !shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.f10717a) {
            this.f10718b.setVisibility(0);
            this.f10720d.setImageResource(R.mipmap.permission_setting);
            this.f10719c.setText(R.string.open_setting);
        } else {
            this.f10718b.setVisibility(8);
            this.f10720d.setImageResource(R.mipmap.permission_icon);
            this.f10719c.setText(R.string.allow);
            if (this.f10723g) {
                requestPermissions(AllPermission.writeExternalPermissiom, 2);
            }
        }
        if (!this.f10722f && this.f10724h.getVisibility() != 0) {
            this.f10724h.setVisibility(0);
        }
        this.f10723g = false;
        this.f10722f = false;
    }

    /* renamed from: e */
    private void m12282e() {
        this.f10721e = true;
        FragmentActivity activity = getActivity();
        if (activity instanceof FileExplorerActivity) {
            ((FileExplorerActivity) activity).setTheme();
        } else if (activity instanceof SimpleFragmentActivity) {
            ((SimpleFragmentActivity) activity).setTheme();
        } else if (activity != null) {
            activity.finish();
        }
    }

    public void onClick(View view) {
        if (!mo17989b() || view.getId() != R.id.permission_button) {
            return;
        }
        if (this.f10717a) {
            AllPermission.m7377a((Fragment) this);
        } else {
            requestPermissions(AllPermission.writeExternalPermissiom, 2);
        }
    }
}
