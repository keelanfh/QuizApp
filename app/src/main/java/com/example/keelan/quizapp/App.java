package com.example.keelan.quizapp;

import java.util.ArrayList;

/**
 * Created by keelan on 30/11/16.
 */

class App {
    private static int currentQuizNumber = 1;
    static ArrayList<Score> scoreList = new ArrayList<Score>();

    static User currentUser = new User();

    static Question[] questionList = new Question[]{

            new Question("What is it really about between the white zone and the red zone voices?",
                    "Vernon wants her to get an abortion", new String[]{"a", "b", "c"}),
            // TODO change those to something else
            new Question("What is the name of Kareem Abdul-Jabbar's character?",
                    "Roger Murdock", new String[]{"Millard Filmore", "Kareem Abdul-Jabbar", "Clarence Oveur"}),
            new Question("Does Ted get a smoking or non-smoking ticket?", "Smoking", new String[]{"Non-smoking", "It never says",
                    "He doesn't buy a ticket"}),
            new Question("\"Nervous?\"\n\"Yes\"\n\"First time?\"",
                    "No, I've been nervous lots of times", new String[]{"No, but I haven't flown in a long time", "Yes, I've never " +
                    "been nervous before", "No"}),
            new Question("\"When can we land?\" \"I can't tell.\"", "You can tell me, I'm a doctor",
                    new String[]{"a", "b", "c"}),
            // TODO change those to something else
            new Question("What route is the airplane flying?", "Los Angeles to Chicago",
                    new String[]{"Los Angeles to New York", "Austin to Chicago", "Boston to Seattle"}),
            new Question("Who has to clear the runway for the emergency landing?", "Air Israel",
                    new String[]{"Alaska Airlines", "Trans American", "Virgin"}),
            new Question("Which things does Steve McCroskey say it was the wrong week to quit?", "Smoking, drinking, amphetamines, sniffing glue",
                    new String[]{"Chocolate, smoking, drinking, cocaine", "Chewing gum, cigarettes, whiskey, crystal meth",
                            "Calligraphy, vodka, morphine, jelly beans"}),
            new Question("Which of these was NOT a line in the end credits?", "All-around cool guy - Jerry Zucker",
                    new String[]{"Generally in charge of a lot of things - Mike Finnell", "Author of A Tale of Two Cities - Charles Dickens",
                            "Worst Boy - Adolf Hitler"}),
            new Question("The executive producers, collectively known as ZAZ, were sibling team David and Jerry Zucker and ...", "Jim Abrahams",
                    new String[]{"Martin Abrams", "Charles Anderson", "John Atkinson"}),
            new Question("Which of these is not a member of the flight crew?",
                    "Shirley", new String[]{"Victor", "Clarence", "Roger"}),
            new Question("Which of these is not a religious group in the airport?",
                    "Church of the Flying Spaghetti Monster", new String[]{"Buddhism", "Church of Religious Consciousness", "Scientology"}),
            new Question("Dinner was a choice between steak and fish. What does Dr. Rumack remember that he had?",
                    "Lasagna", new String[]{"Steak", "Fish", "Nothing - he wasn't hungry"}),
            new Question("What does Jim never do at home?",
                    "Vomit", new String[]{"Have a second cup of tea", "Eat breakfast", "Read the newspaper"}),
            new Question("What is the 'light reading' on offer on flight 209?",
                    "Famous Jewish Sports Legends", new String[]{"Electric Lighting Weekly", "Famous Christian Music Stars", "an Agatha Christie book"})
    };

    private static boolean lastAnswerCorrect = false;

    static boolean isLastAnswerCorrect() {
        return lastAnswerCorrect;
    }

    static void setLastAnswerCorrect(boolean lastAnswerCorrect) {
        App.lastAnswerCorrect = lastAnswerCorrect;
    }


    static int getScore() {
        return score;
    }

    private static int score = 0;

    static void incrementScore() {
        score++;
        lastAnswerCorrect = true;
    }


    private static boolean cheated = false;

    static boolean isCheated() {
        return cheated;
    }

    static void setCheated(boolean cheated) {
        App.cheated = cheated;
    }


    static void setQuestionNumber(int newQuestionNumber) {
        questionNumber = newQuestionNumber;
        question = questionList[newQuestionNumber];

        if(questionNumber + 1 == questionList.length){
            endOfQuiz = true;
        }
    }

    static int getQuestionNumber() {
        return questionNumber;
    }

    private static int questionNumber = 0;
    static Question question = questionList[0];

    static boolean isEndOfQuiz() {
        return endOfQuiz;
    }

    private static boolean endOfQuiz = false;

    static void moveToNextQuestion() {
        questionNumber++;
        question = questionList[questionNumber];

        if(questionNumber + 1 == questionList.length){
            endOfQuiz = true;
        }
    }

    static void moveToNextQuiz(){
        scoreList.add(new Score(score, currentUser.getUsername(), currentQuizNumber));
        score = 0;
        currentQuizNumber++;
        questionNumber = 0;
        question = questionList[questionNumber];
    }

}

