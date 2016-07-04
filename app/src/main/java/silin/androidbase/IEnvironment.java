package silin.androidbase;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created on 7/4/16: AndroidBase
 */

public interface IEnvironment {
    HttpLoggingInterceptor.Level getHttpLoggingLevel();

    boolean isDebugDrawerEnabled();
}
