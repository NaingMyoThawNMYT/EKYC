package com.qbayar.app2.retrofitHelper;

import com.google.gson.Gson;
import com.qbayar.app2.api.OkayIDAPI;
import com.qbayar.app2.model.OkayID;

import retrofit2.Callback;

public class OkayIDAPIRetrofitHelper {
    private OkayIDAPI api() {
        return RetrofitHelper
                .getRetrofit("https://okaydocdemo.innov8tif.com/ekyc/api/v1/ocr/")
                .create(OkayIDAPI.class);
    }

//    public void post(OkayID okayID, Callback<MyResponse> callback) {
//        api().post(new Gson().toJson(okayID)).enqueue(callback);
//    }

    public void post(OkayID okayID, Callback<String> callback) {
        api().post(new Gson().toJson(okayID)).enqueue(callback);
    }
}
