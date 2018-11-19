package com.codecool.car_race;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    /**
     * @author: elYaro
     * @returns: String
     * this method reads the txt file with 10 given names for the Cars.
     * Then it takes the next name for a new instance of the Car class
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
}

