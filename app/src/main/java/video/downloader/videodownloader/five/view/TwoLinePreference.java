package video.downloader.videodownloader.five.view;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class TwoLinePreference extends Preference {
    public TwoLinePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TwoLinePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            textView.setSingleLine(false);
        }
    }
}
