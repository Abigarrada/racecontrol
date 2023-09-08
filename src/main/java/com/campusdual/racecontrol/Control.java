package com.campusdual.racecontrol;

import com.campusdual.util.Input;

/*
 * Control class with program output.
 */
public class Control {
    public static void main(String[] args) {
        Control.populateApp();
        Menu.mainMenu();
    }



    /*
    * NECESITO
    *
    * --PARA LOS GARAJES Y COCHES--
    *       registrar un garaje
    *       registrar un coche OK
    *       ver lista de garajes
    *       ver lista de coches
    *       ver lista de coches por garaje
    *
    * --PARA LOS TORNEOS Y CARRERAS--
    *       ver lista de torneos
    *       ver lista de carreras por torneo
    *       crear un torneo
    *       crear carreras
    *       añadir carreras a torneos
    *       añadir garajes a carreras
    *       añadir coches aleatoriamente
    *
    * --PARA EL RANKING--
    *       guardar puntuación por coche
    *
    * */


    public static void populateApp(){

        Garage g1 = new Garage("Renault");
        Garage g2 = new Garage("Citroen");
        Garage g3 = new Garage("Opel");
        Garage g4 = new Garage("Seat");
        Garage g5 = new Garage("Fiat");

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

        Garage.garageList.add(g1);
        Garage.garageList.add(g2);
        Garage.garageList.add(g3);
        Garage.garageList.add(g4);
        Garage.garageList.add(g5);



    }



}