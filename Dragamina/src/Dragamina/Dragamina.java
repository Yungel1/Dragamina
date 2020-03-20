package Dragamina;

import Bista.BistaDiagrama;
import Eredua.DragaminaGestorea;

public class Dragamina {

    public static void main(String[] args) {
        DragaminaGestorea dg=DragaminaGestorea.getNireDragaminaGestorea();
        BistaDiagrama bd=new BistaDiagrama(dg);
    }

}
