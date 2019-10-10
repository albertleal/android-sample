package com.albertleal.sample.Scenes.FirstScene;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.albertleal.sample.Helpers.BaseActivity;
import com.albertleal.sample.Helpers.Drawable;
import com.albertleal.sample.R;
import com.albertleal.sample.Scenes.FirstScene.Interfaces.IFirstSceneActivity;
import com.albertleal.sample.Scenes.SecondScene.SecondSceneActivity;

public class FirstSceneActivity extends BaseActivity implements IFirstSceneActivity {

    private FirstScenePresenter presenter;
    private ProgressBar progressBar;
    private Button acceptButton;

    //Setting up the event listenrs Objects
    private View.OnClickListener acceptEventListener = new View.OnClickListener() {
        public void onClick(View v) {
            presenter.acceptButtonTapped();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_scene);

        //Setup UI variables so they can be used
        this.progressBar = this.findViewById(R.id.progressBar);
        this.acceptButton = this.findViewById(R.id.sampleButton);

        //Setup the presenter
        this.presenter = new FirstScenePresenter(this);

        //Setup UI Events Listeners
        this.acceptButton.setOnClickListener(acceptEventListener);

    }

    @Override
    public void showError() {
        Drawable _showErrorDrawable = new Drawable() {
            @Override
            public void draw() {
                Toast.makeText(FirstSceneActivity.this, FirstSceneActivity.this.getText(R.string.error), Toast.LENGTH_LONG).show();
            }
        };

        this.draw(_showErrorDrawable);
    }

    @Override
    public void updateProgressBar(final int percentage) {
        this.draw(new Drawable() {
            @Override
            public void draw() {
                progressBar.setProgress(percentage);
            }
        });
    }

    @Override
    public void hideProgressBar() {

        //Can't guarantee hide is done always on the main thread
        this.draw(new Drawable() {
            @Override
            public void draw() {
               progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void showProgressBar() {
        this.draw(new Drawable() {
            @Override
            public void draw() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void navigateToSecondScene() {
        this.draw(new Drawable() {
            @Override
            public void draw() {
                Intent view = new Intent(FirstSceneActivity.this, SecondSceneActivity.class);
                view.setAction(Intent.ACTION_VIEW);
                startActivity(view);
            }
        });

    }

    @Override
    public void blockButton() {
        this.draw(new Drawable() {
            @Override
            public void draw() {
                acceptButton.setEnabled(false);
            }
        });
    }

    @Override
    public void unblockButton() {
        this.draw(new Drawable() {
            @Override
            public void draw() {
                acceptButton.setEnabled(true);
            }
        });
    }
}
