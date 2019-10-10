package com.albertleal.sample.Scenes.FirstScene;

import com.albertleal.sample.Helpers.Callback;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstSceneInteractor;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstScenePresenter;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstSceneActivity;


import java.util.Timer;
import java.util.TimerTask;

public class FirstScenePresenter implements IFirstScenePresenter {
    private IFirstSceneActivity view;
    private IFirstSceneInteractor interactor;

    //The constructor where we are going to initialize and parametrize
    public FirstScenePresenter(IFirstSceneActivity view) {
        this.interactor = new FirstSceneInteractor();
        this.view = view;

        //Set initial UI state
        this.view.hideProgressBar();

    }


    @Override
    public void acceptButtonTapped() {

        //Showing the progressBar
        this.view.blockButton();
        this.view.showProgressBar();

        for (int i= 0 ; i <= 100; i++) {
            final int percentage = i;
            final int afterMilliSeconds = 10 * i;

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    view.updateProgressBar(percentage);
                }
            }, afterMilliSeconds);

        }

        this.interactor.retrieveUser(new Callback() {
            @Override
            public void onSuccess(Object user) {
                view.hideProgressBar();
                view.navigateToSecondScene();
            }

            @Override
            public void onError() {
                view.hideProgressBar();
                view.unblockButton();
                view.showError();
            }
        });

    }
}
