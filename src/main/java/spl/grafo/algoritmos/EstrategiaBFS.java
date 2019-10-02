package spl.grafo.algoritmos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import spl.grafo.fabrica.Nodo;
import spl.grafo.interfaces.IEstrategiaBusqueda;

public class EstrategiaBFS implements IEstrategiaBusqueda{
	
	public Nodo buscarNodo(String nombre, List<Nodo> nodos) 
	{
		for (Nodo nodo: nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}
	
	@Override
	public List<Nodo> buscarRuta(String origen, String destino, List<Nodo> nodos) {
		Nodo nodoOrigen = buscarNodo(origen,nodos);
		Nodo nodoDestino = buscarNodo(destino,nodos);
		List<Nodo> nodosRuta = new ArrayList<>();
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		if (buscarRutaBFS(nodosRuta, nodoOrigen, nodoDestino)) {
			return nodosRuta;
		} else {
			return null;
		}
	}

	@Override
	public boolean existeRuta(String origen, String destino, List<Nodo> nodos) {
		if (buscarRuta(origen, destino, nodos) != null) {
			return true;
		}
		return false;
	}
	
	private boolean buscarRutaBFS(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {
		
		// origen y destino son el mismo ?
		if(nodoOrigen.getNombre().equals(nodoDestino.getNombre())){
			System.err.println("Nodo destino encontrado en el mismo nodo origen");
		    nodosRuta.add(nodoOrigen);
            return true;
        }
		
		// si no son el mismo, revise las rutas usando una cola
        Queue<Nodo> queue = new LinkedList<>();
		ArrayList<Nodo> nodosVisitados = new ArrayList<>();
        
        queue.add(nodoOrigen);
        nodosVisitados.add(nodoOrigen);

        while(!queue.isEmpty()){
        	
            Nodo actual = queue.remove();
            if(actual.equals(nodoDestino)) {
            	nodosRuta.add(actual);
                return true;
            }
            else{
                if(actual.getNodosAdyacentes().isEmpty())
                    return false;
                else {
                	for (Nodo nodo: actual.getNodosAdyacentes()) {
                		if (!nodosVisitados.contains(nodo))
                			queue.add(nodo);
                	}
                }
                    
            }
            if (!nodosRuta.contains(actual))
            	nodosRuta.add(actual);
        }

        return false;        
	}	
}