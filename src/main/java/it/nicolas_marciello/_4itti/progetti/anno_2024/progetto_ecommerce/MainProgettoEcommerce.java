package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce.categorie_prodotto.*;

// 2) Implementare funzione di traferimento oggetti da lista dei desideri a carrello.

public class MainProgettoEcommerce {
	@SuppressWarnings("ConvertToTryWithResources") // Note: Per rimuovere quell'errore noioso dell'oggetto scanner.
	public static void main(String[] args) {
		// Crea le liste necessarie per la gestione dell'ecommerce.
		List<Prodotto> listaDesideri = new ArrayList<>();
		List<Prodotto> carrello = new ArrayList<>();
		List<Prodotto> ecommerce = new ArrayList<>(); // Lista che contiene tutti gli oggetti (Prodotti).
		List<Prodotto> listaCestino = new ArrayList<>();
		List<Prodotto> listaProdottiAcq = new ArrayList<>();

		/*
		 * Non ha senso instanziare Negozio (Nome della classe prima di essere cambiato in ListaOperazioni),
		 * perchè non è un oggetto fisico che ha metodi privi di parametri i quali modificano attributi della classe,
		 * ha solo lo scopo di mantenere tutte i metodi che modificano le liste in un unico luogo.
		 * Il codice che segue è prima della modifica della classe 'ListaOperazioni' (ex Negozio) in 'final':
		 *	 Creazione dell'oggetto 'negozio' di classe 'Negozio' il quale contiene le funzioni chiave per il controllo dell'ecommerce.
		 *	 Negozio negozio = new Negozio(listaDesideri, carrello);
		*/

		// Elettronica:
		ecommerce.add(new Elettronica("iPhone 16", 979, "Apple", "1", 0, "1 anno", 'a', true));
		ecommerce.add(new Elettronica("iPad", 409, "Apple", "2", 0, "1 anno", 'a', true));
		ecommerce.add(new Elettronica("AirPods", 149, "Apple", "3", 0, "1 anno", 'a', true));
		ecommerce.add(new Elettronica("MacBook Pro M4", 1949, "Apple", "4", 0, "1 anno", 'a', true));

		// Alimento:
		ecommerce.add(new Alimento("Cotolette di pollo", 20, "Amadori", "5", 0, "", true, true, 350, "4/02/2025"));
		ecommerce.add(new Alimento("Prosciutto", 60, "SanDaniele", "6", 0, "", true, true, 2000, "10/10/25"));
		ecommerce.add(new Alimento("Yogurt alla vaniglia", 4, "Danette", "7", 0, "", false, false, 20, "12/12/24"));

		// Abbiliamento:
		ecommerce.add(new Abbigliamento("Felpa Nike", 60, "Nike", "8", 0, "", "M", "cotone", "grigio"));
		ecommerce.add(new Abbigliamento("AirForce 1", 120, "Nike", "9", 0, "", "44", "", "bianco"));
		ecommerce.add(new Abbigliamento("Jordan 4", 530, "Jordan", "10", 0, "", "46", "", "verde"));
		ecommerce.add(new Abbigliamento("Pantaloni Nike", 90, "Nike", "11", 0, "", "XS", "tech", "nero"));

		// Attributi in comune (aggiunti per la creazione di nuovi oggetti dall'utente):
		float prezzoProdotto;
		String titoloProdotto, marcaProdotto, codiceUnivocoProdotto, garanziaProdotto;
		// Attributi di 'Elettronica':
		char consumoElettronica;
		boolean batteriaElettronica;
		// Attributi di 'Alimento':
		boolean solidoAlimento, salatoAlimento;
		float pesoAlimento;
		String scadenzaAlimento;
		// Attributi di 'Abbigliamento':
		String tagliaAbbigliamento, materialeAbbigliamento, coloreCapoAbbigliamento;

		// Creazione dell'oggetto scanner (per prendere in input i valori dell'utente):
		Scanner scanner = new Scanner(System.in);

		// Variabili per la gestione del menu:
		int selezione, selezione2;
		String testoInput;

		// MENU
		do{
			printTime();
			/* Opzioni:
			 *   1. Gestisci liste.
			 *   2. Aggiungi oggetti nelle liste.
			 *   3. Crea prodotto.
			 *   0. Esci.
			 */
			System.out.println("Opzioni:\n  1. Gestisci liste.\n  2. Aggiungi oggetti nelle liste.\n  3. Crea prodotto.\n  0. Esci.");

			selezione = readInputInt("> ");

			// Ripulusci lo schermo dopo che ha preso in input 'selezione' (quindi l'utente ha tempo per vedere il messaggio di opzioni).
			System.out.print("\033[H\033[2J");
			System.out.flush();

			switch(selezione){
				case 1 -> {
					printTime();
					// Gestisci le liste:
					/* Gestisci liste:
					 *   1. Controlla carrello. /  1. Controlla carrello (Vuoto).
					 *   2. Controlla lista dei desideri. /  2. Controlla lista dei desideri (Vuota).
					 *   3. Riordina liste.
					 *   4. Prosegui acquisto. /  4. Prosegui acquisto (Il carrello è vuoto!).
					 *   5. Controlla lista acquisti passati. /  5. Controlla lista acquisti passati (Vuota).
					 *   6. Controlla lista oggetti rimossi. /  6. Controlla lista oggetti rimossi (Vuota).
					 *   7. Indietro.
					 */
					System.out.println("Gestisci liste:");
					if(!carrello.isEmpty()){System.out.println("  1. Controlla carrello.");}else{System.out.println("  1. Controlla carrello (Vuoto).");}
					if(!listaDesideri.isEmpty()){System.out.println("  2. Controlla lista dei desideri.");}else{System.out.println("  2. Controlla lista dei desideri (Vuota).");}
					System.out.println("  3. Riordina liste.");
					if(!carrello.isEmpty()){System.out.println("  4. Prosegui acquisto.");}else{System.out.println("  4. Prosegui acquisto (Il carrello è vuoto!).");}
					if(!listaProdottiAcq.isEmpty()){System.out.println("  5. Controlla lista acquisti passati.");}else{System.out.println("  5. Controlla lista acquisti passati (Vuota).");}
					if(!listaCestino.isEmpty()){System.out.println("  6. Controlla lista oggetti rimossi.");}else{System.out.println("  6. Controlla lista oggetti rimossi (Vuota).");}
					System.out.println("  7. Indietro.");

					selezione = readInputInt("> ");

					// Ripulusci lo schermo.
					System.out.print("\033[H\033[2J");
					System.out.flush();

					switch(selezione){
						// Scrivi carrello:
						case 1 ->{
							System.out.println("\nControlla carrello:");
							ListaOperazioni.printList(carrello);
							System.out.println();
						}
						// Scrivi lista dei desideri:
						case 2 ->{
							System.out.println("\nControllo della lista dei desideri:");
							ListaOperazioni.printList(listaDesideri);
							System.out.println();
						}

						// Riordina le liste:
						case 3 ->{
							System.out.println("Riordina liste:");
							if(carrello.isEmpty()){System.out.print("  1. Carrello (Vuoto!)\n  ");}else{System.out.print("  1. Carrello\n");}
							if(listaDesideri.isEmpty()){System.out.print("  2. Lista dei desideri (Vuoto!)\n");}else{System.out.print("  2. Lista dei desideri\n");}
							System.out.println("  3. Indietro");

							selezione = readInputInt("> ");

							// Ripulusci lo schermo.
							System.out.print("\033[H\033[2J");
							System.out.flush();

							switch(selezione){
								// Modalità del carrello:
								case 1 -> {
									if(!carrello.isEmpty()){
										System.out.println("Carrello:\n  1. Scambia prodotti\n  2. Elimina prodotti  \n  3. Indietro");

										selezione = readInputInt("> ");

										// Ripulusci lo schermo.
										System.out.print("\033[H\033[2J");
										System.out.flush();

										switch(selezione){
											// Scambia prodotti del carrello:
											case 1 -> {
												ListaOperazioni.printList(carrello);
												System.out.println("Sposta l'elemento del carrello: ");
												selezione = readInputInt("> ");
												System.out.println("Con l'elemento: ");
												selezione2 = readInputInt("> ");

												ListaOperazioni.swapItemsInList(selezione, selezione2, carrello);
											}
											// Elimina prodotti del carrello:
											case 2 -> {
												if(!carrello.isEmpty()){
													ListaOperazioni.printList(carrello);
													System.out.println("Posizione del prodotto da eliminare: ");
													selezione = readInputInt("> ");
													listaCestino.add(carrello.get(selezione-1));
													System.out.println("Prodotto alla posizione [" + selezione + "][" + carrello.get(selezione-1).titoloArticolo + "] è stato eliminato con successo.");
													carrello.remove(selezione-1);
												}else{
													System.out.println("Il carrello è vuoto.");
												}
											}
											case 3 -> {continue;} // Indietro.
											default -> System.out.println("Valore non valido");
										}
									}else{
										System.out.println("Il carrello è vuoto!");
									}

								}
								// Modalità della lista dei desideri:
								case 2 -> {
									if(!listaDesideri.isEmpty()){
										System.out.println("Lista dei desideri:\n  1. Scambia prodotti\n  2. Elimina prodotti  \n  3. Indietro");

										selezione = readInputInt("> ");

										// Ripulusci lo schermo.
										System.out.print("\033[H\033[2J");
										System.out.flush();

										switch(selezione){
											// Scambia prodotti della lista dei desideri:
											case 1 -> {
												ListaOperazioni.printList(listaDesideri);
												System.out.println("Sposta l'elemento della lista dei desideri: ");
												selezione = readInputInt("> ");
												System.out.println("Con l'elemento: ");
												selezione2 = readInputInt("> ");

												ListaOperazioni.swapItemsInList(selezione, selezione2, listaDesideri);
											}
											// Elimina prodotti della lista dei desideri:
											case 2 -> {
												if(!listaDesideri.isEmpty()){
													ListaOperazioni.printList(listaDesideri);
													System.out.println("Posizione del prodotto da eliminare: ");
													selezione = readInputInt("> ");
													System.out.println("Prodotto alla posizione [" + selezione + "][" + listaDesideri.get(selezione-1).titoloArticolo + "] è stato eliminato con successo.");
													listaDesideri.remove(selezione-1);
												}else{
													System.out.println("La lista dei desideri è vuota");
												}
											}
											case 3 -> {continue;} // Indietro.
											default -> System.out.println("Valore non valido");
										}
									}else{
										System.out.println("La lista dei desideri è vuota!");
									}
								}
								case 3 -> {continue;} // Indietro.
								default -> System.out.println("Valore non valido");
							}
						}
						// Prosegui acquisto:
						case 4 ->{
							if(!carrello.isEmpty()){
								System.out.println("Prosegui acquisto:\n");
								ListaOperazioni.printList(carrello);
								System.out.println("Subtotale pagamento: " + ListaOperazioni.sumPrices(carrello));
								System.out.println("Conferma:\n  1. Si\n  2. No");

								selezione = readInputInt("> ");
								switch(selezione){
									// Acquisto merce:
									case 1 ->{
										// Ripulusci lo schermo.
										System.out.print("\033[H\033[2J");
										System.out.flush();

										/* Scambio dei prodotti da:
										 * carrello --> listaProdottiAcq
										*/
										for(Prodotto prodottoCorrente: carrello){
											listaProdottiAcq.add(prodottoCorrente);
										}
										for(Prodotto prodottoCorrente: listaProdottiAcq){
											carrello.remove(prodottoCorrente);
										}

										System.out.println("Acquisto avvenuto con successo!");
									}
									// Indietro:
									case 2 ->{
										// Ripulusci lo schermo.
										System.out.print("\033[H\033[2J");
										System.out.flush();
										continue;
									}
									default -> System.out.println("Valore non valido");
								}
							}else{
								System.out.println("Nessun oggetto nel carrello.");
							}
						}
						// Controlla lista acquisti passati:
						case 5 ->{
							ListaOperazioni.printList(listaProdottiAcq);
							System.out.println("Lista degli acquisti passati:\n  1. Indietro");

							selezione = readInputInt("> ");

							// Ripulusci lo schermo.
							System.out.print("\033[H\033[2J");
							System.out.flush();

							if(selezione == 1){continue;}
						}
						// Controlla lista cestino:
						case 6 ->{
							ListaOperazioni.printList(listaCestino);
							System.out.println("Lista degli oggetti rimossi:\n  1. Indietro");

							selezione = readInputInt("> ");

							// Ripulusci lo schermo.
							System.out.print("\033[H\033[2J");
							System.out.flush();

							if(selezione == 1){continue;}
						}
						case 7 ->{continue;} // Indietro.
						default -> System.out.println("Valore non valido");
					}

				}
				case 2 -> {
					printTime();
					// Aggiungi oggetti nelle liste:
					System.out.println("Aggiungi nuovi oggetti:\n  1. Al carrello.\n  2. Alla lista dei desideri.\n  3. Indietro");

					selezione = readInputInt("> ");

					// Ripulusci lo schermo.
					System.out.print("\033[H\033[2J");
					System.out.flush();

					switch(selezione){
						case 1 ->{
							// Aggiungi oggetti al Carrello:
							ListaOperazioni.printList(ecommerce);

							selezione = readInputInt("> ");

							if(selezione >= 1 && selezione <= ecommerce.size()){
								ListaOperazioni.addProd(carrello, ecommerce.get(selezione-1));
							}else{
								System.out.println("Numero non valido");
							}
						}
						case 2 ->{
							// Aggiungi oggetti alla Lista dei desideri:
							ListaOperazioni.printList(ecommerce);

							selezione = readInputInt("> ");

							if(selezione >= 1 && selezione <= ecommerce.size()){
								ListaOperazioni.addProd(listaDesideri, ecommerce.get(selezione-1));
							}else{
								System.out.println("Numero non valido");
							}
						}
						case 3 ->{continue;} // Indietro.
						default -> System.out.println("Valore non valido");
					}
				}
				case 3 -> {
					printTime();
					// Crea prodotto:
					System.out.println("Crea un nuovo prodotto:\n Categoria\n  1. Elettronica.\n  2. Alimento.\n  3. Abbigliamento.\n  4. Indietro");
					selezione = readInputInt("> ");

					// Ripulusci lo schermo.
					System.out.print("\033[H\033[2J");
					System.out.flush();

					// Se l'utente vuole ritornare alla scheda principale, senza aver eseguito nulla nella scheda corrente,
					// controllo prima se il valore di 'selezione' è uguale a 4 (--> ritorno alla scheda principale).
					switch(selezione){
						case 4 ->{continue;} // Indietro.
					}

					System.out.println("Titolo del prodotto:");
					testoInput = readInputString("> ");
					titoloProdotto = testoInput;

					System.out.println("Prezzo del prodotto:");
					testoInput = readInputString("> ");
					prezzoProdotto = Float.parseFloat(testoInput);

					System.out.println("Marca del prodotto:");
					testoInput = readInputString("> ");
					marcaProdotto = testoInput;

					System.out.println("Codice univoco del prodotto:");
					testoInput = readInputString("> ");
					codiceUnivocoProdotto = testoInput;

					System.out.println("Garanzia del prodotto:");
					testoInput = readInputString("> ");
					garanziaProdotto = testoInput;

					switch(selezione){
						case 1 ->{
							// Nuovo Prodotto di Elettronica.
							System.out.println("Consumo del prodotto:");
							testoInput = readInputString("> ");
							consumoElettronica = testoInput.charAt(0);

							// Non è conforme al resto del codice dove si immette solo valori numerici in input
							// (eccetto le stringhe per la creazione di nuovi oggetti) perchè faccio digitare
							// all'utente 'si' oppure 'no' per scegliere l'opzione data:
							do {
								System.out.println("Batteria (si/no):");
								testoInput = readInputString("> ");
								if("si".equals(testoInput)){batteriaElettronica = true; break;}else if("no".equals(testoInput)){batteriaElettronica = false; break;}
							}while(true);

							ecommerce.add(new Elettronica(titoloProdotto, prezzoProdotto, marcaProdotto, codiceUnivocoProdotto, 0, garanziaProdotto, consumoElettronica, batteriaElettronica));

							// Ripulusci lo schermo.
							System.out.print("\033[H\033[2J");
							System.out.flush();
							System.out.println("Prodotto aggiunto con successo!");
						}
						case 2 ->{
							// Nuovo Prodotto di Alimento.
							do {
								System.out.println("Solido (si/no):");
								testoInput = readInputString("> ");
								if("si".equals(testoInput)){solidoAlimento = true; break;}else if("no".equals(testoInput)){solidoAlimento = false; break;}
							}while(true);

							do {
								System.out.println("Salato (si/no):");
								testoInput = readInputString("> ");
								if("si".equals(testoInput)){salatoAlimento = true; break;}else if("no".equals(testoInput)){salatoAlimento = false; break;}
							}while(true);

							System.out.println("Peso del prodotto:");
							testoInput = readInputString("> ");
							pesoAlimento = Float.parseFloat(testoInput);

							System.out.println("Scadenza del prodotto:");
							testoInput = readInputString("> ");
							scadenzaAlimento = testoInput;

							ecommerce.add(new Alimento(titoloProdotto, prezzoProdotto, marcaProdotto, codiceUnivocoProdotto, 0, garanziaProdotto, solidoAlimento, salatoAlimento, pesoAlimento, scadenzaAlimento));

							// Ripulusci lo schermo.
							System.out.print("\033[H\033[2J");
							System.out.flush();
							System.out.println("Prodotto aggiunto con successo!");
						}
						case 3 ->{
							// Nuovo Prodotto di Abbigliamento.
							System.out.println("Taglia del prodotto:");
							testoInput = readInputString("> ");
							tagliaAbbigliamento = testoInput;

							System.out.println("Materiale del prodotto:");
							testoInput = readInputString("> ");
							materialeAbbigliamento = testoInput;

							System.out.println("Colore del prodotto:");
							testoInput = readInputString("> ");
							coloreCapoAbbigliamento = testoInput;

							ecommerce.add(new Abbigliamento(titoloProdotto, prezzoProdotto, marcaProdotto, codiceUnivocoProdotto, 0, garanziaProdotto, tagliaAbbigliamento, materialeAbbigliamento, coloreCapoAbbigliamento));

							// Ripulusci lo schermo.
							System.out.print("\033[H\033[2J");
							System.out.flush();
							System.out.println("Prodotto aggiunto con successo!");
						}
						default -> System.out.println("Valore non valido");
					}
				}
				// Uscita del programma:
				case 0 -> System.out.println("Uscita");
				// Caso di input non valido:
				case -1 -> {System.out.println("Valore non valido"); continue;}
				default -> System.out.println("Numero non valido");
			}


		}while(selezione != 0);

		scanner.close();
	}

	// Prende in input una stringa:
	@SuppressWarnings("resource") // Note: Per rimuovere l'errore dell'oggetto scanner.
	public static String readInputString(String preMessaggio){
		if(preMessaggio != null){System.out.print(preMessaggio);}

		Scanner scanner = new Scanner(System.in);
		try{
			return scanner.next();
		}catch(Exception e){
			return null;
		}
	}

	// Prende in unput un intero:
	@SuppressWarnings("resource") // Note: Per rimuovere l'errore dell'oggetto scanner.
	public static int readInputInt(String preMessaggio){
		if(preMessaggio != null){System.out.print(preMessaggio);}

		Scanner scanner = new Scanner(System.in);
		try{
			return scanner.nextInt();
		}catch(Exception e){
			return -1;
		}
	}

	// Scrive la data e l'ora corrente in modo formattato:
	public static void printTime(){
		LocalDateTime adesso = LocalDateTime.now();
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
		String adessoFormattato = adesso.format(myFormat);
		System.out.println("Ora esecuzione: " + adessoFormattato + "\r");
	}
}
