package com.abhishek.xplayer.fragments;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.abhishek.xplayer.activities.FileExplorerActivity;
import com.abhishek.xplayer.activities.SimpleFragmentActivity;
import com.abhishek.xplayer.application.MyApplication;

import classesdef.xdplayer.PermissionHelper;
import classesdef.xdplayer.Permissions;
import hdplayer.xdplayer.videoplayer.R;


public class AllFilesPermissionFragment extends FragmentLifecycle implements View.OnClickListener {

    /* renamed from: a */
    private boolean allPermissionsGranted;

    /* renamed from: b */
    private TextView f10718b;

    /* renamed from: c */
    private TextView f10719c;

    private TextView allPermissionButton;

    /* renamed from: d */
    private ImageView f10720d;

    /* renamed from: e */
    private boolean isResumed;

    /* renamed from: f */
    private boolean f10722f;

    /* renamed from: g */
    private boolean f10723g;

    /* renamed from: h */
    private View f10724h;

    /* renamed from: a */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10723g = true;
        this.f10722f = true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_all_files_permission, viewGroup, false);
        ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(false);
        supportActionBar.setDisplayShowHomeEnabled(false);
        supportActionBar.setSubtitle((CharSequence) null);
        supportActionBar.setTitle((int) R.string.app_name);
        setHasOptionsMenu(true);
        this.f10718b = (TextView) inflate.findViewById(R.id.permission_desc);
        this.f10719c = (TextView) inflate.findViewById(R.id.permission_button);
        this.f10720d = (ImageView) inflate.findViewById(R.id.permission_icon);
        this.allPermissionButton = (TextView) inflate.findViewById(R.id.all_permission_button);
        this.f10719c.setOnClickListener(this);
        this.allPermissionButton.setOnClickListener(this);
        if (this.f10722f) {
            inflate.setVisibility(8);
        }
        this.f10724h = inflate;
        return inflate;
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    public void onResume() {
        FileExplorerActivity.fragmentName = "Permission";
        super.onResume();
        if (!this.isResumed) {
            if (Environment.isExternalStorageManager()) {
                handleAllPermissionsGranted();
            } else if (PermissionHelper.hasPermission(MyApplication.getApplicationContext_(), "android.permission.WRITE_EXTERNAL_STORAGE")) {
                handleAllPermissionsGranted();
            } else {
                handlePermissionsDenied();
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.isResumed) {
            this.f10723g = false;
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i == 2) {
                if (PermissionHelper.permissionChek(iArr)) {
                    handleAllPermissionsGranted();
                } else {
                    handlePermissionsDenied();
                }
            }
            else if (i == 471) {
                handleAllPermissionsGranted();
            }
        }
    }

    /* renamed from: d */
    private void handlePermissionsDenied() {
        boolean shouldShowRationale;

        if (Build.VERSION.SDK_INT >= 33) {
            // Check if the app should show rationale for video and audio permissions
            shouldShowRationale = shouldShowRequestPermissionRationale("android.permission.READ_MEDIA_VIDEO") ||
                    shouldShowRequestPermissionRationale("android.permission.READ_MEDIA_AUDIO");
        } else {
            // Check if the app should show rationale for external storage permissions
            shouldShowRationale = shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE") ||
                    shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        
        this.allPermissionsGranted = !this.f10722f && shouldShowRationale;
        if (this.allPermissionsGranted) {
            this.f10718b.setVisibility(0);
            this.f10720d.setImageResource(R.mipmap.permission_setting);
            this.f10719c.setText(R.string.open_setting);
        } else {
            this.f10718b.setVisibility(8);
            this.f10720d.setImageResource(R.mipmap.permission_icon);
            this.f10719c.setText(R.string.allow);
            if (this.f10723g) {
                requestPermissions(Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"} : Permissions.StoragePermissions.READ_WRITE, 2);
            }
        }
        this.allPermissionButton.setText("Grant All Permission");
        if (!this.f10722f && this.f10724h.getVisibility() != 0) {
            this.f10724h.setVisibility(0);
        }
        this.f10723g = false;
        this.f10722f = false;
    }

    /* renamed from: e */
    private void handleAllPermissionsGranted() {
        this.isResumed = true;
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
        if (mo17989b() && view.getId() == R.id.permission_button) {
            if (this.allPermissionsGranted) {
                PermissionHelper.openAppDetailsSettings((Fragment) this);
            } else {
                requestPermissions(Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO"} : Permissions.StoragePermissions.READ_WRITE, 2);
            }
        } else if (mo17989b() && view.getId() == R.id.all_permission_button) {
            PermissionHelper.manageAppFilesAccessPermission(requireActivity());
        }
    }
}
