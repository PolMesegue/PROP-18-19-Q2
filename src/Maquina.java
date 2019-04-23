import java.util.*;

@SuppressWarnings("Duplicates")
public class Maquina extends Usuari {

    public Maquina(String nom){

        super(nom);
    }

    public Jugada play(Peca[] peces_blanques, Peca[] peces_negres, boolean color) {

        //totes les jugades que pot fer un jugador
        ArrayList<IntPair> posiblesMoviments = new ArrayList<IntPair>();

        //maquina juga amb blanques color = true;
        if (color) {
            for (int i = 0; i < peces_blanques.length; ++i) {
                ArrayList<IntPair> moviments = peces_blanques[i].getMoviments();
                for (int j = 0; j < peces_blanques[i].getMoviments().size(); ++j) {
                    posiblesMoviments.add(moviments.get(j));
                }
            }
        }
        //maquina juga amb negres color = false
        else if (!color) {
            for (int i = 0; i < peces_negres.length; ++i) {
                ArrayList<IntPair> moviments = peces_negres[i].getMoviments();
                for (int j = 0; j < peces_negres[i].getMoviments().size(); ++j) {
                    posiblesMoviments.add(moviments.get(j));
                }
            }
        }
        Collections.shuffle(posiblesMoviments);
        //continua
        return null;
    }
}

