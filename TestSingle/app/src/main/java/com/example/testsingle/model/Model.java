package com.example.testsingle.model;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Model {
    private static final String TAG = "Model";

     public Single<String> requestToServer(){
         Single<String> observable = Single.create((SingleOnSubscribe<String>) emitter -> {
             String json = "{'name':'Uncle Bans', 'age':'68 лет'}";
             Log.d(TAG, "requestToServer: " + Thread.currentThread().getName() + ": " + json);
             emitter.onSuccess(json);
         }).subscribeOn(Schedulers.io());

         return observable;
     }
}


