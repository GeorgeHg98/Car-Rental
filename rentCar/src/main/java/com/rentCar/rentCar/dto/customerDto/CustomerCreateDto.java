package com.rentCar.rentCar.dto.customerDto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class CustomerCreateDto {

    @NotBlank(message = "First name is required !")
    private String firstName;
    @NotBlank(message = "Name is required !")
    private String name;
    @NotBlank(message = "Email is required !")
    private String email;
    @NotBlank(message = "Address is required !")
    private String address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
