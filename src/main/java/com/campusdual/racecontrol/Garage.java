package com.campusdual.racecontrol;

import com.campusdual.util.Input;

import java.util.ArrayList;
import java.util.List;

/*
 * Class to handle garages.
 * Must contain the garage's name and list of cars per garage.
 */
public class Garage {
    private static int garageID = 1;
    private String garageName;
    protected static List<Garage> garageList = new ArrayList<>();


    public Garage(String garageName) {
        this.garageName = garageName;
        garageID++;
    }
    /*
     * Method to create a new garage adding it to the garage list from the menu.
     * */
    public static void addGarageToList() {
        String g = Input.string("Enter garage name: ");
        Garage.garageList.add(new Garage(g.toLowerCase()));
        System.out.println("New garage " + g.toLowerCase() + " was registered ");
    }
    /*
     * Method to show the complete garage list.
     * */
    public static void showGarageList(){
        for (Garage g: garageList){
            System.out.println(g);
        }
    }

}

/*
* En los Torneos y las Carreras, pueden participar uno o varios Garajes.
* Si participa uno, todos sus coches entrarán en la competición.
* En el caso de ser más de uno, solo competirá un coche de cada Garaje,
* elegido de forma aleatoria.
* */

