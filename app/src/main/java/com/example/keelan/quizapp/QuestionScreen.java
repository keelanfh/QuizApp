package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.keelan.quizapp.App.currentUser;
import static com.example.keelan.quizapp.App.question;

/**
 * Created by keelan on 1/12/16.
 */

public class QuestionScreen extends AppCompatActivity {

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


    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_screen);

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

        String[] randomAnswers = App.question.randomAnswers();
        mQuestion.setText(App.question.getQuestion());
        mAnswer1.setText(randomAnswers[0]);
        mAnswer2.setText(randomAnswers[1]);
        mAnswer3.setText(randomAnswers[2]);
        mAnswer4.setText(randomAnswers[3]);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioButtonID = mRadioGroup.getCheckedRadioButtonId();
                View radioButton = mRadioGroup.findViewById(radioButtonID);
                int idx = mRadioGroup.indexOfChild(radioButton);
                RadioButton r = (RadioButton) mRadioGroup.getChildAt(idx);
                String selectedtext = r.getText().toString();
                boolean tf = App.question.checkAnswer(selectedtext);
                if (tf){
                    App.incrementScore();
                    App.moveToNextQuestion();

                    String[] randomAnswers = App.question.randomAnswers();
                    mQuestion.setText(App.question.getQuestion());
                    mAnswer1.setText(randomAnswers[0]);
                    mAnswer2.setText(randomAnswers[1]);
                    mAnswer3.setText(randomAnswers[2]);
                    mAnswer4.setText(randomAnswers[3]);

                    // TODO make sure that the RadioButton is unticked the next time

                    // TODO move to right answer screen
                }
                else{
                    // TODO move to wrong answer screen
                }

            }


        });
    }
}
