


public class Cavall extends Peça{


    public Cavall(int x, int y, boolean es_blanca) {
        super(x,y,es_blanca);
    }

    @Override
    public boolean moviment_valid(int desti_x, int desti_y) {
        //codi moviment Cavall
        return false;
    }
}
