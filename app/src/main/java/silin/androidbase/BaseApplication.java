package silin.androidbase;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import autodagger.AutoComponent;
import silin.androidbase.modules.ContextModule;
import silin.androidbase.modules.EnvironmentModule;
import silin.androidbase.modules.NetworkModule;
import silin.androidbase.modules.SharedPrefModule;

/**
 * Created on 7/4/16: AndroidBase
 */
@AutoComponent(
        modules = {
                ContextModule.class,
                EnvironmentModule.class,
                NetworkModule.class,
                SharedPrefModule.class
        }
)
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initializeWithDefaults(this);
        LeakCanary.install(this);
    }
}
