



public abstract class Peça {
    private int x;
    private int y;
    final private boolean es_blanca;

    //pol: private char tipus;  --> R si es rei, C si es cavall... No se si hauria de anar aqui pero aniria be tenir algo
    //per saber que es cada peça


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

    //public bool hihaPeça(int x, int y);
    //Pol: necessito una funció que em retorni si en una posicio X,Y hi ha una peça o no

    //public char getTipus (int x, int y); que retorni el tipus (rei, peo...) de la peça



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

