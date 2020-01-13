package DOM;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMParserBooksStore {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		File f = new File("src/resources/books.xml");
		
		Document doc = docBuilder.parse(f);
		
		// Get a list of all elements in the document
		// The wild card * matches all tags
		NodeList list = doc.getElementsByTagName("*");
		
		int bookCount = 0;
		
		for ( int i = 0; i < list.getLength(); i++ ) {
			// Get the elements book (attribute isbn), title, author
			Element element = (Element)list.item(i);
			String nodeName = element.getNodeName();
			
			if(nodeName.equals("Book")) {
				bookCount++;
				System.out.println("Book " + bookCount);
				String isbn = element.getAttribute("published");
				System.out.println("\tPublished:\t" +isbn);
				
			}
			else if (nodeName.equals("Title")) {
				System.out.println("\tTitle:\t" + element.getChildNodes().item(0).getNodeValue());
			}
			else if(nodeName.equals("Author")) {
				System.out.println("\tAuthor:\t" + element.getChildNodes().item(0).getNodeValue());
			}
		}
	}

}
