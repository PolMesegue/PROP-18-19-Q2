

import java.util.ArrayList;

public class Problema {

    private String FEN;
    private String ID;

    private char whoStarts;

    Problema(String FEN) {
        this.FEN = FEN;
    }

    public String getFEN() {
        return FEN;
    }

/*
   public char whoStarts() {
        return FEN[FEN.length() - 9];
    }
*/
    public void setID(String id) {
        this.ID = id;
    }

    public String getID() {
        return ID;
    }





    //PeoPeoPeoPeoPeoPeoPeoPeoAlfAlfCavCavTorTorReinaRei;

    //aixo passa de FEN a un tauler decente de personas
    public Tauler FENtoHuman() {

        char[] FEN = this.FEN.toCharArray();

        int BnP = 0, BnC = 8, BnA = 10, BnT = 12;
        int NnP = 0, NnC = 8, NnA = 10, NnT = 12;

        Tauler T = new Tauler();
        int tam = FEN.length;
        int x = 0, y = 0;
        for (int i = 0; i < tam; ++i) {

            switch (FEN[i]) {

                case '/':
                    ++y;
                    x = 0;
                case 'K':
                    Rei R = new Rei(15,x, y,true);
                    T.setRei(R);
                case 'k':
                    Rei r = new Rei(15,x, y, false);
                    T.setRei(r);
                case 'Q':
                    Reina D = new Reina(14,x, y, true);
                    T.setReina(D);
                case 'q':
                    Reina d = new Reina(14,x, y, false);
                    T.setReina(d);
                case 'R':
                    Torre To = new Torre(BnT,x, y, true);
                    T.setTorre(To);
                    ++BnT;
                case 'r':
                    Torre to = new Torre(NnT, x, y, false);
                    T.setTorre(to);
                    ++NnT;
                case 'B':
                    Alfil A = new Alfil(BnA,x, y, true);
                    T.setAlfil(A);
                    ++BnA;
                case 'b':
                    Alfil a = new Alfil(NnA,x, y, false);
                    T.setAlfil(a);
                    ++NnA;
                case 'N':
                    Cavall C = new Cavall(BnA,x, y, true);
                    T.setCavall(C);
                    ++BnA;
                case 'n':
                    Cavall c = new Cavall(NnA,x, y, false);
                    T.setCavall(c);
                    ++NnA;
                case 'P':
                    Peo P = new Peo(BnP,x, y, true);
                    T.setPeo(P);
                    ++BnP;
                case 'p':
                    Peo p = new Peo(NnP,x, y, false);
                    T.setPeo(p);
                    ++NnP;

                default:
                    if (FEN[i] == 'w') break;
                    ++x;

                    //sha de mirar mes casos
            }
        }

        return T;
    }
}











    //public bool teSolucio() {}

