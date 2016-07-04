package silin.androidbase;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created on 7/4/16: AndroidBase
 */

public enum Environment implements IEnvironment {
    DEV {
        @Override
        public HttpLoggingInterceptor.Level getHttpLoggingLevel() {
            return HttpLoggingInterceptor.Level.BODY;
        }

        @Override
        public boolean isDebugDrawerEnabled() {
            return true;
        }
    },

    STAGING {
        @Override
        public HttpLoggingInterceptor.Level getHttpLoggingLevel() {
            return HttpLoggingInterceptor.Level.BODY;
        }

        @Override
        public boolean isDebugDrawerEnabled() {
            return true;
        }
    },

    PROD {
        @Override
        public HttpLoggingInterceptor.Level getHttpLoggingLevel() {
            return HttpLoggingInterceptor.Level.NONE;
        }

        @Override
        public boolean isDebugDrawerEnabled() {
            return false;
        }
    }
}
