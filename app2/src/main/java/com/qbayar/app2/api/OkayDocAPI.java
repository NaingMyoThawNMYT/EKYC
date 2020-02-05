package com.qbayar.app2.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface OkayDocAPI {

    @Headers("Content-Type: application/json")
    @POST()
    Call<String> postOkayDoc(@Url String url, @Body String json);
}
