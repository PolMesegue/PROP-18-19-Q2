


public class Peo extends Peça {

    public Peo(int x, int y, boolean es_blanca) {
        super(x,y,es_blanca);
    }


    @Override
    public boolean moviment_valid(int desti_x, int desti_y) {
        //codi moviment Peo
        return false;
    }
    // mata diferent
    public void matar(){

    }
}
