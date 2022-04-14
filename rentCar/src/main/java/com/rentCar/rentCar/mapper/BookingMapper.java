package com.rentCar.rentCar.mapper;

import com.rentCar.rentCar.dto.bookingDto.BookingDto;
import com.rentCar.rentCar.model.Booking;
import com.rentCar.rentCar.repository.BookingRepository;
import com.rentCar.rentCar.repository.CarRepository;
import com.rentCar.rentCar.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {
    private CarRepository carRepository;
    private CustomerRepository customerRepository;

    public BookingMapper(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public  Booking mapToEntity(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setStartDate(bookingDto.getStartDate());
        booking.setEndDate(bookingDto.getEndDate());
        booking.setCar(carRepository.findById(bookingDto.getCarId()).get());
        booking.setCustomer(customerRepository.findById(bookingDto.getCustomerId()).get());
        return booking;
    }

    public static BookingDto toDto(Booking savedBooking) {
        BookingDto booking = new BookingDto();
        booking.setStartDate(savedBooking.getStartDate());
        booking.setEndDate(savedBooking.getEndDate());
        booking.setCarId(savedBooking.getCar().getId());
        booking.setCustomerId(savedBooking.getCustomer().getId());
        return booking;
    }
}
