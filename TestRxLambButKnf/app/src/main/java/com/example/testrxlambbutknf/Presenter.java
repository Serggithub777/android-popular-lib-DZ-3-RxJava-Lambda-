package com.example.testrxlambbutknf;

import android.util.Log;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Presenter {
    private static final String TAG = "Presenter";

    public Observable<String> getMessage() {
        Observable<String> observable = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            try {
                for (int i = 0; i < 15; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    String msg = "message: " + i;
                    Log.d(TAG, "getMessage: " + Thread.currentThread().getName() + ": " + msg);
                    emitter.onNext(msg);
                }
                emitter.onComplete();
            } catch (InterruptedException e) {
                Log.d(TAG, "getMessage: not disposed");
            }
        }).subscribeOn(Schedulers.io());

        return observable;
    }

}