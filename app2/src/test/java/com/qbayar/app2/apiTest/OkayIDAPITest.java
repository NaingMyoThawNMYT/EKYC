package com.qbayar.app2.apiTest;

import android.util.Log;

import com.google.gson.Gson;
import com.qbayar.app2.model.MyResponse;
import com.qbayar.app2.model.OkayID;
import com.qbayar.app2.retrofitHelper.OkayIDAPIRetrofitHelper;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OkayIDAPITest {
    private static final String TAG = OkayIDAPITest.class.getSimpleName();

    @Test(timeout = 10000)
    public void post() {
        OkayID okayID = new OkayID();
        okayID.setApiKey("Ba0UkW6l1LJWuevMJn9gpBLajRqaA5Nx");
        okayID.setImageEnabled(true);
        okayID.setImageFormat(".jpg");
        okayID.setBase64ImageString("Encoded 64 string");

        OkayIDAPIRetrofitHelper okayIDAPIRetrofitHelper = new OkayIDAPIRetrofitHelper();
        okayIDAPIRetrofitHelper.post(okayID,
                new Callback<MyResponse>() {
                    @Override
                    public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                        Log.d(TAG, "onResponse() : call : " + new Gson().toJson(call));
                        Log.d(TAG, "onResponse() : response : " + new Gson().toJson(response));
                    }

                    @Override
                    public void onFailure(Call<MyResponse> call, Throwable t) {
                        Log.d(TAG, "onFailure() : call : " + new Gson().toJson(call));
                        Log.e(TAG, "onFailure() : fail", t);
                    }
                });
    }
}
