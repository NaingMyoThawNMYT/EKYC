package com.qbayar.app2.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OkayIDAPI {

    @Headers("Content-Type: application/json")
    @POST("ocr")
    Call<String> post(@Body String okayIdJson);
}
