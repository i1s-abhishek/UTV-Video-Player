package video.downloader.videodownloader.five.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import classesdef.browser.BrowserData;

public class MyImageView extends ImageView {

    private Context f13726a;

    private String f13727b;

    public MyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13726a = context;
    }

    public MyImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            BrowserData.m18385a().mo23297a((Throwable) e);
            e.printStackTrace();
        } catch (Error e2) {
            BrowserData.m18385a().mo23297a((Throwable) e2);
            e2.printStackTrace();
        }
    }

    public void setPosition(String str) {
        this.f13727b = str;
    }
}
