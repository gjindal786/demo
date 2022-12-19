package com.example.demo.customer;
// This class is to define your custom configuration before run application.
import com.example.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
//But instead of using @Component here we can use @Configuration as this is much better approach for Configuration class and @Component already inside the @Configuration.
public class CustomerConfiguration {
    //@Value to define where to pick value for useFakeCustomerRepository object. Here we are picking from application properties. We can use ENV variables as well.
    @Value("true")//@Value("${app.useFakeCustomerRepository:false}")
    private Boolean useFakeCustomerRepository;

    @Value("${info.company.name}")
    private String companyName;

    //@Autowired is auto-injection of Environment from the bean i.e which exist in the project.
    //Environment is java class used to access application.properties key pairs. We can get values for those.
    @Autowired
    private Environment environment;

    //@Bean it means part of execution of project, if we not use this below code never execute
    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {
            System.out.println("Command Line Runner Yes");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(infoApp);
        };
    }
    @Bean
    CustomerInterface customerInterface() {
        // useFakeCustomerRepository = true here but we have CustomerRepository as Primary so still CustomerRepository will run.
        System.out.println("useFakeCustomerRepository " + useFakeCustomerRepository);
        return useFakeCustomerRepository ? new CustomerFakeRepository() : new CustomerFakeRepository();
    }
}
