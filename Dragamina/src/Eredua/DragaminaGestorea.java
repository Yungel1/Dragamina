package Eredua;

import java.util.Observable;

public class DragaminaGestorea extends Observable{
    private MinaZelaia zelaia;
    private static DragaminaGestorea nireGestorea;
    private DragaminaGestorea(){
        
    }
    public static DragaminaGestorea getNireDragaminaGestorea(){
        if(nireGestorea==null)nireGestorea=new DragaminaGestorea();
        return nireGestorea;
    }
    public int aktibatutakoaKudeatu(int pErrenkada,int pZutabea){
        //-1 a 8
    }
    private boolean minaDago(int pErrenkada,int pZutabea){
        
    }
    
}
