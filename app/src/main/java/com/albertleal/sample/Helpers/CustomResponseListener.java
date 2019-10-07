package com.albertleal.sample.Helpers;

public interface CustomResponseListener<Response> {

    void onResponseReceived(Response response);

    void onError();

}
