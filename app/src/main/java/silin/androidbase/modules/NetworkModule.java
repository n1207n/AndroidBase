package silin.androidbase.modules;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.novoda.merlin.Merlin;
import com.novoda.merlin.MerlinsBeard;
import com.squareup.moshi.Moshi;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import rx.schedulers.Schedulers;
import silin.androidbase.IEnvironment;

/**
 * Created on 7/11/16: AndroidBase
 */
@Module
public class NetworkModule {
    @Provides
    @Singleton
    Cache providesCache(@NonNull final Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB

        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(@NonNull final IEnvironment environment, @NonNull Cache cache) {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(environment.getHttpLoggingLevel());

        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new StethoInterceptor())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request requestWithCache = originalRequest.newBuilder()
                                .header("Content-Type", "application/json")
                                .header("Cache-Control", "max-age=21600")
                                // Add your HTTP Authorization header if needed with BuildConfig.BASE_API_KEY
                                .build();

                        Response response = chain.proceed(requestWithCache);
                        response.cacheResponse();

                        return response;
                    }
                })
                .cache(cache).build();
    }

    @Provides
    @Singleton
    Merlin providesMerlin(@NonNull final Context context) {
        return new Merlin.Builder()
                .withConnectableCallbacks()
                .withDisconnectableCallbacks()
                .withBindableCallbacks()
                .withLogging(true)
                .build(context);
    }

    @Provides
    @Singleton
    MerlinsBeard providesMerlinBeard(@NonNull final Context context) {
        return MerlinsBeard.from(context);
    }

    @Provides
    @Singleton
    Picasso providesPicasso(@NonNull final Context context) {
        final Picasso picasso = Picasso.with(context);
        picasso.setIndicatorsEnabled(true);
        picasso.setLoggingEnabled(true);
        return picasso;
    }

    @Provides
    @Singleton
    Moshi providesMoshi() {
        return new Moshi.Builder()
                // .add(new AutoValueMoshiAdapterFactory())
                .build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(@NonNull final Moshi moshi, @NonNull final OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                // Replace with BuildConfig.API_BASE_URL
                .baseUrl("")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(okHttpClient)
                .build();
    }

    // Use below for Retrofit 2
    // @Provides
    // @Singleton
    // NetworkService providesNetworkInterface(@NonNull final Retrofit retrofit) {
    //     return retrofit.create(NetworkService.class);
    // }

    // @Provides
    // @Singleton
    // APIService providesAPIService(@NonNull final NetworkService networkService) {
    //     return new APIService(networkService);
    // }
}
