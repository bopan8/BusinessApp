package com.example.sapBusinessApp.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "administrator")
public class Administrator implements User{

    @Id
    @Column(name = "administrator_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private final String role = "ADMIN";

    @NotNull
    @NotEmpty
    @Size(max = 30, message = "Too Long Name")
    @Column(name = "administrator_name")
    private String name;

    @NotNull
    @NotEmpty
    @Column(name =  "administrator_pass")
    private String password;

    public Administrator() {
    }

    public Administrator(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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
        return this.role;
    }
}
