package com.albertleal.sample.FirstScene;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.albertleal.sample.R;

public class MainActivity extends AppCompatActivity implements IFirstSceneView {

    private FirstScenePresenter presenter;
    private ProgressBar progressBar;
    private void setUpLoading() {
        this.progressBar = this.findViewById(R.id.progressBar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setUpLoading();

        this.presenter = new FirstScenePresenter(this);

        final Button button = (Button) findViewById(R.id.sampleButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                presenter.setupApp();
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
    public void hideLoading() {
        //Can't garantee hide is done always on the main thread
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(100);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(50);
    }

    @Override
    public void navigateToSecondScene() {
        final MainActivity contextView = this;

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(contextView, "navigateToSecondScene", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
