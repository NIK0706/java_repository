package it.nicolas_marciello._4itti.esercizi.febbraio_2025.consegna_in_classe;

public class Planet {
	protected String name;
	protected int diameter; // In km.

	public Planet(String name, int diameter){
		this.name = name;
		this.diameter = diameter;
	}

	public void printPlanetInfo(){
		System.out.println("	Name: " + name + "\n	diameter: " + diameter + "\n	---");
	}
}
