package video.downloader.videodownloader.fragment;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.Unbinder;
import butterknife.internal.Utils;
import hdplayer.vlcplayer.videoplayer.R;

public class TabsFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private TabsFragment f13802a;

    public TabsFragment_ViewBinding(TabsFragment tabsFragment, View view) {
        this.f13802a = tabsFragment;
        tabsFragment.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.tabs_list, "field 'mRecyclerView'", RecyclerView.class);
    }

    public void unbind() {
        TabsFragment tabsFragment = this.f13802a;
        if (tabsFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f13802a = null;
        tabsFragment.mRecyclerView = null;
    }
}
