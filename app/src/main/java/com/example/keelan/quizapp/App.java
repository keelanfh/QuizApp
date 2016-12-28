package com.example.keelan.quizapp;

import java.util.ArrayList;

/**
 * Created by keelan on 30/11/16.
 */

class App {
    private static int currentQuizNumber = 0;
    static ArrayList<Score> scoreList = new ArrayList<>();

    // TODO Azra getNextPlayerName

    public static boolean isMultiplayer() {
        return multiplayer;
    }

    static boolean multiplayer = false;

    static void startQuiz(boolean multiplayer) {
        App.multiplayer = multiplayer;
        currentQuizNumber++;
        endOfQuiz = false;
        questionNumber = 0;

        if (multiplayer) {
            currentUser = new User();
            nextUser = new User();
            currentUser.score = 0;
            nextUser.score = 0;

            questionList = multiPlayerQuestionListCreator();

        } else {
            currentUser = new User();
            currentUser.score = 0;

            questionList = singlePlayerQuestionListCreator();
        }
        question = questionList[questionNumber];


    }

    static User currentUser;
    static User nextUser;
    static String player1Name;
    static String player2Name;

    static Question[] questionList;

    private static Question[] singlePlayerQuestionListCreator() {
        Question[] singlePlayerQuestionList = new Question[]{

                new Question("What is the argument between the voices on the intercom disagreeing about the white zone and red zone really about?",
                        "Vernon wants her to get an abortion", new String[]{"Someone ate Vernon's lunch yesterday when it was clearly labelled",
                        "The red zone is a metaphor for Vernon's heart", "There is no deeper meaning to the argument"}),
                new Question("What is the name of Kareem Abdul-Jabbar's character?",
                        "Roger Murdock", new String[]{"Millard Filmore", "Kareem Abdul-Jabbar", "Clarence Oveur"}),
                new Question("Does Ted get a smoking or non-smoking ticket?", "Smoking", new String[]{"Non-smoking", "It never says",
                        "He doesn't buy a ticket"}),
                new Question("\"Nervous?\"\n\"Yes\"\n\"First time?\"",
                        "No, I've been nervous lots of times", new String[]{"No, but I haven't flown in a long time", "Yes, I've never " +
                        "been nervous before", "No"}),
                new Question("\"When can we land?\" \"I can't tell.\"", "You can tell me, I'm a doctor",
                        new String[]{"Can you write it down?", "You can tell me, I'm a federal air marshal.", "You're supposed to be the captain here!"}),
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
                new Question("The executive producers, collectively known as ZAZ, were sibling team David and Jerry Zucker and their partner...", "Jim Abrahams",
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
        return singlePlayerQuestionList;
    }

    private static Question[] multiPlayerQuestionListCreator(){
        Question[] singlePlayerQuestionList = singlePlayerQuestionListCreator();
        Question[] multiPlayerQuestionList = new Question[30];
        for(int i=0; i<15; i++){
            multiPlayerQuestionList[i] = singlePlayerQuestionList[i];
        }
        for(int i=15; i<30; i++){
            multiPlayerQuestionList[i] = singlePlayerQuestionList[i-15];
        }
        return multiPlayerQuestionList;
    }

    private static boolean lastAnswerCorrect = false;

    static boolean isLastAnswerCorrect() {
        return lastAnswerCorrect;
    }

    static void setLastAnswerCorrect(boolean lastAnswerCorrect) {
        App.lastAnswerCorrect = lastAnswerCorrect;
    }

    static void incrementScore() {
        // increment the score of the current user.
        if (!(question.isAlreadyAnswered())){
            currentUser.score++;
        }
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

        if (questionNumber + 1 == questionList.length) {
            endOfQuiz = true;
        }
    }

    static int getQuestionNumber() {
        return questionNumber;
    }

    private static int questionNumber;
    static Question question;

    static boolean isEndOfQuiz() {
        return endOfQuiz;
    }

    private static boolean endOfQuiz = false;

    static void moveToNextQuestion() {
        questionNumber++;
        question = questionList[questionNumber];

        // Flip the users around.
        flipUsers();

        if (questionNumber + 1 == questionList.length) {
            endOfQuiz = true;
        }
    }

    static void flipUsers(){
        if(multiplayer) {
            User tempUser = currentUser;
            currentUser = nextUser;
            nextUser = tempUser;
        }
    }

    static void addScoreToList() {
        scoreList.add(new Score(currentUser.getScore(), currentUser.getUsername(), currentQuizNumber));
        if(multiplayer){
            scoreList.add(new Score(nextUser.getScore(), nextUser.getUsername(), currentQuizNumber));
        }
    }

    static boolean odd = false;

    public static boolean isOdd(int n) {
        if ((n % 2) == 0) {
            odd = false;
        }
        else {
            odd = true;
        }
        return odd;
    }

}

