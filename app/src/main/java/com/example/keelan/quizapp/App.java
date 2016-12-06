package com.example.keelan.quizapp;

/**
 * Created by keelan on 30/11/16.
 */

class App {
    static User currentUser = new User();

    static Question[] questionList = new Question[]{

            new Question("What is it really about between the white zone and the red zone voices?",
                    "Vernon wants her to get an abortion", new String[]{"a", "b", "c"}),
            new Question("What is the name of Kareem Abdul-Jabbar's character?",
                    "Roger Murdock", new String[]{"Millard Filmore", "b", "c"}),
            new Question("Does Ted get a smoking or non-smoking ticket?", "Smoking", new String[]{"Non-smoking", "It never says",
                    "He doesn't buy a ticket"}),
            new Question("\"Nervous?\"\n\"Yes\"\n\"First time?\"",
                    "No, I've been nervous lots of times", new String[]{"No, but I haven't flown in a long time", "Yes, I've never " +
                    "been nervous before", "No"}),
            new Question("\"When can we land?\" \"I can't tell.\"", "You can tell me, I'm a doctor",
                    new String[]{"a", "b", "c"}),
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
                    new String[]{"Martin Abrams", "Charles Anderson", "John Atkinson"})
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

