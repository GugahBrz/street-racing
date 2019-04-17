package com.zanoni.streetracing;

import android.content.Context;
import android.view.Display;

public class Global {
    // Constants
    public static final int GAME_THREAD_FPS_SLEEP = (1000/60);

    // Variables
    public static Context context;
    public static Display display;
    public static int PLAYER_ACTION = 0;
    public static int GAME_SCREEN_WIDTH = 1000;
    public static int GAME_SCREEN_HEIGHT = 3000;

    // Textures
    public static int PLAYER_CAR = R.drawable.car_red;
    public static int GAME_ROAD = R.drawable.road2;

    // Functions
    public static float getProportionalHeight(float width) {
        float ratio = (float)display.getWidth()/display.getHeight();
        float height = ratio * width;
        return height;
    }
}
