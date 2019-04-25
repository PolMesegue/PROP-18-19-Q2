import java.util.*;

@SuppressWarnings("Duplicates")
public class Maquina extends Usuari {

    public Maquina(String nom){

        super(nom);
    }

    public Jugada play(Peca[] peces_blanques, Peca[] peces_negres, boolean color, int n) {

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
        Jugada jugada = new Jugada();
        ArrayList<IntPair> visited = new ArrayList<>();
        //backtracking(jugada,posiblesMoviments,0,n,visited);
        return null;
    }

    private boolean isvisited(IntPair pos, ArrayList<IntPair> visited) {
        for (int i = 0; i < visited.size(); ++i) {
            if (pos == visited.get(i)) return true;
        }
        return false;
    }

    //comprova si la peca arriba al rei en n jugades
    private boolean backtracking(Jugada jugada, IntPair pos_rei, Peca peca, int i, int n, ArrayList<IntPair> visited) {
        if (i > n) return false;
        else if (peca.getX() == pos_rei.getX() && peca.getY() == pos_rei.getY()) {
            jugada.setPeca(peca);
            jugada.setPos_fin_x(peca.getX());
            jugada.setPos_fin_y(peca.getY());
            return true;
        }
        else {
            boolean b = false;
            for (int j = 0; j < peca.moviments.size(); ++j) {
                if (!isvisited(peca.moviments.get(i),visited) || !b) {
                    visited.add(peca.moviments.get(i));
                    peca.setX(peca.moviments.get(i).getX());
                    peca.setY(peca.moviments.get(i).getY());
                    b = backtracking(jugada,pos_rei,peca,i+1,n,visited);
                }
            }
            return b;
        }
    }

    public boolean te_solucio(Peca[] peces_blanques, Peca[] peces_negres, int n) {

        IntPair rei_pos = new IntPair();
        for (int i = 0; i < peces_negres.length; ++i) {
            if (peces_negres[i] instanceof Rei) {
                rei_pos.setX(peces_negres[i].getX());
                rei_pos.setY(peces_negres[i].getY());
            }
        }
        Jugada jugada = new Jugada();
        ArrayList<IntPair> visited = new ArrayList<>();
        boolean b = false;
        for (int i = 0; i < peces_blanques.length; ++i) {
            Peca peca = peces_blanques[i];
            if (!b) b = backtracking(jugada,rei_pos,peca,0,n,visited);
        }
        return b;
    }
}

