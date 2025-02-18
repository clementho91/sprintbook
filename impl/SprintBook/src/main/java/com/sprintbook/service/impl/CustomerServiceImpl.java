package com.sprintbook.service.impl;

import com.sprintbook.dto.Customer;
import com.sprintbook.mappers.CustomerMapper;
import com.sprintbook.model.CustomerModel;
import com.sprintbook.repository.CustomerRepository;
import com.sprintbook.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerRepository customerRepository;


    @Override
    @Transactional
    public Customer Add(Customer customer) {
        CustomerModel model = customerMapper.map(customer);
        customerRepository.save(model);
        return null;
    }

    @Override
    public Customer FindById(UUID id) {
        return null;
    }

    @Override
    public List<Customer> GetAll() {

        return customerRepository.findAll().stream().map( entity-> {
            return customerMapper.map(entity);
        }).collect(Collectors.toList() );
    }

    @Override
    public void Delete(UUID id) {

    }
}
