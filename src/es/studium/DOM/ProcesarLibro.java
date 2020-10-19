package es.studium.DOM;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProcesarLibro {
	protected static String[] procesarLibro(Node n) {
		String datos[] = new String[3];
		Node ntemp = null;
		int contador = 1;
	/* Obtiene el valor del primer atributo del nodo */
		datos[0] = n.getAttributes().item(0).getNodeValue();
	/* Obtiene los hijos del Libro (título y autor) */
		NodeList nodos = n.getChildNodes();
		for (int i = 0; i < nodos.getLength(); i++) {
			ntemp = nodos.item(i);
			if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
			/* IMPORTANTE: para obtener el texto con el título y autor se accede al contenido TEXT del nodo */
				datos[contador] = ntemp.getTextContent();
				contador++;
			}
		}
		return datos;
	}
}
