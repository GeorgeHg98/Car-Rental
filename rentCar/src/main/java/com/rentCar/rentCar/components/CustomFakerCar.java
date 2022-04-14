package com.rentCar.rentCar.components;
import com.github.javafaker.Faker;
import com.rentCar.rentCar.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerCar {

        public static List<Car>  createDummyCarList(){
            List<Car> carList = new ArrayList<>();

            List<String> brands = new ArrayList<String>();
            brands.add("Toyota");
            brands.add("Mercedes");
            brands.add("BMW");
            brands.add("Nisan");
            brands.add("Dacia");

            List<String> models = new ArrayList<>();
            models.add("e39");
            models.add("e43");
            models.add("e72");
            models.add("e59");
            models.add("e47");

            List<String> bodyType = new ArrayList<>();
            bodyType.add("Sedan");
            bodyType.add("Cabrio");
            bodyType.add("HedgeBack");
            bodyType.add("SUV");


            Faker faker = new Faker();

            for(int i=0; i<500;i++){
                Car car = new Car();
                car.setBrand(brands.get((int)(Math.random()*10)%5));
                car.setModel(models.get((int)(Math.random()*10)%5));
                car.setBodyType(bodyType.get((int)(Math.random()*10)%4));
                car.setColour(faker.color().name());
                car.setMileage(faker.number().numberBetween(1000,200000));
                car.setAmount(faker.number().numberBetween(100,500));

                carList.add(car);
            }

            return carList;
        }

    public CustomFakerCar() {
            createDummyCarList();
    }
}

