/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyBeans;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author anton
 */
public class Product implements Serializable {
    
public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    private String description;
    private int idProduct;
    private int stock;
    private int minimunStock;
    private double pvp;
    private PropertyChangeSupport propertySupport;
   
    public Product(String description,int idProduct,  int stock, int minimunStock, double pvp) {
        propertySupport=new PropertyChangeSupport(this);
        this.description = description;
        this.idProduct = idProduct;
        this.stock = stock;
        this.minimunStock = minimunStock;
        this.pvp = pvp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        int oldStock=this.stock;//save the current value
        this.stock = stock;
        if(this.stock<getMinimunStock()){//we need to make an order (order=pedido)
            propertySupport.firePropertyChange("stock ", oldStock, this.stock);
            stock=oldStock;
        }
    }

    public int getMinimunStock() {
        return minimunStock;
    }

    public void setMinimunStock(int minimunStock) {
        this.minimunStock = minimunStock;
    }

    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public PropertyChangeSupport getPropertySupport() {
        return propertySupport;
    }

    public void setPropertySupport(PropertyChangeSupport propertySupport) {
        this.propertySupport = propertySupport;
    }
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
}
