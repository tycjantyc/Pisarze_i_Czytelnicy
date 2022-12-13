package pl.edu.agh.kis.pz1;


import pl.edu.agh.kis.pz1.util.Czytelnik;
import pl.edu.agh.kis.pz1.util.Library;
import pl.edu.agh.kis.pz1.util.Pisarz;

public class Main {
    public static void main( String[] args ) {
        Library lib = new Library();

        for(int i = 0;i<8;i++){
            Czytelnik temp = new Czytelnik();
            temp.start();
            lib.addToQueue(temp);
        }
        for(int i=0;i<3;i++){
            Pisarz temp = new Pisarz();
            temp.start();
            lib.addToQueue(temp);
        }


    }
}
