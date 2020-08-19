package com.crisspian.recyclerviewexamples_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
 ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Animation animaMov1 = AnimationUtils.loadAnimation(Splash.this,R.anim.mov);

        img = findViewById(R.id.img_sol);
        img.startAnimation(animaMov1);

        new Handler().postDelayed(new Runnable(){
            @Override
            public  void run(){
                Intent intent=new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}