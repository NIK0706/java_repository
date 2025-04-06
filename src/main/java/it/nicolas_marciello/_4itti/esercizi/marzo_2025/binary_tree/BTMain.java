package it.nicolas_marciello._4itti.esercizi.marzo_2025.binary_tree;
import it.nicolas_marciello._4itti.esercizi.marzo_2025.Obj;

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

		System.out.println("---");

		tree1.visitaSimmetrica(tree1.root);

		System.out.println(tree1.findNode(tree1.root, obj9));
	}
}
