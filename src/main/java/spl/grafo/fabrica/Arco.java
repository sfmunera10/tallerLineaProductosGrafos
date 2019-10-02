package spl.grafo.fabrica;

public class Arco {
	private Nodo origen;
	private Nodo destino;
	private int	peso;
	private boolean bidireccional;
	
	public Arco() {	}
	
	public Nodo getOrigen() {
		return origen;
	}
	public void setOrigen(Nodo origen) {
		this.origen = origen;
	}
	
	public Nodo getDestino() {
		return destino;
	}
	public void setDestino(Nodo destino) {
		this.destino = destino;
	}
	
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public boolean isBidireccional() {
		return bidireccional;
	}
	public void setBidireccional(boolean b) {
		this.bidireccional = b;
	}
}