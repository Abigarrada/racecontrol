package com.campusdual.racecontrol;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class Storage {

    /*
     * Method to export car-type objects to JSON.
     * */
    public static JSONObject exportCar(Car c){
        JSONObject car = new JSONObject();
        car.put(Car.BRAND, c.brand);
        car.put(Car.MODEL, c.model);
        if(c.garageName != ""){
            car.put(Car.GARAGE, c.garageName);
        }

        return car;

    }

    /*
     * Method to import car-type objects from JSON.
     * */
    public static Car importCar(JSONObject obj) {
        String brand = (String) obj.get(Car.BRAND);
        String model = (String) obj.get(Car.MODEL);
        String garage = (String) obj.get(Car.GARAGE);
        return new Car(brand, model, garage);
    }

    /*
     * Method to export JSON-type objects to a file.
     * */
    public static void exportJSONToFile(JSONObject obj) {
        try (FileWriter w = new FileWriter("test.json")) { //try with resources: will close all
            w.write(obj.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * Method to import JSON-type objects from a file.
     * */
    public static JSONObject importFromJSONFile(String fileName) {
        try (FileReader r = new FileReader(fileName)) {
            JSONParser p = new JSONParser();
            JSONObject obj = (JSONObject) p.parse(r);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    /*
     * Method that starts the app.
     * Checks if it's the first time it is used.
     * The first time, it uses the method populateApp().
     * After that, it uses the method importDataFromJSON().
     * */
    public static void startApp(){
        //if (files do not exist), then execute populateApp();
        //else, execute importDataFromJSON();
    }

    /*
     * Method that imports all the data created and saved from JSON when the app is started.
     * */
    public static void importDataFromJSON(){
        JSONObject parse = new JSONObject();
        Car.importCar(parse, Car.CAR_FILE);
        Garage.importGarage(Garage.GARAGE_FILE);
        Race.importRace(Race.RACE_FILE);
        Tournament.importTournament(Tournament.TOURNAMENT_FILE);
    }

    /*
    * Method that creates usable data for the app the first time is used.
    * */
    public static void populateApp() {

        Garage g1 = new Garage("Garajes Juan Cuesta");
        Garage g2 = new Garage("Coches Marisa");
        Garage g3 = new Garage("Cars by Concha");
        Garage g4 = new Garage("Vicentavisión");
        Garage g5 = new Garage("Gangas Mariano");

        Garage.garageList.add(g1);
        Garage.garageList.add(g2);
        Garage.garageList.add(g3);
        Garage.garageList.add(g4);
        Garage.garageList.add(g5);

        Tournament.participantList.add(g1);
        Tournament.participantList.add(g2);
        Tournament.participantList.add(g3);
        Tournament.participantList.add(g4);
        Tournament.participantList.add(g5);

        Car c1 = new Car("Renault", "Clio");
        Car c2 = new Car("Renault", "Megane");
        Car c3 = new Car("Renault", "Captur");
        Car c4 = new Car("Renault", "Austral");

        Car c5 = new Car("Citroen", "Xsara");
        Car c6 = new Car("Citroen", "C1");
        Car c7 = new Car("Citroen", "C2");
        Car c8 = new Car("Citroen", "C3");

        Car c9 = new Car("Opel", "Astra");
        Car c10 = new Car("Opel", "Corsa");
        Car c11 = new Car("Opel", "Mokka");
        Car c12 = new Car("Opel", "Zafira");

        Car c13 = new Car("Seat", "Leon");
        Car c14 = new Car("Seat", "Panda");
        Car c15 = new Car("Seat", "Malaga");
        Car c16 = new Car("Seat", "Ateca");

        Car c17 = new Car("Fiat", "Panda");
        Car c18 = new Car("Fiat", "Punto");
        Car c19 = new Car("Fiat", "Tipo");
        Car c20 = new Car("Fiat", "500");

        c1.setGarageName(g1.getGarageName());
        c2.setGarageName(g1.getGarageName());
        c3.setGarageName(g1.getGarageName());
        c4.setGarageName(g1.getGarageName());

        c5.setGarageName(g2.getGarageName());
        c6.setGarageName(g2.getGarageName());
        c7.setGarageName(g2.getGarageName());
        c8.setGarageName(g2.getGarageName());

        c9.setGarageName(g3.getGarageName());
        c10.setGarageName(g3.getGarageName());
        c11.setGarageName(g3.getGarageName());
        c12.setGarageName(g3.getGarageName());

        c13.setGarageName(g4.getGarageName());
        c14.setGarageName(g4.getGarageName());
        c15.setGarageName(g4.getGarageName());
        c16.setGarageName(g4.getGarageName());

        c17.setGarageName(g5.getGarageName());
        c18.setGarageName(g5.getGarageName());
        c19.setGarageName(g5.getGarageName());
        c20.setGarageName(g5.getGarageName());

        Car.carList.add(c1);
        Car.carList.add(c2);
        Car.carList.add(c3);
        Car.carList.add(c4);
        Car.carList.add(c5);
        Car.carList.add(c6);
        Car.carList.add(c7);
        Car.carList.add(c8);
        Car.carList.add(c9);
        Car.carList.add(c10);
        Car.carList.add(c11);
        Car.carList.add(c12);
        Car.carList.add(c13);
        Car.carList.add(c14);
        Car.carList.add(c15);
        Car.carList.add(c16);
        Car.carList.add(c17);
        Car.carList.add(c18);
        Car.carList.add(c19);
        Car.carList.add(c20);

        Race r1 = new StandardRace("Montmelo");
        Race r2 = new StandardRace("Shanghai");
        Race r3 = new StandardRace("Monaco");
        Race r4 = new StandardRace("Liechtenstein");
        Race r5 = new StandardRace("Monza");
        Race r6 = new StandardRace("Suzuka");
        Race r7 = new StandardRace("Melbourne");
        Race r8 = new StandardRace("Istambul");
        Race r9 = new StandardRace("Bahrein");
        Race r10 = new StandardRace("Silverstone");

        Race.raceList.add(r1);
        Race.raceList.add(r2);
        Race.raceList.add(r3);
        Race.raceList.add(r4);
        Race.raceList.add(r5);
        Race.raceList.add(r6);
        Race.raceList.add(r7);
        Race.raceList.add(r8);
        Race.raceList.add(r9);
        Race.raceList.add(r10);

        Race r11 = new QualifyingRace("Interlagos");
        Race r12 = new QualifyingRace("Fuji");
        Race r13 = new QualifyingRace("Valencia");
        Race r14 = new QualifyingRace("Marina Bay");
        Race r15 = new QualifyingRace("Monza");
        Race r16 = new QualifyingRace("Abu Dhabi");
        Race r17 = new QualifyingRace("Korea");
        Race r18 = new QualifyingRace("Sochi");
        Race r19 = new QualifyingRace("Sepang");
        Race r20 = new QualifyingRace("Gilles Villeneuve");

        Race.raceList.add(r11);
        Race.raceList.add(r12);
        Race.raceList.add(r13);
        Race.raceList.add(r14);
        Race.raceList.add(r15);
        Race.raceList.add(r16);
        Race.raceList.add(r17);
        Race.raceList.add(r18);
        Race.raceList.add(r19);
        Race.raceList.add(r20);

    }


    public static void main(String[] args) {

        /*Car newCar = new Car("Renault", "Clio", "Garage421");
        System.out.println(newCar.toString());
        JSONObject obj1 = newCar.exportCar();
        Car.exportJSONToFile(obj1);
        JSONObject obj2 = Car.importFromJSONFile("test2.json");
        System.out.println(obj2);
        Car newCar2 = Car.importCar(obj2);
        System.out.println(newCar2);

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

        System.out.println(c.compareTo(c2));*/


    }

}
