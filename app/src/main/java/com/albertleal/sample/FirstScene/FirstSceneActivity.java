package com.albertleal.sample.FirstScene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.albertleal.sample.R;
import com.albertleal.sample.SecondScene.SecondSceneActivity;

public class FirstSceneActivity extends AppCompatActivity implements IFirstSceneView {

    private FirstScenePresenter presenter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup UI variables so they can be used
        this.progressBar = this.findViewById(R.id.progressBar);

        //Setup the presenter
        this.presenter = new FirstScenePresenter(this);

        //Setup UI Events Listeners
        this.findViewById(R.id.sampleButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.animateLogin();
            }
        });

    }

    @Override
    public void updateProgressBar(final int percentage) {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(percentage);
            }
        });
    }

    @Override
    public void changeTextViewWithText(String string) {
        TextView tv = this.findViewById(R.id.sampleTextView);
        tv.setText(string);
    }

    @Override
    public void changeTextViewWithResource() {
        String string = getString(R.string.sample_text);
        this.changeTextViewWithText(string);
    }

    @Override
    public void hideProgressBar() {
        //Can't guarantee hide is done always on the main thread
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void showProgressBar() {
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void navigateToSecondScene() {
        Intent view = new Intent(this, SecondSceneActivity.class);
        view.setAction(Intent.ACTION_VIEW);
        startActivity(view);
    }
}
