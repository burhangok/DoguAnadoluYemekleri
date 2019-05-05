package com.burhangok.doguyemekleri;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {

    SharedPreferences preferencesNesnesi;
    SharedPreferences.Editor duzenleyici;
    int PRIVATE_MODE=0;
    Context contextNesnesi;

    public static final String PREF_ADI="Time";
    public static final String KEY_LOGIN="FirstTime";

    public SessionManagement(Context contextNesnesi) {
        this.contextNesnesi = contextNesnesi;
        this.preferencesNesnesi=contextNesnesi.getSharedPreferences(PREF_ADI,PRIVATE_MODE);
        this.duzenleyici=preferencesNesnesi.edit();
    }


    public void createSession () {

        duzenleyici.putString(KEY_LOGIN,"yes");
        duzenleyici.commit();
    }

    public boolean checkLogin() {

        String girisDurumu = preferencesNesnesi.getString(KEY_LOGIN,null);

        if(girisDurumu==null) return false;
        else return true;

    }

}