package com.campusdual.racecontrol;

import java.util.concurrent.ThreadLocalRandom;

/*
 * Abstract class to create races.
 * Races can be standard or play-offs.
 * Must contain race name, type and length.
 */
public abstract class Race {
    protected String raceName;
    protected String raceType;
    protected int raceLength;

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
     * Override method to print the properties of a race.
     * */
    @Override
    public String toString(){
        return "Name: " + this.getRaceName() + "\nType: " + this.getRaceType() + "\nLength: " + getRaceLength();
    }

}
