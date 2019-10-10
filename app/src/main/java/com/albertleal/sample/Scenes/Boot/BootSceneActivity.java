package com.albertleal.sample.Scenes.Boot;

import com.albertleal.sample.R;
import com.albertleal.sample.Scenes.Boot.Interfaces.IBootSceneActivity;
import com.albertleal.sample.Scenes.FirstScene.FirstSceneActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class BootSceneActivity extends Activity implements IBootSceneActivity {

    private BootScenePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_scene);

        //Setup the presenter
        this.presenter = new BootScenePresenter(this);

        presenter.boot();
    }

    @Override
    public void navigateToPublic() {
        Intent view = new Intent(BootSceneActivity.this, FirstSceneActivity.class);
        view.setAction(Intent.ACTION_VIEW);
        startActivity(view);
    }

    @Override
    public void navigateToPrivate() {

    }
}
