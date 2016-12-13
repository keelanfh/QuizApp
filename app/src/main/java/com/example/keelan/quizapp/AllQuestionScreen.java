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

public class AllQuestionScreen extends AppCompatActivity {

    final Context context = this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_question_screen);

        int[] ids = new int[]{R.id.q1, R.id.q2, R.id.q3, R.id.q4, R.id.q5, R.id.q6, R.id.q7, R.id.q8, R.id.q9, R.id.q10, R.id.q11, R.id.q12, R.id.q13, R.id.q14, R.id.q15};

        for(int i = 0; i<ids.length; i++){
            Button mQuestionText = (Button) findViewById(ids[i]);
            mQuestionText.setText(App.questionList[i].getQuestion());
        }

    }

    public void nextQuestion(View v){
        App.moveToNextQuestion();
        Intent intent = new Intent(context, QuestionScreen.class);
        startActivity(intent);
    }

}
