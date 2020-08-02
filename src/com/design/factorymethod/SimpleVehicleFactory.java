package com.design.factorymethod;

/**
 * 简单工厂的可扩展性并不好
 */
public class SimpleVehicleFactory {
    public Car createCar(){
        //前置操作，可以进行一部分业务处理，也能后面创建后进行一部分业务处理
        return new Car();
    }

    public Plane createPlane(){
        return new Plane();
    }
}
