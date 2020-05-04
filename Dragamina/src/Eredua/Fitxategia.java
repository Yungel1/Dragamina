package Eredua;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fitxategia {
    
    private Scanner eskanerHau;
    
    private static Fitxategia nFitxategia=null;
    
    private Fitxategia(){

    }
    
    public static synchronized Fitxategia getNireFitxategia(){
        if(nFitxategia==null){
            nFitxategia=new Fitxategia();
        }
        return nFitxategia;
    }
    
    /**FITXATEGIAREN IRAKURKETA**/
    public void fitxategiaIreki(String pIrekitzekoa){

        String filename = pIrekitzekoa;
        try{

            eskanerHau = new Scanner(new File(filename));
        }

        catch(Exception e){

            System.out.println("Fitxategia ez da aurkitu.");
        }

    }
    
    public void fitxategiaIrakurri(){

        while(eskanerHau.hasNextLine()){

            String lerroa = this.eskanerHau.nextLine();
            String[] izenPuntu = lerroa.split("###");
            String izena = izenPuntu[0];
            int puntuak = Integer.parseInt(izenPuntu[1]);

            ListaJokalariak.getNireListaJokalariak().sartuJokFitx(izena,puntuak);
        }
            
    }
    
    public void jokalariakIdatzi(){
        
        String filename        = "fitxategia/jokalariak.txt";

        try{

            File file = new File (filename);
            PrintWriter outputStream = new PrintWriter(file);
            ListaJokalariak.getNireListaJokalariak().idatziJokalariak(outputStream);
            outputStream.flush();
            outputStream.close();
        }

        catch (FileNotFoundException e){

            e.printStackTrace();
        }
    }
}
