package domini;

import java.util.*;

@SuppressWarnings("Duplicates")
public class Reina extends Peca {


    public Reina(int i, int x, int y, boolean color) {
        setId(i);
        setX(x);
        setY(y);
        setColor(color);
        setPunts(1000);
    }

    public ArrayList<IntPair> posibles_moviments(Peca[] peces_blanques, Peca[] peces_negres) {
        //la domini.Reina es pot moure en qualsevol de les direccions ilimitadament
        Tauler t = new Tauler(peces_blanques,peces_negres);
        this.moviments.clear();

        //comprovar posibles moviments en horitzontal
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
        while (tempy < 8) {
            if (t.getPeca(this.getX(), tempy) == null) {
                IntPair aux = new IntPair(this.getX(), tempy);
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
        tempy = this.getY() - 1; //movem amunt
        while (tempy >= 0) {
            if (t.getPeca(this.getX(), tempy) == null) {
                IntPair aux = new IntPair(this.getX(), tempy);
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
        tempx = this.getX() + 1; //moviment
        tempy = this.getY() - 1; //diagonal dreta-amunt
        while (tempx < 8 && tempy >= 0) {
            if (t.getPeca(tempx,tempy) == null) {
                IntPair aux = new IntPair(tempx,tempy);
                this.moviments.add(aux);
            }
            else if (t.getPeca(tempx,tempy).getColor() == this.getColor()) break;
            else {
                IntPair aux = new IntPair(tempx,tempy);
                this.moviments.add(aux);
                break;
            }
            tempx++;
            tempy--;
        }

        tempx = this.getX() - 1; //moviment
        tempy = this.getY() + 1; //diagonal esquerre-avall
        while (tempx >= 0 && tempy < 8) {
            if (t.getPeca(tempx,tempy) == null) {
                IntPair aux = new IntPair(tempx,tempy);
                this.moviments.add(aux);
            }
            else if (t.getPeca(tempx,tempy).getColor() == this.getColor()) break;
            else {
                IntPair aux = new IntPair(tempx,tempy);
                this.moviments.add(aux);
                break;
            }
            tempx--;
            tempy++;
        }

        tempx = this.getX() - 1; //moviment
        tempy = this.getY() - 1; //diagonal esquerra-amunt
        while (tempx >= 0 && tempy >= 0) {
            if (t.getPeca(tempx,tempy) == null) {
                IntPair aux = new IntPair(tempx,tempy);
                this.moviments.add(aux);
            }
            else if (t.getPeca(tempx,tempy).getColor() == this.getColor()) break;
            else {
                IntPair aux = new IntPair(tempx,tempy);
                this.moviments.add(aux);
                break;
            }
            tempx--;
            tempy--;
        }

        tempx = this.getX() + 1; //moviment
        tempy = this.getY() + 1; //diagonal dreta-avall
        while (tempx < 8 && tempy < 8) {
            if (t.getPeca(tempx,tempy) == null) {
                IntPair aux = new IntPair(tempx,tempy);
                this.moviments.add(aux);
            }
            else if (t.getPeca(tempx,tempy).getColor() == this.getColor()) break;
            else {
                IntPair aux = new IntPair(tempx,tempy);
                this.moviments.add(aux);
                break;
            }
            tempx++;
            tempy++;
        }

        return this.moviments;

    }
}
