package com.company;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Item> itemsToBeLaunchPhase1 = Simulation.loadItemsPhase();        //array full of items to be shipped in Phase1
        ArrayList<Item> itemsToBeLaunchPhase2 = Simulation.loadItemsPhase();        //array full of items to be shipped in Phase2

        ArrayList<Rocket> rocketsReadyToLaunchPhase1 = new ArrayList<>();
        ArrayList<Rocket> rocketsReadyToLaunchPhase2 = new ArrayList<>();

        double budget$ = 0;
        double rocketsCrashed = 0;
        double rocketsLandedOnMars = 0;


        int i=0;
        while (Simulation.isItemStillOnStock(itemsToBeLaunchPhase1)) {
            Simulation.loadTheRocketU1(itemsToBeLaunchPhase1, rocketsReadyToLaunchPhase1);
            System.out.printf("Rocket No: %d, type U1. Launch risk level: %.2f%% Land risk level: %.2f%% \n", i+1, rocketsReadyToLaunchPhase1.get(i).getChanceOfLaunchExplosion(), rocketsReadyToLaunchPhase1.get(i).getChanceOfLandingCrash());
            System.out.printf("Total carried item's weight is: %.0f kg\n\n", (rocketsReadyToLaunchPhase1.get(i).getCurrentWeightOfRocket()-rocketsReadyToLaunchPhase1.get(i).getWeight()));
            i++;

        }
        int j = 0;
        while (Simulation.isItemStillOnStock(itemsToBeLaunchPhase2)) {
            Simulation.loadTheRocketU2(itemsToBeLaunchPhase2, rocketsReadyToLaunchPhase2);
            System.out.printf("Rocket No: %d, type U2. Launch risk level: %.2f. Land risk level: %.2f. \n", j+1, rocketsReadyToLaunchPhase2.get(j).getChanceOfLaunchExplosion(), rocketsReadyToLaunchPhase2.get(j).getChanceOfLandingCrash());
            System.out.printf("Total carried item's weight is: %.0f kg\n\n", (rocketsReadyToLaunchPhase2.get(j).getCurrentWeightOfRocket()-rocketsReadyToLaunchPhase2.get(j).getWeight()));
            j++;
        }

        System.out.println("\n\n***************** REPORT: ALL ROCKETS READY FOR LAUNCH *****************\n\n\n");
        System.out.println("\t\t\t\t LAUNCHING ROCKETS FOR PHASE 1... ");

        ArrayList<Double>dataPhase1 = Simulation.runSimulation(rocketsReadyToLaunchPhase1, budget$,rocketsCrashed, rocketsLandedOnMars );
        Simulation.printReport(dataPhase1);

        ArrayList<Double>dataPhase2 = Simulation.runSimulation(rocketsReadyToLaunchPhase2, budget$,rocketsCrashed, rocketsLandedOnMars );
        Simulation.printReport(dataPhase2);
        }
    }



