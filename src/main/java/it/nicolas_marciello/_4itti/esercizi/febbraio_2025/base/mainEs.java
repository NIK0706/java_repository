package it.nicolas_marciello._4itti.esercizi.febbraio_2025.base;

public class mainEs {
	public static void main(String[] args) {
		// Oggetti generici:
		Obj obj1 = new Obj("First", 1), obj2 = new Obj("Second", 2);
		Obj obj3 = new Obj("Third", 3), obj4 = new Obj("Fourth", 4);
		Obj obj5 = new Obj("Fifth", 5), obj6 = new Obj("Sixth", 6);
		Obj obj7 = new Obj("Seventh", 7), obj8 = new Obj("Eighth", 8);

		// --- //

		System.out.println("------\nLista1:");

		// ---
		List lista1 = new List();

		// (1)
		lista1.addInHead(obj1);
		lista1.addInQueue(obj2);
		lista1.addInQueue(obj3);
		lista1.addInQueue(obj7);
		System.out.println("Prima:");
		lista1.printList();

		/* Lista prima:
		 * Obj:		name:		ID:		Operazione:
		 * obj1 --> First,		1		(1)
		 * obj2 --> Second,		2		(1)
		 * obj3 --> Third,		3		(1)
		 * obj7 --> Seventh,	7		(1)
		*/

		// Vogliamo aggiungere gli elementi obj4, obj5 e obj6 in ordine.

		// (2)
		lista1.addInIdOrder(obj4);
		lista1.addInIdOrder(obj5);
		lista1.addInIdOrder(obj6);
		System.out.println("Dopo:");
		lista1.printList();

		/* Lista dopo:
		 * Obj:		name:		ID:		Operazione:
		 * obj1 --> First,		1		(1)
		 * obj2 --> Second,		2		(1)
		 * obj3 --> Third,		3		(1)
		 * obj4 --> Fourth,		4		(2)
		 * obj5 --> Fifth,		5		(2)
		 * obj6 --> Sixth,		6		(2)
		 * obj7 --> Seventh,	7		(1)
		*/

		// --- //

		System.out.println("------\nLista2:");

		// ---
		List lista2 = new List();

		// (1)
		lista2.addInHead(obj1);
		lista2.addInIdOrder(obj7);
		System.out.println("Prima:");
		lista2.printList();

		/* Lista prima:
		 * Obj:		name:		ID:		Operazione:
		 * obj1 -->	First,		1		(1)
		 * obj7 -->	Seventh,	7		(1)
		*/

		// (2)
		lista2.addInIdOrder(obj2);
		lista2.addInIdOrder(obj8);
		System.out.println("Dopo:");
		lista2.printList();

		/* Lista dopo:
		* Obj:		name:		ID:		Operazione:
		* obj1  -->	First,		1		(1)
		* obj2  -->	Second,		2		(2)
		* obj7  -->	Seventh,	7		(1)
		* obj8  -->	Eighth,		8		(2)
		*/

		// --- //

		System.out.println("------\nLista3:");

		// ---
		List lista3 = new List();

		// (1)
		lista3.addInHead(obj7);
		lista3.printList();

		// (2)
		lista3.addInIdOrder(obj2);
		lista3.printList();

		/* Lista prima:
		 * Obj:		name:		ID:		Operazione:
		 * obj2 -->	Second,		2		(2)
		 * obj7 -->	Seventh,	7		(1)
		*/

		// (3)
		lista3.addInIdOrder(obj3);
		lista3.addInIdOrder(obj8);
		lista3.printList();

		/* Lista dopo:
		 * Obj:		name:		ID:		Operazione:
		 * obj2 -->	Second,		2		(2)
		 * obj3 -->	Third,		3		(3)
		 * obj7 -->	Seventh,	7		(1)
		 * obj8 -->	Eighth,		8		(3)
		*/

		// --- //

		System.out.println("------\nLista4:");

		// ---
		List lista4 = new List();

		// (1)
		lista4.addInQueue(obj2);
		lista4.addInQueue(obj3);
		lista4.addInQueue(obj7);
		lista4.addInQueue(obj8);
		lista4.printList();

		/* Lista prima:
		 * Obj:		name:		ID:		Operazione:
		 * obj2 -->	Second,		2		(1)
		 * obj3 -->	Third,		3		(1)
		 * obj7 -->	Seventh,	7		(1)
		 * obj8 -->	Eighth,		8		(1)
		*/

		// (2)
		lista4.delFromOrder(obj7);
		lista4.printList();

		/* Lista dopo:
		 * Obj:		name:		ID:		Operazione:
		 * obj2 -->	Second,		2		(1)
		 * obj3 -->	Third,		3		(1)
		 *~obj7 -->	Seventh,	7		(1)~ --> Eliminato in operazione (2)
		 * obj8 -->	Eighth,		8		(1)
		*/

		// --- //

		System.out.println("------\nLista5:");

		// ---
		List lista5 = new List();

		// (1)
		lista5.addInHead(obj1);
		lista5.addInQueue(obj2);
		lista5.addInQueue(obj3);
		lista5.printList();

		/* Lista prima:
		 * Obj:		name:		ID:		Operazione:
		 * obj1 -->	First,		1		(1)
		 * obj2 -->	Second,		2		(1)
		 * obj3 -->	Third,		3		(1)
		*/

		// (2)
		lista5.delFromQueue();
		lista5.printList();

		// (3)
		lista5.delFromQueue();
		lista5.printList();

		// (4)
		lista5.delFromQueue();
		lista5.printList();

		// (5)
		lista5.delFromQueue();

		/* Lista dopo:
		 * Obj:		name:		ID:		Operazione:
		 *~obj1 -->	First,		1		(1)~ --> Eliminato in operazione (4)
		 *~obj2 -->	Second,		2		(1)~ --> Eliminato in operazione (3)
		 *~obj3 -->	Third,		3		(1)~ --> Eliminato in operazione (2)
		 *
		 * L'operazione (5) non cambia niente nella lista, essendo vuota. --> Output: "La lista è vuota."
		*/

		System.out.println("\n" + lista5.isEmpty()); // --> Output: true
	}
}
