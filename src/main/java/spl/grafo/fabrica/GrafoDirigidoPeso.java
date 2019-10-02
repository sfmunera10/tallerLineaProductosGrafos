package spl.grafo.fabrica;

import java.util.ArrayList;
import java.util.List;
import spl.grafo.interfaces.IEstrategiaBusqueda;
import spl.grafo.interfaces.IGrafo;

public class GrafoDirigidoPeso implements IGrafo{
	List<Nodo> nodos = new ArrayList<>();
	List<Arco> arcos = new ArrayList<>();
	
	private IEstrategiaBusqueda estrategia;
	
	public GrafoDirigidoPeso() { }
	
	public Nodo buscarNodo(String nombre) 
	{
		for (Nodo nodo: nodos) {
			if (nodo.getNombre().equals(nombre)) {
				return nodo;
			}
		}
		return null;
	}

	@Override
	public void agregarNodo(String nombre) {
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);
	}

	@Override
	public void agregarArco(String origen, String destino, int peso) throws Exception{
		Nodo nodoOrigen = buscarNodo(origen);
		Nodo nodoDestino = buscarNodo(destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		addArco(nodoOrigen, nodoDestino, peso);
	}	
	
	public void addArco(Nodo nodoOrigen, Nodo nodoDestino, int peso)
	{
		Arco arco = new Arco();
		arco.setBidireccional(false);
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arco.setPeso(peso);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
	}
	
	@Override
	public void setEstrategiaBusqueda(IEstrategiaBusqueda strategy) {
		this.estrategia = strategy;
	}

	@Override
	public List<Nodo> buscarRuta(String origen, String destino, List<Nodo> nodos) {
		return estrategia.buscarRuta(origen, destino, nodos);
	}
	
	@Override
	public List<Nodo> getNodos(){
		return nodos;
	}
}