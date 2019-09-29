package spl.grafo.interfaces;
import java.util.List;
import spl.grafo.fabrica.Nodo;

public interface IEstrategiaBusqueda {
	public List<Nodo> buscarRuta(String origen, String destino);
	public boolean existeRuta(String origen, String destino);
}