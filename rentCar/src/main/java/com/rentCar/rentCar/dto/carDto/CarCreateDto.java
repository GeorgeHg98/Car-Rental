package com.rentCar.rentCar.dto.carDto;

import javax.validation.constraints.NotBlank;

public class CarCreateDto {
    @NotBlank(message = "Brand name is required !")
    private String brand;
    @NotBlank(message = "Model is required !")
    private String model;
    @NotBlank(message = "Body Type is required !")
    private String bodyType;
    @NotBlank(message = "Colour name is required !")
    private String colour;

    private Integer mileage;

    private boolean isBooked;

    private double amount;

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

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
