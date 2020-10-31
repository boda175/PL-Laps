package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiChoiceGame implements Game {
    private ArrayList<GameQuestions> questions = new ArrayList<GameQuestions>();
    private int score;
    private Scanner input = new Scanner(System.in);

    public MultiChoiceGame() {
        this.score = 0;
    }

    @Override
    public void startGame() {
        for (int i = 0; i < this.questions.size(); i++) { //Use Enhanced for loop.
            this.questions.get(i).printQuestion();
            char choice = input.next().charAt(0);
            if (choice == questions.get(i).getCorrectAnswer()) {
                ++this.score;
            }
        }
    }

    public void printScore() {
        System.out.println("Your score is: " + this.score + "/" + this.questions.size());
    }


    public void generateQuestions() {
        questions.add(new GameQuestions("Java Language is High-Level-Language", new String[]{"Yes", "No", "Unknown"}, 'a'));
        questions.add(new GameQuestions("What is the longest that an elephant has ever lived", new String[]{"17 year", "49 years", "86 years"}, 'b'));
        questions.add(new GameQuestions("How many rings are on the Olympic flag", new String[]{"7", "3", "5"}, 'c'));
        questions.add(new GameQuestions(" What are the main colors on the flag of Spain", new String[]{"Green and white", "Red and yellow", "None"}, 'b'));
        questions.add(new GameQuestions("Which of these animals does NOT appear in the Chinese zodiac", new String[]{"Bear", "Rabbit", "Dragon"}, 'a'));
    }
}
