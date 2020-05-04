package Eredua;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;


public class ListaJokalariak {
    private static ListaJokalariak nireListaJokalariak;
    private ArrayList<Jokalaria> zerrenda;
    private Jokalaria unekoJokalaria;
    
    private ListaJokalariak(){
    	
    	this.unekoJokalaria = null;
    	this.zerrenda		= new ArrayList<Jokalaria>();
    }
    
    public static synchronized ListaJokalariak getNireListaJokalariak(){
        if(nireListaJokalariak==null){
            nireListaJokalariak=new ListaJokalariak();
        }
        return nireListaJokalariak;
    }
    public void sartuJokalaria(String pIzena){
        this.unekoJokalaria=new Jokalaria(pIzena);
    }
    
    private Iterator<Jokalaria> getIteradorea(){
    	
    	return this.zerrenda.iterator();
    }
    
    public void zerrendanSartu(){ //zerrenda ordenatuta egongo da, Puntuazioaren arabera.
    							  //Puntuaziorik handiena ezkerrean egongo da.

    	
    	/*IMPORTANTEA: PROBATU BEHAR DA WHILE-AREN BALDINTZAK ONDO DOAZELA JAKITEKO*/
    	int 		ezkerrekoErtza 		= 0;
    	int 		eskuinekoErtza 		= this.zerrenda.size()-1;
    	int 		sartzekoPosPosible	= 0;
    	boolean 	topatua				= false;
    	Jokalaria	konparatzekoa 		= null;
    	
    	if(ezkerrekoErtza<=eskuinekoErtza){//Hutsik ez badago
    		
    		sartzekoPosPosible		= (eskuinekoErtza + ezkerrekoErtza)/2;
    		konparatzekoa	= this.zerrenda.get(sartzekoPosPosible);
    	
	    	while( (ezkerrekoErtza < eskuinekoErtza) && !topatua){
	    		
	    		/* &&
				ezkerrekoErtza < this.zerrenda.size() && eskuinekoErtza <0  */
	    		
	    		if( this.unekoJokalaria.konparatu( konparatzekoa.getPuntuak() ) == -1){
	    			
	    			ezkerrekoErtza = sartzekoPosPosible;
	    			
	    			if(eskuinekoErtza-ezkerrekoErtza == 1){
	    				
	    				//Bi elementutako subarray batean aztertzerakoan ziklatzen ez geratzeko.
	    				ezkerrekoErtza++;
	    			}
	    		}
	    		
	    		else if(this.unekoJokalaria.konparatu( konparatzekoa.getPuntuak() ) == 0){
	    			
	    			topatua = true;
	    		}
	    		
	    		else{
	    			
	    			eskuinekoErtza = sartzekoPosPosible;
	    		}
	    		
	    		sartzekoPosPosible		= (eskuinekoErtza + ezkerrekoErtza)/2; //aztertuko den posizioa
	    																		//eguneratzen.
	    		konparatzekoa	= this.zerrenda.get(sartzekoPosPosible);
	    	}
	    	
	    	if( this.unekoJokalaria.konparatu( konparatzekoa.getPuntuak() ) < 1 ){
	    		//Zerrendan elementu bakarra dagoenean
	    		
	    		sartzekoPosPosible++;
	    	}
	    	
	    	
    	
    	}
    	
    	this.zerrenda.add(sartzekoPosPosible, this.unekoJokalaria);
    	//this.unekoJokalaria = null;							//partidaren amaieran
    } 
    
    
    
    /****************************PROBENTZAT ERABILITAKO METODOAK****************************/
    
    public void zerrendaResetProba(){
    	
    	this.zerrenda.clear();
    }
    
    public void zerrendaNulleraProba(){
    	
    	this.zerrenda = null;
    }
    
    public void jokalariaSartuProba(Jokalaria pJok){
    	
    	this.zerrenda.add(pJok);
    }
    
    public void jokalariakInprimatuProba(){
    	
    	Iterator<Jokalaria> itr		= this.getIteradorea();
    	Jokalaria			jokaHau	= null;
    	
    	System.out.println("\t\t\t**************JOKALARIEN RANKING-A*****************\n\n");
    	
    	while(itr.hasNext()){
    		
    		jokaHau = itr.next();
    		jokaHau.inprimatuJokalariarenInfo();
    	}
    	
    	System.out.println("\n\n");
    }
    
    public void unekoJokalariaAldatuProba(Jokalaria pJoka){
    	
    	this.unekoJokalaria=pJoka;
    }

    public void puntuazioaKalkulatu(int pErrenkada, int pZutabea, boolean pIrabaziDu) {//BERRIA
        unekoJokalaria.puntuazioaKalkulatu(pErrenkada,pZutabea,pIrabaziDu);
        this.zerrendanSartu();
    }
    
    public void sartuJokFitx(String pIzena,int pPuntuak){//BERRIA
        Jokalaria jok=new Jokalaria(pIzena);
        jok.setPuntuak(pPuntuak);
        this.zerrenda.add(jok);
    }
    
    public void idatziJokalariak(PrintWriter pOutputStream){//BERRIA
        
        Iterator<Jokalaria> itr = this.getIteradorea();
        Jokalaria jok = null;

        while( itr.hasNext() ){

            jok = itr.next();
            jok.idatziJokalaria(pOutputStream);
            
        }
    }
    
}
