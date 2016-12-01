package com.example.keelan.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by keelan on 29/11/16.
 */

public class StartScreen extends AppCompatActivity {

    private Button mStartButton;
    private EditText mUsernameBox;
    private TextView mHelloMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        mStartButton = (Button) findViewById(R.id.start_button);
        mHelloMessage = (TextView) findViewById(R.id.helloMessage);

        mHelloMessage.setText("Welcome, " + App.currentUser.getUsername());
//        mStartButton.setOnClickListener(new View.OnClickListener() {
//            // Move on to the next screen here.
//            ;
//        });
    }
}