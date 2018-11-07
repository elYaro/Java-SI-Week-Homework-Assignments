package com.company;


public interface Flyable {

    //a method that returns either true or false indicating if the launch was successful or if the rocket has crashed.
    public boolean isLaunched();

    //a method that also returns either true or false based on the success of the landing.
    public boolean isLanded();

    // a method that takes an Item as an argument and returns true if the rocket can carry such item or false if it will exceed the weight limit.
    public boolean canCarry();

    // a method that also takes an Item object and updates the current weight of the rocket.
    public void updateRocketWeight(Item item);

}
