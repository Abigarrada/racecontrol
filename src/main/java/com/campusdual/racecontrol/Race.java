package com.campusdual.racecontrol;

import com.campusdual.util.Input;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Abstract class to create races.
 * Races can be standard or play-offs.
 * Must contain race name, type and length.
 */
public abstract class Race {
    public static final String RACE_NAME = "Name";
    public static final String RACE_TYPE = "Type";
    public static final String RACE_LENGTH = "Length";
    protected String raceName;
    protected String raceType;
    protected int raceLength;
    protected static List<Race> raceList = new ArrayList<>();
    protected static List<Garage> garagesPerRace = new ArrayList<>();
    protected static List<Car> carsPerRace = new ArrayList<>();
    protected static List<Car> podium = new LinkedList<>();

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
     * Method to get one race's type.
     * */
    public String getRaceType() {

        return raceType;
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
    protected int randomLength(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /*
     * Overwritten method to print the properties of a race.
     * */
    @Override
    public String toString() {
        return Race.RACE_NAME + ": " + this.getRaceName() + "\t\n" +
                Race.RACE_TYPE + ": " + this.getRaceType() + "\t\n" +
                Race.RACE_LENGTH + ": " + getRaceLength();
    }

    /*
     * Method to run a race.
     * Uses Car's method to change the speed of a car.
     * */
    protected void racingCars(Race r, Car c) {
        for (int i = 0; i <= r.getRaceLength(); i++) {
            c.calculateSpeed();

        }
    }

    /*
     * Method to import race-type objects from JSON.
     * */
    public static Race importRace(String fileName){

        JSONParser parser = new JSONParser();
        //fileName = Input.string("File name: ");
        try{
            JSONObject parse = (JSONObject) parser.parse(new FileReader(fileName));

            String name = (String) parse.get(Race.RACE_NAME);
            String type = (String) parse.get(Race.RACE_TYPE);

            if(type == StandardRace.STANDARD_TYPE){
                Race r = new StandardRace(name);
                return r;
            } if(type == QualifyingRace.QUALIFYING_TYPE){
                Race r = new QualifyingRace(name);
                return r;
            } else {
                return null;
            }

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


}
