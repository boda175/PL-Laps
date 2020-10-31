package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Fibonacci extends Sequence {
    public Fibonacci() {
        super.list = new ArrayList<Integer>();
    }

    public void calculateFibonacci(int number) {
        int val = 0;
        this.list = new ArrayList<Integer>();
        this.setElement(0, 0);
        this.setElement(1, 1);
        for (int i = 2; ; i++) {
            val = this.getElement(i - 1) + this.getElement(i - 2);
            if (val <= number) {
                this.setElement(i, this.getElement(i - 1) + this.getElement(i - 2));
            } else {
                break;
            }
        }
    }

    public void setElement(int index, int value) {
        this.list.add((int) value);
    }

    public int getElement(int index) {
        return (int) this.list.get(index);
    }

    public void oddNumbers() {
        Iterator<Integer> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 ==0) {
                iterator.remove();
            }
        }
    }

    public void evenNumbers() {
        Iterator<Integer> iterator = this.list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 !=0) {
                iterator.remove();
            }
        }
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < this.getLength(); i++) {
            sum += this.getElement(i);
        }
        return sum;
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    public void print(){
        for(int i=0;i<this.getLength();i++){
            System.out.println(this.getElement(i));
        }
    }


}
