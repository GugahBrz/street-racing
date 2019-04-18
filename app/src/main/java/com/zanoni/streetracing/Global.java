package com.zanoni.streetracing;

import android.content.Context;
import android.view.Display;

public class Global {
    // Constants
    public static final int GAME_THREAD_FPS_SLEEP = (1000/60);
    // Textures
    public static int PLAYER_CAR = R.drawable.car_red;
    public static int GAME_ROAD = R.drawable.road2;

    // Variables
    public static Context context;
    public static Display display;
    // Actions
    public static int PLAYER_ACTION = 0;
    public static final int CONTROL_RELEASED  = 0;
    public static final int ACTION_DOWN  = 1;

    // Functions
    public static float getProportionalHeight(float width) {
        float ratio = (float)display.getWidth()/display.getHeight();
        float height = ratio * width;
        return height;
    }
}
