package video.downloader.videodownloader.fragment;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.Unbinder;
import butterknife.internal.Utils;
import hdplayer.vlcplayer.videoplayer.R;

public class BookmarksFragment_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BookmarksFragment f13775a;

    public BookmarksFragment_ViewBinding(BookmarksFragment bookmarksFragment, View view) {
        this.f13775a = bookmarksFragment;
        bookmarksFragment.mBookmarksListView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.right_drawer_list, "field 'mBookmarksListView'", RecyclerView.class);
        bookmarksFragment.mBookmarkImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon_star, "field 'mBookmarkImage'", ImageView.class);
    }

    public void unbind() {
        BookmarksFragment bookmarksFragment = this.f13775a;
        if (bookmarksFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f13775a = null;
        bookmarksFragment.mBookmarksListView = null;
        bookmarksFragment.mBookmarkImage = null;
    }
}
