package com.campusdual.racecontrol;

import com.campusdual.util.Input;

import java.util.ArrayList;
import java.util.List;

/*
 * Class to handle tournaments.
 * Must contain the tournament's name, list of races and ranking.
 */
public class Tournament {
    public static final int GOLD_POINTS = 3;
    public static final int SILVER_POINTS = 2;
    public static final int BRONZE_POINTS = 1;
    public static final String TOURNAMENT_NAME = "Tournament name";
    private String tournamentName;
    protected static List<Tournament> tournamentList = new ArrayList<>();
    protected static List<Race> raceList = new ArrayList<>(10);
    protected static List<Garage> participantList = new ArrayList<>();
    protected static List<Car> racingCarsList = new ArrayList<>();

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

    /*
     * Method to show the list of tournaments.
     * */
    public static void showTournamentList() {
        for (Tournament t : tournamentList) {
            System.out.println(t);
        }
    }

    /*
     * Method to get a tournament's name.
     * */
    public String getTournamentName() {
        return tournamentName;
    }

    public void addRace(Race r){
        raceList.add(r);
    }

    public void addParticipants(){
        int numberGarages = participantList.size();

    }

    public void startTournament(){
        addParticipants();
        for (Race r: raceList){
            for (Car c: racingCarsList){
                r.racingCars(r, c);
            }
        }
        showPodium();
    }

    public void showPodium(){

    }

    /*
     * Overwritten method to print the properties of a tournament.
     * */
    @Override
    public String toString() {
        return Tournament.TOURNAMENT_NAME + ": " + this.getTournamentName() + "\t\n" +
                Race.RACE_TYPE + ": " + this.getRaceType() + "\t\n" +
                Race.RACE_LENGTH + ": " + getRaceLength();
    }

}



