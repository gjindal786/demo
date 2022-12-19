package com.example.demo.customer;
//This is a Normal Object Class.

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
//@ToString it replaces toString function as it auto do for us.
@ToString
//@AllArgsConstructor it replaces constructor function as it auto do for us.
@AllArgsConstructor
//@NoArgsConstructor it replaces empty constructor function as it auto do for us.
@NoArgsConstructor
//@EqualsAndHashCode perform equal check to compare objects.
@EqualsAndHashCode
public class Customer {
    @Id
    private Long id;

    //@NotBlank Means its required from api side.
    @NotBlank(message = "name must be not empty")
    private String name;

    //@JsonProperty here we have set "access" to password field like we can write in this column
    // but can not get in json response as we have put it under Json ignore in below getter method (getPassword)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@NotBlank Means its required from api side.
    @NotBlank(message = "password must be not empty")
    private String password;

    //@Email Means it is checking for valid email address for api.
    // We can give email with our regular expression like @Email("your expression")
    @NotBlank(message = "email must be not empty")
    @Email(message = "email must be valid")
    private String email;


    public String getName() {
        return name;
    }

    //@JsonProperty : It will rename the key as customer_id (you can give any name for key) rather than id.
    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }

    //@JsonIgnore : It will ignore this to be return in api
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    //customerId : As custom return in output of api
    public Long getCustomerId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
