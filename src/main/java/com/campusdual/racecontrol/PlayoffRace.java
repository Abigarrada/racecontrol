package com.campusdual.racecontrol;

public class PlayoffRace extends Race{
    private static final int MIN_LENGTH = 10;
    private static final int MAX_LENGTH = 60;

    public PlayoffRace(String raceName) {
        super(raceName);
        super.raceType = "Playoff";
        super.length = randomLength(MIN_LENGTH, MAX_LENGTH);
    }
}
