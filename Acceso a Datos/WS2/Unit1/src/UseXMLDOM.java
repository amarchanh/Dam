import java.io.File;

public class UseXMLDOM {

	public static void main(String[] args) {

		AccesXMLDOM a = new AccesXMLDOM();
		File f = new File("src/resources/books.xml");
		
		a.openXMLtoDom(f);
		
	}

}
