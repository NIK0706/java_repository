package it.nicolas_marciello._4itti.esercizi.gennaio_2025.num1;

public class Operazioni {
	protected int a;
	protected int b;

	public Operazioni(int a, int b){
		this.a = a;
		this.b = b;
	}

	public int sum(int a, int b){
		return a + b;
	}

	public int sub(int a, int b){
		return a - b;
	}

	public int mult(int a, int b){
		return a * b;
	}

	public int div(int a, int b){
		return a / b;
	}
}
