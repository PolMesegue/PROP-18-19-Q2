import java.util.*;


public abstract class Peca {
    private int id;
    private int x; //[0..7]
    private int y; //[0..7]
    private boolean es_blanca;
    protected ArrayList<IntPair> moviments = new ArrayList<IntPair>();

    //id setter
    public void setId(int id) {
        this.id=id;
    }

    //id getter
    public int getId() {
        return id;
    }

    //color setter
    public void setColor(boolean color) {
        this.es_blanca=color;
    }

    //color getter
    public boolean getColor() {return this.es_blanca; }

    //color getter blanca
    public boolean esBlanca() {
        return es_blanca;
    }

    //color getter negra
    public boolean esNegra() {
        return !es_blanca;
    }

    //x setter
    public void setX(int x) {
        this.x = x;
    }

    //y setter
    public void setY(int Y) {
        this.y = y;
    }

    //x getter
    public int getX() {
        return x;
    }

    //y getter
    public int getY() {
        return y;
    }

    public ArrayList<IntPair> getMoviments() {
        return moviments;
    }

    public abstract ArrayList<IntPair> posibles_moviments(Peca[] peces_blanques, Peca[] peces_negres);


}
