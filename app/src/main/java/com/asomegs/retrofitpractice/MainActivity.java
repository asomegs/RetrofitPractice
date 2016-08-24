package com.asomegs.retrofitpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.eTextLat) EditText mEditTextLat;
    @Bind(R.id.eTextLng) EditText mEditTextLng;
    @Bind(R.id.tViewResult) TextView mTextViewResult;

    private String apiKey = "a22138b1bba6f624e00f2ac3e5d5a27a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnGetWeather) public void onClick(Button button) {
        GetWeatherClient<TestService> getWeatherClient;
        TestService mTestService;

        getWeatherClient = new GetWeatherClient<>();
        mTestService = getWeatherClient.getClient(TestService.class);

        Call<String> call = mTestService.getJsonObject(mEditTextLat.getText().toString(), mEditTextLng.getText().toString(), apiKey);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()) {
                        try {
                            String responseString = response.body();
                            JSONObject jsonObject = new JSONObject(responseString);
                            JSONObject main = jsonObject.getJSONObject("main");
                            Gson gson = new Gson();
                            Weather weather = gson.fromJson(main.toString(), Weather.class);
                            Log.d("result", weather.toString());
                            mTextViewResult.setText(weather.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "호출 실패", Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "오류 발생:" + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("onFailure", t.getLocalizedMessage());

            }
        });
    }


}
