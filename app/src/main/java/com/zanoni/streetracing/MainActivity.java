package com.zanoni.streetracing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Define Global's
        Global.context = getApplicationContext();
        Global.display = ((WindowManager) getSystemService(Global.context.WINDOW_SERVICE)).getDefaultDisplay();
        Global.musicThread = new Thread(){
            @Override
            public void run() {
                Intent musicIntent = new Intent(getApplicationContext(), Music.class);
                startService(musicIntent);
            }
        };
        Global.musicThread.start();

        // Define btn_start_race
        ImageButton btn_start_race = findViewById(R.id.btn_start_race);
        // Set Listener
        btn_start_race.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start Game
                Intent it = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(it);
            }
        });
    }

}
