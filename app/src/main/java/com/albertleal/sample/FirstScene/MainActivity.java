package com.albertleal.sample.FirstScene;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.albertleal.sample.R;

public class MainActivity extends AppCompatActivity implements IFirstSceneView {

    private FirstScenePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.presenter = new FirstScenePresenter(this);

        //Automated call to setup
        presenter.setupApp();
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
        Toast.makeText(this, "Hide Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Show Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToSecondScene() {
        Toast.makeText(this, "navigateToSecondScene", Toast.LENGTH_SHORT).show();
    }
}
