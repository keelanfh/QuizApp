package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by keelan on 29/11/16.
 */

public class StartScreen extends AppCompatActivity {

    private Button mStartButton;
    private TextView mHelloMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        mStartButton = (Button) findViewById(R.id.start_button);
        mHelloMessage = (TextView) findViewById(R.id.helloMessage);

        if (App.isMultiplayer()) {
            mHelloMessage.setText("Welcome, " + App.currentUser.getUsername() + " and " + App.nextUser.getUsername());
        } else {
            mHelloMessage.setText("Welcome, " + App.currentUser.getUsername());
        }
        mStartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, QuestionScreen.class);
                startActivity(intent);

            }

        });
    }
}