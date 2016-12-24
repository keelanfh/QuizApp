package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by keelan on 8/12/16.
 */

public class AnswerScreen extends AppCompatActivity {

    private TextView mResultMessage;
    private TextView mAnswerMessage;
    private TextView mHandToPlayer;
    private String resultMessage;
    private String handToPlayerMessage;
    final Context context = this;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_screen);

        // TODO Azra add to result message which player is coming next

        mResultMessage = (TextView) findViewById(R.id.result_message);
        mAnswerMessage = (TextView) findViewById(R.id.answer_message);
        mHandToPlayer = (TextView) findViewById(R.id.hand_to_player);

        if (App.isLastAnswerCorrect()) {
            resultMessage = "Correct!";
        }
        else if (App.isCheated()) {
            resultMessage = "";
        }
        else{
            resultMessage = "Incorrect!";
        }

        if (App.isMultiplayer()) {
            handToPlayerMessage = "Hand the phone to " + App.nextUser.getUsername();
        }
        else {
            handToPlayerMessage = "";
        }

        mResultMessage.setText(resultMessage);
        mAnswerMessage.setText(App.question.answerParagraph());
        mHandToPlayer.setText(handToPlayerMessage);

    }

    public void nextQuestion(View v){
        if (App.isEndOfQuiz()){
            Intent intent = new Intent(context, ScoreScreen.class);
            startActivity(intent);
        }
        else {
            App.moveToNextQuestion();
            Intent intent = new Intent(context, QuestionScreen.class);
            startActivity(intent);
        }
    }

}
