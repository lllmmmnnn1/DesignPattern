package com.design.factorymethod;

public class CarFactory {
    /*public Car create(){
        System.out.println("a car created!");
        return new Car();
    }*/

    public Moveable create(){
        System.out.println("a car created!");
        return new Car();
    }
}
