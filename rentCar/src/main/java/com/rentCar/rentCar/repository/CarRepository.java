package com.rentCar.rentCar.repository;

import com.rentCar.rentCar.model.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Integer> {

    Optional<Car> findCarByBrand(String brand);

    Optional<Car> findCarByBrandAndModel(String brand, String model);

//    Optional<Car> findById(Integer id);

//    void saveAllCars(List<Car> listOfCars);



}

