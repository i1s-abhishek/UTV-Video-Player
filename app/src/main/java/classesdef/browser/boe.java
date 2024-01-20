package classesdef.browser;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.five.activity.HelpActivity;
import video.downloader.videodownloader.five.view.MyViewPager;
import video.downloader.videodownloader.five.view.ScalingImageView;

/* renamed from: boe */
public class boe extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    private int f16041a;

    /* renamed from: b */
    private MyViewPager f16042b;

    /* renamed from: c */
    private TextView f16043c;

    /* renamed from: d */
    private TextView f16044d;

    /* renamed from: e */
    private ScalingImageView f16045e;

    /* renamed from: f */
    private ImageView[] f16046f = new ImageView[4];

    /* renamed from: g */
    private LinearLayout f16047g;

    /* renamed from: h */
    private RelativeLayout f16048h;

    /* renamed from: i */
    private Button f16049i;

    /* renamed from: j */
    private HelpActivity f16050j;

    /* renamed from: a */
    public static boe m18293a(int i) {
        boe boe = new boe();
        Bundle bundle = new Bundle();
        bundle.putInt("index", i);
        boe.setArguments(bundle);
        return boe;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    /* renamed from: a */
    public void mo23260a(int i, MyViewPager myViewPager) {
        this.f16041a = i;
        this.f16042b = myViewPager;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity != null && (activity instanceof HelpActivity)) {
            this.f16050j = (HelpActivity) activity;
        }
    }

    /* renamed from: a */
    public MyViewPager mo23259a() {
        if (this.f16042b == null && this.f16050j != null) {
            this.f16042b = this.f16050j.f13714a;
        }
        return this.f16042b;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_help, (ViewGroup) null);
        if (getActivity() != null && (getActivity() instanceof HelpActivity)) {
            this.f16050j = (HelpActivity) getActivity();
        }
        this.f16043c = (TextView) inflate.findViewById(R.id.number);
        this.f16044d = (TextView) inflate.findViewById(R.id.title);
        this.f16045e = (ScalingImageView) inflate.findViewById(R.id.help_image);
        this.f16046f[0] = (ImageView) inflate.findViewById(R.id.dot_0);
        this.f16046f[1] = (ImageView) inflate.findViewById(R.id.dot_1);
        this.f16046f[2] = (ImageView) inflate.findViewById(R.id.dot_2);
        this.f16046f[3] = (ImageView) inflate.findViewById(R.id.dot_3);
        this.f16047g = (LinearLayout) inflate.findViewById(R.id.youtube_layout);
        this.f16048h = (RelativeLayout) inflate.findViewById(R.id.previous_layout);
        this.f16049i = (Button) inflate.findViewById(R.id.next);
        inflate.findViewById(R.id.close).setOnClickListener(this);
        this.f16048h.setOnClickListener(this);
        this.f16049i.setOnClickListener(this);
        TextView textView = this.f16043c;
        textView.setText("" + (this.f16041a + 1));
        m18294b();
        m18295c();
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.close) {
            getActivity().finish();
            BrowserLogEvent.downloaderLogEvent(getContext(), "guide", "直接关闭");
        } else if (id != R.id.next) {
            if (id == R.id.previous_layout) {
                BrowserLogEvent.downloaderLogEvent(getContext(), "guide", "点击向前");
                mo23259a().setCurrentItem(mo23259a().getCurrentItem() - 1, true);
            }
        } else if (mo23259a().getCurrentItem() == mo23259a().getAdapter().getCount() - 1) {
            getActivity().finish();
            BrowserLogEvent.downloaderLogEvent(getContext(), "guide", "最后一个");
        } else {
            mo23259a().setCurrentItem(mo23259a().getCurrentItem() + 1, true);
            BrowserLogEvent.downloaderLogEvent(getContext(), "guide", "点击下一个");
        }
    }

    /* renamed from: b */
    private void m18294b() {
        switch (this.f16041a) {
            case 0:
                this.f16044d.setText(Html.fromHtml(getString(R.string.go_to_website_help)));
                Glide.with(getContext() ).load(Integer.valueOf(R.mipmap.help_0)).dontAnimate().into((ImageView) this.f16045e);
                this.f16048h.setVisibility(8);
                this.f16049i.setText(getString(R.string.next));
                this.f16047g.setVisibility(8);
                return;
            case 1:
                this.f16044d.setText(Html.fromHtml(getString(R.string.play_video)));
                Glide.with( getContext()).load(Integer.valueOf(R.mipmap.help_1)).dontAnimate().into((ImageView) this.f16045e);
                this.f16048h.setVisibility(0);
                this.f16049i.setText(getString(R.string.next));
                this.f16047g.setVisibility(8);
                return;
            case 2:
                this.f16044d.setText(Html.fromHtml(getString(R.string.click_download_button)));
                Glide.with(getContext()).load(Integer.valueOf(R.mipmap.help_2)).dontAnimate().into((ImageView) this.f16045e);
                this.f16048h.setVisibility(0);
                this.f16049i.setText(getString(R.string.next));
                this.f16047g.setVisibility(8);
                return;
            case 3:
                this.f16043c.setVisibility(4);
                this.f16044d.setVisibility(4);
                Glide.with(getContext()).load(Integer.valueOf(R.mipmap.help_2)).dontAnimate().into((ImageView) this.f16045e);
                this.f16045e.setVisibility(4);
                this.f16048h.setVisibility(0);
                this.f16049i.setText(getString(R.string.got_it));
                this.f16047g.setVisibility(0);
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private void m18295c() {
        for (int i = 0; i < this.f16046f.length; i++) {
            if (i == this.f16041a) {
                this.f16046f[i].setImageResource(R.mipmap.ic_pager_index_checked);
            } else {
                this.f16046f[i].setImageResource(R.mipmap.ic_pager_index);
            }
        }
    }
}
