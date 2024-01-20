package video.downloader.videodownloader.five.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

public class ScalingImageView extends AppCompatImageView {
    public ScalingImageView(Context context) {
        super(context);
    }

    public ScalingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScalingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) View.MeasureSpec.getSize(i)) / (((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight()))), 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
