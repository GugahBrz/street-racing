package com.zanoni.streetracing;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {
    private GameView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define and set view
        view = new GameView(this);
        setContentView(view);
    }

    // The following methods are designed to
    // handle possible interruptions

    @Override
    protected void onResume() {
        super.onResume();
        view.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        view.onPause();
    }

}
