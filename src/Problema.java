

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
                    setPeca(R);
                case 'k':
                    Rei r = new Rei(x,y,false);
                    setPeca(r);
                case 'Q':
                    Reina D = new Reina(x,y,true);
                    setPeca(D);
                case 'q':
                    Reina d = new Reina(x,y,false);
                    setPeca(d);
                case 'R':
                    Torre T = new Torre(x,y,true);
                    setPeca(T);
                case 'r':
                    Torre t = new Torre(x,y,false);
                    setPeca(T);
                case 'B':
                    Alfil A = new Alfil(x,y,true);
                    setPeca(A);
                case 'b':
                    Alfil a = new Alfil(x,y,false);
                    setPeca(a);
                case 'N':
                    Cavall C = new Cavall(x,y,true);
                    setPeca(R);
                case 'n':
                    Cavall c = new Cavall(x,y,false);
                    setPeca(R);
                case 'P':
                    Peo P = new Peo(x,y,true);
                    setPeca(R);
                case 'p':
                    Peo p = new Peo(x,y,false);
                    setPeca(R);

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
