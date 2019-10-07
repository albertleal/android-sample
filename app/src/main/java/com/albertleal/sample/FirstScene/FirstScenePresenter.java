package com.albertleal.sample.FirstScene;

import java.util.Timer;
import java.util.TimerTask;

public class FirstScenePresenter implements IFirstScenePresenter {
    private AppModel app;
    private IFirstSceneView view;


    public FirstScenePresenter(IFirstSceneView view) {
        this.app = new AppModel();
        this.view = view;
    }


    @Override
    public void setupApp() {
        this.view.showLoading();
        this.view.changeTextViewWithResource();
        this.app.setStatus(true);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                view.hideLoading();
                view.navigateToSecondScene();
            }
        }, 2000);
    }
}
