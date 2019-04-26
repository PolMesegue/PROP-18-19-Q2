import java.util.*;

@SuppressWarnings("Duplicates")
public class Maquina extends Usuari {

    public Maquina(String nom){

        super(nom);
    }

    public Jugada play(Peca[] peces_blanques, Peca[] peces_negres, int n) {

        Jugada jugada = new Jugada();
        Tauler t_temp = new Tauler(peces_blanques,peces_negres);
        ArrayList<IntPair> visited = new ArrayList<>();
        boolean b = backtracking(jugada,t_temp,0,n,visited);
        if (b) return jugada;
        else return null;
    }

    private boolean isvisited(IntPair pos, ArrayList<IntPair> visited) {
        for (int i = 0; i < visited.size(); ++i) {
            if (pos == visited.get(i)) return true;
        }
        return false;
    }

    //comprova si la peca arriba al rei en n jugades
    private boolean backtracking(Jugada jugada, Tauler t, int i, int n,ArrayList<IntPair> visited) {
        if (i > n) return false;
        //MIRAR SI REI ESTA EN MAT
        else if (t.white_king_in_mate()) return true;
        else {
            boolean b = false;
            for (int j = 0; j < t.getPeces_negres().length; ++j) {
                IntPair actual_pos = new IntPair(t.getPeces_negres()[i].getX(),t.getPeces_negres()[i].getY());
                visited.add(actual_pos);
                for (int z = 0; z < t.getPeces_negres()[j].moviments.size(); ++z) {
                    if (!isvisited(t.getPeces_negres()[j].moviments.get(z),visited)) {
                        int oldX = t.getPeces_negres()[j].getX();
                        int oldY = t.getPeces_negres()[j].getY();
                        t.getPeces_negres()[j].setX(t.getPeces_negres()[j].moviments.get(z).getX());
                        t.getPeces_negres()[j].setY(t.getPeces_negres()[j].moviments.get(z).getY());
                        t.actualitzar();
                        jugada.setPeca(t.getPeces_negres()[j]);
                        jugada.setPos_fin_x(t.getPeces_negres()[j].moviments.get(z).getX());
                        jugada.setPos_fin_y(t.getPeces_negres()[j].moviments.get(z).getY());
                        b = backtracking(jugada,t,i+1,n,visited);
                        t.getPeces_negres()[j].setX(oldX);
                        t.getPeces_negres()[j].setY(oldY);
                        t.actualitzar();
                        if (b) break;
                    }
                }
                visited.clear();
            }
            return b;
        }
    }

    public boolean te_solucio(Peca[] peces_blanques, Peca[] peces_negres, int n) {
        Jugada jugada = new Jugada();
        Tauler t_temp = new Tauler(peces_negres,peces_blanques); //els parametres estan girats A PROPOSIT!
        ArrayList<IntPair> visited = new ArrayList<>();
        return backtracking(jugada,t_temp,0,n,visited);
    }
}

