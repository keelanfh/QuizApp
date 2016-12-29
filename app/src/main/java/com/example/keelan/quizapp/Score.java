package com.example.keelan.quizapp;

/**
 * Created by keelan on 15/12/16.
 */

class Score {
    private int score;
    private String username;
    private int quizNumber;

    Score(int score, String username, int quizNumber) {
        this.score = score;
        this.username = username;
        this.quizNumber = quizNumber;
    }

    int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    int getQuizNumber() {
        return quizNumber;
    }

    public void setQuizNumber(int quizNumber) {
        this.quizNumber = quizNumber;
    }

}
