package com.mohammedherezcolorx.colorx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView spalch_iv_logo;
    private ConstraintLayout splach_cl_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spalch_iv_logo = (ImageView) findViewById(R.id.splach_iv_logo);
        splach_cl_main = (ConstraintLayout) findViewById(R.id.splach_cl_main);

        Animation startscreen = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        spalch_iv_logo.startAnimation(startscreen);
        splach_cl_main.startAnimation(startscreen);

        final Intent intent = new Intent(MainActivity.this, home.class);

        Thread timer = new Thread(){
            public  void  run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    return;
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };

        timer.start();

    }
}