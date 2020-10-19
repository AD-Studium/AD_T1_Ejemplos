package es.studium.Ejemplos;

import java.io.FileReader;
import java.io.IOException;
 
public class Ejemplo01 {
	private static String FILE_NAME = "C:\\prueba.txt";
	private static char BUSCAR = 'a';
 
	public static void main(String[] args) {
		try {
			int contador = 0;
			FileReader input = new FileReader(FILE_NAME);
			int c = input.read();
			while (c != -1) {
			/* vemos si es el que buscamos */
			if ((char) c == BUSCAR) 
				contador++;
			/* leemos otro carácter */
			c = input.read();
			}
			/* cerramos el flujo */	
			input.close();
			System.out.println(contador);
		} catch (IOException ex) {
			System.out.println("Se ha producido un ERROR");
		}
	}
}