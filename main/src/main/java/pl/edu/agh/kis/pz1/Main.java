package pl.edu.agh.kis.pz1;


import pl.edu.agh.kis.pz1.util.Czytelnik;
import pl.edu.agh.kis.pz1.util.Library;
import pl.edu.agh.kis.pz1.util.Pisarz;

public class Main {
    public static void main( String[] args ) {
        Library lib = new Library();

        for(int i = 0;i<8;i++){
            Czytelnik temp = new Czytelnik(lib);
            temp.start();
        }
        for(int i=0;i<3;i++){
            Pisarz temp = new Pisarz(lib);
            temp.start();
        }
        lib.start();

    }
}
