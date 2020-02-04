package com.qbayar.ekyc;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.qbayar.app2.model.OkayID;
import com.qbayar.app2.retrofitHelper.OkayIDAPIRetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkayID okayID = new OkayID();
        okayID.setApiKey("Ba0UkW6l1LJWuevMJn9gpBLajRqaA5Nx");
        okayID.setImageEnabled(true);
        okayID.setImageFormat(".jpg");
        okayID.setBase64ImageString("Encoded 64 string");

        OkayIDAPIRetrofitHelper okayIDAPIRetrofitHelper = new OkayIDAPIRetrofitHelper();
        okayIDAPIRetrofitHelper.post(okayID,
                new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d(TAG, "onResponse() : call : " + new Gson().toJson(call));
                        Log.d(TAG, "onResponse() : response : " + new Gson().toJson(response));
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.d(TAG, "onFailure() : call : " + new Gson().toJson(call));
                        Log.e(TAG, "onFailure() : fail", t);
                    }
                });
    }
}
