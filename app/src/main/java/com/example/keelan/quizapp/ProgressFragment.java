package com.example.keelan.quizapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by azragordy on 13/12/2016.
 */

public class ProgressFragment extends Fragment {
    static TextView mProgressMessage;
    static TextView mPlayerMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.progress_bar, container, false);

        mProgressMessage = (TextView) mView.findViewById(R.id.progress_message);
        mPlayerMessage = (TextView) mView.findViewById(R.id.player_message);

        if (App.isMultiplayer()) {
            mProgressMessage.setText("Question " + (App.getQuestionNumber() + 1) + " of 30");
            mPlayerMessage.setText("Current player: " + App.currentUser.getUsername());
        } else {
            mProgressMessage.setText("Question " + (App.getQuestionNumber() + 1) + " of 15");
            mPlayerMessage.setText(null);
        }

        return mView;
    }

}
