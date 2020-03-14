package Eredua;

import java.util.Random;

public class Matrizea {
    private Kasilla[][] matrize;

    public Matrizea(int pErrenkadaKop,int pZutabeKop, int pZailtasuna){
    	
    	this.matrize = new Kasilla[pErrenkadaKop][pZutabeKop]; 
    	this.minakEsleitu(pZailtasuna);
    }
    
    
    private void minakEsleitu(int pZailtasuna){
    	
    	//Mina kopurua zutabe kopurua bider matrizearen zutabe kopurua izango da.
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
    		
    	
		 

		 /*
		 for (int i = 0; i < probak; i++){
			 
			 //Auzazko zenbakiak hartzen
			 a = ausazkoak.nextInt(grafokoElemGuztiak.length); // 0-tik (luzera-1)-rainoko zenbakiak
			 b = ausazkoak.nextInt(grafokoElemGuztiak.length); // 0-tik (luzera-1)-rainoko zenbakiak
		
			 //Ausazko elementuak hartzen grafotik
			 zine1 = grafokoElemGuztiak[a];
			 zine2 = grafokoElemGuztiak[b];
			 
			 if( !zine1.equals(zine2) ){ //Aurrebaldintza: ez da elementu berbera sartuko metodoan
			 
				 //konektatuta metodoaren exekuzio denbora aztertzen
				 System.out.print("\n"+i +". Konetatuta froga empirikoa: "+zine1.getIzena()+" eta "+zine2.getIzena()+
						 "konektatuta? ");
				 Stopwatch kronometroa = new Stopwatch();
				 erantz = gHau.konektatuta(zine1, zine2);
				 hartuta = kronometroa.elapsedTime();
				 System.out.println(erantz);
				 System.out.println("\nTardatutako denbora: "+hartuta+" segundu.\n");
				 
				 if( hartuta > maximoa ){
					 
					 maximoa = hartuta;
    	 */
    
}
