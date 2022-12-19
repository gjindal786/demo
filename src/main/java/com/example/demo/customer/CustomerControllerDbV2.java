package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//This is a Normal Controller Class where we write business Logic .

//@RestController As it gives default things to our controller like HTTP request GET, POST methods
@RestController

//@AllArgsConstructor it replaces constructor function as it auto do for us.
@AllArgsConstructor

//@RequestMapping Here we can set base path after domain for api like domain/api/v1/customer to access below api functions
@RequestMapping(path = "api/db/v2/customer")
public class CustomerControllerDbV2 {

    private final CustomerDbService customerDbService;

    //@Autowired is auto-injection of CustomerService from the bean i.e which exist in the project.
//    @Autowired
//    public CustomerControllerDbV2(CustomerDbService customerDbService) {
//        this.customerDbService = customerDbService;
//    }
    //@GetMapping is kind of GET request with value which is part of url while you access this service.
    //e.g localhost:8080/api/v1/customer/all to access below
    @GetMapping(value = "all")
    List <Customer> getCustomers() {
        System.out.println("All Customers for V2");
        return customerDbService.getCustomers();
    }

    @GetMapping(path="{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerDbService.getCustomer(id);
    }

    @GetMapping(path="{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for customer " + id
        );
    }

    //@PostMapping is kind of POST request.
    //@RequestBody : Data getting from body, it should inline with Customer class variables like id,name,password
    //@Valid : Add validation on data model like we have name and password should be non-blank.
    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("Post Request");
        System.out.println(customer);
    }

    //@PutMapping is kind of PUT request.
    //@RequestBody : Data getting from body, it should inline with Customer class variables like id,name,password
    @PutMapping
    void updateNewCustomer(@RequestBody Customer customer) {
        System.out.println("Update Request");
        System.out.println(customer);
    }

    //@DeleteMapping is kind of Delete request.
    //We can add more parameters to like {customerId}/name/{customerName} here we have 2 customerId & customerName
    //@PathVariable is used to access arguments/parameters from request url
    @DeleteMapping(path="{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("Delete Request for customer id "+ id);
    }
}
