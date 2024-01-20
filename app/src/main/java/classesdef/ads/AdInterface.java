package classesdef.ads;

import android.view.View;

import com.mopub.nativeads.NativeErrorCode;


public interface AdInterface {

    void AdLogEvent();

    void AdLayout(View view);

    void AdsError(NativeErrorCode nativeErrorCode);
}
