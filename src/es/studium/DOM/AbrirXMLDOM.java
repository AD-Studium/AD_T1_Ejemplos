package es.studium.DOM;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class AbrirXMLDOM {
public static int abrirXMLDOM(File fichero) {
	/* Representa al �rbol DOM */
	Document doc = null;
	try {
		/* Se crea un objeto DocumentBuilderFactory */
		DocumentBuilderFactory factory = 
DocumentBuilderFactory.newInstance();
		/* Indica que el modelo DOM no debe contemplar los comentarios que tenga el XML */
		factory.setIgnoringComments(true);
		/* Ignorar los espacios en blanco */
		factory.setIgnoringElementContentWhitespace(true);
		/* Se crea un objeto DocumentBuilder para cargar en �l la estructura de �rbol DOM a partir del XML seleccionado */ 
		DocumentBuilder builder = factory.newDocumentBuilder();
		/* Interpreta el XML y genera el DOM equivalente */
		doc = builder.parse(fichero);
		/* Ahora doc apunta al �rbol DOM, listo para recorrer */
		return 0;
	} catch (Exception e) {
		e.printStackTrace();
		return -1;
	}
}
}

