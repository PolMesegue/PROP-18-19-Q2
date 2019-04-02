import java.util.*;


public class Tauler {
    //vector< vector<Cela> > tauler;
    public Peça[16] peces_blanques; // peces_blanques {p,p,p,p,p,p,p,p,a,a,c,c,t,t,d,r}
    public Peça[16] peces_negres;
    private final int files = 8;
    private final int columnes = 8;
  //  private Integer[][] Graella;
    private Integer nT = 0, nC = 0, nA = 0, nP = 0;


    /*
    private Collection<Problema> CollectionProblems;

    public BD_Problemas(){
        this.CollectionProblems = new ArrayList<>();
    } */

    public Tauler() {



    }

    //mourePeça
    //getTauler
/*
    public Peça(int x, int y, boolean es_blanca) {
        this.es_blanca = es_blanca;
        this.x = x;
        this.y = y;
    }
 */


    public void setPeca(Peça p) {

        if (p.esBlanca()) {

            switch(p.getTipus()) {

                case 'r': peces_blanques.add(15,p);

                case 'd': peces_blanques.add(14,p);

                case 't':
                    if (nT == 0;){
                    peces_blanques.add(12,p);
                    ++nT;
                    }
                    else {
                    peces_blanques.add(13,p);
                    }

                case 'c':;
                    if (nC == 0;){
                    peces_blanques.add(10,p);
                    ++nC;
                     }
                    else {
                    peces_blanques.add(11,p);
                     }

                case 'a':;
                    if (nA == 0;){
                    peces_blanques.add(8,p);
                    ++nA;
                     }
                    else {
                    peces_blanques.add(9,p);
                    }

                case 'p':;
                    peces_blanques.add(nP,p);
                    ++nP;
            }

        }


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

