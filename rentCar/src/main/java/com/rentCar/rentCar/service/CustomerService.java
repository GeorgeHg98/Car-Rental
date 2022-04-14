package com.rentCar.rentCar.service;

import com.rentCar.rentCar.dto.customerDto.CustomerCreateDto;
import com.rentCar.rentCar.dto.customerDto.CustomerFullDto;
import com.rentCar.rentCar.dto.customerDto.CustomerLoginDto;
import com.rentCar.rentCar.dto.customerDto.CustomerResponseDto;

import com.rentCar.rentCar.exceptions.EmailAddressAlreadyUsedException;
import com.rentCar.rentCar.exceptions.InvalidEmailAddressException;
import com.rentCar.rentCar.model.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto create(CustomerCreateDto customerCreateDto);

    Customer toEntity(CustomerFullDto loginDTO);

    Customer toEntity(CustomerLoginDto loginDTO);

    //TODO
    CustomerFullDto signUp(CustomerLoginDto loginDTO) throws InvalidEmailAddressException, EmailAddressAlreadyUsedException;

    CustomerFullDto findCustomerByName(String name);

    CustomerFullDto findCustomerById(Integer id);

    CustomerFullDto findCustomerByFirstName(String firstName);

    CustomerFullDto findCustomerByEmail(String email);

    CustomerFullDto login(CustomerLoginDto customerLoginDto);

    List<CustomerFullDto> findAll(Integer pageNumber, Integer pageSize, String sortBy);

    void saveAllCustomers(List<Customer> listOfCustomers);
}
