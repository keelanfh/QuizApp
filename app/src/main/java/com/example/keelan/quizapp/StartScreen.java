package com.example.keelan.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by keelan on 29/11/16.
 */

public class StartScreen extends AppCompatActivity {

    private Button mStartButton;
    private EditText mUsernameBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        mStartButton = (Button) findViewById(R.id.start_button);
        //mStartButton.setOnClickListener(new View.OnClickListener() {
            // Move on to the next screen here.
        //});
    }
}