package com.company;

import java.util.ArrayList;

public abstract class Rocket implements Flyable {


    private double cost;                           //cost of the rocket
    private double weight;                         //weight of the rocket itself (empty)
    private double maxWeightWithCargo;             //max weight of the rocket with cargo
    private double currentWeightOfRocket;          //actual weight of the rocket with cargo loaded
    private double chanceOfLaunchExplosion;       // chance od the explosion when launching
    private double chanceOfLandingCrash;          // chance od the explosion when landing
    private ArrayList<Item> itemsInSpaceShip;       // list of items packed into the selected rocket



    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMaxWeightWithCargo() {
        return maxWeightWithCargo;
    }

    public void setMaxWeightWithCargo(double maxWeightWithCargo) {
        this.maxWeightWithCargo = maxWeightWithCargo;
    }

    public double getCurrentWeightOfRocket() {
        return currentWeightOfRocket;
    }

    public void setCurrentWeightOfRocket(double currentWeightOfRocket) {
        this.currentWeightOfRocket = currentWeightOfRocket;
    }

    public double getChanceOfLaunchExplosion() {
        return chanceOfLaunchExplosion;
    }

    public void setChanceOfLaunchExplosion(double chanceOfLaunchExplosion) {
        this.chanceOfLaunchExplosion = chanceOfLaunchExplosion;
    }

    public abstract void setChanceOfLaunchExplosion();

    public double getChanceOfLandingCrash() {
        return chanceOfLandingCrash;
    }

    public void setChanceOfLandingCrash(double chanceOfLandingCrash) {
        this.chanceOfLandingCrash = chanceOfLandingCrash;
    }

    public abstract void setChanceOfLandingCrash();

    public ArrayList<Item> getItemsInSpaceShip() {
        return itemsInSpaceShip;
    }

    public void setItemsInSpaceShip() {
        this.itemsInSpaceShip = new ArrayList<>();
    }
    public void setItemsInSpaceShip(Item item) {
        this.itemsInSpaceShip.add(item);
    }



    public boolean isLaunched(){
        return true;
    }

    public boolean isLanded(){
        return true;
    }

    public boolean canCarry() {
        if (currentWeightOfRocket  < maxWeightWithCargo) {
            return true;
        } else {return false;}
    }

    public void updateRocketWeight(Item item) {
        currentWeightOfRocket = currentWeightOfRocket + item.getWeight();
    }
}
