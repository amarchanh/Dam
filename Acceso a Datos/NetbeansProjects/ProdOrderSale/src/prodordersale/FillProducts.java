/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodordersale;
import MyBeans.DataBase;
import MyBeans.Product;
public class FillProducts {

    public static void main(String[] args) {
        DataBase db=new DataBase();
        Product p1=new Product("DDR memory",1,10,3,50);
        Product p2=new Product("monitor 15i",2,5,2,176);
        Product p3=new Product("ssd",3,20,5,65);
        Product p4=new Product("monitos 17i",4,6,2,200);
        
        //store the products
        db.insertProduct(p1);
        db.insertProduct(p2);
        db.insertProduct(p3);
        db.insertProduct(p4);
        
        //see the products
        
        
        db.closeDB();
        
    }
  
}

