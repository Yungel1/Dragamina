package Eredua;

import java.util.ArrayList;
import java.util.Iterator;


public class ListaJokalariak {
    private static ListaJokalariak nireListaJokalariak;
    private ArrayList<Jokalaria> zerrenda;
    private Jokalaria unekoJokalaria;
    
    private ListaJokalariak(){}
    
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
    
    public void zerrendanSartu(){ //zerrenda ordenatuta egongo da

    	int 		ezkerrekoErtza 		= 0;
    	int 		eskuinekoErtza 		= this.zerrenda.size()-1;
    	int 		unekoPos	   		= 0;
    	boolean 	topatua				= false;
    	Jokalaria	konparatzekoa 		= null;
    	
    	while( (ezkerrekoErtza < eskuinekoErtza) && !topatua ){
    		
    		unekoPos		= (eskuinekoErtza+ezkerrekoErtza)/2;
    		konparatzekoa	= this.zerrenda.get(unekoPos);
    		
    		if( this.unekoJokalaria.konparatu( konparatzekoa.getPuntuak() ) == -1){
    			
    			eskuinekoErtza = unekoPos;
    		}
    		
    		else if(this.unekoJokalaria.konparatu( konparatzekoa.getPuntuak() ) == 0){
    			
    			topatua = true;
    		}
    		
    		else{
    			
    			ezkerrekoErtza = unekoPos;
    		}
    	}
    	
    	this.zerrenda.add(unekoPos, this.unekoJokalaria);
    	this.unekoJokalaria = null;							//partidaren amaieran
    }
    
}
