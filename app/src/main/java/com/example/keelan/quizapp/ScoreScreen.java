package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by keelan on 8/12/16.
 */

public class ScoreScreen extends AppCompatActivity {

    private TextView mScoreMessage;
    final Context context = this;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_screen);

        mScoreMessage = (TextView) findViewById(R.id.score_message);
        if (App.getScore() == 1){
            mScoreMessage.setText(("You got " + App.getScore() + " question out of 15 correct"));

        }
        else {
            mScoreMessage.setText(("You got " + App.getScore() + " questions out of 15 correct"));
        }

    }


}
