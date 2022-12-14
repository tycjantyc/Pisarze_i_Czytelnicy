package pl.edu.agh.kis.pz1.util;

import java.util.ArrayList;

public class Library {

    final int max_liczba_czytelnikow = 5;
    int ile_w_czytelni = 0;
    int numer_tury = 0;

    final int max_liczba_pisarzy = 1;
    boolean pisarz_w_czytelni = false;
    boolean ostatnio_byl_pisarz = true;



    ArrayList<Pisarz> kolejkaP = new ArrayList<>();
    ArrayList<Czytelnik> kolejkaCz = new ArrayList<>();

    void zmienkolej(){ostatnio_byl_pisarz = !ostatnio_byl_pisarz;}

    public void requestRead(Czytelnik c){
        kolejkaCz.add(c);
    }
    public void finishRead(){
        ile_w_czytelni--;
    }
    public void requestWrite(Pisarz p){
        kolejkaP.add(p);
    }
    public void finishWrite(){
        pisarz_w_czytelni = false;
    }

    public void start(){
        try{
            while(true) {

                if(numer_tury == 0 && !ostatnio_byl_pisarz){
                    zmienkolej();
                }
                if(numer_tury == 5 && ostatnio_byl_pisarz || ostatnio_byl_pisarz && kolejkaCz.isEmpty()){
                    zmienkolej();
                    //numer_tury = 0;
                }

                if(kolejkaCz.isEmpty() && kolejkaP.isEmpty()){
                    Thread.sleep(4000);
                    if(kolejkaCz.isEmpty() && kolejkaP.isEmpty()){
                        System.out.println("Koniec");
                        return;
                    }


                }
                if (ostatnio_byl_pisarz && ile_w_czytelni < max_liczba_czytelnikow && numer_tury != 5 && !kolejkaCz.isEmpty() && !pisarz_w_czytelni) {
                    kolejkaCz.get(0).zmienStatus();
                    kolejkaCz.remove(0);
                    ile_w_czytelni++;
                    numer_tury++;
                }
                if(!ostatnio_byl_pisarz && !pisarz_w_czytelni && !kolejkaP.isEmpty() && ile_w_czytelni == 0){
                    kolejkaP.get(0).zmienStatus();
                    pisarz_w_czytelni = true;
                    kolejkaP.remove(0);
                }

                Thread.sleep(50);
                //System.out.println("Osoby w czytelni: "+ile_w_czytelni);
                //System.out.println("Tura czytelnikow: "+ostatnio_byl_pisarz);
                //System.out.println("Numer tury: "+numer_tury);
                //System.out.println("Size kolejka: "+kolejkaCz.size());

            }
        }
        catch(java.lang.InterruptedException e){
            e.printStackTrace();
        }
    }
}
