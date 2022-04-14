package com.rentCar.rentCar.dto.bookingDto;

import com.rentCar.rentCar.model.Car;
import com.rentCar.rentCar.model.Customer;

import java.util.Date;

public class BookingDto {
    public Date startDate;
    public Date endDate;
    public Integer carId;
    public Integer customerId;

    public BookingDto(Date startDate, Date endDate, Integer carId, Integer customerId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.carId = carId;
        this.customerId = customerId;
    }

    public BookingDto() {

    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}
