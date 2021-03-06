package Eredua;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;



public class Matrizea {
    private Kasilla[][] matrize;
    private int minaKop;
    private int banderaKop;
    private int estalitaKop;

    public Matrizea(int pErrenkadaKop,int pZutabeKop, int pZailtasuna){
    	this.matrize = new Kasilla[pErrenkadaKop][pZutabeKop]; 
    	this.estalitaKop=pErrenkadaKop*pZutabeKop;
    	this.minakEsleitu(pZailtasuna); //honetan minaKop hasieratuko da.
    	this.besteKasillakEsleitu();
    	this.banderaKop = 0;
    	this.printKasillak();
    }
    
    public Kasilla lortuKasilla(int pErrenkada,int pZutabea){
        return matrize[pErrenkada][pZutabea];
    }
    
    private void minakEsleitu(int pZailtasuna){
    	
    	//Mina kopurua zailtasuna bider matrizearen zutabe kopurua izango da.
    	this.minaKop = pZailtasuna*this.matrize[0].length;
    	int minaKopAux = this.minaKop;
    	
    	Random ausazkoak = new Random();
    	
    	//Behin eta berriro minak sartzeko erabiliko diren koordenatuak 
    	int errenka		= 0;
    	int zutabe  	= 0;
   
    	
    	
    	while(minaKopAux > 0 ){
    		
    		errenka = ausazkoak.nextInt(this.matrize.length);
    		zutabe	= ausazkoak.nextInt(this.matrize[0].length);
    		
    		if ( this.matrize[errenka][zutabe] == null){
    			
    			this.matrize[errenka][zutabe] = KasillaFactory.getKasillaFactory().sortuKasilla("mina", errenka, zutabe );
    			minaKopAux--;
    		}
    	}
    }
    
    
    private void besteKasillakEsleitu(){
    	
    	int zenbatMina = 0;
    	
    	for(int errenka = 0; errenka < this.matrize.length; errenka++){
    		
    		for(int zutabe = 0; zutabe < this.matrize[0].length; zutabe++){
    			
    			zenbatMina = 0;
    			
    			if( this.matrize[errenka][zutabe] == null ){// !( this.matrize[errenka][zutabe] instanceof Mina)
    				
    				zenbatMina = ingurukoMinaKopurua(errenka, zutabe);
    			
	    			if( zenbatMina == 0){
	    				
	    				this.matrize[errenka][zutabe] = KasillaFactory.getKasillaFactory().sortuKasilla("hutsa", errenka, zutabe );
	    			}
	    			
	    			else{
	    				
	    				this.matrize[errenka][zutabe] = KasillaFactory.getKasillaFactory().sortuKasilla("zenbakizkoa", errenka, zutabe );
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
    	
 
    	
    	return kopuru;
    }
    		
    	
    private int albokoaMinaDa(int pErrenka, int pZutabe){
    	
    	if( (pErrenka > -1) && (pZutabe > -1) && (pErrenka < this.matrize.length) &&
    			(pZutabe < this.matrize[0].length) &&(this.matrize[pErrenka][pZutabe] != null)&&
    			   this.matrize[pErrenka][pZutabe] instanceof Mina){
    		
    		return 1;
    	}
    	
    	else{ 
    		
    		return 0;
    	}
    }
    
    public boolean irabaziDu(){
        if(this.minaKop==this.estalitaKop){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int getErrenkadaKop(){
    	
    	return this.matrize.length;
    }
    
    
    
    public int getZutabeKop(){
    	
    	return this.matrize[0].length;
    }
    
    public void markatu(int pErrenkada,int pZutabea){
        
        if(this.matrize[pErrenkada][pZutabea].getEstaltzea() instanceof Bandera){
            this.banderaKop--;
        	this.matrize[pErrenkada][pZutabea].markatu();
        }
        
        else{
            if(this.banderaKop<this.minaKop){
                this.matrize[pErrenkada][pZutabea].markatu();
                this.banderaKop++;
            }
        }    
    }
    
    public int getUnekoMinak(){ 
    	return this.minaKop-this.banderaKop;  //Bistaren mina kopurua adierazten duen display-an jartzeko.
    } 
    
    
    public void desestali(int pErrenka, int pZutabe){
        
        if(this.matrize[pErrenka][pZutabe].getEstaltzea() instanceof Estalita){
            this.estalitaKop--;
            //System.out.println(this.estalitaKop);
        }
        
    	if((this.matrize[pErrenka][pZutabe] instanceof Hutsa) && 
    			!(this.matrize[pErrenka][pZutabe].getEstaltzea() instanceof Bandera) ){
    		
    		this.desestaliHutsaDenean(pErrenka, pZutabe);
    	}
    	
    	else{
    		this.matrize[pErrenka][pZutabe].desestali();
    	}	
    }
    
    private void desestaliHutsaDenean(int pErrenka, int pZutabe){
    	
    	//Honen bidez, alboko zenbakizkoak eta hutsak desestaliko dira.
    	
    	 Kasilla hasierakoa		  	= this.matrize[pErrenka][pZutabe];
    	 Kasilla unekoa	   			= hasierakoa;
    	 
    	 Queue<Kasilla>		aztertuGabeak		=	new LinkedList<Kasilla>();
		 HashSet<Kasilla>	aztertuak			=	new HashSet<Kasilla>();
		 
		 aztertuak.add(unekoa);
		 aztertuGabeak.add(unekoa);
		 
		 int errenka = pErrenka;
		 int zutabe	 = pZutabe;
		 
		 while ( !aztertuGabeak.isEmpty()){
		    	
		    	unekoa = aztertuGabeak.remove();
		    	
		    	errenka = unekoa.getErrenkada();
		    	zutabe  = unekoa.getZutabe();
		    	
		    	if(!(unekoa instanceof Mina)){
		    		
		    		unekoa.desestali();
		    		
		    		if(unekoa instanceof Hutsa){
			    		
			    		prozesatuHutsa(errenka-1, zutabe-1, aztertuGabeak, aztertuak);
			    		prozesatuHutsa(errenka-1, zutabe, aztertuGabeak, aztertuak);
			    		prozesatuHutsa(errenka-1, zutabe+1, aztertuGabeak, aztertuak);
			    		prozesatuHutsa(errenka, zutabe-1, aztertuGabeak, aztertuak);
			    		prozesatuHutsa(errenka, zutabe+1, aztertuGabeak, aztertuak);
			    		prozesatuHutsa(errenka+1, zutabe-1, aztertuGabeak, aztertuak);
			    		prozesatuHutsa(errenka+1, zutabe, aztertuGabeak, aztertuak);
			    		prozesatuHutsa(errenka+1, zutabe+1, aztertuGabeak, aztertuak);
		    		}

		    	}
		 }
    }

	
	 private void prozesatuHutsa( int pErrenka, int pZutabe, Queue<Kasilla>	 pAztertuGabeak, 
				HashSet<Kasilla> pAztertuak){


		if( (pErrenka > -1) && (pZutabe > -1) && (pErrenka < this.matrize.length) &&
    			(pZutabe < this.matrize[0].length)&&!pAztertuak.contains(this.matrize[pErrenka][pZutabe])&&
    			  (this.matrize[pErrenka][pZutabe]).getEstaltzea() instanceof Estalita){
		    this.estalitaKop--;
		    //System.out.println(this.estalitaKop);
			pAztertuGabeak.add(this.matrize[pErrenka][pZutabe]);
			pAztertuak.add(this.matrize[pErrenka][pZutabe]);
		
		}			
    }
	 
	 


/****************Hauek programaren frogak egiteko erabili dira**********/
	public void printKasillak(){
		
		for(int errenka = 0; errenka < this.matrize.length; errenka++){
			
			System.out.println("\n");
			for(int zutabe = 0; zutabe < this.matrize[0].length; zutabe++){
				
				if (this.matrize[errenka][zutabe] instanceof Mina){
					
					System.out.print("-1");
	    			}
				
				else if(this.matrize[errenka][zutabe] instanceof Zenbakizkoa){
					
					int zenbat = ((Zenbakizkoa)this.matrize[errenka][zutabe]).getZenb();
					
					switch(zenbat){
					
						case 1:
							System.out.print("1");
							break;
							
						case 2:
							System.out.print("2");
							break;
							
						case 3:
							System.out.print("3");
							break;
							
						case 4:
							System.out.print("4");
							break;
							
						case 5:
							System.out.print("5");
							break;
							
						case 6:
							System.out.print("6");
							break;
							
						case 7:
							System.out.print("7");
							break;
							
						case 8:
							System.out.print("8");
					}
				}
				
				else if(this.matrize[errenka][zutabe] instanceof Hutsa){
					
					System.out.print("0");
				}
					
				else{ 
					
					System.out.print("F\t");
					
				}
				
				if(this.matrize[errenka][zutabe].getEstaltzea() instanceof Estalita){
					System.out.print("E\t");
				}
				
				else{
					
					System.out.print("D\t");
				}
				
			}
		}
		
		System.out.println("\n");
		
	}
    	
 
    
    

		 


}
