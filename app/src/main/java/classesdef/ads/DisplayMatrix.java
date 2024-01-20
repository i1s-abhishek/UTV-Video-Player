package classesdef.ads;

import android.content.Context;


public class DisplayMatrix {

    public static int getdisplayDensity(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }


    public static int getDisplayWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }


    public static int getDisplayHeikht(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
