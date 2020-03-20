package Eredua;

import java.util.Random;

public class Matrizea {
    private Kasilla[][] matrize;

    public Matrizea(int pErrenkadaKop,int pZutabeKop, int pZailtasuna){
    	
    	this.matrize = new Kasilla[pErrenkadaKop][pZutabeKop]; 
    	this.minakEsleitu(pZailtasuna);
    	this.besteKasillakEsleitu(); //cambio para mikel
    }
    
    
    private void minakEsleitu(int pZailtasuna){
    	
    	//Mina kopurua zailtasuna bider matrizearen zutabe kopurua izango da.
    	int minaKop = pZailtasuna*this.matrize[0].length;
    	
    	Random ausazkoak = new Random();
    	
    	//Behin eta berriro minak sartzeko erabiliko diren koordenatuak 
    	int errenka		= 0;
    	int zutabe  	= 0;
   
    	
    	
    	while(minaKop != 0 ){
    		
    		errenka = ausazkoak.nextInt(this.matrize.length);
    		zutabe	= ausazkoak.nextInt(this.matrize[0].length);
    		
    		if ( this.matrize[errenka][zutabe] == null){
    			
    			this.matrize[errenka][zutabe] = KasillaFactory.getKasillaFactory().sortuKasilla("mina");
    			minaKop--;
    		}
    	}
    }
    
    
    private void besteKasillakEsleitu(){
    	
    	int zenbatMina = 0;
    	
    	for(int errenka = 0; errenka < this.matrize.length; errenka++){
    		
    		for(int zutabe = 0; zutabe < this.matrize[0].length; zutabe++){
    			
    			if( !( this.matrize[errenka][zutabe] instanceof Mina) ){
    				
    				zenbatMina = ingurukoMinaKopurua(errenka, zutabe);
    			
	    			if( zenbatMina == 0){
	    				
	    				this.matrize[errenka][zutabe] = new Hutsa();
	    			}
	    			
	    			else{
	    				
	    				this.matrize[errenka][zutabe] = new Zenbakizkoa();
	    				((Zenbakizkoa ) this.matrize[errenka][zutabe]).setZenb(zenbatMina);
	    			}
    			}
    		}
    	}
    }
    
    
    private int ingurukoMinaKopurua(int pErrenka, int pZutabe){
    	
    	int kopuru = 0;
    	
    	kopuru += albokoaMinaDa(pErrenka-1, pZutabe-1);
    	kopuru += albokoaMinaDa(pErrenka-1, pZutabe);
    	kopuru += albokoaMinaDa(pErrenka-1, pZutabe+1);
    	kopuru += albokoaMinaDa(pErrenka, pZutabe-1);
    	kopuru += albokoaMinaDa(pErrenka, pZutabe+1);
    	kopuru += albokoaMinaDa(pErrenka+1, pZutabe-1);
    	kopuru += albokoaMinaDa(pErrenka+1, pZutabe);
    	kopuru += albokoaMinaDa(pErrenka+1, pZutabe+1);
    	
    //jejejejeje
    	
    	return kopuru;
    }
    		
    	
    private int albokoaMinaDa(int pErrenka, int pZutabe){
    	
    	if( (pErrenka > -1) && (pZutabe > -1) && (pErrenka < this.matrize.length) &&
    			(pZutabe < this.matrize[0].length) && this.matrize[pErrenka][pZutabe] instanceof Mina){
    		
    		return 1;
    	}
    	
    	else{ 
    		
    		return 0;
    	}
    }
    
    
    public int getErrenkadaKop(){
    	
    	return this.matrize.length;
    }
    
    public int getZutabeKop(){
    	
    	return this.matrize[0].length;
    }
    
    
    /*
     * private void desestali(int pErrenka, int pZutabe){
     * 
     * 		
     * 
     * 		
     * }
     */
     
		 


}
