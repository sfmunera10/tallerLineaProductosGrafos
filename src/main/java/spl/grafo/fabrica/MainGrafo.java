package spl.grafo.fabrica;

import java.util.List;

import spl.grafo.algoritmos.EstrategiaBFS;
import spl.grafo.algoritmos.EstrategiaDFS;
import spl.grafo.interfaces.IGrafo;

public class MainGrafo {
public static void main(String[] args) {
		try {
			IGrafo g;
			g = FabricaGrafo.getGrafo();
			g.agregarNodo("A");
			g.agregarNodo("B");
			g.agregarNodo("C");
			g.agregarNodo("D");
			
			g.agregarArco("A", "D", 5);
			

			//Aquí se puede cambiar entre EstrategiaBFS o EstrategiaDFS
			g.setEstrategiaBusqueda(new EstrategiaBFS());
			
			String nodoOrigen = "A";
			String nodoDestino = "D";
			
			List<Nodo> camino = g.buscarRuta(nodoOrigen, nodoDestino, g.getNodos());
			
			if (camino == null) {
				System.out.println("Camino "+nodoOrigen+ " -> "+ nodoDestino+ " no encontrado");
			} else {
				System.out.println("Camino "+nodoOrigen+ " -> "+ nodoDestino+ " encontrado");
				for (Nodo nodo: camino) {
					System.out.println(nodo.getNombre());
				}				
			}
			System.out.println();
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}	
	}
}
