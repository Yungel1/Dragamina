package Eredua;

public class Estalita implements Estaltzea{
	
    public Estalita(){
        
    }
    
    public void desestali(Kasilla kas){
        kas.aldatuEgoera(new EzEstalita());
       // DragaminaGestorea.getNireDragaminaGestorea().printKasillak();
    }

    public void markatu(Kasilla kas) {
        kas.aldatuEgoera(new Bandera());
    }
}
