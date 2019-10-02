package spl.grafo.interfaces;

import java.util.List;

import spl.grafo.fabrica.Nodo;

public interface IGrafo {
	public List<Nodo> getNodos();
	public void agregarNodo(String nombre);
	public void agregarArco(String origen, String destino, int peso) throws Exception;
	public void setEstrategiaBusqueda(IEstrategiaBusqueda strategy);
	public List<Nodo> buscarRuta(String origen, String destino, List<Nodo> nodos);
}