package it.nicolas_marciello._4itti.esercizi.febbraio_2025.base;

public class List {
	private Node head;
	private int nElements;

	public List(){
		head = null;
		nElements = 0;
	}

	public void addInHead(Obj data){
		Node newNode = new Node(data);
		newNode.setLink(head);
		head = newNode;
		nElements++;
	}

	public void addInQueue(Obj data){
		if(head != null){
			Node newNode = new Node(data);
			Node curNode = head;
			while(curNode.getLink() != null){
				curNode = curNode.getLink();
			}
			curNode.setLink(newNode);
			newNode.setLink(null);
			nElements++;
		}else{
			addInHead(data);
		}
	}

	// Aggiungi in ordine rispettando la cardinalità definita dall'ID (in modo crescente).
	public void addInIdOrder(Obj data){
		if(head != null){
			Node newNode = new Node(data);
			Node curNode = head;
			Node nextNode = curNode.getLink();

			// In questo caso necessitiamo di metterlo in testa, quindi devo usare la funzione addInHead().
			if(head.getData().id > data.id){
				addInHead(data);
			}else{
				// Ciclo che itera fino a quando non esce dalla lista, o quando il valore dell'ID del prossimo nodo presente nella lista è maggiore rispetto al nodo da aggiungere.
				while(nextNode != null && nextNode.getData().id < data.id){
					curNode = nextNode;
					nextNode = curNode.getLink();
				}
				curNode.setLink(newNode);
				newNode.setLink(nextNode);
				nElements++;
			}
		}else{
			// Qualora la lista fosse vuota usiamo la funzione addInHead().
			addInHead(data);
		}
	}

	public void delFromHead(){
		if(head != null){
			head = head.getLink();
			nElements--;
		}else{
			System.out.println("La lista è vuota.");
		}
	}

	public void delFromQueue(){
		if(nElements >= 2){
			Node curNode = head;
			// Ottiene "il prossimo del prossimo" e controlla se è null.
			while(curNode.getLink().getLink() != null){
				curNode = curNode.getLink();
			}
			// Una volta essendo sul penultimo nodo possiamo porgere il suo link a null, così rimuovendo l'ultimo nodo dalla lista.
			curNode.setLink(null);
			nElements--;
		}else{
			// Se abbiamo un solo elemento nella lista richiamiamo la funzione delFromHead(), visto che se passassimo dal ciclo, egli cercerebbe di trovare il prossimo elemento
			// di null, il quale non esiste.
			delFromHead();
		}
	}

	// Elimina l'elemento corrispondente al parametro in input.
	public void delFromOrder(Obj data){
		// In questo metodo controllo se gli attributi dentro gli oggetti sono uguali, se qualora volessi controllare l'uguaglianza degli oggetti stessi
		// indipendentemente dal loro contenuto, avrei dovuto fare il seguente controllo: (Nodo.getData() == data).
		if(head != null){
			Node curNode = head;
			Node nextNode = curNode.getLink();

			// Se l'elemento si trova in testa bisogna chiamare la funzione delFromHead(), così si occupa lei del cambio head.
			if((head.getData().id == data.id) && head.getData().name.equals(data.name)){
				delFromHead();
			}else{
				// Cicliamo fino a quando non troviamo l'elemento da eliminare.
				while(nextNode != null && (nextNode.getData().id != data.id && !nextNode.getData().name.equals(data.name))){
					curNode = nextNode;
					nextNode = curNode.getLink();
				}
				if(nextNode != null){
					// In questo caso curNode indica l'elemento della lista posizionato prima rispetto quello da eliminare, cioè nextNode.
					curNode.setLink(nextNode.getLink());
					nElements--;
				}else{
					// Infine se scorriamo tutta la lista senza trovare occorrenze sia di nome che di ID informiamo, all'user, dell'esito.
					System.out.println("L'elemento: Name: " + data.name + " | ID: " + data.id + " --> Non è stato trovato.");
				}
			}
		}
	}

	public boolean isEmpty(){
		return head == null;
	}

	public void printList(){
		System.out.println(nElements + " element(s):");
		if(head != null){
			Node curNode = head;
			while(curNode != null){
				curNode.getData().printObj();
				curNode = curNode.getLink();
			}
		}else{
			System.out.println("	Lista vuota");
		}
	}
}
