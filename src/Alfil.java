


public class Alfil extends Peça {


    public Alfil(int x, int y, boolean es_blanca) {
        super(x,y,es_blanca);
    }

    @Override
    public boolean moviment_valid(Tauler t, int desti_x, int desti_y) {
        //Un alfil es pot moure tantes cel·les com vulgui en les quatre digagonals.

        //Si hi ha una peça aliada a la posició destí, no ens podem moure
        Peça p_aux = t.getPeça(desti_x, desti_y);

        if (p_aux != null) {
            if (p_aux.esBlanca() && this.esBlanca()) return false;
            if (p_aux.esNegra() && this.esNegra()) return false;
        }

        //No es pot moure ni adalt ni avall ni dreta no esuqerra
        if (this.getX() == desti_x || this.getY() == desti_y) return false;

        //No pot saltar peces

    }
}

