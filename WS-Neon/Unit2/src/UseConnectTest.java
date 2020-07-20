
public class UseConnectTest {

	public static void main(String[] args) {
		
		// Creating the connectTEST object..
		connectTEST ct = new connectTEST();
		
		// Connecting to Dataase..
		ct.connect();
		
		// Shows data stored in the Student table
		ct.showData();
		
		// Inserts data into the table
		ct.insert();
		
		// Upadates a specific student
		ct.update();
		
		// Deletes a student using his/her NIF 
		ct.delete();
		
		// Closes the connection to the Database
		ct.closeConnection();
		
	}

}
