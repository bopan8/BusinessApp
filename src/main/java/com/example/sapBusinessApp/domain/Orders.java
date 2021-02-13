package com.example.sapBusinessApp.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @NotNull
    @Column(name = "ordered_products")
    private int orderedProduct;

    @NotNull
    @Column(name = "ordering_amount")
    private int orderedAmount;

    @NotNull
    @Column(name = "customer")
    private int orderingCustomer;

    @NotNull
    @Column(name = "order_date")
    private Date orderDate;

    public Orders() {
    }

    public Orders(int order_id, int ordered_product, int ordered_amount, int ordering_customer,Date order_date) {
        this.orderId = order_id;
        this.orderedProduct = ordered_product;
        this.orderedAmount = ordered_amount;
        this.orderingCustomer = ordering_customer;
        this.orderDate = order_date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderedProduct() {
        return orderedProduct;
    }

    public void setOrderedProduct(int orderedProduct) {
        this.orderedProduct = orderedProduct;
    }

    public int getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(int orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public int getOrderingCustomer() {
        return orderingCustomer;
    }

    public void setOrderingCustomer(int orderingCustomer) {
        this.orderingCustomer = orderingCustomer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
