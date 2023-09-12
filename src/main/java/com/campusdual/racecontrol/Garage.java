package com.campusdual.racecontrol;

import com.campusdual.util.Input;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * Class to handle garages.
 * Must contain the garage's name and list of cars per garage.
 */
public class Garage {
    public static final String GARAGE_NAME = "Garage";
    private String garageName;
    protected static List<Garage> garageList = new ArrayList<>();


    public Garage(String garageName) {
        this.garageName = garageName.toLowerCase();
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
    public static void showGarageList() {
        for (Garage g : garageList) {
            System.out.println(g);
        }
    }

    /*
     * Method to get one garage's name.
     * */
    public String getGarageName() {
        return garageName;
    }

    /*
     * Overwritten method to print the properties of a car.
     * */
    @Override
    public String toString() {
        return Garage.GARAGE_NAME + ": " + this.getGarageName();
    }
    /*
     * Method to export garage-type objects to JSON.
     * */
    public JSONObject exportGarage(){
        JSONObject garage = new JSONObject();
        garage.put(Garage.GARAGE_NAME, this.garageName);

        return garage;


    }
    /*
     * Method to export the whole list of garage objects to JSON.
     * */
    public JSONObject exportGarageWithCars(){
        JSONObject garage = new JSONObject();
        garage.put(Garage.GARAGE_NAME, this.garageName);

        JSONArray carArray = new JSONArray();

        for(Car c: Car.carList){ //FIXME él usa un this.carlist que yo no tengo
            carArray.add(c.exportCar());
        }

        garage.put("carList", carArray);

        return garage;

    }
    /*
     * Method to import garage-type objects from JSON.
     * */
    public static Garage importGarage(String fileName){

        JSONParser parser = new JSONParser();
        fileName = Input.string("File name: ");
        try{
            JSONObject parse = (JSONObject) parser.parse(new FileReader(fileName));

            String name = (String) parse.get(Garage.GARAGE_NAME);

            return new Garage(name);

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    /*
     * Method to import the whole list of garage objects from JSON.
     * */
    public static Garage importGarageWithCars(String fileName){

        JSONParser parser = new JSONParser();
        fileName = Input.string("File name: ");
        try{
            JSONObject parse = (JSONObject) parser.parse(new FileReader(fileName));
            String name = (String) parse.get(Garage.GARAGE_NAME);
            Garage g = new Garage(name);
            JSONArray cars = (JSONArray) parse.get("carList");

            for (int i = 0; i < cars.size(); i++) {
                JSONObject car = (JSONObject) cars.get(i);
                Garage.registerCarInGarage(Car.importCar(car,"garageList.json"));
            }
            return new Garage(name);

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static void registerCarInGarage(Car c){

    }

    public static void main(String[] args) {
        Garage myGarage = new Garage("Pepito");
        JSONObject exportedGarage = myGarage.exportGarage();

        try (FileWriter f = new FileWriter("garageList.json")) {
            f.write(exportedGarage.toJSONString());
            f.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}


