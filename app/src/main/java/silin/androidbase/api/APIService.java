package silin.androidbase.api;

/**
 * Created on 7/11/16: AndroidBase
 *
 * Credit goes to https://github.com/ennur/Clean-Android-Code! Thanks!
 */

public class APIService {
    private final NetworkService networkService;

    public APIService(NetworkService networkService) {
        this.networkService = networkService;
    }

    /*
     * Sample Observable Retrofit 2 implementation from NetworkService classes
     */

//    public Subscription getPopularObjectList(final GetPopularObjectListCallback callback) {
//        return networkService.getPopularObjectList("ascending")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MovieList>>() {
//                    @Override
//                    public Observable<? extends MovieList> call(Throwable throwable) {
//                        return Observable.error(throwable);
//                    }
//                })
//                .subscribe(new Subscriber<CoolObjectList>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        callback.onError(new NetworkException(e));
//                    }
//
//                    @Override
//                    public void onNext(CoolObjectList objectList) {
//                        callback.onSuccess(objectList);
//                    }
//                });
//    }
//
//    public Subscription getObject(final String movie_id, final GetObjectCallback callback) {
//        return networkService.getObject(movie_id)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MovieDetails>>() {
//                    @Override
//                    public Observable<? extends MovieDetails> call(Throwable throwable) {
//                        return Observable.error(throwable);
//                    }
//                })
//                .subscribe(new Subscriber<CoolObject>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        callback.onError(new NetworkException(e));
//                    }
//
//                    @Override
//                    public void onNext(CoolObject coolObject) {
//                        callback.onSuccess(coolObject);
//                    }
//                });
//    }
//
//    public interface GetPopularObjectListCallback {
//        void onSuccess(CoolObjectList objectList);
//
//        void onError(NetworkException exception);
//    }
//
//    public interface GetObjectCallback {
//        void onSuccess(CoolObject coolObject);
//
//        void onError(NetworkException exception);
//    }
}
