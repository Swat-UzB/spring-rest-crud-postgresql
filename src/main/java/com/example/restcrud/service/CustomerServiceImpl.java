package com.example.restcrud.service;

import com.example.restcrud.exception.CustomerNotFound;
import com.example.restcrud.model.Customer;
import com.example.restcrud.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    // == fields ==
    @Autowired
    private CustomerRepo customerRepo;

    // == public methods ==
    @Override
    public List<Customer> getCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> getCustomer(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isEmpty())
            throw new CustomerNotFound("id="+ id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }

//    @Override
//    public void updateCustomer(Customer customer) {
//        customerRepo.findById(customer.getId());
//
//    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }
}
