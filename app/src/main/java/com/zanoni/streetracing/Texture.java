package com.zanoni.streetracing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Texture {
    private FloatBuffer vertBuf, textBuf;
    private ByteBuffer indexBuf;

    private int textures[] = new int[1];
    private float texture[];

    private float vertices[] = {
            0.0f, 0.0f, 0.0f,
            1.0f, 0.0f, 0.0f,
            1.0f, 1.0f, 0.0f,
            0.0f, 1.0f, 0.0f
    };

    private byte indexes[] = {
            0, 1, 2,
            0, 2, 3
    };

    public Texture(float[] _texture) {
        this.texture = _texture;
        ByteBuffer byteBuf;
        // Vertices
        byteBuf = ByteBuffer.allocateDirect(this.vertices.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        vertBuf = byteBuf.asFloatBuffer();
        vertBuf.put(this.vertices);
        vertBuf.position(0);
        // Texture
        byteBuf = ByteBuffer.allocateDirect(this.texture.length * 4);
        byteBuf.order(ByteOrder.nativeOrder());
        textBuf = byteBuf.asFloatBuffer();
        textBuf.put(this.texture);
        textBuf.position(0);
        // Indexes
        indexBuf = ByteBuffer.allocateDirect(this.indexes.length * 4);
        indexBuf.put(this.indexes);
        indexBuf.position(0);
    }

    public void loadTexture(GL10 gl, int texture, Context context) {
        // Get image stream from resources
        InputStream imageStream = context.getResources().openRawResource(texture);
        Bitmap bitmap = null;
        // Try to access the image by stream
        try {
            bitmap = BitmapFactory.decodeStream(imageStream);
        } catch(Exception e) {
            imageStream = null;
        } finally {
            try {
                imageStream.close();
                imageStream = null;
            } catch (IOException e) {
                imageStream = null;
            }
        }
        // Bind textures
        gl.glGenTextures(1, textures, 0);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, this.textures[0]);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();
    }

    public void draw(GL10 gl){
        gl.glBindTexture(GL10.GL_TEXTURE_2D, this.textures[0]);
        gl.glFrontFace(GL10.GL_CCW);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glCullFace(GL10.GL_BACK);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertBuf);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, textBuf);
        gl.glDrawElements(GL10.GL_TRIANGLES, this.indexes.length, GL10.GL_UNSIGNED_BYTE, indexBuf);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);
    }
}
