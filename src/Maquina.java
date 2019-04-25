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
    private boolean backtracking(Jugada jugada, IntPair pos_rei, Tauler t, int i, int n) {
        if (i > n) return false;
        //MIRAR SI REI ESTA EN MAT
        else if (t.white_king_in_mate()) return true;
        else {
            boolean b = false;
            for (int j = 0; j < t.getPeces_blanques().length; ++j) {
                ArrayList<IntPair> visited = new ArrayList<>();
                IntPair actual_pos = new IntPair(t.getPeces_blanques()[i].getX(),t.getPeces_blanques()[i].getY());
                visited.add(actual_pos);
                for (int z = 0; z < t.getPeces_blanques()[j].moviments.size(); ++z) {
                    if (!isvisited(t.getPeces_blanques()[j].moviments.get(z),visited)) {
                        t.getPeces_blanques()[j].setX(t.getPeces_blanques()[j].moviments.get(z).getX());
                        t.getPeces_blanques()[j].setY(t.getPeces_blanques()[j].moviments.get(z).getY());
                        t.actualitzar();
                        jugada.setPeca(t.getPeces_blanques()[j]);
                        jugada.setPos_fin_x(t.getPeces_blanques()[j].moviments.get(z).getX());
                        jugada.setPos_fin_y(t.getPeces_blanques()[j].moviments.get(z).getY());
                        b = backtracking(jugada,pos_rei,t,i+1,n);
                        if (b) break;
                    }
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
        boolean b = false;
        Tauler t_temp = new Tauler(peces_blanques,peces_negres);
        return backtracking(jugada,rei_pos,t_temp,0,n);
    }
}

