package com.campusdual.racecontrol;

/*
 * Class to handle play-off type races.
 * Extends Race class.
 */
public class QualifyingRace extends Race {
    private static final int MIN_QUALIFYING_LENGTH = 10;
    private static final int MAX_QUALIFYING_LENGTH = 60;
    public static final String QUALIFYING_TYPE = "Qualifying";
    private int carsRacing;

    /*
     * PlayoffRace class constructor.
     * Needs a race name.
     * Marks race type as playoff and creates a random length.
     * */
    public QualifyingRace(String raceName) {
        super(raceName);
        super.raceType = QUALIFYING_TYPE;
        super.raceLength = randomLength(MIN_QUALIFYING_LENGTH, MAX_QUALIFYING_LENGTH) + getCarsRacing();
    }

    /*
     * Method to get the number of cars participating in the race.
     * */
    private int getCarsRacing() {
        return this.carsRacing;
    }


}
