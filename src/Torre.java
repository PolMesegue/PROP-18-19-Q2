import java.util.*;


public class Torre extends Peca {

    public Torre(String i, int x, int y, boolean color) {
        setId(i);
        setX(x);
        setY(y);
        setColor(color);
    }

    public ArrayList<IntPair> posibles_moviments(Tauler t) {
        //torre nomes es pot moure horitzontal i vertical
        moviments.clear();
        int tempx =  this.getX();
        while (tempx >= 0) {
            if (t.getPeca(this.getX(), this.getY()) == null) {
                IntPair aux = new IntPair(this.getX(), this.getY());
                this.moviments.add(aux);
            }
        }


        return null;

    }
}


/*
Peca p_aux = t.getPeca(desti_x,desti_y);
        if (p_aux != null) {
            if (p_aux.esBlanca() && this.esBlanca()) return false;
            if (p_aux.esNegra() && this.esNegra()) return false;
        }

        //No es pot moure en linea diagonal
        if (this.getX() != desti_x && this.getY() != desti_y) return false;

        //No pot saltar peces
        if (desti_y > this.getY()) { //torre es mou avall
            int numero_moviments = Math.abs(desti_y - this.getY());
            for (int i = 0; i < numero_moviments; i++) {
                Peca p = t.getPeca(this.getX(), this.getY() + i);
                if (p != null) return false;
            }
        }
        if (desti_y < this.getY()) { //torre es mou amunt
            int numero_moviments = Math.abs(desti_y - this.getY());
            for (int i = 0; i < numero_moviments; i++) {
                Peca p = t.getPeca(this.getX(), this.getY() - i);
                if (p != null) return false;
            }
        }
        if (desti_x > this.getX()) { //torre es mou dreta
            int numero_moviments = Math.abs(desti_x - this.getX());
            for (int i = 0; i < numero_moviments; i++) {
                Peca p = t.getPeca(this.getX() + i, this.getY());
                if (p != null) return false;
            }
        }
        if (desti_x < this.getX()) { //torre es mou esquerra
            int numero_moviments = Math.abs(desti_x - this.getX());
            for (int i = 0; i < numero_moviments; i++) {
                Peca p = t.getPeca(this.getX() - i, this.getY());
                if (p != null) return false;
            }
        }

        return true;
    }
 */
