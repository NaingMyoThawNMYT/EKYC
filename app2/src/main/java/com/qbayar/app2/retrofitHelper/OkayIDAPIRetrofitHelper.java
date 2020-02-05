package com.qbayar.app2.retrofitHelper;

import com.google.gson.Gson;
import com.qbayar.app2.api.OkayIDAPI;
import com.qbayar.app2.callback.OkayIDPostAPICallback;
import com.qbayar.app2.model.OkayIDResponse;
import com.qbayar.app2.model.OkayID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OkayIDAPIRetrofitHelper {
    private OkayIDAPI api() {
        return RetrofitHelper
                .getRetrofit("https://okaydocdemo.innov8tif.com/ekyc/api/v1/")
                .create(OkayIDAPI.class);
    }

    public void post(final OkayID okayID, final OkayIDPostAPICallback callback) {
        final Gson gson = new Gson();
        api().post(gson.toJson(okayID))
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        callback.onResponse(gson.fromJson(response.body(), OkayIDResponse.class));
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        callback.onFailure(t);
                    }
                });
    }
}
