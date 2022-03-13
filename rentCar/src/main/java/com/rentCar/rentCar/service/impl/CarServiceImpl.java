package com.rentCar.rentCar.service.impl;

import com.rentCar.rentCar.exceptions.CarException;
import com.rentCar.rentCar.dto.carDto.CarCreateDto;
import com.rentCar.rentCar.dto.carDto.CarFullDto;
import com.rentCar.rentCar.dto.carDto.CarResponseDto;
import com.rentCar.rentCar.mapper.CarMapper;
import com.rentCar.rentCar.model.Car;
import com.rentCar.rentCar.repository.CarRepository;
import com.rentCar.rentCar.service.CarService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarResponseDto create(CarCreateDto carCreateDto) {
Car car = CarMapper.carToEntity(carCreateDto);
Car savedCar = carRepository.save(car);
        return CarMapper.carToResponseDto(savedCar);
    }

    @Override
    public CarFullDto findCarByBrand(String brand) {
        Car car = carRepository.findCarByBrand(brand).orElseThrow(() ->
                new CarException("Car with brand: " + brand + " not found !"));
        return CarMapper.carToFullDto(car);
    }

    @Override
    public CarFullDto findCarById(Integer id) {
        Car car = carRepository.findById(id).orElseThrow(() ->
        new CarException("Car with ID: " + id + "is not found !"));
        return CarMapper.carToFullDto(car);
    }

    @Override
    public CarFullDto findCarByBrandAndModel(String brand, String model) {
        Car car = carRepository.findCarByBrandAndModel(brand, model).orElseThrow(() ->
                new CarException("Company with Brand: " +brand +" and Model: " + model +" not found !"));

        return CarMapper.carToFullDto(car);
    }

    @Override
    public List<CarFullDto> findAll(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

        List<CarFullDto> result = new ArrayList<>();
        carRepository.findAll(pageable).forEach(entity -> {
            result.add(CarMapper.carToFullDto(entity));
        });

        return result;
    }

    @Override
    public void saveAllCars(List<Car> listOfCars) {
        carRepository.saveAll(listOfCars);
        System.out.println(listOfCars.size() + " companies was added");

    }
}
