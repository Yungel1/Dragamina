package Eredua;

public class Mina extends Kasilla {
	
	private int errenkada;
	private int zutabe;
	
	public Mina(int pZutabe, int pErrenkada) {
		
		this.errenkada=pErrenkada;
		this.zutabe=pZutabe;
		
	}
	
	public int getZutabea() {
		
		return this.zutabe;
		
	}
	
	public int getErrenkada() {
		
		return this.errenkada;
	}

}
