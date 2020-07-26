package com.example.testrxlambbutknf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitActivity";
    private RetrofitPresenter retrofitPresenter;
    @BindView(R.id.imageView)
    ImageView avatarView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
        retrofitPresenter = new RetrofitPresenter();

    }
    @OnClick(R.id.buttonGetString)
    public void onClickButton(View view) {
        Log.d(TAG, "onClickButton: ");
        retrofitPresenter.getString();
     }
    @OnClick(R.id.buttonShowPicture)
    public void onClickButtonShowPic(View view){
        Glide
                .with(this)
                .load("https://avatars0.githubusercontent.com/u/66577?v=4")
                .into(avatarView);
    }
}
