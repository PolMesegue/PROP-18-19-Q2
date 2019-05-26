package domini;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Maquina extends Usuari {

    public Maquina(String nom){

        super(nom);
    }

    public Jugada play(Peca[] peces_blanques, Peca[] peces_negres, int n) {

        Jugada jugada = new Jugada();
        for (int i = 0; i < 16; ++i) {
            if (peces_negres[i] != null) {
                jugada.setPeca(peces_negres[i]);
                jugada.setPos_fin_x(peces_negres[i].getX());
                jugada.setPos_fin_y(peces_negres[i].getY());
                break;
            }
        }
        Tauler t_temp = new Tauler(peces_blanques,peces_negres);
        t_temp.actualitzar();
        boolean b = backtracking(jugada,t_temp,0,n);
        if (b) return jugada;
        else return null;
    }

    private boolean isvisited(IntPair pos, ArrayList<IntPair> visited) {
        for (int i = 0; i < visited.size(); ++i) {
            if (pos.getX() == visited.get(i).getX() && pos.getY() == visited.get(i).getY()) return true;
        }
        return false;
    }

    //comprova si la peca arriba al rei en n jugades
    private boolean backtracking(Jugada jugada, Tauler t, int i, int n) {
        Jugada jugada_old = new Jugada();
        if (i > n) return false;
        //MIRAR SI REI ESTA EN MAT
        if (jugada.getPeca().getX() == t.getPeces_blanques()[15].getX() && jugada.getPeca().getY() == t.getPeces_blanques()[15].getY()) return true;
        else {
            boolean b = false;
            for (int j = 0; j < t.getPeces_negres().length; ++j) {
                if (t.getPeces_negres()[j] != null) {
                    IntPair actual_pos = new IntPair(t.getPeces_negres()[j].getX(), t.getPeces_negres()[j].getY());
                    t.actualitzar();
                    jugada.setPeca(t.getPeces_negres()[j]);
                    for (int z = 0; z < t.getPeces_negres()[j].moviments.size(); ++z) {
                            // Save old position to restore it after the recursive call
                            int oldX = t.getPeces_negres()[j].getX();
                            int oldY = t.getPeces_negres()[j].getY();
                            jugada_old.setPos_fin_x(oldX);
                            jugada_old.setPos_fin_y(oldY);

                            // Get the movement from the possible movement list
                            int newX = t.getPeces_negres()[j].moviments.get(z).getX();
                            int newY = t.getPeces_negres()[j].moviments.get(z).getY();

                            // Generate the play and move the pieces
                            //jugada.setPeca(t.getPeces_negres()[j]);
                            jugada.setPos_fin_x(newX);
                            jugada.setPos_fin_y(newY);

                            //mou la peça
                            t.getPeces_negres()[j].setX(newX);
                            t.getPeces_negres()[j].setY(newY);
                            t.actualitzar();

                            // Recursive call
                            b = backtracking(jugada, t, i + 1, n);

                            // Get back to the old state
                            jugada.setPos_fin_x(jugada_old.getPos_fin_x());
                            jugada.setPos_fin_y(jugada_old.getPos_fin_y());
                            t.getPeces_negres()[j].setX(oldX);
                            t.getPeces_negres()[j].setY(oldY);
                            t.actualitzar();
                            if (b) break;
                    }
                    if (b) break;
                }
            }
            return b;
        }

    }

    public boolean te_solucio(Peca[] peces_blanques, Peca[] peces_negres, int n) {
        Jugada jugada = new Jugada();
        for (int i = 0; i < 16; ++i) {
            if (peces_negres[i] != null) {
                jugada.setPeca(peces_negres[i]);
                jugada.setPos_fin_x(peces_negres[i].getX());
                jugada.setPos_fin_y(peces_negres[i].getY());
                break;
            }
        }
        Tauler t_temp = new Tauler(peces_negres,peces_blanques); //els parametres estan girats A PROPOSIT!
        t_temp.actualitzar();
        ArrayList<IntPair> visited = new ArrayList<>();
        return backtracking(jugada,t_temp,0,n);
    }
}

