package com.rentCar.rentCar.controller;


import com.rentCar.rentCar.dto.customerDto.CustomerFullDto;
import com.rentCar.rentCar.dto.customerDto.CustomerLoginDto;
import com.rentCar.rentCar.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/customer")
@ControllerAdvice
public class CustomerController {
CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<CustomerFullDto>> getAll(){
        return new ResponseEntity<>(customerService.findAll(1,500,"Id"), HttpStatus.OK);
    }

   @PostMapping("/signup")
    public ResponseEntity<CustomerFullDto> signup(@RequestBody CustomerLoginDto loginDto){
        return new ResponseEntity<>(customerService.signUp(loginDto), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerFullDto> login(@RequestBody CustomerLoginDto loginDto){
        return new ResponseEntity<>(customerService.login(loginDto),HttpStatus.OK);
    }
}
