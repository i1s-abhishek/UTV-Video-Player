package com.us.rateus.general;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import hdplayer.xdplayer.videoplayer.R;


public class RatingTheme extends AlertDialog {

    protected RatingTheme(@NonNull Context context) {
        super(context);
    }

    /* renamed from: bay$a */
    public static class C3942a extends AlertDialog.Builder {
        public C3942a(Context context) {
            super(context, R.style.lib_v7_alert_dialog_theme);
        }
    }
}
