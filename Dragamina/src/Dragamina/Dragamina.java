package Dragamina;

import Bista.BistaDiagrama;
import Bista.BistaZailtasuna;
import Eredua.DragaminaGestorea;
import Eredua.Fitxategia;

public class Dragamina {

    public static void main(String[] args) {
        //DragaminaGestorea dg=DragaminaGestorea.getNireDragaminaGestorea();
        Fitxategia.getNireFitxategia().fitxategiaIreki("fitxategia/jokalariak.txt");
        Fitxategia.getNireFitxategia().fitxategiaIrakurri();
        BistaZailtasuna bd=new BistaZailtasuna();
    }

}
