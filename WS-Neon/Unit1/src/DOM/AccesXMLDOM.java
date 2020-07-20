package DOM;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
	
	
	// Adds book to the DOM
	public int addBookToDOM(String title, String author, String year) {
		try {
			// Create the nodes => append them to the father, from the leaf to the root
			System.out.println("Adding book to the DOM tree: "+title+"; "+author+"; "+year);
			
			// CREATE TITLE with the text in the middle
			//Creates labels <Title>..</Title>
			Node ntitle = doc.createElement("Title");
			//Creates the text node for the Title
			Node ntitle_text = doc.createTextNode(title);
			// Appends the title to the labels => <Title>title</Title>
			ntitle.appendChild(ntitle_text);
			
			// CREATE AUTHOR
			Node nauthor = doc.createElement("Author");
			
			Node nauthor_text = doc.createTextNode(author);
			
			nauthor.appendChild(nauthor_text);
			
			
			// CREATE BOOK, WITH THE ATTRIBUTE, TITLE AND AUTOR
			Node nbook = doc.createElement("Book");
			((Element) nbook).setAttribute("published",year);
			nbook.appendChild(ntitle);
			nbook.appendChild(nauthor);
			
			// APPEND BOOK TO THE ROOT
			Node raiz = doc.getFirstChild(); // doc.getChildNodes().item(0)
			raiz.appendChild(nbook);
			System.out.println("Book added.");
			return 0;
			
			
		}
		catch ( Exception e ) {
			System.out.println(e);
			return -1;
		}
	}
	
	
	// Deleting a NODE
	public int deleteNode(String tit) {
		System.out.println("Looking for the book "+tit+" to delete it.");
		
		try {
			// Node root = doc.getFirstChild();
			Node root = doc.getDocumentElement();
			NodeList nl1 = doc.getElementsByTagName("Title");
			Node n1;
			
			for (int i=0; i<nl1.getLength(); i++) {
				n1 = nl1.item(i);
				
				if ( n1.getNodeType() == Node.ELEMENT_NODE  ) {
					if( n1.getChildNodes().item(0).getNodeValue().equals(tit)) {
						System.out.println("Deleting the node <Book> with title " +tit);
						
						n1.getParentNode().getParentNode().removeChild(n1.getParentNode());
					}
				}
				
			}
			
			System.out.println("Node deleted.");
			// Save the new DOM tree in a new file (to keep your original file)
			//saveDOMasFile("DeletedBooks.xml")
			
			return 0;
		}
		catch (Exception e ) {
			System.out.println(e);
			return -1;
		}
		
	}
	
	public int saveDOMasFile(String fileName) {
		try {
			File fxml = new File(fileName);
//			OutputFormat format = new OutputFormat(doc);
//			format.setIndenting(true);
			
//			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(fxml),format);
//			serializer.serialize(doc);
			
			System.out.println(fileName + " file XML created from DOM successfully");
			
			return 0;
		}
		catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	
}
