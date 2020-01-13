/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usejavaapplication1;

import MyBeans.Order;
import MyBeans.Product;

/**
 *
 * @author anton
 */
public class UseJavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Product product = new Product("DDR memory",1,10,13,16);
       Order order = new Order();
       order.setProduct(product);
       
       product.addPropertyChangeListener(order);
       
       product.setStock(2);
    }
    
}
