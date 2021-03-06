package es.studium.DOM;

import java.io.File;
import java.io.FileOutputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AnnadirDOM {
	public static int annadirDOM (Document doc, String titulo, String autor, String anno) {
		try {
	/* Se crea un nodo Elemento con nombre 'titulo' */
			Node ntitulo = doc.createElement("Titulo");
	/* Se crea un nodo tipo texto con el t�tulo del libro */
			Node ntitulo_text = doc.createTextNode(titulo);
	/* Se a�ade el nodo de texto como hijo del elemento */
			Titulo ntitulo.appendChild(ntitulo_text);
	 
			/* Se hace lo mismo con autor */
			Node nautor = doc.createElement("Autor");
			Node nautor_text = doc.createTextNode(autor);
			nautor.appendChild(nautor_text);
	 
			/* Se crea un nodo de tipo elemento (<libro>) */
			Node nlibro = doc.createElement("Libro");
		/* Al nuevo nodo se le a�ade atributo publicado_en */
			((Element) nlibro).setAttribute("publicado_en", anno);
		/* Se a�ade a libro los nodos autor y titulo */
			nlibro.appendChild(ntitulo);
			nlibro.appendChild(nautor);
		/* Finalmente se obtiene el primer nodo del elemento y se le a�ade como hijo el nodo libro que ya tiene colgando todos sus hijos y atributos creados antes */
			Node raiz = doc.getFirstChild();
			raiz.appendChild(nlibro);
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public static int guardarDOMcomoFILE(Document doc) {
		try {
			/* Crea un fichero llamado salida.xml */
			File archivo_xml = new File("proyecto//salida.xml");
			/* Especifica el formato de salida */
			OutputFormat format = new OutputFormat(doc);
			/* Especifica que la salida est� indentada */
			format.setIndenting(true);
			/* Escribe el contenido en el FILE */
			XMLSerializer serializer = new XMLSerializer (new FileOutputStream(archivo_xml),format);
			serializer.serialize(doc);
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}
}
