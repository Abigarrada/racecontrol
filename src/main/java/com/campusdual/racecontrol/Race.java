package com.campusdual.racecontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Abstract class to create races.
 * Races can be standard or play-offs.
 * Must contain race name, type and length.
 */
public abstract class Race {
    public static final String NAME= "Name";
    public static final String TYPE= "Type";
    public static final String LENGTH= "Length";
    protected String raceName;
    protected String raceType;
    protected int raceLength;
    protected List<Garage> garagesPerRace = new ArrayList<>();
    protected List<Car> carsPerRace = new ArrayList<>();
    protected String podium;

    /*
     * Race class constructor.
     * Needs a race name.
     * */
    public Race(String raceName) {

        this.raceName = raceName;
    }

    /*
     * Method to get one race's name.
     * */
    public String getRaceName() {

        return raceName;
    }
    /*
     * Method to change one race's name.
     * */
    public void setRaceName(String raceName) {

        this.raceName = raceName;
    }
    /*
     * Method to get one race's type.
     * */
    public String getRaceType() {

        return raceType;
    }
    /*
     * Method to change one race's type.
     * */
    public void setRaceType(String raceType) {

        this.raceType = raceType;
    }
    /*
     * Method to get one race's length.
     * */
    public int getRaceLength() {

        return raceLength;
    }
    /*
     * Method to randomly create a race's length.
     * */
    protected int randomLength(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }
    /*
     * Overwritten method to print the properties of a race.
     * */
    @Override
    public String toString(){
        return Race.NAME +  ": " + this.getRaceName() + "\n" + Race.TYPE + ": " + this.getRaceType() + "\n" + Race.LENGTH + ": " + getRaceLength();
    }


    protected void racingCars(Race r, Car c){

        for (int i = 0; i <= r.getRaceLength(); i++) {
            c.calculateSpeed();
            }

        }
    }



}
