

import java.util.ArrayList;

public class Problema {

    private char[] FEN;
    private String ID;

    private char whoStarts;

    Problema (char[] FEN){
        this.FEN=FEN;
    }
 //probva

    public char whoStarts() {

        return FEN[FEN.length - 9];

    }

    public String getID() { return ID;}

    //PeoPeoPeoPeoPeoPeoPeoPeoAlfAlfCavCavTorTorReinaRei;

    //aixo passa de FEN a un tauler decente de personas
    public void FENtoHuman(){

        int tam = FEN.length;
        int x=0, y=0;
        for (int i = 0; i < tam; ++i) {

            switch(FEN[i]) {

                case '/':
                    ++y;
                    x = 0;
                case 'K':
                    Rei R = new Rei(x,y,true);
                    setPeça(R);
                case 'k':
                    Rei r = new Rei(x,y,false);
                    setPeça(r);
                case 'Q':
                    Reina D = new Reina(x,y,true);
                    setPeça(D);
                case 'q':
                    Reina d = new Reina(x,y,false);
                    setPeça(d);
                case 'R':
                    Torre T = new Torre(x,y,true);
                    setPeça(T);
                case 'r':
                    Torre t = new Torre(x,y,false);
                    setPeça(T);
                case 'B':
                    Alfil A = new Alfil(x,y,true);
                    setPeça(A);
                case 'b':
                    Alfil a = new Alfil(x,y,false);
                    setPeça(a);
                case 'N':
                    Cavall C = new Cavall(x,y,true);
                    setPeça(R);
                case 'n':
                    Cavall c = new Cavall(x,y,false);
                    setPeça(R);
                case 'P':
                    Peo P = new Peo(x,y,true);
                    setPeça(R);
                case 'p':
                    Peo p = new Peo(x,y,false);
                    setPeça(R);

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
