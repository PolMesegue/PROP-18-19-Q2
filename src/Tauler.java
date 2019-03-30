import java.util.*;


public class Tauler {
    //vector< vector<Cela> > tauler;
    public Peça[] peces_blanques;
    public Peça[] peces_negres;
    private final int files = 8;
    private final int columnes = 8;
    private Integer[][] Graella;

    //la graella no és de celes?
    //private Cela[][] Graella = new Cela[8][8];

    public void setPeça(Peça) {

    }

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

    public void HumantoFEN (Peça[] peces_blanques, Peça[] peces_negres ){

        Peça[][] mapa = new Peça[8][8];

        int whiteX, whiteY, blackX, blackY;

        for (int i = 0; i < 16; ++i) {
            whiteX = peces_blanques[i].getX();
            whiteY = peces_blanques[i].getY();

            blackX = peces_negres[i].getX();
            blackY = peces_negres[i].getY();

            mapa[whiteX][whiteY] = peces_blanques[i];
            mapa[blackX][blackY] = peces_blanques[i];


        }

        int iter = 0;
        for (int i = 0; i < 8; ++i) {
            int buit = 0;
            for (int j = 0; j < 8; ++j) {

                if (!mapa[i][j].hihaPeça()) ++buit;
                else {
                    if (buit != 0) {
                        FEN[iter] = (char) buit;
                        ++iter;
                    }
                    FEN[iter] = mapa[i][j].tipus();
                }
            }
            FEN[iter] = '/';
        } //falta el i el guionet i bla bla






    }


}

   /*
    private void removePeça(int x, int y) {
        Graella[x][y] = Cela::removePeça;

    }

    public void setPeça(Peça p, int x, int y) {
        Graella[x][y] = Cela::setPeça(p);
    }
    */

