package com.campusdual.racecontrol;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class Car {
    public static final String BRAND = "brand";
    public static final String MODEL = "model";
    public static final int MAX_SPEED = 200;
    private String brand;
    private String model;


    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString(){
        return this.getBrand() + " " + this.getModel();
    }

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

    public static Car importCar(JSONObject obj){
        String brand = (String )obj.get(Car.BRAND);
        String model = (String )obj.get(Car.MODEL);
        return new Car(brand, model);
    }

    public static void exportJSONToFile(JSONObject obj){
        try (FileWriter w = new FileWriter("test.json")) { //try with resources: will close all
            w.write(obj.toJSONString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

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
