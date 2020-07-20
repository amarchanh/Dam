package SAX;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class AccessXMLSAX {
	
	MySAXhandler sh;
	SAXParser parser;

	public int openXMLwithSAX() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			sh = new MySAXhandler();
			
			return 0;
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public void traverseSAX(File fXML) {
		try {
			parser.parse(fXML, sh);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error al parser con SAX");
		}
	}
	
	public void OpenTraverseSAXUsingXMLReader(String fileName) throws SAXException, IOException {
		System.out.println("***** Solution using XMLReader *****");
		XMLReader xmlr = XMLReaderFactory.createXMLReader();
		sh = new MySAXhandler();
		xmlr.setContentHandler(sh);
		
		InputSource fileXML = new InputSource(fileName);
		// Parse generating output with the events
		xmlr.parse(fileXML);
	}
}
