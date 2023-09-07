package com.campusdual.racecontrol;

/*
 * Class to handle standard type races.
 * Extends Race class.
 */
public class StandardRace extends Race {
    private static final int MIN_STANDARD_LENGTH = 60;
    private static final int MAX_STANDARD_LENGTH = 240;

    /*
    * StandardRace class constructor.
    * Needs a race name.
    * Marks race type as standard and creates a random length.
    * */
    public StandardRace(String raceName) {
        super(raceName);
        super.raceType = "Standard";
        super.raceLength = randomLength(MIN_STANDARD_LENGTH, MAX_STANDARD_LENGTH);
    }

    public static void main(String[] args) {
        StandardRace r1 = new StandardRace("mi primerita ves");
        System.out.println(r1.toString());
    }



}
