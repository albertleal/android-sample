package com.albertleal.sample.FirstScene;

import java.util.Timer;
import java.util.TimerTask;

public class FirstScenePresenter implements IFirstScenePresenter {
    private AppModel app;
    private IFirstSceneView view;

    //The constructor where we are going to initialize and parametrize
    public FirstScenePresenter(IFirstSceneView view) {
        this.app = new AppModel();
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

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                view.hideProgressBar();
                view.navigateToSecondScene();
            }
        }, 1000);
    }
}
