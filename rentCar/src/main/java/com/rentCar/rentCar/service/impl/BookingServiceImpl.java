package com.rentCar.rentCar.service.impl;

import com.rentCar.rentCar.dto.bookingDto.BookingDto;
import com.rentCar.rentCar.mapper.BookingMapper;
import com.rentCar.rentCar.model.Booking;
import com.rentCar.rentCar.model.Car;
import com.rentCar.rentCar.repository.BookingRepository;
import com.rentCar.rentCar.repository.CarRepository;
import com.rentCar.rentCar.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository repository;
    private CarRepository carRepository;
    private BookingMapper bookingMapper;

    public BookingServiceImpl(BookingRepository repository, CarRepository carRepository, BookingMapper bookingMapper) {
        this.repository = repository;
        this.carRepository = carRepository;
        this.bookingMapper = bookingMapper;
    }

    @Override
    public List<Car> getAvailableCars(Date startDate, Date endDate) {
        List<Car> availableCars = (List<Car>) carRepository.findAll();

        List<Booking> allBookings = repository.findAll();

        boolean isCarAvailable = true;
        for (Car c : availableCars) {
            for (Booking b : allBookings) {

                if ((startDate.before(b.getStartDate()) && endDate.before(b.getStartDate())) ||
                        (startDate.after(b.getEndDate()) && endDate.after(b.getEndDate()))) {

                } else {
                    isCarAvailable = false;
                }
            }
            if (!isCarAvailable) {
                availableCars.remove(c);
            }
        }
        return availableCars;
    }


    @Override
    public BookingDto create(BookingDto bookingDto) {

        List<Booking> allBookings = repository.findAll();

        boolean isCarAvailable = true;
        for (Booking b : allBookings) {
            if ((bookingDto.startDate.before(b.getStartDate()) && bookingDto.endDate.before(b.getStartDate())) ||
                    (bookingDto.startDate.after(b.getEndDate()) && bookingDto.endDate.after(b.getEndDate()))) {

            } else {
                isCarAvailable = false;
            }
        }
        Booking entityToSave = bookingMapper.mapToEntity(bookingDto);
        Booking savedBooking = repository.save(entityToSave);
        return bookingMapper.toDto(savedBooking);
    }


}
