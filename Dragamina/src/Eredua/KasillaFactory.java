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
        if(mota.equals("mina")||mota.equals("Mina")){
            return new Mina();
        }
        else if(mota.equals("zenbakizkoa")||mota.equals("Zenbakizkoa")){
            return new Zenbakizkoa();
        }
        else{
            return new Hutsa();
        }
    }
}
