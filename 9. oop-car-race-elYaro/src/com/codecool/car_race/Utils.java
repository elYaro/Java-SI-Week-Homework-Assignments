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
    public static ArrayList<String> getNamesForCar() {
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
    public static void createNameForCar() {
        String carName = "";
        Random random = new Random();
        int numberOfNamesInTxtFile = 10;
        for (int i = 0; i <2; i++) {
            int randomNumber = random.nextInt(numberOfNamesInTxtFile);
            carName += getNamesForCar().get(randomNumber) + " ";
        }
        System.out.println(carName);
        }


    /**
     * this method generates random number from 1 to 1000 and then casing this int number to String
     * then returns this string to the set neme method for Truck
     * @author: elYaro
     * @return String
     */
    public static String createNameForTruck(){
        Random random = new Random();
        int randomNumber = random.nextInt(1000) + 1;
        return String.valueOf(randomNumber);
    }



    /**
     * this method generates random number from 1 to 10 and based on the result returns truwe or false if there is a rain.
     * there is a 30% of beeing rain.
     * @author: elYaro
     * @return boolean
     */
    public static boolean checkIfItsRaining() {
        Random random = new Random();
        int randomNumber = random.nextInt(10) + 1;
        if (randomNumber % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }



    }


