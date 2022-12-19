package com.example.demo.customer;
// This is service class which used in our controller.
import com.example.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

//@Component put this class in bean means ready to execute & it will create new instance of this class as singleton class.
//@Component
//But instead of using @Component here we can use @Service as this is much better approach and @Component already inside the @Service.
@Service
//@AllArgsConstructor it replaces constructor function as it auto do for us e.g I have commented the below public function CustomerDbService.
@AllArgsConstructor
//@Slf4j it replaces Logger LOGGER object creation & directly use with log instead of LOGGER e.g I have commented the below private final static Logger LOGGER Object
@Slf4j
public class CustomerDbService {
//    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerDbService.class);

    private final CustomerRepository customerRepository;

//    @Autowired
//    public CustomerDbService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }
    /*
    // Implement one interface with multiple repository & we need to provide a Qualifier like a identifier for which repository we need to inject.
    public CustomerService(@Qualifier("fake") CustomerInterface customerInterface) {
        this.customerInterface = customerInterface;
    }
    */
    List <Customer> getCustomers() {
        log.info("getCustomers was called");
        return customerRepository.findAll();
    }

    Customer getCustomer(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    "customer with id " + id + " not found");
                            log.error("error in getting customer {}", id, notFoundException);
                            return notFoundException;
                        });
    }

}
