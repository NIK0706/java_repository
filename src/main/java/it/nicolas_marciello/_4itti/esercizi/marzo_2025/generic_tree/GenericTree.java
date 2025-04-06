package it.nicolas_marciello._4itti.esercizi.marzo_2025.generic_tree;

public class GenericTree{
	protected GenericTreeNode root;

	public GenericTree(){
		root = null;
	}

	public void visitaAnticipata(GenericTreeNode root){
		if(root == null){
			return;
		}
		root.getData().printObj();
		if(root.getFChild() != null){
			visitaAnticipata(root.getFChild());
		}
		if(root.getFSibling() != null){
			visitaAnticipata(root.getFSibling());
		}
	}

	public void visitaDifferita(GenericTreeNode root){
		if(root == null){
			return;
		}
		if(root.getFChild() != null){
			visitaDifferita(root.getFChild());
		}
		root.getData().printObj();
		if(root.getFSibling() != null){
			visitaDifferita(root.getFSibling());
		}
	}
}
