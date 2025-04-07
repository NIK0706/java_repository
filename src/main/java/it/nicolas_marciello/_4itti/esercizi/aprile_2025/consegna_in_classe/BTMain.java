package it.nicolas_marciello._4itti.esercizi.aprile_2025.consegna_in_classe;

public class BTMain{
	public static void main(String[] args) {
		BT tree1 = new BT();
		Obj obj1 = new Obj("Primo", 1), obj2 = new Obj("Secondo", 2);
		Obj obj3 = new Obj("Terzo", 3), obj4 = new Obj("Quarto", 4);
		Obj obj8 = new Obj("Ottavo", 8), obj9 = new Obj("Nono", 9);

		tree1.addNode(obj4);
		tree1.addNode(obj1);
		tree1.addNode(obj3);
		tree1.addNode(obj2);
		tree1.addNode(obj9);
		tree1.addNode(obj8);
		// tree1.addNode(obj4, obj1, obj3, obj2, obj9, obj8); // --> Passando dal metodo che accetta ppiù variabili (varargs).

		System.out.println("---\nVisista simmetrica:");
		tree1.visitaSimmetrica();

		System.out.println("---\nVisista anticipata:");
		tree1.visitaAnticipata();

		// Controllo della presenza dell'oggetto obj2 nell'albero.
		System.out.println("\nIl valore:");
		obj2.printObj();

		// Uso dell'operatore ternario per semplificare la lettura (cond ? true-case : false-case).
		System.out.println(tree1.findNode(tree1.root, obj2) ? "è presente nell'albero." : "non è presente nell'albero.");

		System.out.println(tree1.isEmpty() ? "L'albero è vuoto." : "L'albero non è vuoto.");
	}
}
