package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by keelan on 8/12/16.
 */

public class AllScoreScreen extends AppCompatActivity {

    private TextView mUsernames;
    private TextView mQuizNumbers;
    private TextView mScores;
    final Context context = this;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_score_screen);

        mUsernames = (TextView) findViewById(R.id.usernames);
        mQuizNumbers = (TextView) findViewById(R.id.quiznumbers);
        mScores = (TextView) findViewById(R.id.scores);

        String usernames = "User\n\n";
        String quiznumbers = "Quiz number\n\n";
        String scores = "Score\n\n";
        for (Score score : App.scoreList){
            usernames += score.getUsername();
            usernames += "\n";
            quiznumbers += score.getQuizNumber();
            quiznumbers += "\n";
            scores += score.getScore();
            scores += "\n";
        }

        mUsernames.setText(usernames);
        mQuizNumbers.setText(quiznumbers);
        mScores.setText(scores);

    }

    public void scoreScreenNewQuiz(View v) {

        Intent intent = new Intent(context, RegistrationScreen.class);
        // TODO change to go to single player/multiplayer screen
        startActivity(intent);
    }
}


