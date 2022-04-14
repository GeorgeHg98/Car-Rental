package com.rentCar.rentCar.service;

import com.rentCar.rentCar.dto.bookingDto.BookingDto;
import com.rentCar.rentCar.model.Car;

import java.util.Date;
import java.util.List;

public interface BookingService {
     List<Car> getAvailableCars(Date startDate, Date endDate);

    BookingDto create(BookingDto bookingDto);


}
