package com.game.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView tic,tac,toe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        tic=findViewById(R.id.txtTic);
        tac=findViewById(R.id.txtTac);
        toe=findViewById(R.id.txtToe);

        Animation my_tic = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tic_anim);
        Animation my_tac = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tac_anim);
        Animation my_toe = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.toe_anim);

        tic.startAnimation(my_tic);
        tac.startAnimation(my_tac);
        toe.startAnimation(my_toe);

        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        },6000);
    }
}