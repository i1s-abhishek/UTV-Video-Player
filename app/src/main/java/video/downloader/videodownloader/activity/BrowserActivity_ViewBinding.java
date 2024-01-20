package video.downloader.videodownloader.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;

import com.anthonycr.progress.AnimatedProgressBar;

import butterknife.Unbinder;
import butterknife.internal.Utils;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.five.view.FixedDrawerLayout;

public class BrowserActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private BrowserActivity f13494a;

    public BrowserActivity_ViewBinding(BrowserActivity browserActivity, View view) {
        this.f13494a = browserActivity;
        browserActivity.mDrawerLayout = (FixedDrawerLayout) Utils.findRequiredViewAsType(view, R.id.drawer_layout, "field 'mDrawerLayout'", FixedDrawerLayout.class);
        browserActivity.mBrowserFrame = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content_frame, "field 'mBrowserFrame'", FrameLayout.class);
        browserActivity.mDrawerLeft = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.left_drawer, "field 'mDrawerLeft'", ViewGroup.class);
        browserActivity.mDrawerRight = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.right_drawer, "field 'mDrawerRight'", ViewGroup.class);
        browserActivity.mUiLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.ui_layout, "field 'mUiLayout'", ViewGroup.class);
        browserActivity.mToolbarLayout = (ViewGroup) Utils.findRequiredViewAsType(view, R.id.toolbar_layout, "field 'mToolbarLayout'", ViewGroup.class);
        browserActivity.mProgressBar = (AnimatedProgressBar) Utils.findRequiredViewAsType(view, R.id.progress_view, "field 'mProgressBar'", AnimatedProgressBar.class);
        browserActivity.mSearchBar = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.search_bar, "field 'mSearchBar'", RelativeLayout.class);
        browserActivity.mToolbar = (Toolbar) Utils.findRequiredViewAsType(view, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    }

    public void unbind() {
        BrowserActivity browserActivity = this.f13494a;
        if (browserActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f13494a = null;
        browserActivity.mDrawerLayout = null;
        browserActivity.mBrowserFrame = null;
        browserActivity.mDrawerLeft = null;
        browserActivity.mDrawerRight = null;
        browserActivity.mUiLayout = null;
        browserActivity.mToolbarLayout = null;
        browserActivity.mProgressBar = null;
        browserActivity.mSearchBar = null;
        browserActivity.mToolbar = null;
    }
}
