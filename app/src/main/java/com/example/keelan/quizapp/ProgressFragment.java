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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.progress_bar, container, false);

        mProgressMessage = (TextView) mView.findViewById(R.id.progress_message);

        mProgressMessage.setText("Question " + (App.getQuestionNumber() + 1)  + " of 15");
        // TODO Azra change to 30

        return mView;
    }

}
