package com.zanoni.streetracing;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.Display;

public class Global {
    // Textures
    public static int PLAYER_CAR = R.drawable.car_red;
    public static int GAME_ROAD = R.drawable.road2;
    // Variables
    public static Context context;
    public static Display display;
    // Actions
    public static double ACCELEROMETER_X = 0.0;
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
