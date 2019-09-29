package spl.grafo.interfaces;

public interface IGrafo {
	public void agregarNodo();
	public void agregarArco(String origen, String destino);
	public void agregarArco(String origen, String destino, int peso);
	public void getNombre();
	public void setNombre(String nombre);
}