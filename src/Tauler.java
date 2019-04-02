import java.util.*;


public class Tauler {
    //vector< vector<Cela> > tauler;
    public Peça[] peces_blanques; // peces_blanques {p,p,p,p,p,p,p,p,a,a,c,c,t,t,d,r}
    public Peça[] peces_negres;
  //  private final int files = 8;
  //  private final int columnes = 8;
  //  private Integer[][] Graella;
    private Integer BnT, BnC, BnA, BnP, NnT, NnC, NnA, NnP;


    /*
    private Collection<Problema> CollectionProblems;

    public BD_Problemas(){
        this.CollectionProblems = new ArrayList<>();
    } */

    public Tauler() {

        this.peces_blanques = new Peça[16];
        this.peces_negres = new Peça[16];
        this.BnT = 0;
        this.BnC = 0;
        this.BnA = 0;
        this.BnP = 0;
        this.NnT = 0;
        this.NnC = 0;
        this.NnA = 0;
        this.NnP = 0;

    }

    //mourePeça
    public Tauler getTauler() {

        return

    }


    public void setRei(Rei R) {

        if (R.esBlanca()) peces_blanques[15] = R;
        else peces_negres[15] = R;

    }
    public void setReina(Reina D) {

        if (D.esBlanca()) peces_blanques[14] = D;
        else peces_negres[14] = D;

    }

    public void setTorre(Torre To) {

        if (To.esBlanca()) {
            peces_blanques[12+BnT] = To;
            ++BnT;
        }
        else {
            peces_negres[12+NnT] = To;
            ++NnT;
        }

    }

    public void setCavall(Cavall C) {

        if (C.esBlanca()) {
            peces_blanques[10+BnC] = C;
            ++BnC;
        }
        else{
            peces_negres[10+NnC] = C;
            ++NnC;
        }

    }

    public void setAlfil(Alfil A) {

        if (A.esBlanca()){
            peces_blanques[8+BnA] = A;
            ++BnA;
        }
        else {
            peces_negres[8+NnA] = A;
            ++NnA;
        }

    }

    public void setPeo(Peo P) {

        if (P.esBlanca()){
            peces_blanques[BnP] = P;
            ++BnP;
        }
        else {
            peces_negres[NnP] = P;
            ++NnP;
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

    public char[] HumantoFEN (Peça[] peces_blanques, Peça[] peces_negres ){

        Peça[][] mapa = new Peça[8][8];

        int whiteX, whiteY, blackX, blackY;

        for (int i = 0; i < 16; ++i) {
            whiteX = peces_blanques[i].getX();
            whiteY = peces_blanques[i].getY();

            blackX = peces_negres[i].getX();
            blackY = peces_negres[i].getY();

            mapa[whiteX][whiteY] = peces_blanques[i];
            mapa[blackX][blackY] = peces_negres[i];


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

