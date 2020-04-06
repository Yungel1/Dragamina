package Eredua;

public class Jokalaria {
    private int puntuak;
    private String izena;
    
    public Jokalaria(String pIzena){
        this.izena=pIzena;
        this.puntuak=0;
    }
    
    public void setPuntuak(int pPuntuak){
        this.puntuak=pPuntuak;
    }
    
    public int getPuntuak(){
    	
        return this.puntuak;
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
}
