package it.nicolas_marciello._4itti.esercizi.aprile_2025.consegna_in_classe;

public class BT{
	protected BTNode root;

	public BT(){
		root = null;
	}

	public void addNode(Obj data){
		BTNode newNode = new BTNode(data), curNode, subRoot;

		// Se l'albero è vuoto allora imposta come nuova root l'elemento nuovo
		if(root == null){
			root = newNode;
		}else{
			// In caso contrario tengo conto di due puntatori:
			// subRoot a fine iterazione segnerà il nodo a cui andremo ad aggiungere il nuovo figlio.
			// curNode a fine iterazione assumerà il valore null, il quale permette lo spostamento per l'albero.
			subRoot = root;

			// Decidiamo, in base al valore del nuovo elemento da aggiungere, da quale parte iniziare la ricerca del nodo
			// interssato nell'inserimento.
			if(data.getValue() < root.data.getValue()){
				curNode = subRoot.getPsx();
			}else{
				curNode = subRoot.getPdx();
			}

			// Una volta trovata la parte cicliamo fino a quando non troviamo il valore null per il puntatore curNode.
			while(curNode != null){
				subRoot = curNode;
				if(data.getValue() < curNode.data.getValue()){
					curNode = curNode.getPsx(); // Permette lo spostamento a sinistra dell'albero.
				}else{
					curNode = curNode.getPdx(); // Permette lo spostamento a destra dell'albero.
				}
			}

			// Come ultimo controllo necessitiamo di controllare la grandezza del nuovo elemento in comparazione
			// all'ultimo dell'albero al quale andremo ad aggiunere il nuovo elemento.
			if(data.getValue() < subRoot.data.getValue()){
				subRoot.setPsx(newNode);
			}else{
				subRoot.setPdx(newNode);
			}

		}
	}

 	public void visitaSimmetrica(BTNode root){
		if(root == null){
			return;
		}
		if(root.getPsx() != null){
			visitaSimmetrica(root.getPsx());
		}
		root.data.printObj();
		if(root.getPdx() != null){
			visitaSimmetrica(root.getPdx());
		}
	}

	// Senza dover specificare la root.
	public void visitaSimmetrica(){
		visitaSimmetrica(root);
	}

	public void visitaAnticipata(BTNode root){
		if(root == null){
			return;
		}
		root.data.printObj();
		if(root.getPsx() != null){
			visitaSimmetrica(root.getPsx());
		}
		if(root.getPdx() != null){
			visitaSimmetrica(root.getPdx());
		}
	}

	public boolean findNode(BTNode root, Obj data){
		// Se l'albero non esistesse, allora ritorna false.
		if(root == null){
			return false;
		}

		// Se l'elemento combacia, allora ritorna true.
		if(root.data.getValue() == data.getValue()){
			return true;
		}

		// Se invece l'elemento cercato è minore dell'elemento corrente, allora spostati a sinistra.
		// In caso contrario, qual'ora fosse maggiore dell'elemento corrente, spostati a destra.
		if(root.data.getValue() > data.getValue()){
			return findNode(root.getPsx(), data);
		}
		if(root.data.getValue() < data.getValue()){
			return findNode(root.getPdx(), data);
		}
		return false;
	}
}
