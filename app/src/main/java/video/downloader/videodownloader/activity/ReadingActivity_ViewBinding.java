package video.downloader.videodownloader.activity;

import android.view.View;
import android.widget.TextView;

import butterknife.Unbinder;
import butterknife.internal.Utils;
import hdplayer.vlcplayer.videoplayer.R;

public class ReadingActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private ReadingActivity f13523a;

    public ReadingActivity_ViewBinding(ReadingActivity readingActivity, View view) {
        this.f13523a = readingActivity;
        readingActivity.mTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.textViewTitle, "field 'mTitle'", TextView.class);
        readingActivity.mBody = (TextView) Utils.findRequiredViewAsType(view, R.id.textViewBody, "field 'mBody'", TextView.class);
    }

    public void unbind() {
        ReadingActivity readingActivity = this.f13523a;
        if (readingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f13523a = null;
        readingActivity.mTitle = null;
        readingActivity.mBody = null;
    }
}
