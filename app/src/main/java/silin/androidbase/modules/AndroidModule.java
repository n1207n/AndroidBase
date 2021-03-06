package silin.androidbase.modules;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 7/11/16: AndroidBase
 */
@Module
public class AndroidModule {
    private final Application mApplication;

    public AndroidModule(@NonNull Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return mApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }
}
