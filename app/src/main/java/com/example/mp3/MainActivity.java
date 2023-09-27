//import androidx.appcompat.app.AppCompatActivity;
//
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.view.View;
//
//public class MainActivity extends AppCompatActivity {
//    MediaPlayer player;
//    public  void play(View view){
//        player.start();
//    }
//    public  void pause(View view){
//        player.pause();
//    }
//    public  void stop(View view){
//        player.stop();
//    }
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        player =MediaPlayer.create(this,R.raw.downloadmp3);
//    }
//}


package com.example.mp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Switch;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player1;

    MediaPlayer player2;
    MediaPlayer player3;
    AudioManager audioManagers;



    Switch switchDarkMode;

    public void play1(View view) {
        player1.start();
    }

    public void pause1(View view) {
        player1.pause();
    }

    public void stop1(View view) {
        player1.stop();
    }
    public void play2(View view) {
        player2.start();
    }
    public void pause2(View view) {
        player2.pause();
    }

    public void stop2(View view) {
        player2.stop();
    }
    public void play3(View view) {
        player3.start();
    }
    public void pause3(View view) {
        player3.pause();
    }

    public void stop3(View view) {
        player3.stop();
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize MediaPlayer
        player1 = MediaPlayer.create(this, R.raw.download0112);
        player2 = MediaPlayer.create(this, R.raw.download8);
        player3=MediaPlayer.create(this,R.raw.download7);
        audioManagers=(AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVol= audioManagers.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol= audioManagers.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar seekVol=findViewById(R.id.seekVol);
        seekVol.setMax(maxVol);
        seekVol.setProgress(curVol);
        seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManagers.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





        SeekBar seekProg1 = findViewById(R.id.seekProg1);
        seekProg1.setMax(player1.getDuration());

// Update SeekBar progress at regular intervals
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        seekProg1.setProgress(player1.getCurrentPosition());
                    }
                });
            }
        }, 0, 1000); // Update every 1 second (adjust the interval as needed)

// SeekBar change listener to seek the media player when the user interacts with the SeekBar
        seekProg1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    player1.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for your current implementation
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed for your current implementation
            }
        });
        SeekBar seekProg2 = findViewById(R.id.seekProg2);
        seekProg2.setMax(player2.getDuration());

// Update SeekBar progress at regular intervals
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        seekProg2.setProgress(player2.getCurrentPosition());
                    }
                });
            }
        }, 0, 1000); // Update every 1 second (adjust the interval as needed)

// SeekBar change listener to seek the media player when the user interacts with the SeekBar
        seekProg2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    player2.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for your current implementation
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed for your current implementation
            }
        });
        SeekBar seekProg3 = findViewById(R.id.seekProg3);
        seekProg3.setMax(player3.getDuration());

// Update SeekBar progress at regular intervals
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        seekProg3.setProgress(player3.getCurrentPosition());
                    }
                });
            }
        }, 0, 1000); // Update every 1 second (adjust the interval as needed)

// SeekBar change listener to seek the media player when the user interacts with the SeekBar
        seekProg3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    player3.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Not needed for your current implementation
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Not needed for your current implementation
            }

        });
        // Initialize Switch
        switchDarkMode = findViewById(R.id.switch_dark_mode);
        switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Enable Dark Mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                // Disable Dark Mode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

    }
}
