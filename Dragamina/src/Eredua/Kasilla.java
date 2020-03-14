package Eredua;

abstract class Kasilla {
    private Estaltzea egoera;
    public Kasilla(){
        egoera=new Estalita();
    }
    public void aldatuEgoera(Estaltzea pEgoera){
        this.egoera=pEgoera;
    }
    public void desestali(){
        egoera.desestali();
        if(egoera instanceof Estalita){//DUDAK
            this.aldatuEgoera(new EzEstalita());
        }
    }
}
