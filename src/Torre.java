import java.util.*;

@SuppressWarnings("Duplicates")
public class Torre extends Peca {

    public Torre(int i, int x, int y, boolean color) {
        setId(i);
        setX(x);
        setY(y);
        setColor(color);
        setValue(525);
    }

    public ArrayList<IntPair> posibles_moviments(Peca[] peces_blanques, Peca[] peces_negres) {
        //torre nomes es pot moure horitzontal i vertical
        Tauler t = new Tauler(peces_blanques,peces_negres);
        moviments.clear();
        int tempx =  this.getX() - 1; //movem a l'esquerra
        while (tempx >= 0) {
            if (t.getPeca(tempx, this.getY()) == null) {
                IntPair aux = new IntPair(tempx, this.getY());
                this.moviments.add(aux);
            }
            else if (t.getPeca(tempx, this.getY()).getColor() == this.getColor()) break;
            else {
                IntPair aux = new IntPair(tempx, this.getY());
                this.moviments.add(aux);
                break;
            }
            tempx--;
        }
        tempx =  this.getX() + 1; //movem dreta
        while (tempx < 8) {
            if (t.getPeca(tempx, this.getY()) == null) {
                IntPair aux = new IntPair(tempx, this.getY());
                this.moviments.add(aux);
            }
            else if (t.getPeca(tempx, this.getY()).getColor() == this.getColor()) break;
            else {
                IntPair aux = new IntPair(tempx, this.getY());
                this.moviments.add(aux);
                break;
            }
            tempx++;
        }
        int tempy = this.getY() + 1; //movem avall
        while (tempy >= 0) {
            if (t.getPeca(this.getX(), tempy) == null) {
                IntPair aux = new IntPair(this.getY(), tempy);
                this.moviments.add(aux);
            }
            else if (t.getPeca(this.getX(), tempy).getColor() == this.getColor()) break;
            else {
                IntPair aux = new IntPair(this.getX(), tempy);
                this.moviments.add(aux);
                break;
            }
            tempy--;
        }
        tempy = this.getY() - 1; //movem amunt
        while (tempy < 8) {
            if (t.getPeca(this.getX(), tempy) == null) {
                IntPair aux = new IntPair(this.getY(), tempy);
                this.moviments.add(aux);
            }
            else if (t.getPeca(this.getX(), tempy).getColor() == this.getColor()) break;
            else {
                IntPair aux = new IntPair(this.getX(), tempy);
                this.moviments.add(aux);
                break;
            }
            tempy++;
        }
        return this.moviments;
    }
}

//IGNORAR A PARTIR D'AQUI
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
