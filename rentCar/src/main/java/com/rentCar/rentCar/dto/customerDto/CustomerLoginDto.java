package com.rentCar.rentCar.dto.customerDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomerLoginDto {
    private String email;
    private String password;
}
