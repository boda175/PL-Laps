package com.company;

public class Player {
    private int score;
    private int numberOfErrors;
    private boolean isFinished;

    public Player() {
        this.score = 0;
        this.numberOfErrors = 0;
        this.isFinished = false;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    public void increaseScore() {
        ++this.score;
    }

    public void increaseNumberOfErrors() {
        ++this.numberOfErrors;
    }

    public int getScore() {
        return score;
    }

    public void setIsFinished(boolean finished) {
        isFinished = finished;
    }
}
