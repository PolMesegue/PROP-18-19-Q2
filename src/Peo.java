import java.util.*;


public class Peo extends Peca {

    public Peo(int x, int y, boolean es_blanca) {
        super(x,y,es_blanca);
    }

    public boolean moviment_valid(Tauler t, int desti_x, int desti_y) {
        //codi moviment Peo
        return false;
    }
    // mata diferent
    public void matar(){

    }
}
