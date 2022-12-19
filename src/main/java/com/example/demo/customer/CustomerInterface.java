package com.example.demo.customer;
// This is interface class where we define all methods
import java.util.List;
//Here we have implement interface with 2 Repositories
public interface CustomerInterface {
    List<Customer> getCustomers();
    Customer getCustomer(Long id);
}
