package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Students extends Sequence {
    private String name;

    public Students() {
        this.name = "";
        super.list = new ArrayList<String>();
    }

    public void readDataFromFile() {
        this.list = new ArrayList<String>();
        try {
            File file = new File("names.txt");
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                this.name = read.nextLine();
                this.list.add(this.name);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int getNumberOfStudents() {
        return super.getLength();
    }
}
