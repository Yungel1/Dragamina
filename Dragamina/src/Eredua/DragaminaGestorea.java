package Eredua;

import java.util.ArrayList;
import java.util.Observable;

public class DragaminaGestorea extends Observable{
    private MinaZelaia zelaia;
    private static DragaminaGestorea nireGestorea;
    private DragaminaGestorea(int pZailtasuna){
        this.zelaia=FactoryZailtasuna.getNireFactoryZailtasuna().zelaiaSortu(pZailtasuna);//Hau bigarren sprintean aldatuko da
    }
    public static DragaminaGestorea getNireDragaminaGestorea(int pZailtasuna){
        if(nireGestorea==null)nireGestorea=new DragaminaGestorea(pZailtasuna);
        return nireGestorea;
    }
    public int getErrenkada(){
        return zelaia.getErrenkada();
    }
    public int getZutabea(){
        return zelaia.getZutabea();
    }
    public boolean irabaziDu(){
        return this.zelaia.irabaziDu();
    }
    public int getUnekoMinak(){
    	return this.zelaia.getUnekoMinak();
    }
    
    public void aktibatutakoaKudeatu(int pErrenkada,int pZutabea){
        zelaia.desestali(pErrenkada, pZutabea);
        super.setChanged();
        super.notifyObservers();
    }
    public Kasilla lortuKasilla(int pErrenkada,int pZutabea){
        return zelaia.lortuKasilla(pErrenkada, pZutabea);
    }
    public int getMinaKop(){
        return zelaia.getMinaKop();
    }
    public void markatu(int pErrenkada,int pZutabea){
        zelaia.markatu(pErrenkada,pZutabea);
        super.setChanged();
        super.notifyObservers();
    }
    public void sartuJokalaria(String pIzena){
        ListaJokalariak.getNireListaJokalariak().sartuJokalaria(pIzena);
    }
    public void zerrendanSartu(){
        ListaJokalariak.getNireListaJokalariak().zerrendanSartu();
    }
    public void puntuazioaKalkulatu(){//METODO BERRIA
        ListaJokalariak.getNireListaJokalariak().puntuazioaKalkulatu(zelaia.getErrenkada(),zelaia.getZutabea(),this.irabaziDu());
    }
    
    public ArrayList<Jokalaria> getZerrenda(){//BERRIA
    	
    	return ListaJokalariak.getNireListaJokalariak().getZerrenda();
    }
    
    public void jokalariakIdatzi() {
    	
    	Fitxategia.getNireFitxategia().jokalariakIdatzi();    	
    	
    }
    
    public void erreseteatu(){
        int zailtasuna=this.zelaia.zailtasuna;
        nireGestorea=null;
        getNireDragaminaGestorea(zailtasuna);
        this.sartuJokalariaBerriro();
        
    }
    
    private void sartuJokalariaBerriro() {
    	
    	ListaJokalariak.getNireListaJokalariak().sartuJokalariaBerriro();
    	
    }
    /*Proba metodoak*/
	/*public void printKasillak(){
		
		this.zelaia.printKasillak();
	}*/
}
