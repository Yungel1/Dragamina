package Eredua;

import java.util.ArrayList;

public class ListaJokalariak {
    private static ListaJokalariak nireListaJokalariak;
    private ArrayList<Jokalaria> zerrenda;
    private Jokalaria unekoJokalaria;
    
    private ListaJokalariak(){}
    
    public static synchronized ListaJokalariak getNireListaJokalariak(){
        if(nireListaJokalariak==null){
            nireListaJokalariak=new ListaJokalariak();
        }
        return nireListaJokalariak;
    }
    public void sartuJokalaria(String pIzena){
        this.unekoJokalaria=new Jokalaria(pIzena);
    }
    
    public void zerrendanSartu(){
        //bilaketa dikotomikoa
    }
    
}
