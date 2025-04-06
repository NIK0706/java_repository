package it.nicolas_marciello._4itti.esercizi.febbraio_2025.base;

public class Node {
	// Final perchè in questo caso non cambiaremo mai l'oggetto a cui è collegato il Nodo.
	// Andremo, eventualmente, a cambiare solo il contenuto dell'oggetto stesso, ma non il contenuto del Nodo.
	private final Obj data;
	private Node link;

	public Node(Obj data){
		this.data = data;
		link = null;
	}

	public Obj getData(){
		return data;
	}

	public Node getLink(){
		return link;
	}

	public void setLink(Node link){
		this.link = link;
	}
}
