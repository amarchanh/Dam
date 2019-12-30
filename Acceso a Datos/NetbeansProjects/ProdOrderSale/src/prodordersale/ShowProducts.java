/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodordersale;
import MyBeans.DataBase;
import MyBeans.Order;
import MyBeans.Product;
import MyBeans.Sale;
import com.db4o.ObjectContainer;
import java.util.List;


public class ShowProducts {

    public static void main(String[] args) {
        System.out.println("Connecting to dbSales.db4o");
        DataBase db=new DataBase();
        ObjectContainer oc=DataBase.getOC();
        System.out.println("----------PRODUCTS LIST------------");
        List<Product> products = oc.query(Product.class);
        System.out.println(products.size());
		for (Product p : products) {
                    System.out.println(p.getIdProduct()+"-"+p.getDescription()+"STOCk:"+p.getStock()+"-"+p.getPvp());
		}
         System.out.println("----------SALES LIST------------");
        List<Sale> sales=oc.query(Sale.class);
        System.out.println(sales.size());
		for (Sale s : sales) {
                    System.out.println(s.getSaleNumber()+"-"+s.getProductId()+"-"+s.getDate()+"-"+s.getAmount());
		}
                
                 System.out.println("----------ORDERS LIST------------");
        List<Order> orders=oc.query(Order.class);
        System.out.println(orders.size());
		for (Order o : orders) {
                    System.out.println(o.getProduct().getDescription()+"-"+o.getOrderNumber()+"-"+o.getDate()+"-"+o.getAmount());
		}
        db.closeDB();
    }
    
}

