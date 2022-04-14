package com.rentCar.rentCar.mapper;

import com.rentCar.rentCar.dto.customerDto.CustomerCreateDto;
import com.rentCar.rentCar.dto.customerDto.CustomerFullDto;
import com.rentCar.rentCar.dto.customerDto.CustomerLoginDto;
import com.rentCar.rentCar.dto.customerDto.CustomerResponseDto;
import com.rentCar.rentCar.model.Customer;

public class CustomerMapper {

    public static Customer customerToEntity(CustomerCreateDto customerCreateDto) {
        Customer customer = new Customer();
        customer.setName(customerCreateDto.getName());
        customer.setFirstName(customerCreateDto.getFirstName());
        customer.setEmail(customerCreateDto.getEmail());
        customer.setAddress(customerCreateDto.getAddress());

        return customer;
    }

    public static CustomerResponseDto customerResponseDto(Customer customer) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setId(customer.getId());
        customerResponseDto.setName(customer.getName());
        customerResponseDto.setFirstName(customer.getFirstName());
        customerResponseDto.setEmail(customer.getEmail());
        customerResponseDto.setAddress(customer.getAddress());

        return customerResponseDto;
    }

    public static CustomerFullDto customerToFullDto(Customer customer) {
        CustomerFullDto customerFullDto = new CustomerFullDto();
        customerFullDto.setId(customer.getId());
        customerFullDto.setName(customer.getName());
        customerFullDto.setFirstName(customer.getFirstName());
        customerFullDto.setEmail(customer.getEmail());
        customerFullDto.setAddress(customer.getAddress());
        return customerFullDto;

    }

}
