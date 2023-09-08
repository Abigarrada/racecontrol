package com.campusdual.racecontrol;

import com.campusdual.util.Input;
import org.example.ScoreCar;
import org.example.util.Utils;
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
public class Car implements Comparable<Car>{
    public static final String BRAND = "Brand";
    public static final String MODEL = "Model";
    public static final String GARAGE = "Garage";
    public static final int MAX_SPEED = 200;
    protected static List<Car> carList = new ArrayList<>();
    private String brand;
    private String model;
    private String garageName = "";
    private int speed = 0;
    private double distance = 0.0;
    private int score;

    /*
     * Car class constructors.
     * Requests brand and model.
     * */
    public Car() {
        this.brand = org.example.util.Input.string("Select brand: ").toLowerCase();
        this.model = org.example.util.Input.string("Select model: ").toLowerCase();

    }
    public Car(String brand, String model) {
        this.brand = brand.toLowerCase();
        this.model = model.toLowerCase();
    }

    /*
     * Method to create a new car adding it to the car list from the menu.
     * */
    public static void newCarToList(){
        System.out.println("Select one garage from the following list: \n");
        Garage.showGarageList();
        String g = Input.string("Enter garage name: ");
        if (Garage.garageList.toString().equals(g)){
            Car.carList.add(new Car());
        }else {
            System.out.println("Select a valid garage name.");
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
     * Method to get one car's model.
     * */
    public String getModel() {
        return model;
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
    /*
     * Method to change one car's garage.
     * */
    public void setGarageName(String garageName) {

        this.garageName = garageName;
    }
    /*
     * Method to get one car's garage name.
     * */
    public String getGarageName() {
        return garageName;
    }
    /*
     * Method to get one car's distance covered.
     * */
    public double getDistance() {
        return distance;
    }
    /*
     * Method to speed up a car in 10km/h intervals.
     * */
    public void speedUp(){
        if(this.speed<MAX_SPEED){
            speed+=10;
        }
    }
    /*
     * Method to slow down a car in 10km/h intervals.
     * */
    public void slowDown(){
        if(this.speed>0){
            speed-=10;
        }
    }
    /*
     * Method to modify the speed of a car, updating distance covered while doing so.
     * */
    protected void calculateSpeed(){
        int speedModifier = Utils.getRandomNumberInRange(1,3);
        if(speedModifier != 2){
            speedUp();
        }else{
            slowDown();
        }
        updateDistance();
    }
    /*
     * Method to update one car's distance covered.
     * */
    protected void updateDistance(){

        distance += speed * 16.667;
    }
    /*
     * Overwritten method to print the properties of a car.
     * */
    @Override
    public String toString() {
        return Car.BRAND + ": " + this.getBrand() + "\n" +
                Car.MODEL + ": " + this.getModel() + "\n" +
                Car.GARAGE + ": " + this.getGarageName();
    }
    /*
     * Overwritten method from Comparable Interface to compare the distance covered by two cars.
     * */
    @Override
    public int compareTo(Car o) {
        if(this.getDistance() > o.getDistance()){
            return 1;
        } else if (this.getDistance() < o.getDistance()) {
            return -1;
        } else {
            return 0;
        }
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
        String garage = (String )obj.get(Car.GARAGE);
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

        /*Car newCar = new Car("Renault", "Clio", "Garage421");
        System.out.println(newCar.toString());
        JSONObject obj1 = newCar.exportCar();
        Car.exportJSONToFile(obj1);
        JSONObject obj2 = Car.importFromJSONFile("test2.json");
        System.out.println(obj2);
        Car newCar2 = Car.importCar(obj2);
        System.out.println(newCar2);*/

        Car c = new Car("seat", "leon");
        System.out.println(c);
        Car c2 = new Car("renault", "clio");
        System.out.println(c2);

        for (int i = 0; i < 120; i++) {
            c.calculateSpeed();
            c2.calculateSpeed();
        }

        System.out.println("Final coche 1. Velocidad: " + c.getSpeed() + ". Distancia: " + c.getDistance());
        System.out.println("Final coche 2. Velocidad: " + c2.getSpeed() + ". Distancia: " + c2.getDistance());

        System.out.println(c.compareTo(c2));

    }
}
