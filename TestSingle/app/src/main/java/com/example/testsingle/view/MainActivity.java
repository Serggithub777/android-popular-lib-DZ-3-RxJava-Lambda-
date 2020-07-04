package com.example.testsingle.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testsingle.R;
import com.example.testsingle.presenter.Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;


public class MainActivity extends MvpAppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";

    @BindView(R.id.textViewData)
    TextView textView;

    @InjectPresenter
    Presenter presenter;

    @ProvidePresenter
    public Presenter providePresenter() {
        return new Presenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }
    @OnClick(R.id.buttonGetData)
    public void getData(View view) {
        presenter.request();
    }

    @Override
    public void setText(String json) {
        textView.setText(json);
    }
}
