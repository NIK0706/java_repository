package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_halloween2024.classi_dolcetti;

public class CaramellaAmara extends Dolcetto {
	protected int amarezza;
	protected boolean sputato = false;

	public CaramellaAmara(String nome, int sapore, float peso, String[] ingredienti, int amarezza){
		super(nome, sapore, peso, ingredienti);

		this.amarezza = amarezza;
	}

	/* Note: Posso usare la seguente funzione per negare sputato, ma è rindondante:
		private void sputa(){
			this.sputato = !sputato;
		}
	*/

	@Override
	public void mangia(){
		if(!sputato){
			String stringPiacere;

			if(amarezza <= 4){
				stringPiacere = "è poco amara!";
			}else if(amarezza > 4 && amarezza <= 8){
				stringPiacere = "è neutra!";
			}else{
				stringPiacere = "è amarisima!";
				sputato = !sputato;
				// sputa();
			}

			String listaIngr = String.join(", ", ingredienti);
			System.out.println(nome + " è composto da: " + listaIngr + ". Pesa " + peso + " grammi, ed " + stringPiacere);
		}else{
			System.out.println(nome + " è troppo amara, non ci riprovo a mangiarla!");
		}
	}
}
