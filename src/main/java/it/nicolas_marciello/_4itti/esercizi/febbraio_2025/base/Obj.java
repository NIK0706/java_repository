package it.nicolas_marciello._4itti.esercizi.febbraio_2025.base;

public class Obj {
	// Campi di esempio:
	protected String name;
	protected int id; // Unico valore che indica una regola di inserimento specifico nella lista.

	public Obj(String name, int id){
		this.name = name;
		this.id = id;
	}

	public void printObj(){
		System.out.println("	Name: " + name + "\n	ID: " + id + "\n	---");
	}
}
