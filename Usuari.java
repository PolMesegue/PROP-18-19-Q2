
import java.util.*;


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
}
