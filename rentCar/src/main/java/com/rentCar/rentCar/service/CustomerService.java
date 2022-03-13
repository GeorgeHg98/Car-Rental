package com.rentCar.rentCar.service;

import com.rentCar.rentCar.dto.customerDto.CustomerCreateDto;
import com.rentCar.rentCar.dto.customerDto.CustomerFullDto;
import com.rentCar.rentCar.dto.customerDto.CustomerResponseDto;

import com.rentCar.rentCar.model.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto create(CustomerCreateDto customerCreateDto);

    CustomerFullDto findCustomerByName(String name);

    CustomerFullDto findCustomerById(Integer id);

    CustomerFullDto findCustomerByFirstName(String firstName);

    CustomerFullDto findCustomerByEmail(String email);

    List<CustomerFullDto> findAll(Integer pageNumber, Integer pageSize, String sortBy);

    void saveAllCustomers(List<Customer> listOfCustomers);
}
