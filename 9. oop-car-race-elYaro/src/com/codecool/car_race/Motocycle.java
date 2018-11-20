package com.codecool.car_race;

public class Motocycle extends Vehicules implements Moveable {

    public Motocycle() {
        setName(createNameForMotocycle());
        setSpeed(100);

    }

    @Override
    public void prepareForLap(Race race) {

    }

    @Override
    public int moveForAnHour(Race race) {
        return 0;
    }

    public void slowDownWhileRaining(){
        int newSpeedWhileRaining = this.getSpeed() - Utils.calculateMotocyclesSpeedTOSlowDownWhileRaining();
        this.setSpeed(newSpeedWhileRaining);
    }

    public String createNameForMotocycle(){
        String name = Utils.createNameForMotocycle();
        return name;
        }
    }


