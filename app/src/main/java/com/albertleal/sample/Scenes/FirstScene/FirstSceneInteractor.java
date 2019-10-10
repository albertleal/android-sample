package com.albertleal.sample.Scenes.FirstScene;

import com.albertleal.sample.Helpers.Callback;
import com.albertleal.sample.Entities.UserModel;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstSceneInteractor;

public class FirstSceneInteractor implements IFirstSceneInteractor {

    @Override
    public void retrieveUser(final Callback listener) {


        UserModel.fetch(new Callback() {
            @Override
            public void onSuccess(Object user) {
                //we should save this data for later
                //for now we just respond to the listener
                listener.onSuccess(user);
            }
            @Override
            public void onError() {
                listener.onError();
            }
        });


    }
}