import java.util.*;

@SuppressWarnings("Duplicates")
public class Cavall extends Peca{


    public Cavall(int i, int x, int y, boolean color) {
        setId(i);
        setX(x);
        setY(y);
        setColor(color);
        //setValue(350);
    }

    public ArrayList<IntPair> posibles_moviments(Peca[] peces_blanques, Peca[] peces_negres) {
        //en qualsevol punt del cavall, hi ha maxim 8 punts on es pot moure
        Tauler t = new Tauler(peces_blanques,peces_negres);
        this.moviments.clear();
        int posx[] = {this.getX() - 2, this.getX() - 1 , this.getX() + 1, this.getX() + 2, this.getX() - 2 , this.getX() - 1, this.getX() + 1, this.getX() - 2};
        int posy[] = {this.getY() - 1, this.getY() - 2, this.getY() - 2, this.getY() - 1, this.getY() + 1, this.getY() + 2, this.getY() + 2, this.getY() + 1};
        for (int i = 0; i < 8; ++i) {
            if (posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8) {
                if (t.getPeca(posx[i],posy[i]) == null || t.getPeca(posx[i],posy[i]).getColor() != this.getColor()) {
                    IntPair aux = new IntPair(posx[i],posy[i]);
                    this.moviments.add(aux);
                }
            }
        }
        return this.moviments;
    }
}

