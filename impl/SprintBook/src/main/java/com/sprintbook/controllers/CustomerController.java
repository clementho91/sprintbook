package com.sprintbook.controllers;

import com.sprintbook.dto.Customer;
import com.sprintbook.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> Add(Customer customer){

        return null;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> Index( ){
        List<Customer> customers = customerService.GetAll();
        return ResponseEntity.ok( customers);
    }


    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") UUID id){

        return null;
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id){

        return null;
    }

}
