package DOM;
import java.io.File;

public class UseXMLDOM {

	public static void main(String[] args) {

		AccesXMLDOM a = new AccesXMLDOM();
		File f = new File("src/resources/books.xml");
		
		a.openXMLtoDom(f);
		
		// Show XML
		a.traverseDOMandShow();
		
		// Adding book
		a.addBookToDOM("The name of the wind", "Patrick Rothfuss", "2007");
		
		System.out.println("-----------------------------");
		
		// Show XML after adding new Book
		a.traverseDOMandShow();
		
	}

}
