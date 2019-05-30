package domini;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

@SuppressWarnings("Duplicates")
public class Maquina extends Usuari {

    private ArrayList<ArrayList<IntPair>> matriu_camins = new ArrayList<ArrayList<IntPair>>();

    Map<ArrayList<IntPair>, Integer> map = new HashMap<ArrayList<IntPair>, Integer>();

    Map<Integer,Boolean> mapSolucio = new HashMap<Integer, Boolean>();

    public Maquina(String nom) {

        super(nom);
    }

    public Jugada condicioMap(Tauler T) {
        Jugada play = new Jugada();
        ArrayList<IntPair> aux = new ArrayList<>();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            ArrayList<IntPair> key = (ArrayList<IntPair>) it.next();
            aux = key;
            if (aux.size() == 0) {
            } else {
                Peca whatapiece = T.getPeca(aux.get(0).getX(), aux.get(0).getY());
                for (int z = 1; z < aux.size(); z += 2) {
                    if (T.getPeca(aux.get(z).getX(), aux.get(z).getY()) != null) {
                        if (T.getPeca(aux.get(z).getX(), aux.get(z).getY()).getColor() != whatapiece.getColor()) {
                            map.put(key, 1);
                            Jugada whataplay = new Jugada();
                            whataplay.setPeca(whatapiece);
                            whataplay.setPos_fin_x(aux.get(1).getX());
                            whataplay.setPos_fin_y(aux.get(1).getY());
                            return whataplay;
                        }
                    }

                }

            }

        }
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            ArrayList<IntPair> key = (ArrayList<IntPair>) it2.next();
            if (key.size() != 0) {
                Peca whatapiece = T.getPeca(key.get(0).getX(), key.get(0).getY());
                Jugada whataplay = new Jugada();
                whataplay.setPeca(whatapiece);
                whataplay.setPos_fin_x(key.get(1).getX());
                whataplay.setPos_fin_y(key.get(1).getY());
                return whataplay;
            }

        }
        return null;
    }

    public Jugada play(Peca[] peces_blanques, Peca[] peces_negres, int n, int i) {
        map.clear();
        Jugada jugada = new Jugada();
        Tauler t_temp = new Tauler(peces_blanques, peces_negres);
        t_temp.actualitzar();
        ArrayList<IntPair> camins = new ArrayList<>();
        int turn = 1;
        boolean b = backtrackingJugar(jugada, t_temp, i, n, camins, turn,true);
        //int puntuacio = 0;
        //boolean b = backtrackingHeuristic(jugada, t_temp, i, n, camins, turn, puntuacio);

        Jugada amazingplay = condicioMap(t_temp);

        if (b) return amazingplay;
        else return null;
    }

    public Jugada playPRO(Peca[] peces_blanques, Peca[] peces_negres, int n, int i) {
        map.clear();
        Jugada jugada = new Jugada();
        Tauler t_temp = new Tauler(peces_blanques, peces_negres);
        t_temp.actualitzar();
        ArrayList<IntPair> camins = new ArrayList<>();
        int turn = 1;
        int puntuacio = 0;
        boolean b = backtrackingHeuristic(jugada, t_temp, i, n, camins, turn, puntuacio);


        Jugada amazingplay = new Jugada();
        //ordenar map per value mes gran
        //map.entrySet().stream().sorted(comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        //Map<ArrayList<IntPair>, Integer> sorted = map.entrySet().stream().sorted(comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        Map<ArrayList<IntPair>, Integer> sorted = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        //amazingplay = primera posicio del map
        Iterator it2 = sorted.keySet().iterator();
        while (it2.hasNext()) {
            ArrayList<IntPair> key = (ArrayList<IntPair>) it2.next();
            if (key.size() != 0) {
                if(t_temp.getPeca(key.get(1).getX(), key.get(1).getY()) !=null){
                    Peca whatapiece = t_temp.getPeca(key.get(0).getX(), key.get(0).getY());
                    amazingplay.setPeca(whatapiece);
                    amazingplay.setPos_fin_x(key.get(1).getX());
                    amazingplay.setPos_fin_y(key.get(1).getY());
                    break;
                }
            }
        }
        if(amazingplay.getPeca() == null){
            Iterator it3 = sorted.keySet().iterator();
            while (it3.hasNext()) {
                ArrayList<IntPair> key = (ArrayList<IntPair>) it3.next();
                if (key.size() != 0) {
                    Peca whatapiece = t_temp.getPeca(key.get(0).getX(), key.get(0).getY());
                    amazingplay.setPeca(whatapiece);
                    amazingplay.setPos_fin_x(key.get(1).getX());
                    amazingplay.setPos_fin_y(key.get(1).getY());
                    break;
                }
            }
        }

        if (b) return amazingplay;
        else return null;
    }

    //comprova si la peca arriba al rei en n jugades
    private boolean backtracking(Jugada jugada, Tauler t, int i, int n, ArrayList<IntPair> cami, int turn, boolean seguirBacktrack) {
        Jugada jugada_old = new Jugada();
        if (i >= n) {
            ArrayList<IntPair> cami_aux = new ArrayList<>();
            cami_aux = (ArrayList<IntPair>) cami.clone();
            map.put(cami_aux, 0);
            return true;
        }
        if(!seguirBacktrack){
            return true;
        }
        if (turn == 1) {
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

                        Peca isRey = t.getPeca(newX,newY);
                        if(isRey != null){
                            if(isRey.getColor() == false && isRey.getId()==15){
                                seguirBacktrack =false;
                                mapSolucio.put(1,false);
                                i=1000000;
                                break;
                            }
                        }
                        //mou peça i actualitzem tauler
                        t.getPeces_negres()[j].setX(newX);
                        t.getPeces_negres()[j].setY(newY);
                        t.actualitzar();

                        backtracking(jugada, t, i, n, cami, turn = 0,seguirBacktrack);
                        //tornem a enrere
                        cami.remove(cami.size() - 1);
                        cami.remove(cami.size() - 1);
                        t.getPeces_negres()[j].setX(X_piece);
                        t.getPeces_negres()[j].setY(Y_piece);
                        t.actualitzar();
                    }
                    if(mapSolucio.get(1)!= null){
                        break;
                    }

                }
            }

        }
        if (turn == 0) {
            for (int j = 0; j < 16; j++) {
                if (t.getPeces_blanques()[j] != null) {
                    int X_piece = t.getPeces_blanques()[j].getX(); // old X
                    int Y_piece = t.getPeces_blanques()[j].getY(); // old Y
                    for (int z = 0; z < t.getPeces_blanques()[j].moviments.size(); z++) {
                        if (seguirBacktrack == false){
                            break;
                        }
                        int newX = t.getPeces_blanques()[j].moviments.get(z).getX();
                        int newY = t.getPeces_blanques()[j].moviments.get(z).getY();

                        t.getPeces_blanques()[j].setX(newX);
                        t.getPeces_blanques()[j].setY(newY);
                        t.actualitzar();

                        backtracking(jugada, t, i+1, n, cami, turn = 1,seguirBacktrack);

                        t.getPeces_blanques()[j].setX(X_piece);
                        t.getPeces_blanques()[j].setY(Y_piece);
                        t.actualitzar();
                    }
                    if(mapSolucio.get(1)!= null){
                        break;
                    }
                }
            }
        }
        return true;
    }

    private boolean backtrackingJugar(Jugada jugada, Tauler t, int i, int n, ArrayList<IntPair> cami, int turn, boolean seguirBacktrack) {
        Jugada jugada_old = new Jugada();
        if (i >= n) {
            ArrayList<IntPair> cami_aux = new ArrayList<>();
            cami_aux = (ArrayList<IntPair>) cami.clone();
            map.put(cami_aux, 0);
            return true;
        }
        if (turn == 1) {
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

                        backtracking(jugada, t, i, n, cami, turn = 0,seguirBacktrack);
                        //tornem a enrere
                        cami.remove(cami.size() - 1);
                        cami.remove(cami.size() - 1);
                        t.getPeces_negres()[j].setX(X_piece);
                        t.getPeces_negres()[j].setY(Y_piece);
                        t.actualitzar();
                    }
                }
            }

        }
        if (turn == 0) {
            for (int j = 0; j < 16; j++) {
                if (t.getPeces_blanques()[j] != null) {
                    int X_piece = t.getPeces_blanques()[j].getX(); // old X
                    int Y_piece = t.getPeces_blanques()[j].getY(); // old Y
                    for (int z = 0; z < t.getPeces_blanques()[j].moviments.size(); z++) {
                        if (seguirBacktrack == false){
                            break;
                        }
                        int newX = t.getPeces_blanques()[j].moviments.get(z).getX();
                        int newY = t.getPeces_blanques()[j].moviments.get(z).getY();

                        t.getPeces_blanques()[j].setX(newX);
                        t.getPeces_blanques()[j].setY(newY);
                        t.actualitzar();

                        backtracking(jugada, t, i+1, n, cami, turn = 1,seguirBacktrack);

                        t.getPeces_blanques()[j].setX(X_piece);
                        t.getPeces_blanques()[j].setY(Y_piece);
                        t.actualitzar();
                    }
                    if(mapSolucio.get(1)!= null){
                        break;
                    }
                }
            }
        }
        return true;
    }
    //
    private boolean backtrackingHeuristic(Jugada jugada, Tauler t, int i, int n, ArrayList<IntPair> cami, int turn,int puntuacio) {
        Jugada jugada_old = new Jugada();

        if (i == n || puntuacio >= 10000) {
            ArrayList<IntPair> cami_aux = new ArrayList<>();
            cami_aux = (ArrayList<IntPair>) cami.clone();;

            int puntuacioAux=0;
            for (int z = 1; z < cami_aux.size(); z += 2) {
                if (t.getPeca(cami_aux.get(z).getX(), cami_aux.get(z).getY()) != null) {
                    Peca isPeca = t.getPeca(cami_aux.get(z).getX(),cami_aux.get(z).getY());
                        if (isPeca.getColor() == true) {
                            puntuacioAux+=isPeca.getPunts();
                            map.put(cami_aux, puntuacioAux/i);
                        }
                }
            }

            return true;
        }

        if (turn == 1) {
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

                        Peca isPeca = t.getPeca(newX,newY);
                        //sumem la puntuacio d'aquest cami si la aux2
                        if(isPeca != null){
                            if (isPeca.getColor() == true) {
                                puntuacio += isPeca.getPunts();
                            }
                        }

                        //mou peça i actualitzem tauler
                        t.getPeces_negres()[j].setX(newX);
                        t.getPeces_negres()[j].setY(newY);
                        t.actualitzar();

                        backtrackingHeuristic(jugada, t, i, n, cami, turn = 0, puntuacio);

                        //tornem a enrere
                        cami.remove(cami.size() - 1);
                        cami.remove(cami.size() - 1);
                        t.getPeces_negres()[j].setX(X_piece);
                        t.getPeces_negres()[j].setY(Y_piece);
                        t.actualitzar();
                    }
                }
            }
        }
        if (turn == 0) {
            for (int j = 0; j < 16; j++) {
                if (t.getPeces_blanques()[j] != null) {
                    int X_piece = t.getPeces_blanques()[j].getX(); // old X
                    int Y_piece = t.getPeces_blanques()[j].getY(); // old y

                    for (int z = 0; z < t.getPeces_blanques()[j].moviments.size(); z++) {
                        int newX = t.getPeces_blanques()[j].moviments.get(z).getX();
                        int newY = t.getPeces_blanques()[j].moviments.get(z).getY();

                        t.getPeces_blanques()[j].setX(newX);
                        t.getPeces_blanques()[j].setY(newY);

                        t.actualitzar();

                        backtrackingHeuristic(jugada, t, i+1, n, cami, turn = 1,puntuacio);

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
        map.clear();
        mapSolucio.clear();
        Jugada jugada = new Jugada();
        Tauler t_temp = new Tauler(peces_negres, peces_blanques);
        t_temp.actualitzar();
        ArrayList<IntPair> camins = new ArrayList<>();
        int turn = 1;
        Boolean seguirBacktrack = new Boolean(true);
        boolean b = backtracking(jugada, t_temp, 0, n, camins, turn, seguirBacktrack);

        if(mapSolucio.get(1)!= null){
            return true;
        }
        else return false;
    }
}

