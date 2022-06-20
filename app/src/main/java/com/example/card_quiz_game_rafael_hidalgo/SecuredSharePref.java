package com.example.card_quiz_game_rafael_hidalgo;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

public class SecuredSharePref implements ISharedPreference {
    private SharedPreferences sharedPreferences;

    public SecuredSharePref(String name, Context context) {


        //sets a master key in order to encrypt data.
        MasterKey masterKey = null;
        try {
            masterKey = new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build();


            sharedPreferences = EncryptedSharedPreferences.create(
                    context,
                    name,
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );


        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    //Creates and updates shared preferences by using this class
    @Override
    public String getString(String name, String value) {
        return sharedPreferences.getString(name, value);
    }

    @Override
    public void putString(String name, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, value);
        editor.apply();

    }

    @Override
    public int getInt(String name, Integer value) {
        return sharedPreferences.getInt(name, value);
    }

    @Override
    public void putInt(String name, Integer value) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(name, value);
        editor.apply();
    }

    @Override
    public void remove(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(name);
        editor.apply();
    }
}
