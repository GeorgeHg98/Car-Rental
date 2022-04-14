package com.rentCar.rentCar.repository;

import com.rentCar.rentCar.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
