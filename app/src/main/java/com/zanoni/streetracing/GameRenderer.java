package com.zanoni.streetracing;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GameRenderer implements GLSurfaceView.Renderer {

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
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

    }
}
