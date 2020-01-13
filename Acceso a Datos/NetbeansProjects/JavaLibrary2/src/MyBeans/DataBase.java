package MyBeans;

import java.beans.*;
import java.io.Serializable;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;



/**
 *
 * @author ines
 */
public class DataBase implements Serializable {
    static ObjectContainer db;
	
	public DataBase(){
            //open the database
		db = Db4oEmbedded.openFile("dbSales.db4o");
	}
        
        public static ObjectContainer getOC(){
            return DataBase.db;
        }

	public static int getOrderNumber(){
            int maxOrder=0;
            List<Order> orders = db.query(Order.class);
		for (Order order : orders) {
		if (order.getOrderNumber()>maxOrder){
                    maxOrder=order.getOrderNumber();
                }// we have method toString defined in Pilot
		}
                return maxOrder+1;
        }
        public int getSaleNumber(){
            int maxSale=0;
            List<Sale> sales = db.query(Sale.class);
		for (Sale sale : sales) {
		if (sale.getSaleNumber()>maxSale){
                    maxSale=sale.getSaleNumber();
                }// we have method toString defined in Pilot
		}
                return maxSale+1;
        }
        
        
        //insert a product
        public void insertProduct(Product p){
            db.store(p);
            db.commit();
        }
        
        public static void insertOrder(Product p, int amount){
            Order order=new Order(getOrderNumber(),p,getCurrentDate(),amount);
            db.store(order);
            System.out.printf("ORDER GENERATED for the product: %s%n",p.getDescription());
            db.commit();
        }
        public void insertSale(Product p, int amount){
            int saleNumber=getSaleNumber();
            Sale sale=new Sale(saleNumber,p.getIdProduct(),getCurrentDate(), amount, " ");
            p.addPropertyChangeListener(sale);//adding a listener
            updateStock(p,amount);
            db.store(sale);
            System.out.printf("SALE %d INSERTED, Comments: %s %n", saleNumber, sale.getComment());
            db.commit();
        }
        
        private void updateStock(Product p, int amount){
            Order order=new Order();
            order.setProduct(p);
            order.setAmount(amount);
            p.addPropertyChangeListener(order);//adding a listener
            //calculate the stock
            int newStock=p.getStock()-amount;
            p.setStock(newStock);
            db.store(p);
            db.commit();
            
        }
        
	public static void closeDB() {
		db.close();
	}
        private static java.sql.Date getCurrentDate(){
            java.util.Date today=new java.util.Date();
            return new java.sql.Date(today.getTime());
        }
        

    
}
