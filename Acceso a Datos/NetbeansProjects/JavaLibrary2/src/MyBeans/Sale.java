package MyBeans;

import java.beans.*;
import java.io.Serializable;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Sale implements Serializable, PropertyChangeListener {
    
   private int saleNumber;
   private int productId;
   private Date date;
   private int amount;
   private String comment;
    
    public Sale() {
       
    }

    public Sale(int saleNumber, int productId, Date date, int amount, String comment) {
        this.saleNumber = saleNumber;
        this.productId = productId;
        this.date = date;
        this.amount = amount;
        this.comment = comment;
    }

    public void propertyChange(PropertyChangeEvent evt){
        this.comment="Waiting order for lack of stock";
    }
    public int getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(int saleNumber) {
        this.saleNumber = saleNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
