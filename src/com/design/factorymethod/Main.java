package com.design.factorymethod;

public class Main {

    public static void main(String[] args) {
        /*Car c = new Car();
        c.go();*/

        /*Plane p =new Plane();
        p.go();*/

        /*Moveable m =new Car();
        m.go();*/

        Moveable m=new SimpleVehicleFactory().createCar();
        m.go();

        /*Moveable m= new CarFactory().createCar();
        m.go();*/
    }
}
