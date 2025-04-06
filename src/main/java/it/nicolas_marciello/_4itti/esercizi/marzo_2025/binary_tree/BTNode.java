package it.nicolas_marciello._4itti.esercizi.marzo_2025.binary_tree;
import it.nicolas_marciello._4itti.esercizi.marzo_2025.Obj;

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
