package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Prime extends Sequence {
    public Prime() {
        super.list = new ArrayList<Integer>();
    }

    public void setList(int number) {
        this.list = new ArrayList<Integer>();
        for (int i = 0; i < number; i++) {
            if (this.isPrime(i)) {
                this.setElement(i);
            }
        }
    }

    public void setElement(int value) {
        this.list.add((int) value);
    }

    public int getElement(int index) {
        return (int) this.list.get(index);
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public void filterByDigit(int digitNumber, int digitValue) {
        Iterator<Integer> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().toString().charAt(0) != Integer.toString(digitValue).charAt(0)) {
                iterator.remove();
            }
        }
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    public double average() {
        double avg = 0.0;
        for (int i = 0; i < this.getLength(); i++) {
            avg += this.getElement(i);
        }
        return avg / this.getLength();
    }


}
