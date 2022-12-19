package com.example.demo.customer;
// This is actual Repository class which get data from actual DB.
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

//@Component put this class in bean means ready to execute & it will create new instance of this class as singleton class.
//@Component
@Repository
//But instead of using @Component here we can use @Repository as this is much better approach and @Component already inside the @Repository.

//@Primary it this Repository on priority if we have multiple in our project.
@Primary
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
