package com.example.card_quiz_game_rafael_hidalgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        Button btnPlay = (Button) findViewById(R.id.chipPlay2);
        Button btnHomePage = (Button) findViewById(R.id.chipHomePage);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rules.this,QuizActivity.class );
                startActivity(intent);
                finish();
            }
        });

        btnHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rules.this,MainActivity.class );
                startActivity(intent);
                finish();
            }
        });
    }
}