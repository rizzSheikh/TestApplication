package com.fwd.testapplication;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Rizwan Sheikh on 23-Dec-20.
 */
public class RepositoryClass {

    public Observable<Response<ModelClass>> getResponse() {
        JsonObject jsonObject = new JsonObject();
        return RetrofitAdapter.getRetrofit().create(APIClass.class).getResponse(jsonObject);
    }

}
