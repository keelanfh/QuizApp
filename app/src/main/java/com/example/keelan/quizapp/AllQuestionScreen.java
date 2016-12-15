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

    public void thisQuestion(View v) {
        switch (v.getId()) {
            case R.id.q1:
                goToQuestion(1);
                break;

            case R.id.q2:
                goToQuestion(2);
                break;

            case R.id.q3:
                goToQuestion(3);
                break;

            case R.id.q4:
                goToQuestion(4);
                break;

            case R.id.q5:
                goToQuestion(5);
                break;

            case R.id.q6:
                goToQuestion(6);
                break;

            case R.id.q7:
                goToQuestion(7);
                break;

            case R.id.q8:
                goToQuestion(8);
                break;

            case R.id.q9:
                goToQuestion(9);
                break;

            case R.id.q10:
                goToQuestion(10);
                break;

            case R.id.q11:
                goToQuestion(11);
                break;

            case R.id.q12:
                goToQuestion(12);
                break;

            case R.id.q13:
                goToQuestion(13);
                break;

            case R.id.q14:
                goToQuestion(14);
                break;

            case R.id.q15:
                goToQuestion(15);
                break;
        }
    }



    public void goToQuestion(int q){
        App.setQuestionNumber(q-1);
        Intent intent = new Intent(context, QuestionScreen.class);
        startActivity(intent);
    }

}
