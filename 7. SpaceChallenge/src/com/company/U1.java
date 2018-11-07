package com.company;

public class U1 extends Rocket {

    @Override
    public boolean isLaunched() {
        return true;  //will be override here
    }

    @Override
    public boolean isLanded() {
        return true;  //will be override here
    }

    @Override
    public void setChanceOfLaunchExplosion(){
        setChanceOfLaunchExplosion(5*((getCurrentWeightOfRocket() - getWeight()) / (getMaxWeightWithCargo() - getWeight())));}

    @Override
    public void setChanceOfLandingCrash() {
        setChanceOfLandingCrash(1 * ((getCurrentWeightOfRocket() - getWeight()) / (getMaxWeightWithCargo() - getWeight())));
    }

    public U1() {
        this.setCost(100);                                    //cost of the rocket
        this.setWeight(10000);                                      //weight of the rocket itself (empty)
        this.setMaxWeightWithCargo(18000);                          //max weight of the rocket with cargo
        this.setCurrentWeightOfRocket(getWeight());                 //actual weight of the rocket with cargo loaded
        this.setChanceOfLaunchExplosion(5 * ((getCurrentWeightOfRocket() - getWeight()) / (getMaxWeightWithCargo() - getWeight())));
        this.setChanceOfLandingCrash(1 * ((getCurrentWeightOfRocket() - getWeight()) / (getMaxWeightWithCargo() - getWeight())));
        this.setItemsInSpaceShip();
    }

}