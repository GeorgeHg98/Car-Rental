package com.rentCar.rentCar.repository;


import com.rentCar.rentCar.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    Optional<Customer> findCustomerById(int id);
    Optional<Customer> findCustomerByName(String name);
    Optional<Customer> findCustomerByFirstName(String firstName);
    Optional<Customer> findCustomerByEmail(String email);


}
