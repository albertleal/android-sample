package com.albertleal.sample.Helpers;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void draw(final Drawable drawable) {
        //We'll guarantee that any Draw operation happens on the UI Thread
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                drawable.draw();
            }
        });
    }
}
