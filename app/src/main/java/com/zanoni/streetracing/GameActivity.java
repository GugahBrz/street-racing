package com.zanoni.streetracing;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;

public class GameActivity extends Activity implements SensorEventListener {
    private GameView view;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define and set view
        view = new GameView(this);
        setContentView(view);
        // Register the sensor listener
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sensorManager.SENSOR_DELAY_NORMAL);
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

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            Global.ACCELEROMETER_X = event.values[0];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // (?)
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
