package com.sprintbook.service;

import com.sprintbook.dto.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer Add(Customer customer);
    Customer findById(UUID id);
    List<Customer> get(  );
    void delete(UUID id);


}
