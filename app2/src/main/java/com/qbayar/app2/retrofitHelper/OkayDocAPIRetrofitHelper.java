package com.qbayar.app2.retrofitHelper;

import com.google.gson.Gson;
import com.qbayar.app2.api.OkayDocAPI;
import com.qbayar.app2.callback.OkayDocMyKadPostAPICallback;
import com.qbayar.app2.model.OkayDocMyKad;
import com.qbayar.app2.model.OkayDocMyKadResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OkayDocAPIRetrofitHelper {

    private static OkayDocAPI api() {
        return RetrofitHelper
                .getRetrofit("https://okaydocdemo.innov8tif.com/ekyc/api/")
                .create(OkayDocAPI.class);
    }

    public static void postMyKad(OkayDocMyKad okayDocMyKad, final OkayDocMyKadPostAPICallback callback) {
        final Gson gson = new Gson();
        api().postOkayDoc("ekyc/v5/doc-verify/mykad", gson.toJson(okayDocMyKad))
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        callback.onResponse(gson.fromJson(response.body(), OkayDocMyKadResponse.class));
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        callback.onFailure(t);
                    }
                });
    }
}
