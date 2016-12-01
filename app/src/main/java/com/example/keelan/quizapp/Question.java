package com.example.keelan.quizapp;

/**
 * Created by keelan on 1/12/16.
 */

public class Question {

    private String question;
    private String answer;
    private String[] incorrectAnswers;

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public Question() {
        question = "question";
        answer = "answer";
        incorrectAnswers = new String[3];
        for (int i=0; i < incorrectAnswers.length; i++){
            incorrectAnswers[i] = "wrong";
        }
    }

    public Question(String theQuestion, String theAnswer, String[] theIncorrectAnswers){
        question = theQuestion;
        answer = theAnswer;
        incorrectAnswers = theIncorrectAnswers;

    }

    public String[] randomAnswers(){
        String[] allAnswers = new String[incorrectAnswers.length + 1];
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * (incorrectAnswers.length);
        } while (allAnswers[randomNumber]!=null);

        allAnswers[randomNumber] = answer;

        for (int i=0; i<incorrectAnswers.length; i++){
            do {
                randomNumber = (int) (Math.random() * (incorrectAnswers.length);
            } while (allAnswers[randomNumber]!=null);
            allAnswers[randomNumber] = incorrectAnswers[i];
        }


    }
}
