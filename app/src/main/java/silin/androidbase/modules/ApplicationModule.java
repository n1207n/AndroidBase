package silin.androidbase.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import silin.androidbase.BaseApplication;

/**
 * Created on 7/4/16: AndroidBase
 */
@Module
public class ApplicationModule {
    private final BaseApplication mApplication;

    public ApplicationModule(BaseApplication mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    BaseApplication providesApplication() {
        return mApplication;
    }
}
