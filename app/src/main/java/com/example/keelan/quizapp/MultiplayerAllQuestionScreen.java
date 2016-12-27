package com.example.keelan.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by azragordy on 24/12/2016.
 */

public class MultiplayerAllQuestionScreen extends AppCompatActivity {

    final Context context = this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_all_question_screen);

        int[] ids = new int[]{R.id.q1, R.id.q2, R.id.q3, R.id.q4, R.id.q5, R.id.q6, R.id.q7, R.id.q8, R.id.q9, R.id.q10, R.id.q11, R.id.q12, R.id.q13, R.id.q14, R.id.q15,
                R.id.q16, R.id.q17, R.id.q18, R.id.q19, R.id.q20, R.id.q21, R.id.q22, R.id.q23, R.id.q24, R.id.q25, R.id.q26, R.id.q27, R.id.q28, R.id.q29, R.id.q30};

        for (int i = 0; i < ids.length; i++) {
            Button mQuestionText = (Button) findViewById(ids[i]);
            if (App.isOdd(i)) {
                mQuestionText.setText(App.player2Name + ": " + App.questionList[i].getQuestion());
            } else {
                mQuestionText.setText(App.player1Name + ": " + App.questionList[i].getQuestion());
            }
        }
        for (int i = 15; i < 30; i++) {
            Button mQuestionText = (Button) findViewById(ids[i]);
            if (App.isOdd(i)) {
                mQuestionText.setText(App.player2Name + ": " + App.questionList[i - 15].getQuestion());
            } else {
                mQuestionText.setText(App.player1Name + ": " + App.questionList[i - 15].getQuestion());
            }
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
            case R.id.q16:
                goToQuestion(16);
                break;

            case R.id.q17:
                goToQuestion(17);
                break;

            case R.id.q18:
                goToQuestion(18);
                break;

            case R.id.q19:
                goToQuestion(19);
                break;

            case R.id.q20:
                goToQuestion(20);
                break;

            case R.id.q21:
                goToQuestion(21);
                break;

            case R.id.q22:
                goToQuestion(22);
                break;

            case R.id.q23:
                goToQuestion(23);
                break;

            case R.id.q24:
                goToQuestion(24);
                break;

            case R.id.q25:
                goToQuestion(25);
                break;

            case R.id.q26:
                goToQuestion(26);
                break;

            case R.id.q27:
                goToQuestion(27);
                break;

            case R.id.q28:
                goToQuestion(28);
                break;

            case R.id.q29:
                goToQuestion(29);
                break;

            case R.id.q30:
                goToQuestion(30);
                break;
        }
    }

    public void goToQuestion(int q) {
        App.setQuestionNumber(q - 1);
        if (App.isOdd(q - 1)) {
            // If it's an odd question, should be player 2's name.

            if (!(App.currentUser.getUsername().equals(App.player2Name)))
            {
                App.flipUsers();
            }


            // If it's an even question, should be player 1's name.
        } else {
            if (!(App.currentUser.getUsername().equals(App.player1Name)))
            {
                App.flipUsers();
            }
        }
        Intent intent = new Intent(context, QuestionScreen.class);
        startActivity(intent);
    }

}
