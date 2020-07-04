package com.example.testsingle.presenter;


import com.example.testsingle.model.Model;
import com.example.testsingle.view.MainView;

import io.reactivex.Single;
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

    }



}
