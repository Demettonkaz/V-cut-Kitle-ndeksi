package com.vvv.vki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HeightActivity extends Activity {

    Button buttonHesapla;
    SeekBar seekBarBoy;
    TextView textView,textViewBoy;

    public String weightValue;
    public int heightValue;

    private static int gosterim_suresi = 1000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.height_screen);

        seekBarBoy = findViewById(R.id.SeekBarBoy);
        textView = findViewById(R.id.TextView);
        buttonHesapla = findViewById(R.id.ButtonHesapla);
        textViewBoy = findViewById(R.id.textViewBoy);

        weightValue = (getIntent().getExtras().getString("weight"));

        seekBarBoy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                heightValue =i;
                textView.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String heightVal = Integer.toString(heightValue);


                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent i = new Intent(HeightActivity.this, FinishActivity.class);
                        i.putExtra("height",heightVal);
                        i.putExtra("weight",weightValue);

                        startActivity(i);
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                        finish();
                    }
                }, gosterim_suresi);

//
//                String heightVal = Integer.toString(heightValue);
//
//                Intent i = new Intent(getApplicationContext(),FinishActivity.class);
//                i.putExtra("height",heightVal);
//                i.putExtra("weight",weightValue);
//                startActivity(i);
            }
        });

    }
}
