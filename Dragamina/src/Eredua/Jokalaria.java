package Eredua;

import java.io.PrintWriter;

public class Jokalaria {
    private int puntuak;
    private String izena;
    private Kronometroa kron;
    
    public Jokalaria(String pIzena){
        if(pIzena.equals("")){
            this.izena="Ezezaguna";
        }
        else{
            this.izena=pIzena;
            this.puntuak=0;
        }
        kron=new Kronometroa();
    }
    
    public void setPuntuak(int pPuntuak){
        this.puntuak=pPuntuak;
    }
    
    public int getPuntuak(){
    	
        return this.puntuak;
    }
    
    public void puntuazioaKalkulatu(int pErrenkada, int pZutabea, boolean pIrabaziDu) {
        if(pIrabaziDu){
            int puntuazioa=(pErrenkada*pZutabea*1000)/(int)this.kron.pasatutakoDenbora();
            this.setPuntuak(puntuazioa);
        }
    }
    
    public void idatziJokalaria(PrintWriter pOS){
        pOS.print(this.izena+"###");
        pOS.println(this.puntuak);
    }
        
    public int konparatu(int pBestearenPuntuak){ //*****KLASE DIAGRAMAN EGUNERATU*********
    	
    	int emaitza = 0;
    	
    	//	-1	izango da puntuak < pBestea
    	//	0 	izango da berdinak badira
    	//	1	izango da puntuak > pBestea
    	
    	if (this.puntuak < pBestearenPuntuak){
    		
    		emaitza = -1;
    	}
    	
    	else if(this.puntuak == pBestearenPuntuak){
    		
    		emaitza = 0;
    	}
    	
    	else{
    		
    		emaitza = 1;
    	}
    	
    	return emaitza;
    }
    
	/****************************PROBENTZAT ERABILITAKO METODOAK****************************/
	
	public Jokalaria(String pIzen, int pPuntuak){ //Eraikitzaile hau testak errazteko egin da. Komentatuta geratuko da.
		
		this.izena   = pIzen;
		this.puntuak = pPuntuak;
	}
	
	public void inprimatuJokalariarenInfo(){
		
		System.out.print(this.izena);
		System.out.println("\t"+this.puntuak);
	}


}
