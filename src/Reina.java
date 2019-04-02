import java.util.*;

public class Reina extends Peca {


    public Reina(int x, int y, boolean es_blanca) {
        super(x,y,es_blanca);
    }

    public boolean moviment_valid(Tauler t, int desti_x, int desti_y) {
        //La Reina es pot moure en qualsevol casella en diagonal, horitzontal i vertical

        //Si hi ha una peça aliada a la posició destí, no ens podem moure
        Peca peça_aux = t.getPeca(desti_x,desti_y);
        if (peça_aux != null) {
            if (peça_aux.esBlanca() && this.esBlanca()) return false;
            if (peça_aux.esNegra() && this.esNegra()) return false;
        }
         //+++

        return false;
    }


}
