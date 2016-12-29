package com.example.keelan.quizapp;

/**
 * Created by keelan on 1/12/16.
 */


class Question {

    private String question;
    private String answer;
    private String[] incorrectAnswers;
    private int answersGiven = 0;

    Question() {
        question = "question";
        answer = "answer";
        incorrectAnswers = new String[3];
        for (int i = 0; i < incorrectAnswers.length; i++) {
            incorrectAnswers[i] = "wrong" + i;
        }
    }

    Question(String theQuestion, String theAnswer, String[] theIncorrectAnswers) {
        question = theQuestion;
        answer = theAnswer;
        incorrectAnswers = theIncorrectAnswers;

    }

    boolean isAlreadyAnswered() {
        return answersGiven > 1;
    }

    void setAnswersGiven(int answersGiven) {
        this.answersGiven = answersGiven;
    }

    String getQuestion() {
        return question;
    }

    String getAnswer() {
        return answer;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    String[] randomAnswers() {
        // returns an array of correct and incorrect answers, in a random order
        String[] allAnswers = new String[incorrectAnswers.length + 1];
        int randomNumber;
        do {
            randomNumber = (int) (Math.random() * (incorrectAnswers.length + 1));
        } while (allAnswers[randomNumber] != null);

        allAnswers[randomNumber] = answer;

        for (String incorrectAnswer : incorrectAnswers) {
            do {
                randomNumber = (int) (Math.random() * (incorrectAnswers.length + 1));
            } while (allAnswers[randomNumber] != null);
            allAnswers[randomNumber] = incorrectAnswer;
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

    boolean checkAnswer(String userAnswer) {
        answersGiven++;
        return userAnswer == answer;
    }

    String answerParagraph() {
        return "The right answer is " + this.answer;
    }
}
