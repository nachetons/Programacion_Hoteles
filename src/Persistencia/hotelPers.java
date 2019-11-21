package Persistencia;

import java.util.ArrayList;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Dominio.Hotel;

public class hotelPers {

	public hotelPers(){
		
	}
	
	public static void escribir(ArrayList<Hotel> lista){
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			// Tendremos que definir el elemento raíz del documento en cuestión
			Element eRaiz = doc.createElement("hoteles");
			doc.appendChild(eRaiz);
			for (int i = 0; i < lista.size(); i++) {
				
				// Después, definimos el nodo que contendrá los elementos
				Element eHotel = doc.createElement("hotel");
				eRaiz.appendChild(eHotel);

				// Atributos principales. Que estos serán nombre y foto.
				Attr enombre = doc.createAttribute("nombre");
				enombre.appendChild(doc.createTextNode(lista.get(i).getNombre()));
				eHotel.setAttributeNode(enombre);

				Attr efoto = doc.createAttribute("foto");
				efoto.appendChild(doc.createTextNode(lista.get(i).getFoto()));
				eHotel.setAttributeNode(efoto);
				
				// Después definimos cada uno de los elementos y le asignamos un valor

				Element eTelefono = doc.createElement("tel");
				eTelefono.appendChild(doc.createTextNode(Integer.toString(lista.get(i).getTelefono())));
				eHotel.appendChild(eTelefono);

				Element eDireccion = doc.createElement("direccion");
				eDireccion.appendChild(doc.createTextNode(lista.get(i).getDireccion()));
				eHotel.appendChild(eDireccion);
				
				Element eCiudad = doc.createElement("ciudad");
				eCiudad.appendChild(doc.createTextNode(lista.get(i).getCiudad()));
				eHotel.appendChild(eCiudad);
				
				Element ePais = doc.createElement("pais");
				ePais.appendChild(doc.createTextNode(lista.get(i).getPais()));
				eHotel.appendChild(ePais);
				
				Element eNumestrellas = doc.createElement("numestrellas");
				eNumestrellas.appendChild(doc.createTextNode(Integer.toString(lista.get(i).getNumestrellas())));
				eHotel.appendChild(eNumestrellas);
				
				Element ehab_indi = doc.createElement("hab_indi");
				ehab_indi.appendChild(doc.createTextNode(Integer.toString(lista.get(i).getHab_indi())));
				eHotel.appendChild(ehab_indi);
				
				Element ehab_dobles = doc.createElement("hab_dobles");
				ehab_dobles.appendChild(doc.createTextNode(Integer.toString(lista.get(i).getHab_dobles())));
				eHotel.appendChild(ehab_dobles);
				
				Element ehab_triples = doc.createElement("hab_triples");
				ehab_triples.appendChild(doc.createTextNode(Integer.toString(lista.get(i).getHab_triples())));
				eHotel.appendChild(ehab_triples);
				
				Element esuites = doc.createElement("suites");
				esuites.appendChild(doc.createTextNode(Integer.toString(lista.get(i).getSuites())));
				eHotel.appendChild(esuites);
			}
			
			// Clases necesarias para finalizar la creación del archivo XML
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("Hoteles.xml"));
			
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Hotel>leer() {
		File file = new File("Hoteles.xml");
		ArrayList<Hotel> lista = new ArrayList<Hotel>();

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			// Con estos métodos, podemos usarlos combinados para normalizar el archivo XML
			doc.getDocumentElement().normalize();
			// almacenamos los nodos para luego mostrar la cantidad de ellos con el método getLength()
			NodeList nList = doc.getElementsByTagName("hotel");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String nombre = eElement.getAttribute("nombre");
					String foto = eElement.getAttribute("foto");
					int telefono = Integer.parseInt(eElement.getElementsByTagName("tel").item(0).getTextContent());
					String direccion = eElement.getElementsByTagName("direccion").item(0).getTextContent();
					String ciudad = eElement.getElementsByTagName("ciudad").item(0).getTextContent();
					String pais = eElement.getElementsByTagName("pais").item(0).getTextContent();
					int Numestrellas = Integer.parseInt(eElement.getElementsByTagName("numestrellas").item(0).getTextContent());
					int hab_indi = Integer.parseInt(eElement.getElementsByTagName("hab_indi").item(0).getTextContent());
					int hab_dobles = Integer.parseInt(eElement.getElementsByTagName("hab_dobles").item(0).getTextContent());
					int hab_triples = Integer.parseInt(eElement.getElementsByTagName("hab_triples").item(0).getTextContent());
					int suites = Integer.parseInt(eElement.getElementsByTagName("suites").item(0).getTextContent());
					Hotel h = new Hotel(nombre,foto,telefono,direccion,ciudad,pais,Numestrellas,hab_indi,hab_dobles,hab_triples,suites);
					lista.add(h);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
