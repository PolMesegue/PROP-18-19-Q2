import java.util.ArrayList;

public class Problema {

    private char[] FEN;
    private String Id;


    Problema (char[] FEN){
        this.FEN=FEN;
    }
 //probva

    public String getId() { return Id;}

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
                    if (tmp != 0) {
                        FEN[iter] = buit;
                        ++iter;
                        FEN[iter] = mapa[i][j].tipus();
                    }
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
