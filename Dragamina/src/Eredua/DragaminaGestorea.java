package Eredua;

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
    /*Proba metodoak*/
	/*public void printKasillak(){
		
		this.zelaia.printKasillak();
	}*/
}
