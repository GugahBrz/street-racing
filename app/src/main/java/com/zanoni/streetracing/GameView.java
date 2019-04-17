package com.zanoni.streetracing;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class GameView extends GLSurfaceView {
    private GameRenderer renderer;

    public GameView(Context context){
        super(context);
        renderer = new GameRenderer();
        this.setRenderer(renderer);
    }
}
