package com.albertleal.sample.Scenes.Boot;

import com.albertleal.sample.Helpers.Callback;
import com.albertleal.sample.Scenes.Boot.Interfaces.IBootSceneActivity;
import com.albertleal.sample.Scenes.Boot.Interfaces.IBootSceneInteractor;
import com.albertleal.sample.Scenes.Boot.Interfaces.IBootScenePresenter;

import java.util.Timer;
import java.util.TimerTask;

public class BootScenePresenter implements IBootScenePresenter {


    private IBootSceneActivity view;
    private IBootSceneInteractor interactor;

    //The constructor where we are going to initialize and parametrize
    public BootScenePresenter(IBootSceneActivity view) {
        this.interactor = new BootSceneInteractor();
        this.view = view;
    }

    @Override
    public void boot() {
        this.interactor.isUserLogedIn(new Callback() {
            @Override
            public void onSuccess(Object responseObject) {
                view.navigateToPrivate();
            }

            @Override
            public void onError() {
                view.navigateToPublic();
            }
        });

    }
}
