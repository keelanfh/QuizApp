package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by keelan on 29/11/16.
 */

public class MultiplayerChoiceScreen extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_choice_screen);
    }

    public void SinglePlayerClick(View v) {
        final Context context = this;
        Intent intent = new Intent(context, RegistrationScreen.class);
        startActivity(intent);
    }

    public void MultiPlayerClick(View v) {
        final Context context = this;
        Intent intent = new Intent(context, MultiplayerRegistrationScreen.class);
        startActivity(intent);
    }
}