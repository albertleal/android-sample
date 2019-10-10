package com.albertleal.sample.Scenes.Boot;

import com.albertleal.sample.Helpers.Callback;
import com.albertleal.sample.Scenes.Boot.Interfaces.IBootSceneInteractor;

import java.util.Timer;
import java.util.TimerTask;

public class BootSceneInteractor implements IBootSceneInteractor {

    @Override
    public void isUserLogedIn(final Callback listener) {
        //Mock a delay to retrieve local user
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                listener.onError();
                //listener.onSuccess(null);
            }
        }, 250);
    }
}



