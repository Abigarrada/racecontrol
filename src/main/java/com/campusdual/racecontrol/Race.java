package com.campusdual.racecontrol;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Race {
    protected String raceName;
    protected String raceType;
    protected int length;
    public Race(String raceName) {
        this.raceName = raceName;
    }

    protected int randomLength(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
