package com.albertleal.sample.FirstScene;

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

        this.view.hideLoading();
        this.view.navigateToSecondScene();
    }
}
