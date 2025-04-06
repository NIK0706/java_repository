package it.nicolas_marciello._4itti.esercizi.aprile_2025.apr7;

public class Obj {
	protected String name;
	protected int value; // Nel BT è l'attributo che scandisce la ricerca e l'inserimento.

	public Obj(String name, int value){
		this.name = name;
		this.value = value;
	}

	public void printObj(){
		System.out.println("Name: " + name + "\nValue: " + value);
	}

	public String getName(){
		return name;
	}

	public int getValue(){
		return value;
	}
}
