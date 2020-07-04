package com.example.testrxlambbutknf;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Presenter presenter;
    private Observable<String> observable;
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter();
        observable = presenter.getMessage();

    }

    @OnClick(R.id.buttonSubscribe)
    public void subscribe(View view) {
        disposable = observable.observeOn(AndroidSchedulers.mainThread()).subscribe(str -> {
            Log.d(TAG, "onNext: " + str);
        }, throwable -> {
            Log.e(TAG, "onError");
        }, ()->{
            Log.d(TAG, "onComplete: ");
        });
    }

    @OnClick (R.id.buttonUnsubscribe)
    public void unsubscribe(View view) {
        disposable.dispose();
    }
}


