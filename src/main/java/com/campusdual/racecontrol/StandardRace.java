package com.campusdual.racecontrol;

public class StandardRace extends Race {
    private static final int MIN_LENGTH = 60;
    private static final int MAX_LENGTH = 240;

    public StandardRace(String raceName) {
        super(raceName);
        super.raceType = "Standard";
        super.length = randomLength(MIN_LENGTH, MAX_LENGTH);
    }
}
