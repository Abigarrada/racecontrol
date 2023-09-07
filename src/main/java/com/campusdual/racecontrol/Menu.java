package com.campusdual.racecontrol;

import com.campusdual.util.Input;

/*
 * Menu class with menu options.
 */

public class Menu {

    /*
     * Method to show the main menu.
     * */
    protected static void mainMenu(){
        int mainMenu;
        do {
            mainMenu = Input.integer("Welcome to Race Control! \n" +
                    "Select an option to continue: \n" +
                    "1: Manage tournaments \n" +
                    "2: Manage garages \n" +
                    "3: Exit \n");
            switch (mainMenu) {
                case 1:
                    Menu.tournamentMenu();
                    break;
                case 2:
                    Menu.garageMenu();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 3.");
            }
        }
        while (mainMenu != 3);
    }
    /*
     * Method to show the tournament menu (main menu option 1).
     * */
    private static void tournamentMenu(){
        int tournamentMenu;
        do {
            tournamentMenu = Input.integer("Manage a tournament: \n" +
                    "1: Create new tournament \n" +
                    "2: View existing tournament \n" +
                    "3: Back \n");
            switch (tournamentMenu) {
                case 1:
                    System.out.println("Opción 1");
                    break;
                case 2:
                    System.out.println("Opción 2");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 3.");
            }
        }
        while (tournamentMenu != 3);
    }
    /*
     * Method to show the garage menu (main menu option 2).
     * */
    private static void garageMenu(){
        int garageMenu;
        do {
            garageMenu = Input.integer("Manage a garage: \n" +
                    "1: Register new garage \n" +
                    "2: View existing garage \n" +
                    "3: Register new car \n" +
                    "4: View existing car \n" +
                    "5: Back \n");
            switch (garageMenu) {
                case 1:
                    System.out.println("Opción 1");
                    break;
                case 2:
                    System.out.println("Opción 2");
                    break;
                case 3:
                    Car.newCarToList();
                    break;
                case 4:
                    System.out.println("Opción 4");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Please, enter a number between 1 and 5.");
            }
        }
        while (garageMenu != 5);
    }

}
