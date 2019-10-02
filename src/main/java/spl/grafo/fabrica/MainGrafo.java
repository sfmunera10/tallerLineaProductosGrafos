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
			
			g.agregarArco("A", "B", 1);
			g.agregarArco("B", "C", 1);
			g.agregarArco("A", "C", 2);

			//Aquí se puede cambiar entre EstrategiaBFS o EstrategiaDFS
			g.setEstrategiaBusqueda(new EstrategiaBFS());
			
			List<Nodo> camino = g.buscarRuta("A", "C", g.getNodos());
			
			if (camino == null) {
				System.out.println("Camino A -> C no encontrado");
			} else {
				System.out.println("Camino A -> C encontrado");
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
