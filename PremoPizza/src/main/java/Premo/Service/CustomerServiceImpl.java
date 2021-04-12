package Premo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Premo.Model.Customer;
import Premo.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List < Customer > getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String phonenumber) {
        Optional < Customer > optional = customerRepository.findById(phonenumber);
        Customer customer = null;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(" Customer not found for phonenumber :: " + phonenumber);
        }
        return customer;
    }

    @Override
    public void deleteCustomerById(String phonenumber) {
        this.customerRepository.deleteById(phonenumber);
    }
}
