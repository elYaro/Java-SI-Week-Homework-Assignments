package com.company;

public class U2 extends Rocket {

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
        setChanceOfLaunchExplosion(4*((getCurrentWeightOfRocket() - getWeight()) / (getMaxWeightWithCargo() - getWeight())));}

    @Override
    public void setChanceOfLandingCrash() {
        setChanceOfLandingCrash(8 * ((getCurrentWeightOfRocket() - getWeight()) / (getMaxWeightWithCargo() - getWeight())));
    }


    public U2() {
        this.setCost(120);                                    //cost of the rocket
        this.setWeight(18000);                                      //weight of the rocket itself (empty)
        this.setMaxWeightWithCargo(29000);                          //max weight of the rocket with cargo
        this.setCurrentWeightOfRocket(getWeight());                 //actual weight of the rocket with cargo loaded
        this.setChanceOfLaunchExplosion(4  *  ((getCurrentWeightOfRocket()) - getWeight()) / (getMaxWeightWithCargo() - getWeight()));
        this.setChanceOfLandingCrash(8 * ((getCurrentWeightOfRocket()) - getWeight()) / (getMaxWeightWithCargo() - getWeight()));
        this.setItemsInSpaceShip();
    }

}