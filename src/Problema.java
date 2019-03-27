


public class Problema {



    //aixo passa de FEN a un tauler decente de personas
    public void conversio(string FEN){

        int tam = FEN.length();
        int x=0, y=0;
        for (int i = 0; i < tam; ++i) {


            switch(FEN[i]) {

                case '/':
                    ++y;
                    x = 0;
                case 'K':
                    Rey R = Rei(x,y,true);
                case 'k':
                    Rei r = Rei(x,y,false);
                case 'Q':
                    Reina re = Reina(x,y,true);
                case 'q':
                    Reina re = Reina(x,y,false);
                case 'R':
                    Torre T = Torre(x,y,true);
                case 'r':
                    Torre t = Torre(x,y,false);
                case 'B':
                    Alfil A = Alfil(x,y,true);
                case 'b':
                    Alfil a = Alfil(x,y,true);
                case 'N':
                    Cavall C = Cavall(x,y,true);
                case 'n':
                    Cavall c = Cavall(x,y,true);
                case 'P':
                    Peo P = Peo(x,y,true);
                case 'p':
                    Peo p = Peo(x,y,true);

                default:


            }
            ++x;
        }

    }

    public bool teSolucio() {

    }


}
