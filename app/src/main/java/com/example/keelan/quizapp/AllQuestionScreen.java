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

        int[] ids = new int[]{R.id.b1, R.id.b2, R.id.b3};

        for(int i = 0; i<=2; i++){
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
