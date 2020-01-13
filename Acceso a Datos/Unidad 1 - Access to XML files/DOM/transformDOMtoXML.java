/* 
This method creates an XML file from a DOM tree, using the class Transformer. 
The Transformer class has the method transform(source, result) that creates a
result (a file in this example) from a source (a DOM tree in this example)

*/	

public void transformDOMtoXML(String fileName) {
		try {
			File f=new File(fileName);//create a new file with the argument
			Source src=new DOMSource(doc);
			Result rst=new StreamResult(new File(fileName));
			Transformer transformer=TransformerFactory.newInstance().newTransformer();
			transformer.transform(src, rst);
			System.out.println("File transformed from DOM successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}