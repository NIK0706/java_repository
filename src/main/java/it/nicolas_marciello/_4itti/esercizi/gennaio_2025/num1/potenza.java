package it.nicolas_marciello._4itti.esercizi.gennaio_2025.num1;

public class potenza {
	protected int base;

	public potenza(int base){
		this.base = base;
	}

	public int pow(int potenza){
		int result = base;
		for(int i = 1; i < potenza; i++){
			result *= base;
		}
		return result;
	}

	public int powRecursive(int potenza){
		if(potenza == 1){
			return base;
		}else{
			return base * powRecursive(potenza - 1);
		}
	}

	public void cambiaBase(int base){
		this.base = base;
	}
}
