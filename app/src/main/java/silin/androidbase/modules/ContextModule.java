package silin.androidbase.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created on 7/4/16: AndroidBase
 */
@Module
public class ContextModule {
    private final Context mContext;

    public ContextModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return mContext;
    }
}
