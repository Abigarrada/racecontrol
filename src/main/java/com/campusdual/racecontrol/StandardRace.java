package com.campusdual.racecontrol;

/*
 * Class to handle standard type races.
 * Extends Race class.
 */
public class StandardRace extends Race {
    private static final int MIN_STANDARD_LENGTH = 60;
    private static final int MAX_STANDARD_LENGTH = 240;
    public static final String STANDARD_TYPE = "Standard";

    /*
     * StandardRace class constructor.
     * Needs a race name.
     * Marks race type as standard and creates a random length.
     * */
    public StandardRace(String raceName) {
        super(raceName);
        super.raceType = STANDARD_TYPE;
        super.raceLength = randomLength(MIN_STANDARD_LENGTH, MAX_STANDARD_LENGTH);
    }


}
