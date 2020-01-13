package SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXhandler extends DefaultHandler{
	
	int lastElement;//used to know what type of tag is generating the event
	
	public MySAXhandler() {
		 lastElement=0;//
	}
	
	@Override
	public void startElement(String uri,String localName,String qName,Attributes atts) throws SAXException{
		if(qName.equals("Book")){
			System.out.println("Published in: "+atts.getValue(atts.getQName(0)));//extracts the first attribute
			lastElement=1;
		}else if(qName.equals("Title")){
			System.out.print("\n "+"The title es: ");//we will know the value of Title later, in event characters
			lastElement=2;
			
		}else if(qName.equals("Author")){
			System.out.print("\n "+"The author is: ");
			lastElement=3;
			
		}
	}
	@Override
	public void endElement(String uri, String localName,String qName) throws SAXException{
		if(qName.equals("Book")){
			System.out.println("\n-----------------------");
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException{
		String car=new String(ch,start,length);
		car=car.replaceAll("\t","");//cleans all tabs				
		System.out.print(car);	
	}

}
