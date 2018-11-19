package com.codecool.car_race;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    /**
     * this method reads the txt file with 10 given names for the Cars.
     * then adds each name to the ArrayList
     * @author: elYaro
     * @input: txt file
     * @return: ArrayList of Strings with names
     */
    ArrayList<String> getNamesForCar() {
        File file = new File("/Users/Yaro/repository/Java/Java SI Assignments/9. oop-car-race-elYaro/carsNames.txt");
        ArrayList <String> listOfCarNames = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                listOfCarNames.add(scanner.nextLine());
            }
            scanner.close();
            return listOfCarNames;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listOfCarNames;
    }


    /**
     * this method generates 2 numbers from 0 till 10.
     * then it takes two names (with randomly picked index) from ArrayList and concatenates them into one String
     *@author: elYaro
     *@return: String (two words in one string)
     */
    void createNameForCar() {
        String carName = "";
        Random random = new Random();
        int numberOfNamesInTxtFile = 10;
        for (int i = 0; i <2; i++) {
            int randomNumber = random.nextInt(numberOfNamesInTxtFile);
            carName += getNamesForCar().get(randomNumber) + " ";
        }
        System.out.println(carName);
        }
    }


