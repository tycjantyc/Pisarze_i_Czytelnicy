package pl.edu.agh.kis.pz1.util;

public class Pisarz extends Thread{

    public static final  String typ = "pisarz";
    static int numer = 0;
    int wlasnyNumer = -1;
    boolean wBibliotece = false;
    int ellapsedTime = 0;

    Library library;

    public Pisarz(Library lib){
        this.library = lib;
    }

    @Override
    public void run() {
        numer++;
        wlasnyNumer = numer;
        library.requestWrite(this);
        while (true) {

            try {
                if(ellapsedTime>2){
                    wychodze();
                    library.finishWrite();
                    library.numer_tury = 0;
                    break;
                }
                if(wBibliotece){
                    czytam();
                    ellapsedTime++;
                }
                else{

                    czekam();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void zmienStatus() {
        wBibliotece = !wBibliotece;
    }
    public void czytam(){
        System.out.println("Pisarz nr "+wlasnyNumer+":Piszę");
    }
    public void czekam(){
        System.out.println("Pisarz nr "+wlasnyNumer+":Chce wejsc do czytelni");
    }
    public void wychodze(){
        System.out.println("Pisarz nr "+wlasnyNumer+":Wychodze z czytelni");
    }
}
