package com.example.restcrud.controller;

import com.example.restcrud.exception.CustomerNotFound;
import com.example.restcrud.model.Customer;
import com.example.restcrud.service.CustomerService;
import com.example.restcrud.util.Mappings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
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

    // http://localhost:8082/api/customers/{customerId}
    @GetMapping(Mappings.CUSTOMERS_CUSTOMERID)
    public ResponseEntity<?> getCustomer(@PathVariable int customerId) {
        Optional<Customer> customer = customerService.getCustomer(customerId);
        if (customer.isEmpty())
            throw new CustomerNotFound("Customer id not found : " + customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // http://localhost:8082/api/customers
    @PostMapping(Mappings.CUSTOMERS)
    public ResponseEntity<?> createCustomers(@RequestBody Customer customer) {
        log.info("new customer : {}", customer);
        customer.setId(0);
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // http://localhost:8082/api/customers/{customerId}
    @DeleteMapping(Mappings.CUSTOMERS_CUSTOMERID)
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) {
        if (!customerService.getCustomer(customerId).isPresent())
            throw new CustomerNotFound("Customer id not found : " + customerId);
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Deleted Customer id - "+customerId,HttpStatus.OK);
    }

    // http://localhost:8082/api/customers
    @PutMapping(Mappings.CUSTOMERS)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
