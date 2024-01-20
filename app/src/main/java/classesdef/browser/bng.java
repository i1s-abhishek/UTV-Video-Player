package classesdef.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import hdplayer.vlcplayer.videoplayer.R;


/* renamed from: bng */
public class bng extends BaseAdapter {

    /* renamed from: a */
    private Context f15915a;

    /* renamed from: b */
    private ArrayList<String> f15916b;

    public long getItemId(int i) {
        return (long) i;
    }

    public bng(Context context, ArrayList<String> arrayList) {
        this.f15915a = context;
        this.f15916b = arrayList;
    }

    public int getCount() {
        return this.f15916b.size();
    }

    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        C3942a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.f15915a).inflate(R.layout.item_downloader_folder, (ViewGroup) null);
            aVar = new C3942a();
            TextView unused = aVar.f15918b = (TextView) view.findViewById(R.id.tv_folder_name);
            view.setTag(aVar);
        } else {
            aVar = (C3942a) view.getTag();
        }
        aVar.f15918b.setText(this.f15916b.get(i));
        return view;
    }

    /* renamed from: bng$a */
    private class C3942a {
        /* access modifiers changed from: private */

        /* renamed from: b */
        public TextView f15918b;

        private C3942a() {
        }
    }
}
