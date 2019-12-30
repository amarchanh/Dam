package JAXB;

import java.io.File;

public class UseMenuJAXB {

	public static void main(String[] args) {

		MenuJaxb m = new MenuJaxb();
		File f = new File ("src/resources/Menu.xml");
		
		m.openXMLwithJAXBandShow(f);
		
		m.addFood("Gazpacho", (short)100, "Gazpacho andaluz", 3.95);
		
		m.createXMLfromList("prueba");
		
	}

}
