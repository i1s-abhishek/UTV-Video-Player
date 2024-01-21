package classesdef.browser;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mopub.common.util.Views;

import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bne */
public class bne extends BaseAdapter {

    /* renamed from: a */
    public bnk f15837a;

    /* renamed from: b */
    private DownloadFinishedFileItemFragment f15838b;

    /* renamed from: c */
    private View f15839c;

    public int getViewTypeCount() {
        return 3;
    }

    public bne(bnk bnk, DownloadFinishedFileItemFragment bnf) {
        this.f15837a = bnk;
        this.f15838b = bnf;
        bnk.f15945a = this;
        bnf.f15842a = this;
    }

    /* renamed from: a */
    public void mo23150a(View view) {
        this.f15839c = view;
    }

    /* renamed from: a */
    public View mo23149a() {
        return this.f15839c;
    }

    /* renamed from: b */
    public void mo23151b() {
        if (this.f15839c != null) {
            ViewGroup viewGroup = (ViewGroup) this.f15839c.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f15839c);
            }
            this.f15839c = null;
        }
    }

    public int getCount() {
        int c = m18179c();
        if (c == 0) {
            return 0;
        }
        return this.f15839c != null ? c + 1 : c;
    }

    /* renamed from: c */
    private int m18179c() {
        return this.f15837a.mo23203a() + this.f15838b.mo23158a();
    }

    public Object getItem(int i) {
        if (this.f15839c != null) {
            if (i == 1) {
                return this.f15839c;
            }
            if (i > 1) {
                i--;
            }
        }
        if (i < this.f15837a.mo23203a()) {
            return this.f15837a.mo23205a(i);
        }
        return this.f15838b.mo23160a(i - this.f15837a.mo23203a());
    }

    public long getItemId(int i) {
        if (this.f15839c != null) {
            if (i == 1) {
                return -1;
            }
            if (i > 1) {
                i--;
            }
        }
        if (i < this.f15837a.mo23203a()) {
            return this.f15837a.mo23207b(i);
        }
        return this.f15838b.mo23161b(i - this.f15837a.mo23203a()) + 10000;
    }

    public int getItemViewType(int i) {
        if (this.f15839c != null) {
            if (i == 1) {
                return 2;
            }
            if (i > 1) {
                i--;
            }
        }
        if (i < this.f15837a.mo23203a()) {
            return 0;
        }
        return 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: bne$a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0021 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public View getVieww(int r5, View r6, ViewGroup r7) {
        /*
            r4 = this;
            android.view.View r0 = r4.f15839c
            r1 = 1
            r2 = -1
            if (r0 == 0) goto L_0x000e
            if (r5 != r1) goto L_0x000a
            r0 = 2
            goto L_0x000f
        L_0x000a:
            if (r5 <= r1) goto L_0x000e
            int r5 = r5 + -1
        L_0x000e:
            r0 = -1
        L_0x000f:
            r3 = 0
            if (r0 != r2) goto L_0x001d
            bnk r0 = r4.f15837a
            int r0 = r0.mo23203a()
            if (r5 >= r0) goto L_0x001c
            r0 = 0
            goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r1 = 0
            switch(r0) {
                case 0: goto L_0x0060;
                case 1: goto L_0x0052;
                case 2: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            return r1
        L_0x0022:
            if (r6 == 0) goto L_0x002b
            java.lang.Object r5 = r6.getTag()
            r1 = r5
            bne$a r1 = (p000.bne.C3921a) r1
        L_0x002b:
            if (r1 != 0) goto L_0x004c
            android.view.ContextThemeWrapper r5 = new android.view.ContextThemeWrapper
            android.content.Context r6 = r7.getContext()
            r0 = 2131689656(0x7f0f00b8, float:1.9008334E38)
            r5.<init>(r6, r0)
            android.view.LayoutInflater r5 = android.view.LayoutInflater.from(r5)
            r6 = 2131427408(0x7f0b0050, float:1.8476431E38)
            android.view.View r6 = r5.inflate(r6, r7, r3)
            bne$a r1 = new bne$a
            r1.<init>(r6)
            r6.setTag(r1)
        L_0x004c:
            android.view.View r5 = r4.f15839c
            r1.m18184a(r5)
            return r6
        L_0x0052:
            bnf r0 = r4.f15838b
            bnk r1 = r4.f15837a
            int r1 = r1.mo23203a()
            int r5 = r5 - r1
            android.view.View r5 = r0.mo23159a((int) r5, (android.view.View) r6, (android.view.ViewGroup) r7)
            return r5
        L_0x0060:
            bnk r0 = r4.f15837a
            android.view.View r5 = r0.mo23204a(r5, r6, r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.bne.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
    public View getViewc(int i, View view, ViewGroup viewGroup) {
        char c2;
        if (this.f15839c != null) {
            if (i == 1) {
                c2 = 2;
                if (c2 == 65535) {
                    c2 = i < this.f15837a.mo23203a() ? (char) 0 : 1;
                }
                C3921a aVar = null;
                switch (c2) {
                    case 0:
                        return this.f15837a.mo23204a(i, view, viewGroup);
                    case 1:
                        return this.f15838b.mo23159a(i - this.f15837a.mo23203a(), view, viewGroup);
                    case 2:
                        if (view != null) {
                            aVar = (C3921a) view.getTag();
                        }
                        if (aVar == null) {
                            view = LayoutInflater.from(new ContextThemeWrapper(viewGroup.getContext(), (int) R.style.NormalTheme)).inflate(R.layout.folder_list_ad_container, viewGroup, false);
                            aVar = new C3921a(view);
                            view.setTag(aVar);
                        }
                        aVar.m18184a(this.f15839c);
                        return view;
                    default:
                        return null;
                }
            } else if (i > 1) {
                i--;
            }
        }
        c2 = 65535;
        if (c2 == 65535) {
        }
        C3921a aVar2 = null;
        switch (c2) {
        }
        return view;
    }

    public View getView(int n, View inflate, final ViewGroup viewGroup) {
        int n2 = n;
        int n3 = 0;
        int n4 = 0;
        Label_0046: {
            if (this.f15839c != null) {
                if (n == 1) {
                    n3 = 2;
                    n4 = n;
                    break Label_0046;
                }
                if ((n2 = n) > 1) {
                    n2 = n - 1;
                }
            }
            n = -1;
            n4 = n2;
            n3 = n;
        }
        n = n3;
        if (n3 == -1) {
            if (n4 < this.f15837a.mo23203a()) {
                n = 0;
            }
            else {
                n = 1;
            }
        }
        C3921a a = null;
        switch (n) {
            default:
                return null;
            case 2: {
                if (inflate != null) {
                    a = (C3921a)inflate.getTag();
                }
              C3921a tag;
                if ((tag = a) == null) {
                    inflate = LayoutInflater.from((Context)new ContextThemeWrapper(viewGroup.getContext(), R.style.NormalTheme)).inflate(R.layout.folder_list_ad_container, viewGroup, false);
                    tag = new C3921a( inflate);
                    inflate.setTag((Object)tag);
                }
                tag.m18184a( this.f15839c);
                return inflate;
            }
            case 1:
                return this.f15838b.mo23159a(n4 - this.f15837a.mo23203a(), inflate, viewGroup);
            case 0:
                return this.f15837a.mo23204a(n4, inflate, viewGroup);
        }
    }


    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo23148a(int i) {
        return (this.f15839c == null || i < 1) ? i : i + 1;
    }

    /* renamed from: bne$a */
    private class C3921a {

        /* renamed from: a */
        final ViewGroup f15840a;

        C3921a(View view) {
            this.f15840a = (ViewGroup) view.findViewById(R.id.ad_container);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m18184a(View view) {
            if (this.f15840a != null && this.f15840a.getChildCount() == 0) {
                Views.removeFromParent(view);
                if (view != null) {
                    this.f15840a.addView(view);
                }
            }
        }
    }
}
