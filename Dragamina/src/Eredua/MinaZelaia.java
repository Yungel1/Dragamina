package Eredua;

public abstract class MinaZelaia {
    protected Matrizea zelaia;
    protected int zailtasuna;
    
    public MinaZelaia(){
        
    }
    public int getErrenkada(){
        return zelaia.getErrenkadaKop();
    }
    public int getZutabea(){
        return zelaia.getZutabeKop();
    }
    public Kasilla lortuKasilla(int pErrenkada, int pZutabea){
        return zelaia.lortuKasilla(pErrenkada, pZutabea);
    }
    public void desestali(int pErrenka, int pZutabe){
        zelaia.desestali(pErrenka, pZutabe);
    }
    public int getMinaKop(){
        return this.getZutabea()*this.zailtasuna;
    }
    
    public int getUnekoMinak(){
    	
    	return this.zelaia.getUnekoMinak();
    }
    public void markatu(int pErrenkada,int pZutabea){
        zelaia.markatu(pErrenkada,pZutabea);
    }
    
    /*Proba metodoak*/
 	/*public void printKasillak(){
 		
 		this.zelaia.printKasillak();
 	}*/
}
