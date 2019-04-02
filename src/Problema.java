

import java.util.ArrayList;

public class Problema {

    private char[] FEN;
    private String ID;

    private char whoStarts;

    Problema (char[] FEN){
        this.FEN=FEN;
    }

    public char whoStarts() {
        return FEN[FEN.length - 9];
    }



    public String getID() { return ID;}

    //PeoPeoPeoPeoPeoPeoPeoPeoAlfAlfCavCavTorTorReinaRei;

    //aixo passa de FEN a un tauler decente de personas
    public void FENtoHuman(){

        Tauler T =
        int tam = FEN.length;
        int x=0, y=0;
        for (int i = 0; i < tam; ++i) {

            switch(FEN[i]) {

                case '/':
                    ++y;
                    x = 0;
                case 'K':
                    Rei R = new Rei(x,y,true);
                    T.setRei(R);
                case 'k':
                    Rei r = new Rei(x,y,false);
                    T.setRei(r);
                case 'Q':
                    Reina D = new Reina(x,y,true);
                    T.setReina(D);
                case 'q':
                    Reina d = new Reina(x,y,false);
                    T.setReina(d);
                case 'R':
                    Torre To = new Torre(x,y,true);
                    T.setTorre(To);
                case 'r':
                    Torre t = new Torre(x,y,false);
                    T.setTorre(to);
                case 'B':
                    Alfil A = new Alfil(x,y,true);
                    T.setAlfil(A);
                case 'b':
                    Alfil a = new Alfil(x,y,false);
                    T.setAlfil(a);
                case 'N':
                    Cavall C = new Cavall(x,y,true);
                    T.setCavall(C);
                case 'n':
                    Cavall c = new Cavall(x,y,false);
                    T.setCavall(c);
                case 'P':
                    Peo P = new Peo(x,y,true);
                    T.setPeo(P);
                case 'p':
                    Peo p = new Peo(x,y,false);
                    T.setPeo(p);

                default:
                    if (FEN[i] == '-') break;
                    ++x;

                    //sha de mirar mes casos
            }
        }

    }









    } // aa

/*
    public bool teSolucio() {
//ni idea
        bool kek = true;
        return kek;
    }
    */


}
