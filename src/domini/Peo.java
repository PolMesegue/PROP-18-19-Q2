package domini;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Peo extends Peca {

    public Peo(int i, int x, int y, boolean color) {
        setId(i);
        setX(x);
        setY(y);
        setColor(color);
        //setValue(100);
    }

    public ArrayList<IntPair> posibles_moviments(Peca[] peces_blanques, Peca[] peces_negres) {
        //El peo es pot moure nomes una casella endavant, amb algunes excepcions
        //Excepcio 1: el primer moviment del peó, es pot moure 2 celes
        //Excepcio 2: el peo es pot moure una cela en diagonal si hi ha una peça del equip enemic (ataca)
        Tauler t = new Tauler(peces_blanques,peces_negres);
        this.moviments.clear();
        if (this.esBlanca()) {
            if (t.getPeca(this.getX(), this.getY() - 1) == null) {
                IntPair aux = new IntPair(this.getX(), this.getY() - 1);
                this.moviments.add(aux);
            }
            //mira si hi ha enemic a la diagonal esquerra-amunt
            if (t.getPeca(this.getX() - 1, this.getY() - 1) != null && t.getPeca(this.getX() - 1, this.getY() - 1).getColor() != this.getColor()) {
                IntPair aux = new IntPair(this.getX() - 1, this.getY() - 1);
                this.moviments.add(aux);
            }
            //mira si hi ha enemic a la diagonal dreta-amunt
            if (t.getPeca(this.getX() + 1, this.getY() - 1) != null && t.getPeca(this.getX() + 1, this.getY() - 1).getColor() != this.getColor()) {
                IntPair aux = new IntPair(this.getX() + 1, this.getY() - 1);
                this.moviments.add(aux);
            }
        }
        if (this.esNegra()) {
            if (t.getPeca(this.getX(), this.getY() + 1) == null) {
                IntPair aux = new IntPair(this.getX(), this.getY() + 1);
                this.moviments.add(aux);
            }
            //mira si hi ha enemic a la diagonal esquerra-avall
            if (t.getPeca(this.getX() - 1, this.getY() + 1) != null && t.getPeca(this.getX() - 1, this.getY() + 1).getColor() != this.getColor()) {
                IntPair aux = new IntPair(this.getX() - 1, this.getY() + 1);
                this.moviments.add(aux);
            }
            //mira si hi ha enemic a la diagonal dreta-avall
            if (t.getPeca(this.getX() + 1, this.getY() + 1) != null && t.getPeca(this.getX() + 1, this.getY() + 1).getColor() != this.getColor()) {
                IntPair aux = new IntPair(this.getX() + 1, this.getY() + 1);
                this.moviments.add(aux);
            }
        }
        return this.moviments;
    }
}
