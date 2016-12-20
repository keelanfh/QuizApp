package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by keelan on 8/12/16.
 */

public class ScoreScreen extends AppCompatActivity {

    private TextView mScoreMessage0;
    private TextView mScoreMessage1;
    private TextView mScoreMessage2;
    final Context context = this;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_screen);
        mScoreMessage0 = (TextView) findViewById(R.id.score_message0);
        mScoreMessage1 = (TextView) findViewById(R.id.score_message1);
        mScoreMessage2 = (TextView) findViewById(R.id.score_message2);


        //TODO Keelan change these

        if (App.isMultiplayer()) {
            if (App.currentUser.getScore() > App.nextUser.getScore()) {
                App.currentUser.getUsername();
            }
            if (App.currentUser.getScore() == 1) {
                mScoreMessage1.setText(("You got " + App.currentUser.getScore() + " question out of 15 correct"));

            } else {
                mScoreMessage1.setText(("You got " + App.currentUser.getScore() + " questions out of 15 correct"));
            }
        } else {
            if (App.currentUser.getScore() == 1) {
                mScoreMessage1.setText(("You got " + App.currentUser.getScore() + " question out of 15 correct"));

            } else {
                mScoreMessage1.setText(("You got " + App.currentUser.getScore() + " questions out of 15 correct"));
            }
        }
    }

    public void newQuiz(View v){
        App.addScoreToList();
        Intent intent = new Intent(context, RegistrationScreen.class);
        //TODO go back to the single/multiplayer choice screen
        startActivity(intent);
    }

    public void seeAllScores(View v){
        App.addScoreToList();
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
