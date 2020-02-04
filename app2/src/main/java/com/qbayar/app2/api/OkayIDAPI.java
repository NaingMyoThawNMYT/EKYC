package com.qbayar.app2.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OkayIDAPI {

    @POST("/")
    Call<String> post(@Body String okayIdJson);
}
