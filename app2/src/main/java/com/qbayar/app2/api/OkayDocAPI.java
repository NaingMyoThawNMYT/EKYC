package com.qbayar.app2.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OkayDocAPI {

    @Headers("Content-Type: application/json")
    @POST("ekyc/v5/doc-verify/mykad")
    Call<String> postMyKad(@Body String okayDocMyKadJson);
}
