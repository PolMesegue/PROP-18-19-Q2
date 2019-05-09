package domini;

public class Jugada {
    private Peca peca;
    private int pos_fin_x;
    private int pos_fin_y;

    Jugada(){}

    Jugada(Peca peca, int pos_fin_x, int pos_fin_y) {
        this.peca = peca;
        this.pos_fin_x = pos_fin_x;
        this.pos_fin_y = pos_fin_y;
    }

    //getter de peça
    public Peca getPeca() { return peca; }

    //getter de pos_fin_x
    public int getPos_fin_x() {
        return pos_fin_x;
    }

    //getter de pos_fin_y
    public int getPos_fin_y() {
        return pos_fin_y;
    }

    //setter de pos_fin_x
    public void setPos_fin_x(int x) {
        this.pos_fin_x = x;
    }

    //setter de pos_fin_y
    public void setPos_fin_y(int y) {
        this.pos_fin_y = y;
    }

    //setter de peça
    public void setPeca(Peca p) {
        this.peca = p;
    }
}
