package video.downloader.videodownloader.five.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AdActivity extends AppCompatActivity {

    private static AdActivity adActivity;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        adActivity = this;
        finish();
    }
}
