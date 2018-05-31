package com.darkmind.onemoreshot;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

/**
 * Created by sergi on 15/08/2017.
 */

public class Memes extends AppCompatActivity {

    //normal o evento
    private int evento = StartMenu.NORMAL;
    //array de imagenes para los botones
    private int []pictures = null;
    //maximo de botones
    private int MaxButtonY = 4;
    private int MaxButtonX = 5;
    private int MaxBotones = MaxButtonX * MaxButtonY;
    private int id = 0;
    //Mediaplayers
    private ArrayList<MediaPlayer> sounds;
    //pantalla
    private int pantalla = 1;
    //layouts
    private LinearLayout l1;
    private RelativeLayout r;
    private MemeBoton activo = null;
    private int height;
    //anuncios

    private int ads= 0;
    private int MAXADS = 12;
    private InterstitialAd adG = null;
    private AdRequest adGr = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Obtener extras
        Bundle b = getIntent().getExtras();
        if(b != null) evento = b.getInt("id");

        //Obtener tamaño de pantalla
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        height = (dm.heightPixels -180)/(MaxButtonY);

        setContentView(R.layout.activity_memes);

        //crear stop
        Button stop = (Button) findViewById(R.id.stopBtn);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activo != null){
                    if(activo.isPlaying()){
                        activo.stopMp3();
                        activo.releaseMp3();
                        activo = null;
                    }
                }
            }
        });

        //obtener los layout
        l1 = (LinearLayout) findViewById(R.id.memesLandscape);
        r = (RelativeLayout) findViewById(R.id.MemeTitle);

        if(evento == StartMenu.HALLOWEEN){
            RelativeLayout stopRelative = findViewById(R.id.stopLayout);
            TextView texto = findViewById(R.id.titleM);

            stopRelative.setBackgroundColor(Color.parseColor("#DD855C"));
            r.setBackgroundColor(Color.parseColor("#DD855C"));
            texto.setText("FREE SPOOKY");
        }

        // publicidad:

        adG = new InterstitialAd(getApplicationContext());
        adG.setAdUnitId("ca-app-pub-5144756144150507/7908573285");
        adGr = new AdRequest.Builder().build();
        adG.loadAd(adGr);

        //crear tablero con los memebotones
        crearTablero(pantalla);
    }



    private void crearTablero(int screen){
        if(r == null || l1 == null ) return;
        Button back = (Button) findViewById(R.id.backBtn);
        Button next = (Button) findViewById(R.id.nextBtn);

        this.pantalla = screen;
        MemeBoton.setMaxSongs(evento);
        //int maxPantalla = (MemeBoton.getMaxSongs()%MaxBotones == 0)?
        //      MemeBoton.getMaxSongs()/MaxBotones:MemeBoton.getMaxSongs()/MaxBotones;
        int maxPantalla = MemeBoton.getMaxSongs()/MaxBotones;
        id = (pantalla-1)*MaxBotones;

        if(pantalla == 1){
            next.setOnClickListener(null);
            back.setOnClickListener(null);
            //tablero
            l1.removeAllViews();
            crearMemes();

            //boton back
            back.setVisibility(View.INVISIBLE);

            //boton next
            if(pantalla == maxPantalla) next.setVisibility(View.INVISIBLE);
            else next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crearTablero(pantalla+1);
                }
            });
        }

        else if(pantalla == maxPantalla){
            next.setOnClickListener(null);
            back.setOnClickListener(null);
            //tablero
            l1.removeAllViews();
            crearMemes();

            //boton back
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crearTablero(pantalla-1);
                }
            });

            //boton next
            next.setVisibility(View.INVISIBLE);
        }

        else{
            next.setOnClickListener(null);
            back.setOnClickListener(null);
            //tablero
            l1.removeAllViews();
            crearMemes();

            //boton back
            back.setVisibility(View.VISIBLE);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crearTablero(pantalla-1);
                }
            });

            //boton next
            next.setVisibility(View.VISIBLE);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    crearTablero(pantalla+1);
                }
            });
        }
    }

    private void crearMemes(){
        for( int i = 0; i < MaxButtonX; i++){
            LinearLayout l2 = new LinearLayout(this);
            l2.setOrientation(LinearLayout.HORIZONTAL);
            for(int j = 0; j < MaxButtonY;j ++){
                //crear boton
                MemeBoton mb = new MemeBoton(getApplicationContext());
                mb.setImagen(id,evento);
                mb.setId(id);
                mb.setLayoutParams(new LinearLayout.LayoutParams(0,height,1.0f));
                mb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //parte anuncio

                        if(ads == MAXADS){
                            if(adG.isLoaded())adG.show();
                            adGr = new AdRequest.Builder().build();
                            adG.loadAd(adGr);
                            ads = 0;
                        }else ads++;

                        adG.setAdListener(new AdListener(){
                            @Override
                            public void onAdOpened() {
                                if(activo != null){
                                    activo.stopMp3();
                                    activo.releaseMp3();
                                    activo = null;
                                }
                            }
                        });

                        //parte sonido del boton
                        if(activo != null){
                            if(activo == ((MemeBoton)v)){
                                    activo.stopMp3();
                                    activo.prepareMp3();
                                    activo.playMp3();
                            }else{
                                activo.stopMp3();
                                activo.releaseMp3();
                                ((MemeBoton)v).setMp3(getApplicationContext(),-1,evento);
                                ((MemeBoton)v).playMp3();
                                activo = ((MemeBoton)v);
                            }
                        } else{
                            ((MemeBoton)v).setMp3(getApplicationContext(),-1,evento);
                            ((MemeBoton)v).playMp3();
                            activo = ((MemeBoton)v);
                        }


                    }
                });

                id++;

                l2.addView(mb);
                if(id == MemeBoton.getMaxSongs())break;
            }
            l1.addView(l2);
            if(id == MemeBoton.getMaxSongs())break;
        }
    }

    private void stopMusic(){
        if(activo != null){
            activo.stopMp3();
            activo.releaseMp3();
            activo = null;
        }
    }

    protected void onPause() {
        super.onPause();
        stopMusic();
    }
}
