package com.us.rateus;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;

import com.us.rateus.general.RateConstant;
import com.us.rateus.general.RatingTheme;
import com.us.rateus.general.RatingInterface;

import hdplayer.vlcplayer.videoplayer.R;

public class FeedbackDailog {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo20089a(Context context, RateConstant avo, RatingInterface avq) {
        Context context2 = context;
        final RatingInterface avq2 = avq;
        if (avq2 != null) {
            try {
                avq2.mo23215a("AppRate_new", "DoNotLike", "");
            } catch (Exception e) {
                if (avq2 != null) {
                    avq2.mo23216a((Throwable) e);
                }
                e.printStackTrace();
                return;
            }
        }
        RatingTheme.C3942a aVar = new RatingTheme.C3942a(context2);
        View inflate = LayoutInflater.from(context).inflate(R.layout.lib_rate_dialog_feedback, (ViewGroup) null);
        aVar.setView(inflate);
        final AlertDialog b = aVar.create();
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.feedback_option_1);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.feedback_option_2);
        CheckBox checkBox3 = (CheckBox) inflate.findViewById(R.id.feedback_option_3);
        CheckBox checkBox4 = (CheckBox) inflate.findViewById(R.id.feedback_option_4);
        Button button = (Button) inflate.findViewById(R.id.btn_cancel);
        button.setText(context2.getString(R.string.lib_rate_btn_cancel).toUpperCase());
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RatingInterface avq = avq2;
                if (avq != null) {
                    avq.mo23214a(3);
                    avq2.mo23215a("AppRate_new", "DoNotLike", "NoFeedback");
                }
                b.dismiss();
            }
        });
        Button button2 = (Button) inflate.findViewById(R.id.btn_submit);
        button2.setText(context2.getString(R.string.lib_rate_btn_submit).toUpperCase());
        final RatingInterface avq3 = avq;

        final CheckBox checkBox5 = checkBox;
        CheckBox checkBox6 = checkBox;
        Button button3 = button2;
        final CheckBox checkBox7 = checkBox2;
        Button button4 = button;
        final CheckBox checkBox8 = checkBox3;
        CheckBox checkBox9 = (CheckBox) inflate.findViewById(R.id.feedback_option_5);
        final CheckBox checkBox10 = checkBox4;
        CheckBox checkBox11 = checkBox4;
        final CheckBox checkBox12 = checkBox9;
        CheckBox checkBox13 = checkBox3;
        final AlertDialog aVar2 = b;
        View.OnClickListener r1 = new View.OnClickListener() {
            public void onClick(View view) {
                RatingInterface avq = avq3;
                if (avq != null) {
                    avq.mo23215a("AppRate_new", "DoNotLike", "Feedback");
                    if (checkBox5.isChecked()) {
                        avq3.mo23215a("AppRate_new", "feeback_option", "bad design");
                    }
                    if (checkBox7.isChecked()) {
                        avq3.mo23215a("AppRate_new", "feeback_option", "no function");
                    }
                    if (checkBox8.isChecked()) {
                        avq3.mo23215a("AppRate_new", "feeback_option", "not easy to use");
                    }
                    if (checkBox10.isChecked()) {
                        avq3.mo23215a("AppRate_new", "feeback_option", "too complicated");
                    }
                    if (checkBox12.isChecked()) {
                        avq3.mo23215a("AppRate_new", "feeback_option", "bad translation");
                    }
                    if (checkBox5.isChecked() || checkBox7.isChecked() || checkBox8.isChecked() || checkBox10.isChecked() || checkBox12.isChecked()) {
                        avq3.mo23217b();
                    } else {
                        avq3.mo23215a("AppRate_new", "feeback_option", "nothing checked");
                        avq3.mo23219c();
                    }
                }
                aVar2.dismiss();
            }
        };
        button3.setOnClickListener(r1);
        b.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                RatingInterface avq = avq2;
                if (avq != null) {
                    avq.mo23218b(3);
                }
            }
        });
        if (avo.f14668c) {
            inflate.setBackgroundResource(R.drawable.lib_rate_dialog_bg_dark);
            Context context3 = context;
            ((TextView) inflate.findViewById(R.id.feedback_tip)).setTextColor(ContextCompat.getColor(context3, R.color.lib_rate_dialog_message_text_color_dark));
            CheckBox checkBox14 = checkBox6;
            checkBox14.setTextColor(ContextCompat.getColor(context3, R.color.lib_rate_dialog_message_text_color_dark));
            checkBox2.setTextColor(ContextCompat.getColor(context3, R.color.lib_rate_dialog_message_text_color_dark));
            CheckBox checkBox15 = checkBox13;
            checkBox15.setTextColor(ContextCompat.getColor(context3, R.color.lib_rate_dialog_message_text_color_dark));
            CheckBox checkBox16 = checkBox11;
            checkBox16.setTextColor(ContextCompat.getColor(context3, R.color.lib_rate_dialog_message_text_color_dark));
            CheckBox checkBox17 = checkBox9;
            checkBox17.setTextColor(ContextCompat.getColor(context3, R.color.lib_rate_dialog_message_text_color_dark));
            checkBox14.setButtonDrawable(R.drawable.lib_rate_checkbox_dark);
            checkBox2.setButtonDrawable(R.drawable.lib_rate_checkbox_dark);
            checkBox15.setButtonDrawable(R.drawable.lib_rate_checkbox_dark);
            checkBox16.setButtonDrawable(R.drawable.lib_rate_checkbox_dark);
            checkBox17.setButtonDrawable(R.drawable.lib_rate_checkbox_dark);
            button4.setTextColor(ContextCompat.getColor(context3, R.color.lib_rate_dialog_button_enable_color_dark));
            button3.setTextColor(ContextCompat.getColor(context3, R.color.lib_rate_dialog_button_enable_color_dark));
        }
        b.show();
    }
}
