package com.rentCar.rentCar.config;

import com.rentCar.rentCar.components.CustomFakerCustomer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomFakerCustomer customFakerCustomer(){
        return new CustomFakerCustomer();
    }
}
