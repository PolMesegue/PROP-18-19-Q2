

public class Jugada {
    private Peca peca;
    private int pos_fin_x;
    private int pos_fin_y;

    Jugada(Peca peca, int pos_fin_x, int pos_fin_y) {
        this.peca = peca;
        this.pos_fin_x = pos_fin_x;
        this.pos_fin_y = pos_fin_y;
    }

    public int getPos_fin_x() {
        return pos_fin_x;
    }

    public int getPos_fin_y() {
        return pos_fin_y;
    }
}
