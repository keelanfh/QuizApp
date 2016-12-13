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
        for (int i = 0; i < incorrectAnswers.length; i++) {
            incorrectAnswers[i] = "wrong" + i;
        }
    }

    public Question(String theQuestion, String theAnswer, String[] theIncorrectAnswers) {
        question = theQuestion;
        answer = theAnswer;
        incorrectAnswers = theIncorrectAnswers;

    }

    public String[] randomAnswers() {
        // returns an array of correct and incorrect answers, in a random order
        String[] allAnswers = new String[incorrectAnswers.length + 1];
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * (incorrectAnswers.length + 1));
        } while (allAnswers[randomNumber] != null);

        allAnswers[randomNumber] = answer;

        for (int i = 0; i < incorrectAnswers.length; i++) {
            do {
                randomNumber = (int) (Math.random() * (incorrectAnswers.length + 1));
            } while (allAnswers[randomNumber] != null);
            allAnswers[randomNumber] = incorrectAnswers[i];
        }

        return allAnswers;
    }

    public String[] answers() {
        String[] allAnswers = new String[incorrectAnswers.length + 1];
        for (int i = 0; i < incorrectAnswers.length; i++) {
            allAnswers[i] = incorrectAnswers[i];
        }
        incorrectAnswers[incorrectAnswers.length - 1] = answer;
        return allAnswers;

    }

    public boolean checkAnswer(String userAnswer) {
        if (userAnswer == answer){
            return true;
        }
        else
        {
            return false;
        }
    }

    public String answerParagraph(){
        String paragraph = "The right answer is " + this.answer;
        return paragraph;
    }
}
