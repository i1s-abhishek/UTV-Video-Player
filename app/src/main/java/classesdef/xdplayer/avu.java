package classesdef.xdplayer;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.ViewGroup;

import hdplayer.xdplayer.videoplayer.R;



public class avu implements avt {

    public void mo10824a(Context context, ViewGroup viewGroup) {
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(R.attr.homeBgColor, typedValue, true);
        axu.m7428a().mo11007a(viewGroup, typedValue.resourceId);
    }
}
