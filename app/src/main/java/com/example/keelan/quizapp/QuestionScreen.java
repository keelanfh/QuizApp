package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by keelan on 1/12/16.
 */

public class QuestionScreen extends FragmentActivity {

    private final Context context = this;
    private RadioGroup mRadioGroup;
    private TextView mQuestion;
    private RadioButton mAnswer1;
    private RadioButton mAnswer2;
    private RadioButton mAnswer3;
    private RadioButton mAnswer4;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_screen);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.commit();

        mRadioGroup = (RadioGroup) findViewById(R.id.answers_group);
        mQuestion = (TextView) findViewById(R.id.question);
        mAnswer1 = (RadioButton) findViewById(R.id.answer1);
        mAnswer2 = (RadioButton) findViewById(R.id.answer2);
        mAnswer3 = (RadioButton) findViewById(R.id.answer3);
        mAnswer4 = (RadioButton) findViewById(R.id.answer4);

        refreshText();
    }

    public void submit(View v) {
        int radioButtonID = mRadioGroup.getCheckedRadioButtonId();
        if (!(radioButtonID == -1)) {
            App.setCheated(false);

            View radioButton = mRadioGroup.findViewById(radioButtonID);
            int idx = mRadioGroup.indexOfChild(radioButton);
            RadioButton r = (RadioButton) mRadioGroup.getChildAt(idx);
            String selectedtext = r.getText().toString();
            boolean tf = App.question.checkAnswer(selectedtext);

            if (tf) {
                App.incrementScore();
            } else {
                App.setLastAnswerCorrect(false);

            }
            Intent intent = new Intent(context, AnswerScreen.class);
            startActivity(intent);
        } else {
            Toast.makeText(QuestionScreen.this,
                    "Please select an answer.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void cheat(View v) {
        App.setLastAnswerCorrect(false);
        App.setCheated(true);
        App.question.setAnswersGiven(2);
        Intent intent = new Intent(context, AnswerScreen.class);
        startActivity(intent);
    }

    public void skip(View v) {
        App.setLastAnswerCorrect(false);
        App.question.setAnswersGiven(2);
        if (App.isEndOfQuiz()) {
            Intent intent = new Intent(context, ScoreScreen.class);
            startActivity(intent);
        } else {
            App.question.setAnswersGiven(2);
            App.moveToNextQuestion();
            refreshText();
            mRadioGroup.clearCheck();
        }
    }

    private void refreshText() {

        String[] randomAnswers = App.question.randomAnswers();
        mQuestion.setText(App.question.getQuestion());
        mAnswer1.setText(randomAnswers[0]);
        mAnswer2.setText(randomAnswers[1]);
        mAnswer3.setText(randomAnswers[2]);
        mAnswer4.setText(randomAnswers[3]);
        if (App.isMultiplayer()) {
            ProgressFragment.mProgressMessage.setText("Question " + (App.getQuestionNumber() + 1) + " of 30");
            ProgressFragment.mPlayerMessage.setText("Current player: " + App.currentUser.getUsername());
        } else {
            ProgressFragment.mProgressMessage.setText("Question " + (App.getQuestionNumber() + 1) + " of 15");
            ProgressFragment.mPlayerMessage.setText(null);
        }


    }

    public void seeAllQuestions(View v) {
        if (App.isMultiplayer()) {
            Intent intent = new Intent(context, MultiplayerAllQuestionScreen.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(context, AllQuestionScreen.class);
            startActivity(intent);
        }
    }
}
