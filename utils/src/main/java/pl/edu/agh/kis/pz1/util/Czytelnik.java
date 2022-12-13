package pl.edu.agh.kis.pz1.util;

public class Czytelnik extends Thread {
    static int numer = 0;
    public static final  String typ = "czytelnik";
    public int wlasnyNumer = -1;
    boolean wCzytelni = false;
    int ellapsedTime = 0;

    @Override
    public void run() {
        numer++;
        wlasnyNumer = numer;
        while (true) {

            try {
                if(ellapsedTime>2){
                    wychodze();
                    break;
                }
                if(wCzytelni){
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
        wCzytelni = !wCzytelni;
    }
    public void czytam(){
        System.out.println("Czytelnik nr "+wlasnyNumer+":Czytam");
    }
    public void czekam(){
        System.out.println("Czytelnik nr "+wlasnyNumer+":Chce wejsc do czytelni");
    }
    public void wychodze(){
        System.out.println("Czytelnik nr "+wlasnyNumer+":Wychodze z czytelni");
    }
}