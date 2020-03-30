package Eredua;

public abstract class Kasilla {
	
    private Estaltzea egoera;
    protected int posErrenka;
    protected int posZutabe;
    
    public Kasilla(int pErrenka, int pZutabe){
    	
    	posErrenka = pErrenka;
    	posZutabe  = pZutabe;
        egoera=new Estalita();
    }
    
    public void aldatuEgoera(Estaltzea pEgoera){
        this.egoera=pEgoera;
    }
    
    public void desestali(){
        egoera.desestali(this);
    }
    
    public void markatu(){
        egoera.markatu(this);
    }
    
    public Estaltzea getEstaltzea(){
        return this.egoera;
    }
    
    public int getErrenkada(){
    	
    	return this.posErrenka;
    }
    
    public int getZutabe(){
    	
    	return this.posZutabe;
    }
    
    public abstract void printKasillaMota();
    	
   
}
