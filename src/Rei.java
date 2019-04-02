import java.util.*;


public class Rei extends Peca {

    public Rei(int x, int y, boolean es_blanca) {
        super(x,y,es_blanca);
    }

    public void moviments(int posicio){

    }
    public void cami(int posini, int posfi){

    }

    public boolean moviment_valid(Tauler t, int desti_x, int desti_y) {
        //El Rei es pot moure a qualsevol cel·la a distancia 1 de la seva posicio actual

        //Si hi ha una peça aliada a la posició destí, no ens podem moure
        Peca p_aux = t.getPeca(desti_x,desti_y);
        if (p_aux != null) {
            if (p_aux.esBlanca() && this.esBlanca()) return false;
            if (p_aux.esNegra() && this.esNegra()) return false;
        }

        //tots els moviments a distancia 1 son valids
        int dist_x = Math.abs(desti_x - this.getX());
        int dist_y = Math.abs(desti_y - this.getY());
        if (dist_x == 1 && dist_y == 1) return true; //moviment diagonal
        if (dist_x == 1 && dist_y == 0) return true; //moviment horitzontal
        if (dist_x == 0 && dist_y == 1) return true; //moviment vertical
        return false; //qualsevol altre moviment no es valid
    }
}
