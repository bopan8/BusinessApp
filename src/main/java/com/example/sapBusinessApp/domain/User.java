package com.example.sapBusinessApp.domain;

public interface User {

    public void setId(int id);

    public int getId();

    public String getName();

    public void setName(String name);

    public String getPassword();

    public void setPassword(String password);

    public String getRole();
}
