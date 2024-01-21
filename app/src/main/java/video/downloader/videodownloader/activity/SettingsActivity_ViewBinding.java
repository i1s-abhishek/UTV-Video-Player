package video.downloader.videodownloader.activity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;

import butterknife.Unbinder;
import butterknife.internal.Utils;
import hdplayer.xdplayer.videoplayer.R;

public class SettingsActivity_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SettingsActivity f13544a;

    public SettingsActivity_ViewBinding(SettingsActivity settingsActivity, View view) {
        this.f13544a = settingsActivity;
        settingsActivity.rl_download_location = Utils.findRequiredView(view, R.id.rl_download_location, "field 'rl_download_location'");
        settingsActivity.tv_download_location = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_download_location, "field 'tv_download_location'", TextView.class);
        settingsActivity.tv_active_downloads = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_active_downloads, "field 'tv_active_downloads'", TextView.class);
        settingsActivity.rl_active_downloads = Utils.findRequiredView(view, R.id.rl_active_downloads, "field 'rl_active_downloads'");
        settingsActivity.rl_download_wifi = Utils.findRequiredView(view, R.id.rl_download_wifi, "field 'rl_download_wifi'");
        settingsActivity.sc_wifi = (SwitchCompat) Utils.findRequiredViewAsType(view, R.id.sc_wifi, "field 'sc_wifi'", SwitchCompat.class);
        settingsActivity.ll_home_page = Utils.findRequiredView(view, R.id.ll_home_page, "field 'll_home_page'");
        settingsActivity.tv_home_page = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_home_page, "field 'tv_home_page'", TextView.class);
        settingsActivity.rl_ad_block = Utils.findRequiredView(view, R.id.rl_ad_block, "field 'rl_ad_block'");
        settingsActivity.sc_ad_block = (SwitchCompat) Utils.findRequiredViewAsType(view, R.id.sc_ad_block, "field 'sc_ad_block'", SwitchCompat.class);
        settingsActivity.tv_ad_block = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ad_block, "field 'tv_ad_block'", TextView.class);
        settingsActivity.rl_save_password = Utils.findRequiredView(view, R.id.rl_save_password, "field 'rl_save_password'");
        settingsActivity.tb_save_password = (SwitchCompat) Utils.findRequiredViewAsType(view, R.id.tb_save_password, "field 'tb_save_password'", SwitchCompat.class);
        settingsActivity.rl_search_engine = Utils.findRequiredView(view, R.id.rl_search_engine, "field 'rl_search_engine'");
        settingsActivity.tv_search_engine = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_search_engine, "field 'tv_search_engine'", TextView.class);
        settingsActivity.rl_clear_cache = Utils.findRequiredView(view, R.id.rl_clear_cache, "field 'rl_clear_cache'");
        settingsActivity.rl_clear_history = Utils.findRequiredView(view, R.id.rl_clear_history, "field 'rl_clear_history'");
        settingsActivity.rl_clear_cookies = Utils.findRequiredView(view, R.id.rl_clear_cookies, "field 'rl_clear_cookies'");
        settingsActivity.rl_sync_gallery = Utils.findRequiredView(view, R.id.rl_sync_gallery, "field 'rl_sync_gallery'");
        settingsActivity.sc_sync_gallery = (SwitchCompat) Utils.findRequiredViewAsType(view, R.id.sc_sync_gallery, "field 'sc_sync_gallery'", SwitchCompat.class);
        settingsActivity.tv_sync_gallery = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sync_gallery, "field 'tv_sync_gallery'", TextView.class);
        settingsActivity.tv_howto_download = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_howto_download, "field 'tv_howto_download'", TextView.class);
        settingsActivity.tv_feedback = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_feedback, "field 'tv_feedback'", TextView.class);
        settingsActivity.tv_privacy_policy = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_privacy_policy, "field 'tv_privacy_policy'", TextView.class);
        settingsActivity.tv_version = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_version, "field 'tv_version'", TextView.class);
    }

    public void unbind() {
        SettingsActivity settingsActivity = this.f13544a;
        if (settingsActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f13544a = null;
        settingsActivity.rl_download_location = null;
        settingsActivity.tv_download_location = null;
        settingsActivity.tv_active_downloads = null;
        settingsActivity.rl_active_downloads = null;
        settingsActivity.rl_download_wifi = null;
        settingsActivity.sc_wifi = null;
        settingsActivity.ll_home_page = null;
        settingsActivity.tv_home_page = null;
        settingsActivity.rl_ad_block = null;
        settingsActivity.sc_ad_block = null;
        settingsActivity.tv_ad_block = null;
        settingsActivity.rl_save_password = null;
        settingsActivity.tb_save_password = null;
        settingsActivity.rl_search_engine = null;
        settingsActivity.tv_search_engine = null;
        settingsActivity.rl_clear_cache = null;
        settingsActivity.rl_clear_history = null;
        settingsActivity.rl_clear_cookies = null;
        settingsActivity.rl_sync_gallery = null;
        settingsActivity.sc_sync_gallery = null;
        settingsActivity.tv_sync_gallery = null;
        settingsActivity.tv_howto_download = null;
        settingsActivity.tv_feedback = null;
        settingsActivity.tv_privacy_policy = null;
        settingsActivity.tv_version = null;
    }
}
