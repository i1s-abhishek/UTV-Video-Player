package classesdef.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bnh */
public class bnh extends RecyclerView.Adapter<bnh.C3945b> {

    /* renamed from: a */
    C3944a f15919a;

    /* renamed from: b */
    private Context f15920b;

    /* renamed from: c */
    private ArrayList<String> f15921c;

    /* renamed from: bnh$a */
    public interface C3944a {
        /* renamed from: a */
        void mo21404a(int i);
    }

    public bnh(Context context, ArrayList<String> arrayList) {
        this.f15920b = context;
        this.f15921c = arrayList;
    }

    /* renamed from: a */
    public C3945b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C3945b(LayoutInflater.from(this.f15920b).inflate(R.layout.folder_path_item, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(C3945b bVar, final int i) {
        bVar.f15924a.setText(this.f15921c.get(i));
        bVar.f15924a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (bnh.this.f15919a != null) {
                    bnh.this.f15919a.mo21404a(i);
                }
            }
        });
    }

    public int getItemCount() {
        return this.f15921c.size();
    }

    /* renamed from: bnh$b */
    public class C3945b extends RecyclerView.ViewHolder {

        /* renamed from: a */
        public TextView f15924a;

        public C3945b(View view) {
            super(view);
            this.f15924a = (TextView) view.findViewById(R.id.tv_path_item);
        }
    }

    /* renamed from: a */
    public void mo23193a(C3944a aVar) {
        this.f15919a = aVar;
    }
}
