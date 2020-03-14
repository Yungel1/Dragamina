package Eredua;

public class FactoryZailtasuna {
    private static FactoryZailtasuna nireFactoryZail;
    private FactoryZailtasuna(){
        
    }
    public static FactoryZailtasuna getNireFactoryZailtasuna(){
        if(nireFactoryZail==null)nireFactoryZail=new FactoryZailtasuna();
        return nireFactoryZail;
    }
    public MinaZelaia zelaiaSortu(int pZailtasuna){
        switch(pZailtasuna){
        default:
            return new ZelaiErreza();
        }
    }
}
