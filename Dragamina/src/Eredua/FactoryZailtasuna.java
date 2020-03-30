package Eredua;

public class FactoryZailtasuna {
    private static FactoryZailtasuna nireFactoryZail;
    private FactoryZailtasuna(){
        
    }
    public static synchronized FactoryZailtasuna getNireFactoryZailtasuna(){
        if(nireFactoryZail==null)nireFactoryZail=new FactoryZailtasuna();
        return nireFactoryZail;
    }
    public MinaZelaia zelaiaSortu(int pZailtasuna){
        switch(pZailtasuna){
        case(1):
            return new ZelaiErreza();
        case(2):
            return new ZelaiErtaina();
        default:
            return new ZelaiZaila();
        }
    }
}
