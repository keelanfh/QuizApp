package com.example.keelan.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mSubmitButton;
    private EditText mUsernameBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSubmitButton = (Button) findViewById(R.id.submit_button);
        mUsernameBox = (EditText) findViewById(R.id.username_box);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setUsername(mUsernameBox.getText().toString());

                Toast.makeText(MainActivity.this,
                        user.getUsername(),
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
}