package com.fwd.testapplication;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rizwan Sheikh on 23-Dec-20.
 */
public class RetrofitAdapter {

    private static volatile Retrofit retrofit;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            return retrofit = (new Retrofit.Builder().client(getClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("BASE URL")
                    .build());
        }

        return retrofit;
    }

    private static OkHttpClient getClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = builder.build();
        return okHttpClient;
    }
}
