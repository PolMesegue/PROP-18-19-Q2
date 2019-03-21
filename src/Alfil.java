


public class Alfil extends Peça {


    public Alfil(int x, int y, boolean es_blanca) {
        super(x,y,es_blanca);
    }

    @Override
    public boolean moviment_valid(int desti_x, int desti_y) {
        //codi moviment Alfil
        return false;
    }
}
