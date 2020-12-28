package com.mohammedherezcolorx.colorx;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class rgb_to_hex extends AppCompatActivity {
    HexOrRGB rgbTOHex = new HexOrRGB();
    SeekBar redseekbar,greenseekbar,blueseekbar;
    ConstraintLayout rgb_to_hex_cv_main;
    TextView hextext, redtext, greentext, bluetext;
    int Rprogress=250, Gprogress=250, Bprogress=250;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgb_to_hex);

        rgb_to_hex_cv_main = findViewById(R.id.rgb_to_hex_cv_main);
        hextext = findViewById(R.id.hex_text);
        redtext = findViewById(R.id.red_text);
        greentext = findViewById(R.id.green_text);
        bluetext = findViewById(R.id.blue_text);

        redseekbar = findViewById(R.id.red_seekbar);
        greenseekbar = findViewById(R.id.green_seekbar);
        blueseekbar = findViewById(R.id.blue_seekbar);

        Animation Oanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        rgb_to_hex_cv_main.startAnimation(Oanim);
        hextext.startAnimation(Oanim);
        redtext.startAnimation(Oanim);
        greentext.startAnimation(Oanim);


        redseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Rprogress = progress;
                rgbTOHex.setR(progress);
                hextext.setText(rgbTOHex.getHex());
                redtext.setText(String.valueOf(progress));
                rgb_to_hex_cv_main.setBackgroundColor(Color.parseColor(rgbTOHex.getHex()));

                if(Rprogress<100 || Gprogress<100 || Bprogress<100){
                    hextext.setTextColor(Color.parseColor("#FFFFFF"));
                    redtext.setTextColor(Color.parseColor("#FFFFFF"));
                    greentext.setTextColor(Color.parseColor("#FFFFFF"));
                    bluetext.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else{
                    hextext.setTextColor(Color.parseColor("#00000E"));
                    redtext.setTextColor(Color.parseColor("#00000E"));
                    greentext.setTextColor(Color.parseColor("#00000E"));
                    bluetext.setTextColor(Color.parseColor("#00000E"));
                }

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        greenseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Gprogress = progress;
                rgbTOHex.setG(progress);
                hextext.setText(rgbTOHex.getHex());
                greentext.setText(String.valueOf(progress));
                rgb_to_hex_cv_main.setBackgroundColor(Color.parseColor(rgbTOHex.getHex()));
                if(Rprogress<100 || Gprogress<100 || Bprogress<100){
                    hextext.setTextColor(Color.parseColor("#FFFFFF"));
                    redtext.setTextColor(Color.parseColor("#FFFFFF"));
                    greentext.setTextColor(Color.parseColor("#FFFFFF"));
                    bluetext.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else{
                    hextext.setTextColor(Color.parseColor("#00000E"));
                    redtext.setTextColor(Color.parseColor("#00000E"));
                    greentext.setTextColor(Color.parseColor("#00000E"));
                    bluetext.setTextColor(Color.parseColor("#00000E"));
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        blueseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Bprogress = progress;
                rgbTOHex.setB(progress);
                hextext.setText(rgbTOHex.getHex());
                bluetext.setText(String.valueOf(progress));
                rgb_to_hex_cv_main.setBackgroundColor(Color.parseColor(rgbTOHex.getHex()));
                if(Rprogress<100 || Gprogress<100 || Bprogress<100){
                    hextext.setTextColor(Color.parseColor("#FFFFFF"));
                    redtext.setTextColor(Color.parseColor("#FFFFFF"));
                    greentext.setTextColor(Color.parseColor("#FFFFFF"));
                    bluetext.setTextColor(Color.parseColor("#FFFFFF"));
                }
                else{
                    hextext.setTextColor(Color.parseColor("#00000E"));
                    redtext.setTextColor(Color.parseColor("#00000E"));
                    greentext.setTextColor(Color.parseColor("#00000E"));
                    bluetext.setTextColor(Color.parseColor("#00000E"));
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        hextext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Color has been copied..",Toast.LENGTH_SHORT).show();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("color", rgbTOHex.getHex());
                clipboard.setPrimaryClip(clip);
            }
        });




    }



}