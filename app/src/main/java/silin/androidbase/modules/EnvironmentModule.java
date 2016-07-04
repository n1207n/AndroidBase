package silin.androidbase.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import silin.androidbase.BuildConfig;
import silin.androidbase.IEnvironment;

/**
 * Created on 7/4/16: AndroidBase
 */
@Module
public class EnvironmentModule {
    @Provides
    @Singleton
    public IEnvironment providesEnvironment() {
        return BuildConfig.Environment;
    }
}
