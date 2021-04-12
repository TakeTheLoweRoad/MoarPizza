package Premo.Service;

import java.util.List;

import Premo.Model.Customer;

public interface CustomerService {
    List < Customer > getAllCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(String phonenumber);
    void deleteCustomerById(String phonenumber);

}    
