package com.fwd.testapplication;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by Rizwan Sheikh on 23-Dec-20.
 */
public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<ModelClass> responseData;
    private RepositoryClass repositoryClass;

    public MainActivityViewModel() {
        repositoryClass = new RepositoryClass();
        responseData = new MediatorLiveData<>();
    }

    public MutableLiveData<ModelClass> getResponseData() {
        return responseData;
    }

    public void getData() {
        Observer<Response<ModelClass>> observer = new Observer<Response<ModelClass>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Response<ModelClass> response) {
                if (response.code() == 200) {
                    responseData.postValue(response.body());
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        if (repositoryClass == null)
            repositoryClass = new RepositoryClass();

        repositoryClass.getResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(observer);
    }

}
