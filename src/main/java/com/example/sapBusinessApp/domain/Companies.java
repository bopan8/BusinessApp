package com.example.sapBusinessApp.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "companies")
public class Companies implements User{

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private final String role = "COMPANY";

    @NotNull
    @NotEmpty
    @Size(max = 200)
    @Column(name = "company_name")
    private String name;

    @Size(max = 56)
    @Column(name = "company_country")
    private String companyCountry;

    @Size(max = 20)
    @Column(name = "company_phone")
    private String companyPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_offer")
    private ProductCategory productCategory;

    @NotNull
    @NotEmpty
    @Column(name = "company_pass")
    private String password;


    @Email
    @Column(name = "company_mail")
    private String companyMail;


    public Companies() {
    }

    public Companies(int id,
                     String name,
                     String company_country,
                     String company_phone,
                     ProductCategory productCategory,
                     String password,
                     String company_mail)
    {
        this.id = id;
        this.name = name;
        this.companyCountry = company_country;
        this.companyPhone = company_phone;
        this.productCategory = productCategory;
        this.password = password;
        this.companyMail = company_mail;
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
        return role;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getCompanyMail() {
        return companyMail;
    }

    public void setCompanyMail(String companyMail) {
        this.companyMail = companyMail;
    }


}
