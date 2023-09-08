package com.campusdual.racecontrol;

/*
 * Class to handle play-off type races.
 * Extends Race class.
 */
public class PlayoffRace extends Race{
    private static final int MIN_PLAYOFF_LENGTH = 10;
    private static final int MAX_PLAYOFF_LENGTH = 60;
    public static final String PLAYOFF_TYPE = "Playoff";
    private int carsRacing;

    /*
     * PlayoffRace class constructor.
     * Needs a race name.
     * Marks race type as playoff and creates a random length.
     * */
    public PlayoffRace(String raceName) {
        super(raceName);
        super.raceType = PLAYOFF_TYPE;
        super.raceLength = randomLength(MIN_PLAYOFF_LENGTH, MAX_PLAYOFF_LENGTH) + getCarsRacing();
    }

    /*
     * Method to get the number of cars participating in the race.
     * */
    private int getCarsRacing(){
        return this.carsRacing;
    }

    public static void main(String[] args) {
        PlayoffRace r2 = new PlayoffRace("mi segundita ves");
        System.out.println(r2.toString());
    }
}
