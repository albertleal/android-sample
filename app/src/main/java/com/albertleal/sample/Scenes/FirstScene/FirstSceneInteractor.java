package com.albertleal.sample.Scenes.FirstScene;

import com.albertleal.sample.Helpers.CustomResponseListener;
import com.albertleal.sample.Entities.UserModel;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstSceneInteractor;

public class FirstSceneInteractor implements IFirstSceneInteractor {

    @Override
    public void fetchUser(final CustomResponseListener listener) {


        UserModel.fetch(new CustomResponseListener() {
            @Override
            public void onResponseReceived(Object user) {
                //we should save this data for later
                //for now we just respond to the listener
                listener.onResponseReceived(user);
            }
            @Override
            public void onError() {
                listener.onError();
            }
        });


    }
}