package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by keelan on 1/12/16.
 */

public class QuestionScreen extends FragmentActivity {

    private Button mSubmitButton;
    private RadioGroup mRadioGroup;
    private Button mSkipButton;
    private Button mCheatButton;
    private Button mAllQButton;
    private TextView mQuestion;
    private RadioButton mAnswer1;
    private RadioButton mAnswer2;
    private RadioButton mAnswer3;
    private RadioButton mAnswer4;
    final Context context = this;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_screen);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        Fragment fragment = new Fragment();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        mRadioGroup = (RadioGroup) findViewById(R.id.answers_group);
        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mSkipButton = (Button) findViewById(R.id.skip_button);
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mAllQButton = (Button) findViewById(R.id.allq_button);
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
                refreshText();

            } else {
                App.setLastAnswerCorrect(false);

            }
            Intent intent = new Intent(context, AnswerScreen.class);
            startActivity(intent);
        }

    }

    public void cheat(View v){
        App.setLastAnswerCorrect(false);
        App.setCheated(true);
        Intent intent = new Intent(context, AnswerScreen.class);
        startActivity(intent);
    }

    public void skip(View v){

        App.moveToNextQuestion();
        refreshText();
    }

    public void refreshText(){

        String[] randomAnswers = App.question.randomAnswers();
        mQuestion.setText(App.question.getQuestion());
        mAnswer1.setText(randomAnswers[0]);
        mAnswer2.setText(randomAnswers[1]);
        mAnswer3.setText(randomAnswers[2]);
        mAnswer4.setText(randomAnswers[3]);

    }

    public void seeAllQuestions(View v){
        Intent intent = new Intent(context, AllQuestionScreen.class);
        startActivity(intent);
    }
}
