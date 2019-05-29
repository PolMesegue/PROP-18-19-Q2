package domini;


public abstract class Usuari {

    private String nom;

    Usuari(String nom){
        this.nom=nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Jugada play(Peca[] peces_blanques, Peca[] peces_negres, int n,int i){
        return null;
    }

    public boolean te_solucio(Peca[] peces_blanques, Peca[] peces_negres, int n) {
        return false;
    }
}
