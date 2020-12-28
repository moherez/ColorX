package com.mohammedherezcolorx.colorx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class hex_to_rgb extends AppCompatActivity {
    TextView hex_to_rgb_rval, hex_to_rgb_gval, hex_to_rgb_bval;
    EditText hex_to_rgb_et_hex;
    ConstraintLayout themain;
    private ArrayList<Character> AllHexChar = new ArrayList<Character>();
    HexOrRGB hexTORgb_object = new HexOrRGB();
    boolean chake = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_to_rgb);



        AllHexChar.add('0') ; AllHexChar.add('1') ; AllHexChar.add('2') ; AllHexChar.add('3') ;
        AllHexChar.add('4') ; AllHexChar.add('5') ; AllHexChar.add('6') ; AllHexChar.add('7') ; AllHexChar.add('8') ;
        AllHexChar.add('9') ; AllHexChar.add('A') ; AllHexChar.add('B') ; AllHexChar.add('C') ; AllHexChar.add('D') ;
        AllHexChar.add('E') ; AllHexChar.add('F') ;


        //Views
        themain = (ConstraintLayout) findViewById(R.id.themain);
        hex_to_rgb_rval = (TextView) findViewById(R.id.hex_to_rgb_rval);
        hex_to_rgb_gval = (TextView) findViewById(R.id.hex_to_rgb_gval);
        hex_to_rgb_bval = (TextView) findViewById(R.id.hex_to_rgb_bval);
        hex_to_rgb_et_hex = (EditText) findViewById(R.id.hex_to_rgb_et_hex);

        Animation Oanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        themain.startAnimation(Oanim);
        hex_to_rgb_et_hex.startAnimation(Oanim);
        hex_to_rgb_rval.startAnimation(Oanim);
        hex_to_rgb_gval.startAnimation(Oanim);
        hex_to_rgb_bval.startAnimation(Oanim);


        hex_to_rgb_et_hex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                StringBuilder sd = new StringBuilder(hex_to_rgb_et_hex.getText().toString());


                if(!hex_to_rgb_et_hex.getText().toString().isEmpty()){
                    if(hex_to_rgb_et_hex.getText().toString().charAt(0) != '#') hex_to_rgb_et_hex.setText("#");
                    hex_to_rgb_et_hex.setSelection(hex_to_rgb_et_hex.getText().toString().length());
                }

                if (hex_to_rgb_et_hex.getText().toString().isEmpty()){
                    hex_to_rgb_et_hex.setText("#");
                    hex_to_rgb_et_hex.setSelection(hex_to_rgb_et_hex.getText().toString().length());
                }

                if(hex_to_rgb_et_hex.getText().toString().length() >7){
                    sd.deleteCharAt(7);
                    hex_to_rgb_et_hex.setText(sd.toString().toUpperCase());
                    hex_to_rgb_et_hex.setSelection(hex_to_rgb_et_hex.getText().toString().length());
                }

                boolean hjj= true;
                if(!hex_to_rgb_et_hex.getText().toString().isEmpty()){

                    for(int i=1; i<sd.toString().length(); i++){
                        if(!AllHexChar.contains(sd.toString().toUpperCase().charAt(i))){
                            hex_to_rgb_et_hex.setError("Sorry, the code contains an invalid number, the hex number must contain 1-9 or A-F only.");

                            hex_to_rgb_et_hex.setTextColor(Color.parseColor("#D32F2F"));
                            hjj=false;

                        }
                 }
                    if (hjj){
                        chake=true;
                    }
                    else {
                        hex_to_rgb_et_hex.setTextColor(Color.parseColor("#0F0F0F"));
                        chake=false;
                        hjj=true;


                    }
            }


                if (s.toString().length() == 7 && chake){
                    hexTORgb_object.setHex(sd.toString().toUpperCase());
                    hex_to_rgb_rval.setText(hexTORgb_object.getR());
                    hex_to_rgb_gval.setText(hexTORgb_object.getG());
                    hex_to_rgb_bval.setText(hexTORgb_object.getB());
                }


        }
    });

        hex_to_rgb_rval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Red has been copied..",Toast.LENGTH_SHORT).show();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("color", hexTORgb_object.getR());
                clipboard.setPrimaryClip(clip);
            }
        });

        hex_to_rgb_gval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Geen has been copied..",Toast.LENGTH_SHORT).show();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("color", hexTORgb_object.getG());
                clipboard.setPrimaryClip(clip);
            }
        });

        hex_to_rgb_bval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Blue has been copied..",Toast.LENGTH_SHORT).show();

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("color", hexTORgb_object.getB());
                clipboard.setPrimaryClip(clip);
            }
        });
}
}