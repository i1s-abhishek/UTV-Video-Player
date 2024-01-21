package classesdef.inplayer;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import com.abhishek.xplayer.application.MyApplication;


import classesdef.xdplayer.axy;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: awz */
public class awz {

    /* renamed from: awz$b */
    public interface C1324b {
        /* renamed from: k */
        String mo10919k();
    }
    public static View m18242a(Context context, int i) {
        try {
            return LayoutInflater.from(context).inflate(i, (ViewGroup) null);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                return LayoutInflater.from(context).inflate(i, (ViewGroup) null);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }


    public static void m7242a(final Activity activity, boolean z, final C1324b bVar, final DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder;
        View a = m18242a((Context) activity, (int) R.layout.dialog_feedback);
        final EditText editText = (EditText) a.findViewById(R.id.suggest_feedback_et);
        if (z) {
            editText.setTextColor(-1);
            editText.setHintTextColor(1124073471);
        }
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
            builder = new AlertDialog.Builder(activity, R.style.MyAlertStyle);
        } else {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setView(a).setPositiveButton((int) R.string.feedback_submit, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String obj = editText.getText().toString();
              //  Activity activity = activity;
                String k = bVar != null ? bVar.mo10919k() : null;
                axy.m7464a(activity, obj, k, "(" + obj.length() + ")" + activity.getResources().getString(R.string.feedback_subject));
                dialogInterface.dismiss();
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        }).setNegativeButton((int) R.string.feedback_not_now, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
            }
        });
        final Button button = builder.show().getButton(-1);
        button.setEnabled(false);
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.toString().length() > 0) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
    }

    /* renamed from: c */
    public static void m7244c(Activity activity) {
        m7242a(activity, false, (C1324b) null, (DialogInterface.OnCancelListener) null);
    }


}
