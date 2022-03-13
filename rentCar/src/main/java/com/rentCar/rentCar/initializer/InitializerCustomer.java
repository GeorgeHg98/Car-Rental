package com.rentCar.rentCar.initializer;

import com.rentCar.rentCar.components.CustomFakerCustomer;
import com.rentCar.rentCar.model.Customer;
import com.rentCar.rentCar.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitializerCustomer {

    private CustomerService customerService;

    public InitializerCustomer(CustomerService customerService) {
        this.customerService = customerService;
        List<Customer> customers = CustomFakerCustomer.createDummyCustomerList();
        if (this.customerService.findAll(1, 10, "id").isEmpty()) {
            this.customerService.saveAllCustomers(customers);
        }
    }
}
