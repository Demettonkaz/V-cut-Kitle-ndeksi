package com.vvv.vki;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class WeightActivity extends Activity {

    private SeekBar seekBarKilo;
    private TextView textViewKilo,textView;
    private Button buttonIleri;

    public int weightValue;

    private static int gosterim_suresi = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.TextView);
        textViewKilo = findViewById(R.id.TextViewKilo);
        seekBarKilo = findViewById(R.id.SeekBarKilo);
        buttonIleri = findViewById(R.id.ButtonIleri);

        seekBarKilo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                weightValue=i;
                textView.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonIleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String weightVal = Integer.toString(weightValue);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent i = new Intent(WeightActivity.this, HeightActivity.class);
                        i.putExtra("weight",weightVal);

                        startActivity(i);
                        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                        finish();
                    }
                }, gosterim_suresi);

//                String weightVal = Integer.toString(weightValue);
//
//                Intent i = new Intent(getApplicationContext(), HeightActivity.class);
//                i.putExtra("weight",weightVal);
//                startActivity(i);
            }
        });




    }
}
