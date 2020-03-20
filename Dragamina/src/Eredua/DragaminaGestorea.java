package Eredua;

import java.util.Observable;

public class DragaminaGestorea extends Observable{
    private MinaZelaia zelaia;
    private static DragaminaGestorea nireGestorea;
    private DragaminaGestorea(){
        this.zelaia=FactoryZailtasuna.getNireFactoryZailtasuna().zelaiaSortu(1);//Hau bigarren sprintean aldatuko da
    }
    public static DragaminaGestorea getNireDragaminaGestorea(){
        if(nireGestorea==null)nireGestorea=new DragaminaGestorea();
        return nireGestorea;
    }
    public int getErrenkada(){
        return zelaia.getErrenkada();
    }
    public int getZutabea(){
        return zelaia.getZutabea();
    }
    public int aktibatutakoaKudeatu(int pErrenkada,int pZutabea){
        //-1 a 8
    }
    public Kasilla lortuKasilla(int pErrenkada,int pZutabea){
        
    }
}
