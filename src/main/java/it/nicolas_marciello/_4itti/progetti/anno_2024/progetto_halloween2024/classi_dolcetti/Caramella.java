package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_halloween2024.classi_dolcetti;

public class Caramella extends Dolcetto {
	private final int dolcezza; // Scala da 1 a 10;
	private boolean scartato = false;

	public Caramella(String nome, int sapore, float peso, String[] ingredienti, int dolcezza){
		super(nome, sapore, peso, ingredienti);

		this.dolcezza = dolcezza;
	}

	public void scarta(){
		if(!scartato){
			scartato = !scartato;
			System.out.println("La confezione di " + nome + " è stato aperto.");
		}else{
			System.out.println(nome + " è già stato scartato.");
		}
	}

	@Override
	public void mangia(){
		if(scartato){
			String stringPiacere;

			if(dolcezza <= 4){
				stringPiacere = "è poco dolce!";
			}else if(dolcezza > 4 && dolcezza <= 8){
				stringPiacere = "è neutro!";
			}else{
				stringPiacere = "è dolcissimo!";
			}

			String listaIngr = String.join(", ", ingredienti);
			System.out.println(nome + " è composto da: " + listaIngr + ". Pesa " + peso + " grammi, ed " + stringPiacere);

		}else{
			System.out.println("Non posso mangiare " + nome +  " se non rimuovo prima il suo incarto.");
		}
	}
}
