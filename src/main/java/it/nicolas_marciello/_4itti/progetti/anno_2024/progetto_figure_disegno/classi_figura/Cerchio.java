package it.nicolas_marciello._4itti.progetti.anno_2024.progetto_figure_disegno.classi_figura;

public class Cerchio extends Figura {
	private final float raggio;

	public Cerchio(String nome, float raggio){
		super(nome);
		this.raggio = raggio;
	}

	@Override
	public float area(){
		return (float)((raggio*raggio)*Math.PI);
	}

	@Override
	public float perimetro(){
		return (float)((2*Math.PI)*raggio);
	}
}
