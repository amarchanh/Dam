import java.sql.*;

public class JdbcMySQL {
	public static void main(String[] args) {
		//String url="jdbc:mariadb://localhost/test";
		String url="jdbc:mysql://localhost/test";
	try{
		//Class.forName("org.mariadb.jdbc.Driver");//it also works for MySQL in XAMPP. We need the driver for mariadb
		Class.forName("com.mysql.jdbc.Driver");
		//User="root", password="" in MySQL, cadena is the url of the database
		//Open the connection with the 3 arguments (url,user,password)
		Connection conexion=DriverManager.getConnection(url,"root","");
		//if the connection fails, there is an exception here
		System.out.println("CONNECTED TO DATABASE "+ url);
		//Create the SQL sentence to execute in the database
		Statement sentence=conexion.createStatement();
		String sql="SELECT * FROM students";
		//execute the sentence, obtaining a relset
		ResultSet resul=sentence.executeQuery(sql);
		//process the resulset with the methos resul.next()
		while(resul.next()){
			System.out.printf("%d,%s,%s %n",resul.getInt(1),resul.getString(2),resul.getString(3) );
		}
//result.getInt(nif), resul.getString(name), resul.getString(age) también funciona
		//close the objects
		resul.close();
		sentence.close();
		//close the connection
		conexion.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
