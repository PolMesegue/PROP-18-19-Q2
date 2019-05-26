package domini;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Maquina extends Usuari {

    private ArrayList<ArrayList<IntPair>> matriu_camins = new ArrayList<ArrayList<IntPair>>();

    public Maquina(String nom){

        super(nom);
    }

    public Jugada condicio(Tauler jaume_diarrea) {
        for (int j = 0; j < matriu_camins.size(); j++) {
            ArrayList<IntPair> aux = matriu_camins.get(j); // 34 35, 35 36
            Peca whatapiece = jaume_diarrea.getPeca(aux.get(0).getX(), aux.get(0).getY());
            for (int z = 1; z < aux.size(); z++) {
                if (jaume_diarrea.getPeca(aux.get(z).getX(), aux.get(z).getY()) != null) {
                    if (jaume_diarrea.getPeca(aux.get(z).getX(), aux.get(z).getY()).getColor() != whatapiece.getColor()) {
                        Jugada whataplay = new Jugada();
                        whataplay.setPeca(whatapiece);
                        whataplay.setPos_fin_x(aux.get(1).getX());
                        whataplay.setPos_fin_y(aux.get(1).getY());
                        return whataplay;
                    }
                }
            }
        }
        return null;
    }


    public Jugada play(Peca[] peces_blanques, Peca[] peces_negres, int n) {

        Jugada jugada = new Jugada();
        Tauler t_temp = new Tauler(peces_blanques,peces_negres);
        t_temp.actualitzar();
        ArrayList<IntPair> camins = new ArrayList<>();
        int turn =1;
        boolean b = backtracking(jugada,t_temp,1,n,camins,turn);

        Jugada amazingplay = condicio(t_temp);
        if (b) return amazingplay;
        else return null;
    }

    private boolean isvisited(IntPair pos, ArrayList<IntPair> visited) {
        for (int i = 0; i < visited.size(); ++i) {
            if (pos.getX() == visited.get(i).getX() && pos.getY() == visited.get(i).getY()) return true;
        }
        return false;
    }

    //comprova si la peca arriba al rei en n jugades
    private boolean backtracking(Jugada jugada, Tauler t, int i, int n, ArrayList<IntPair> cami, int turn) {
        Jugada jugada_old = new Jugada();
        if(i >= n){
            if(!matriu_camins.contains(cami)) {
                ArrayList<IntPair> cami_aux = new ArrayList<>();
                cami_aux = (ArrayList<IntPair>) cami.clone();
                matriu_camins.add(cami_aux);
            }
            return true;
        }
        if(turn ==1) {
            for (int j = 0; j < 16; j++) {
                if (t.getPeces_negres()[j] != null) {
                    int X_piece = t.getPeces_negres()[j].getX(); // old X
                    int Y_piece = t.getPeces_negres()[j].getY(); // old Y
                    //guardar antiga
                    jugada_old.setPos_fin_x(X_piece);
                    jugada_old.setPos_fin_y(Y_piece);
                    // peça que tractem
                    jugada.setPeca(t.getPeces_negres()[j]);

                    for (int z = 0; z < t.getPeces_negres()[j].moviments.size(); z++) {
                        //torre al 0 0
                        int newX = t.getPeces_negres()[j].moviments.get(z).getX();
                        int newY = t.getPeces_negres()[j].moviments.get(z).getY();
                        // 01 02 03 04 05 06 07
                        //set new posicio
                        jugada.setPos_fin_x(newX); //posicio nova peça
                        jugada.setPos_fin_y(newY);
                        //gaurdem la jugada
                        IntPair aux = new IntPair();
                        aux.setX(X_piece);
                        aux.setY(Y_piece);

                        IntPair aux2 = new IntPair();
                        aux2.setX(newX);
                        aux2.setY(newY);

                        cami.add(aux);
                        cami.add(aux2);

                        //mou peça i actualitzem tauler
                        t.getPeces_negres()[j].setX(newX);
                        t.getPeces_negres()[j].setY(newY);
                        t.actualitzar();

                        backtracking(jugada, t, i, n, cami, turn = 0);
                        //tornem a enrere
                        cami.remove(cami.size()-1);
                        cami.remove(cami.size()-1);
                        t.getPeces_negres()[j].setX(X_piece);
                        t.getPeces_negres()[j].setY(Y_piece);
                        t.actualitzar();


                    }
                }
            }

        }
        if(turn ==0) {
            for (int j = 0; j < 16; j++) {
                if (t.getPeces_blanques()[j] != null) {
                    int X_piece = t.getPeces_blanques()[j].getX(); // old X
                    int Y_piece = t.getPeces_blanques()[j].getY(); // old Y
                    for (int z = 0; z < t.getPeces_blanques()[j].moviments.size(); z++) {

                        int newX = t.getPeces_blanques()[j].moviments.get(z).getX();
                        int newY = t.getPeces_blanques()[j].moviments.get(z).getY();

                        t.getPeces_blanques()[j].setX(newX);
                        t.getPeces_blanques()[j].setY(newY);
                        t.actualitzar();

                        backtracking(jugada, t, i+1, n, cami, turn = 1);

                        t.getPeces_blanques()[j].setX(X_piece);
                        t.getPeces_blanques()[j].setY(Y_piece);
                        t.actualitzar();
                    }
                }
            }
        }
        return true;
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
        ArrayList<IntPair> camins = new ArrayList<>();
        return backtracking(jugada,t_temp,0,n,camins,0);
    }
}

