package com.qbayar.app2.retrofitHelper;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class RetrofitHelper {
    static Retrofit getRetrofit(String baseUrl) {
        return new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }
}
