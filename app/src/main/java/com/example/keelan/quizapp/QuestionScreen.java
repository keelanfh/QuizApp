package com.example.keelan.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by keelan on 1/12/16.
 */

public class QuestionScreen extends AppCompatActivity {

    private Button mSkipButton;
    private Button mCheatButton;
    private Button mAllQButton;
    private TextView mQuestion;
    private RadioButton mAnswer1;
    private RadioButton mAnswer2;
    private RadioButton mAnswer3;
    private RadioButton mAnswer4;


    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_screen);

        mSkipButton = (Button) findViewById(R.id.skip_button);
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mAllQButton= (Button) findViewById(R.id.allq_button);
        mQuestion = (TextView) findViewById(R.id.question);
        mAnswer1 = (RadioButton) findViewById(R.id.answer1);
        mAnswer2 = (RadioButton) findViewById(R.id.answer2);
        mAnswer3 = (RadioButton) findViewById(R.id.answer3);
        mAnswer4 = (RadioButton) findViewById(R.id.answer4);

        String[] randomAnswers = App.question.randomAnswers();
        mQuestion.setText(App.question.getQuestion());
        mAnswer1.setText(randomAnswers[0]);
        mAnswer2.setText(randomAnswers[1]);
        mAnswer3.setText(randomAnswers[2]);
        mAnswer4.setText(randomAnswers[3]);

    }
}
