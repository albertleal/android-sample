package com.albertleal.sample.Scenes.FirstScene.Interfaces;

public interface IFirstSceneView {

    void showProgressBar();
    void hideProgressBar();
    void navigateToSecondScene();

    void changeTextViewWithResource();
    void changeTextViewWithText(String string);
    void updateProgressBar(int percentage);

}
