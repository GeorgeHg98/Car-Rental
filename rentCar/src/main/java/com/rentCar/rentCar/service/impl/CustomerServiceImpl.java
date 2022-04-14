package com.rentCar.rentCar.service.impl;

import com.rentCar.rentCar.dto.customerDto.CustomerCreateDto;
import com.rentCar.rentCar.dto.customerDto.CustomerFullDto;
import com.rentCar.rentCar.dto.customerDto.CustomerLoginDto;
import com.rentCar.rentCar.dto.customerDto.CustomerResponseDto;
import com.rentCar.rentCar.exceptions.CustomerException;
import com.rentCar.rentCar.exceptions.EmailAddressAlreadyUsedException;
import com.rentCar.rentCar.exceptions.InvalidEmailAddressException;
import com.rentCar.rentCar.mapper.CustomerMapper;
import com.rentCar.rentCar.model.Customer;
import com.rentCar.rentCar.repository.CustomerRepository;
import com.rentCar.rentCar.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Value("${user.validation.email-regex}")
    private String emailRegex = "^(.+)@gmail\\.com";

    private final CustomerRepository customerRepository;

    private CustomerMapper customerMapper;

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
    public Customer toEntity(CustomerFullDto loginDTO) {
        return new Customer(
                null,
                null,
                loginDTO.getEmail(),
                loginDTO.getPassword(),
                null
        );
    }

    @Override
    public Customer toEntity(CustomerLoginDto loginDTO) {
        return null;
    }


    @Override
    public CustomerFullDto signUp(CustomerLoginDto loginDTO) throws InvalidEmailAddressException, EmailAddressAlreadyUsedException {
        if (!isValidEmail(loginDTO.getEmail())) {
            throw new InvalidEmailAddressException(loginDTO.getEmail());
        }
        if (customerRepository.existsByEmail(loginDTO.getEmail())) {
            throw new EmailAddressAlreadyUsedException(loginDTO.getEmail());
        }
        Customer customer = customerRepository.save(toEntity(loginDTO));
        return CustomerMapper.customerToFullDto(customer);
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches(emailRegex);
    }

    //TODO
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

    @Override
    public CustomerFullDto login(CustomerLoginDto customerLoginDto) {
        Optional<Customer> customer = customerRepository.findCustomerByEmail(customerLoginDto.getEmail());
        return CustomerMapper.customerToFullDto(customer.get());
    }
}
