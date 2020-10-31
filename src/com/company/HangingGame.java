package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HangingGame implements Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<StringBuilder> hiddenWords = new ArrayList<StringBuilder>();
    private int numberOfPlayers;
    private Scanner input = new Scanner(System.in);

    public HangingGame() {
        this.numberOfPlayers = 0;
    }

    public void generateWords() {
        this.words.add(new String("Compiler"));
        this.words.add(new String("Hello"));
        this.words.add(new String("Django"));
        this.words.add(new String("Software"));
        this.words.add(new String("Devops"));
        this.words.add(new String("Flutter"));
        this.words.add(new String("Python"));
        this.words.add(new String("Microsoft"));
        this.words.add(new String("Database"));
        this.words.add(new String("Networks"));
    }

    public void setHiddenWords() {
        for (String str : this.words) {
            String temp = "";
            temp += str.charAt(0);
            for (int i = 1; i < str.length(); i++) {
                temp += "*";
            }
            this.hiddenWords.add(new StringBuilder(temp));
        }
    }

    public void setPlayers() {
        for (int i = 0; i < this.numberOfPlayers; i++) {
            this.players.add(new Player());
        }
    }

    public int inputNumberOfPlayers() {
        System.out.println("Enter Number Of Players:");
        this.numberOfPlayers = input.nextInt();
        return this.numberOfPlayers;
    }

    public char inputChar() {
        char h = input.next().charAt(0);
        return h;
    }

    public StringBuilder getHideWord(int indexOfPlayer) {
        return this.hiddenWords.get(indexOfPlayer);
    }

    public void changeHideWord(int index, int indexOfChar, char choice) {
        this.hiddenWords.get(index).setCharAt(indexOfChar, choice);
    }

    public boolean checkFinished() {
        for (int i = 0; i < this.numberOfPlayers; i++) {
            if (!this.players.get(i).isFinished()) {
                return false;
            }
        }
        return true;
    }

    public void showScores() {
        for (int i = 0; i < this.numberOfPlayers; i++) {
            if (this.players.get(i).getScore() == this.words.get(i).length() - 1) {
                System.out.println("Player {" + (i + 1) + "} Win");
            } else {
                System.out.println("Player {" + (i + 1) + "} Failed");
            }
        }
    }

    public ArrayList<StringBuilder> copyArrayList(ArrayList<StringBuilder> str) {
        for (int i = 0; i < this.numberOfPlayers; i++) {
            str.add(new StringBuilder(this.words.get(i)));
        }
        return str;
    }

    @Override
    public void startGame() {
        ArrayList<StringBuilder> str = new ArrayList<StringBuilder>();
        this.inputNumberOfPlayers();
        this.generateWords();
        str = this.copyArrayList(str);
        this.setHiddenWords();
        this.setPlayers();
        while (true) {
            int i = 0;
            StringBuilder temp;
            while (i < this.numberOfPlayers && this.players.get(i).getNumberOfErrors() < 6) {
                if (!this.players.get(i).isFinished()) {
                    System.out.println("Player {" + (i + 1) + "}:");
                    temp = new StringBuilder(str.get(i));
                    System.out.println(this.getHideWord(i));
                    System.out.println("Enter a char");
                    char choice = this.inputChar();
                    if (temp.indexOf(choice + "") != -1 && choice != this.words.get(i).charAt(0)) {
                        int indexOfChar = temp.indexOf(choice + "");
                        this.changeHideWord(i, indexOfChar, choice);
                        temp.setCharAt(indexOfChar, '*');
                        str.get(i).replace(0, temp.length(), temp.toString());
                        this.players.get(i).increaseScore();
                    } else {
                        System.out.println("incorrect char!!");
                        this.players.get(i).increaseNumberOfErrors();
                    }
                    if (this.players.get(i).getScore() == this.words.get(i).length() - 1) {
                        this.players.get(i).setIsFinished(true);
                    } else if (this.players.get(i).getNumberOfErrors() == 6) {
                        this.players.get(i).setIsFinished(true);
                    }
                    System.out.println("-----------------");

                }
                i++;
            }
            if (this.checkFinished()) {
                this.showScores();
                break;
            }
        }
    }
}
