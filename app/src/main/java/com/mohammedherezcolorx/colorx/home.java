package com.mohammedherezcolorx.colorx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class home extends AppCompatActivity {


    //Views
    private ConstraintLayout home_cl_main;
    private CardView home_card_rgb, home_card_hex, home_card_randomcolor;
    private TextView home_tv_randomcolor, home_tv_random_rgb_val;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        HexOrRGB object_randomcolor = new HexOrRGB();
        Random randomcolor = new Random();
        object_randomcolor.setRgb(randomcolor.nextInt(250),randomcolor.nextInt(250),randomcolor.nextInt(250));


        //Intents
        Intent hexPage = new Intent(getBaseContext(),hex_to_rgb.class);
        Intent rgbPage = new Intent(getBaseContext(), rgb_to_hex.class);

        //Views bt Id
        home_cl_main = findViewById(R.id.home_cl_main);
        home_card_hex = findViewById(R.id.home_card_hex);
        home_card_rgb = findViewById(R.id.home_card_rgb);
        home_card_randomcolor = findViewById(R.id.home_card_plaeycolor);
        home_tv_randomcolor = findViewById(R.id.home_tv_randomcolor);
        home_tv_random_rgb_val = findViewById(R.id.home_tv_random_rgb_val);

        //random Color
        home_tv_randomcolor.setText(object_randomcolor.getHex());
        home_tv_randomcolor.setBackgroundColor(Color.parseColor(object_randomcolor.getHex()));
        home_tv_random_rgb_val.setText(
                "Red: " + object_randomcolor.getR() + "   " +
                "Green: " + object_randomcolor.getG() + "   " +
                "Blue: " + object_randomcolor.getB()
        );
        //anim
        Animation startscreentowO = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        home_cl_main.startAnimation(startscreentowO);


        //switch screen
       home_card_hex.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { startActivity(hexPage); }});
       home_card_rgb.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { startActivity(rgbPage); }});

        home_tv_randomcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Your random color has been copied..",Toast.LENGTH_SHORT).show();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("color", object_randomcolor.getB());
                clipboard.setPrimaryClip(clip);
            }
        });


    }
}