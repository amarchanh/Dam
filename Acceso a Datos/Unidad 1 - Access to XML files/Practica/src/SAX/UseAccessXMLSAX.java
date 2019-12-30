package SAX;

import java.io.File;

public class UseAccessXMLSAX {

	public static void main(String[] args) throws Exception {
		File f = new File("src/resources/books.xml");
		AccessXMLSAX a = new AccessXMLSAX();
		
		a.openXMLwithSAX();
		a.traverseSAX(f);
		a.OpenTraverseSAXUsingXMLReader("src/resources/books.xml");
	}

}
