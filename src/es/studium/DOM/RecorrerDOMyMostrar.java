package es.studium.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class RecorrerDOMyMostrar {
	ProcesarLibro procesarLibro = new ProcesarLibro();
	public static void recorrerDOMyMostrar(Document doc) {
		String datos_nodo[] = null;
		String salida = "";
		Node node;
		/* Obtiene el primer nodo del DOM (primer hijo) */
		Node raiz = doc.getFirstChild();
		/* Obtiene una lista de nodos con todos los nodos hijo */
		NodeList nodelist = raiz.getChildNodes();
		/* Procesa los nodos hijo */
		for (int i = 0; i < nodelist.getLength(); i++) {
			node = nodelist.item(i);
			/* Es un nodo Libro */
			if (node.getNodeType() == Node.ELEMENT_NODE) {
			/* Método que procesa el Nodo y extrae su información */
				datos_nodo = ProcesarLibro.procesarLibro(node);
				salida += "\nPublicado en: " + datos_nodo[0];
				salida += "\nEl autor es: " + datos_nodo[2];
				salida += "\nEl título es: " + datos_nodo[1];
				salida += "\n	";
			}
		}
		System.out.println(salida);
	}
}
