package pl.edu.agh.kis.pz1.util;

import java.util.ArrayList;

public class Library {

    int max_liczba_czytelnikow = 5;
    int max_liczba_pisarzy = 1;

    Thread [] lista_osob_w_czytelni = new Thread[5];
    int ilosc_czytelnikow_obecnie = 0;
    boolean jest_pisarz = false;
    Thread [] lista_pisarzy_w_czytelni = new Thread[1];

    ArrayList<Thread> kolejka = new ArrayList<>();

    void requesRead(){

    }
    void finishRead(){

    }
    void requestWrite(){

    }
    void finishWrite(){

    }
    public void addToQueue(Thread t){
        kolejka.add(t);
    }

    void check(){
        for(Thread t: kolejka){

        }
    }
}
