package com.newer.domain;

import java.io.Serializable;

public class Car implements Serializable {

    private Integer carId;
    private String plateNumeber;
    private Integer fuel;
    private String state;
    private Integer parkId;
    private Integer typeId;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getPlateNumeber() {
        return plateNumeber;
    }

    public void setPlateNumeber(String plateNumeber) {
        this.plateNumeber = plateNumeber;
    }

    public Integer getFuel() {
        return fuel;
    }

    public void setFuel(Integer fuel) {
        this.fuel = fuel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", plateNumeber='" + plateNumeber + '\'' +
                ", fuel=" + fuel +
                ", state='" + state + '\'' +
                ", parkId=" + parkId +
                ", typeId=" + typeId +
                '}';
    }
}
