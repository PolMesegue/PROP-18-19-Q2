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

        return FEN[FEN.size() - 9];

    }

    public String getID() { return ID;}

    //PeoPeoPeoPeoPeoPeoPeoPeoAlfAlfCavCavTorTorReinaRei;

    //aixo passa de FEN a un tauler decente de personas
    public void FENtoHuman(){

        int tam = FEN.size();
        int x=0, y=0;
        for (int i = 0; i < tam; ++i) {

            switch(FEN[i]) {

                case '/':
                    ++y;
                    x = 0;
                case 'K':
                    Rei R = new Rei(x,y,true);

                case 'k':
                    Rei r = new Rei(x,y,false);
                case 'Q':
                    Reina Re = new Reina(x,y,true);
                case 'q':
                    Reina re = new Reina(x,y,false);
                case 'R':
                    Torre T = new Torre(x,y,true);
                case 'r':
                    Torre t = new Torre(x,y,false);
                case 'B':
                    Alfil A = new Alfil(x,y,true);
                case 'b':
                    Alfil a = new Alfil(x,y,false);
                case 'N':
                    Cavall C = new Cavall(x,y,true);
                case 'n':
                    Cavall c = new Cavall(x,y,false);
                case 'P':
                    Peo P = new Peo(x,y,true);
                case 'p':
                    Peo p = new Peo(x,y,false);

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
