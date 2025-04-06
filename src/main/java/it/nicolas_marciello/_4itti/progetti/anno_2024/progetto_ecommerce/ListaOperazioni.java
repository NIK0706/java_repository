package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce;

import java.util.List;

import it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce.categorie_prodotto.*;

public final class ListaOperazioni {
	// Stringa che conterrà l'informazione letterale di un valore boolean:
	protected static String specBoolString;
	// Numero intero che conterà l'iterazione del ciclo:
	protected static int i;

	public static void printList(List<Prodotto> lista){
		i = 1;

		if(!lista.isEmpty()){
			for(Prodotto prodottoCorrente: lista){
				System.out.println("┌: ["+ i +"]: " + prodottoCorrente.titoloArticolo + ":");
				System.out.format("├─  Prezzo: %.2f euro\n", prodottoCorrente.prezzo);

				if(!"".equals(prodottoCorrente.marca)){ // Note: Uguale a dire: prodottoCorrente.marca != "" ma Java manda un avvertimento per cambiarlo come scritto nell'argomento del costrutto "if".
				// Inoltre equals compara due oggetti, ma visto che le stringhe in java sono oggetti posso
				// tranquillamente comparare due stringhe usando questa funzione.
					System.out.println("├─  Marca: " + prodottoCorrente.marca);
				}

				System.out.println("├─  Codice univoco: " + prodottoCorrente.codiceUnivoco);

				if(prodottoCorrente.sconto != 0){
					System.out.print("├─  Sconto applicato: " + prodottoCorrente.sconto + "% --> ");
					System.out.format("%.2f euro\n", ((prodottoCorrente.prezzo*prodottoCorrente.sconto)/100));}

				if(!"".equals(prodottoCorrente.garanzia)){
					System.out.println("├─  Garanzia prodotto: " + prodottoCorrente.garanzia);}

				if(prodottoCorrente.isBought){
					System.out.println("├─  L'oggetto è stato già comprato in passato");}

				// Solo per oggetti di classe 'Aliemento'.
				if(prodottoCorrente instanceof Alimento alimentoCorrente){
					// Note: Uguale a dire, dentro il corpo dell'if statement, senza l'oggetto 'alimentoCorrente' presente nella condizione del costrutto if: 'Alimento alimentoCorrente = (Alimento) prodottoCorrente;'
					if(alimentoCorrente.IsSolido()){specBoolString = "solido";}else{specBoolString = "morbido";}
					System.out.print("├─  L'alimento è " + specBoolString + " e ");

					if(alimentoCorrente.IsSalato()){specBoolString = "salato";}else{specBoolString = "dolce";}
					System.out.println(specBoolString);

					System.out.println("├─  Peso: " + alimentoCorrente.getPeso() + "\n├─  Scadenza: " + alimentoCorrente.getScadenza());
				}

				// Solo per oggetti di classe 'Elettronica'.
				if(prodottoCorrente instanceof Elettronica elettronicaCorrente){
					System.out.println("├─  Consumo: " + elettronicaCorrente.getConsumo());

					if(elettronicaCorrente.hasBatteria()){specBoolString = "possiede almeno una batteria";}else{specBoolString = "è privo di batterie";}
					System.out.println("├─  Il prodotto " + specBoolString );
				}

				// Solo per oggetti di classe 'Abbigliamento'.
				if(prodottoCorrente instanceof Abbigliamento abbigliamentoCorrente){
					System.out.println("├─  Taglia: " + abbigliamentoCorrente.getTaglia() + "\n├─  Colore: " + abbigliamentoCorrente.getColoreCapo());

					if(!"".equals(abbigliamentoCorrente.getMateriale())){
						System.out.println("├─  Materiale: " + abbigliamentoCorrente.getMateriale());}
				}

				if(prodottoCorrente.amount > 1){
					System.out.println("├─  Quantità: " + prodottoCorrente.amount);}

				i++;
				System.out.println("└─────────────────────┘\n");
			}
		}else{
			System.out.println("La lista è vuota");
		}
	}

	// L'elemento aggiunto viene posizionato prima dell'index indicato -- Quindi -> list.add(pos, elementNuovo) -- Indica -> 'elementNuovo' aggiunto prima di element.get(pos)
	public static void swapItemsInList(int indexElement1, int indexElement2, List<Prodotto> lista){
		indexElement1 -= 1;
		indexElement2 -= 1;
		Prodotto element1 = lista.get(indexElement1);
		Prodotto element2 = lista.get(indexElement2);

		if(indexElement1 < indexElement2){
			lista.add(indexElement2, element1);
			lista.remove(element2);
			lista.remove(element1);
			lista.add(indexElement1, element2);
		}else if(indexElement1 > indexElement2){
			lista.add(indexElement1, element2);
			lista.remove(element1);
			lista.remove(element2);
			lista.add(indexElement2, element1);
		}else if(indexElement1 == indexElement2){
			System.out.println("Non puoi scambiare lo stesso elemento ["+element1.titoloArticolo+"].");
		}
	}

	public static void clearList(List<Prodotto> lista){
		lista.clear();
	}

	public static int sumPrices(List<Prodotto> lista){
		int sum = 0;
		for(Prodotto oggettoCorrente: lista){
			sum += (oggettoCorrente.prezzo * oggettoCorrente.amount);
		}
		return sum;
	}

	// Controlla se l'oggetto è già presente nella lista, se lo fosse allora aumenta la quantità dell'oggetto:
	public static void addProd(List<Prodotto> lista, Prodotto oggetto){
		if(!lista.contains(oggetto)){
			lista.add(oggetto);
		}else{
			// lista.get(lista.indexOf(oggetto)).amount++; --> Altro modo.
			oggetto.amount++;
		}
	}
}
