package com.darkmind.onemoreshot;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Random;


/**
 * Created by sergi on 30/08/2017.
 */

public class RandomMeme  extends AppCompatActivity {

    private int ads = 0;
    private int MAXADS = 4;
    private AdView ad = null;
    private AdRequest adr = null;
    private MemeBoton randomBtn = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_random);

        randomBtn = new MemeBoton(this,R.drawable.randomshrek,null);

        //crear Random
        RelativeLayout relative = (RelativeLayout) findViewById(R.id.RelativeRandom);
        relative.addView(randomBtn );
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) randomBtn.getLayoutParams();
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        randomBtn.setLayoutParams(layoutParams);

        //anuncios

        ad = (AdView)findViewById(R.id.ad3);
        adr = new AdRequest.Builder().build();
        ad.loadAd(adr);


        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MemeBoton a = ((MemeBoton)v);

                //parte anuncios

                ads++;
                if(ads == MAXADS){
                    adr = new AdRequest.Builder().build();
                    ad.loadAd(adr);

                    ads = 0;
                }


                //parte musica
                if(a.isPlaying()){
                    a.stopMp3();
                    a.releaseMp3();
                    a.setMp3(getApplicationContext(),randomNumber(MemeBoton.getMaxSongs()));
                    a.playMp3();
                } else{
                    a.setMp3(getApplicationContext(),randomNumber(MemeBoton.getMaxSongs()));
                    a.playMp3();
                }
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        randomBtn.stopMp3();
    }

    private int randomNumber(int max){
        Random rn = new Random();
        return rn.nextInt(max);
    }
}
