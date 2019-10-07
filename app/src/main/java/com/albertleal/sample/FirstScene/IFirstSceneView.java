package com.albertleal.sample.FirstScene;

public interface IFirstSceneView {

    void showLoading();
    void hideLoading();
    void navigateToSecondScene();

    void changeTextViewWithResource();
    void changeTextViewWithText(String string);

}
