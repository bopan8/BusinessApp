package com.example.sapBusinessApp.domain;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customers implements User{

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private final String role = "CUSTOMER";

    @NotNull
    @NotEmpty
    @Size(max = 30,message = "Too Long Name")
    @Column(name = "customer_name")
    private String name;

    @NotNull
    @NotEmpty
    @Size(min = 5,max = 254)
    @Email
    @Column(name = "customer_mail")
    private String customerMail;

    @NotNull
    @NotEmpty
    @Size(max = 10)
    @Column(name = "customer_pass")
    private String password;

    public Customers() {
    }

    public Customers(int id, String name, String customer_mail, String password) {
        this.id = id;
        this.name = name;
        this.customerMail = customer_mail;
        this.password =password;
    }

    @Override
    public void setId(int id) {
        this.id =id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setName(String name) {
        this.name =name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPassword(String password) {
        this.password =password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getRole() {
        return null;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }
}
