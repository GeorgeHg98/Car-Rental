package com.rentCar.rentCar.components;


import com.github.javafaker.Faker;
import com.rentCar.rentCar.model.Customer;

import java.util.ArrayList;
import java.util.List;


public class CustomFakerCustomer {

    public static List<Customer> createDummyCustomerList(){
        List<Customer> customerList = new ArrayList<>();

        Faker faker = new Faker();

        for(int i=0; i<500;i++){
            Customer customer = new Customer();
            customer.setFirstName(faker.name().firstName());
            customer.setName(faker.name().lastName());
            customer.setEmail(faker.bothify("?????##@yahoo.com"));
            customer.setAddress(faker.address().fullAddress());

            customerList.add(customer);
        }

        return customerList;
    }
}

