package com.asomegs.retrofitpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.eTextLat)
    EditText mEditTextLat;
    @BindView(R.id.eTextLng)
    EditText mEditTextLng;
    @BindView(R.id.tViewResult)
    TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnGetWeather)
    void onClickGetWeather() {
        
    }
}
