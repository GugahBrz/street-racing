package com.zanoni.streetracing;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameRenderer implements GLSurfaceView.Renderer {
    private Road road = new Road();
    private Car car = new Car();

    private long loopStart = 0;
    private long loopEnd = 0;
    private long loopRunTime = 0;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // Load textures
        road.loadTexture(gl, Global.GAME_ROAD, Global.context);
        car.loadTexture(gl, Global.PLAYER_CAR, Global.context);
        // Enable 2D capability
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glClearDepthf(1.0f);
        // Text depth
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        // Blend to enable transparency
        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // Set position and size
        gl.glViewport(0, 0, width, height);
        // Put the matrix in projection mode to access glOrthof()
        gl.glMatrixMode(GL10.GL_PROJECTION);
        // Load current identity of state
        gl.glLoadIdentity();
        // Set orthogonal dimension of scene
        gl.glOrthof(0f, 1f, 0f, 1f, -1f, 1f);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        loopStart = System.currentTimeMillis();
        try {
            if (loopRunTime < Global.GAME_THREAD_FPS_SLEEP) {
                Thread.sleep(Global.GAME_THREAD_FPS_SLEEP - loopRunTime);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        drawRoad(gl);
        drawCar(gl);

        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
    }

    public void drawRoad(GL10 gl) {
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glPushMatrix();
        gl.glScalef(1f, 1f, 1f);
        gl.glTranslatef(0f, 0f, 0f);
        gl.glMatrixMode(GL10.GL_TEXTURE);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, 0.0f);
        road.draw(gl);
        gl.glPopMatrix();
        gl.glLoadIdentity();
    }

    public void drawCar(GL10 gl) {
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glPushMatrix();
        // gl.glScalef(0.15f, Global.getProportionalHeight(0.15f), 0.15f);
        gl.glScalef(0.3f, Global.getProportionalHeight(0.6f), 0.15f);
        gl.glTranslatef(1.2f, 0.25f, 0f);
        gl.glMatrixMode(GL10.GL_TEXTURE);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, 0.0f);
        car.draw(gl);
        gl.glPopMatrix();
        gl.glLoadIdentity();
    }
}
