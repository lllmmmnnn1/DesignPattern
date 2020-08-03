package com.design.abstractfactory;

public class Main {

    public static void main(String[] args) {
        /*Car c = new Car();
        c.go();
        AK47 a =new AK47();
        a.shoot();
        Bread b =new Bread();
        b.printName();*/
        AbastractFactory f =new ModernFactory();
        Vehicle v =f.createVehicle();
        v.go();
        Weapon w =f.createWeapon();
        w.shoot();
        Food food =f.createFood();
        food.printName();


    }
}
