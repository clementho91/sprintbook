package com.sprintbook.service;

import com.sprintbook.dto.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer Add(Customer customer);
    Customer FindById(UUID id);
    List<Customer> GetAll(  );
    void Delete(UUID id);


}
