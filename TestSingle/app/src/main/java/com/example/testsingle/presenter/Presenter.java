package com.example.testsingle.presenter;


import android.util.Log;

import com.example.testsingle.model.Model;
import com.example.testsingle.view.MainView;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class Presenter extends MvpPresenter<MainView> {
    private static final String TAG = "Presenter";
    private Model model;

    public Presenter() {
        model = new Model();
    }
    public void request(){
        Single<String> single = model.requestToServer();
        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(json ->{
            Log.d(TAG, "request: " + Thread.currentThread().getName() + ": " + json);
            getViewState().setText(json);
        });
    }
}

