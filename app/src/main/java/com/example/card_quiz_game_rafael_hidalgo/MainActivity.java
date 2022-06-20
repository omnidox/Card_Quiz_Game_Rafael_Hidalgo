package com.example.card_quiz_game_rafael_hidalgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ISharedPreference sharedPreference;
    private TextView userView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userView = findViewById(R.id.textWelcomeUser);
        Button btnRules = (Button) findViewById(R.id.chipRules);
        Button btnPlay = (Button) findViewById(R.id.chipPlay);
        Button btnHigh = (Button) findViewById(R.id.chipHigh);
        Button btnLogOut = (Button) findViewById(R.id.chipLogOut);

        sharedPreference = new SecuredSharePref("MYPREFS", MainActivity.this);


        String userFirstName = sharedPreference.getString("firstname","nofirstnameonmain");
        String userLastName = sharedPreference.getString("lastname","nolastnameonmain");

        userView.setText("Welcome!\n" + userFirstName +" "+ userLastName);


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,QuizActivity.class );
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginRegisterPage.class );
                startActivity(intent);
                finish();
            }
        });

        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Rules.class );
                startActivity(intent);
            }
        });

        btnHigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PrevScores.class );
                startActivity(intent);
            }
        });
    }
}