package com.campusdual.racecontrol;

import com.campusdual.util.Input;
import com.campusdual.util.Utils;

import java.util.List;

/*
 * Menu class with menu options.
 */

public class Menu {

    /*
     * Method to show the main menu.
     * */
    protected static void mainMenu() {
        int mainMenu;
        do {
            mainMenu = Input.integer("Welcome to Race Control! \n" +
                    "Select an option to continue: \n" +
                    "1: Manage tournaments \n" +
                    "2: Manage races \n" +
                    "3: Manage garages \n" +
                    "4: Exit \n");
            switch (mainMenu) {
                case 1:
                    Menu.tournamentMenu();
                    break;
                case 2:
                    Menu.raceMenu();
                    break;
                case 3:
                    Menu.garageMenu();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 3.");
            }
        }
        while (mainMenu != 4);
    }

    /*
     * Method to show the tournament menu (main menu option 1).
     * */
    private static void tournamentMenu() {
        int tournamentMenu;
        do {
            tournamentMenu = Input.integer("\nManage a tournament: \n" +
                    "1: Register new tournament \n" +
                    "2: View existing tournaments \n" +
                    "3: Manage existing tournaments \n" +
                    "4: Back \n");
            switch (tournamentMenu) {
                case 1:
                    Tournament.addTournamentToList();
                    break;
                case 2:
                    Tournament.showTournamentList();
                    break;
                case 3:
                    Menu.manageTournamentMenu();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 4.");
            }
        }
        while (tournamentMenu != 4);
    }

    /*
     * Method to show the race menu (main menu option 2).
     * */
    private static void raceMenu() {
        int raceMenu;
        do {
            raceMenu = Input.integer("Manage a race: \n" +
                    "1: Register new standard race \n" +
                    "2: Register new playoff race \n" +
                    "3: View and manage existing races \n" +
                    "4: Start race \n" +
                    "5: Back \n");
            switch (raceMenu) {
                case 1:
                    System.out.println("Opción 1");
                    break;
                case 2:
                    System.out.println("Opción 2");
                    break;
                case 3:
                    Utils.showAndSelectFromList(Race.raceList, true, true);
                    break;
                case 4:
                    System.out.println("Opción 5");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 5.");
            }
        }
        while (raceMenu != 5);
    }

    /*
     * Method to show the garage menu (main menu option 3).
     * */
    private static void garageMenu() {
        int garageMenu;
        do {
            garageMenu = Input.integer("Manage a garage: \n" +
                    "1: Register new garage \n" +
                    "2: View and manage existing garages \n" +
                    "3: Change garage name \n" +
                    "4: Manage cars \n" +
                    "5: Back \n");
            switch (garageMenu) {
                case 1:
                    Garage.addGarageToList();
                    break;
                case 2:
                    Utils.showAndSelectFromList(Garage.garageList, true, true);
                    break;
                case 3:
                    System.out.println("Opción 3");
                    break;
                case 4:
                    Menu.carMenu();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 5.");
            }
        }
        while (garageMenu != 5);
    }

    /*
     * Method to manage an existing tournament from the menu (tournament menu option 3).
     * */
    private static void manageTournamentMenu() {
        int manageTournamentMenu;
        do {
            manageTournamentMenu = Input.integer("Manage a tournament: \n" +
                    "1: View and manage tournaments \n" +
                    "2: Add garages to existing tournament \n" +
                    "3: Add cars to existing tournament \n" +
                    "4: Back \n");
            switch (manageTournamentMenu) {
                case 1:
                    Utils.showAndSelectFromList(Tournament.tournamentList, true, true);
                    break;
                case 2:
                    System.out.println("Opción 2");
                    break;
                case 3:
                    System.out.println("Opción 3");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 4.");
            }
        }
        while (manageTournamentMenu != 4);
    }

    /*
     * Method to show the car menu (garage menu option 4).
     * */
    private static void carMenu() {
        int carMenu;
        do {
            carMenu = Input.integer("Manage a car: \n" +
                    "1: Register new car \n" +
                    "2: View and manage existing cars \n" +
                    "3: Back \n");
            switch (carMenu) {
                case 1:
                    Car.newCarToList();
                    break;
                case 2:
                    Utils.showAndSelectFromList(Car.carList, true, true);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 3.");
            }
        }
        while (carMenu != 3);
    }


}
