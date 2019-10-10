package com.albertleal.sample.Helpers;

public interface Callback<Object> {

    void onSuccess(Object responseObject);

    void onError();

}
