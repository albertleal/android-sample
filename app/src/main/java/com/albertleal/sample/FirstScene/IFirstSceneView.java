package com.albertleal.sample.FirstScene;

public interface IFirstSceneView {

    void showProgressBar();
    void hideProgressBar();
    void navigateToSecondScene();

    void changeTextViewWithResource();
    void changeTextViewWithText(String string);
    void updateProgressBar(int percentage);

}
