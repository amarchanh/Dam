import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class connectTEST {

	private Connection con;

	void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "");
			// if the connection fails, there is an exception here
			System.out.println("CONNECTED TO DATABASE " + "jdbc:mysql://localhost/test");

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	void closeConnection() {
		try {
			con.close();
			System.out.println("jdbc:mysql://localhost/test " + "closed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void insert() {
		Scanner sc = new Scanner(System.in);
		String nif, name;
		int age;

		try {
			System.out.println("Write the information of the new student for the database:");
			System.out.println("NIF?");
			nif = sc.nextLine();
			System.out.println("Name?");
			name = sc.nextLine();
			System.out.println("age?");
			age = Integer.parseInt(sc.nextLine());

			// Create a statement
			Statement st = con.createStatement();
			// Execute the insertion
			// st.executeUpdate("INSERT INTO students VALUES('4444','Diego',17)");
			st.executeUpdate("INSERT INTO students VALUES('" + nif + "','" + name + "'," + age + ")");
			// String sql=String.format("INSERT INTO students
			// VALUES('%s','%s',%d)",nif,name,age);
			// st.executeUpdate(sql);
			// close the statement
			st.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	void update() {
		String sql;
		String nif;
		int age;
		
		try {
			this.showData();
			System.out.println("Which student do you want to update?");
			
			System.out.println("Write NIF:");
			
			Scanner sc = new Scanner(System.in);
			
			nif = sc.nextLine();
			
			System.out.println("New age for the student:");
			age = Integer.parseInt(sc.nextLine());
			
			System.out.println("Updating...");
			Statement st = con.createStatement();
			
			// Execute the statement
			sql = String.format("UPDATE students SET AGE=%d WHERE students.NIF='%s'", age,nif);
			st.executeUpdate(sql);
			
			System.out.println("Update.");
			
			st.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void delete() {
		this.showData();
		
		String nif;
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Write the NIF of the student you want to delete ");
			nif = sc.nextLine();
			
			String sql;
			Statement st = con.createStatement();
			sql = String.format("DELETE	from students WHERE students.NIF='%s'", nif);
			st.executeUpdate(sql);
			
			System.out.println("Student deleted.");
			
			st.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void showData() {
		try {
			System.out.println("DATABASE DATA");
			System.out.println("--------------");
			Statement st = con.createStatement();
			String sql="SELECT * FROM students";
			ResultSet resul=st.executeQuery(sql);
			//process the resulset with the methos resul.next()
			while(resul.next()){
				System.out.printf("%d,%s,%s %n",resul.getInt(1),resul.getString(2),resul.getString(3) );
			}
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
