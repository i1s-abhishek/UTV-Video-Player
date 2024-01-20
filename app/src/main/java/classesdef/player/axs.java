package classesdef.player;

import java.util.List;

/* renamed from: axs */
class axs {
    /* renamed from: a */
    static boolean m7418a(String[] strArr, String str) {
        for (String startsWith : strArr) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static int m7417a(List<String> list, String str) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).endsWith(str)) {
                return size;
            }
        }
        return -1;
    }
}
