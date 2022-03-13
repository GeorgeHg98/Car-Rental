package com.rentCar.rentCar.initializer;

import com.rentCar.rentCar.components.CustomFakerCar;
import com.rentCar.rentCar.components.CustomFakerCustomer;
import com.rentCar.rentCar.model.Car;
import com.rentCar.rentCar.model.Customer;
import com.rentCar.rentCar.service.CarService;
import com.rentCar.rentCar.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Initializer {

    private CarService carService;

    private CustomerService customerService;

    public Initializer(CarService carService) {
        this.carService = carService;
        List<Car> cars = CustomFakerCar.createDummyCarList();
        if (this.carService.findAll(1, 10, "id").isEmpty()) {
            this.carService.saveAllCars(cars);
        }
    }

}