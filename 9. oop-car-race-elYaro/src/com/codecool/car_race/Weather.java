package com.codecool.car_race;

public class Weather {
    private boolean isRaining;

    public boolean getIsRaining() {
        return isRaining;
    }

    public void setIsRaining() {
        isRaining = Utils.checkIfItsRaining();
    }
}




