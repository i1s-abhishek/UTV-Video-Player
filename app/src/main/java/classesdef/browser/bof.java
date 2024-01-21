package classesdef.browser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bof */
public class bof extends Fragment {
    /* renamed from: a */
    public static bof m18298a(int i) {
        bof bof = new bof();
        Bundle bundle = new Bundle();
        bundle.putInt("index", i);
        bof.setArguments(bundle);
        return bof;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_null, (ViewGroup) null);
    }
}
