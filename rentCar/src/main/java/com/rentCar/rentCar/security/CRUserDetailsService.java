package com.rentCar.rentCar.security;

import com.rentCar.rentCar.model.Customer;
import com.rentCar.rentCar.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CRUserDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;

public CRUserDetailsService(CustomerRepository customerRepository){
    this.customerRepository =customerRepository;
}
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer repoCustomer  =customerRepository.findCustomerByEmail(email).get();
   CRUserDetails securityUserDetails = new CRUserDetails(repoCustomer);
   return securityUserDetails;
    }
}
