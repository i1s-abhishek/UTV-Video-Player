package video.downloader.videodownloader.five.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.drawerlayout.widget.DrawerLayout;

public class FixedDrawerLayout extends DrawerLayout {
    public FixedDrawerLayout(Context context) {
        super(context);
    }

    public FixedDrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FixedDrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
    }
}
