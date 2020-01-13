/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodordersale;

import MyBeans.DataBase;
import MyBeans.Product;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

/**
 *
 * @author anton
 */
public class ProductOrderSale {

     public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Accessing the database dbSales to insert one sale of a product----");
        DataBase db=new DataBase();
        ObjectContainer oc=DataBase.getOC();
        
        int idProduct=1;//DDR memory, stock 10, minimunStock 3
        int amount=8;//if we sell 8, let's see if an order is generated
        //public Sale(int saleNumber, int productId, Date date, int amount, String comment) {
        Product p=new Product(null,idProduct,0,0,0);
        //voy por aquí
     	Product nextProd=null;	
        ObjectSet<Product> result = oc.queryByExample(p);//obtiene el producto con la idProduct
       
        //comprobamos que encuentra el producto con id=1, que es la DDR memory
	System.out.println(result.size());
	    while(result.hasNext()) {
                nextProd=result.next();
	        System.out.println(nextProd.getDescription()+"-"+nextProd.getStock());
	    }

        //creamos una venta del producto. Si el stock decrece, debe generarse un pedido
       
        db.closeDB();
    }
    
}
