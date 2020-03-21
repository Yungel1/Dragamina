package Eredua;

public class Zenbakizkoa extends Kasilla {
    
    int zenb=0;
    
    public Zenbakizkoa(int pErrenka, int pZutabe){
    	
    	super(pErrenka, pZutabe);
    }
    public void setZenb(int pZenb){
        this.zenb=pZenb;
    }
    public int getZenb(){
        return this.zenb;
    }
    
    public  void printKasillaMota(){
    	
    	System.out.println("Zenbaki bat naiz");
    }
}
