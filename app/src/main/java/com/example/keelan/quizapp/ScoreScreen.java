package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;

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

    public void newQuiz(View v){
        App.moveToNextQuiz();
        Intent intent = new Intent(context, RegistrationScreen.class);
        startActivity(intent);
    }

    public void seeAllScores(View v){
        App.moveToNextQuiz();
        Collections.sort(App.scoreList, new Comparator<Score>() {
            @Override
            public int compare(Score score1, Score score2)
            {

                return  Integer.valueOf(score1.getScore()).compareTo(Integer.valueOf(score2.getScore()));
            }
        });
        Collections.reverse(App.scoreList);
        Intent intent = new Intent(context, AllScoreScreen.class);
        startActivity(intent);

    }



}
