package com.darkmind.onemoreshot;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class StartMenu extends AppCompatActivity {

    public static final int NORMAL = 1;
    public static final int HALLOWEEN = 2;
    public static final int GOTY = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_start_menu);

        Button btnMemes = findViewById(R.id.MenuMemesBtn);
        btnMemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMemes();
            }
        });

        Button btnRandom = findViewById(R.id.RandomBtn);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRandom();
            }
        });

        Button btnHalloween = findViewById(R.id.HalloweenBtn);
        btnHalloween.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHalloween();
            }
        });

        Button btnGoty = findViewById(R.id.GotyBtn);
        btnGoty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGoty();
            }
        });

        //publicidad

        AdView ad = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        ad.loadAd(adRequest);
    }

    private void startMemes(){
        Intent i = new Intent(this, Memes.class);
        Bundle b = new Bundle();
        b.putInt("id", NORMAL);
        i.putExtras(b);
        startActivity(i);
    }

    private void startRandom(){
        Intent i = new Intent(this, RandomMeme.class);
        startActivity(i);
    }

    private void startHalloween(){
        Intent i = new Intent(this, Memes.class);
        Bundle b = new Bundle();
        b.putInt("id", HALLOWEEN);
        i.putExtras(b);
        startActivity(i);
    }

    private void startGoty(){
        Intent i = new Intent(this, Memes.class);
        Bundle b = new Bundle();
        b.putInt("id", GOTY);
        i.putExtras(b);
        startActivity(i);
    }
}
