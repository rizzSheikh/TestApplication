package com.fwd.testapplication;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Rizwan Sheikh on 23-Dec-20.
 */
public interface APIClass {

    @POST("")
    Observable<Response<ModelClass>> getResponse(@Body JsonObject jsonObject);
}
