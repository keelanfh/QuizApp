package com.example.keelan.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationScreen extends AppCompatActivity {

    private Button mSubmitButton;
    private EditText mUsernameBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_screen);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mUsernameBox = (EditText) findViewById(R.id.username_box);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User currentUser = App.currentUser;
                String userInput = mUsernameBox.getText().toString();

                // Don't let the user set a username of less than 3 characters.
                if(userInput.length() <= 3){
                    Toast.makeText(RegistrationScreen.this,
                            "Please enter a username longer than 3 characters.",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    currentUser.setUsername(userInput);
                    Intent intent = new Intent(context, StartScreen.class);
                    startActivity(intent);
                }


            }
        });
    }
}