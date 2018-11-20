package com.codecool.car_race;

public class Truck extends Vehicules implements Moveable {


    private boolean isTruckBroken = false;
    private int breakdownTurnsLeft;
    private static double CHANCEFORBREAKINGDOWNFOR2TURNS = 0.05;

    public boolean isTruckBroken() {
        return isTruckBroken;
    }

    public void setTruckBroken(boolean truckBroken) {
        isTruckBroken = truckBroken;
    }

    public int getBreakdownTurnsLeft() {
        return breakdownTurnsLeft;
    }

    public void setBreakdownTurnsLeft(int breakdownTurnsLeft) {
        this.breakdownTurnsLeft = breakdownTurnsLeft;
    }




    public Truck() {
        setName(Utils.createNameForTruck());
        setSpeed(100);
        setBreakdownTurnsLeft(0);
    }

    @Override
    public void prepareForLap(Race race) {

    }

    @Override
    public int moveForAnHour(Race race) {
        return 0;
    }
}
