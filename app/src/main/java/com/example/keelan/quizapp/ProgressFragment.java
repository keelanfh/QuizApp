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
    private TextView mProgressMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.progress_bar, container, false);

        mProgressMessage = (TextView) v.findViewById(R.id.progress_message);

        mProgressMessage.setText("Progress");

        return v;
    }

}
