package com.example.demo.customer;
// This is Fake Repository for returning example data only. We will remove this class from actual project
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//@Component put this class in bean means ready to execute & it will create new instance of this class as singleton class.
//@Component(value = "fake")
//@Repository(value = "fake") in this we have define a Qualifier like a identifier which we use in Service class to give as reference.
@Repository(value = "fake")
//But instead of using @Component here we can use @Repository as this is much better approach and @Component already inside the @Repository.
public class CustomerFakeRepository implements CustomerInterface {
    //@Override it override the functions from Interface.
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
            new Customer(1L,"Gaurav Jindal","password123","email.gamil.com"),
            new Customer(2L,"Nazmul","123password","email.gamil.com")
        );
    }

    //.Stream API is used to process collections of objects
    @Override
    public Customer getCustomer(Long id) {
        return getCustomers()
                .stream()
                .filter(customer -> Objects.equals(customer.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("customer with id " + id + " not found"));
    }
}
