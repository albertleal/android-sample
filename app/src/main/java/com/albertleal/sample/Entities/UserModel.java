package com.albertleal.sample.Entities;

import com.albertleal.sample.Helpers.CustomResponseListener;

import java.util.Timer;
import java.util.TimerTask;

public class UserModel {

    String name;
    String email;

    public UserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

    final static int MOCK_DURATION = 1000;
    public static void fetch(final CustomResponseListener listener) {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                listener.onResponseReceived(new UserModel("albert", "albert.leal@eug.es"));

            }
        }, MOCK_DURATION );

    }
}
