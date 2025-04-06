package it.nicolas_marciello._4itti.esercizi.febbraio_2025.consegna_in_classe;

public class mainEs {
	public static void main(String[] args) {
		Planet sun = new Planet("Sun", 1391000);
		Planet saturn = new Planet("Saturn", 116460);
		Planet uranus = new Planet("Uranus", 50720);
		Planet neptune = new Planet("Neptune", 49240);
		Planet earth = new Planet("Earth", 12742);
		Planet venus = new Planet("Venus", 12104);
		Planet mars = new Planet("Mars", 6779);
		Planet mercury = new Planet("Mercury", 4880);

		System.out.println("------\nLista1:");
		List lista1 = new List();

		lista1.addInHead(sun);
		lista1.addInQueue(mars);
		lista1.delFromQueue();
		lista1.addInQueue(mercury);
		lista1.addInDiameterOrder(mars);
		lista1.addInDiameterOrder(saturn);
		lista1.addInDiameterOrder(neptune);
		lista1.addInDiameterOrder(uranus);
		lista1.addInDiameterOrder(venus);
		lista1.addInDiameterOrder(earth);

		lista1.printList();
	}
}
