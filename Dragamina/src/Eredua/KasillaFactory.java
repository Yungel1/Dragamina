package Eredua;

public class KasillaFactory {
    private KasillaFactory nireKasillaFactory;
    private KasillaFactory(){
        
    }
    public KasillaFactory getKasillaFactory(){
        if (nireKasillaFactory==null)nireKasillaFactory=new KasillaFactory();
        return nireKasillaFactory;
    }
    public Kasilla sortuKasilla(String mota){
        
    }
}
