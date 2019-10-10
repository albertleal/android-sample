package com.albertleal.sample.Scenes.FirstScene.Interfaces;

public interface IFirstSceneActivity {

    void showProgressBar();
    void hideProgressBar();
    void updateProgressBar(int percentage);

    void blockButton();
    void unblockButton();

    void showError();

    void navigateToSecondScene();

}
