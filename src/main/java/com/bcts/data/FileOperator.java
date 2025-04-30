package com.bcts.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FileOperator{
    private Scanner fileReader;

    public FileOperator(){
        // Empty Constructor needed for Spring
    }

    public void setFile(String filename){
        if (fileReader != null){
            fileReader.close();
        }

        try {
            fileReader = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public ArrayList<Integer> toIntList(){
        ArrayList<Integer> arr = new ArrayList<>();

        while (fileReader.hasNextInt()){
            arr.add(fileReader.nextInt());
        }

        return arr;
    }

    public ArrayList<String> toStringList(){
        ArrayList<String> arr = new ArrayList<>();

        while(fileReader.hasNextLine()){
            arr.add(fileReader.nextLine());
        }
        return arr;
    }

    public ArrayList<Double> toDoubleList(){
        ArrayList<Double> arr = new ArrayList<>();

        while(fileReader.hasNextDouble()){
            arr.add(fileReader.nextDouble());
        }
        return arr;
    }
}