package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_figure_disegno.classi_figura;

public abstract class Figura {
	protected String nome;

	public Figura(String nome){
		this.nome = nome;
	}

	public abstract float area();
	public abstract float perimetro();

	public String getNome(){
		return nome;
	}
}
