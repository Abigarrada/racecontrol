package com.campusdual.racecontrol;

import com.campusdual.util.Input;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
 * Class to handle cars.
 * Must contain brand and model.
 * Maximum speed will be the same for every car.
 */
public class Car {
    public static final String BRAND = "brand";
    public static final String MODEL = "model";
    public static final int MAX_SPEED = 200;
    protected static List<Car> carList = new ArrayList<>();
    private String brand;
    private String model;
    private int score;
    private int speed = 0;
    private String garageName;

    /*
     * Car class constructor.
     * Needs brand and model.
     * */
    public Car(String brand, String model, String garageName) {
        this.brand = brand;
        this.model = model;
        this.garageName = garageName;
    }

    /*
     * Method to create a new car adding it to the car list from the menu.
     * */
    public static void newCarToList(){
        System.out.println("Select one garage from the following list: \n");
        Garage.showGarageList();
        String g = Input.string("Enter garage name: ");
        if (Garage.garageList.toString().equals(g)){
            String b = Input.string("Enter car brand: ");
            String m = Input.string("Enter car model: ");
            Car.carList.add(new Car(b.toLowerCase(), m.toLowerCase(), g));
            System.out.println("New car " + b.toLowerCase() + " " + m.toLowerCase() + " was registered " +
                    "to the garage" + g + ".");
        }else {
            System.out.println("Select a valid garage name");
        }
    }
    /*
     * Method to show the complete car list.
     * */
    public static void showCarList(){
        for (Car c: carList){
            System.out.println(c);
        }
    }
    /*
     * Method to get one car's brand.
     * */
    public String getBrand() {
        return brand;
    }
    /*
     * Method to change one car's brand.
     * */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /*
     * Method to get one car's model.
     * */
    public String getModel() {
        return model;
    }
    /*
     * Method to change one car's brand.
     * */
    public void setModel(String model) {
        this.model = model;
    }
    /*
     * Method to get one car's score.
     * */
    public int getScore() {
        return score;
    }
    /*
     * Method to change one car's score.
     * */
    public void setScore(int score) {
        this.score = score;
    }
    /*
     * Method to get one car's speed.
     * */
    public int getSpeed() {
        return speed;
    }
    /*
     * Method to change one car's speed.
     * */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getGarageName() {
        return garageName;
    }

    /*
     * Method to start the car with a random speed between 1 and MAX_SPEED.
     * */
    public void start(){
        Random r = new Random();
        this.speed = r.nextInt(MAX_SPEED + 1);
    }
    /*
     * Method to speed up a car in 10km/h intervals.
     * */
    public void speedUp(){
        Random r = new Random();
        this.speed = this.speed+r.nextInt(10);
    }
    /*
     * Method to slow down a car in 10km/h intervals.
     * */
    public void slowDown(){
        Random r = new Random();
        this.speed = this.speed-r.nextInt(10);
    }
    /*
     * Method to stop the car, changing speed back to 0.
     * */
    public void stop(){
        this.speed = 0;
    }

    /*
     * Overwritten method to print the properties of a car.
     * */
    @Override
    public String toString(){
        return "Brand: " + this.getBrand() + "\nModel: " + this.getModel();
    }
    /*
     * Method to export car-type objects to JSON.
     * */
    public JSONObject exportCar(){

        //único objeto
        JSONObject obj = new JSONObject();
        obj.put(Car.BRAND, this.getBrand()); //must be used with const
        obj.put(Car.MODEL, this.getModel());

        //múltiples coches
        JSONArray a = new JSONArray();
        a.add(obj); //genera un array de objetos, no requiere clave --usar foreach --lista de coches de un garaje

        return obj;
    }
    /*
     * Method to import car-type objects from JSON.
     * */
    public static Car importCar(JSONObject obj){
        String brand = (String )obj.get(Car.BRAND);
        String model = (String )obj.get(Car.MODEL);
        return new Car(brand, model);
    }
    /*
     * Method to export JSON-type objects to a file.
     * */
    public static void exportJSONToFile(JSONObject obj){
        try (FileWriter w = new FileWriter("test.json")) { //try with resources: will close all
            w.write(obj.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /*
     * Method to import JSON-type objects from a file.
     * */
    public static JSONObject importFromJSONFile (String fileName){
        try(FileReader r = new FileReader(fileName)) {
            JSONParser p = new JSONParser();
            JSONObject obj = (JSONObject) p.parse(r);
            return obj;
        }catch (Exception e){
            return null;
        }
    }

    public static void main(String[] args) {
        Car newCar = new Car("Renault", "Clio");
        System.out.println(newCar.toString());
        JSONObject obj1 = newCar.exportCar();
        Car.exportJSONToFile(obj1);
        JSONObject obj2 = Car.importFromJSONFile("test2.json");
        System.out.println(obj2);
        Car newCar2 = Car.importCar(obj2);
        System.out.println(newCar2);

    }
}
