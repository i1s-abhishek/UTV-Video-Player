package classesdef.xdplayer;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class PermissionHelper {

    public static final String[] cameraPermission = {"android.permission.CAMERA"};


    public static final String[] STORAGE_PERMISSIONS = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    public static final String[] getAccount = {"android.permission.GET_ACCOUNTS"};

    public static boolean permissionChek(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            Log.e("PermissionUtils", "verifyPermissions-failed: grantResults == null || grantResults.length <= 0.");
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                Log.e("PermissionUtils", "verifyPermissions-failed: result != PackageManager.PERMISSION_GRANTED.");
                return false;
            }
        }
        Log.e("PermissionUtils", "verifyPermissions-success.");
        return true;
    }

    public static boolean hasPermission(Context context, String str) {
        if (!isSdkVersion23OrHigher()) {
            return true;
        }
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            return checkStoragePermissions(context);
        }
        if(hasAllFilesAccessPermission()){
            return  true;
        }
        return checkMediaPermissions(context);
    }
    private static boolean checkStoragePermissions(Context context) {
        for (String permission : STORAGE_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(context, permission) != 0) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkMediaPermissions(Context context) {
        return checkPermission(context, "android.permission.READ_MEDIA_VIDEO") &&
                checkPermission(context, "android.permission.READ_MEDIA_AUDIO");
    }
    private static boolean isSdkVersion23OrHigher() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean checkPermission(Context context, String permission) {
        return !isSdkVersion23OrHigher() || ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public static boolean canDrawOverlays(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(context);
    }
    public static boolean hasAllFilesAccessPermission() {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.R || Environment.isExternalStorageManager();
    }
    public static boolean overlayPermission(Activity activity, int i) {
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivityForResult(intent, i);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                activity.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", activity.getPackageName(), (String) null)), i);
                return true;
            } catch (ActivityNotFoundException e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public static void openAppDetailsSettings(Fragment fragment) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.getContext().getPackageName(), (String) null));
        try {
            fragment.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void manageAppFilesAccessPermission(Activity activity) {
        if (Build.VERSION.SDK_INT >= 30) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setData(Uri.fromParts("package", "hdplayer.xdplayer.videoplayer", null));

            try {
                activity.startActivityForResult(intent, 471);
            } catch (Exception e) {
                e.printStackTrace();

                try {
                    Intent fallbackIntent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                    activity.startActivityForResult(fallbackIntent, 471);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
