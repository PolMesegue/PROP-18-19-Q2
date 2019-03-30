import java.util.ArrayList;

public class Problema {

    Private String FEN;


    Problema (String FEN){
        this.FEN=FEN;
    }


    //aixo passa de FEN a un tauler decente de personas
    public void FENtoHuman(){

        int tam = FEN.length();
        int x=0, y=0;
        for (int i = 0; i < tam; ++i) {

            char c = FEN.charAt(i);

            switch(c) {

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
                    if (c == '-') break;
                    ++x;

                    //sha de mirar mes casos



            }
        }

    }

    public void HumantoFEN (ArrayList<Peça> peces_blanques, ArrayList<Peça> peces_negres ){



    } // aa

/*
    public bool teSolucio() {
//ni idea
        bool kek = true;
        return kek;
    }
    */


}
