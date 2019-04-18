package com.zanoni.streetracing;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class GameActivity extends Activity {
    private GameView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define and set view
        view = new GameView(this);
        setContentView(view);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Switch action
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                Global.PLAYER_ACTION = Global.ACTION_DOWN;
                break;
            case MotionEvent.ACTION_UP :
                Global.PLAYER_ACTION = Global.CONTROL_RELEASED;
                break;
        }
        return false;
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
