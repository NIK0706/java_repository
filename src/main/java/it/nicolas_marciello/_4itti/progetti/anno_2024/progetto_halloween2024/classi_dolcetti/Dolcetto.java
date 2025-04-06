package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_halloween2024.classi_dolcetti;

public class Dolcetto {
	protected String nome;
	protected int sapore; // Scala da 1 a 10;
	protected float peso;
	protected String[] ingredienti; // Array degli ingredienti

	// Da cambiare:
	public Dolcetto(String nome, int sapore, float peso, String[] ingredienti){
		this.nome = nome;
		this.sapore = sapore;
		this.peso = peso;
		this.ingredienti = ingredienti;
	}

	public void mangia(){
		String stringPiacere;

		if(sapore <= 4){
			stringPiacere = "non è nulla di che!";
		}else if(sapore > 4 && sapore <= 8){
			stringPiacere = "è abbastanza buono!";
		}else{
			stringPiacere = "è buonissimo!";
		}

		String listaIngr = String.join(", ", ingredienti);
		System.out.println(nome + " è composto da: " + listaIngr + ". Pesa " + peso + " grammi, ed " + stringPiacere);
	}
}
