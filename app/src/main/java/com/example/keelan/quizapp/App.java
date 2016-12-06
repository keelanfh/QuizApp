package com.example.keelan.quizapp;

/**
 * Created by keelan on 30/11/16.
 */

class App {
    static User currentUser = new User();

    static Question[] questionList = new Question[]{

            new Question("What is it really about between the white zone and the red zone voices?",
                                           "Vernon wants her to get an abortion", new String[] {"a", "b", "c"}),
            new Question("What is the name of Kareem Abdul-Jabbar's character?",
                    "Roger Murdock", new String[] {"a","b","c"}),


    };

    static int questionNumber = 0;

    static int score = 0;
    static Question question = questionList[0];

    static void incrementScore(){
        score++;
    }

    static void moveToNextQuestion(){
        questionNumber++;
        question = questionList[questionNumber];
    }


    }

