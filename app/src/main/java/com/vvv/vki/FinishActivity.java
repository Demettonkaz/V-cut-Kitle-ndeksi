package com.vvv.vki;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class FinishActivity extends Activity
{
    private AdView banner;
    TextView txt1,txt2;
    public String w,h;
    public String vkiYdk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish_screen);

        MobileAds.initialize(this, "ca-app-pub-3740483491697462~2086290172");
        banner=findViewById(R.id.banner);
        AdRequest adRequest=new AdRequest.Builder().build();
        banner.loadAd(adRequest);

        banner.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                Log.e("banner","onAdLoaded çalıştı");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                Log.e("banner","onAdFailedToLoad çalıştı");
            }

            @Override
            public void onAdOpened() {
                Log.e("banner","onAdOpened çalıştı");
            }

            @Override
            public void onAdLeftApplication() {
                Log.e("banner","onAdLeftApplication çalıştı");
            }

            @Override
            public void onAdClosed() {
                Log.e("banner","onAdClosed çalıştı");
            }
        });

        w=(getIntent().getExtras().getString("weight"));
        h=(getIntent().getExtras().getString("height"));
        txt1 = findViewById(R.id.textView1);
        txt2 = findViewById(R.id.textView2);

        float kilo=Float.parseFloat(w);
        float boy=Float.parseFloat(h);

        float vki = (kilo/(boy*boy))*10000;
        //DecimalFormat df = new DecimalFormat("#.00");
        //float vki2 = Float.valueOf(df.format(vki));

        //vkiYdk = Float.toString(vki);

        txt1.setText(String.format("%.02f",vki));

        if (vki<=18.5)
        {
            txt2.setText("zayıf");
        }
        else if (18.5<=vki && vki<=24.9)
        {
            txt2.setText("normal");
        }
        else if (25.0<=vki && vki<=29.9)
        {
            txt2.setText("fazla kilolu");
        }
        else if (30.0<=vki && vki<=34.9)
        {
            txt2.setText("1.derece obez");
        }
        else if (35.0<=vki && vki<=40)
        {
            txt2.setText("2.derece obez");
        }
        else
            txt2.setText("3.derece obez");

    }

}

