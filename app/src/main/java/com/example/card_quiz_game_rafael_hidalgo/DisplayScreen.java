package com.example.card_quiz_game_rafael_hidalgo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayScreen extends AppCompatActivity {

    //In this App, an encrypted shared preference is implemented to save user information.
    private ISharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_screen);

        sharedPreference = new SecuredSharePref("MYPREFS", this);

        String display = sharedPreference.getString("display", "");

        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
        displayInfo.setText(display);
    }
}