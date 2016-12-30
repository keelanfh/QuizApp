package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by azragordy on 22/12/2016.
 */

public class MultiplayerRegistrationScreen extends AppCompatActivity {

    private Button mSubmitButton;
    private EditText mUsernameBox1;
    private EditText mUsernameBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer_registration_screen);

        mSubmitButton = (Button) findViewById(R.id.submit_button_multiplayer);
        mUsernameBox1 = (EditText) findViewById(R.id.username_box1);
        mUsernameBox2 = (EditText) findViewById(R.id.username_box2);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput1 = mUsernameBox1.getText().toString();
                String userInput2 = mUsernameBox2.getText().toString();

                // Don't let the user set a username of less than 3 characters.
                if (userInput1.length() <= 2 || userInput2.length() <= 2) {
                    Toast.makeText(MultiplayerRegistrationScreen.this,
                            "Please enter a username 3 characters or longer.",
                            Toast.LENGTH_SHORT).show();
                }
                //Don't let both users have the same username.
                else if (userInput1.equals(userInput2)) {
                    Toast.makeText(MultiplayerRegistrationScreen.this,
                            "Please enter 2 different usernames.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    App.startQuiz(true);
                    App.currentUser.setUsername(userInput1);
                    App.nextUser.setUsername(userInput2);
                    App.player1Name = userInput1;
                    App.player2Name = userInput2;
                    Intent intent = new Intent(context, StartScreen.class);
                    startActivity(intent);
                }

            }
        });
    }
}
