package com.darkmind.onemoreshot;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Button;

import java.io.IOException;

/**
 * Created by sergi on 15/08/2017.
 */

public class MemeBoton  extends android.support.v7.widget.AppCompatButton{


    private MediaPlayer mp3;
    private int id;
    private static int MaxSongs = 100;

    public MemeBoton(Context context, int background, MediaPlayer mp3){
        super(context);
        setBack(background);
        this.mp3 = mp3;
    }

    public MemeBoton(Context context, int background){
        super(context);
        setBack(background);
    }

    public MemeBoton(Context context){ super(context);}

    public static int getMaxSongs(){
        return MaxSongs;
    }
    public void setMp3(Context context,int r) {
        this.mp3 = crearSonidos(context,r);
    }

    public void setMp3(Context context, int r, int evento){
        this.mp3 = crearSonidos(context,r,evento);
    }

    public void setBack(int background) {
        this.setBackgroundResource(background);
        this.invalidate();
    }

    public void playMp3(){
        this.mp3.start();
    }

    public void prepareMp3(){
        try{
            this.mp3.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stopMp3(){
        if(mp3 != null){
            this.mp3.pause();
            this.mp3.stop();
        }
    }

    public void releaseMp3(){
        if(mp3 != null){
            this.mp3.release();
        }
    }

    public void setId(int id){
        this.id = id;
    }

    public int getID(){
        return this.id;
    }

    public boolean isPlaying(){
        return this.mp3 != null && this.mp3.isPlaying();
    }

    public MediaPlayer crearSonidos(Context context,int id) {
        if(id == -1) id = this.id;

        switch (id) {
            case 0: return MediaPlayer.create(context,R.raw.aleman);
            case 1: return MediaPlayer.create(context,R.raw.badumtss);
            case 2: return MediaPlayer.create(context,R.raw.bodies);
            case 3: return MediaPlayer.create(context,R.raw.brunomars);
            case 4: return MediaPlayer.create(context,R.raw.catpiano);
            case 5: return MediaPlayer.create(context,R.raw.cena);
            case 6: return MediaPlayer.create(context,R.raw.charlie);
            case 7: return MediaPlayer.create(context,R.raw.cookinf);
            case 8: return MediaPlayer.create(context,R.raw.crawling);
            case 9: return MediaPlayer.create(context,R.raw.crikts);
            case 10: return MediaPlayer.create(context,R.raw.dance);
            case 11: return MediaPlayer.create(context,R.raw.deez);
            case 12: return MediaPlayer.create(context,R.raw.dejavu);
            case 13: return MediaPlayer.create(context,R.raw.doit);
            case 14: return MediaPlayer.create(context,R.raw.dropit);
            case 15: return MediaPlayer.create(context,R.raw.friendzoned);
            case 16: return MediaPlayer.create(context,R.raw.fuck);
            case 17: return MediaPlayer.create(context,R.raw.gabedog);
            case 18: return MediaPlayer.create(context,R.raw.gokuu);
            case 19: return MediaPlayer.create(context,R.raw.gottagofast);
            case 20: return MediaPlayer.create(context,R.raw.harrypotas);
            case 21: return MediaPlayer.create(context,R.raw.hellodarkness);
            case 22: return MediaPlayer.create(context,R.raw.heyya);
            case 23: return MediaPlayer.create(context,R.raw.heyya2);
            case 24: return MediaPlayer.create(context,R.raw.hitler);
            case 25: return MediaPlayer.create(context,R.raw.imgay);
            case 26: return MediaPlayer.create(context,R.raw.jew);
            case 27: return MediaPlayer.create(context,R.raw.leeroy);
            case 28: return MediaPlayer.create(context,R.raw.mincraft);
            case 29: return MediaPlayer.create(context,R.raw.mom);
            case 30: return MediaPlayer.create(context,R.raw.money);
            case 31: return MediaPlayer.create(context,R.raw.myname);
            case 32: return MediaPlayer.create(context,R.raw.noo);
            case 33: return MediaPlayer.create(context,R.raw.noone);
            case 34: return MediaPlayer.create(context,R.raw.noscope);
            case 35: return MediaPlayer.create(context,R.raw.numberone);
            case 36: return MediaPlayer.create(context,R.raw.nyan);
            case 37: return MediaPlayer.create(context,R.raw.pirate);
            case 38: return MediaPlayer.create(context,R.raw.ppap);
            case 39: return MediaPlayer.create(context,R.raw.rasputin);
            case 40: return MediaPlayer.create(context,R.raw.reallynigga);
            case 41: return MediaPlayer.create(context,R.raw.running);
            case 42: return MediaPlayer.create(context,R.raw.rusia);
            case 43: return MediaPlayer.create(context,R.raw.rusky);
            case 44: return MediaPlayer.create(context,R.raw.sad);
            case 45: return MediaPlayer.create(context,R.raw.seinfield);
            case 46: return MediaPlayer.create(context,R.raw.sitcom);
            case 47: return MediaPlayer.create(context,R.raw.sleep);
            case 48: return MediaPlayer.create(context,R.raw.somebody);
            case 49: return MediaPlayer.create(context,R.raw.stilllove);
            case 50: return MediaPlayer.create(context,R.raw.suck);
            case 51: return MediaPlayer.create(context,R.raw.takeon);
            case 52: return MediaPlayer.create(context,R.raw.theone);
            case 53: return MediaPlayer.create(context,R.raw.thomas);
            case 54: return MediaPlayer.create(context,R.raw.thug);
            case 55: return MediaPlayer.create(context,R.raw.titanic);
            case 56: return MediaPlayer.create(context,R.raw.tobecontinued);
            case 57: return MediaPlayer.create(context,R.raw.trombone);
            case 58: return MediaPlayer.create(context,R.raw.trump);
            case 59: return MediaPlayer.create(context,R.raw.turndown);
            case 60: return MediaPlayer.create(context,R.raw.weed);
            case 61: return MediaPlayer.create(context,R.raw.wololo);
            case 62: return MediaPlayer.create(context,R.raw.yee);
            case 63: return MediaPlayer.create(context,R.raw.bark);
            case 64: return MediaPlayer.create(context,R.raw.batman);
            case 65: return MediaPlayer.create(context,R.raw.batmantrans);
            case 66: return MediaPlayer.create(context,R.raw.boi);
            case 67: return MediaPlayer.create(context,R.raw.britney);
            case 68: return MediaPlayer.create(context,R.raw.fun);
            case 69: return MediaPlayer.create(context,R.raw.epicsax);
            case 70: return MediaPlayer.create(context,R.raw.ultrasax);
            case 71: return MediaPlayer.create(context,R.raw.genji);
            case 72: return MediaPlayer.create(context,R.raw.hide);
            case 73: return MediaPlayer.create(context,R.raw.murloc);
            case 74: return MediaPlayer.create(context,R.raw.nani);
            case 75: return MediaPlayer.create(context,R.raw.power);
            case 76: return MediaPlayer.create(context,R.raw.racist);
            case 77: return MediaPlayer.create(context,R.raw.risitas);
            case 78: return MediaPlayer.create(context,R.raw.rko);
            case 79: return MediaPlayer.create(context,R.raw.sanic);
            case 80: return MediaPlayer.create(context,R.raw.time);
            case 81: return MediaPlayer.create(context,R.raw.trololo);
            case 82: return MediaPlayer.create(context,R.raw.woah);
            case 83: return MediaPlayer.create(context,R.raw.xd);
            case 84: return MediaPlayer.create(context,R.raw.breakfast);
            case 85: return MediaPlayer.create(context,R.raw.brode);
            case 86: return MediaPlayer.create(context,R.raw.darude);
            case 87: return MediaPlayer.create(context,R.raw.goat);
            case 88: return MediaPlayer.create(context,R.raw.horn);
            case 89: return MediaPlayer.create(context,R.raw.nein);
            case 90: return MediaPlayer.create(context,R.raw.noice);
            case 91: return MediaPlayer.create(context,R.raw.nope);
            case 92: return MediaPlayer.create(context,R.raw.polka);
            case 93: return MediaPlayer.create(context,R.raw.rickroll);
            case 94: return MediaPlayer.create(context,R.raw.sparta);
            case 95: return MediaPlayer.create(context,R.raw.trap);
            case 96: return MediaPlayer.create(context,R.raw.weird);
            case 97: return MediaPlayer.create(context,R.raw.wilhelm);
            case 98: return MediaPlayer.create(context,R.raw.wowmlg);
            case 99: return MediaPlayer.create(context,R.raw.years);

            default: return MediaPlayer.create(context,R.raw.seinfield);
        }
    }

    public MediaPlayer crearSonidos(Context context,int id,int evento){
        if(id == -1) id = this.id;
        if(evento == StartMenu.NORMAL) return crearSonidos(context,id);
        else if(evento == StartMenu.HALLOWEEN){
            switch (id){
                case 0: return MediaPlayer.create(context,R.raw.h_alive);
                case 1: return MediaPlayer.create(context,R.raw.h_bees);
                case 2: return MediaPlayer.create(context,R.raw.h_chan);
                case 3: return MediaPlayer.create(context,R.raw.h_clicker);
                case 4: return MediaPlayer.create(context,R.raw.h_creepygirl);
                case 5: return MediaPlayer.create(context,R.raw.h_shot);
                case 6: return MediaPlayer.create(context,R.raw.h_it);
                case 7: return MediaPlayer.create(context,R.raw.h_jaws);
                case 8: return MediaPlayer.create(context,R.raw.h_johnny);
                case 9: return MediaPlayer.create(context,R.raw.h_lavender);
                case 10: return MediaPlayer.create(context,R.raw.h_meat);
                case 11: return MediaPlayer.create(context,R.raw.h_pain);
                case 12: return MediaPlayer.create(context,R.raw.h_police);
                case 13: return MediaPlayer.create(context,R.raw.h_psicosis);
                case 14: return MediaPlayer.create(context,R.raw.h_scream);
                case 15: return MediaPlayer.create(context,R.raw.h_spooky);
                case 16: return MediaPlayer.create(context,R.raw.h_thisis);
                case 17: return MediaPlayer.create(context,R.raw.h_trumpet);
                case 18: return MediaPlayer.create(context,R.raw.h_verruckt);
                case 19: return MediaPlayer.create(context,R.raw.h_wolf);
            }
        }

        return MediaPlayer.create(context,R.raw.seinfield);
    }

    /* Metodo que crea las imagenes del MemeBoton
    *  Entrada: id de la imagen
    *  Salida: La imagen*/
    public int crearImagenes(int id){
        switch(id) {
            case 0: return R.drawable.aleman;
            case 1: return R.drawable.badumtss;
            case 2: return R.drawable.bodies;
            case 3: return R.drawable.brunomars;
            case 4: return R.drawable.catpiano;
            case 5: return R.drawable.cena;
            case 6: return R.drawable.charlie;
            case 7: return R.drawable.cookinf;
            case 8: return R.drawable.crawling;
            case 9: return R.drawable.crikets;
            case 10: return R.drawable.dance;
            case 11: return R.drawable.deez;
            case 12: return R.drawable.dejavu;
            case 13: return R.drawable.doit;
            case 14: return R.drawable.dropit;
            case 15: return R.drawable.friendzoned;
            case 16: return R.drawable.fuck;
            case 17: return R.drawable.gabedog;
            case 18: return R.drawable.gokuu;
            case 19: return R.drawable.gottagofast;
            case 20: return R.drawable.harrypotas;
            case 21: return R.drawable.hellodarkness;
            case 22: return R.drawable.heyya;
            case 23: return R.drawable.heyya2;
            case 24: return R.drawable.hitler;
            case 25: return R.drawable.imgay;
            case 26: return R.drawable.jew;
            case 27: return R.drawable.leeroy;
            case 28: return R.drawable.mincraft;
            case 29: return R.drawable.mom;
            case 30: return R.drawable.money;
            case 31: return R.drawable.myname;
            case 32: return R.drawable.noo;
            case 33: return R.drawable.noone;
            case 34: return R.drawable.noscope;
            case 35: return R.drawable.numberone;
            case 36: return R.drawable.nyan;
            case 37: return R.drawable.pirate;
            case 38: return R.drawable.ppap;
            case 39: return R.drawable.rasputin;
            case 40: return R.drawable.reallynigga;
            case 41: return R.drawable.running;
            case 42: return R.drawable.rusia;
            case 43: return R.drawable.rusky;
            case 44: return R.drawable.sad;
            case 45: return R.drawable.seinfield;
            case 46: return R.drawable.sitcom;
            case 47: return R.drawable.sleep;
            case 48: return R.drawable.somebody;
            case 49: return R.drawable.still;
            case 50: return R.drawable.suck;
            case 51: return R.drawable.takeon;
            case 52: return R.drawable.theone;
            case 53: return R.drawable.thomas;
            case 54: return R.drawable.thuglife;
            case 55: return R.drawable.titanic;
            case 56: return R.drawable.tobecontinued;
            case 57: return R.drawable.trombone;
            case 58: return R.drawable.trump;
            case 59: return R.drawable.turndown;
            case 60: return R.drawable.weed;
            case 61: return R.drawable.wololo;
            case 62: return R.drawable.yee;
            case 63: return R.drawable.bark;
            case 64: return R.drawable.batman;
            case 65: return R.drawable.batmantrans;
            case 66: return R.drawable.boi;
            case 67: return R.drawable.britney;
            case 68: return R.drawable.fun;
            case 69: return R.drawable.epicsax;
            case 70: return R.drawable.ultrasax;
            case 71: return R.drawable.genji;
            case 72: return R.drawable.hide;
            case 73: return R.drawable.murloc;
            case 74: return R.drawable.nani;
            case 75: return R.drawable.power;
            case 76: return R.drawable.racist;
            case 77: return R.drawable.risitas;
            case 78: return R.drawable.rko;
            case 79: return R.drawable.sanic;
            case 80: return R.drawable.time;
            case 81: return R.drawable.trololo;
            case 82: return R.drawable.woah;
            case 83: return R.drawable.xd;
            case 84: return R.drawable.breakfast;
            case 85: return R.drawable.brode;
            case 86: return R.drawable.darude;
            case 87: return R.drawable.goat;
            case 88: return R.drawable.horn;
            case 89: return R.drawable.nein;
            case 90: return R.drawable.noice;
            case 91: return R.drawable.nope;
            case 92: return R.drawable.polka;
            case 93: return R.drawable.rickroll;
            case 94: return R.drawable.sparta;
            case 95: return R.drawable.trap;
            case 96: return R.drawable.weird;
            case 97: return R.drawable.wilhelm;
            case 98: return R.drawable.wowmlg;
            case 99: return R.drawable.years;


            default: return R.drawable.pepegood;
        }
    }

    /* Metodo que crea las imagenes del MemeBoton
    *  Entrada: id de la imagen
    *           evento para cargar diferentes sets de imagenes
    *  Salida: La imagen*/
    public int crearImagenes(int id,int evento){
        if(evento == StartMenu.NORMAL) return crearImagenes(id);
        else if(evento == StartMenu.HALLOWEEN){
            switch (id){
                case 0: return R.drawable.h_alive;
                case 1: return R.drawable.h_bees;
                case 2: return R.drawable.h_chan;
                case 3: return R.drawable.h_clicker;
                case 4: return R.drawable.h_creepygirl;
                case 5: return R.drawable.h_gunshot;
                case 6: return R.drawable.h_it;
                case 7: return R.drawable.h_jaws;
                case 8: return R.drawable.h_johnny;
                case 9: return R.drawable.h_lavender;
                case 10: return R.drawable.h_meat;
                case 11: return R.drawable.h_pain;
                case 12: return R.drawable.h_police;
                case 13: return R.drawable.h_psicosis;
                case 14: return R.drawable.h_scream;
                case 15: return R.drawable.h_spooky;
                case 16: return R.drawable.h_thisis;
                case 17: return R.drawable.h_trumpet;
                case 18: return R.drawable.h_verruct;
                case 19: return R.drawable.h_wolf;
            }
        }else if(evento == StartMenu.GOTY){

        }

        return R.drawable.pepegood;
    }

    public void setImagen(int id, int evento){
        setBack(crearImagenes(id,evento));
    }

    public static void setMaxSongs(int evento){
        if(evento == StartMenu.NORMAL){
            MaxSongs = 100;
        }else if(evento == StartMenu.HALLOWEEN){
            MaxSongs = 20;
        }
    }
}
