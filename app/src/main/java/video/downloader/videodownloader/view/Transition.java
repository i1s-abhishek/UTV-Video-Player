package video.downloader.videodownloader.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

import androidx.core.content.ContextCompat;

import classesdef.browser.bqt;
import hdplayer.xdplayer.videoplayer.R;

public class Transition extends TransitionDrawable {

    private boolean transition;

    public Transition(Context context) {
        super(new Drawable[]{new ColorDrawable(ContextCompat.getColor(context, R.color.transparent)), new ColorDrawable(bqt.m18987a(context, (int) R.attr.selectedBackground))});
    }

    public void startTransition(int i) {
        if (!this.transition) {
            super.startTransition(i);
        }
        this.transition = true;
    }

    public void reverseTransition(int i) {
        if (this.transition) {
            super.reverseTransition(i);
        }
        this.transition = false;
    }
}
