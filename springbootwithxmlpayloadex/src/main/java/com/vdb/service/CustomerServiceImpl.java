package com.vdb.service;

import com.vdb.model.Customer;
import com.vdb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer signUp(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public boolean signIn(String custEmailId, String custPassword) {

        boolean flag = false;

        Customer customer = customerRepository.findByCustEmailIdAndCustPassword(custEmailId, custPassword);

        if (customer != null) {
            flag = true;
        }

        return flag;
    }

    @Override
    public Optional<Customer> findById(long custId) {
        return customerRepository.findById(custId);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(long custId, Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(long custId) {
        customerRepository.deleteById(custId);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }
}
