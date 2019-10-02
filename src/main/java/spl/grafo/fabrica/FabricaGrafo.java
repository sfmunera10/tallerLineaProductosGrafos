package spl.grafo.fabrica;

import java.io.FileReader;
import java.util.Properties;
import spl.grafo.interfaces.IGrafo;

public class FabricaGrafo {
	
	public static String getOpcionConfigurada() {		

		// lee el archivo de configuraci�n
		Properties opciones = new Properties();
		
		try {
			opciones.load(new FileReader("config-instanciacion.properties"));			
		} catch (Exception e) {
			// ignora cualquier error leyendo el archivo
		}
				
		// obtiene el valor. por defecto use "ejemplo.sha256"
		return opciones.getProperty("gd", "spl.grafo.fabrica.GrafoDirigido");

	}
	
	public static IGrafo getGrafo() {
				
		// obtiene la opci�n configurada
		String opcion = FabricaGrafo.getOpcionConfigurada();
		System.out.println("Opci�n configurada para el grafo: " + opcion.toString());
		
		// crea el objeto de acuerdo a la opci�n configurada
		IGrafo grafo = null;
		try {
			grafo = (IGrafo) Class.forName(opcion).newInstance();

		} catch (Exception e) {
			// No se pudo crear el algoritmo
			throw new RuntimeException("No se pudo crear el algoritmo de hash");
		}
		return grafo;
	}

}
