package Eredua;

public class Matrizea {
    private Kasilla[][] matrize;

    public Matrizea(int pErrenkadaKop,int pZutabeKop, int pZailtasuna){
    	
    	this.matrize = new Kasilla[pErrenkadaKop][pZutabeKop]; 
    	this.minakEsleitu(pZailtasuna);
    }
    
    
    private void minakEsleitu(int pZailtasuna){
    	
    	int minaKop = pZailtasuna*this.matrize[0].length;
    	
    }
}
