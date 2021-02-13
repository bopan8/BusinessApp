package com.example.sapBusinessApp.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @NotNull
    @NotEmpty
    @Size(max = 50, message = "Too LOng Name of Product")
    @Column(name = "product_name")
    private String productName;

    @Size(max = 56)
    @Column(name = "product_country")
    private String productCountry;

    @NotNull
    @Column(name = "product_price")
    private double productPrice;

    @NotNull
    @Column(name = "product_amount")
    private int productAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_category")
    private ProductCategory productCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_company")
    private Companies companies;

    @Size(max = 30)
    @Column(name = "comments")
    private String comments;

    public Products() {
    }

    public Products(int productId,
                    String productName,
                    String productCountry,
                    double productPrice,
                    int productAmount,
                    ProductCategory productCategory,
                    Companies companies,
                    String comments) {
        this.productId = productId;
        this.productName = productName;
        this.productCountry = productCountry;
        this.productPrice = productPrice;
        this.productAmount = productAmount;
        this.productCategory = productCategory;
        this.companies =  companies;
        this.comments = comments;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCountry() {
        return productCountry;
    }

    public void setProductCountry(String productCountry) {
        this.productCountry = productCountry;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Companies getCompanies() {
        return companies;
    }

    public void setCompanies(Companies companies) {
        this.companies = companies;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
