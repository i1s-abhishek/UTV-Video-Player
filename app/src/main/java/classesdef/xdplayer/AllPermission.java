package classesdef.xdplayer;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

public class AllPermission {

    public static final String[] cameraPermission = {"android.permission.CAMERA"};


    public static final String[] writeExternalPermissiom = {"android.permission.WRITE_EXTERNAL_STORAGE"};

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

    public static boolean m7381a(Context context, String str) {
        if (sdkVersion() && ActivityCompat.checkSelfPermission(context, str) != 0) {
            return false;
        }
        return true;
    }

    private static boolean sdkVersion() {
        return Build.VERSION.SDK_INT >= 23;
    }


    public static boolean canDrawOverlays(Context context) {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays(context);
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

    public static void m7377a(Fragment fragment) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", fragment.getContext().getPackageName(), (String) null));
        try {
            fragment.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
