package com.example.keelan.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by keelan on 1/12/16.
 */

public class QuestionScreen extends AppCompatActivity {

    private Button mSkipButton;
    private Button mCheatButton;
    private Button mAllQButton;

    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_screen);

        mSkipButton = (Button) findViewById(R.id.skip_button);
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mAllQButton= (Button) findViewById(R.id.allq_button);
    }
}
