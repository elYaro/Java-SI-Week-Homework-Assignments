package com.company;
import java.io.File;
import java.util.ArrayList;


public class Simulation {

    public static ArrayList<Item> loadItemsPhase() throws Exception {      //this method loads all items from a text file and returns an ArrayList of Items:
        File file = SourceRead.SetSourceFilePathPhase();                 //get file path
        ArrayList<Item> arrayWordsInLine = SourceRead.ReadFile(file);
        return arrayWordsInLine;
    }

    public static ArrayList<Rocket> loadTheRocketU1(ArrayList<Item> itemsToBeLaunchPhase1, ArrayList<Rocket> rocketsReadyToLaunchPhase1) {
        U1 u1 = new U1();
        ArrayList<Item> itemsInSpaceShip = new ArrayList<>();   //new array of items on the ship. will collect items packed to the ship

        for (Item item : itemsToBeLaunchPhase1) {
            if (!u1.canCarry()) {
                break;
            } else if (item.isOnStock() && (u1.getCurrentWeightOfRocket() + item.getWeight() <= u1.getMaxWeightWithCargo())) {
                u1.updateRocketWeight(item);
                u1.setItemsInSpaceShip(item);
                itemsInSpaceShip.add(item);
                item.setOnStock(false);
            }
            u1.setChanceOfLaunchExplosion();
            u1.setChanceOfLandingCrash();
        }
        rocketsReadyToLaunchPhase1.add(u1);
        return rocketsReadyToLaunchPhase1;
    }

    public static ArrayList<Rocket> loadTheRocketU2(ArrayList<Item> itemsToBeLaunchPhase2, ArrayList<Rocket> rocketsReadyToLaunchPhase2) {
        U2 u2 = new U2();
        ArrayList<Item> itemsInSpaceShip = new ArrayList<>();   //new array of items on the ship. it is empty here yet

        for (Item item : itemsToBeLaunchPhase2) {
            if (!u2.canCarry()) {
                break;
            } else if (item.isOnStock() && (u2.getCurrentWeightOfRocket() + item.getWeight() <= u2.getMaxWeightWithCargo())) {
                u2.updateRocketWeight(item);
                u2.setItemsInSpaceShip(item);
                itemsInSpaceShip.add(item);
                item.setOnStock(false);
            }
            u2.setChanceOfLaunchExplosion();
            u2.setChanceOfLandingCrash();
        }
        rocketsReadyToLaunchPhase2.add(u2);
        return rocketsReadyToLaunchPhase2;
    }


    public static boolean isItemStillOnStock(ArrayList<Item> itemsToBeLunch) {
        for (Item item : itemsToBeLunch) {
            if (item.isOnStock()) {
                return true;
            }
        }
        return false;
    }


    public static  ArrayList<Double> runSimulation(ArrayList<Rocket> rocketsReadyToLaunch, double budget$,double rocketsCrashed, double rocketsLandedOnMars) {

        boolean launch;
        boolean land;
        for (int i = 0; i < rocketsReadyToLaunch.size(); i++) {
            launch = launch(rocketsReadyToLaunch.get(i));
            land = land(rocketsReadyToLaunch.get(i));
            if (launch && land) {
                rocketsLandedOnMars++;
                budget$ += rocketsReadyToLaunch.get(i).getCost();
            } else {
                rocketsCrashed++;
                i--;
                if (i < 0) {
                    i = 0;
                }
                budget$ += rocketsReadyToLaunch.get(i).getCost();
            }
        }
        ArrayList<Double>data = new ArrayList<Double>();
        data.add(budget$);
        data.add(rocketsCrashed);
        data.add(rocketsLandedOnMars);
        return data;
    }


    public static boolean launch(Rocket rocket) {
        return checkIfLaunchSuccess(rocket);
        }


    public static boolean checkIfLaunchSuccess(Rocket rocket) {
        if (generateRandomNumber() < rocket.getChanceOfLaunchExplosion()) {
            return false;
        } else return true;
    }


    public static boolean land(Rocket rocket) {
        return checkIfLandSuccessed(rocket);
    }


    public static boolean checkIfLandSuccessed(Rocket rocket) {
        if (generateRandomNumber() < rocket.getChanceOfLandingCrash()) {
            return false;
        } else return true;
    }

    public static double generateRandomNumber() {
        double randomNumber = (Math.random()*100);
        return randomNumber;
    }

    public static void printReport(ArrayList<Double>data){
        System.out.println("\n\n***************** PHASE 1 ACCOMPLISHED. SUMMARY BELOW: *****************");
        System.out.println("Rockets landed on Marse:\t" + data.get(2) );
        System.out.println("Rockets crashed\t\t   :    " + data.get(1) );
        System.out.println("Total rockets launched :    " + (data.get(1) + data.get(2)) );
        System.out.println("Budget used\t\t\t   :    " + data.get(0) );
    }
}