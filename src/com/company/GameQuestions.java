package com.company;

public class GameQuestions {
    private String question;
    private String[] answers;
    private char correctAnswer;

    public GameQuestions(String question, String[] answers, char correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public void printQuestion() {
        System.out.println(question + "?!");
        for (int i = 0; i < answers.length; i++) {
            System.out.println(new String[]{"a", "b", "c"}[i] + ". " + answers[i] + ".");
        }
    }
}
