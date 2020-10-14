package com.example.restcrud.controller;

import com.example.restcrud.service.CustomerService;
import com.example.restcrud.util.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Mappings.API)
public class CustomerController {

    // == fields ==
    @Autowired
    CustomerService customerService;

    // == request methods ==
    // http://localhost:8082/api/customers
    @GetMapping(Mappings.CUSTOMERS)
    public ResponseEntity<?> getCustomers() {
        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
    }
}
