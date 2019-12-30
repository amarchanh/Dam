package MyPackEnterprise;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateEnterprise {

	// This SessionFactory will be created once and used for all the connections
	private static SessionFactory sf;
	
	// Constructor
	HibernateEnterprise() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	// Adds product to the table Products
	public void addProduct(int id, String name, double price) {
		Session session = sf.openSession();
		Transaction tx = null;
		
		// create the product with the parameters in the method
		Products p = new Products();
		p.setName(name);
		p.setPrice(price);
		p.setProductId(id);
		
		// keep it in the database --> session.save(p)
		
		try {
			System.out.printf("Inserting a row in the database: %s, %s, %s \n",id, name, price);
			
			tx = session.beginTransaction();
			// INSERTS p into the table PRODUCTS
			session.save(p);
			// If session.save doesn't produces an exception, we "commit" the transaction
			tx.commit();
			
		}
		catch (Exception e) {
			// If there is any exception, we "rollback" and close safely
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	//Find a product from the table Products by his ID
	public Products findProductById(int id) {
		Session session = sf.openSession();
		Transaction tx = null;
		Products p =  new Products();
		
		try {
			System.out.println("loading the object from the database");
			tx=session.beginTransaction();
			p=(Products)session.load(Products.class, id);
			tx.commit();
			System.out.println("The product with id="+id+" is:"+p.getName());
		}
		// ObjectNotFoundException throws a compilation error. So, if we cannot find the product, we throw a RuntimeException
		catch(RuntimeException e) {
			if(tx!=null) {
				System.out.println("Product not found with id: "+id);
			}
		}
		catch(Exception e) {
			if(tx!=null){
				System.out.println(e);
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
		
		// Returns product, not used in this examples
		return p;
	}

	// Deletes a product by his ID
	public void deleteProductById(int id) {
		Products p = new Products();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx=session.beginTransaction();
			try{
				p = (Products) session.load(Products.class, id);
				session.delete(p);
				tx.commit();
				System.out.printf("Object deleted from the Database: %s, %s, %s \n",
						p.getProductId(), p.getName(), p.getPrice());
			}
			// ObjectNotFoundException throws a compilation error
			catch(RuntimeException e) {
				System.out.println("Product not found with id: " +id+". Deleting cannot be completed.");
			}
		}
		catch (Exception e) {
			if(tx!= null) {
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
	}
	
	// Updates product by his id. Shows the original product and the final product
	public void updateProductById(int id, String newName, double newPrice){
		Products p = new Products();
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			System.out.println("Updating value.");
			System.out.println("Before updating, we need to load the object:");
			
			p = (Products) session.load(Products.class, id);
			
			System.out.println("Initial product -- > id: "+p.getProductId()+ ", name: " +p.getName() + ", price: "+p.getPrice() );
			
			p.setPrice(newPrice);
			p.setName(newName);
			
			session.update(p);
			
			tx.commit();
			System.out.println("Product updated.id: "+p.getProductId()+ ", name: " +p.getName() + ", price: "+p.getPrice() );
		}
		catch(RuntimeException e) {
			System.out.println("Product not found with id: " +id+". Updating cannot be completed.");
		}
		catch (Exception e) {
			System.out.println(e);
			if (tx!=null){
				tx.rollback();
			}
		}
		finally {
			session.close();
		}
	}
	
	// Shows all products in the table
	public void showProducts() {
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List allProducts = session.createQuery("FROM Products").list();
			Iterator iterator = allProducts.iterator();
			
			// Iterates over the list of products that we get from the table and print them
			while (iterator.hasNext()) {
				Products p = (Products) iterator.next();
				System.out.print("Id: " +p.getProductId());
				System.out.print(", Name: " +p.getName());
				System.out.println(", Price: " +p.getPrice());
			}
			tx.commit();
		}
		catch (HibernateException e) {
			if(tx!=null) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		finally {
			session.close();
		}
	}
	
	// Show all products that have the "name" variable in his name
	public void showByName(String name) {
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List allProducts = session.createQuery("FROM Products where name like '%"+name+"%'").list();
			Iterator iterator = allProducts.iterator();
			
			while (iterator.hasNext()) {
				Products p = (Products) iterator.next();
				System.out.print("Id: " +p.getProductId());
				System.out.print(", Name: " +p.getName());
				System.out.println(", Price: " +p.getPrice());
			}
			tx.commit();
		}
		catch (HibernateException e) {
			
		}
		finally {
			session.close();
		}
	}
	
	// Show all products ordered by his price
	public void productsOrderedByPrice() {
		Session session = sf.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List allProducts = session.createQuery("FROM Products order by price desc").list();
			Iterator iterator = allProducts.iterator();
			
			while (iterator.hasNext()) {
				Products p = (Products) iterator.next();
				System.out.print("Id: " +p.getProductId());
				System.out.print(", Name: " +p.getName());
				System.out.println(", Price: " +p.getPrice());
			}
			tx.commit();
		}
		catch (HibernateException e) {
			
		}
		finally {
			session.close();
		}
	}
	
	// Shows al prices (and entire product) with the String "name" in his name
	public void priceOf() {
		Session session = sf.openSession();
		Transaction tx = null;
		String name;
		
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Insert the name of the product you want to show the price:");
			name = sc.nextLine();
			tx = session.beginTransaction();
			List allProducts = session.createQuery("FROM Products where name like '%"+name+"%'").list();
			Iterator iterator = allProducts.iterator();
			
			System.out.println("There is " +allProducts.size() +" products with that name.");
			
			while (iterator.hasNext()) {
				Products p = (Products) iterator.next();
				System.out.print("Id: " +p.getProductId());
				System.out.print(", Name: " +p.getName());
				System.out.println(", Price: " +p.getPrice());
			}
			tx.commit();
		}
		catch (HibernateException e) {
			
		}
		finally {
			session.close();
		}
	}
	
	// Find product by his id, using unique result
	public void findProduct(int id) { 
		Session session = sf.openSession();
		Transaction tx = null;
		Products p = new Products();
		
		try {
			tx = session.beginTransaction();
			p = (Products) session.createQuery("FROM Products where id = " +id).uniqueResult();
			
			System.out.print("Id: " +p.getProductId());
			System.out.print(", Name: " +p.getName());
			System.out.println(", Price: " +p.getPrice());
			
			tx.commit();
		}
		catch (HibernateException e) {
			
		}
		finally {
			session.close();
		}
	}
}
