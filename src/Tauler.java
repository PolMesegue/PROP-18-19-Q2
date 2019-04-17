import java.util.*;


public class Tauler {
    //vector< vector<Cela> > tauler;
    private Peca[] peces_blanques; // peces_blanques {p,p,p,p,p,p,p,p,a,a,c,c,t,t,d,r}
    private Peca[] peces_negres;
    //  private final int files = 8;
    //  private final int columnes = 8;
    //  private Integer[][] Graella;
    private Integer BnT, BnC, BnA, BnP, NnT, NnC, NnA, NnP;


    public Tauler() {

        peces_blanques = new Peca[16];
        peces_negres = new Peca[16];
        BnT = 0;
        BnC = 0;
        BnA = 0;
        BnP = 0;
        NnT = 0;
        NnC = 0;
        NnA = 0;
        NnP = 0;

    }

    //mourePeça
    public Tauler getTauler(char[] FEN) {


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
            peces_blanques[12 + BnT] = To;
            ++BnT;
        } else {
            peces_negres[12 + NnT] = To;
            ++NnT;
        }

    }

    public void setCavall(Cavall C) {

        if (C.esBlanca()) {
            peces_blanques[10 + BnC] = C;
            ++BnC;
        } else {
            peces_negres[10 + NnC] = C;
            ++NnC;
        }

    }

    public void setAlfil(Alfil A) {

        if (A.esBlanca()) {
            peces_blanques[8 + BnA] = A;
            ++BnA;
        } else {
            peces_negres[8 + NnA] = A;
            ++NnA;
        }

    }

    public void setPeo(Peo P) {

        if (P.esBlanca()) {
            peces_blanques[BnP] = P;
            ++BnP;
        } else {
            peces_negres[NnP] = P;
            ++NnP;
        }

    }


    public Peca getPeca(int x, int y) {
        for (Peca p : peces_blanques) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        for (Peca p : peces_negres) {
            if (p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    public char[] HumantoFEN(Peca[] peces_blanques, Peca[] peces_negres) {

        Peca[][] mapa = new Peca[8][8];

        int whiteX, whiteY, blackX, blackY;

        for (int i = 0; i < 16; ++i) {
            whiteX = peces_blanques[i].getX();
            whiteY = peces_blanques[i].getY();

            blackX = peces_negres[i].getX();
            blackY = peces_negres[i].getY();

            mapa[whiteX][whiteY] = peces_blanques[i];
            mapa[blackX][blackY] = peces_negres[i];



/*
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
*/
