package classesdef.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: bmr */
public class bmr {

    /* renamed from: bmr$a */
    public interface C3877a {
        /* renamed from: a */
        void mo21426a(String str);
    }

    /* renamed from: bmr$b */
    public static abstract class C3878b {

        /* renamed from: a */
        private final int f15689a;

        /* renamed from: b */
        private boolean f15690b = true;

        /* renamed from: a */
        public abstract void mo21391a();

        protected C3878b(int i) {
            this.f15689a = i;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public int m18091b() {
            return this.f15689a;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public boolean m18093c() {
            return this.f15690b;
        }
    }

    /* renamed from: a */
    public static void m18086a(Activity activity, int i, C3878b... bVarArr) {
        m18087a(activity, activity.getString(i), bVarArr);
    }

    /* renamed from: a */
    public static void m18087a(Activity activity, String str, C3878b... bVarArr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.list_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
        ListView listView = (ListView) inflate.findViewById(R.id.dialog_list);
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, 17367043);
        final ArrayList<C3878b> arrayList = new ArrayList<>(1);
        for (C3878b bVar : bVarArr) {
            if (bVar.m18093c()) {
                arrayList.add(bVar);
            }
        }
        for (C3878b b : arrayList) {
            arrayAdapter.add(activity.getString(b.m18091b()));
        }
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        listView.setAdapter(arrayAdapter);
        listView.setDivider((Drawable) null);
        builder.setView(inflate);
        final AlertDialog show = builder.show();
        m18088a(activity, show);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ((C3878b) arrayList.get(i)).mo21391a();
                show.dismiss();
            }
        });
    }

    /* renamed from: a */
    public static void m18085a(Activity activity, int i, int i2, String str, int i3, final C3877a aVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_edit_text, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.dialog_edit_text);
        editText.setHint(i2);
        if (str != null) {
            editText.setText(str);
        }
        m18088a(activity, new AlertDialog.Builder(activity).setTitle(i).setView(inflate).setPositiveButton(i3, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                aVar.mo21426a(editText.getText().toString());
            }
        }).show());
    }

    /* renamed from: a */
    public static void m18088a(Context context, Dialog dialog) {
        int a = bqp.m18969a(context, R.dimen.dialog_max_size);
        int a2 = bqg.m18941a(context) - (bqp.m18969a(context, R.dimen.dialog_padding) * 2);
        if (a <= a2) {
            a2 = a;
        }
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(a2, -2);
        }
    }
}
