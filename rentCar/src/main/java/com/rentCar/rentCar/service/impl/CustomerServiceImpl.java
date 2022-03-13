package com.rentCar.rentCar.service.impl;

import com.rentCar.rentCar.dto.customerDto.CustomerCreateDto;
import com.rentCar.rentCar.dto.customerDto.CustomerFullDto;
import com.rentCar.rentCar.dto.customerDto.CustomerResponseDto;
import com.rentCar.rentCar.exceptions.CustomerException;
import com.rentCar.rentCar.mapper.CustomerMapper;
import com.rentCar.rentCar.model.Customer;
import com.rentCar.rentCar.repository.CustomerRepository;
import com.rentCar.rentCar.service.CustomerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDto create(CustomerCreateDto customerCreateDto) {
        Customer customer = CustomerMapper.customerToEntity(customerCreateDto);
        Customer savedCustomer = customerRepository.save(customer);

        return CustomerMapper.customerResponseDto(savedCustomer);
    }

    @Override
    public CustomerFullDto findCustomerByName(String name) {
        Customer customer = customerRepository.findCustomerByName(name).orElseThrow(() ->
                new CustomerException("Customer with name: " + name + " not found !"));
        return CustomerMapper.customerToFullDto(customer);
    }

    @Override
    public CustomerFullDto findCustomerById(Integer id) {
        Customer customer = customerRepository.findCustomerById(id).orElseThrow(() ->
                new CustomerException("Customer with id: " + id + " is not found!"));
        return CustomerMapper.customerToFullDto(customer);
    }

    @Override
    public CustomerFullDto findCustomerByFirstName(String firstName) {
        Customer customer = customerRepository.findCustomerByFirstName(firstName).orElseThrow(() ->
                new CustomerException("Customer with first name: " + firstName + " is not found!"));
        return CustomerMapper.customerToFullDto(customer);
    }

    @Override
    public CustomerFullDto findCustomerByEmail(String email) {
        Customer customer = customerRepository.findCustomerByEmail(email).orElseThrow(() ->
                new CustomerException("Customer with the email: " + email + " is not found!"));
        return CustomerMapper.customerToFullDto(customer);
    }

    @Override
    public List<CustomerFullDto> findAll(Integer pageNumber, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

        List<CustomerFullDto> result = new ArrayList<>();
        customerRepository.findAll(pageable).forEach(entity -> {
            result.add(CustomerMapper.customerToFullDto(entity));
        });

        return result;
    }

    @Override
    public void saveAllCustomers(List<Customer> listOfCustomers) {
        customerRepository.saveAll(listOfCustomers);
        System.out.println(listOfCustomers.size() + " companies was added");

    }
}
