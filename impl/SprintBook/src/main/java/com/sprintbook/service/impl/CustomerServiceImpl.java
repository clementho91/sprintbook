package com.sprintbook.service.impl;

import com.sprintbook.dto.Customer;
import com.sprintbook.service.CustomerService;

import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer Add(Customer customer) {
        return null;
    }

    @Override
    public Customer findById(UUID id) {
        return null;
    }

    @Override
    public List<Customer> get() {
        return List.of();
    }

    @Override
    public void delete(UUID id) {

    }
}
