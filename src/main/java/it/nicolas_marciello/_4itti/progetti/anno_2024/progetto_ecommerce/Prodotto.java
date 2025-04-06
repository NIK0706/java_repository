package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce;

public class Prodotto {
	protected String titoloArticolo;
	protected float prezzo;
	protected String marca;
	protected boolean isBought;
	protected String codiceUnivoco;
	protected int sconto; // Se sconto == 0 --> nesuno sconto
	protected String garanzia; // Se nullo --> nessuna garanzia
	protected int amount;

	public Prodotto(String titoloArticolo, float prezzo, String marca, String codiceUnivoco, int sconto, String garanzia){
		this.titoloArticolo = titoloArticolo;
		this.prezzo = prezzo;
		this.marca = marca;
		this.codiceUnivoco = codiceUnivoco;
		this.sconto = sconto;
		this.garanzia = garanzia;
		this.isBought = false;
		this.amount = 1;
	}
}
