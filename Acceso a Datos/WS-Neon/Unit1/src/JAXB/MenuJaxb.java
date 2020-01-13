package JAXB;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import JAXB.BreakfastMenu.Food;

public class MenuJaxb {

	JAXBContext contexto;
	Unmarshaller u;
	BreakfastMenu menu;
	List<Food> lMenu;
	
	public void openXMLwithJAXBandShow(File f) {
		// UNMARSHALLING: From the XML file, we fill the object
		// menu and the list of menus
		
		try {
			// open the context
			contexto = JAXBContext.newInstance(BreakfastMenu.class);
			
			// open de unmarshaller
			u=contexto.createUnmarshaller();
			
			// menus has all the info from the file
			menu = (BreakfastMenu) u.unmarshal(f);
			
			// in result, we will concat the information from the XML
			String result = "";
			
			// Create a list of food wiht the method getFood
			lMenu = menu.getFood();
			
			
			System.out.println("Number of foods:" + lMenu.size());
			
			for (Food food : lMenu) {
				result = "";
				result = result + "\n Name of the food: " + food.getName();
				result = result + "\n Number of calories: " + food.getCalories();
				result = result + "\n Description: " + food.getDescription();
				result = result + "\n Price: " + food.getPrice();
				
				System.out.println(result);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addFood(String name, short calories, String description, Double price) {
		
		try {
			Food food1 = new Food();
			food1.setName(name);
			food1.setCalories(calories);
			food1.setDescription(description);
			food1.setPrice("$"+price );
			
			lMenu.add(food1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createXMLfromList(String fileName) {
		// MARSHALLING: Creating an XML file from a list of Books
		
		try {
			Marshaller m = contexto.createMarshaller();
			// To have indentations and lines
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			
			m.marshal(menu, System.out);
			
			m.marshal(menu, new FileOutputStream(fileName));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
