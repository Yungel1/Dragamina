package Eredua;

public abstract class MinaZelaia {
    protected Matrizea zelaia;
    protected int zailtasuna;
    public MinaZelaia(){
        
    }
    public int getErrenkada(){
        return zelaia.getErrenkadaKop();
    }
    public int getZutabea(){
        return zelaia.getZutabeKop();
    }
}
