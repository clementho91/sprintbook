package com.sprintbook.controllers;

import com.sprintbook.dto.CreateCustomer;
import com.sprintbook.dto.Customer;
import com.sprintbook.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Customer> Add(CreateCustomer customer){
        Customer savedCustomer =  this.customerService.Add( customer );
        return ResponseEntity.ok(savedCustomer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> Index( ){
        List<Customer> customers = customerService.GetAll();
        return ResponseEntity.ok( customers);
    }


    @GetMapping("{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") UUID id){
        Customer customer = customerService.FindById(id);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }


    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id){
        Customer customer = customerService.FindById(id);
        if(customer == null){
            return ResponseEntity.notFound().build();
        }
        customerService.Delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
