import java.util.*;


public class Tauler {
    //vector< vector<Cela> > tauler;
    public ArrayList<Peça> peces_blanques = new ArrayList<>();
    public ArrayList<Peça> peces_negres = new ArrayList<>();
    private final int files = 8;
    private final int columnes = 8;
    private Integer[][] Graella;

    public Peça getPeça(int x, int y) {
        for (Peça p : peces_blanques) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        for (Peça p : peces_negres) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }
}
