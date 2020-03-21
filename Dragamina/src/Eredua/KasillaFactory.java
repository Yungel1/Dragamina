package Eredua;

public class KasillaFactory {
    private static KasillaFactory nireKasillaFactory;
    private KasillaFactory(){
        
    }
    public static synchronized KasillaFactory getKasillaFactory(){
        if (nireKasillaFactory==null)nireKasillaFactory=new KasillaFactory();
        return nireKasillaFactory;
    }
    public Kasilla sortuKasilla(String mota, int pErrenka, int pZutabe){
        if(mota.equals("mina")||mota.equals("Mina")){
            return new Mina(pErrenka, pZutabe);
        }
        else if(mota.equals("zenbakizkoa")||mota.equals("Zenbakizkoa")){
            return new Zenbakizkoa(pErrenka, pZutabe);
        }
        else{
            return new Hutsa(pErrenka, pZutabe);
        }
    }
}
