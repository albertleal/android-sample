package com.albertleal.sample.Entities;

import com.albertleal.sample.Helpers.Callback;

import java.util.Timer;
import java.util.TimerTask;

public class UserModel {

    String name;
    String email;

    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static void fetch(final Callback callback) {
        //We'll respond in a second so we can pretend we're using an async call to a
        //service.

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //If we want to trigger an error we'll use
                //listener.onError();

                //Responding as async with a sample UserModel
                callback.onSuccess(new UserModel("albert", "albert.leal@eug.es"));
            }
        }, 1000 );

    }
}
