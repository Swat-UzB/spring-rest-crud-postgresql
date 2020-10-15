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
        return customerRepo.findById(id);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        if (customerRepo.findById(id).isPresent()) {
            Optional<Customer> customer1 = customerRepo.findById(id);

        }
        customerRepo.findById(id);


    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }
}
