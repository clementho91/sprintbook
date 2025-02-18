package com.sprintbook.controllers;

import com.sprintbook.dto.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @PostMapping
    public ResponseEntity<Customer> Add(Customer customer){

        return null;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> Index( ){

        return null;
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
