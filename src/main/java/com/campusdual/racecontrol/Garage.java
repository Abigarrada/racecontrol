package com.campusdual.racecontrol;

import java.util.ArrayList;
import java.util.List;

/*
 * Class to handle garages.
 * Must contain the garage's name and list of cars per garage.
 */
public class Garage {
    private String garageName;
    protected List<Garage> garageList = new ArrayList<>();
    protected List<Car> garageCarList = new ArrayList<>();

    public Garage(String garageName) {
        this.garageName = garageName;
    }

    public void addCarToList(Garage g){
        this.garageList.add(g);
    }

    public void creatingGarageCarList(List<Car> carList){
        for(Car c: carList){
            if(c.getGarageName().equals(this.garageName)){
                this.garageCarList.add(c);
            }
        }
    }

}

/*
* En los Torneos y las Carreras, pueden participar uno o varios Garajes.
* Si participa uno, todos sus coches entrarán en la competición.
* En el caso de ser más de uno, solo competirá un coche de cada Garaje,
* elegido de forma aleatoria.
* */

