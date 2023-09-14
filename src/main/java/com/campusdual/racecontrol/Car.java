package com.campusdual.racecontrol;

import com.campusdual.util.Input;
import org.example.util.Utils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;


/*
 * Class to handle cars.
 * Must contain brand and model.
 * Maximum speed will be the same for every car.
 */
public class Car implements Comparable<Car> {
    public static final String BRAND = "Brand";
    public static final String MODEL = "Model";
    public static final String GARAGE = "Garage";
    public static final int MAX_SPEED = 200;
    public static final String CAR_FILE = "carlist.json";
    protected static List<Car> carList = new ArrayList<>();
    protected final String brand;
    protected final String model;

    protected String garageName = "";
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

    public Car(String brand, String model, String garageName) {
        this.brand = brand.toLowerCase();
        this.model = model.toLowerCase();
        this.garageName = garageName.toLowerCase();
    }

    /*
     * Method to create a new car adding it to the car list from the menu.
     * */
    public static void newCarToList() {
        System.out.println("Select one garage from the following list: \n");
        Garage.showGarageList();
        String g = Input.string("Enter garage name: ");
        if (Garage.garageList.toString().equals(g)) {
            Car.carList.add(new Car());
        } else {
            System.out.println("Select a valid garage name.");
        }
    }

    /*
     * Method to show the complete car list.
     * */
    public static void showCarList() {
        for (Car c : carList) {
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
    public void speedUp() {
        if (this.speed < MAX_SPEED) {
            speed += 10;
        }
    }

    /*
     * Method to slow down a car in 10km/h intervals.
     * */
    public void slowDown() {
        if (this.speed > 0) {
            speed -= 10;
        }
    }

    /*
     * Method to change the speed of a car, updating distance covered while doing so.
     * */
    protected void calculateSpeed() {
        int speedModifier = Utils.getRandomNumberInRange(1, 3);
        if (speedModifier != 2) {
            speedUp();
        } else {
            slowDown();
        }
        updateDistance();
    }

    /*
     * Method to update one car's distance covered.
     * */
    protected void updateDistance() {

        distance += speed * 16.667;
    }

    /*
     * Overwritten method to print the properties of a car.
     * */
    @Override
    public String toString() {
        return Car.BRAND + ": " + this.getBrand() + " \t\t" +
                Car.MODEL + ": " + this.getModel() + " \t\t" +
                Car.GARAGE + ": " + this.getGarageName();
    }

    /*
     * Overwritten method from Comparable Interface to compare the distance covered by two cars.
     * */
    @Override
    public int compareTo(Car o) {
        if (this.getDistance() > o.getDistance()) {
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
        JSONObject car = new JSONObject();
        car.put(Car.BRAND, this.brand);
        car.put(Car.MODEL, this.model);
        if(this.garageName != ""){
            car.put(Car.GARAGE, this.garageName);
        }

        return car;

    }
    /*
     * Method to import car-type objects from JSON.
     * */
    public static Car importCar(JSONObject parse, String fileName){

        JSONParser parser = new JSONParser();
       // fileName = Input.string("File name: ");
        try{
            parse = (JSONObject) parser.parse(new FileReader(fileName));

            String brand = (String) parse.get(Car.BRAND);
            String model = (String) parse.get(Car.MODEL);
            String garage = (String) parse.get(Car.GARAGE);

            return new Car(brand, model, garage);

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {
        Car myCar = new Car("Renault", "Clio", "Garajes Pepito");
        JSONObject exportedCar = myCar.exportCar();

        try (FileWriter f = new FileWriter("carList.json")) {
            f.write(exportedCar.toJSONString());
            f.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
