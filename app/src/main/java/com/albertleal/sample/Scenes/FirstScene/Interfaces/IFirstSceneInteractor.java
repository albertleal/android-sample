package com.albertleal.sample.Scenes.FirstScene.Interfaces;

import com.albertleal.sample.Helpers.CustomResponseListener;
import com.albertleal.sample.Entities.UserModel;


public interface IFirstSceneInteractor {

    void fetchUser(final CustomResponseListener listener);
}

