package com.albertleal.sample.Scenes.FirstScene;

import com.albertleal.sample.Entities.*;
import com.albertleal.sample.Helpers.CustomResponseListener;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstSceneInteractor;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstScenePresenter;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstSceneView;


import java.util.Timer;
import java.util.TimerTask;

public class FirstScenePresenter implements IFirstScenePresenter {
    private AppModel app;
    private IFirstSceneView view;
    private IFirstSceneInteractor interactor;

    //The constructor where we are going to initialize and parametrize
    public FirstScenePresenter(IFirstSceneView view) {
        this.app = new AppModel();
        this.interactor = new FirstSceneInteractor();
        this.view = view;
    }


    @Override
    public void animateLogin() {
        //changing some UI
        this.view.changeTextViewWithResource();

        //Showing the progressBar
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

        this.interactor.fetchUser(new CustomResponseListener() {
            @Override
            public void onResponseReceived(Object user) {
                view.hideProgressBar();
                view.navigateToSecondScene();
            }

            @Override
            public void onError() {
                view.changeTextViewWithText("There's been an error");
            }
        });

    }
}
