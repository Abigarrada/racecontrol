package com.campusdual.racecontrol;

import com.campusdual.util.Input;

import java.util.ArrayList;
import java.util.List;

/*
 * Class to handle tournaments.
 * Must contain the tournament's name, list of races and ranking.
 */
public class Tournament {
    private String tournamentName;
    protected static List<Tournament> tournamentList = new ArrayList<>();
    protected static List<Race> raceList = new ArrayList<>(10);

    public Tournament(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    /*
     * Method to create a new tournament adding it to the tournament list from the menu.
     * */
    public static void addTournamentToList() {
        String t = Input.string("Enter tournament name: ");
        Tournament.tournamentList.add(new Tournament(t.toLowerCase()));
        System.out.println("New tournament " + t.toLowerCase() + " was registered ");
    }

    public static void showTournamentList(){
        for (Tournament t: tournamentList){
            System.out.println(t);
        }
    }


    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }
}
