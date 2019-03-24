



public abstract class Peça {
    private int x;
    private int y;
    final private boolean es_blanca;

    public Peça(int x, int y, boolean es_blanca) {
        this.es_blanca = es_blanca;
        this.x = x;
        this.y = y;
    }

    public boolean esBlanca() {
        return es_blanca;
    }

    public boolean esNegra() {
        return !es_blanca;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int Y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract boolean moviment_valid(Tauler t, int desti_x, int desti_y);


}

