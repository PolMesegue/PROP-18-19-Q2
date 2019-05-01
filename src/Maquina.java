import java.util.*;

@SuppressWarnings("Duplicates")
public class Maquina extends Usuari {

    public Maquina(String nom){

        super(nom);
    }

    public Jugada play(Peca[] peces_blanques, Peca[] peces_negres, int n) {

        Jugada jugada = new Jugada();
        Tauler t_temp = new Tauler(peces_blanques,peces_negres);
        t_temp.actualitzar();
        ArrayList<IntPair> visited = new ArrayList<>();
        boolean b = backtracking(jugada,t_temp,0,n,visited);
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
    private boolean backtracking(Jugada jugada, Tauler t, int i, int n,ArrayList<IntPair> visited) {
        if (i > n) return false;
        //MIRAR SI REI ESTA EN MAT
        if (t.white_king_in_mate()) return true;
        else {
            boolean b = false;

            for (int j = 0; j < t.getPeces_negres().length; ++j) {
                if (t.getPeces_negres()[j] != null) {
                    IntPair actual_pos = new IntPair(t.getPeces_negres()[j].getX(), t.getPeces_negres()[j].getY());
                    visited.add(actual_pos);
                    t.actualitzar();
                        for (int z = 0; z < t.getPeces_negres()[j].moviments.size(); ++z) {
                            if (!isvisited(t.getPeces_negres()[j].moviments.get(z), visited)) {

                                // Save old position to restore it after the recursive call
                                int oldX = t.getPeces_negres()[j].getX();
                                int oldY = t.getPeces_negres()[j].getY();


                                // Regenerate possible movements (?)
                                //t.actualitzar();

                                // Move the piece
                                jugada.setPeca(t.getPeces_negres()[j]);

                                // Check that the play still exists
                                //if (t.getPeces_negres()[j].moviments.size() > z) {

                                // Get the movement from the possible movement list
                                int newX = t.getPeces_negres()[j].moviments.get(z).getX();
                                int newY = t.getPeces_negres()[j].moviments.get(z).getY();

                                // Generate the play and move the pieces
                                jugada.setPos_fin_x(newX);
                                jugada.setPos_fin_y(newY);

                                t.getPeces_negres()[j].setX(newX);
                                t.getPeces_negres()[j].setY(newY);

                                // Recursive call
                                b = backtracking(jugada, t, i + 1, n, visited);

                                // Get back to the old state
                                t.getPeces_negres()[j].setX(oldX);
                                t.getPeces_negres()[j].setY(oldY);

                                //t.actualitzar();

                                if (b) break;
                            }
                        }
                        if (b) break;
                        visited.clear();
                    }
                }
                return b;
            }

    }

    public boolean te_solucio(Peca[] peces_blanques, Peca[] peces_negres, int n) {
        Jugada jugada = new Jugada();
        Tauler t_temp = new Tauler(peces_negres,peces_blanques); //els aprametres estan girats A PROPOSIT!
        t_temp.actualitzar();
        ArrayList<IntPair> visited = new ArrayList<>();
        return backtracking(jugada,t_temp,0,n,visited);
    }
}

