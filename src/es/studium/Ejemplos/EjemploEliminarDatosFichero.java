package es.studium.Ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class EjemploEliminarDatosFichero {
	public static  void EliminarRegistro(File FficheroAntiguo,String Satigualinea){        
		/*Obtengo un numero aleatorio*/
		Random numaleatorio= new Random(3816L); 
		/*Creo un nombre para el nuevo fichero apartir del
		 *numero aleatorio*/
		String SnombFichNuev=FficheroAntiguo.getParent()+"/auxiliar"+String.valueOf(Math.abs(numaleatorio.nextInt()))+".txt";
		/*Crea un objeto File para el fichero nuevo*/
		File FficheroNuevo=new File(SnombFichNuev);
		try {
			/*Si existe el fichero inical*/
			if(FficheroAntiguo.exists()){
				/*Abro un flujo de lectura*/
				BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
				String Slinea;
				/*Recorro el fichero de texto linea a linea*/
				while((Slinea=Flee.readLine())!=null) { 
					/*Si la linea obtenida es distinta al la buscada
					 *para eliminar*/
					if (!Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
						/*la escribo en el fichero nuevo*/ 
						EcribirFichero(FficheroNuevo,Slinea);
					}else{
						/*Si es igual simple mete no hago nada*/
					}             
				}
				/*Obtengo el nombre del fichero inicial*/
				String SnomAntiguo=FficheroAntiguo.getName();
				/*Borro el fichero inicial*/
				BorrarFichero(FficheroAntiguo);
				/*renombro el nuevo fichero con el nombre del fichero inicial*/
				FficheroNuevo.renameTo(FficheroAntiguo);
				/*Cierro el flujo de lectura*/
				Flee.close();
			}else{
				System.out.println("Fichero No Existe");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static  void BorrarFichero(File Ffichero){
		try {
			/*Si existe el fichero*/
			if(Ffichero.exists()){
				/*Borra el fichero*/  
				Ffichero.delete(); 
				System.out.println("Fichero Borrado con Exito");
			}
		} catch (Exception ex) {
			/*Captura un posible error y le imprime en pantalla*/ 
			System.out.println(ex.getMessage());
		}
	} 
	public static void EcribirFichero(File Ffichero,String SCadena){
		try {
			//Si no Existe el fichero lo crea
			if(!Ffichero.exists()){
				Ffichero.createNewFile();
			}
			/*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. 
			 *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)",
			 *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
			BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));
			/*Escribe en el fichero la cadena que recibe la función. 
			 *el string "\r\n" significa salto de linea*/
			Fescribe.write(SCadena + "\r\n");
			//Cierra el flujo de escritura
			Fescribe.close();
		} catch (Exception ex) {
			//Captura un posible error le imprime en pantalla 
			System.out.println(ex.getMessage());
		} 
	}

	public static  void LeerFichero(File Ffichero){
		try {
			/*Si existe el fichero*/
			if(Ffichero.exists()){
				/*Abre un flujo de lectura a el fichero*/
				BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
				String Slinea;
				System.out.println("**********Leyendo Fichero***********");
				/*Lee el fichero linea a linea hasta llegar a la ultima*/
				while((Slinea=Flee.readLine())!=null) {
					/*Imprime la linea leida*/    
					System.out.println(Slinea);              
				}
				System.out.println("*********Fin Leer Fichero**********");
				/*Cierra el flujo*/
				Flee.close();
			}else{
				System.out.println("Fichero No Existe");
			}
		} catch (Exception ex) {
			/*Captura un posible error y le imprime en pantalla*/ 
			System.out.println(ex.getMessage());
		}
	}
}
