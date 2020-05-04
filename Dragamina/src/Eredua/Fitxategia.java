package Eredua;

public class Fitxategia {
    private static Fitxategia nFitxategia=null;
    
    private Fitxategia(){

    }
    
    public static synchronized Fitxategia getNireFitxategia(){
        if(nFitxategia==null){
            nFitxategia=new Fitxategia();
        }
        return nFitxategia;
    }
    
}
