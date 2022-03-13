package com.rentCar.rentCar.service;

import com.rentCar.rentCar.dto.carDto.CarCreateDto;
import com.rentCar.rentCar.dto.carDto.CarFullDto;
import com.rentCar.rentCar.dto.carDto.CarResponseDto;
import com.rentCar.rentCar.model.Car;

import java.util.List;

public interface CarService {
    CarResponseDto create(CarCreateDto carCreateDto);

    CarFullDto findCarByBrand(String brand);

   CarFullDto findCarById(Integer id);

    CarFullDto findCarByBrandAndModel(String brand, String model);

    List<CarFullDto> findAll(Integer pageNumber, Integer pageSize, String sortBy);

    void saveAllCars(List<Car> listOfCars);
}

