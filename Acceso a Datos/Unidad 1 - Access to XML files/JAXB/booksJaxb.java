import javax.xml.bind.Marshaller;

import myBooks.*;
import java.io.*;
import java.util.List;

public class BooksJaxb {
	//FUNCIONA GUAY
	public static void openXMLwithJAXBandShow(File f) {
		//UNMARSHALLING
		try{
			//open the context
			JAXBContext contexto=JAXBContext.newInstance(Books.class);
			//open the unmarshaller
			Unmarshaller u=contexto.createUnmarshaller();
			//allBooks has all the info from the file
			Books allBooks= (Books)u.unmarshal(f);
			String result="";//in result, we will concant the information from the XML
			List <Book> lBooks=allBooks.getBook();//Create a list of Books with the method getBook()
			System.out.println("Number of books:"+ lBooks.size());
			for(int i=0;i<lBooks.size();i++){
				result=result+"\n Published in: "+lBooks.get(i).getPublished();
				result=result+"\n The Title is: "+lBooks.get(i).getTitle();
				result=result+"\n The author is: "+lBooks.get(i).getAuthor()+"\n-------------";
			}
			System.out.println(result);
			
			//MARSHALLING
			Marshaller m=contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(allBooks, System.out);//si en vez de pone System.out pongo nombre de archivo, lo graba en un archivo
			//ADDING A BOOK
			//PEDIR POR PANTALLA
			//CREAMOS EL OBJETO Books.Book
			Book book1=new Book() ;
			book1.setAuthor("JKRowling");
			book1.setTitle("Harry Potter");
			book1.setPublished("1998");
			//add it to the list of books unmarshalled before
			lBooks.add(book1);
			//now create a new file marshalling lBooks
			m.marshal(allBooks, new FileOutputStream("BooksAddedJAXB.xml"));
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	public static void main(String[] args) {
		File f=new File("Books.xml");
		openXMLwithJAXBandShow(f);
		
	}
}