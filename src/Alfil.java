import java.util.*;


public class Alfil extends Peca {


    public Alfil(String i, int x, int y, boolean color) {
        setId(i);
        setX(x);
        setY(y);
        setColor(color);
    }

    public ArrayList<IntPair> posibles_moviments(Tauler t) {
        //Un alfil es pot moure tantes cel·les com vulgui en les quatre digagonals.
        moviments.clear();
        int tempx = this.getX() + 1; //moviment
        int tempy = this.getY() - 1; //diagonal dreta-amunt
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
        tempy = this.getY() + 1; //diagonal dreta-avall
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
        tempx = this.getY() - 1; //diagonal esquerra-amunt
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
        tempx = this.getY() + 1; //diagonal esquerra-avall
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

//IGNORAR A PARTIR D'AQUI
/*
    //Si hi ha una peça aliada a la posició destí, no ens podem moure
    Peça p_aux = t.getPeça(desti_x, desti_y);

        if (p_aux != null) {
                if (p_aux.esBlanca() && this.esBlanca()) return false;
                if (p_aux.esNegra() && this.esNegra()) return false;
                }

                //No es pot moure ni adalt ni avall ni dreta no esuqerra
                if (this.getX() == desti_x || this.getY() == desti_y) return false;

//No pot saltar peces
*/