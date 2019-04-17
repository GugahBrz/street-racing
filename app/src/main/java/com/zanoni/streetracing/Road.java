package com.zanoni.streetracing;

public class Road extends Texture {
    private static float texture[] = {
            0.0f, 0.0f,
            1.0f, 0.0f,
            1.0f, 1.5f,
            0.0f, 1.5f
    };

    public Road() {
        super(texture);
    }
}
