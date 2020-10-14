package com.example.restcrud.service;

import com.example.restcrud.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getCustomers();

    Optional<Customer> getCustomer(int id);

    void deleteCustomer(int id);

//    void updateCustomer(Customer customer);

    void saveCustomer(Customer customer);

}
