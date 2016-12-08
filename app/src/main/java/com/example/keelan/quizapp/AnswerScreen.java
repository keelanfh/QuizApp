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

    private Button mNextQuestion;
    private TextView mResultMessage;
    private TextView mAnswerMessage;
    private String resultMessage;
    final Context context = this;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer_screen);

        mNextQuestion = (Button) findViewById(R.id.next_button);
        mResultMessage = (TextView) findViewById(R.id.result_message);
        mAnswerMessage = (TextView) findViewById(R.id.answer_message);

        if (App.lastAnswerCorrect) {
            resultMessage = "Correct!";
        }
        else if (App.cheated) {
            resultMessage = "";
        }
        else{
            resultMessage = "Incorrect!";
        }

        mResultMessage.setText(resultMessage);
        mAnswerMessage.setText(App.question.answerParagraph());

    }

    public void nextQuestion(View v){
        App.moveToNextQuestion();
        Intent intent = new Intent(context, QuestionScreen.class);
        startActivity(intent);
    }

}
