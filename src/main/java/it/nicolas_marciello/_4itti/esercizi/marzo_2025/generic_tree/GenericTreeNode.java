package it.nicolas_marciello._4itti.esercizi.marzo_2025.generic_tree;
import it.nicolas_marciello._4itti.esercizi.marzo_2025.Obj;

public class GenericTreeNode{
	protected Obj data;
	protected GenericTreeNode firstChild;
	protected GenericTreeNode firstSibling;

	public GenericTreeNode(Obj data){
		this.data = data;
		firstChild = null;
		firstSibling = null;
	}

	public void changeData(Obj data){
		this.data = data;
	}

	public Obj getData(){
		return data;
	}

	public GenericTreeNode getFChild(){
		return firstChild;
	}

	public GenericTreeNode getFSibling(){
		return firstSibling;
	}

	public void setFChild(GenericTreeNode child){
		firstChild = child;
	}
	public void setFSibling(GenericTreeNode sibling){
		firstSibling = sibling;
	}
}
