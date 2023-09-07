package com.campusdual.racecontrol;

/*
 * Class to handle play-off type races.
 * Extends Race class.
 */
public class PlayoffRace extends Race{
    private static final int MIN_PLAYOFF_LENGTH = 10;
    private static final int MAX_PLAYOFF_LENGTH = 60;

    public PlayoffRace(String raceName) {
        super(raceName);
        super.raceType = "Playoff";
        super.raceLength = randomLength(MIN_PLAYOFF_LENGTH, MAX_PLAYOFF_LENGTH);
    }

    public static void main(String[] args) {
        PlayoffRace r2 = new PlayoffRace("mi segundita ves");
        System.out.println(r2.toString());
    }
}
