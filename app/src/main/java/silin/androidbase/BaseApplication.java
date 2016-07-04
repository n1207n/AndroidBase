package silin.androidbase;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created on 7/4/16: AndroidBase
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
        LeakCanary.install(this);
    }
}
