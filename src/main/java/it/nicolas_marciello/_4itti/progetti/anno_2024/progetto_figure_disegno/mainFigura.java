package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_figure_disegno;

import it.nicolas_marciello._4itti.progetti.anno_2024.progetto_figure_disegno.classi_figura.Cerchio;
import it.nicolas_marciello._4itti.progetti.anno_2024.progetto_figure_disegno.classi_figura.Figura;
import it.nicolas_marciello._4itti.progetti.anno_2024.progetto_figure_disegno.classi_figura.Quadrato;

public class mainFigura {
	public static void main(String[] args) {
		// In questo caso posso instanziare senza problemi un oggetto della classe Cerchio/Quadrato con variabile ("circle", "qudrato") di tipo Figura
		// perchè uso dei metodi dichiarati nella classe astratta ("Figura") --> Dove poi ho sovrascritto usando @Override.
		// Invece se avessi avuto dei metodi specifici delle classi figlie (a quella astratta) dovevo per forza instanziare, come prima, gli oggetti
		// della classe Cerchio/Quadrato però con variabile ("circle", "qudrato") di tipo Cerchio o Quadrato.
		Figura circle = new Cerchio("diddy", 10);
		Figura quadrato = new Quadrato("freaky :3", 10);

		System.out.println("area " + circle.getNome() + " : " + circle.area());
		System.out.println("perimetro " + circle.getNome() + " : " + circle.perimetro());

		System.out.println("area " + quadrato.getNome() + " : " + quadrato.area());
		System.out.println("perimetro " + quadrato.getNome() + " : " + quadrato.perimetro());

		System.out.println(quadrato.getNome());
	}
}
