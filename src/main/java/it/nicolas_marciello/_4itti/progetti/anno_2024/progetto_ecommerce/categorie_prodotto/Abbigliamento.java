package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce.categorie_prodotto;

import it.nicolas_marciello._4itti.progetti.anno_2024.progetto_ecommerce.Prodotto;

public class Abbigliamento extends Prodotto {
	protected String taglia;
	protected String materiale;
	protected String coloreCapo;

	public Abbigliamento(String titoloArticolo, float prezzo, String marca, String codiceUnivoco, int sconto, String garanzia, String taglia, String materiale, String coloreCapo){
		super(titoloArticolo, prezzo, marca, codiceUnivoco, sconto, garanzia);
		this.taglia = taglia;
		this.materiale = materiale;
		this.coloreCapo = coloreCapo;
	}

	public String getTaglia(){
		return taglia;
	}

	public String getMateriale(){
		return materiale;
	}

	public String getColoreCapo(){
		return coloreCapo;
	}
}
