



public class Torre extends Peca {

    public Torre(int x, int y, boolean es_blanca) {
        super(x,y,es_blanca);
    }

    public boolean moviment_valid(Tauler t, int desti_x, int desti_y) {
        //Una torre es pot moure tantes cel·les com vulgui en direcció amunt, avall, dreta o esquerra

        //Si hi ha una peça aliada a la posició destí, no ens podem moure
        Peca p_aux = t.getPeça(desti_x,desti_y);
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
                Peca p = t.getPeça(this.getX(), this.getY() + i);
                if (p != null) return false;
            }
        }
        if (desti_y < this.getY()) { //torre es mou amunt
            int numero_moviments = Math.abs(desti_y - this.getY());
            for (int i = 0; i < numero_moviments; i++) {
                Peca p = t.getPeça(this.getX(), this.getY() - i);
                if (p != null) return false;
            }
        }
        if (desti_x > this.getX()) { //torre es mou dreta
            int numero_moviments = Math.abs(desti_x - this.getX());
            for (int i = 0; i < numero_moviments; i++) {
                Peca p = t.getPeça(this.getX() + i, this.getY());
                if (p != null) return false;
            }
        }
        if (desti_x < this.getX()) { //torre es mou esquerra
            int numero_moviments = Math.abs(desti_x - this.getX());
            for (int i = 0; i < numero_moviments; i++) {
                Peca p = t.getPeça(this.getX() - i, this.getY());
                if (p != null) return false;
            }
        }

        return true;
    }
}
