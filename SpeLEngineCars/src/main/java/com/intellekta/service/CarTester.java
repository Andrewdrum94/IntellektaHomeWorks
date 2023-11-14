package com.intellekta.service;

@SuppressWarnings("unused")
public class CarTester {

    private boolean goodCar;
    private boolean greatCar;
    private String carInfo;

    public CarTester() {
    }

    public boolean isGoodCar() {
        return goodCar;
    }

    public void setGoodCar(boolean goodCar) {
        this.goodCar = goodCar;
    }

    public boolean isGreatCar() {
        return greatCar;
    }

    public void setGreatCar(boolean greatCar) {
        this.greatCar = greatCar;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    @Override
    public String toString() {
        return "CarTester{" +
                "goodCar=" + goodCar +
                ", greatCar=" + greatCar +
                ", carInfo='" + carInfo + '\'' +
                '}';
    }
}
