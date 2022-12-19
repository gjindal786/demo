package com.example.demo.customer;
// This is service class which used in our controller.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
//@Component put this class in bean means ready to execute & it will create new instance of this class as singleton class.
//@Component
@Service
//But instead of using @Component here we can use @Service as this is much better approach and @Component already inside the @Service.
public class CustomerService {


    private final CustomerInterface customerInterface;

    @Autowired
    public CustomerService(CustomerInterface customerInterface) {
        this.customerInterface = customerInterface;
    }
    /*
    // Implement one interface with multiple repository & we need to provide a Qualifier like a identifier for which repository we need to inject.
    public CustomerService(@Qualifier("fake") CustomerInterface customerInterface) {
        this.customerInterface = customerInterface;
    }
    */
    List <Customer> getCustomers() {
        return customerInterface.getCustomers();
    }

    Customer getCustomer(Long id) {
        return customerInterface.getCustomer(id);
    }
}
