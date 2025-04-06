package it.nicolas_marciello._4itti.esercizi.aprile_2025.consegna_in_classe;

public class BTNode{
	protected Obj data;
	protected BTNode psx;
	protected BTNode pdx;

	public BTNode(Obj data){
		this.data = data;
		psx = null;
		pdx = null;
	}

	public BTNode getPsx(){
		return psx;
	}

	public BTNode getPdx(){
		return pdx;
	}

	public void setPsx(BTNode psx){
		this.psx = psx;
	}

	public void setPdx(BTNode pdx){
		this.pdx = pdx;
	}
}
