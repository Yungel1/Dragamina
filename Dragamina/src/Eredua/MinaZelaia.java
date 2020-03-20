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
    public Kasilla lortuKasilla(int pErrenkada,int pZutabea){
        return zelaia.lortuKasilla(pErrenkada, pErrenkada);
    }
    public void desestali(int pErrenka, int pZutabe){
        zelaia.desestali(pErrenka, pZutabe);
    }
}
