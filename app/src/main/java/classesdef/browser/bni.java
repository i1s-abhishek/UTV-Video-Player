package classesdef.browser;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/* renamed from: bni */
public class bni extends FragmentStatePagerAdapter {

    /* renamed from: a */
    private ArrayList<Fragment> f15926a;

    public int getItemPosition(Object obj) {
        return -2;
    }

    public bni(FragmentManager fragmentManager, ArrayList<Fragment> arrayList) {
        super(fragmentManager);
        this.f15926a = arrayList;
    }

    public Fragment getItem(int i) {
        return this.f15926a.get(i);
    }

    public int getCount() {
        return this.f15926a.size();
    }
}
