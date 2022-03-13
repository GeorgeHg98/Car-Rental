package com.rentCar.rentCar.components;

import com.github.javafaker.Faker;
import com.rentCar.rentCar.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomFakerEmployee {

    public List<Employee> createDummyEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();

        Faker faker = new Faker();

        for(int i=0; i<500;i++){
            Employee employee = new Employee();
            employee.setFirstName(faker.name().firstName());
            employee.setName(faker.name().lastName());
            employee.setPosition(faker.job().position());

            employeeList.add(employee);
        }

        return employeeList;
    }
}

