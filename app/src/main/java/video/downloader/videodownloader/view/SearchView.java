package video.downloader.videodownloader.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

public class SearchView extends AppCompatAutoCompleteTextView {

    private C3602a f13817a;

    private boolean f13818b;

    private long f13819c;

    public interface C3602a {
        void mo21395a();
    }

    public SearchView(Context context) {
        super(context);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnPreFocusListener(C3602a aVar) {
        this.f13817a = aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    this.f13819c = System.currentTimeMillis();
                    this.f13818b = true;
                    break;
                case 1:
                    if (this.f13818b && !m15342a() && this.f13817a != null) {
                        this.f13817a.mo21395a();
                        break;
                    }
            }
        } else {
            this.f13818b = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean m15342a() {
        return System.currentTimeMillis() - this.f13819c >= ((long) ViewConfiguration.getLongPressTimeout());
    }
}
