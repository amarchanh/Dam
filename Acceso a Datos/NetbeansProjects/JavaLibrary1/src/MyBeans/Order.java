package MyBeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.*;
import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable,PropertyChangeListener {
    private int orderNumber;
    private Product product;
    private Date date;
    private int amount;
    
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        System.out.printf("Old stock: %d%n", evt.getOldValue());
        System.out.printf("Stock: %d%n", evt.getNewValue());
	System.out.printf("Create an order for product : %s%n", product.getDescription());		
    }
    public Order(){
    }

    public Order(int orderNumber, Product product, Date date, int amount) {
        this.orderNumber = orderNumber;
        this.product = product;
        this.date = date;
        this.amount = amount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    } 
    
}

