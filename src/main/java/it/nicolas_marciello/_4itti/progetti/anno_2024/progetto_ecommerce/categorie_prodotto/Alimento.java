package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce.categorie_prodotto;

import it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce.Prodotto;

public class Alimento extends Prodotto {
	protected boolean solido;
	protected boolean salato;
	protected float peso;
	protected String scadenza;

	public Alimento(String titoloArticolo, float prezzo, String marca, String codiceUnivoco, int sconto, String garanzia, boolean solido, boolean salato, float peso, String scadenza){
		super(titoloArticolo, prezzo, marca, codiceUnivoco, sconto, garanzia);
		this.solido = solido;
		this.salato = salato;
		this.peso = peso;
		this.scadenza = scadenza;
	}

	public boolean IsSolido(){
		return solido;
	}

	public boolean IsSalato(){
		return salato;
	}


	public float getPeso(){
		return peso;
	}

	public String getScadenza(){
		return scadenza;
	}
}
