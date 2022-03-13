package com.rentCar.rentCar.mapper;

import com.rentCar.rentCar.dto.carDto.CarCreateDto;
import com.rentCar.rentCar.dto.carDto.CarFullDto;
import com.rentCar.rentCar.dto.carDto.CarResponseDto;
import com.rentCar.rentCar.model.Car;

public class CarMapper {

    public static Car carToEntity(CarCreateDto carCreateDto) {
        Car car = new Car();
        car.setBrand(carCreateDto.getBrand());
        car.setModel(carCreateDto.getModel());
        car.setBodyType(carCreateDto.getBodyType());
        car.setColour(carCreateDto.getColour());
        car.setMileage(carCreateDto.getMileage());

        return car;
    }

    public static CarResponseDto carToResponseDto(Car car) {
        CarResponseDto carResponseDto = new CarResponseDto();
        carResponseDto.setId(car.getId());
        carResponseDto.setBrand(car.getBrand());
        carResponseDto.setModel(car.getModel());
        carResponseDto.setMileage(car.getMileage());
        carResponseDto.setAmount(car.getAmount());

        return carResponseDto;
    }

    public static CarFullDto carToFullDto(Car car) {
        CarFullDto carFullDto = new CarFullDto();
        carFullDto.setId(car.getId());
        carFullDto.setBrand(car.getBrand());
        carFullDto.setModel(car.getModel());
        carFullDto.setBodyType(car.getBodyType());
        carFullDto.setColour(car.getColour());
        carFullDto.setMileage(car.getMileage());
        carFullDto.setAmount(car.getAmount());

        return carFullDto;

    }
}


