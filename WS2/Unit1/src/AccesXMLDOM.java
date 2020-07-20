import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AccesXMLDOM {

	Document doc;
	
	public int openXMLtoDom (File f) {
		try {
			System.out.println("Opening XML file and creating DOM ...");
			
			//new object DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			// ignore comments and white spaces
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			
			// DocumentBuilder will have the DOM loaded when we parse the XML file
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc=builder.parse(f);
			
			// now doc point to the DOM tree an we can traverse it.
			System.out.println("DOM created succesfully.");
			return 0; // if the method works
		}
		catch (Exception e) {
			System.out.println(e);
			return -1; // If the method fails
		}
	}
	
	public void traverseDOMandShow() {
		String[] data = new String[3];
		Node node = null;
		Node root = doc.getFirstChild();
		NodeList nodeList = root.getChildNodes();
		// Traverse or loop through DOM tree
		for (int i = 0; i<nodeList.getLength(); i++) {
			node = nodeList.item(i); // Node has the childs of root
			// for nodes <Book>
			if ( node.getNodeType() == Node.ELEMENT_NODE ) {
				Node ntemp = null;
				int contador = 1;
				
				// Get the attribute "published"
				data[0] = node.getAttributes().item(0).getNodeValue();
				
				// Get the values of the sub-child <Title> <Author>
				NodeList  nl2 = node.getChildNodes(); // get the list of sub-child
				
				for ( int j = 0; j<nl2.getLength(); j++ ) {
					ntemp = nl2.item(j);
					// To get the text of tittle and author, access the child node and getNodeValue()
					if(ntemp.getNodeType() == Node.ELEMENT_NODE ) {
						data[contador] = ntemp.getChildNodes().item(0).getNodeValue();
						contador++;
					}
				}
				
				// The String array data[] has now the values we needed 
				
				System.out.println(data[0] + " -- " + data[2] + " -- " + data[1]);
				
			}
		}
		
	}
	
}
